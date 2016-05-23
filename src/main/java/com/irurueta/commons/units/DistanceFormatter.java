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

import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Locale;

/**
 * Class in charge of formatting or parsing a distance value and unit.
 */
public class DistanceFormatter extends 
        MeasureFormatter<Distance, DistanceUnit> implements Cloneable {
    
    /**
     * Milimeter symbol.
     */
    public static final String MILIMETER = "mm";
    
    /**
     * Centimeter symbol.
     */
    public static final String CENTIMETER = "cm";
    
    /**
     * Meter symbol.
     */
    public static final String METER = "m";
    
    /**
     * Kilometer symbol.
     */
    public static final String KILOMETER = "Km";
    
    /**
     * Inch symbol.
     */
    public static final String INCH = "in";
    
    /**
     * Foot symbol.
     */
    public static final String FOOT = "ft";
    
    /**
     * Yard symbol.
     */
    public static final String YARD = "yd";
    
    /**
     * Mile symbol.
     */
    public static final String MILE = "mi";
    
    /**
     * Singleton instance of distance formatter for default locale.
     */
    private static SoftReference<DistanceFormatter> mReference;
    
    /**
     * Singleton instances of formatter for each instantiated locale.
     */
    private static SoftReference<HashMap<Locale, DistanceFormatter>> 
            mReferences;
    
    /**
     * Constructor.
     */
    protected DistanceFormatter() {
        super();
    }
    
    /**
     * Constructor with locale.
     * @param locale locale.
     * @throws IllegalArgumentException if locale is null.
     */
    protected DistanceFormatter(Locale locale) 
            throws IllegalArgumentException {
        super(locale);
    }
    
    /**
     * Clones this distance formatter.
     * @return a copy of this distance formatter.
     */
    @Override
    public Object clone() {
        DistanceFormatter copy = new DistanceFormatter();
        return internalClone(copy);
    }
    
    /**
     * Determines if two distance formatters are equal by comparing all of its
     * internal parameters.
     * @param obj another object to compare.
     * @return true if provided object is assumed to be equal to this instance.
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = super.equals(obj);
        if (equals && !(obj instanceof DistanceFormatter)) {
            return false;
        }
        return equals;
    }
    
    /**
     * Returns or creates singleton instance of this class using default locale.
     * @return singleton instance.
     */
    public static DistanceFormatter getInstance() {
        DistanceFormatter formatter;
        if (mReference == null || (formatter = mReference.get()) == null) {
            formatter = new DistanceFormatter();
            mReference = new SoftReference<>(formatter);
        }
        return formatter;
    }
    
    /**
     * Returns or creates singleton instance of this class for provided locale.
     * @param locale locale to set on returned distance formatter.
     * @return a singleton distance formatter for provided locale.
     * @throws IllegalArgumentException if locale is null.
     */
    public static DistanceFormatter getInstance(Locale locale) 
            throws IllegalArgumentException {
        if (locale == null) {
            throw new IllegalArgumentException();
        }
        
        HashMap<Locale, DistanceFormatter> singletons;
        if (mReferences == null || (singletons = mReferences.get()) == null) {
            //if map no longer exists, create a new one
            singletons = new HashMap<>();
            mReferences = new SoftReference<>(singletons);
        }
        
        if (!singletons.containsKey(locale)) {
            //if locale is not in singletons map, create new formatter
            DistanceFormatter formatter = new DistanceFormatter(locale);
            singletons.put(locale, formatter);
            return formatter;
        } else {
            //retrieve available formatter in singletons map
            return singletons.get(locale);
        }
    }
    
    /**
     * Parses provided string and tries to determine a distance value and unit.
     * @param source a string to be parsed.
     * @return a distance containing a value and unit.
     * @throws ParseException if provided string cannot be parsed.
     * @throws UnknownUnitException if unit cannot be determined.
     */
    @Override
    public Distance parse(String source) throws ParseException, 
            UnknownUnitException {
        return internalParse(source, new Distance());
    }
    
    /**
     * Formats and converts provided distance value and unit using unit system 
     * assigned to locale of this instance (if no locale has been provided it 
     * is assumed that the system default locale is used).
     * If provided value is too large for provided unit, this method will 
     * convert it to a more appropriate unit.
     * @param value a distance value.
     * @param unit a distance unit.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(Number value, DistanceUnit unit) {
        return formatAndConvert(value, unit, getUnitSystem());
    }
    
    /**
     * Formats and converts provided distance value and unit using unit system 
     * assigned to locale of this instance (if no locale has been provided it 
     * is assumed that the system default locale is used).
     * If provided value is too large for provided unit, this method will 
     * convert it to a more appropriate unit.
     * @param value a distance value.
     * @param unit a distance unit.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(double value, DistanceUnit unit) {
        return formatAndConvert(new BigDecimal(value), unit);
    }
    
    /**
     * Formats and converts provided distance value and unit using unit system 
     * assigned to locale of this instance (if no locale has been provided it 
     * is assumed that the system default locale is used).
     * If provided value is too large for provided distance unit, this method 
     * will convert it to a more appropriate unit.
     * @param distance a distance.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(Distance distance) {
        return formatAndConvert(distance.getValue(), distance.getUnit());
    }    
    
    /**
     * Formats and converts provided distance value and unit using provided
     * unit system.
     * If provided value is too large for provided distance unit, this method
     * will convert it to a more appropriate unit and also using provided unit 
     * system.
     * @param value a distance value.
     * @param unit a distance unit.
     * @param system system unit to convert distance to.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(Number value, DistanceUnit unit, 
            UnitSystem system) {
        switch (system) {
            case IMPERIAL:
                return formatAndConvertImperial(value, unit);
            case METRIC:
            default:
                return formatAndConvertMetric(value, unit);
        }
    }
    
    /**
     * Formats and converts provided distance value and unit using provided
     * unit system.
     * If provided value is too large for provided distance unit, this method
     * will convert it to a more appropriate unit and also using provided unit 
     * system.
     * @param value a distance value.
     * @param unit a distance unit.
     * @param system system unit to convert distance to.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(double value, DistanceUnit unit,
            UnitSystem system) {
        return formatAndConvert(new BigDecimal(value), unit, system);
    }
    
    /**
     * Formats and converts provided distance value and unit using provided
     * unit system.
     * If provided distance value is too large for provided distance unit, 
     * this method will convert it to a more appropriate unit and also using 
     * provided unit system.
     * @param distance a distance.
     * @param system system unit to convert distance to.
     * @return a string representation of distance value and unit.
     */
    public String formatAndConvert(Distance distance, UnitSystem system) {
        return formatAndConvert(distance.getValue(), distance.getUnit(), 
                system);
    }

    /**
     * Formats and converts provided distance value and unit using metric unit
     * system.
     * If provided distance value is too large for provided distance unit, 
     * this method will convert it to a more appropriate unit.
     * @param value a distance value.
     * @param unit a distance unit.
     * @return a string representation of distance value and unit using metric
     * unit system.
     */
    public String formatAndConvertMetric(Number value, DistanceUnit unit) {
        double v = value.doubleValue();
        
        double milimeters = DistanceConverter.convert(v, unit, 
                DistanceUnit.MILIMETER);
        if (Math.abs(milimeters) < (DistanceConverter.METERS_PER_CENTIMETER / 
                DistanceConverter.METERS_PER_MILIMETER)) {
            return format(milimeters, DistanceUnit.MILIMETER);
        }
        
        double centimeters = DistanceConverter.convert(v, unit, 
                DistanceUnit.CENTIMETER);
        if (Math.abs(centimeters) < 
                (1.0 / DistanceConverter.METERS_PER_CENTIMETER)) {
            return format(centimeters, DistanceUnit.CENTIMETER);
        }
        
        double meters = DistanceConverter.convert(v, unit, DistanceUnit.METER);
        if (Math.abs(meters) < DistanceConverter.METERS_PER_KILOMETER) {
            return format(meters, DistanceUnit.METER);
        }
        
        double kilometers = DistanceConverter.convert(v, unit, 
                DistanceUnit.KILOMETER);
        return format(kilometers, DistanceUnit.KILOMETER);
    }

    /**
     * Formats and converts provided distance value and unit using imperial unit
     * system.
     * If provided distance value is too large for provided distance unit, 
     * this method will convert it to a more appropriate unit.
     * @param value a distance value.
     * @param unit a distance unit.
     * @return a string representation of distance value and unit using imperial
     * unit system.
     */    
    public String formatAndConvertImperial(Number value, DistanceUnit unit) {
        double v = value.doubleValue();
        
        double inches = DistanceConverter.convert(v, unit, DistanceUnit.INCH);
        if (Math.abs(inches) < (DistanceConverter.METERS_PER_FOOT / 
                DistanceConverter.METERS_PER_INCH)) {
            return format(inches, DistanceUnit.INCH);
        }
        
        double feet = DistanceConverter.convert(v, unit, DistanceUnit.FOOT);
        if (Math.abs(feet) < (DistanceConverter.METERS_PER_YARD / 
                DistanceConverter.METERS_PER_FOOT)) {
            return format(feet, DistanceUnit.FOOT);
        }
        
        double yards = DistanceConverter.convert(v, unit, DistanceUnit.YARD);
        if (Math.abs(yards) < (DistanceConverter.METERS_PER_MILE / 
                DistanceConverter.METERS_PER_YARD)) {
            return format(yards, DistanceUnit.YARD);
        }
        
        double miles = DistanceConverter.convert(v, unit, DistanceUnit.MILE);
        return format(miles, DistanceUnit.MILE);
    }
    
    /**
     * Attempts to determine a distance unit from its string representation.
     * @param source a unit string representation.
     * @return a distance unit, or null if none can be determined.
     */
    @Override
    protected DistanceUnit findUnit(String source) {
        if (source.contains(MILIMETER + " ") || source.endsWith(MILIMETER)) {
            return DistanceUnit.MILIMETER;
        }
        if (source.contains(CENTIMETER + " ") || source.endsWith(CENTIMETER)) {
            return DistanceUnit.CENTIMETER;
        }
        if (source.contains(KILOMETER + " ") || source.endsWith(KILOMETER)) {
            return DistanceUnit.KILOMETER;
        }
        if (source.contains(INCH + " ") || source.endsWith(INCH)) {
            return DistanceUnit.INCH;
        }
        if (source.contains(FOOT + " ") || source.endsWith(FOOT)) {
            return DistanceUnit.FOOT;
        }
        if (source.contains(YARD + " ") || source.endsWith(YARD)) {
            return DistanceUnit.YARD;
        }
        if (source.contains(MILE + " ") || source.endsWith(MILE)) {
            return DistanceUnit.MILE;
        }
        
        if (source.contains(METER + " ") || source.endsWith(METER)) {
            return DistanceUnit.METER;
        }        
        return null;        
    }
    
    /**
     * Returns unit string representation.
     * @param unit a distance unit.
     * @return its string representation.
     */
    @Override
    protected String getUnitSymbol(DistanceUnit unit) {
        String unitStr;
        switch (unit) {
            case MILIMETER:
                unitStr = MILIMETER;
                break;
            case CENTIMETER:
                unitStr = CENTIMETER;
                break;
            case KILOMETER:
                unitStr = KILOMETER;
                break;
            case INCH:
                unitStr = INCH;
                break;
            case FOOT:
                unitStr = FOOT;
                break;
            case YARD:
                unitStr = YARD;
                break;
            case MILE:
                unitStr = MILE;
                break;
                
            case METER:
            default:
                unitStr = METER;
                break;
        }
        return unitStr;
    }
}
