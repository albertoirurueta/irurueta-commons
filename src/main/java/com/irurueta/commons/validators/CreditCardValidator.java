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
package com.irurueta.commons.validators;

import java.util.Arrays;

/**
 * Class to validate credit card PAN numbers.
 * PAN numbers are formed by IIN (Issuer Identification Number) followed by a 
 * series of digits + the check digit (using Luhn algorithm), if available for 
 * a given credit card network. Notice that the first digit of the IIN corresponds
 * to a MII (Major Industry Identifier).
 * This class also provides functionality to detect network of a given credit
 * card PAN number.
 * Notice that network detection and validation is not 100% accurate, hence it 
 * is suggested to never prevent users from completing payments if validation 
 * does not pass or network cannot be detected. In those cases simply a warning 
 * can be shown to the user indicating that payment data might be wrong.
 * Notice as well that if network is detected and validation passes, then it is
 * almost certain that payment data is correct.
 */
@SuppressWarnings("WeakerAccess")
public class CreditCardValidator {
    /**
     * Minimum allowed length for a credit card PAN.
     */
    @SuppressWarnings("unused")
    public static final int MIN_LENGTH = 8;
    
    /**
     * Maximum allowed length for a credit card PAN.
     */
    @SuppressWarnings("unused")
    public static final int MAX_LENGTH = 19;

    /**
     * Constant indicating whether American Express uses Luhn validation to
     * ensure that PAN is valid.
     */
    protected static final boolean AMEX_HAS_VALIDATION = true;

    /**
     * Constant indicating whether American Express network is still being used.
     */
    protected static final boolean AMEX_IS_ACTIVE = true;

    /**
     * Constant indicating whether Bankcard uses Luhn validation to ensure that
     * PAN is valid.
     */
    protected static final boolean BANKCARD_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Bankcard network is still being used.
     */
    protected static final boolean BANKCARD_IS_ACTIVE = false;

    /**
     * Constant indicating whether China UnionPay uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean CHINA_UNIONPAY_HAS_VALIDATION = false;

    /**
     * Constant indicating whether China UnionPay network is still being used.
     */
    protected static final boolean CHINA_UNIONPAY_IS_ACTIVE = true;

    /**
     * Constant indicating whether Diners Club Carte Blanche uses Luhn
     * validation to ensure that PAN is valid.
     */
    protected static final boolean DINERS_CLUB_CARTE_BLANCHE_HAS_VALIDATION =
            true;

    /**
     * Constant indicating whether Diners Club Carte Blanche network is still
     * being used.
     */
    protected static final boolean DINERS_CLUB_CARTE_BLANCHE_IS_ACTIVE = true;

    /**
     * Constant indicating whether Diners Club enRoute uses Luhn validation to
     * ensure that PAN is valid.
     */
    protected static final boolean DINERS_CLUB_ENROUTE_HAS_VALIDATION = false;

    /**
     * Constant indicating whether Diners Club enRoute network is still being
     * used.
     */
    protected static final boolean DINERS_CLUB_ENROUTE_IS_ACTIVE = false;

    /**
     * Constant indicating whether Diners Club International uses Luhn
     * validation to ensure that PAN is valid.
     */
    protected static final boolean DINERS_CLUB_INTERATIONAL_HAS_VALIDATION =
            true;

    /**
     * Constant indicating whether Diners Club International network is still
     * being used.
     */
    protected static final boolean DINERS_CLUB_INTERATIONAL_IS_ACTIVE = true;

    /**
     * Constant indicating whether Diners Club USA and Canada uses Luhn
     * validation to ensure that PAN is valid.
     */
    protected static final boolean DINERS_CLUB_USA_CA_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Diners Club USA and Canada network is still
     * being used.
     */
    protected static final boolean DINERS_CLUB_USA_CA_IS_ACTIVE = true;

    /**
     * Constant indicating whether Discover uses Luhn validation to ensure that
     * PAN is valid.
     */
    protected static final boolean DISCOVER_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Discover network is still being used.
     */
    protected static final boolean DISCOVER_IS_ACTIVE = true;

    /**
     * Constant indicating whether InstaPayment uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean INSTAPAYMENT_HAS_VALIDATION = true;

    /**
     * Constant indicating whether InstaPayment network is still being used.
     */
    protected static final boolean INSTAPAYMENT_IS_ACTIVE = true;

    /**
     * Constant indicating whether JCB uses Luhn validation to ensure that PAN
     * is valid.
     */
    protected static final boolean JCB_HAS_VALIDATION = true;

    /**
     * Constant indicating whether JCB network is still being used.
     */
    protected static final boolean JCB_IS_ACTIVE = true;

    /**
     * Constant indicating whether Laser uses Luhn validation to ensure that PAN
     * is valid.
     */
    protected static final boolean LASER_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Laser network is still being used.
     */
    protected static final boolean LASER_IS_ACTIVE = true;

    /**
     * Constant indicating whether Maestro uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean MAESTRO_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Maestro network is still being used.
     */
    protected static final boolean MAESTRO_IS_ACTIVE = true;

    /**
     * Constant indicating whether MasterCard uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean MASTERCARD_HAS_VALIDATION = true;

    /**
     * Constant indicating whether MasterCard network is still being used.
     */
    protected static final boolean MASTERCARD_IS_ACTIVE = true;

    /**
     * Constant indicating whether Solo uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean SOLO_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Solo network is still being used.
     */
    protected static final boolean SOLO_IS_ACTIVE = false;

    /**
     * Constant indicating whether Switch uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean SWITCH_HAS_VALIDATION = true;

    /**
     * Constant indicating whether Switch network is still being used.
     */
    protected static final boolean SWITCH_IS_ACTIVE = false;

    /**
     * Constant indicating whether VISA uses Luhn validation to ensure
     * that PAN is valid.
     */
    protected static final boolean VISA_HAS_VALIDATION = true;

    /**
     * Constant indicating whether VISA network is still being used.
     */
    protected static final boolean VISA_IS_ACTIVE = true;

    /**
     * Constant indicating whether VISA Electron uses Luhn validation to
     * ensure that PAN is valid.
     */
    protected static final boolean VISA_ELECTRON_HAS_VALIDATION = true;

    /**
     * Constant indicating whether VISA Electron network is still being used.
     */
    protected static final boolean VISA_ELECTRON_IS_ACTIVE = true;

    /**
     * Constant containing IIN ranges reserved for American Express.
     */
    private static final String[][] AMEX_IIN = new String[][] {
            new String[] {"34", "34"},
            new String[] {"37", "37"}
    };
    
    /**
     * Constant containing valid lengths for American Express.
     */
    private static final byte[][] AMEX_LENGTH = new byte[][] {
            new byte[] {15, 15}
    };

