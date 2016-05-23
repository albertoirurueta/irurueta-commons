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
package com.irurueta.commons.validators;

/**
 * Base class for all data model validators.
 * All validators implementations of data models should extends this class.
 *
 * @param <T> model of data to be validated.
 */
public abstract class Validator<T> {

    /**
     * Indicates whether data model is valid or not.
     * @param obj object to be validated.
     * @return true if object is valid, false otherwise.
     */
    public abstract boolean isValid(T obj);
}
