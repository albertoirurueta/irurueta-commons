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
package com.irurueta.commons;

import com.irurueta.commons.validators.CreditCardNetwork;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PanMaskGeneratorTest {
    
    public PanMaskGeneratorTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }
    
    @Test
    public void testGenerate() {
        //cards with known grouping
        assertEquals(PanMaskGenerator.generate(
                CreditCardNetwork.AMERICAN_EXPRESS, '*', '_'),
                "****_******_*****");
        assertEquals(PanMaskGenerator.generate(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '*', '_'),
                "****_******_****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.DISCOVER, 
                '*', '_'), "****_****_****_****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.MASTERCARD, 
                '*', '_'), "****_****_****_****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.VISA, '*', 
                '_'), "****_****_****_****");
        assertEquals(PanMaskGenerator.generate(
                CreditCardNetwork.VISA_ELECTRON, '*', '_'),
                "****_****_****_****");

        //other types of cards
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.JCB, '*', '_'),
                "****_****_****_*******");
        assertEquals(PanMaskGenerator.generate((CreditCardNetwork) null, '*', 
                '_'), "****_****_****_*******");                
    }
    
    @Test
    public void testGenerateWithDefaultSeparatorChar() {
        //cards with known grouping
        assertEquals(PanMaskGenerator.generate(
                CreditCardNetwork.AMERICAN_EXPRESS, '*'), "**** ****** *****");
        assertEquals(PanMaskGenerator.generate(
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '*'),
                "**** ****** ****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.DISCOVER, 
                '*'), "**** **** **** ****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.MASTERCARD, 
                '*'), "**** **** **** ****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.VISA, '*'), 
                "**** **** **** ****");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.VISA_ELECTRON, 
                '*'), "**** **** **** ****");

        //other types of cards
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.JCB, '*'),
                "**** **** **** *******");
        assertEquals(PanMaskGenerator.generate((CreditCardNetwork) null, '*'), 
                "**** **** **** *******");                        
    }
    
    @Test
    public void testGenerateWithDefaultMaskChar() {
        //cards with known grouping
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.AMERICAN_EXPRESS),
                "#### ###### #####");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.DINERS_CLUB_INTERNATIONAL),
                "#### ###### ####");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.DISCOVER),
                "#### #### #### ####");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.MASTERCARD),
                "#### #### #### ####");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.VISA),
                "#### #### #### ####");
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.VISA_ELECTRON),
                "#### #### #### ####");

        //other types of cards
        assertEquals(PanMaskGenerator.generate(CreditCardNetwork.JCB),
                "#### #### #### #######");
        assertEquals(PanMaskGenerator.generate((CreditCardNetwork)null),
                "#### #### #### #######");        
    }
}
