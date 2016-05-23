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
 * Contains a distance value and unit.
 */
public class Distance extends Measurement<DistanceUnit> {
    
    /**
     * Constructor.
     */
    protected Distance() {
        super();
    }
    
    /**
     * Constructor with value and unit.
     * @param value distance value.
     * @param unit unit of distance.
     * @throws IllegalArgumentException if either value or unit is null.
     */
    public Distance(Number value, DistanceUnit unit) 
            throws IllegalArgumentException {
        super(value, unit);
    }
}