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
package com.irurueta.commons.validators;

/**
 * Validates RFC (Registro Federal de Contribuyentes) for Mexico.
 */
@SuppressWarnings("WeakerAccess")
public class RFCValidator {
    /**
     * Regular expression to validate RFC (Registro Federal de Contribuyentes).
     */
    public static final String RFC_REGEX = "^[A-Za-z]{3,4}[ |\\-]{0,1}[0-9]{6}[ |\\-]{0,1}[0-9A-Za-z]{3}$";

    /**
     * Constructor.
     */
    protected RFCValidator() { }

    /**
     * Indicates whether provided RFC has a valid format.
     * @param value RFC to be validated.
     * @return true if RFC has a valid format, false otherwise.
     */
    public static boolean isValid(String value) {
        return value != null && value.matches(RFC_REGEX);
    }
}
