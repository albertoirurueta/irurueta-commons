/*
 * Copyright (C) 2016 Alberto Irurueta Carro (alberto@irurueta.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.irurueta.commons;

import com.irurueta.commons.validators.CreditCardNetwork;
import com.irurueta.commons.validators.CreditCardValidator;

/**
 * Generates a masked PAN where only the last 4 digits are displayed and the 
 * remaining ones are masked using digit groupings according to the 
 * corresponding credit card network.
 * Notice that this class displays a maximum of 4 digits to remain PCI DSS no 
 * matter how many visible digits are requested.
 * If less than request digits are available in provided PAN, then only 
 * available digits are displayed as the last digits of masked PAN.
 */
@SuppressWarnings("WeakerAccess")
public class MaskedPanFormatter {
    
    /**
     * Default character to use as a masked digit on a credit card PAN.
     */
    public static final char DEFAULT_MASK_CHAR = '*';
    
    /**
     * Default character to use as a group separator.
     */
    public static final char DEFAULT_SEPARATOR_CHAR = ' ';
    
    /**
     * Default number of visible digits to be PCI DSS compliant.
     */
    public static final int NUM_VISIBLE_DIGITS = 4;
    
    /**
     * Constructor.
     */
    private MaskedPanFormatter() { }
    
    /**
     * Formats a credit card PAN (or its last digits) by making visible only the
     * last digits and masking the remaining ones following the digits grouping
     * required for provided credit card network.
     * @param panOrLastDigits credit card number (or its last digits) to be 
     * masked.
     * @param network credit card network.
     * @param maskChar mask character to be used.
     * @param separatorChar group separator character to be used.
     * @return masked PAN.
     */
    public static String format(String panOrLastDigits, 
            CreditCardNetwork network, char maskChar, char separatorChar) {
        return format(toDigits(panOrLastDigits), network, maskChar, 
                separatorChar, NUM_VISIBLE_DIGITS);
    }
    
    /**
     * Formats a credit card PAN (or its last digits) by making visible only the
     * last digits and masking the remaining ones following the digits grouping
     * required for provided credit card network.
     * This method uses the space as a group separator.
     * @param panOrLastDigits credit card number (or its last digits) to be
     * masked.
     * @param network credit card network.
     * @param maskChar mask character to be used.
     * @return masked PAN.
     */
    public static String format(String panOrLastDigits, 
            CreditCardNetwork network, char maskChar) {
        return format(panOrLastDigits, network, maskChar, 
                DEFAULT_SEPARATOR_CHAR);
    }
    
    /**
     * Formats a credit card PAN (or its last digits) by making visible only the
     * last digits and masking the remaining ones following the digits grouping
     * required for provided credit card network.
     * This method uses the space as a group separator and the star character
     * as a masked digit.
     * @param panOrLastDigits credit card number (or its last digits) to be
     * masked.
     * @param network credit card network.
     * @return masked PAN.
     */
    public static String format(String panOrLastDigits, 
            CreditCardNetwork network) {
        return format(panOrLastDigits, network, DEFAULT_MASK_CHAR);
    }
    
    /**
     * Formats a full credit card PAN by making visible only the last digits and
     * masking the remaining ones following the digits grouping required for
     * the detected credit card network.
     * This method needs a full credit card PAN to detect the credit card 
     * network using the former digits, and making visible the latter ones.
     * If a credit card network cannot be determined, default grouping is used
     * instead.
     * @param pan a full credit card number.
     * @param maskChar mask character to be used.
     * @param separatorChar group separator character to be used.
     * @return masked PAN.
     */
    public static String format(String pan, char maskChar, char separatorChar) {
        return format(pan, CreditCardValidator.detectNetworkFromPAN(pan), 
                maskChar, separatorChar);
    }
    
    /**
     * Formats a full credit card PAN by making visible only the last digits and
     * masking the remaining ones following the digits grouping required for
     * the detected credit card network.
     * This method needs a full credit card PAN to detect the credit card
     * network using the former digits, and making visible the latter ones.
     * If a credit card network cannot be determined, default grouping is used
     * instead.
     * This method uses the space as a group separator.
     * @param pan a full credit card number.
     * @param maskChar mask character to be used.
     * @return masked PAN.
     */
    public static String format(String pan, char maskChar) {
        return format(pan, maskChar, DEFAULT_SEPARATOR_CHAR);
    }
    
    /**
     * Formats a full credit card PAN by making visible only the last digits and
     * masking the remaining ones following the digits grouping required for
     * the detected credit card network.
     * This method needs a full credit card PAN to detect the credit card
     * network using the former digits, and making visible the latter ones.
     * If a credit card network cannot be determined, default grouping is used
     * instead.
     * This method uses the space as a group separator and the star character
     * as a masked digit.
     * @param pan a full credit card number.
     * @return masked PAN.
     */
    public static String format(String pan) {
        return format(pan, DEFAULT_MASK_CHAR);
    }
    
    /**
     * Formats a credit card PAN (or its last digits) by making visible only the
     * last digits and masking the remaining ones following the digits grouping
     * required for provided credit card network.
     * @param digits array containing the full credit card number (or its last
     * digits) to be masked.
     * @param network credit card network.
     * @param maskChar mask character to be used.
     * @param separatorChar group separator character to be used.
     * @param numVisibleDigits number of visible digits. The number of visible
     * digits must not exceed 4 to remain PCI DSS compliant. Only the last group
     * of digits will be shown unmasked if this value exceed the length of such
     * group.
     * @return masked PAN.
     */
    private static String format(byte[] digits, CreditCardNetwork network, 
            char maskChar, char separatorChar, int numVisibleDigits) {
        String mask = PanMaskGenerator.generate(network, maskChar, 
                separatorChar);

        //limit the number of visible digits to provided value, limited to
        //the length of last group of digits
        int numGroups = CreditCardValidator.getNumberOfGroupsForNetwork(
                network);
        int lastGroupLength = CreditCardValidator.
                getMaxDigitsForGroupAndNetwork(numGroups - 1, network);

        numVisibleDigits = Math.min(numVisibleDigits, lastGroupLength);
        int startPos = Math.max(0, digits.length - numVisibleDigits);
        int visibleDigits = digits.length - startPos;
        int endMaskPosition = mask.length() - visibleDigits;

        mask = mask.substring(0, endMaskPosition);
        StringBuilder builder = new StringBuilder(mask);
        for (int i = startPos; i < digits.length; i++) {
            builder.append(digits[i]);
        }

        return builder.toString();        
    }
    
    /**
     * Converts a PAN into an array of digits. Any non digit character is 
     * ignored.
     * @param pan PAN to be converted to digits.
     * @return array containing digits within provided PAN.
     */
    private static byte[] toDigits(String pan) {
        return CreditCardValidator.toDigits(pan);
    }
}
