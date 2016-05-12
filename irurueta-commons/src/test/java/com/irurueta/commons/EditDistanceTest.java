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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EditDistanceTest {
    
    public EditDistanceTest() {}
    
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
        assertNotNull(new EditDistance());
    }

    @Test
    public void testStringEditDistance() {
        String str1 = "dog";
        String str2 = "dogs";

        Character[] array1 = new Character[str1.length()];
        for(int i = 0; i < array1.length; i++) array1[i] = str1.charAt(i);
        Character[] array2 = new Character[str2.length()];
        for(int i = 0; i < array2.length; i++) array2[i] = str2.charAt(i);

        //distance is 1 because we can insert an 's' at the end of 'dog' to 
        //obtain 'dogs'
        assertEquals(EditDistance.stringDistance(str1, str2), 1);
        assertEquals(EditDistance.distance(array1, array2), 1);


        str1 = "puppy";
        str2 = "lucky";

        array1 = new Character[str1.length()];
        for(int i = 0; i < array1.length; i++) array1[i] = str1.charAt(i);
        array2 = new Character[str2.length()];
        for(int i = 0; i < array2.length; i++) array2[i] = str2.charAt(i);

        //distance is 3 because we can exchange the 'l' by the 1st 'p', the 'c' 
        //by the second 'p', and the 'k' by the third 'p'.
        assertEquals(EditDistance.stringDistance(str1, str2), 3);
        assertEquals(EditDistance.distance(array1, array2), 3);
    }    
}
