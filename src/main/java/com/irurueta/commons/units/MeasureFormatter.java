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
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Base class to format a parse a given measure using its value and unit.
 * @param <T> type of measurement (i.e. Distance).
 * @param <U> type of unit (i.e. DistanceUnit).
 */
public abstract class MeasureFormatter<T extends Measurement, U extends Enum> implements Cloneable {
    
    /**
     * Default pattern to format values and units together into a single string.
     * {0} corresponds to the value, {1} corresponds to the unit part.
     */
    public static final String DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN = 
            "{0} {1}";
    
    /**
     * Internal number formatter.
     */
    private NumberFormat mNumberFormat;
    
    /**
     * Internal string formatter.
     */
    private MessageFormat mFormat;
    
    /**
     * Internal locale.
     */
    private Locale mLocale;
        
    /**
     * Pattern to format values and unit together into a single string. {0}
     * corresponds to the value, {1} corresponds to the unit part.
     */
    private String mValueAndUnitFormatPattern;
    
    /**
     * Constructor.
     */
    protected MeasureFormatter() {
        mNumberFormat = NumberFormat.getInstance();
        mLocale = Locale.getDefault();
        mValueAndUnitFormatPattern = DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN;
    }
    
    /**
     * Constructor with locale.
     * @param locale locale.
     * @throws IllegalArgumentException if locale is null.
     */
    protected MeasureFormatter(Locale locale) throws IllegalArgumentException {
        if (locale == null) {
            throw new IllegalArgumentException();
        }
        mNumberFormat = NumberFormat.getInstance(locale);
        mLocale = locale;
        mValueAndUnitFormatPattern = DEFAULT_VALUE_AND_UNIT_FORMAT_PATTERN;
    }
    
    /**
     * Internal method to clone this measure formatter.
     * @param copy an instantiated copy of a measure formatter that needs to be
     * initialized.
     * @return provided copy.
     */
    protected MeasureFormatter<T, U> internalClone(
            MeasureFormatter<T, U> copy) {
        copy.mNumberFormat = (NumberFormat)mNumberFormat.clone();
        if (mFormat != null) {
            copy.mFormat = (MessageFormat)mFormat.clone();
        }
        if (mLocale != null) {
            copy.mLocale = (Locale)mLocale.clone(); 
        }
        return copy;        
    }
    
    /**
     * Clones this measure formatter.
     * @return a copy of this unit formatter.
     */    
    @Override
    public abstract Object clone();
    
