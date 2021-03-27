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
package com.irurueta.commons;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Utility class to work with timestamps or dates.
 * This class allows parsing and formatting of timestamps in ISO 8601 format,
 * and some utility methods such as to determine whether two timestamps
 * correspond to the same date, etc.
 */
public class DateUtils {

    /**
     * Timestamp format without date and time separators.
     */
    private static final String TIMESTAMP_NO_SEPARATORS_FORMAT =
            "yyyyMMdd'T'HHmmssZ";

    /**
     * Timestamp format with date and time separators.
     */
    private static final String TIMESTAMP_SEPARATORS_FORMAT =
            "yyyy-MM-dd'T'HH:mm:ssZ";

    /**
     * Date format without separators.
     */
    private static final String DATE_FORMAT = "yyyyMMdd";

    /**
     * Constructor.
     */
    protected DateUtils() {
    }

    /**
     * Parses a string representing a date or timestamp in ISO 8601 format.
     *
     * @param date date or timestamp expressed as a String in ISO 8601 format.
     * @return a date object or null if string could not be parsed.
     */
    public static Date parse(String date) {
        if (date == null) {
            return null;
        }

        try {
            // try parsing without separators
            date = date.replaceAll("Z$", "+0000");
            final SimpleDateFormat format = new SimpleDateFormat(
                    TIMESTAMP_NO_SEPARATORS_FORMAT, Locale.US);
            return format.parse(date);
        } catch (final ParseException e) {
            // if it fails, try parsing with separators
            try {
                final SimpleDateFormat format = new SimpleDateFormat(
                        TIMESTAMP_SEPARATORS_FORMAT, Locale.US);
                return format.parse(date);
            } catch (final ParseException e2) {
                // if it fails, try parsing just the date component
                try {
                    final SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT,
                            Locale.US);
                    return format.parse(date);
                } catch (final ParseException e3) {
                    // if it fails, return null.
                    return null;
                }
            }
        }
    }

    /**
     * Formats a date into a string using medium format.
     *
     * @param date a date.
     * @return a date formatted in medium format.
     */
    public static String formatDate(final Date date) {
        if (date != null) {
            // format date with MEDIUM format
            final SimpleDateFormat format =
                    (SimpleDateFormat) DateFormat.getDateInstance(
                            DateFormat.MEDIUM);
            return format.format(date);
        }
        return "";
    }

    /**
     * Formats date and time as a string using short format.
     *
     * @param date date and time.
     * @return a date and time formatted in short format.
     */
    public static String formatDateAndTime(final Date date) {
        if (date != null) {
            // format date and time with SHORT format
            final SimpleDateFormat format =
                    (SimpleDateFormat) DateFormat.getDateTimeInstance(
                            DateFormat.SHORT, DateFormat.SHORT);
            return format.format(date);
        }
        return "";
    }

    /**
     * Obtains a date/instance set to current date at midnight.
     *
     * @return current date at midnight.
     */
    public static Date today() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * Indicates whether two date/time instances correspond to the same day
     * (same calendar date).
     *
     * @param date1 1st date to check.
     * @param date2 2nd date to check.
     * @return true if both dates are the same, false otherwise.
     */
    public static boolean isSameDay(final Date date1, final Date date2) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    /**
     * Indicates if both provided calendar instances have the same calendar date
     * (even if they have different times set).
     *
     * @param cal1 1st calendar to check.
     * @param cal2 2nd calendar to check.
     * @return true if both calendars have the same date, false otherwise.
     */
    public static boolean isSameDay(final Calendar cal1, final Calendar cal2) {
        return cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Indicates whether provided date and time instances correspond to today
     * taking into account local timezone.
     *
     * @param date date and time to check.
     * @return true if date/time corresponds to today, false otherwise.
     */
    public static boolean isToday(final Date date) {
        return isSameDay(date, new Date());
    }
}
