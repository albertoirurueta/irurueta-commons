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

public class NIFValidatorTest {
    
    public static final String VALID_NIF = "22072532F";
    public static final String INVALID_NIF = "22072532E";
    public static final String VALID_NIE = "Y7921566N";
    public static final String INVALID_NIE1 = "A0744669N";
    public static final String INVALID_NIE2 = "Y0744669K";
    public static final String VALID_CIF = "A78018413";
    public static final String INVALID_CIF = "XX5636417";
        
    public NIFValidatorTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}

    @Test
    public void testIsValid() {
        assertTrue(NIFValidator.isValid(VALID_NIF));
        assertFalse(NIFValidator.isValid(INVALID_NIF));
        assertTrue(NIFValidator.isValid(VALID_NIE));
        assertFalse(NIFValidator.isValid(INVALID_NIE1));
        assertFalse(NIFValidator.isValid(INVALID_NIE2));
        assertTrue(NIFValidator.isValid(VALID_CIF));
        assertFalse(NIFValidator.isValid(INVALID_CIF));

        assertFalse(NIFValidator.isValid(null));
    }

    @Test
    public void testIsValidDNI() {
        assertFalse(NIFValidator.isValidDNI(VALID_NIF));

        assertFalse(NIFValidator.isValidDNI(null));
    }

    @Test
    public void testIsValidNIF() {
        assertTrue(NIFValidator.isValidNIF(VALID_NIF));
        assertFalse(NIFValidator.isValidNIF(INVALID_NIF));

        assertFalse(NIFValidator.isValidNIF(null));
    }

    @Test
    public void testIsValidNIFNonResidents() {
        assertFalse(NIFValidator.isValidNIFNonResidents(VALID_NIF));

        assertFalse(NIFValidator.isValidNIFNonResidents(null));
    }

    @Test
    public void testIsValidNIFMinors() {
        assertFalse(NIFValidator.isValidNIFMinors(VALID_NIF));

        assertFalse(NIFValidator.isValidNIFMinors(null));
    }

    @Test
    public void testIsValidNIE() {
            assertTrue(NIFValidator.isValidNIE(VALID_NIE));
            assertFalse(NIFValidator.isValidNIE(INVALID_NIE1));
            assertFalse(NIFValidator.isValidNIE(INVALID_NIE2));
    }

    @Test
    public void testIsValidCIF() {
            assertTrue(NIFValidator.isValidCIF(VALID_CIF));
            assertFalse(NIFValidator.isValidCIF(INVALID_CIF));
    }
}