    /**
     * Determines if two measure formatters are equal by comparing all of its
     * internal parameters.
     * @param obj another object to compare.
     * @return true if provided object is assumed to be equal to this instance.
     */    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof MeasureFormatter)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        
        MeasureFormatter other = (MeasureFormatter)obj;
        if (!mNumberFormat.equals(other.mNumberFormat)) {
            return false;
        }
        return mLocale.equals(other.mLocale);
    }

    /**
     * Hash code generated for this instance.
     * Hash codes can be internally used by some collections to coarsely 
     * compare objects.
     * @return hash code.
     */    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.mNumberFormat != null ? 
                this.mNumberFormat.hashCode() : 0);
        hash = 19 * hash + (this.mFormat != null ? this.mFormat.hashCode() : 0);
        return hash;
    }
    
    /**
     * Formats provided measurement value and unit into a string representation.
     * @param value a measurement value.
     * @param unit a measurement unit.
     * @return string representation of provided measurement value and unit.
     */
    public String format(Number value, U unit) {
        return MessageFormat.format(mValueAndUnitFormatPattern, 
                mNumberFormat.format(value), getUnitSymbol(unit));
    }
    
    /**
     * Formats provided measurement value and unit into a string representation
     * and appends the result into provided string buffer.
     * @param value a measurement value.
     * @param unit a measurement unit.
     * @param toAppendTo buffer to append the result to.
     * @param pos field position where result will be appended.
     * @return provided string buffer where result is appended.
     */
    public StringBuffer format(Number value, U unit, 
            StringBuffer toAppendTo, FieldPosition pos) {
        if (mFormat == null) {
            mFormat = new MessageFormat(mValueAndUnitFormatPattern);
        }
        return mFormat.format(new Object[]{mNumberFormat.format(value), 
            getUnitSymbol(unit)}, toAppendTo, pos);
    }    
    
    /**
     * Formats provided measurement value and unit into a string representation.
     * @param value a measurement value.
     * @param unit a measurement unit.
     * @return string representation of provided measurement value and unit.
     */    
    public String format(double value, U unit) {
        return format(new BigDecimal(value), unit);
    }
    
    /**
     * Formats provided measurement value and unit into a string representation
     * and appends the result into provided string buffer.
     * @param value a measurement value.
     * @param unit a measurement unit.
     * @param toAppendTo buffer to append the result to.
     * @param pos field position where result will be appended.
     * @return provided string buffer where result is appended.
     */    
    public StringBuffer format(double value, U unit, 
            StringBuffer toAppendTo, FieldPosition pos) {
        return format(new BigDecimal(value), unit, toAppendTo, pos);
    }
    
    /**
     * Formats provided measurement into a string representation.
     * @param measurement a measurement.
     * @return string representation of provided measurement.
     */
    public String format(T measurement) {
        return format(measurement.getValue(), (U)measurement.getUnit());
    }
    
    /**
     * Formats provided measurement into a string representation and appends the
     * result into provided string buffer.
     * @param measurement a measurement.
     * @param toAppendTo buffer to append the result to.
     * @param pos field position where result will be appended.
     * @return provided string buffer where result is appended.
     */
    public StringBuffer format(T measurement, StringBuffer toAppendTo,
            FieldPosition pos) {
        return format(measurement.getValue(), (U)measurement.getUnit(), 
                toAppendTo, pos);
    }
    
    /**
     * Returns available locales for this measurement.
     * @return available locales.
     */
    public static Locale[] getAvailableLocales() {
        return NumberFormat.getAvailableLocales();
    }
     
    /**
     * Returns maximum fraction digits to be shown when formatting a measure.
     * @return maximum fraction digits.
     */
    public int getMaximumFractionDigits() {
        return mNumberFormat.getMaximumFractionDigits();
    }
    
    /**
     * Returns maximum integer digits to be shown when formatting a measure.
     * @return maximum integer digits.
     */
    public int getMaximumIntegerDigits() {
        return mNumberFormat.getMaximumIntegerDigits();
    }
    
    /**
     * Returns minimum fraction digits to be shown when formatting a measure.
     * @return minimum fraction digits.
     */
    public int getMinimumFractionDigits() {
        return mNumberFormat.getMinimumFractionDigits();
    }
    
    /**
     * Returns minimum integer digits to be shown when formatting a measure.
     * @return minimum integer digits.
     */
    public int getMinimumIntegerDigits() {
        return mNumberFormat.getMinimumIntegerDigits();
    }
    
    /**
     * Returns rounding mode to be used when formatting a measure.
     * @return rounding mode to be used when formatting a measure.
     */
    public RoundingMode getRoundingMode() {
        return mNumberFormat.getRoundingMode();
    }
    
    /**
     * Indicates if grouping is used when formatting a measure.
     * @return true if grouping is used, false otherwise.
     */
    public boolean isGroupingUsed() {
        return mNumberFormat.isGroupingUsed();
    }
    
    /**
     * Indicates if only integer values are parsed.
     * @return true if only integer values are parsed, false otherwise.
     */
    public boolean isParseIntegerOnly() {
        return mNumberFormat.isParseIntegerOnly();
    }
    
    /**
     * Returns unit system this instance will use based on its assigned locale.
     * Notice that if no locale was assigned, then the default system locale
     * will be used.
     * @return unit system this instance will use.
     */
    public UnitSystem getUnitSystem() {
        return UnitLocale.getFrom(mLocale);
    }
    
    /**
     * Internal method to parse a string into a measure.
     * @param source text to be parsed.
     * @param measure a measure to be initialized with parsed contents.
     * @return provided measure.
     * @throws ParseException if parsing failed.
     * @throws UnknownUnitException if unit cannot be determined.
     */
    protected T internalParse(String source, T measure) throws ParseException,
            UnknownUnitException {
        measure.setValue(mNumberFormat.parse(source));
        try {
            measure.setUnit(findUnit(source));
        } catch (IllegalArgumentException e) {
            throw new UnknownUnitException(e);
        }
        return measure;
    }
    
    /**
     * Parses a string into a measure.
     * @param source text to be parsed.
     * @return a measure containing measure value and unit obtained from parsed
     * text.
     * @throws ParseException if parsing failed.
     * @throws UnknownUnitException if unit cannot be determined.
     */
    public abstract T parse(String source) throws ParseException, 
            UnknownUnitException;
    
    /**
     * Sets if grouping is used when formatting a measure.
     * @param newValue true if grouping is enabled, false otherwise.
     */
    public void setGroupingUsed(boolean newValue) {
        mNumberFormat.setGroupingUsed(newValue);
    }
    
    /**
     * Sets maximum fraction digits to use when formatting a measure.
     * @param newValue maximum fraction digits to be set.
     */
    public void setMaximumFractionDigits(int newValue) {
        mNumberFormat.setMaximumFractionDigits(newValue);
    }
    
    /**
     * Sets maximum integer digits to use when formatting a measure.
     * @param newValue maximum integer digits to be set.
     */
    public void setMaximumIntegerDigits(int newValue) {
        mNumberFormat.setMaximumIntegerDigits(newValue);
    }
    
    /**
     * Sets minimum fraction digits to use when formatting a measure.
     * @param newValue minimum fraction digits to be set.
     */
    public void setMinimumFractionDigits(int newValue) {
        mNumberFormat.setMinimumFractionDigits(newValue);
    }
    
    /**
     * Sets minimum integer digits to use when formatting a measure.
     * @param newValue minimum integer digits to be set.
     */
    public void setMinimumIntegerDigits(int newValue) {
        mNumberFormat.setMinimumIntegerDigits(newValue);
    }
    
    /**
     * Specifies whether only integer values are parsed or not.
     * @param value if true only integer values will be parsed.
     */
    public void setParseIntegerOnly(boolean value) {
        mNumberFormat.setParseIntegerOnly(value);
    }
    
    /**
     * Specifies rounding mode to use when formatting a measure.
     * @param roundingMode rounding mode to be set.
     */
    public void setRoundingMode(RoundingMode roundingMode) {
        mNumberFormat.setRoundingMode(roundingMode);
    }   
    
    /**
     * Obtains pattern to format values and unit together into a single string.
     * {0} corresponds to the value, {1} corresponds to the unit part.
     * @return pattern to format values and unit together.
     */
    public String getValueAndUnitFormatPattern() {
        return mValueAndUnitFormatPattern;
    }
    
    /**
     * Sets pattern to format values and unit together into a single string.
     * {0} corresponds to the value, {1} corresponds to the unit part.
     * @param valueAndUnitFormatPattern pattern to format values and unit 
     * together.
     */
    public void setValueAndUnitFormatPattern(String valueAndUnitFormatPattern) {
        mValueAndUnitFormatPattern = valueAndUnitFormatPattern;
    }
        
    /**
     * Finds measure unit from its string representation.
     * @param source unit string representation.
     * @return a measure unit.
     */
    protected abstract U findUnit(String source);
    
    /**
     * Obtains measure unit symbol.
     * @param unit a measure unit.
     * @return measure unit symbol.
     */
    protected abstract String getUnitSymbol(U unit);
}
