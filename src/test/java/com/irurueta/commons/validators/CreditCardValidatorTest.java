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

import org.junit.*;

import static org.junit.Assert.*;

public class CreditCardValidatorTest {
    
    public CreditCardValidatorTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }

    @Test
    public void testConstructor() {
        //noinspection all
        assertNotNull(new CreditCardValidator());
    }
    
    @Test
    public void testIsValidMII() {
        //test pan starting with a non digit value
        String pan = " 3333 3333 3333 3333";
        assertTrue(CreditCardValidator.isValidMII(pan));
        
        //test pan with valid MII
        pan = "4444 4444 4444 4444 4444";
        assertTrue(CreditCardValidator.isValidMII(pan));

        //another valid MII
        pan = "5555-5555-5555-5555-5555";
        assertTrue(CreditCardValidator.isValidMII(pan));
        
        //another valid MII
        pan = "6666/66666/666666";
        assertTrue(CreditCardValidator.isValidMII(pan));
        
        //test invalid MII (empty string)
        pan = "";
        assertFalse(CreditCardValidator.isValidMII(pan));
        
        //invalid MII (no digits)
        pan = "/";
        assertFalse(CreditCardValidator.isValidMII(pan));
        
        //invalid MII (invalid first digit)
        pan = "1111 1111 1111 11";
        assertFalse(CreditCardValidator.isValidMII(pan));
        
        //invalid MII (null)
        assertFalse(CreditCardValidator.isValidMII((String)null));
        
        //test with array with valid MII
        byte[] digits = new byte[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        assertTrue(CreditCardValidator.isValidMII(digits));
        
        //another valid MII
        digits = new byte[]{4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        assertTrue(CreditCardValidator.isValidMII(digits));
        
        //another valid MII
        digits = new byte[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        assertTrue(CreditCardValidator.isValidMII(digits));
        
        //another valid MII
        digits = new byte[]{6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
        assertTrue(CreditCardValidator.isValidMII(digits));
        
        //test invalid MII (empty array)
        digits = new byte[]{};
        assertFalse(CreditCardValidator.isValidMII(digits));
                
        //invalid MII (invalid first digit)
        digits = new byte[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        assertFalse(CreditCardValidator.isValidMII(digits));
        
        //invalid MII (null)
        //noinspection all
        assertFalse(CreditCardValidator.isValidMII((byte[])null));
    }
    
    @Test
    public void testIsValidationEnabledForNetwork() {
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.AMERICAN_EXPRESS), 
                CreditCardValidator.AMEX_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.BANKCARD),
                CreditCardValidator.BANKCARD_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.CHINA_UNIONPAY),
                CreditCardValidator.CHINA_UNIONPAY_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE),
                CreditCardValidator.DINERS_CLUB_CARTE_BLANCHE_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.DINERS_CLUB_ENROUTE),
                CreditCardValidator.DINERS_CLUB_ENROUTE_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL),
                CreditCardValidator.DINERS_CLUB_INTERATIONAL_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA),
                CreditCardValidator.DINERS_CLUB_USA_CA_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.DISCOVER),
                CreditCardValidator.DISCOVER_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.INSTAPAYMENT),
                CreditCardValidator.INSTAPAYMENT_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.JCB),
                CreditCardValidator.JCB_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.LASER),
                CreditCardValidator.LASER_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.MAESTRO),
                CreditCardValidator.MAESTRO_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.MASTERCARD),
                CreditCardValidator.MASTERCARD_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.SOLO),
                CreditCardValidator.SOLO_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.SWITCH),
                CreditCardValidator.SWITCH_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.VISA),
                CreditCardValidator.VISA_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.VISA_ELECTRON),
                CreditCardValidator.VISA_ELECTRON_HAS_VALIDATION);
        assertFalse(CreditCardValidator.isValidationEnabledForNetwork(
                CreditCardNetwork.UNKNOWN));
        //noinspection all
        assertFalse(CreditCardValidator.isValidationEnabledForNetwork(null));
    }
    
    @Test
    public void testIsNetworkActive() {
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.AMERICAN_EXPRESS),
                CreditCardValidator.AMEX_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.BANKCARD),
                CreditCardValidator.BANKCARD_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.CHINA_UNIONPAY),
                CreditCardValidator.CHINA_UNIONPAY_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE),
                CreditCardValidator.DINERS_CLUB_CARTE_BLANCHE_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.DINERS_CLUB_ENROUTE),
                CreditCardValidator.DINERS_CLUB_ENROUTE_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL),
                CreditCardValidator.DINERS_CLUB_INTERATIONAL_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA),
                CreditCardValidator.DINERS_CLUB_USA_CA_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.DISCOVER),
                CreditCardValidator.DISCOVER_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.INSTAPAYMENT),
                CreditCardValidator.INSTAPAYMENT_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.JCB),
                CreditCardValidator.JCB_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.LASER),
                CreditCardValidator.LASER_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.MAESTRO),
                CreditCardValidator.MAESTRO_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.MASTERCARD),
                CreditCardValidator.MASTERCARD_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.SOLO),
                CreditCardValidator.SOLO_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.SWITCH),
                CreditCardValidator.SWITCH_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.VISA),
                CreditCardValidator.VISA_IS_ACTIVE);
        assertEquals(CreditCardValidator.isNetworkActive(
                CreditCardNetwork.VISA_ELECTRON),
                CreditCardValidator.VISA_ELECTRON_IS_ACTIVE);
        assertTrue(CreditCardValidator.isNetworkActive(CreditCardNetwork.UNKNOWN));
        //noinspection all
        assertTrue(CreditCardValidator.isNetworkActive(null));
    }
    
    @Test
    public void testDetectNetworkFromPAN() {
        //test for typical credit card test PANs
        
        //VISA
        String pan = "4111 1111 1111 1111";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan), 
                CreditCardNetwork.VISA);
        pan = "4005 5192 0000 0004";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4009-3488-8888-1881";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4012000033330026";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4012000077777777";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4012888888881881";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4217651111111119";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "4500600000000061";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.detectNetworkFromPAN(pan) ==
                CreditCardNetwork.MASTERCARD || 
                CreditCardValidator.detectNetworkFromPAN(pan) == 
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        
        pan = "3782 82246 310005";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.AMERICAN_EXPRESS);
        pan = "371449635398431";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.AMERICAN_EXPRESS);
        
        pan = "6011111111111117";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        
        pan = "3530111333300000";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);
        
        //test for credit card IINs (this can be used to detect network while PAN
        //is being typed
        
        //American Express
        pan = "34";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.AMERICAN_EXPRESS);
        pan = "37";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.AMERICAN_EXPRESS);
        
        //Bankcard
        pan = "5610";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        pan = "560221";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        pan = "560222";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        pan = "560223";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        pan = "560224";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        pan = "560225";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.BANKCARD);
        
        //China UnionPay
        //62 is not enough to determine if it belongs to China UnionPay, as it
        //could also be from Discover, so we use ranges of 62 outside of 
        //Discover
        pan = "620";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.CHINA_UNIONPAY);
        pan = "621";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.CHINA_UNIONPAY);
        pan = "623";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.CHINA_UNIONPAY);
        
        //Diners Club Carte Blanche
        pan = "300";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        pan = "301";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        pan = "302";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        pan = "303";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        pan = "304";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);        
        pan = "305";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        
        //Diners Club Enroute
        pan = "2014";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_ENROUTE);
        pan = "2149";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_ENROUTE);
        
        //Diners Club International
        pan = "36";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
        
        //Diners Club USA & Canda
        pan = "54";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        pan = "55";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        
        //Discover
        pan = "6011";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        pan = "622126";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        pan = "6223";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6224";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6225";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6226";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6227";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6228";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "6229";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "62295";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        pan = "644";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        pan = "645";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "646";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "647";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "648";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);        
        pan = "649";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        pan = "65";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.DISCOVER);
        
        //InstaPayment
        pan = "637";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.INSTAPAYMENT);
        pan = "638";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.INSTAPAYMENT);        
        pan = "639";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.INSTAPAYMENT);
        
        //JCB
        pan = "3528";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);
        pan = "3538";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);        
        pan = "3548";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);                
        pan = "3558";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);                
        pan = "3568";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);                
        pan = "3578";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);                
        pan = "3588";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);                
        pan = "3589";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.JCB);
        
        //Laser
        pan = "6304";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.LASER);
        pan = "6706";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.LASER);
        pan = "6771";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.LASER);
        pan = "6709";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.LASER);
        
        //Maestro
        pan = "5018";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "5020";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "5038";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "5893";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "6759";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "6761";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "6762";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);        
        pan = "6763";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        pan = "0604";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MAESTRO);
        
        //Mastercard
        pan = "51";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MASTERCARD);
        pan = "52";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MASTERCARD);        
        pan = "53";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.MASTERCARD);
        
        //Solo
        pan = "6334";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SOLO);
        pan = "6767";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SOLO);
        
        pan = "4903";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "4905";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "4911";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "4936";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "564182";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "633110";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        pan = "6333";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.SWITCH);
        
        //VISA
        pan = "400";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "410";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "42";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "43";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);
        pan = "441";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);        
        pan = "451";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);        
        pan = "46";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);        
        pan = "47";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);        
        pan = "481";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);        
        pan = "492";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA);  
        
        //VISA Electron
        pan = "4026";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "417500";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "4405";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "4508";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "4844";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "4913";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
        pan = "4917";
        assertEquals(CreditCardValidator.detectNetworkFromPAN(pan),
                CreditCardNetwork.VISA_ELECTRON);
    }
    
    @Test
    public void testIsValidLength() {
        //test for typical credit card test PANs
        
        //VISA
        String pan = "4111 1111 1111 1111";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "4005 5192 0000 0004";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4009-3488-8888-1881";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012000033330026";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012000077777777";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012888888881881";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4217651111111119";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4500600000000061";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DINERS_CLUB_USA_CANADA));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3782 82246 310005";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.AMERICAN_EXPRESS));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "371449635398431";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.AMERICAN_EXPRESS));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6011111111111117";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertTrue(CreditCardValidator.isDiscoverValidLength(pan));
        assertTrue(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3530111333300000";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, CreditCardNetwork.JCB));
        assertTrue(CreditCardValidator.isJCBValidLength(pan));
        assertTrue(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //test for credit card IINs (this can be used to detect network while PAN
        //is being typed
        
        //American Express
        pan = "34";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.AMERICAN_EXPRESS));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "37";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.AMERICAN_EXPRESS));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Bankcard
        pan = "5610";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "560221";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560222";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560223";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560224";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560225";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //China UnionPay
        //62 is not enough to determine if it belongs to China UnionPay, as it
        //could also be from Discover, so we use ranges of 62 outside of 
        //Discover
        pan = "620";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "621";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "623";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Diners Club Carte Blanche
        pan = "300";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "301";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "302";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "303";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "304";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "305";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        
        //Diners Club Enroute
        pan = "2014";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DINERS_CLUB_ENROUTE));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "2149";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DINERS_CLUB_ENROUTE));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Diners Club International
        pan = "36";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL));
        assertFalse(CreditCardValidator.isDinersClubInternationalValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubInternationalValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Diners Club USA & Canda
        pan = "54";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DINERS_CLUB_USA_CANADA));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "55";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DINERS_CLUB_USA_CANADA));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Discover
        pan = "6011";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "622126";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6223";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6224";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6225";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6226";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6227";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6228";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6229";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "62295";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "644";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "645";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "646";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "647";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "648";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "649";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "65";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //InstaPayment
        pan = "637";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "638";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "639";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //JCB
        pan = "3528";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "3538";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3548";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3558";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3568";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3578";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3588";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3589";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Laser
        pan = "6304";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "6706";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6771";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6709";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Maestro
        pan = "5018";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "5020";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "5038";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "5893";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6759";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6761";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6762";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6763";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "0604";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Mastercard
        pan = "51";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "52";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "53";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Solo
        pan = "6334";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.SOLO));
        assertFalse(CreditCardValidator.isSoloValidLength(pan));
        assertFalse(CreditCardValidator.isSoloValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "6767";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.SOLO));
        assertFalse(CreditCardValidator.isSoloValidLength(pan));
        assertFalse(CreditCardValidator.isSoloValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "4903";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "4905";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4911";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4936";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "564182";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "633110";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6333";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardNetwork.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //VISA
        pan = "400";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "410";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "42";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "43";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "441";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "451";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "46";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "47";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "481";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "492";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //VISA Electron
        pan = "4026";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "417500";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4405";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4508";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4844";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4913";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4917";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardNetwork.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsValidAndIsValidChecksumForPAN() {
        //VISA
        String pan = "4111 1111 1111 1111";
        assertTrue(CreditCardValidator.isValid(pan));
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4111 1111 1111 1112";
        assertFalse(CreditCardValidator.isValid(pan));
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4005 5192 0000 0004";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4005 5192 0000 0005";
        assertFalse(CreditCardValidator.isValid(pan));
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4009-3488-8888-1881";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4009-3488-8888-1882";
        assertFalse(CreditCardValidator.isValid(pan));
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4012000033330026";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4012000033330027";
        assertFalse(CreditCardValidator.isValid(pan));
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4012000077777777";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4012000077777778";
        assertFalse(CreditCardValidator.isValid(pan));
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4012888888881881";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4012888888881882";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4217651111111119";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4217651111111118";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "4500600000000061";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "4500600000000062";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "5555555555554445";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "3782 82246 310005";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "3782 82246 310006";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "371449635398431";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "371449635398432";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "6011111111111117";
        assertTrue(CreditCardValidator.isValid(pan));        
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "6011111111111118";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
        
        pan = "3530111333300000";
        assertTrue(CreditCardValidator.isValid(pan));               
        assertTrue(CreditCardValidator.isValidChecksumForPAN(pan));
        pan = "3530111333300001";
        assertFalse(CreditCardValidator.isValid(pan));        
        assertFalse(CreditCardValidator.isValidChecksumForPAN(pan));
    }
    
    @Test
    public void testIsAmericanExpressIIN() {
        String pan = "34";
        assertTrue(CreditCardValidator.isAmericanExpressIIN(pan));
        assertTrue(CreditCardValidator.isAmericanExpressIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "37";
        assertTrue(CreditCardValidator.isAmericanExpressIIN(pan));
        assertTrue(CreditCardValidator.isAmericanExpressIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isAmericanExpressIIN(pan));
        assertFalse(CreditCardValidator.isAmericanExpressIIN(
                CreditCardValidator.toDigits(pan)));
    }
    
    @Test
    public void testIsBankcardIIN() {
        String pan = "5610";
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "560221";
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "560222";
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "560223";
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "560224";        
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "560225";        
        assertTrue(CreditCardValidator.isBankcardIIN(pan));
        assertTrue(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "00";
        assertFalse(CreditCardValidator.isBankcardIIN(pan));
        assertFalse(CreditCardValidator.isBankcardIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsChinaUnionPayIIN() {
        String pan = "620";
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(pan));
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "621";
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(pan));
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "623";        
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(pan));
        assertTrue(CreditCardValidator.isChinaUnionPayIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isChinaUnionPayIIN(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayIIN(
                CreditCardValidator.toDigits(pan)));
    }
    
    @Test
    public void testIsDinersClubCarteBlancheIIN() {
        String pan = "300";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "301";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "302";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "303";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "304";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "305";
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "00";
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheIIN(pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheIIN(
                CreditCardValidator.toDigits(pan)));                
    }
    
    @Test
    public void testIsDinersClubEnrouteIIN() {
        String pan = "2014";
        assertTrue(CreditCardValidator.isDinersClubEnrouteIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubEnrouteIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "2149";
        assertTrue(CreditCardValidator.isDinersClubEnrouteIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubEnrouteIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "00";
        assertFalse(CreditCardValidator.isDinersClubEnrouteIIN(pan));
        assertFalse(CreditCardValidator.isDinersClubEnrouteIIN(
                CreditCardValidator.toDigits(pan)));                
    }
    
    @Test
    public void testIsDinersClubInternationalIIN() {
        String pan = "36";
        assertTrue(CreditCardValidator.isDinersClubInternationalIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubInternationalIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "00";
        assertFalse(CreditCardValidator.isDinersClubInternationalIIN(pan));
        assertFalse(CreditCardValidator.isDinersClubInternationalIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsDinersClubUSACanadaIIN() {
        String pan = "54";
        assertTrue(CreditCardValidator.isDinersClubUSACanadaIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "55";
        assertTrue(CreditCardValidator.isDinersClubUSACanadaIIN(pan));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isDinersClubUSACanadaIIN(pan));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsDiscoverIIN() {
        String pan = "6011";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "622126";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6223";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6224";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6225";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6226";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6227";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6228";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6229";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "62295";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "644";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "645";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "646";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "647";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "648";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "649";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "65";
        assertTrue(CreditCardValidator.isDiscoverIIN(pan));
        assertTrue(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));        

        pan = "00";
        assertFalse(CreditCardValidator.isDiscoverIIN(pan));
        assertFalse(CreditCardValidator.isDiscoverIIN(
                CreditCardValidator.toDigits(pan)));                
    }
    
    @Test
    public void testIsInstaPaymentIIN() {
        String pan = "637";
        assertTrue(CreditCardValidator.isInstaPaymentIIN(pan));
        assertTrue(CreditCardValidator.isInstaPaymentIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "638";
        assertTrue(CreditCardValidator.isInstaPaymentIIN(pan));
        assertTrue(CreditCardValidator.isInstaPaymentIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "639";
        assertTrue(CreditCardValidator.isInstaPaymentIIN(pan));
        assertTrue(CreditCardValidator.isInstaPaymentIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "00";
        assertFalse(CreditCardValidator.isInstaPaymentIIN(pan));
        assertFalse(CreditCardValidator.isInstaPaymentIIN(
                CreditCardValidator.toDigits(pan)));                
    }
    
    @Test
    public void testIsJCBIIN() {
        String pan = "3528";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3538";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3548";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3558";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3568";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3578";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3588";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3589";
        assertTrue(CreditCardValidator.isJCBIIN(pan));
        assertTrue(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isJCBIIN(pan));
        assertFalse(CreditCardValidator.isJCBIIN(
                CreditCardValidator.toDigits(pan)));
    }
    
    @Test
    public void testIsLaserIIN() {
        String pan = "6304";
        assertTrue(CreditCardValidator.isLaserIIN(pan));
        assertTrue(CreditCardValidator.isLaserIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6706";
        assertTrue(CreditCardValidator.isLaserIIN(pan));
        assertTrue(CreditCardValidator.isLaserIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6771";
        assertTrue(CreditCardValidator.isLaserIIN(pan));
        assertTrue(CreditCardValidator.isLaserIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6709";
        assertTrue(CreditCardValidator.isLaserIIN(pan));
        assertTrue(CreditCardValidator.isLaserIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isLaserIIN(pan));
        assertFalse(CreditCardValidator.isLaserIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsMaestroIIN() {
        String pan = "5018";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "5020";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "5038";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "5893";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                        
        
        pan = "6759";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                                
        
        pan = "6761";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                                        
        
        pan = "6762";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                                        
        
        pan = "6763";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                                        
        
        pan = "0604";
        assertTrue(CreditCardValidator.isMaestroIIN(pan));
        assertTrue(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "00";
        assertFalse(CreditCardValidator.isMaestroIIN(pan));
        assertFalse(CreditCardValidator.isMaestroIIN(
                CreditCardValidator.toDigits(pan)));                
    }
    
    @Test
    public void testIsMastercardIIN() {
        String pan = "222100";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "250";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "272099";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "272100";
        assertFalse(CreditCardValidator.isMastercardIIN(pan));
        assertFalse(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));
                
        pan = "51";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "52";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "53";
        assertTrue(CreditCardValidator.isMastercardIIN(pan));
        assertTrue(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "00";
        assertFalse(CreditCardValidator.isMastercardIIN(pan));
        assertFalse(CreditCardValidator.isMastercardIIN(
                CreditCardValidator.toDigits(pan)));                        
    }
    
    @Test
    public void testIsSoloIIN() {
        String pan = "6334";
        assertTrue(CreditCardValidator.isSoloIIN(pan));
        assertTrue(CreditCardValidator.isSoloIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6767";
        assertTrue(CreditCardValidator.isSoloIIN(pan));
        assertTrue(CreditCardValidator.isSoloIIN(
                CreditCardValidator.toDigits(pan)));  
        
        pan = "00";
        assertFalse(CreditCardValidator.isSoloIIN(pan));
        assertFalse(CreditCardValidator.isSoloIIN(
                CreditCardValidator.toDigits(pan)));                        
    }

    @Test
    public void testIsSwitchIIN() {
        
        String pan = "4903";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "4905";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "4911";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "4936";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "564182";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "633110";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                
        
        pan = "6333";
        assertTrue(CreditCardValidator.isSwitchIIN(pan));
        assertTrue(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                

        pan = "00";
        assertFalse(CreditCardValidator.isSwitchIIN(pan));
        assertFalse(CreditCardValidator.isSwitchIIN(
                CreditCardValidator.toDigits(pan)));                        
    }
    
    @Test
    public void testIsVISAIIN() {
        String pan = "400";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "410";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "42";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "43";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "441";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "451";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "46";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "47";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "481";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "492";
        assertTrue(CreditCardValidator.isVISAIIN(pan));
        assertTrue(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "00";
        assertFalse(CreditCardValidator.isVISAIIN(pan));
        assertFalse(CreditCardValidator.isVISAIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsVISAElectronIIN() {
        String pan = "4026";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "417500";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "4405";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "4508";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "4844";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "4913";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));
        
        pan = "4917";
        assertTrue(CreditCardValidator.isVISAElectronIIN(pan));
        assertTrue(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));

        pan = "00";
        assertFalse(CreditCardValidator.isVISAElectronIIN(pan));
        assertFalse(CreditCardValidator.isVISAElectronIIN(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testGetNumberOfGroupsForNetwork() {
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.AMERICAN_EXPRESS);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.AMERICAN_EXPRESS), groups.length);
        
        //Bankcard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.BANKCARD);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.BANKCARD), groups.length);
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.CHINA_UNIONPAY);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.CHINA_UNIONPAY), groups.length);        
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE), groups.length);                
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_ENROUTE);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.DINERS_CLUB_ENROUTE), groups.length);                

        //Diners Club International
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL), groups.length);                

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA), groups.length);                        
        
        //Discover
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DISCOVER);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.DISCOVER), groups.length);                                
        
        //InstaPayment
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.INSTAPAYMENT);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.INSTAPAYMENT), groups.length);                                        
        
        //JCB
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.JCB);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.JCB), groups.length);                                        

        //Laser
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.LASER);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.LASER), groups.length);                                        

        //Maestro
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MAESTRO);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.MAESTRO), groups.length);                                        

        //Mastercard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MASTERCARD);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.MASTERCARD), groups.length);                                        

        //Solo
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SOLO);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.SOLO), groups.length);                                        

        //Switch
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SWITCH);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.SWITCH), groups.length);                                        

        //VISA
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.VISA), groups.length);                                        

        //VISA Electron
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA_ELECTRON);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.VISA_ELECTRON), groups.length);                                        

        //Unknown
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.UNKNOWN);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                CreditCardNetwork.UNKNOWN), groups.length);                                        

        //null
        groups = CreditCardValidator.groupingsForNetwork(null);
        assertEquals(CreditCardValidator.getNumberOfGroupsForNetwork(
                null), groups.length);                                                
    }
    
    @Test
    public void testGetMinDigitsForGroupAndNetwork() {
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.AMERICAN_EXPRESS);
        int numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.AMERICAN_EXPRESS), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Bankcard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.BANKCARD);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.BANKCARD), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.CHINA_UNIONPAY);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.CHINA_UNIONPAY), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) {}
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_ENROUTE);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Diners Club International
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Discover
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DISCOVER);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DISCOVER), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //InstaPayment        
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.INSTAPAYMENT);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.INSTAPAYMENT), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //JCB
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.JCB);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.JCB), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.JCB);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.JCB);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Laser
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.LASER);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.LASER), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.LASER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.LASER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Maestro
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MAESTRO);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.MAESTRO), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Mastercard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MASTERCARD);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.MASTERCARD), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Solo
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SOLO);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.SOLO), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Switch
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SWITCH);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.SWITCH), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //VISA
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.VISA), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.VISA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.VISA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //VISA Electron
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA_ELECTRON);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.VISA_ELECTRON), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Unknown
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.UNKNOWN);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.UNKNOWN), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //null
        groups = CreditCardValidator.groupingsForNetwork(null);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.UNKNOWN), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(-1, null);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMinDigitsForGroupAndNetwork(numGroups, null);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
    }

    @Test
    public void testGetMaxDigitsForGroupAndNetwork() {
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.AMERICAN_EXPRESS);
        int numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.AMERICAN_EXPRESS), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Bankcard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.BANKCARD);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.BANKCARD), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.CHINA_UNIONPAY);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.CHINA_UNIONPAY), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_ENROUTE);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Diners Club International
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DINERS_CLUB_USA_CANADA);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Discover
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.DISCOVER);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.DISCOVER), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //InstaPayment        
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.INSTAPAYMENT);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.INSTAPAYMENT), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //JCB
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.JCB);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.JCB), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.JCB);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.JCB);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Laser
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.LASER);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.LASER), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.LASER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.LASER);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Maestro
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MAESTRO);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.MAESTRO), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Mastercard
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.MASTERCARD);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.MASTERCARD), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Solo
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SOLO);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.SOLO), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //Switch
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.SWITCH);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.SWITCH), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //VISA
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.VISA), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.VISA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.VISA);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //VISA Electron
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.VISA_ELECTRON);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.VISA_ELECTRON), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        
        //Unknown
        groups = CreditCardValidator.groupingsForNetwork(
                CreditCardNetwork.UNKNOWN);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.UNKNOWN), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, 
                    CreditCardNetwork.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, 
                    CreditCardNetwork.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }

        //null
        groups = CreditCardValidator.groupingsForNetwork(null);
        numGroups = groups.length;
        for (int i = 0; i < numGroups; i++) {
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndNetwork(i, 
                    CreditCardNetwork.UNKNOWN), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(-1, null);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
        try {
            CreditCardValidator.getMaxDigitsForGroupAndNetwork(numGroups, null);
            fail("IllegalArgumentException expected but not thrown");
        } catch (IllegalArgumentException ignore) { }
    }
}
