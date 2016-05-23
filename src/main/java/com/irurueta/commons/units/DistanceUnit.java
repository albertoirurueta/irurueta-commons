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

/**
 * Enumerator containing recognized units.
 */
public enum DistanceUnit {
    /**
     * Milimeter distance unit.
     */
    MILIMETER,
    
    /**
     * Centimeter distance unit.
     */
    CENTIMETER,
    
    /**
     * Meter distance unit.
     */
    METER,
    
    /**
     * Kilometer distance unit.
     */
    KILOMETER,
    
    /**
     * Inch distance unit.
     */
    INCH,
    
    /**
     * Foot distance unit.
     */
    FOOT,
    
    /**
     * Yard distance unit.
     */
    YARD,
    
    /**
     * Mile distance unit.
     */
    MILE;

    /**
     * Returns unit system for provided unit.
     * @param unit unit to be checked.
     * @return unit system (metric or imperial).
     * @throws IllegalArgumentException if unit is null or not supported.
     */
    public static UnitSystem getUnitSystem(DistanceUnit unit) 
            throws IllegalArgumentException {

        if (unit == null) {
            throw new IllegalArgumentException();
        }

        switch (unit) {
            case MILIMETER:
            case CENTIMETER:
            case METER:
            case KILOMETER:
                return UnitSystem.METRIC;
            case INCH:
            case FOOT:
            case YARD:
            case MILE:
                return UnitSystem.IMPERIAL;
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Indicates whether provided unit belongs to the metric unit system.
     * @param unit unit to be checked.
     * @return true if unit belongs to metric unit system.
     * @throws IllegalArgumentException if unit is null or not supported.
     */
    public static boolean isMetric(DistanceUnit unit) 
            throws IllegalArgumentException {
        return getUnitSystem(unit) == UnitSystem.METRIC;
    }

    /**
     * Indicates whether provided unit belongs to the imperial unit system.
     * @param unit unit to be checked.
     * @return true if unit belongs to imperial unit system.
     * @throws IllegalArgumentException if nuit is null or not supported.
     */
    public static boolean isImperial(DistanceUnit unit)
            throws IllegalArgumentException {
        return getUnitSystem(unit) == UnitSystem.IMPERIAL;
    }
}
