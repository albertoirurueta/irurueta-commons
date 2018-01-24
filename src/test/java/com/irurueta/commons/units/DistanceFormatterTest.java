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
package com.irurueta.commons.units;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistanceFormatterTest {
    
    public DistanceFormatterTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {
        DistanceFormatter formatter = DistanceFormatter.getInstance();
        formatter.setValueAndUnitFormatPattern(
                MeasureFormatter.DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN);
    }
    
    @Test
    public void testGetInstanceEqualsAndHash(){
        
        //check getInstance returns a singleton
        DistanceFormatter formatter1 = DistanceFormatter.getInstance();
        DistanceFormatter formatter2 = DistanceFormatter.getInstance();
        
        assertSame(formatter1, formatter2);        
        assertTrue(formatter1.equals(formatter2));
        assertEquals(formatter1.hashCode(), formatter2.hashCode());
        
        assertEquals(formatter1.getMaximumFractionDigits(), 
                NumberFormat.getInstance().getMaximumFractionDigits());
        assertEquals(formatter1.getMaximumIntegerDigits(),
                NumberFormat.getInstance().getMaximumIntegerDigits());
        assertEquals(formatter1.getMinimumFractionDigits(),
                NumberFormat.getInstance().getMinimumFractionDigits());
        assertEquals(formatter1.getMinimumIntegerDigits(),
                NumberFormat.getInstance().getMinimumIntegerDigits());
        assertEquals(formatter1.getRoundingMode(), 
                NumberFormat.getInstance().getRoundingMode());
        assertEquals(formatter1.getUnitSystem(), UnitLocale.getDefault());
        assertEquals(formatter1.isGroupingUsed(), 
                NumberFormat.getInstance().isGroupingUsed());
        assertEquals(formatter1.isParseIntegerOnly(),
                NumberFormat.getInstance().isParseIntegerOnly());
        assertEquals(formatter1.getValueAndUnitFormatPattern(), 
                MeasureFormatter.DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN);
        
        //test getInstance with locale
        DistanceFormatter formatter3 = DistanceFormatter.getInstance(
                new Locale("en", "ES")); //make sure this locale is not the same 
                       //as the one used in the machine where tests are running!
        DistanceFormatter formatter4 = DistanceFormatter.getInstance(
                new Locale("en", "ES"));
        
        assertSame(formatter3, formatter4);        
        assertTrue(formatter3.equals(formatter4));
        
        
        assertNotSame(formatter1, formatter3);
        assertFalse(formatter3.equals(formatter1));
        
        assertFalse(formatter3.equals(new Object()));
        
        Locale l = new Locale("es", "ES");
        assertEquals(formatter3.getMaximumFractionDigits(), 
                NumberFormat.getInstance(l).getMaximumFractionDigits());
        assertEquals(formatter3.getMaximumIntegerDigits(),
                NumberFormat.getInstance(l).getMaximumIntegerDigits());
        assertEquals(formatter3.getMinimumFractionDigits(),
                NumberFormat.getInstance(l).getMinimumFractionDigits());
        assertEquals(formatter3.getMinimumIntegerDigits(),
                NumberFormat.getInstance(l).getMinimumIntegerDigits());
        assertEquals(formatter3.getRoundingMode(), 
                NumberFormat.getInstance(l).getRoundingMode());
        assertEquals(formatter3.getUnitSystem(), UnitLocale.getFrom(l));
        assertEquals(formatter3.isGroupingUsed(), 
                NumberFormat.getInstance(l).isGroupingUsed());
        assertEquals(formatter3.isParseIntegerOnly(),
                NumberFormat.getInstance(l).isParseIntegerOnly());    
        
        //Force IllegalArgumentException
        DistanceFormatter formatter = null;
        try{
            formatter = DistanceFormatter.getInstance(null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        assertNull(formatter);
    }
    
    @Test
    public void testClone(){
        DistanceFormatter formatter1 = DistanceFormatter.getInstance();
        DistanceFormatter formatter2 = (DistanceFormatter)formatter1.clone();
        
        assertNotSame(formatter1, formatter2);
        assertEquals(formatter1, formatter2);
    }
    
    @Test
    public void testFormat(){
        double value = 5.50;
        Locale l = new Locale("es", "ES");
        
        DistanceFormatter formatter = DistanceFormatter.getInstance(l);
        
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.MILLIMETER), "5,5 mm");
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.CENTIMETER), "5,5 cm");
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.METER), "5,5 m");        
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.KILOMETER), "5,5 Km");        
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.INCH), "5,5 in");
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.FOOT), "5,5 ft");        
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.YARD), "5,5 yd");        
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.MILE), "5,5 mi");
        
        
        StringBuffer buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.MILLIMETER, buffer,
                new FieldPosition(0)).toString(), "5,5 mm");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.CENTIMETER, buffer, 
                new FieldPosition(0)).toString(), "5,5 cm");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.METER, buffer, 
                new FieldPosition(0)).toString(), "5,5 m");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.KILOMETER, buffer, 
                new FieldPosition(0)).toString(), "5,5 Km");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.INCH, buffer, 
                new FieldPosition(0)).toString(), "5,5 in");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.FOOT, buffer, 
                new FieldPosition(0)).toString(), "5,5 ft");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.YARD, buffer, 
                new FieldPosition(0)).toString(), "5,5 yd");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(new BigDecimal(value), 
                DistanceUnit.MILE, buffer, 
                new FieldPosition(0)).toString(), "5,5 mi");        
        
        assertEquals(formatter.format(value, DistanceUnit.MILLIMETER),
                "5,5 mm");
        assertEquals(formatter.format(value, DistanceUnit.CENTIMETER), 
                "5,5 cm");
        assertEquals(formatter.format(value, DistanceUnit.METER), 
                "5,5 m");        
        assertEquals(formatter.format(value, DistanceUnit.KILOMETER), 
                "5,5 Km");        
        assertEquals(formatter.format(value, DistanceUnit.INCH), 
                "5,5 in");
        assertEquals(formatter.format(value, DistanceUnit.FOOT), 
                "5,5 ft");        
        assertEquals(formatter.format(value, DistanceUnit.YARD), 
                "5,5 yd");        
        assertEquals(formatter.format(value, DistanceUnit.MILE), 
                "5,5 mi");
        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.MILLIMETER, buffer,
                new FieldPosition(0)).toString(), "5,5 mm");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.CENTIMETER, buffer, 
                new FieldPosition(0)).toString(), "5,5 cm");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.METER, buffer, 
                new FieldPosition(0)).toString(), "5,5 m");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.KILOMETER, buffer, 
                new FieldPosition(0)).toString(), "5,5 Km");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.INCH, buffer, 
                new FieldPosition(0)).toString(), "5,5 in");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.FOOT, buffer, 
                new FieldPosition(0)).toString(), "5,5 ft");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.YARD, buffer, 
                new FieldPosition(0)).toString(), "5,5 yd");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(value, DistanceUnit.MILE, buffer, 
                new FieldPosition(0)).toString(), "5,5 mi");   
        
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.MILLIMETER)), "5,5 mm");
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.CENTIMETER)), "5,5 cm");
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.METER)), "5,5 m");        
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.KILOMETER)), "5,5 Km");        
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.INCH)), "5,5 in");
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.FOOT)), "5,5 ft");        
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.YARD)), "5,5 yd");        
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.MILE)), "5,5 mi");  
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.MILLIMETER), buffer,
                new FieldPosition(0)).toString(), "5,5 mm");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.CENTIMETER), buffer, 
                new FieldPosition(0)).toString(), "5,5 cm");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.METER), buffer, 
                new FieldPosition(0)).toString(), "5,5 m");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.KILOMETER), buffer, 
                new FieldPosition(0)).toString(), "5,5 Km");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.INCH), buffer, 
                new FieldPosition(0)).toString(), "5,5 in");        
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.FOOT), buffer, 
                new FieldPosition(0)).toString(), "5,5 ft");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.YARD), buffer, 
                new FieldPosition(0)).toString(), "5,5 yd");
        
        buffer = new StringBuffer();
        assertEquals(formatter.format(
                new Distance(value, DistanceUnit.MILE), buffer, 
                new FieldPosition(0)).toString(), "5,5 mi");           
    }
    
    @Test
    public void testFormatAndConvert(){
        //Test for metric system
        Locale l = new Locale("es", "ES");
        
        DistanceFormatter formatter = DistanceFormatter.getInstance(l);
        formatter.setMaximumFractionDigits(2);

        assertEquals(formatter.formatAndConvert(new BigDecimal(5.50), 
                DistanceUnit.MILLIMETER), "5,5 mm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(50.50), 
                DistanceUnit.MILLIMETER), "5,05 cm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(5000.50), 
                DistanceUnit.MILLIMETER), "5 m");
        assertEquals(formatter.formatAndConvert(new BigDecimal(5000000.50),
                DistanceUnit.MILLIMETER), "5 Km");
        
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0), 
                DistanceUnit.INCH), "2,54 cm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.FOOT), "30,48 cm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.YARD), "91,44 cm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.MILE), "1,61 Km");
        
        assertEquals(formatter.formatAndConvert(5.50, 
                DistanceUnit.MILLIMETER), "5,5 mm");
        assertEquals(formatter.formatAndConvert(50.50, 
                DistanceUnit.MILLIMETER), "5,05 cm");
        assertEquals(formatter.formatAndConvert(5000.50, 
                DistanceUnit.MILLIMETER), "5 m");
        assertEquals(formatter.formatAndConvert(5000000.50,
                DistanceUnit.MILLIMETER), "5 Km");
        
        assertEquals(formatter.formatAndConvert(1.0, 
                DistanceUnit.INCH), "2,54 cm");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.FOOT), "30,48 cm");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.YARD), "91,44 cm");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.MILE), "1,61 Km");

        assertEquals(formatter.formatAndConvert(new Distance(5.50, 
                DistanceUnit.MILLIMETER)), "5,5 mm");
        assertEquals(formatter.formatAndConvert(new Distance(50.50, 
                DistanceUnit.MILLIMETER)), "5,05 cm");
        assertEquals(formatter.formatAndConvert(new Distance(5000.50, 
                DistanceUnit.MILLIMETER)), "5 m");
        assertEquals(formatter.formatAndConvert(new Distance(5000000.50,
                DistanceUnit.MILLIMETER)), "5 Km");
        
        assertEquals(formatter.formatAndConvert(new Distance(1.0, 
                DistanceUnit.INCH)), "2,54 cm");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.FOOT)), "30,48 cm");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.YARD)), "91,44 cm");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.MILE)), "1,61 Km");

        
        assertEquals(formatter.formatAndConvert(new BigDecimal(5.50), 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5,5 mm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(50.50), 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5,05 cm");
        assertEquals(formatter.formatAndConvert(new BigDecimal(5000.50), 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5 m");
        assertEquals(formatter.formatAndConvert(new BigDecimal(5000000.50),
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5 Km");
        
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0), 
                DistanceUnit.INCH, UnitSystem.IMPERIAL), "1 in");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.FOOT, UnitSystem.IMPERIAL), "1 ft");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.YARD, UnitSystem.IMPERIAL), "1 yd");
        assertEquals(formatter.formatAndConvert(new BigDecimal(1.0),
                DistanceUnit.MILE, UnitSystem.IMPERIAL), "1 mi");
        
        assertEquals(formatter.formatAndConvert(5.50, 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5,5 mm");
        assertEquals(formatter.formatAndConvert(50.50, 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5,05 cm");
        assertEquals(formatter.formatAndConvert(5000.50, 
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5 m");
        assertEquals(formatter.formatAndConvert(5000000.50,
                DistanceUnit.MILLIMETER, UnitSystem.METRIC), "5 Km");
        
        assertEquals(formatter.formatAndConvert(1.0, 
                DistanceUnit.INCH, UnitSystem.IMPERIAL), "1 in");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.FOOT, UnitSystem.IMPERIAL), "1 ft");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.YARD, UnitSystem.IMPERIAL), "1 yd");
        assertEquals(formatter.formatAndConvert(1.0,
                DistanceUnit.MILE, UnitSystem.IMPERIAL), "1 mi");

        assertEquals(formatter.formatAndConvert(new Distance(5.50, 
                DistanceUnit.MILLIMETER), UnitSystem.METRIC), "5,5 mm");
        assertEquals(formatter.formatAndConvert(new Distance(50.50, 
                DistanceUnit.MILLIMETER), UnitSystem.METRIC), "5,05 cm");
        assertEquals(formatter.formatAndConvert(new Distance(5000.50, 
                DistanceUnit.MILLIMETER), UnitSystem.METRIC), "5 m");
        assertEquals(formatter.formatAndConvert(new Distance(5000000.50,
                DistanceUnit.MILLIMETER), UnitSystem.METRIC), "5 Km");
        
        assertEquals(formatter.formatAndConvert(new Distance(1.0, 
                DistanceUnit.INCH), UnitSystem.IMPERIAL), "1 in");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.FOOT), UnitSystem.IMPERIAL), "1 ft");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.YARD), UnitSystem.IMPERIAL), "1 yd");
        assertEquals(formatter.formatAndConvert(new Distance(1.0,
                DistanceUnit.MILE), UnitSystem.IMPERIAL), "1 mi");
        
        
        //Test for imperial system
        l = new Locale("en", "US");
        
        formatter = DistanceFormatter.getInstance(l);
        formatter.setMaximumFractionDigits(2);
        
        assertEquals(formatter.formatAndConvert(new BigDecimal(5.50), 
                DistanceUnit.INCH), "5.5 in");
        assertEquals(formatter.formatAndConvert(new BigDecimal(18.0),
                DistanceUnit.INCH), "1.5 ft");
        assertEquals(formatter.formatAndConvert(new BigDecimal(16.50),
                DistanceUnit.FOOT), "5.5 yd");
        assertEquals(formatter.formatAndConvert(new BigDecimal(348480.0), 
                DistanceUnit.INCH), "5.5 mi");
        
        assertEquals(formatter.formatAndConvert(5.50, 
                DistanceUnit.INCH), "5.5 in");
        assertEquals(formatter.formatAndConvert(18.0,
                DistanceUnit.INCH), "1.5 ft");
        assertEquals(formatter.formatAndConvert(16.50,
                DistanceUnit.FOOT), "5.5 yd");
        assertEquals(formatter.formatAndConvert(348480.0, 
                DistanceUnit.INCH), "5.5 mi");

        assertEquals(formatter.formatAndConvert(new Distance(5.50, 
                DistanceUnit.INCH)), "5.5 in");
        assertEquals(formatter.formatAndConvert(new Distance(18.0,
                DistanceUnit.INCH)), "1.5 ft");
        assertEquals(formatter.formatAndConvert(new Distance(16.50,
                DistanceUnit.FOOT)), "5.5 yd");
        assertEquals(formatter.formatAndConvert(new Distance(348480.0, 
                DistanceUnit.INCH)), "5.5 mi");        
    }
    
    @Test
    public void testFormatAndConvertMetric(){
        //Test for metric system
        Locale l = new Locale("es", "ES");
        
        DistanceFormatter formatter = DistanceFormatter.getInstance(l);
        formatter.setMaximumFractionDigits(2);

        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(5.50), 
                DistanceUnit.MILLIMETER), "5,5 mm");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(50.50), 
                DistanceUnit.MILLIMETER), "5,05 cm");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(5000.50), 
                DistanceUnit.MILLIMETER), "5 m");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(5000000.50),
                DistanceUnit.MILLIMETER), "5 Km");
        
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(1.0), 
                DistanceUnit.INCH), "2,54 cm");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(1.0),
                DistanceUnit.FOOT), "30,48 cm");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(1.0),
                DistanceUnit.YARD), "91,44 cm");
        assertEquals(formatter.formatAndConvertMetric(new BigDecimal(1.0),
                DistanceUnit.MILE), "1,61 Km");        
    }
    
    @Test
    public void testFormatAndConvertImperial(){
        Locale l = new Locale("en", "US");
        
        DistanceFormatter formatter = DistanceFormatter.getInstance(l);
        formatter.setMaximumFractionDigits(2);
        
        assertEquals(formatter.formatAndConvertImperial(new BigDecimal(5.50), 
                DistanceUnit.INCH), "5.5 in");
        assertEquals(formatter.formatAndConvertImperial(new BigDecimal(18.0),
                DistanceUnit.INCH), "1.5 ft");
        assertEquals(formatter.formatAndConvertImperial(new BigDecimal(16.50),
                DistanceUnit.FOOT), "5.5 yd");
        assertEquals(formatter.formatAndConvertImperial(new BigDecimal(348480.0), 
                DistanceUnit.INCH), "5.5 mi");
    }
    
    @Test
    public void testGetAvailableLocales(){
        assertArrayEquals(DistanceFormatter.getAvailableLocales(), 
                NumberFormat.getAvailableLocales());
    }
    
    @Test
    public void testGetSetMaximumFractionDigits(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.getMaximumFractionDigits(), 
                NumberFormat.getInstance().getMaximumFractionDigits());
        
        //set new value
        formatter.setMaximumFractionDigits(2);
        
        //check correctness
        assertEquals(formatter.getMaximumFractionDigits(), 2);
    }
    
    @Test
    public void testGetSetMaximumIntegerDigits(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.getMaximumIntegerDigits(),
                NumberFormat.getInstance().getMaximumIntegerDigits());
        
        //set new value
        formatter.setMaximumIntegerDigits(2);
        
        //check correctness
        assertEquals(formatter.getMaximumIntegerDigits(), 2);
    }
    
    @Test
    public void testGetSetMinimumFractionDigits(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.getMinimumFractionDigits(),
                NumberFormat.getInstance().getMinimumFractionDigits());
        
        //set new value
        formatter.setMinimumFractionDigits(2);
        
        //check correctness
        assertEquals(formatter.getMinimumFractionDigits(), 2);
    }
    
    @Test
    public void testGetSetMinimumIntegerDigits(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.getMinimumIntegerDigits(),
                NumberFormat.getInstance().getMinimumIntegerDigits());
        
        //set new value
        formatter.setMinimumIntegerDigits(2);
        
        //check correctness
        assertEquals(formatter.getMinimumIntegerDigits(), 2);
    }
    
    @Test
    public void testGetSetRoundingMode(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.getRoundingMode(), 
                NumberFormat.getInstance().getRoundingMode());
        
        //set new value
        formatter.setRoundingMode(RoundingMode.UNNECESSARY);
        
        //check correctness
        assertEquals(formatter.getRoundingMode(), RoundingMode.UNNECESSARY);
    }
    
    @Test
    public void testGetSetValueAndUnitFormatPattern(){
        DistanceFormatter formatter = DistanceFormatter.getInstance();
        
        assertEquals(formatter.getValueAndUnitFormatPattern(),
                MeasureFormatter.DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN);
        
        //new value
        formatter.setValueAndUnitFormatPattern("{0}{1}");
        
        //check correctness
        assertEquals(formatter.getValueAndUnitFormatPattern(), "{0}{1}");
    }
    
    @Test
    public void testIsSetGroupingUsed(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.isGroupingUsed(), 
                NumberFormat.getInstance().isGroupingUsed());
        
        //set new value
        formatter.setGroupingUsed(!formatter.isGroupingUsed());
        
        //check correctness
        assertEquals(formatter.isGroupingUsed(), 
                !NumberFormat.getInstance().isGroupingUsed());
    }
    
    @Test
    public void testIsSetParseIntegerOnly(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                Locale.FRANCE);
        
        assertEquals(formatter.isParseIntegerOnly(),
                NumberFormat.getInstance().isParseIntegerOnly());
        
        //set new value
        formatter.setParseIntegerOnly(!formatter.isParseIntegerOnly());
        
        //check correctness
        assertEquals(formatter.isParseIntegerOnly(), 
                !NumberFormat.getInstance().isParseIntegerOnly());
    }
    
    @Test
    public void testGetUnitSystem(){
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                new Locale("es", "ES"));
        assertEquals(formatter.getUnitSystem(), UnitSystem.METRIC);
        
        formatter = DistanceFormatter.getInstance(new Locale("en", "US"));
        assertEquals(formatter.getUnitSystem(), UnitSystem.IMPERIAL);
    }
    
    @Test
    public void testParse() throws ParseException, UnknownUnitException{
        DistanceFormatter formatter = DistanceFormatter.getInstance(
                new Locale("es", "ES"));
        
        String text = "5,5 mm";        
        Distance d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.MILLIMETER);
        
        text = "5,5 cm";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.CENTIMETER);
        
        text = "5,5 m";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.METER);
        
        text = "5,5 Km";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.KILOMETER);
        
        text = "5,5 in";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.INCH);
        
        text = "5,5 ft";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.FOOT);
        
        text = "5,5 yd";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.YARD);
        
        text = "5,5 mi";
        d = formatter.parse(text);
        assertEquals(d.getValue().doubleValue(), 5.5, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.MILE);
        
        //Force UnknownUnitException
        text = "5,5 s";
        try{
            formatter.parse(text);
            fail("UnknownUnitException expected but not thrown");
        }catch(UnknownUnitException e){}
        
        //Force ParseException
        try{
            formatter.parse("m");
            fail("ParseException expected but not thrown");
        }catch(ParseException e){}
    }
}