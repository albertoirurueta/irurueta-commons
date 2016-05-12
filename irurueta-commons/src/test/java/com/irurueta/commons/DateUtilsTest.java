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

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilsTest {
    
    public static final int MILLIS_PER_HOUR = 1000 * 3600;
    
    public DateUtilsTest() {}
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {}
    
    @After
    public void tearDown() {}

    @Test
    public void testParse(){
        //timestamp without separators
        String value = "20150429T173115+0200";
        Date d = DateUtils.parse(value);

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("ECT"));
        cal.setTime(d);

        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), 3);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 29);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 17);
        assertEquals(cal.get(Calendar.MINUTE), 31);
        assertEquals(cal.get(Calendar.SECOND), 15);

        //timestamp at UTC
        value = "20150429T173115Z";
        d = DateUtils.parse(value);
        cal.setTime(d);
        int millisOffset = cal.getTimeZone().getOffset(d.getTime());

        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), 3);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 29);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 17 + 
                (millisOffset / MILLIS_PER_HOUR));
        assertEquals(cal.get(Calendar.MINUTE), 31);
        assertEquals(cal.get(Calendar.SECOND), 15);


        //timestamp with separators
        value = "2015-04-29T17:31:15+0200";
        d = DateUtils.parse(value);
        cal.setTime(d);

        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), 3);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 29);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 17);
        assertEquals(cal.get(Calendar.MINUTE), 31);
        assertEquals(cal.get(Calendar.SECOND), 15);

        //timestamp with separators at UTC
        value = "2015-04-29T17:31:15Z";
        d = DateUtils.parse(value);
        cal.setTime(d);
        millisOffset = cal.getTimeZone().getOffset(d.getTime());

        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), 3);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 29);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 17 + 
                (millisOffset / MILLIS_PER_HOUR));
        assertEquals(cal.get(Calendar.MINUTE), 31);
        assertEquals(cal.get(Calendar.SECOND), 15);

        //date only
        value = "20150429";
        d = DateUtils.parse(value);
        cal = Calendar.getInstance();
        cal.setTime(d);

        assertEquals(cal.get(Calendar.YEAR), 2015);
        assertEquals(cal.get(Calendar.MONTH), 3);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 29);
        assertEquals(cal.get(Calendar.HOUR_OF_DAY), 0);
        assertEquals(cal.get(Calendar.MINUTE), 0);
        assertEquals(cal.get(Calendar.SECOND), 0);

        assertNull(DateUtils.parse(null));
    }

    @Test
    public void testFormatDate(){
        Date date = new Date();
        String value = DateFormat.getDateInstance(DateFormat.MEDIUM).
                format(date);

        assertEquals(DateUtils.formatDate(date), value);
    }

    @Test
    public void testFormatDateAndTime(){
        Date date = new Date();
        String value = DateFormat.getDateTimeInstance(DateFormat.SHORT, 
                DateFormat.SHORT).format(date);

        assertEquals(DateUtils.formatDateAndTime(date), value);
    }

    @Test
    public void testTodayIsToday(){
        Date someDate = new Date(0);
        Date today = DateUtils.today();

        assertFalse(DateUtils.isToday(someDate));
        assertTrue(DateUtils.isToday(today));
    }

    @Test
    public void testIsSameDay(){
        Date someDate = new Date(0);
        Date now = new Date();

        assertFalse(DateUtils.isSameDay(someDate, now));
        assertTrue(DateUtils.isSameDay(someDate, someDate));
        assertTrue(DateUtils.isSameDay(now, now));
        assertTrue(DateUtils.isSameDay(now, DateUtils.today()));

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.setTime(someDate);
        cal2.setTime(now);
        assertFalse(DateUtils.isSameDay(cal1, cal2));

        cal1.setTime(someDate);
        cal2.setTime(someDate);
        assertTrue(DateUtils.isSameDay(cal1, cal2));

        cal1.setTime(now);
        cal2.setTime(now);
        assertTrue(DateUtils.isSameDay(cal1, cal2));

        cal1.setTime(now);
        cal2.setTime(DateUtils.today());
        assertTrue(DateUtils.isSameDay(cal1, cal2));
    }    
}
