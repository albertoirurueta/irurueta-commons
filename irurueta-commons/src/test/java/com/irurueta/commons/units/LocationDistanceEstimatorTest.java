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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocationDistanceEstimatorTest {
    
    public static final double MAX_DISTANCE = 1.0; //1km
    public static final double EQUATORIAL_EARTH_RADIUS = 6378.1370; //in km
    public static final double ERROR = 0.5; //in km
    
    public LocationDistanceEstimatorTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}
    
    @Test
    public void testDistanceInMeters(){
        double latitude1 = 41.0;
        double longitude1 = 2.0;
        
        double delta = Math.atan2(MAX_DISTANCE, EQUATORIAL_EARTH_RADIUS) * 
                180.0 / Math.PI;
        
        double latitude2 = latitude1 + delta;
        double longitude2 = longitude1 + delta;
        
        assertEquals(LocationDistanceEstimator.distanceInMeters(
                latitude1, longitude1, latitude1, longitude1), 0.0, 0.0);        
        double distance = LocationDistanceEstimator.distanceInMeters(
                latitude1, longitude1, latitude2, longitude2);
        assertEquals(distance, 1000.0 * MAX_DISTANCE, 1000.0 * ERROR);        
    }
    
    @Test
    public void testDistanceInKilometers(){
        double latitude1 = 41.0;
        double longitude1 = 2.0;
        
        double delta = Math.atan2(MAX_DISTANCE, EQUATORIAL_EARTH_RADIUS) * 
                180.0 / Math.PI;
        
        double latitude2 = latitude1 + delta;
        double longitude2 = longitude1 + delta;
        
        assertEquals(LocationDistanceEstimator.distanceInKilometers(
                latitude1, longitude1, latitude1, longitude1), 0.0, 0.0);
        assertEquals(LocationDistanceEstimator.approximateDistanceInKilometers(
                latitude1, longitude1, latitude1, longitude1), 0.0, 0.0);        
        
        double distance = LocationDistanceEstimator.distanceInKilometers(
                latitude1, longitude1, latitude2, longitude2);
        assertEquals(distance, MAX_DISTANCE, ERROR);        
        distance = LocationDistanceEstimator.approximateDistanceInKilometers(
                latitude1, longitude1, latitude2, longitude2);
        assertEquals(distance, MAX_DISTANCE, ERROR);        
        
    }
}