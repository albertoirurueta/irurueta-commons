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

import com.irurueta.commons.CommonsException;

/**
 * Base exception class for this package.
 * All exceptions in this package extend from this one.
 */
@SuppressWarnings("WeakerAccess")
public class UnitsException extends CommonsException {
    
    /**
     * Constructor.
     */
    public UnitsException() {
        super();
    }
    
    /**
     * Constructor with String containing message.
     * @param message Message indicating the cuase of the exception.
     */
    public UnitsException(String message) {
        super(message);
    }
    
    /**
     * Constructor with message and cause.
     * @param message message describing the cause of the exception.
     * @param cause instance containing the cause of the exception.
     */
    public UnitsException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor with cause.
     * @param cause instance containing the cause of the exception.
     */
    public UnitsException(Throwable cause) {
        super(cause);
    }
}