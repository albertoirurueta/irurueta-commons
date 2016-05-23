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

public class DistanceTest {
    
    public DistanceTest() {}
    
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
        //try protected empty constructor
        Distance d = new Distance();
        
        //check correctness
        assertNull(d.getValue());
        assertNull(d.getUnit());
        
        //test constructor with parameters
        d = new Distance(1.0, DistanceUnit.METER);
        
        //check correctness
        assertEquals(d.getValue().doubleValue(), 1.0, 0.0);
        assertEquals(d.getUnit(), DistanceUnit.METER);        
        
        //Force IllegalArgumentException
        d = null;
        try{
            d = new Distance(null, DistanceUnit.METER);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        try{
            d = new Distance(1.0, null);
            fail("IllegalaRgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
        assertNull(d);
    }
    
    @Test
    public void testGetSetValue(){
        Distance d = new Distance();
        
        //check correctness
        assertNull(d.getValue());
        
        //set new value
        d.setValue(1.0);
        
        //check correctness
        assertEquals(d.getValue().doubleValue(), 1.0, 0.0);
        
        //Force IllegalArgumentException
        try{
            d.setValue(null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
    }
    
    @Test
    public void testGetSetUnit(){
        Distance d = new Distance();
        
        //check correctness
        assertNull(d.getUnit());
        
        //set new value
        d.setUnit(DistanceUnit.INCH);
        
        //check correctness
        assertEquals(d.getUnit(), DistanceUnit.INCH);
        
        //Force IllegalArgumentException
        try{
            d.setUnit(null);
            fail("IllegalArgumentException expected but not thrown");
        }catch(IllegalArgumentException e){}
    }
}