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

public class CreditCardBrandTest {
    
    public CreditCardBrandTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}
    
    @Test
    public void testOrdinals(){
        assertEquals(CreditCardBrand.AMERICAN_EXPRESS.ordinal(), 0);
        assertEquals(CreditCardBrand.BANKCARD.ordinal(), 1);
        assertEquals(CreditCardBrand.CHINA_UNIONPAY.ordinal(), 2);
        assertEquals(CreditCardBrand.DINERS_CLUB_CARTE_BLANCHE.ordinal(), 3);
        assertEquals(CreditCardBrand.DINERS_CLUB_ENROUTE.ordinal(), 4);
        assertEquals(CreditCardBrand.DINERS_CLUB_INTERNATIONAL.ordinal(), 5);
        assertEquals(CreditCardBrand.DINERS_CLUB_USA_CANADA.ordinal(), 6);
        assertEquals(CreditCardBrand.DISCOVER.ordinal(), 7);
        assertEquals(CreditCardBrand.INSTAPAYMENT.ordinal(), 8);
        assertEquals(CreditCardBrand.JCB.ordinal(), 9);
        assertEquals(CreditCardBrand.LASER.ordinal(), 10);
        assertEquals(CreditCardBrand.MAESTRO.ordinal(), 11);
        assertEquals(CreditCardBrand.MASTERCARD.ordinal(), 12);
        assertEquals(CreditCardBrand.SOLO.ordinal(), 13);
        assertEquals(CreditCardBrand.SWITCH.ordinal(), 14);
        assertEquals(CreditCardBrand.VISA.ordinal(), 15);
        assertEquals(CreditCardBrand.VISA_ELECTRON.ordinal(), 16);
        assertEquals(CreditCardBrand.UNKNOWN.ordinal(), 17);
    }
}
