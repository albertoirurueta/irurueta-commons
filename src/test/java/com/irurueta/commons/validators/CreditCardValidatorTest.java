/**
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardValidatorTest {
    
    public CreditCardValidatorTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}

    @Test
    public void testConstructor(){
        assertNotNull(new CreditCardValidator());
    }
    
    @Test
    public void testIsValidMII(){
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
        assertFalse(CreditCardValidator.isValidMII((byte[])null));
    }
    
    @Test
    public void testIsValidationEnabledForBrand(){
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.AMERICAN_EXPRESS), 
                CreditCardValidator.AMEX_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.BANKCARD),
                CreditCardValidator.BANKCARD_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.CHINA_UNIONPAY),
                CreditCardValidator.CHINA_UNIONPAY_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE),
                CreditCardValidator.DINERS_CLUB_CARTE_BLANCHE_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.DINERS_CLUB_ENROUTE),
                CreditCardValidator.DINERS_CLUB_ENROUTE_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL),
                CreditCardValidator.DINERS_CLUB_INTERATIONAL_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.DINERS_CLUB_USA_CANADA),
                CreditCardValidator.DINERS_CLUB_USA_CA_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.DISCOVER),
                CreditCardValidator.DISCOVER_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.INSTAPAYMENT),
                CreditCardValidator.INSTAPAYMENT_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.JCB),
                CreditCardValidator.JCB_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.LASER),
                CreditCardValidator.LASER_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.MAESTRO),
                CreditCardValidator.MAESTRO_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.MASTERCARD),
                CreditCardValidator.MASTERCARD_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.SOLO),
                CreditCardValidator.SOLO_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.SWITCH),
                CreditCardValidator.SWITCH_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.VISA),
                CreditCardValidator.VISA_HAS_VALIDATION);
        assertEquals(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.VISA_ELECTRON),
                CreditCardValidator.VISA_ELECTRON_HAS_VALIDATION);
        assertFalse(CreditCardValidator.isValidationEnabledForBrand(
                CreditCardBrand.UNKNOWN));
        assertFalse(CreditCardValidator.isValidationEnabledForBrand(null));
    }
    
    @Test
    public void testIsBrandActive(){
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.AMERICAN_EXPRESS),
                CreditCardValidator.AMEX_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.BANKCARD),
                CreditCardValidator.BANKCARD_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.CHINA_UNIONPAY),
                CreditCardValidator.CHINA_UNIONPAY_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE),
                CreditCardValidator.DINERS_CLUB_CARTE_BLANCHE_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.DINERS_CLUB_ENROUTE),
                CreditCardValidator.DINERS_CLUB_ENROUTE_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL),
                CreditCardValidator.DINERS_CLUB_INTERATIONAL_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.DINERS_CLUB_USA_CANADA),
                CreditCardValidator.DINERS_CLUB_USA_CA_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.DISCOVER),
                CreditCardValidator.DISCOVER_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.INSTAPAYMENT),
                CreditCardValidator.INSTAPAYMENT_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.JCB),
                CreditCardValidator.JCB_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.LASER),
                CreditCardValidator.LASER_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.MAESTRO),
                CreditCardValidator.MAESTRO_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.MASTERCARD),
                CreditCardValidator.MASTERCARD_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.SOLO),
                CreditCardValidator.SOLO_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.SWITCH),
                CreditCardValidator.SWITCH_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.VISA),
                CreditCardValidator.VISA_IS_ACTIVE);
        assertEquals(CreditCardValidator.isBrandActive(
                CreditCardBrand.VISA_ELECTRON),
                CreditCardValidator.VISA_ELECTRON_IS_ACTIVE);
        assertTrue(CreditCardValidator.isBrandActive(CreditCardBrand.UNKNOWN));
        assertTrue(CreditCardValidator.isBrandActive(null));
    }
    
    @Test
    public void testDetectBrandFromPAN(){
        //test for typical credit card test PANs
        
        //VISA
        String pan = "4111 1111 1111 1111";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan), 
                CreditCardBrand.VISA);
        pan = "4005 5192 0000 0004";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4009-3488-8888-1881";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4012000033330026";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4012000077777777";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4012888888881881";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4217651111111119";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "4500600000000061";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.detectBrandFromPAN(pan) ==
                CreditCardBrand.MASTERCARD || 
                CreditCardValidator.detectBrandFromPAN(pan) == 
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        
        pan = "3782 82246 310005";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.AMERICAN_EXPRESS);
        pan = "371449635398431";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.AMERICAN_EXPRESS);
        
        pan = "6011111111111117";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        
        pan = "3530111333300000";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);
        
        //test for credit card IINs (this can be used to detect brand while PAN
        //is being typed
        
        //American Express
        pan = "34";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.AMERICAN_EXPRESS);
        pan = "37";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.AMERICAN_EXPRESS);
        
        //Bankcard
        pan = "5610";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        pan = "560221";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        pan = "560222";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        pan = "560223";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        pan = "560224";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        pan = "560225";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.BANKCARD);
        
        //China UnionPay
        //62 is not enough to determine if it belongs to China UnionPay, as it
        //could also be from Discover, so we use ranges of 62 outside of 
        //Discover
        pan = "620";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.CHINA_UNIONPAY);
        pan = "621";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.CHINA_UNIONPAY);
        pan = "623";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.CHINA_UNIONPAY);
        
        //Diners Club Carte Blanche
        pan = "300";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        pan = "301";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        pan = "302";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        pan = "303";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        pan = "304";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);        
        pan = "305";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        
        //Diners Club Enroute
        pan = "2014";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_ENROUTE);
        pan = "2149";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_ENROUTE);
        
        //Diners Club International
        pan = "36";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
        
        //Diners Club USA & Canda
        pan = "54";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        pan = "55";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        
        //Discover
        pan = "6011";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        pan = "622126";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        pan = "6223";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6224";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6225";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6226";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6227";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6228";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "6229";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "62295";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        pan = "644";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        pan = "645";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "646";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "647";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "648";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);        
        pan = "649";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        pan = "65";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.DISCOVER);
        
        //InstaPayment
        pan = "637";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.INSTAPAYMENT);
        pan = "638";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.INSTAPAYMENT);        
        pan = "639";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.INSTAPAYMENT);
        
        //JCB
        pan = "3528";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);
        pan = "3538";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);        
        pan = "3548";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);                
        pan = "3558";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);                
        pan = "3568";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);                
        pan = "3578";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);                
        pan = "3588";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);                
        pan = "3589";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.JCB);
        
        //Laser
        pan = "6304";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.LASER);
        pan = "6706";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.LASER);
        pan = "6771";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.LASER);
        pan = "6709";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.LASER);
        
        //Maestro
        pan = "5018";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "5020";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "5038";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "5893";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "6759";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "6761";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "6762";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);        
        pan = "6763";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        pan = "0604";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MAESTRO);
        
        //Mastercard
        pan = "51";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MASTERCARD);
        pan = "52";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MASTERCARD);        
        pan = "53";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.MASTERCARD);
        
        //Solo
        pan = "6334";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SOLO);
        pan = "6767";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SOLO);
        
        pan = "4903";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "4905";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "4911";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "4936";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "564182";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "633110";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        pan = "6333";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.SWITCH);
        
        //VISA
        pan = "400";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "410";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "42";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "43";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);
        pan = "441";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);        
        pan = "451";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);        
        pan = "46";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);        
        pan = "47";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);        
        pan = "481";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);        
        pan = "492";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA);  
        
        //VISA Electron
        pan = "4026";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "417500";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "4405";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "4508";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "4844";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "4913";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
        pan = "4917";
        assertEquals(CreditCardValidator.detectBrandFromPAN(pan),
                CreditCardBrand.VISA_ELECTRON);
    }
    
    @Test
    public void testIsValidLength(){
        //test for typical credit card test PANs
        
        //VISA
        String pan = "4111 1111 1111 1111";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "4005 5192 0000 0004";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4009-3488-8888-1881";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012000033330026";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012000077777777";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4012888888881881";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4217651111111119";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4500600000000061";
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(pan));
        assertTrue(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DINERS_CLUB_USA_CANADA));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertTrue(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3782 82246 310005";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.AMERICAN_EXPRESS));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "371449635398431";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.AMERICAN_EXPRESS));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertTrue(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "6011111111111117";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertTrue(CreditCardValidator.isDiscoverValidLength(pan));
        assertTrue(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));
        
        pan = "3530111333300000";
        assertTrue(CreditCardValidator.isValidLength(pan));
        assertTrue(CreditCardValidator.isValidLength(pan, CreditCardBrand.JCB));
        assertTrue(CreditCardValidator.isJCBValidLength(pan));
        assertTrue(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //test for credit card IINs (this can be used to detect brand while PAN
        //is being typed
        
        //American Express
        pan = "34";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.AMERICAN_EXPRESS));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "37";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.AMERICAN_EXPRESS));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(pan));
        assertFalse(CreditCardValidator.isAmericanExpressValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Bankcard
        pan = "5610";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "560221";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560222";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560223";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560224";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
        assertFalse(CreditCardValidator.isBankcardValidLength(pan));
        assertFalse(CreditCardValidator.isBankcardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "560225";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.BANKCARD));
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
                CreditCardBrand.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "621";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "623";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.CHINA_UNIONPAY));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(pan));
        assertFalse(CreditCardValidator.isChinaUnionPayValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Diners Club Carte Blanche
        pan = "300";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "301";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "302";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "303";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "304";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        pan = "305";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubCarteBlancheValidLength(
                CreditCardValidator.toDigits(pan)));                
        
        //Diners Club Enroute
        pan = "2014";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DINERS_CLUB_ENROUTE));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "2149";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DINERS_CLUB_ENROUTE));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubEnrouteValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Diners Club International
        pan = "36";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL));
        assertFalse(CreditCardValidator.isDinersClubInternationalValidLength(
                pan));
        assertFalse(CreditCardValidator.isDinersClubInternationalValidLength(
                CreditCardValidator.toDigits(pan)));
        
        //Diners Club USA & Canda
        pan = "54";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DINERS_CLUB_USA_CANADA));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "55";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DINERS_CLUB_USA_CANADA));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(pan));
        assertFalse(CreditCardValidator.isDinersClubUSACanadaValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Discover
        pan = "6011";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "622126";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6223";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6224";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6225";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6226";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6227";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6228";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6229";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "62295";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "644";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "645";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "646";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "647";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "648";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "649";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "65";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.DISCOVER));
        assertFalse(CreditCardValidator.isDiscoverValidLength(pan));
        assertFalse(CreditCardValidator.isDiscoverValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //InstaPayment
        pan = "637";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "638";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "639";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.INSTAPAYMENT));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(pan));
        assertFalse(CreditCardValidator.isInstaPaymentValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //JCB
        pan = "3528";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "3538";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3548";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3558";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3568";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3578";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3588";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "3589";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.JCB));
        assertFalse(CreditCardValidator.isJCBValidLength(pan));
        assertFalse(CreditCardValidator.isJCBValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Laser
        pan = "6304";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "6706";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6771";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6709";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.LASER));
        assertFalse(CreditCardValidator.isLaserValidLength(pan));
        assertFalse(CreditCardValidator.isLaserValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Maestro
        pan = "5018";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "5020";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "5038";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "5893";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6759";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6761";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6762";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6763";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "0604";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MAESTRO));
        assertFalse(CreditCardValidator.isMaestroValidLength(pan));
        assertFalse(CreditCardValidator.isMaestroValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Mastercard
        pan = "51";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "52";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "53";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.MASTERCARD));
        assertFalse(CreditCardValidator.isMastercardValidLength(pan));
        assertFalse(CreditCardValidator.isMastercardValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //Solo
        pan = "6334";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.SOLO));
        assertFalse(CreditCardValidator.isSoloValidLength(pan));
        assertFalse(CreditCardValidator.isSoloValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "6767";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.SOLO));
        assertFalse(CreditCardValidator.isSoloValidLength(pan));
        assertFalse(CreditCardValidator.isSoloValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        pan = "4903";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "4905";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4911";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4936";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "564182";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "633110";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "6333";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan,
                CreditCardBrand.SWITCH));
        assertFalse(CreditCardValidator.isSwitchValidLength(pan));
        assertFalse(CreditCardValidator.isSwitchValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //VISA
        pan = "400";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "410";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "42";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "43";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "441";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "451";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "46";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "47";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "481";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "492";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA));
        assertFalse(CreditCardValidator.isVISAValidLength(pan));
        assertFalse(CreditCardValidator.isVISAValidLength(
                CreditCardValidator.toDigits(pan)));        
        
        //VISA Electron
        pan = "4026";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));
        pan = "417500";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4405";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4508";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4844";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4913";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
        pan = "4917";
        assertFalse(CreditCardValidator.isValidLength(pan));
        assertFalse(CreditCardValidator.isValidLength(pan, 
                CreditCardBrand.VISA_ELECTRON));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(pan));
        assertFalse(CreditCardValidator.isVISAElectronValidLength(
                CreditCardValidator.toDigits(pan)));        
    }
    
    @Test
    public void testIsValid(){
        //VISA
        String pan = "4111 1111 1111 1111";
        assertTrue(CreditCardValidator.isValid(pan));
        pan = "4111 1111 1111 1112";
        assertFalse(CreditCardValidator.isValid(pan));
        
        pan = "4005 5192 0000 0004";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4005 5192 0000 0005";
        assertFalse(CreditCardValidator.isValid(pan));
        
        pan = "4009-3488-8888-1881";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4009-3488-8888-1882";
        assertFalse(CreditCardValidator.isValid(pan));
        
        pan = "4012000033330026";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4012000033330027";
        assertFalse(CreditCardValidator.isValid(pan));
        
        pan = "4012000077777777";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4012000077777778";
        assertFalse(CreditCardValidator.isValid(pan));
        
        pan = "4012888888881881";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4012888888881882";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "4217651111111119";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4217651111111118";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "4500600000000061";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "4500600000000062";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "5555555555554444";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "5555555555554445";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "3782 82246 310005";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "3782 82246 310006";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "371449635398431";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "371449635398432";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "6011111111111117";
        assertTrue(CreditCardValidator.isValid(pan));        
        pan = "6011111111111118";
        assertFalse(CreditCardValidator.isValid(pan));        
        
        pan = "3530111333300000";
        assertTrue(CreditCardValidator.isValid(pan));                
        pan = "3530111333300001";
        assertFalse(CreditCardValidator.isValid(pan));        
    }
    
    @Test
    public void testIsAmericanExpressIIN(){
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
    public void testIsBankcardIIN(){
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
    public void testIsChinaUnionPayIIN(){
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
    public void testIsDinersClubCarteBlancheIIN(){
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
    public void testIsDinersClubEnrouteIIN(){
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
    public void testIsDinersClubInternationalIIN(){
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
    public void testIsDinersClubUSACanadaIIN(){
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
    public void testIsDiscoverIIN(){
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
    public void testIsInstaPaymentIIN(){
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
    public void testIsJCBIIN(){
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
    public void testIsLaserIIN(){
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
    public void testIsMaestroIIN(){
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
    public void testIsMastercardIIN(){
        String pan = "51";
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
    public void testIsSoloIIN(){
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
    public void testIsSwitchIIN(){
        
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
    public void testIsVISAIIN(){
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
    public void testIsVISAElectronIIN(){
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
    public void testGetNumberOfGroupsForBrand(){
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.AMERICAN_EXPRESS);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.AMERICAN_EXPRESS), groups.length);
        
        //Bankcard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.BANKCARD);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.BANKCARD), groups.length);
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.CHINA_UNIONPAY);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.CHINA_UNIONPAY), groups.length);        
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE), groups.length);                
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_ENROUTE);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.DINERS_CLUB_ENROUTE), groups.length);                

        //Diners Club International
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL), groups.length);                

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.DINERS_CLUB_USA_CANADA), groups.length);                        
        
        //Discover
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DISCOVER);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.DISCOVER), groups.length);                                
        
        //InstaPayment
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.INSTAPAYMENT);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.INSTAPAYMENT), groups.length);                                        
        
        //JCB
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.JCB);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.JCB), groups.length);                                        

        //Laser
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.LASER);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.LASER), groups.length);                                        

        //Maestro
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MAESTRO);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.MAESTRO), groups.length);                                        

        //Mastercard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MASTERCARD);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.MASTERCARD), groups.length);                                        

        //Solo
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SOLO);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.SOLO), groups.length);                                        

        //Switch
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SWITCH);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.SWITCH), groups.length);                                        

        //VISA
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.VISA), groups.length);                                        

        //VISA Electron
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA_ELECTRON);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.VISA_ELECTRON), groups.length);                                        

        //Unknown
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.UNKNOWN);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                CreditCardBrand.UNKNOWN), groups.length);                                        

        //null
        groups = CreditCardValidator.groupingsForBrand(null);
        assertEquals(CreditCardValidator.getNumberOfGroupsForBrand(
                null), groups.length);                                                
    }
    
    @Test
    public void testGetMinDigitsForGroupAndBrand(){
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.AMERICAN_EXPRESS);
        int numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.AMERICAN_EXPRESS), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Bankcard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.BANKCARD);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.BANKCARD), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.CHINA_UNIONPAY);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.CHINA_UNIONPAY), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_ENROUTE);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Diners Club International
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Discover
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DISCOVER);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DISCOVER), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //InstaPayment        
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.INSTAPAYMENT);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.INSTAPAYMENT), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //JCB
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.JCB);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.JCB), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.JCB);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.JCB);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Laser
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.LASER);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.LASER), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.LASER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.LASER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Maestro
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MAESTRO);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.MAESTRO), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Mastercard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MASTERCARD);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.MASTERCARD), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Solo
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SOLO);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.SOLO), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Switch
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SWITCH);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.SWITCH), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //VISA
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.VISA), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.VISA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.VISA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //VISA Electron
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA_ELECTRON);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.VISA_ELECTRON), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Unknown
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.UNKNOWN);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.UNKNOWN), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //null
        groups = CreditCardValidator.groupingsForBrand(null);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMinDigitsForGroupAndBrand(i, 
                    CreditCardBrand.UNKNOWN), groups[i][0]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(-1, null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMinDigitsForGroupAndBrand(numGroups, null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
    }

    @Test
    public void testGetMaxDigitsForGroupAndBrand(){
        //American Express
        byte[][] groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.AMERICAN_EXPRESS);
        int numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.AMERICAN_EXPRESS), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.AMERICAN_EXPRESS);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Bankcard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.BANKCARD);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.BANKCARD), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.BANKCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //China UnionPay
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.CHINA_UNIONPAY);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.CHINA_UNIONPAY), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.CHINA_UNIONPAY);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Diners Club Carte Blanche
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Diners Club Enroute
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_ENROUTE);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_ENROUTE);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Diners Club International
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_INTERNATIONAL);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Diners Club USA & Canada
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DINERS_CLUB_USA_CANADA);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DINERS_CLUB_USA_CANADA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Discover
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.DISCOVER);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.DISCOVER), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.DISCOVER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //InstaPayment        
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.INSTAPAYMENT);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.INSTAPAYMENT), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.INSTAPAYMENT);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //JCB
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.JCB);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.JCB), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.JCB);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.JCB);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Laser
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.LASER);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.LASER), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.LASER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.LASER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Maestro
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MAESTRO);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.MAESTRO), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.MAESTRO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Mastercard
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.MASTERCARD);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.MASTERCARD), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.MASTERCARD);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Solo
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SOLO);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.SOLO), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.SOLO);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //Switch
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.SWITCH);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.SWITCH), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.SWITCH);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //VISA
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.VISA), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.VISA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.VISA);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //VISA Electron
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.VISA_ELECTRON);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.VISA_ELECTRON), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.VISA_ELECTRON);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        
        //Unknown
        groups = CreditCardValidator.groupingsForBrand(
                CreditCardBrand.UNKNOWN);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.UNKNOWN), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, 
                    CreditCardBrand.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, 
                    CreditCardBrand.UNKNOWN);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}

        //null
        groups = CreditCardValidator.groupingsForBrand(null);
        numGroups = groups.length;
        for(int i = 0; i < numGroups; i++){
            assertEquals(CreditCardValidator.getMaxDigitsForGroupAndBrand(i, 
                    CreditCardBrand.UNKNOWN), groups[i][1]);
        }
        
        //Force IllegalArgumentException
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(-1, null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            CreditCardValidator.getMaxDigitsForGroupAndBrand(numGroups, null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}        
    }
}
