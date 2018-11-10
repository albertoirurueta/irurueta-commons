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

import static org.junit.Assert.assertEquals;

public class CreditCardNetworkTest {
    
    public CreditCardNetworkTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }
    
    @Test
    public void testOrdinals() {
        assertEquals(CreditCardNetwork.AMERICAN_EXPRESS.ordinal(), 0);
        assertEquals(CreditCardNetwork.BANKCARD.ordinal(), 1);
        assertEquals(CreditCardNetwork.CHINA_UNIONPAY.ordinal(), 2);
        assertEquals(CreditCardNetwork.DINERS_CLUB_CARTE_BLANCHE.ordinal(), 3);
        assertEquals(CreditCardNetwork.DINERS_CLUB_ENROUTE.ordinal(), 4);
        assertEquals(CreditCardNetwork.DINERS_CLUB_INTERNATIONAL.ordinal(), 5);
        assertEquals(CreditCardNetwork.DINERS_CLUB_USA_CANADA.ordinal(), 6);
        assertEquals(CreditCardNetwork.DISCOVER.ordinal(), 7);
        assertEquals(CreditCardNetwork.INSTAPAYMENT.ordinal(), 8);
        assertEquals(CreditCardNetwork.JCB.ordinal(), 9);
        assertEquals(CreditCardNetwork.LASER.ordinal(), 10);
        assertEquals(CreditCardNetwork.MAESTRO.ordinal(), 11);
        assertEquals(CreditCardNetwork.MASTERCARD.ordinal(), 12);
        assertEquals(CreditCardNetwork.SOLO.ordinal(), 13);
        assertEquals(CreditCardNetwork.SWITCH.ordinal(), 14);
        assertEquals(CreditCardNetwork.VISA.ordinal(), 15);
        assertEquals(CreditCardNetwork.VISA_ELECTRON.ordinal(), 16);
        assertEquals(CreditCardNetwork.UNKNOWN.ordinal(), 17);
    }
}
