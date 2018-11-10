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

import java.util.Locale;

import static org.junit.Assert.*;

public class ZipCodeValidatorTest {
    
    public ZipCodeValidatorTest() { }
    
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
        //test constructor with country code
        ZipCodeValidator validator = new ZipCodeValidator("ES");
        assertEquals(validator.getCountryCode(), "ES");

        //test constructor with Locale
        validator = new ZipCodeValidator(new Locale("es", "ES"));
        assertEquals(validator.getCountryCode(), "ES");
    }

    @Test
    public void testGetSetCountryCode() {
        ZipCodeValidator validator = new ZipCodeValidator("ES");

        //initial value
        assertEquals(validator.getCountryCode(), "ES");

        //new value
        validator.setCountryCode("FR");

        //check correctness
        assertEquals(validator.getCountryCode(), "FR");
    }

    @Test
    public void testSetCountryCodeFromLocale() {
        ZipCodeValidator validator = new ZipCodeValidator("ES");

        //initial value
        assertEquals(validator.getCountryCode(), "ES");

        //new value
        validator.setCountryCodeFrom(Locale.FRANCE);

        //check correctness
        assertEquals(validator.getCountryCode(), "FR");
    }

    @Test
    public void testIsValid() {
        //Spain
        ZipCodeValidator validator = new ZipCodeValidator("ES");

        //valid post code for Spain
        assertTrue(validator.isValid("08008"));

        //invalid post code for Spain
        assertFalse(validator.isValid("abcd"));


        //France
        validator.setCountryCode("FR");

        //valid post code for France
        assertTrue(validator.isValid("08008"));

        //invalid post code for France
        assertFalse(validator.isValid("abcd"));


        //Germany
        validator.setCountryCode("DE");

        //valid post code for Germany
        assertTrue(validator.isValid("08008"));

        //invalid post code for Germany
        assertFalse(validator.isValid("abcd"));


        //Italy
        validator.setCountryCode("IT");

        //valid post code for Italy
        assertTrue(validator.isValid("08008"));

        //invalid post code for Italy
        assertFalse(validator.isValid("abcd"));


        //Portugal
        validator.setCountryCode("PT");

        //valid post code for Portugal
        assertTrue(validator.isValid("1234-123"));

        //invalid post code for Portugal
        assertFalse(validator.isValid("abcd"));


        //United Kingdom
        validator.setCountryCode("GB");

        //valid post code for UK
        assertTrue(validator.isValid("SW1A 1AA"));

        //invalid post code for UK
        assertFalse(validator.isValid("invalid"));


        //Austria
        validator.setCountryCode("AT");

        //valid post code for Austria
        assertTrue(validator.isValid("1234"));

        //invalid post code for Austria
        assertFalse(validator.isValid("12345"));


        //Ireland
        validator.setCountryCode("IE");

        //valid post code for Ireland
        assertTrue(validator.isValid("1234"));

        //any value is always valid for Ireland
        assertTrue(validator.isValid("invalid"));


        //Belgium
        validator.setCountryCode("BE");

        //valid post code for Belgium
        assertTrue(validator.isValid("1234"));

        //invalid post code for Belgium
        assertFalse(validator.isValid("abcd"));


        //Netherlands
        validator.setCountryCode("NL");

        //valid post code for Netherlands
        assertTrue(validator.isValid("1234AB"));

        //invalid post code for Netherlands
        assertFalse(validator.isValid("abcd12"));


        //Luxembourg
        validator.setCountryCode("LU");

        //valid post code for Luxembourg
        assertTrue(validator.isValid("1234"));

        //invalid post code for Luxembourg
        assertFalse(validator.isValid("abcd"));


        //Monaco
        validator.setCountryCode("MC");

        //valid post code for Monaco
        assertTrue(validator.isValid("12345"));

        //invalid post code for Monaco
        assertFalse(validator.isValid("abcd"));


        //Switzerland
        validator.setCountryCode("CH");

        //valid post code for Switzerland
        assertTrue(validator.isValid("1234"));

        //invalid post code for Switzerland
        assertFalse(validator.isValid("abcd"));


        //Norway
        validator.setCountryCode("NO");

        //valid post code for Norway
        assertTrue(validator.isValid("1234"));

        //invalid post code for Norway
        assertFalse(validator.isValid("abcd"));


        //Denmark
        validator.setCountryCode("DK");

        //valid post code for Denmark
        assertTrue(validator.isValid("1234"));

        //invalid post code for Denmark
        assertFalse(validator.isValid("abcd"));


        //Sweden
        validator.setCountryCode("SE");

        //valid post code for Sweden
        assertTrue(validator.isValid("12345"));

        //invalid post code for Sweden
        assertFalse(validator.isValid("abcde"));


        //Finland
        validator.setCountryCode("FI");

        //valid post code for Finland
        assertTrue(validator.isValid("12345"));

        //invalid post code for Finland
        assertFalse(validator.isValid("1234"));


        //USA
        validator.setCountryCode("US");

        //valid post code for USA
        assertTrue(validator.isValid("02139"));

        //invalid post code for USA
        assertFalse(validator.isValid("invalid"));


        //Japan
        validator.setCountryCode("JP");

        //valid psot code for Japan
        assertTrue(validator.isValid("123-1234"));

        //invalid post code for Japan
        assertFalse(validator.isValid("abc-abcd"));


        //Poland
        validator.setCountryCode("PL");

        //valid post code for Poland
        assertTrue(validator.isValid("12-123"));

        //invalid post code for Poland
        assertFalse(validator.isValid("invalid"));


        //China
        validator.setCountryCode("CN");

        //valid post code for China
        assertTrue(validator.isValid("123456"));

        //invalid post code for China
        assertFalse(validator.isValid("invalid"));


        //Canada
        validator.setCountryCode("CA");

        //valid post code for Canada
        assertTrue(validator.isValid("A1B 2C3"));

        //invalid post code for Canada
        assertFalse(validator.isValid("invalid"));


        //Russia
        validator.setCountryCode("RU");

        //valid post code for Russia
        assertTrue(validator.isValid("123456"));

        //invalid post code for Russia
        assertFalse(validator.isValid("invalid"));


        //Greece
        validator.setCountryCode("GR");

        //valid post code for Greece
        assertTrue(validator.isValid("123 12"));

        //invalid post code for Greece
        assertFalse(validator.isValid("invalid"));


        //South Korea
        validator.setCountryCode("KR");

        //valid post code for South Korea
        assertTrue(validator.isValid("123-123"));

        //invalid post code for South Korea
        assertFalse(validator.isValid("invalid"));


        //Romania
        validator.setCountryCode("RO");

        //valid post code for Romania
        assertTrue(validator.isValid("123456"));

        //invalid post code for Romania
        assertFalse(validator.isValid("invalid"));


        //Mexico
        validator.setCountryCode("MX");

        //valid post code for Mexico
        assertTrue(validator.isValid("12345"));

        //invalid post code for Mexico
        assertFalse(validator.isValid("123.4"));
        assertFalse(validator.isValid("invalid"));


        //Taiwan
        validator.setCountryCode("TW");

        //valid post code for Taiwan
        assertTrue(validator.isValid("123"));

        //invalid post code for Taiwan
        assertFalse(validator.isValid("012"));
        assertFalse(validator.isValid("invalid"));


        //Macao
        validator.setCountryCode("MO");

        //valid post code for Macao
        assertTrue(validator.isValid("12345"));

        //invalid post code for Macao
        assertFalse(validator.isValid("invalid"));


        //Hong Kong
        validator.setCountryCode("HK");

        //valid post code for Hong Kong
        assertTrue(validator.isValid("12345"));

        //invalid post code for Hong Kong
        assertFalse(validator.isValid("invalid"));

        
        //Turkey
        validator.setCountryCode("TR");
        
        //valid post code for Turkey
        assertTrue(validator.isValid("12345"));
        
        //invalid post code for Turkey
        assertFalse(validator.isValid("invalid"));
        

        //Australia
        validator.setCountryCode("AU");

        //post codes are always valid
        assertTrue(validator.isValid("invalid"));

        //for a null country code, validator always returns true
        validator.setCountryCode(null);
        assertTrue(validator.isValid(null));

        //for a known country, a null post code always returns false
        validator.setCountryCode("ES");
        assertFalse(validator.isValid(null));
    }
}
