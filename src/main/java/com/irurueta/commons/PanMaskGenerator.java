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
 * Class to generate masks for PAN (Personal Account Numbers) of credit cards.
 * Masks can be used on text fields to determine how users can input text, and
 * masks can also be used to display credit card PAN's on the screen being
 * PCI DSS compliant by showing only the last 4 digits of the PAN.
 */
public class PanMaskGenerator {

    /**
     * Default character to be used to generate masks.
     */
    public static final char DEFAULT_MASK_CHAR = '#';

    /**
     * Default character to use to separate groups of digits.
     */
    public static final char DEFAULT_GROUP_SEPARATOR = ' ';

    /**
     * Constructor.
     */
    private PanMaskGenerator() {
    }

    /**
     * Generates a mask having required grouping for text input or PAN masking a
     * credit card number.
     *
     * @param network       a credit card network to determine grouping format.
     * @param maskChar      mask character to use.
     * @param separatorChar group separator character to use.
     * @return generated mask.
     */
    public static String generate(final CreditCardNetwork network, final char maskChar,
                                  final char separatorChar) {
        final int numGroups = CreditCardValidator.getNumberOfGroupsForNetwork(
                network);
        final int lastGroupPos = numGroups - 1;
        int groupLength;

        // generate mask
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numGroups; i++) {
            groupLength = CreditCardValidator.getMaxDigitsForGroupAndNetwork(i,
                    network);

            repeatMaskChar(builder, maskChar, groupLength);
            if (i != lastGroupPos) {
                // add separator between groups
                builder.append(separatorChar);
            }
        }

        return builder.toString();
    }

    /**
     * Generates a mask having required grouping for text input or PAN masking a
     * credit card number using default group separator character.
     *
     * @param network  a credit card network to determine grouping format.
     * @param maskChar mask character to use.
     * @return generated mask.
     */
    public static String generate(final CreditCardNetwork network, final char maskChar) {
        return generate(network, maskChar, DEFAULT_GROUP_SEPARATOR);
    }

    /**
     * Generates a mask having required grouping for text input or PAN masking a
     * credit card number using default group separator and mask characters.
     *
     * @param network a credit card network to determine grouping format.
     * @return generated mask.
     */
    public static String generate(final CreditCardNetwork network) {
        return generate(network, DEFAULT_MASK_CHAR);
    }

    /**
     * Repeats a mask character the number of provided times and appends it to
     * provided builder.
     *
     * @param builder  builder where text is added.
     * @param maskChar mask character to use.
     * @param times    number of times to repeat mask character.
     */
    private static void repeatMaskChar(final StringBuilder builder, final char maskChar,
                                       final int times) {
        for (int i = 0; i < times; i++) {
            builder.append(maskChar);
        }
    }
}
