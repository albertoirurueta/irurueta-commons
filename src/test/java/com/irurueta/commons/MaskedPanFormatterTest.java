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

public class MaskedPanFormatterTest {
    
    public MaskedPanFormatterTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }

    @Test
    public void testFormat() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061", 
                CreditCardNetwork.VISA, '·', '_'), "····_····_····_0061");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("5555555555554444",
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·', '_'), 
                "····_······_4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005",
                CreditCardNetwork.AMERICAN_EXPRESS, '·', '_'), 
                "····_······_·0005");
        assertEquals(MaskedPanFormatter.format("371449635398431",
                CreditCardNetwork.AMERICAN_EXPRESS, '·', '_'), 
                "····_······_·8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117", 
                CreditCardNetwork.DISCOVER, '·', '_'), "····_····_····_1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444", 
                CreditCardNetwork.MASTERCARD, '·', '_'), "····_····_····_4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000", 
                CreditCardNetwork.JCB, '·', '_'), "····_····_····_···0000");



        //try now only last digits

        //VISA
        assertEquals(MaskedPanFormatter.format("1111", CreditCardNetwork.VISA, 
                '·', '_'), "····_····_····_1111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("4444", 
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·', '_'), 
                "····_······_4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("0005", 
                CreditCardNetwork.AMERICAN_EXPRESS, '·', '_'),
                "····_······_·0005");

        //Discover
        assertEquals(MaskedPanFormatter.format("1117", 
                CreditCardNetwork.DISCOVER, '·', '_'), "····_····_····_1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("4444", 
                CreditCardNetwork.MASTERCARD, '·', '_'), "····_····_····_4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("0000", CreditCardNetwork.JCB, 
                '·', '_'), "····_····_····_···0000");


        //try a smaller number of digits (only available digits are displayed)

        //VISA
        assertEquals(MaskedPanFormatter.format("111", CreditCardNetwork.VISA, 
                '·', '_'), "····_····_····_·111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("444", 
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·', '_'), 
                "····_······_·444");

        //American Express
        assertEquals(MaskedPanFormatter.format("005", 
                CreditCardNetwork.AMERICAN_EXPRESS, '·', '_'), 
                "····_······_··005");

        //Discover
        assertEquals(MaskedPanFormatter.format("117", 
                CreditCardNetwork.DISCOVER, '·', '_'), "····_····_····_·117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("444", 
                CreditCardNetwork.MASTERCARD, '·', '_'), "····_····_····_·444");

        //JCB
        assertEquals(MaskedPanFormatter.format("000", CreditCardNetwork.JCB, 
                '·', '_'), "····_····_····_····000");        
    }
    
    @Test
    public void testFormatWithDefaultSeparatorChar() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061", 
                CreditCardNetwork.VISA, '·'), "···· ···· ···· 0061");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("5555555555554444",
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·'), 
                "···· ······ 4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005",
                CreditCardNetwork.AMERICAN_EXPRESS, '·'), "···· ······ ·0005");
        assertEquals(MaskedPanFormatter.format("371449635398431",
                CreditCardNetwork.AMERICAN_EXPRESS, '·'), "···· ······ ·8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117", 
                CreditCardNetwork.DISCOVER, '·'), "···· ···· ···· 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444", 
                CreditCardNetwork.MASTERCARD, '·'), "···· ···· ···· 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000", 
                CreditCardNetwork.JCB, '·'), "···· ···· ···· ···0000");



        //try now only last digits

        //VISA
        assertEquals(MaskedPanFormatter.format("1111", CreditCardNetwork.VISA, 
                '·'), "···· ···· ···· 1111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("4444", 
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·'), 
                "···· ······ 4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("0005", 
                CreditCardNetwork.AMERICAN_EXPRESS, '·'), "···· ······ ·0005");

        //Discover
        assertEquals(MaskedPanFormatter.format("1117", 
                CreditCardNetwork.DISCOVER, '·'), "···· ···· ···· 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("4444", 
                CreditCardNetwork.MASTERCARD, '·'), "···· ···· ···· 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("0000", CreditCardNetwork.JCB, 
                '·'), "···· ···· ···· ···0000");


        //try a smaller number of digits (only available digits are displayed)

        //VISA
        assertEquals(MaskedPanFormatter.format("111", CreditCardNetwork.VISA, 
                '·'), "···· ···· ···· ·111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("444", 
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL, '·'), 
                "···· ······ ·444");

        //American Express
        assertEquals(MaskedPanFormatter.format("005", 
                CreditCardNetwork.AMERICAN_EXPRESS, '·'), 
                "···· ······ ··005");

        //Discover
        assertEquals(MaskedPanFormatter.format("117", 
                CreditCardNetwork.DISCOVER, '·'), "···· ···· ···· ·117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("444", 
                CreditCardNetwork.MASTERCARD, '·'), "···· ···· ···· ·444");

        //JCB
        assertEquals(MaskedPanFormatter.format("000", CreditCardNetwork.JCB, 
                '·'), "···· ···· ···· ····000");        
        
    }
    
    @Test
    public void testFormatWithDefaultMaskChar() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111", CreditCardNetwork.VISA),
                "**** **** **** 1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004", CreditCardNetwork.VISA),
                "**** **** **** 0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881", CreditCardNetwork.VISA),
                "**** **** **** 1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026", CreditCardNetwork.VISA),
                "**** **** **** 0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777", CreditCardNetwork.VISA),
                "**** **** **** 7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881", CreditCardNetwork.VISA),
                "**** **** **** 1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119", CreditCardNetwork.VISA),
                "**** **** **** 1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061", CreditCardNetwork.VISA),
                "**** **** **** 0061");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("5555555555554444",
                CreditCardNetwork.DINERS_CLUB_INTERNATIONAL), "**** ****** 4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005",
                CreditCardNetwork.AMERICAN_EXPRESS), "**** ****** *0005");
        assertEquals(MaskedPanFormatter.format("371449635398431",
                CreditCardNetwork.AMERICAN_EXPRESS), "**** ****** *8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117", CreditCardNetwork.DISCOVER),
                "**** **** **** 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444", CreditCardNetwork.MASTERCARD),
                "**** **** **** 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000", CreditCardNetwork.JCB),
                "**** **** **** ***0000");



        //try now only last digits

        //VISA
        assertEquals(MaskedPanFormatter.format("1111", CreditCardNetwork.VISA),
                "**** **** **** 1111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("4444", CreditCardNetwork.DINERS_CLUB_INTERNATIONAL),
                "**** ****** 4444");

        //American Express
        assertEquals(MaskedPanFormatter.format("0005", CreditCardNetwork.AMERICAN_EXPRESS),
                "**** ****** *0005");

        //Discover
        assertEquals(MaskedPanFormatter.format("1117", CreditCardNetwork.DISCOVER),
                "**** **** **** 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("4444", CreditCardNetwork.MASTERCARD),
                "**** **** **** 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("0000", CreditCardNetwork.JCB),
                "**** **** **** ***0000");


        //try a smaller number of digits (only available digits are displayed)

        //VISA
        assertEquals(MaskedPanFormatter.format("111", CreditCardNetwork.VISA),
                "**** **** **** *111");

        //Diners Club
        assertEquals(MaskedPanFormatter.format("444", CreditCardNetwork.DINERS_CLUB_INTERNATIONAL),
                "**** ****** *444");

        //American Express
        assertEquals(MaskedPanFormatter.format("005", CreditCardNetwork.AMERICAN_EXPRESS),
                "**** ****** **005");

        //Discover
        assertEquals(MaskedPanFormatter.format("117", CreditCardNetwork.DISCOVER),
                "**** **** **** *117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("444", CreditCardNetwork.MASTERCARD),
                "**** **** **** *444");

        //JCB
        assertEquals(MaskedPanFormatter.format("000", CreditCardNetwork.JCB),
                "**** **** **** ****000");
    }
   
    @Test
    public void testFormatWithIINDetection() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111", '·', '_'),
                "····_····_····_1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004", '·', '_'),
                "····_····_····_0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881", '·', '_'),
                "····_····_····_1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026", '·', '_'), 
                "····_····_····_0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777", '·', '_'), 
                "····_····_····_7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881", '·', '_'), 
                "····_····_····_1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119", '·', '_'), 
                "····_····_····_1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061", '·', '_'), 
                "····_····_····_0061");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005", '·', '_'), 
                "····_······_·0005");
        assertEquals(MaskedPanFormatter.format("371449635398431", '·', '_'), 
                "····_······_·8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117", '·', '_'), 
                "····_····_····_1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444", '·', '_'), 
                "····_····_····_4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000", '·', '_'), 
                "····_····_····_···0000");        
    }
    
    @Test
    public void testFormatWithIINDetectionAndDefaultSeparatorChar() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111", '·'), 
                "···· ···· ···· 1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004", '·'), 
                "···· ···· ···· 0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881", '·'), 
                "···· ···· ···· 1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026", '·'), 
                "···· ···· ···· 0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777", '·'), 
                "···· ···· ···· 7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881", '·'), 
                "···· ···· ···· 1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119", '·'), 
                "···· ···· ···· 1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061", '·'), 
                "···· ···· ···· 0061");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005", '·'), 
                "···· ······ ·0005");
        assertEquals(MaskedPanFormatter.format("371449635398431", '·'), 
                "···· ······ ·8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117", '·'), 
                "···· ···· ···· 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444", '·'), 
                "···· ···· ···· 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000", '·'), 
                "···· ···· ···· ···0000");
    }
    
    @Test
    public void testFormatWithIINDetectionAndDefaultMaskChar() {
        //VISA
        assertEquals(MaskedPanFormatter.format("4111 1111 1111 1111"), 
                "**** **** **** 1111");
        assertEquals(MaskedPanFormatter.format("4005 5192 0000 0004"), 
                "**** **** **** 0004");
        assertEquals(MaskedPanFormatter.format("4009-3488-8888-1881"), 
                "**** **** **** 1881");
        assertEquals(MaskedPanFormatter.format("4012000033330026"), 
                "**** **** **** 0026");
        assertEquals(MaskedPanFormatter.format("4012000077777777"), 
                "**** **** **** 7777");
        assertEquals(MaskedPanFormatter.format("4012888888881881"), 
                "**** **** **** 1881");
        assertEquals(MaskedPanFormatter.format("4217651111111119"), 
                "**** **** **** 1119");
        assertEquals(MaskedPanFormatter.format("4500600000000061"), 
                "**** **** **** 0061");

        //American Express
        assertEquals(MaskedPanFormatter.format("3782 82246 310005"), 
                "**** ****** *0005");
        assertEquals(MaskedPanFormatter.format("371449635398431"), 
                "**** ****** *8431");

        //Discover
        assertEquals(MaskedPanFormatter.format("6011111111111117"), 
                "**** **** **** 1117");

        //MasterCard
        assertEquals(MaskedPanFormatter.format("5555555555554444"), 
                "**** **** **** 4444");

        //JCB
        assertEquals(MaskedPanFormatter.format("3530111333300000"), 
                "**** **** **** ***0000");
    }    
}
