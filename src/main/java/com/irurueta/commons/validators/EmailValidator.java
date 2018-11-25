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

import java.lang.ref.SoftReference;
import java.util.regex.Pattern;

/**
 * Validates email format.
 */
@SuppressWarnings("WeakerAccess")
public class EmailValidator implements Validator<String> {

    /**
     * Regular expression to validate email format.
     */
    public static final String EMAIL_FORMAT_REGEX = 
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";

    /**
     * Soft reference to the singleton of this class.
     */
    private static SoftReference<EmailValidator> mSingleton;

    /**
     * Pattern to validate email addresses using regular expression defined in
     * EMAIL_FORMAT_REGEX.
     */
    private Pattern mEmailPattern;

    /**
     * Constructor.
     */
    private EmailValidator() {
        mEmailPattern = Pattern.compile(EMAIL_FORMAT_REGEX);
    }

    /**
     * Creates or obtains the singleton instance of this class.
     * @return singleton instance of this class.
     */
    public static synchronized EmailValidator getInstance() {
        EmailValidator validator;
        if (mSingleton == null || (validator = mSingleton.get()) == null) {
            validator = new EmailValidator();
            mSingleton = new SoftReference<>(validator);
        }
        return validator;
    }

    /**
     * Indicates whether provided email has a valid format.
     * @param email email to be checked.
     * @return true if email is valid, false otherwise.
     */
    @Override
    public boolean isValid(String email) {
        return email != null && mEmailPattern.matcher(email).matches();
    }
}