    /**
     * Constant defining digit groups for American Express.
     */
    private static final byte[][] AMEX_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {6, 6},
            new byte[] {5, 5}
    };

    /**
     * Constant containing IIN ranges reserved for Bankcard.
     */
    private static final String[][] BANKCARD_IIN = new String[][] {
            new String[] {"5610", "5610"},
            new String[] {"560221", "560225"}
    };
    
    /**
     * Constant containing valid lengths for Bankcard.
     */
    private static final byte[][] BANKCARD_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant containing IIN ranges reserved for China UnionPay.
     */
    private static final String[][] CHINA_UNIONPAY_IIN = new String[][] {
            new String[] {"62", "62"}
    };
    
    /**
     * Constant containing valid lengths for China UnionPay.
     */
    private static final byte[][] CHINA_UNIONPAY_LENGTH = new byte[][] {
            new byte[] {16, 19}
    };

    /**
     * Constant containing IIN ranges reserved for Diners Club Carte Blanche.
     */
    private static final String[][] DINERS_CLUB_CARTE_BLANCHE_IIN = new String[][] {
            new String[] {"300", "305"}
    };
    
    /**
     * Constant containing valid lengths for Diners Club Carte Blanche.
     */
    private static final byte[][] DINERS_CLUB_CARTE_BLANCHE_LENGTH = new byte[][] {
            new byte[] {14, 14}
    };

    /**
     * Constant containing IIN ranges reserved for Diners Club enRoute.
     */
    private static final String[][] DINERS_CLUB_ENROUTE_IIN = new String[][] {
            new String[] {"2014", "2014"},
            new String[] {"2149", "2149"}
    };
    
    /**
     * Constant containing valid lengths for Diners Club enRoute.
     */
    private static final byte[][] DINERS_CLUB_ENROUTE_LENGTH = new byte[][] {
            new byte[] {15, 15}
    };

    /**
     * Constant defining digit groups for Dinners club enroute.
     */
    private static final byte[][] DINERS_CLUB_ENROUTE_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {7, 7},
            new byte[] {4, 4}
    };

    /**
     * Constant containing IIN ranges reserved for Diners Club International.
     */
    private static final String[][] DINERS_CLUB_INTERNATIONAL_IIN = new String[][] {
            new String[] {"36", "36"}
    };
    
    /**
     * Constant containing valid lengths for Diners Club International.
     */
    private static final byte[][] DINERS_CLUB_INTERNATIONAL_LENGTH = new byte[][] {
            new byte[] {14, 14}
    };

    /**
     * Constant defining digit groups for Dinners club internacional. This
     * grouping is also used for DINERS_CLUB_CARTE_BLANCHE.
     */
    private static final byte[][] DINERS_CLUB_INTERATIONAL_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {6, 6},
            new byte[] {4, 4} };

    /**
     * Constant containing IIN ranges reserved for Diners Club USA and Canada.
     */
    private static final String[][] DINERS_CLUB_USA_CA_IIN = new String[][] {
            new String[] {"54", "55"}
    };
    
    /**
     * Constant containing valid lengths for Diners Club USA and Canada.
     */
    private static final byte[][] DINERS_CLUB_USA_CA_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant containing IIN ranges reserved for Discover.
     */
    private static final String[][] DISCOVER_IIN = new String[][] {
            new String[] {"6011", "6011"},
            new String[] {"622126", "62295"},
            new String[] {"644", "649"},
            new String[] {"65", "65"}
    };
    
    /**
     * Constant containing valid lengths for Discover.
     */
    private static final byte[][] DISCOVER_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant defining digit groups for Discover. This grouping is also used
     * for all Diners Club cards.
     */
    private static final byte[][] DISCOVER_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4}
    };
    
    /**
     * Constant containing IIN ranges reserved for InstaPayment.
     */
    private static final String[][] INSTAPAYMENT_IIN = new String[][] {
            new String[] {"637", "639"}
    };
    
    /**
     * Constant containing valid lengths for InstaPayment.
     */
    private static final byte[][] INSTAPAYMENT_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant containing IIN ranges reserved for JCB.
     */
    private static final String[][] JCB_IIN = new String[][] {
            new String[] {"3528", "3589"}
    };
    
    /**
     * Constant containing valid lengths for JCB.
     */
    private static final byte[][] JCB_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant containing IIN ranges reserved for Laser.
     */
    private static final String[][] LASER_IIN = new String[][] {
            new String[] {"6304", "6304"},
            new String[] {"6706", "6706"},
            new String[] {"6771", "6771"},
            new String[] {"6709", "6709"}
    };
    
    /**
     * Constant containing valid lengths for Laser.
     */
    private static final byte[][] LASER_LENGTH = new byte[][] {
            new byte[] {16, 19}
    };

    /**
     * Constant containing IIN ranges reserved for Maestro.
     */
    private static final String[][] MAESTRO_IIN = new String[][] {
            new String[] {"5018", "5018"},
            new String[] {"5020", "5020"},
            new String[] {"5038", "5038"},
            new String[] {"5893", "5893"},
            new String[] {"6304", "6304"},
            new String[] {"6759", "6759"},
            new String[] {"6761", "6763"},
            new String[] {"0604", "0604"}
    };
    
    /**
     * Constant containing valid lengths for Maestro.
     */    
    private static final byte[][] MAESTRO_LENGTH = new byte[][] {
            new byte[] {12, 19}
    };

    /**
     * Constant containing IIN ranges reserved for MasterCard.
     */
    private static final String[][] MASTERCARD_IIN = new String[][] {
        new String[] {"222100", "272099"},
        new String[] {"51", "55"}
    };
    
    /**
     * Constant containing valid lengths for MasterCard.
     */        
    private static final byte[][] MASTERCARD_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant defining digit groups for Mastercard.
     */
    private static final byte[][] MASTERCARD_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4}
    };

    /**
     * Constant containing IIN ranges reserved for Solo.
     */    
    private static final String[][] SOLO_IIN = new String[][] {
            new String[] {"6334", "6334"},
            new String[] {"6767", "6767"}
    };
    
    /**
     * Constant containing valid lengths for Solo.
     */            
    private static final byte[][] SOLO_LENGTH = new byte[][] {
            new byte[] {16, 16},
            new byte[] {18, 19}
    };

    /**
     * Constant containing IIN ranges reserved for Switch.
     */        
    private static final String[][] SWITCH_IIN = new String[][] {
            new String[] {"4903", "4903"},
            new String[] {"4905", "4905"},
            new String[] {"4911", "4911"},
            new String[] {"4936", "4936"},
            new String[] {"564182", "564182"},
            new String[] {"633110", "633110"},
            new String[] {"6333", "6333"},
            new String[] {"6759", "6759"}
    };
    
    /**
     * Constant containing valid lengths for Switch.
     */                
    private static final byte[][] SWITCH_LENGTH = new byte[][] {
            new byte[] {16, 16},
            new byte[] {18, 19}
    };

    /**
     * Constant containing IIN ranges reserved for VISA.
     */            
    private static final String[][] VISA_IIN = new String[][] {
            new String[] {"4", "4"}
    };
    
    /**
     * Constant containing valid lengths for VISA.
     */                    
    private static final byte[][] VISA_LENGTH = new byte[][] {
            new byte[] {13, 13},
            new byte[] {16, 16}
    };

    /**
     * Constant defining digit groups for VISA.
     */
    private static final byte[][] VISA_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {1, 4}
    };

    /**
     * Constant containing IIN ranges reserved for VISA Electron.
     */                
    private static final String[][] VISA_ELECTRON_IIN = new String[][] {
            new String[] {"4026", "4026"},
            new String[] {"417500", "417500"},
            new String[] {"4405", "4405"},
            new String[] {"4508", "4508"},
            new String[] {"4844", "4844"},
            new String[] {"4913", "4913"},
            new String[] {"4917", "4917"}
    };
    
    /**
     * Constant containing valid lengths for VISA Electron.
     */                        
    private static final byte[][] VISA_ELECTRON_LENGTH = new byte[][] {
            new byte[] {16, 16}
    };

    /**
     * Constant defining digit groups for VISA Electron.
     */
    private static final byte[][] VISA_ELECTRON_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4}
    };

    /**
     * Constant defining digit groups for any other network or unknown networks.
     */
    private static final byte[][] DEFAULT_GROUPING = new byte[][] {
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {4, 4},
            new byte[] {0, 7}
    };

    /**
     * Constructor.
     */
    protected CreditCardValidator() { }
    
    /**
     * Indicates if provided credit card PAN value corresponds to any valid MII
     * (Major Industry Identifier). All valid credit card PANs must start by
     * 3, 4, 5 or 6, which correspond to all the assigned MII.
     * @param pan a credit card PAN value.
     * @return true if PAN corresponds to a valid MII, false otherwise.
     */
    public static boolean isValidMII(String pan) {
        return isValidMII(toDigits(pan));
    }
    
    /**
     * Indicates if provided array of credit card PAN digits corresponds to any
     * valid MII (Major Industry Identifier). All valid credit card PANs must 
     * start by 3, 4, 5 or 6, which correspond to all the assigned MII.
     * @param panDigits an array of credit card PAN digits.
     * @return true if PAN corresponds to a valid MII, false otherwise.
     */
    protected static boolean isValidMII(byte[] panDigits) {
        if (panDigits == null || panDigits.length == 0) {
            return false;
        }
        byte first = panDigits[0];
        
        return first == 3 || first == 4 || first == 5 || first == 6;        
    }
    
    /**
     * Indicates if a given credit card network uses Luhn algorithm to validate 
     * PAN values. For unknown networks validation is assumed to be disabled.
     * @param network a credit card network.
     * @return true if provided network uses PAN validation, false otherwise.
     */
    public static boolean isValidationEnabledForNetwork(CreditCardNetwork network) {
        if (network == null) {
            return false;
        }
        
        switch (network) {
            case AMERICAN_EXPRESS:
                return AMEX_HAS_VALIDATION;
            case BANKCARD:
                return BANKCARD_HAS_VALIDATION;
            case CHINA_UNIONPAY:
                return CHINA_UNIONPAY_HAS_VALIDATION;
            case DINERS_CLUB_CARTE_BLANCHE:
                return DINERS_CLUB_CARTE_BLANCHE_HAS_VALIDATION;
            case DINERS_CLUB_ENROUTE:
                return DINERS_CLUB_ENROUTE_HAS_VALIDATION;
            case DINERS_CLUB_INTERNATIONAL:
                return DINERS_CLUB_INTERATIONAL_HAS_VALIDATION;
            case DINERS_CLUB_USA_CANADA:
                return DINERS_CLUB_USA_CA_HAS_VALIDATION;
            case DISCOVER:
                return DISCOVER_HAS_VALIDATION;
            case INSTAPAYMENT:
                return INSTAPAYMENT_HAS_VALIDATION;
            case JCB:
                return JCB_HAS_VALIDATION;
            case LASER:
                return LASER_HAS_VALIDATION;
            case MAESTRO:
                return MAESTRO_HAS_VALIDATION;
            case MASTERCARD:
                return MASTERCARD_HAS_VALIDATION;
            case SOLO:
                return SOLO_HAS_VALIDATION;
            case SWITCH:
                return SWITCH_HAS_VALIDATION;
            case VISA:
                return VISA_HAS_VALIDATION;
            case VISA_ELECTRON:
                return VISA_ELECTRON_HAS_VALIDATION;
            case UNKNOWN:
            default:
                return false;
        }
    }
    
    /**
     * Indicates if provided credit card network is still being used 
     * commercially.
     * Unknown networks are assumed to be active.
     * @param network a credit card network.
     * @return true if provided network is still being used, false otherwise.
     */
    public static boolean isNetworkActive(CreditCardNetwork network) {
        if (network == null) {
            return true;
        }
        
        switch (network) {
            case AMERICAN_EXPRESS:
                return AMEX_IS_ACTIVE;
            case BANKCARD:
                return BANKCARD_IS_ACTIVE;
            case CHINA_UNIONPAY:
                return CHINA_UNIONPAY_IS_ACTIVE;
            case DINERS_CLUB_CARTE_BLANCHE:
                return DINERS_CLUB_CARTE_BLANCHE_IS_ACTIVE;
            case DINERS_CLUB_ENROUTE:
                return DINERS_CLUB_ENROUTE_IS_ACTIVE;
            case DINERS_CLUB_INTERNATIONAL:
                return DINERS_CLUB_INTERATIONAL_IS_ACTIVE;
            case DINERS_CLUB_USA_CANADA:
                return DINERS_CLUB_USA_CA_IS_ACTIVE;
            case DISCOVER:
                return DISCOVER_IS_ACTIVE;
            case INSTAPAYMENT:
                return INSTAPAYMENT_IS_ACTIVE;
            case JCB:
                return JCB_IS_ACTIVE;
            case LASER:
                return LASER_IS_ACTIVE;
            case MAESTRO:
                return MAESTRO_IS_ACTIVE;
            case MASTERCARD:
                return MASTERCARD_IS_ACTIVE;
            case SOLO:
                return SOLO_IS_ACTIVE;
            case SWITCH:
                return SWITCH_IS_ACTIVE;
            case VISA:
                return VISA_IS_ACTIVE;
            case VISA_ELECTRON:
                return VISA_ELECTRON_IS_ACTIVE;
            case UNKNOWN:
            default:
                return true;
        }        
    }
    
    /**
     * Detects credit card network by using provided credit card PAN value.
     * Detection is done by checking all known registered credit card IINs 
     * (Issuer Identification Number) against provided PAN until a match is 
     * found.
     * @param pan a credit card PAN number.
     * @return detected credit card network.
     */
    public static CreditCardNetwork detectNetworkFromPAN(String pan) {
        return detectNetworkFromPAN(toDigits(pan));
    }
    
    /**
     * Detects credit card network by using provided credit card PAN digits.
     * Detection is done by checking all known registered credit card IINs
     * (Issuer Identification Number) agains provided PAN digits until a match
     * is found.
     * @param panDigits an array containing a credit card PAN digits.
     * @return detected credit card network.
     */
    protected static CreditCardNetwork detectNetworkFromPAN(byte[] panDigits) {
        if (isAmericanExpressIIN(panDigits)) {
            return CreditCardNetwork.AMERICAN_EXPRESS;
        }
        if (isBankcardIIN(panDigits)) {
            return CreditCardNetwork.BANKCARD;
        }
        if (isDinersClubCarteBlancheIIN(panDigits)) {
            return CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE;
        }
        if (isDinersClubEnrouteIIN(panDigits)) {
            return CreditCardNetwork.DINERS_CLUB_ENROUTE;
        }
        if (isDinersClubInternationalIIN(panDigits)) {
            return CreditCardNetwork.DINERS_CLUB_INTERNATIONAL;
        }
        if (isDinersClubUSACanadaIIN(panDigits)) {
            return CreditCardNetwork.DINERS_CLUB_USA_CANADA;
        }
        if (isDiscoverIIN(panDigits)) {
            return CreditCardNetwork.DISCOVER;
            //Discover lies within China UnionPay range, so we check it first
        }
        if (isChinaUnionPayIIN(panDigits)) {
            return CreditCardNetwork.CHINA_UNIONPAY;        
        }
        if (isInstaPaymentIIN(panDigits)) {
            return CreditCardNetwork.INSTAPAYMENT;
        }
        if (isJCBIIN(panDigits)) {
            return CreditCardNetwork.JCB;
        }
        if (isLaserIIN(panDigits)) {
            return CreditCardNetwork.LASER;
        }
        if (isMaestroIIN(panDigits)) {
            return CreditCardNetwork.MAESTRO;
        }
        if (isMastercardIIN(panDigits)) {
            return CreditCardNetwork.MASTERCARD;
        }
        if (isSoloIIN(panDigits)) {
            return CreditCardNetwork.SOLO;
        }
        if (isSwitchIIN(panDigits)) {
            return CreditCardNetwork.SWITCH;
            //VISA Electron is contained within VISA IIN, so we check it first
        }
        if (isVISAElectronIIN(panDigits)) {
            return CreditCardNetwork.VISA_ELECTRON; 
        }
        if (isVISAIIN(panDigits)) {
            return CreditCardNetwork.VISA;
        }
        return CreditCardNetwork.UNKNOWN;
    }
    
    /**
     * Detects network for provided PAN and indicates if provided credit card
     * PAN has an appropriate length for provided credit card network.
     * @param pan a credit card network.
     * @return true if PAN has a valid length, false otherwise.
     */
    public static boolean isValidLength(String pan) {
        return isValidLength(toDigits(pan));
    }
    
    /**
     * Detects network for provided PAN digits and indicates if provided array
     * of credit card PAN digits has an appropriate length for provided credit 
     * card network.
     * PAN for unknown network is assumed to always have a valid length.
     * @param panDigits an array of credit card PAN digits.
     * @return true if PAN has a valid length, false otherwise.
     */
    protected static boolean isValidLength(byte[] panDigits) {
        return isValidLength(panDigits, detectNetworkFromPAN(panDigits));
    }
    
    /**
     * Indicates if provided credit card PAN has an appropriate length for
     * provided credit card network.
     * PAN for unknown network is assumed to always have a valid length.
     * @param pan a credit card PAN.
     * @param network a credit card network.
     * @return true if PAN has a valid length, false otherwise.
     */
    public static boolean isValidLength(String pan, CreditCardNetwork network) {
        return isValidLength(toDigits(pan), network);
    }
    
    /**
     * Indicates if provided array of credit card PAN digits has an appropriate
     * length for provided credit card network.
     * PAN for unknown networks is assumed to always have a valid length.
     * @param panDigits an array of credit card PAN digits.
     * @param network a credit card network.
     * @return true if PAN has a valid length, false otherwise.
     */
    protected static boolean isValidLength(byte[] panDigits, 
            CreditCardNetwork network) {
        if (network == null) {
            return true;
        }

        switch (network) {
            case AMERICAN_EXPRESS:
                return isAmericanExpressValidLength(panDigits);
            case BANKCARD:
                return isBankcardValidLength(panDigits);
            case CHINA_UNIONPAY:
                return isChinaUnionPayValidLength(panDigits);
            case DINERS_CLUB_CARTE_BLANCHE:
                return isDinersClubCarteBlancheValidLength(panDigits);
            case DINERS_CLUB_ENROUTE:
                return isDinersClubEnrouteValidLength(panDigits);
            case DINERS_CLUB_INTERNATIONAL:
                return isDinersClubInternationalValidLength(panDigits);
            case DINERS_CLUB_USA_CANADA:
                return isDinersClubUSACanadaValidLength(panDigits);
            case DISCOVER:
                return isDiscoverValidLength(panDigits);
            case INSTAPAYMENT:
                return isInstaPaymentValidLength(panDigits);
            case JCB:
                return isJCBValidLength(panDigits);
            case LASER:
                return isLaserValidLength(panDigits);
            case MAESTRO:
                return isMaestroValidLength(panDigits);
            case MASTERCARD:
                return isMastercardValidLength(panDigits);
            case SOLO:
                return isSoloValidLength(panDigits);
            case SWITCH:
                return isSwitchValidLength(panDigits);
            case VISA:
                return isVISAValidLength(panDigits);
            case VISA_ELECTRON:
                return isVISAElectronValidLength(panDigits);
            case UNKNOWN:
            default:
                return true;
        }
    }
    
    /**
     * Indicates if provided credit card PAN is valid by detecting its assigned
     * credit card network, checking its length and validating its checksum if
     * network supports validation.
     * @param pan a credit card pan.
     * @return true if credit card PAN appears to be valid, false otherwise.
     */
    public static boolean isValid(String pan) {
        return isValid(toDigits(pan));
    }
    
    /**
     * Indicates if provided credit card PAN is valid by detecting its assigned
     * credit card network, checking its length and validating its checksum if
     * network supports validation.
     * @param panDigits an array containing credit card pan digits.
     * @return true if credit card PAN appears to be valid, false otherwise.
     */
    protected static boolean isValid(byte[] panDigits) {
        CreditCardNetwork network = detectNetworkFromPAN(panDigits);
        boolean valid = isValidLength(panDigits, network);
        if (valid && isValidationEnabledForNetwork(network)) {
            valid = isValidChecksumForPAN(panDigits);
        }
        return valid;
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to American Express
     * IIN (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to American Express, false 
     * otherwise.
     */
    public static boolean isAmericanExpressIIN(String pan) {
        return isValidIIN(pan, AMEX_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN digits correspond to American 
     * Express IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to American Express, false
     * otherwise.
     */
    protected static boolean isAmericanExpressIIN(byte[] panDigits) {
        return isValidIIN(panDigits, AMEX_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for American 
     * Express cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid American Express length, false otherwise.
     */
    public static boolean isAmericanExpressValidLength(String pan) {
        return isValidLength(pan, AMEX_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * American Express cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid American Express length, false otherwise.
     */
    protected static boolean isAmericanExpressValidLength(byte[] panDigits) {
        return isValidLength(panDigits, AMEX_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to BankCard IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to BankCard, false otherwise.
     */
    public static boolean isBankcardIIN(String pan) {
        return isValidIIN(pan, BANKCARD_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to BankCard IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to BankCard, false otherwise.
     */
    protected static boolean isBankcardIIN(byte[] panDigits) {
        return isValidIIN(panDigits, BANKCARD_IIN);
    }

    /**
     * Indicates if provided credit card PAN has valid length for BankCard
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid BankCard length, false otherwise.
     */
    public static boolean isBankcardValidLength(String pan) {
        return isValidLength(pan, BANKCARD_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * BankCard cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid BankCard length, false otherwise.
     */
    protected static boolean isBankcardValidLength(byte[] panDigits) {
        return isValidLength(panDigits, BANKCARD_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to China UnionPay IIN
     * (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to China UnionPay, false 
     * otherwise.
     */
    public static boolean isChinaUnionPayIIN(String pan) {
        return isValidIIN(pan, CHINA_UNIONPAY_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to China UnionPay
     * IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to China UnionPay, false 
     * otherwise.
     */
    protected static boolean isChinaUnionPayIIN(byte[] panDigits) {
        return isValidIIN(panDigits, CHINA_UNIONPAY_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for China UnionPay
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid China UnionPay length, false otherwise.
     */
    public static boolean isChinaUnionPayValidLength(String pan) {
        return isValidLength(pan, CHINA_UNIONPAY_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * China UnionPay cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid China UnionPay length, false otherwise.
     */
    protected static boolean isChinaUnionPayValidLength(byte[] panDigits) {
        return isValidLength(panDigits, CHINA_UNIONPAY_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to Diners Club Carte
     * Blanche IIN (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Diners Club Carte Blanche,
     * false otherwise.
     */
    public static boolean isDinersClubCarteBlancheIIN(String pan) {
        return isValidIIN(pan, DINERS_CLUB_CARTE_BLANCHE_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to Diners Club
     * Carte Blanche IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Diners Club Carte Blance, 
     * false otherwise.
     */
    protected static boolean isDinersClubCarteBlancheIIN(byte[] panDigits) {
        return isValidIIN(panDigits, DINERS_CLUB_CARTE_BLANCHE_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Diners Club 
     * Carte Blanche cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Diners Club Carte Blanche length, false 
     * otherwise.
     */
    public static boolean isDinersClubCarteBlancheValidLength(String pan) {
        return isValidLength(pan, DINERS_CLUB_CARTE_BLANCHE_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Diners Club Carte Blanche cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Diners Club Carte Blanche length, false 
     * otherwise.
     */
    protected static boolean isDinersClubCarteBlancheValidLength(
            byte[] panDigits) {
        return isValidLength(panDigits, DINERS_CLUB_CARTE_BLANCHE_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to Diners Club Enroute
     * IIN (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Diners Club Enroute, false
     * otherwise.
     */
    public static boolean isDinersClubEnrouteIIN(String pan) {
        return isValidIIN(pan, DINERS_CLUB_ENROUTE_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to Diners Club
     * Enroute IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Diners Club Enroute, false
     * otherwise.
     */
    protected static boolean isDinersClubEnrouteIIN(byte[] panDigits) {
        return isValidIIN(panDigits, DINERS_CLUB_ENROUTE_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Diners Club 
     * Enroute cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Diners Club Enroute length, false 
     * otherwise.
     */
    public static boolean isDinersClubEnrouteValidLength(String pan) {
        return isValidLength(pan, DINERS_CLUB_ENROUTE_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Diners Club Enroute cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Diners Club Enroute length, false 
     * otherwise.
     */
    protected static boolean isDinersClubEnrouteValidLength(byte[] panDigits) {
        return isValidLength(panDigits, DINERS_CLUB_ENROUTE_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to Diners Club 
     * International IIN (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Diners Club International,
     * false otherwise.
     */
    public static boolean isDinersClubInternationalIIN(String pan) {
        return isValidIIN(pan, DINERS_CLUB_INTERNATIONAL_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to Diners Club
     * International IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Diners Club International,
     * false otherwise.
     */
    protected static boolean isDinersClubInternationalIIN(byte[] panDigits) {
        return isValidIIN(panDigits, DINERS_CLUB_INTERNATIONAL_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Diners Club 
     * International cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Diners Club International length, false 
     * otherwise.
     */
    public static boolean isDinersClubInternationalValidLength(String pan) {
        return isValidLength(pan, DINERS_CLUB_INTERNATIONAL_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Diners Club International cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Diners Club International length, false 
     * otherwise.
     */
    protected static boolean isDinersClubInternationalValidLength(
            byte[] panDigits) {
        return isValidLength(panDigits, DINERS_CLUB_INTERNATIONAL_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN corresponds to Diners Club USA and
     * Canada IIN (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Diners Club USA and Canada,
     * false otherwise.
     */
    public static boolean isDinersClubUSACanadaIIN(String pan) {
        return isValidIIN(pan, DINERS_CLUB_USA_CA_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to Diners Club
     * USA and Canada IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Diners Club USA and Canada, 
     * false otherwise.
     */
    protected static boolean isDinersClubUSACanadaIIN(byte[] panDigits) {
        return isValidIIN(panDigits, DINERS_CLUB_USA_CA_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Diners Club 
     * USA and Canada cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Diners Club USA and Canada length, false 
     * otherwise.
     */
    public static boolean isDinersClubUSACanadaValidLength(String pan) {
        return isValidLength(pan, DINERS_CLUB_USA_CA_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Diners Club USA and Canada cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Diners Club USA and Canada length, false 
     * otherwise.
     */
    protected static boolean isDinersClubUSACanadaValidLength(
            byte[] panDigits) {
        return isValidLength(panDigits, DINERS_CLUB_USA_CA_LENGTH);
    }    
    
    /**
     * Indicates if provided credit card PAN corresponds to Discover IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Discover, false otherwise.
     */
    public static boolean isDiscoverIIN(String pan) {
        return isValidIIN(pan, DISCOVER_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to Discover IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Discover, false otherwise.
     */
    protected static boolean isDiscoverIIN(byte[] panDigits) {
        return isValidIIN(panDigits, DISCOVER_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Discover
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Discover length, false otherwise.
     */
    public static boolean isDiscoverValidLength(String pan) {
        return isValidLength(pan, DISCOVER_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Discover cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Discover length, false otherwise.
     */
    protected static boolean isDiscoverValidLength(byte[] panDigits) {
        return isValidLength(panDigits, DISCOVER_LENGTH);
    }    
    
    /**
     * Indicates if provided credit card PAN corresponds to InstaPayment IIN
     * (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to InstaPayment, false 
     * otherwise.
     */
    public static boolean isInstaPaymentIIN(String pan) {
        return isValidIIN(pan, INSTAPAYMENT_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits corresponds to InstaPayment
     * IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to InstaPayment, false 
     * otherwise.
     */
    protected static boolean isInstaPaymentIIN(byte[] panDigits) {
        return isValidIIN(panDigits, INSTAPAYMENT_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for InstaPayment
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid InstaPayment length, false otherwise.
     */
    public static boolean isInstaPaymentValidLength(String pan) {
        return isValidLength(pan, INSTAPAYMENT_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * InstaPayment cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid InstaPayment length, false otherwise.
     */
    protected static boolean isInstaPaymentValidLength(byte[] panDigits) {
        return isValidLength(panDigits, INSTAPAYMENT_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to JCB IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to JCB, false otherwise.
     */
    public static boolean isJCBIIN(String pan) {
        return isValidIIN(pan, JCB_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to JCB IIN 
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to JCB, false otherwise.
     */
    protected static boolean isJCBIIN(byte[] panDigits) {
        return isValidIIN(panDigits, JCB_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for JCB
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid JCB length, false otherwise.
     */
    public static boolean isJCBValidLength(String pan) {
        return isValidLength(pan, JCB_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * JCB cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid JCB length, false otherwise.
     */
    protected static boolean isJCBValidLength(byte[] panDigits) {
        return isValidLength(panDigits, JCB_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to Laser IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Laser, false otherwise.
     */
    public static boolean isLaserIIN(String pan) {
        return isValidIIN(pan, LASER_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to Laser IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Laser, false otherwise.
     */
    protected static boolean isLaserIIN(byte[] panDigits) {
        return isValidIIN(panDigits, LASER_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Laser
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Laser length, false otherwise.
     */
    public static boolean isLaserValidLength(String pan) {
        return isValidLength(pan, LASER_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Laser cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Laser length, false otherwise.
     */
    protected static boolean isLaserValidLength(byte[] panDigits) {
        return isValidLength(panDigits, LASER_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to Maestro IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Maestro, false otherwise.
     */
    public static boolean isMaestroIIN(String pan) {
        return isValidIIN(pan, MAESTRO_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to Maestro IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Maestro, false otherwise.
     */
    protected static boolean isMaestroIIN(byte[] panDigits) {
        return isValidIIN(panDigits, MAESTRO_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Maestro
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Maestro length, false otherwise.
     */
    public static boolean isMaestroValidLength(String pan) {
        return isValidLength(pan, MAESTRO_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Maestro cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Maestro length, false otherwise.
     */
    protected static boolean isMaestroValidLength(byte[] panDigits) {
        return isValidLength(panDigits, MAESTRO_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to Mastercard IIN
     * (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Mastercard, false otherwise.
     */
    public static boolean isMastercardIIN(String pan) {
        return isValidIIN(pan, MASTERCARD_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to Mastercard IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Mastercard, false otherwise.
     */
    protected static boolean isMastercardIIN(byte[] panDigits) {
        return isValidIIN(panDigits, MASTERCARD_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Mastercard
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Mastercard length, false otherwise.
     */
    public static boolean isMastercardValidLength(String pan) {
        return isValidLength(pan, MASTERCARD_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Mastercard cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Mastercard length, false otherwise.
     */
    protected static boolean isMastercardValidLength(byte[] panDigits) {
        return isValidLength(panDigits, MASTERCARD_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to Solo IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Solo, false otherwise.
     */
    public static boolean isSoloIIN(String pan) {
        return isValidIIN(pan, SOLO_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to Solo IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Solo, false otherwise.
     */
    protected static boolean isSoloIIN(byte[] panDigits) {
        return isValidIIN(panDigits, SOLO_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Solo
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Solo length, false otherwise.
     */
    public static boolean isSoloValidLength(String pan) {
        return isValidLength(pan, SOLO_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Solo cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Solo length, false otherwise.
     */
    protected static boolean isSoloValidLength(byte[] panDigits) {
        return isValidLength(panDigits, SOLO_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to Switch IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to Switch, false otherwise.
     */
    public static boolean isSwitchIIN(String pan) {
        return isValidIIN(pan, SWITCH_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to Switch IIN
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to Switch, false otherwise.
     */
    protected static boolean isSwitchIIN(byte[] panDigits) {
        return isValidIIN(panDigits, SWITCH_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for Switch
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid Switch length, false otherwise.
     */
    public static boolean isSwitchValidLength(String pan) {
        return isValidLength(pan, SWITCH_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * Switch cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid Switch length, false otherwise.
     */
    protected static boolean isSwitchValidLength(byte[] panDigits) {
        return isValidLength(panDigits, SWITCH_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to VISA IIN (Issuer
     * Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to VISA, false otherwise.
     */
    public static boolean isVISAIIN(String pan) {
        return isValidIIN(pan, VISA_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to VISA IIN 
     * (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to VISA, false otherwise.
     */
    protected static boolean isVISAIIN(byte[] panDigits) {
        return isValidIIN(panDigits, VISA_IIN);
    }
    
    /**
     * Indicates if provided credit card PAN has valid length for VISA cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid VISA length, false otherwise.
     */
    public static boolean isVISAValidLength(String pan) {
        return isValidLength(pan, VISA_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * VISA cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid VISA length, false otherwise.
     */
    protected static boolean isVISAValidLength(byte[] panDigits) {
        return isValidLength(panDigits, VISA_LENGTH);
    }        
    
    /**
     * Indicates if provided credit card PAN corresponds to VISA Electron IIN
     * (Issuer Identification Number).
     * @param pan a credit card PAN.
     * @return true if provided PAN corresponds to VISA Electron, false 
     * otherwise.
     */
    public static boolean isVISAElectronIIN(String pan) {
        return isValidIIN(pan, VISA_ELECTRON_IIN);
    }

    /**
     * Indicates if provided credit card PAN digits correspond to VISA Electron
     * IIN (Issuer Identification Number).
     * @param panDigits array containing credit card PAN digits.
     * @return true if provided PAN corresponds to VISA Electron, false 
     * otherwise.
     */
    protected static boolean isVISAElectronIIN(byte[] panDigits) {
        return isValidIIN(panDigits, VISA_ELECTRON_IIN);
    }

    /**
     * Indicates if provided credit card PAN has valid length for VISA Electron 
     * cards.
     * @param pan a credit card PAN.
     * @return true if PAN has a valid VISA Electron length, false otherwise.
     */
    public static boolean isVISAElectronValidLength(String pan) {
        return isValidLength(pan, VISA_ELECTRON_LENGTH);
    }
    
    /**
     * Indicates if provided credit card PAN digits have valid length for 
     * VISA Electron cards.
     * @param panDigits array containing credit card PAN digits.
     * @return true if PAN has a valid VISA Electron length, false otherwise.
     */
    protected static boolean isVISAElectronValidLength(byte[] panDigits) {
        return isValidLength(panDigits, VISA_ELECTRON_LENGTH);
    }    
    
    /**
     * Validates provided credit card PAN using Luhn algorithm assuming that
     * the last digit of provided PAN corresponds to its checksum value.
     * This method computes the checksum value using Luhn algorithm and compares
     * that with the last digit of provided PAN value, if both are equal PAN
     * checksum is assumed to be valid.
     * @param pan a credit card PAN to validate its checksum.
     * @return true if checksum is valid, false otherwise.
     */
    public static boolean isValidChecksumForPAN(String pan) {
        return isValidChecksumForPAN(toDigits(pan));
    }
    
    /**
     * Validates provided credit card PAN using Luhn algorithm assuming that
     * the last digit of provided PAN corresponds to its checksum value.
     * This method computes the checksum value using Luhn algorithm and compares
     * that with the last digit of provided PAN digits, if both are equal PAN
     * checksum is assumed to be valid.
     * @param panDigits array of digits containing a credit card PAN.
     * @return true if checksum is valid, false otherwise.
     */
    protected static boolean isValidChecksumForPAN(byte[] panDigits) {
        if (panDigits == null) {
            return false;
        }
        
        //last digit is check value
        int length = panDigits.length;
        if (length < 2) {
            return false; //we need at least two digits (digits + checksum)
        }

        byte check = panDigits[length - 1];
        
        //copy digits without check into new array
        byte[] digitsWithoutCheck = Arrays.copyOf(panDigits, length - 1);
        
        //compare checksums
        byte computedCheck = computeCheck(digitsWithoutCheck);
        return check == computedCheck;
    }
    
    /**
     * Internal method to check whether provided credit card PAN corresponds
     * to a valid IIN by checking the array of valid IIN ranges.
     * @param pan a credit card PAN.
     * @param iins array of valid IIN ranges.
     * @return true if PAN corresponds to a valid IIN, false otherwise.
     */
    protected static boolean isValidIIN(String pan, String[][] iins) {
        if (pan == null || iins == null) {
            return false;
        }
        //remove hyphens, spaces or any punctuation mark from pan string
        return isValidIIN(toDigits(pan), iins);
    }
    
    /**
     * Internal method to check whether provided array of PAN digits corresponds
     * to a valid IIN by checking the array of valid IIN ranges.
     * @param panDigits array containing credit card PAN digits.
     * @param iins array of valid IIN ranges.
     * @return true if PAN corresponds to valid IIN, false otherwise.
     */
    protected static boolean isValidIIN(byte[] panDigits, String[][] iins) {
        if (iins == null) {
            return false;
        }
        if (panDigits == null || panDigits.length == 0) {
            return false;
        }
        StringBuilder panBuilder = new StringBuilder();
        for (byte panDigit : panDigits) {
            panBuilder.append(panDigit);
        }
        String pan2 = panBuilder.toString();

        String iinStartStr;
        String iinEndStr;
        String iinStr;
        int iinStart;
        int iinEnd;
        int leadingZeros;
        StringBuilder iinBuilder;        
        //try for all possible IIN ranges
        for (String[] iin : iins) {
            iinStartStr = iin[0];
            iinEndStr = iin[1];
            if (iinStartStr == null || iinEndStr == null) {
                return false;
            }

            leadingZeros = numLeadingZeros(iinStartStr);
            if (iinStartStr.length() < iinEndStr.length()) {
                //add 0's to start of range until both start and end have the 
                //same length
                iinBuilder = new StringBuilder();
                iinBuilder.append(iinStartStr);
                int diff = iinEndStr.length() - iinStartStr.length();
                for (int j = 0; j < diff; j++) {
                    iinBuilder.append('0');
                }
                iinStartStr = iinBuilder.toString();
            }
            if (iinStartStr.length() > iinEndStr.length()) {
                //add 9's to end of range until both start and end have the same
                //length
                iinBuilder = new StringBuilder();
                iinBuilder.append(iinEndStr);
                int diff = iinStartStr.length() - iinEndStr.length();
                for (int j = 0; j < diff; j++) {
                    iinBuilder.append('9');
                }
                iinEndStr = iinBuilder.toString();
            }
            iinStart = Integer.parseInt(iinStartStr);
            iinEnd = Integer.parseInt(iinEndStr);
            for (int j = iinStart; j <= iinEnd; j++) {
                //try for all values within a range
                iinBuilder = new StringBuilder();
                for (int m = 0; m < leadingZeros; m++) {
                    iinBuilder.append('0');
                }
                iinBuilder.append(j);

                //check if pan starts with computed IIN
                iinStr = iinBuilder.toString();
                if (pan2.startsWith(iinStr) || iinStr.startsWith(pan2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * Internal method to determine whether length of provided credit card PAN
     * is valid based on array of valid length ranges.
     * @param pan a credit card PAN.
     * @param lengths array of valid length ranges.
     * @return true if PAN length is valid, false otherwise.
     */
    protected static boolean isValidLength(String pan, byte[][] lengths) {
        if (pan == null || lengths == null) {
            return false;
        }
        return isValidLength(toDigits(pan), lengths);
    }
    
    /**
     * Internal method to determine whether length of provided array of credit
     * card PAN digits is valid based on array of valid length ranges.
     * @param panDigits array containing credit card PAN digits.
     * @param lengths array of valid length ranges.
     * @return true if PAN length is valid, false otherwise.
     */
    protected static boolean isValidLength(byte[] panDigits, byte[][] lengths) {
        if (panDigits == null || lengths == null) {
            return false;
        }
        int length = panDigits.length;

        int minLength;
        int maxLength;
        for (byte[] l : lengths) {
            minLength = l[0];
            maxLength = l[1];
            if (length >= minLength && length <= maxLength) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Computes number of leading zeros on any given IIN.
     * @param iin a given IIN in string format.
     * @return number of leading zeros.
     */
    protected static int numLeadingZeros(String iin) {
        if (iin == null) {
            return 0;
        }
        
        int length = iin.length();
        for (int i = 0; i < length; i++) {
            if (iin.charAt(i) != '0') {
                return i;
            }
        }
        return length;
    }
    
    /**
     * Converts a credit card PAN from its string representation into an array
     * containing PAN digits.
     * This method will strip away any spaces or punctuation marks, leaving only
     * the digits found within provided PAN.
     * @param pan a credit card PAN.
     * @return credit card PAN represented as an array of digits.
     */
    @SuppressWarnings("Duplicates")
    protected static byte[] toDigits(String pan) {
        if (pan == null) {
            return new byte[0];
        }
        
        int length = pan.length();
        byte[] internal = new byte[length];
        byte value;
        char c;
        int numDigits = 0;
        for (int i = 0; i < length; i++) {
            c = pan.charAt(i);
            switch (c) {
                case '0':
                    value = 0;
                    break;
                case '1':
                    value = 1;
                    break;
                case '2':
                    value = 2;
                    break;
                case '3':
                    value = 3;
                    break;
                case '4':
                    value = 4;
                    break;
                case '5':
                    value = 5;
                    break;
                case '6':
                    value = 6;
                    break;
                case '7':
                    value = 7;
                    break;
                case '8':
                    value = 8;
                    break;
                case '9':
                    value = 9;
                    break;
                default:
                    continue;
            }
            
            //value of character is only added if it is a digit,
            //otherwise this is never executed
            internal[numDigits] = value;
            numDigits++;
        }
        
        if (numDigits == 0) {
            return new byte[0];
        } else {
            return Arrays.copyOf(internal, numDigits);
        }
    }
    
    /**
     * Computes checksum using Luhn algorithm.
     * Notice that this method will modify the values in provided array of 
     * digits.
     * @param digitsWithoutCheck array containing a credit card PAN number 
     * without its checksum value (which is the last digit).
     * @return computed checksum value.
     */
    protected static byte computeCheck(byte[] digitsWithoutCheck) {
        //multiply by two even digits
        int length = digitsWithoutCheck.length;
        for (int i = length - 1; i >= 0; i -= 2) {
            digitsWithoutCheck[i] *= 2;
        }
        
        //sum digits of multiplied digits
        byte value;
        byte unit;
        byte ten;
        for (int i = 0; i < length; i++) {
            value = digitsWithoutCheck[i];
            unit = (byte)(value % 10); //a unit
            ten = (byte)((value - unit) / 10); //a ten
            digitsWithoutCheck[i] = (byte)(unit + ten);
        }
        
        //sum all values
        int sum = 0;
        for (byte digitWithoutCheck : digitsWithoutCheck) {
            sum += digitWithoutCheck;
        }
        
        //multiply by 9 and pick last digit (modulus 10)
        return (byte)((sum * 9) % 10);
    }
    
    /**
     * Returns credit card digit groupings for provided credit card network.
     * @param network a credit card network.
     * @return digit groupings.
     */
    protected static byte[][] groupingsForNetwork(CreditCardNetwork network) {
        if (network == null) {
            return DEFAULT_GROUPING;
        }
        
        switch (network) {
            case AMERICAN_EXPRESS:
                return AMEX_GROUPING;
            case VISA:
                return VISA_GROUPING;
            case VISA_ELECTRON:
                return VISA_ELECTRON_GROUPING;
            case MASTERCARD:
                return MASTERCARD_GROUPING;
            case DINERS_CLUB_INTERNATIONAL:
            case DINERS_CLUB_CARTE_BLANCHE:
                return DINERS_CLUB_INTERATIONAL_GROUPING;
            case DINERS_CLUB_ENROUTE:
                return DINERS_CLUB_ENROUTE_GROUPING;
            case DINERS_CLUB_USA_CANADA:
            case DISCOVER:
                return DISCOVER_GROUPING;
            default:
                return DEFAULT_GROUPING;                
        }
    }
    
    /**
     * Returns number of digit groups for provided credit card network.
     * @param network a credit card network.
     * @return number of digit groups for provided credit card network.
     */
    public static int getNumberOfGroupsForNetwork(CreditCardNetwork network) {
        byte[][] groups = groupingsForNetwork(network);
        return groups.length;
    }
    
    /**
     * Returns minimum number of required digits for provided group position
     * (starting at zero until the maximum number of groups minus one).
     * @param groupPos position of group of digits.
     * @param network credit card network.
     * @return minimum number of required digits.
     * @throws IllegalArgumentException if groupPos is negative or exceeds the
     * maximum number of groups minus one for provided credit card network.
     */
    @SuppressWarnings("Duplicates")
    public static int getMinDigitsForGroupAndNetwork(int groupPos, 
            CreditCardNetwork network) {
        if (groupPos < 0) {
            throw new IllegalArgumentException();
        }
        
        byte[][] groups = groupingsForNetwork(network);
        int numGroups = groups.length;
        if (groupPos >= numGroups) {
            throw new IllegalArgumentException();
        }
        
        return groups[groupPos][0];
    }
    
    /**
     * Returns maximum number of allowed digits for provided group position
     * (starting at zero until the maximum number of groups minus one).
     * @param groupPos position of group of digits.
     * @param network credit card network.
     * @return maximum number of allowed digits.
     * @throws IllegalArgumentException if groupPos is negative or exceeds the
     * maximum number of groups minus one for provided credit card network.
     */
    @SuppressWarnings("Duplicates")
    public static int getMaxDigitsForGroupAndNetwork(int groupPos,
            CreditCardNetwork network) {
        if (groupPos < 0) {
            throw new IllegalArgumentException();
        }
        
        byte[][] groups = groupingsForNetwork(network);
        int numGroups = groups.length;
        if (groupPos >= numGroups) {
            throw new IllegalArgumentException();
        }
        
        return groups[groupPos][1];
    }
}
