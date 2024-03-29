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

import org.junit.Test;

import static org.junit.Assert.*;

public class RFCValidatorTest {

    @Test
    public void testConstructor() {
        //noinspection ObviousNullCheck,InstantiationOfUtilityClass,InstantiationOfUtilityClass
        assertNotNull(new RFCValidator());
    }

    @Test
    public void testIsValid() {
        assertTrue(RFCValidator.isValid("CUPU800825569"));

        assertFalse(RFCValidator.isValid("CU800825569"));
        assertFalse(RFCValidator.isValid("CUPU8AA825569"));
        assertFalse(RFCValidator.isValid("CUPU8008255AAA"));

        //noinspection ConstantConditions
        assertFalse(RFCValidator.isValid(null));
    }
}
