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

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DistanceConverterTest {
    
    /**
     * Number of meters in 1 milimeter
     */
    public static final double METERS_PER_MILIMETER = 0.001;
    
    /**
     * Number of meters in 1 centimeter
     */
    public static final double METERS_PER_CENTIMETER = 0.01;
    
    /**
     * Number of meters in 1 kilometer
     */
    public static final double METERS_PER_KILOMETER = 1000.0;
    
    /**
     * Number of meters in 1 inch
     */
    public static final double METERS_PER_INCH = 0.0254;
    
    /**
     * Number of meters in 1 foot
     */
    public static final double METERS_PER_FOOT = 0.3048;
    
    /**
     * Number of meters in 1 yard
     */
    public static final double METERS_PER_YARD = 0.9144;
    
    /**
     * Number of meters in 1 mile
     */
    public static final double METERS_PER_MILE = 1609.344;
    
    public static final double ERROR = 1e-6;
    
    
    public DistanceConverterTest() {}
    
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
        assertNotNull(new DistanceConverter());
    }
    
    @Test
    public void testMetersMilimeters(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToMilimeter(inputValue), 
                inputValue / METERS_PER_MILIMETER, ERROR);
        assertEquals(DistanceConverter.milimeterToMeter(inputValue),
                inputValue * METERS_PER_MILIMETER, ERROR);
    }
    
    @Test
    public void testMetersCentimeters(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToCentimeter(inputValue),
                inputValue / METERS_PER_CENTIMETER, ERROR);
        assertEquals(DistanceConverter.centimeterToMeter(inputValue),
                inputValue * METERS_PER_CENTIMETER, ERROR);
    }
    
    @Test
    public void testMetersKilometers(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToKilometer(inputValue),
                inputValue / METERS_PER_KILOMETER, ERROR);
        assertEquals(DistanceConverter.kilometerToMeter(inputValue),
                inputValue * METERS_PER_KILOMETER, ERROR);
    }
    
    @Test
    public void testMetersInches(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToInch(inputValue),
                inputValue / METERS_PER_INCH, ERROR);
        assertEquals(DistanceConverter.inchToMeter(inputValue),
                inputValue * METERS_PER_INCH, ERROR);
    }
    
    @Test
    public void testMetersFeet(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToFoot(inputValue),
                inputValue / METERS_PER_FOOT, ERROR);
        assertEquals(DistanceConverter.footToMeter(inputValue),
                inputValue * METERS_PER_FOOT, ERROR);
    }
    
    @Test
    public void testMetersYards(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToYard(inputValue),
                inputValue / METERS_PER_YARD, ERROR);
        assertEquals(DistanceConverter.yardToMeter(inputValue),
                inputValue * METERS_PER_YARD, ERROR);
    }
    
    @Test
    public void testMetersMiles(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.meterToMile(inputValue),
                inputValue / METERS_PER_MILE, ERROR);
        assertEquals(DistanceConverter.mileToMeter(inputValue),
                inputValue * METERS_PER_MILE, ERROR);
    }
    
    @Test
    public void testConvert(){
        double inputValue = new Random().nextDouble();
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.MILIMETER), 
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.MILIMETER, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.METER),
                DistanceConverter.milimeterToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.MILIMETER, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILIMETER, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.milimeterToMeter(inputValue)), ERROR);
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.CENTIMETER, DistanceUnit.CENTIMETER),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.METER),
                DistanceConverter.centimeterToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.CENTIMETER, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.CENTIMETER, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.centimeterToMeter(inputValue)), ERROR);        
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.METER, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.METER),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.INCH),
                DistanceConverter.meterToInch(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.METER, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.YARD),
                DistanceConverter.meterToYard(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.METER, DistanceUnit.MILE),
                DistanceConverter.meterToMile(inputValue), ERROR);  
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.KILOMETER, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.METER),
                DistanceConverter.kilometerToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.KILOMETER),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.KILOMETER, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.KILOMETER, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.kilometerToMeter(inputValue)), ERROR);                
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.inchToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.INCH, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.inchToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.METER),
                DistanceConverter.inchToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.inchToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.INCH),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.INCH, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.inchToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.inchToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.INCH, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.inchToMeter(inputValue)), ERROR);                        
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.footToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.FOOT, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.footToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.METER),
                DistanceConverter.footToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.footToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.footToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.FOOT, DistanceUnit.FOOT),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.footToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.FOOT, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.footToMeter(inputValue)), ERROR);                                
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.yardToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.YARD, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.yardToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.METER),
                DistanceConverter.yardToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.yardToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.yardToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.YARD, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.yardToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.YARD),
                inputValue, ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.YARD, DistanceUnit.MILE),
                DistanceConverter.meterToMile(
                DistanceConverter.yardToMeter(inputValue)), ERROR);                                        
        
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.MILIMETER), 
                DistanceConverter.meterToMilimeter(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.MILE, DistanceUnit.CENTIMETER),
                DistanceConverter.meterToCentimeter(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.METER),
                DistanceConverter.mileToMeter(inputValue), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.KILOMETER),
                DistanceConverter.meterToKilometer(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.INCH),
                DistanceConverter.meterToInch(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue,
                DistanceUnit.MILE, DistanceUnit.FOOT),
                DistanceConverter.meterToFoot(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.YARD),
                DistanceConverter.meterToYard(
                DistanceConverter.mileToMeter(inputValue)), ERROR);
        assertEquals(DistanceConverter.convert(inputValue, 
                DistanceUnit.MILE, DistanceUnit.MILE),
                inputValue, ERROR);
    }
}