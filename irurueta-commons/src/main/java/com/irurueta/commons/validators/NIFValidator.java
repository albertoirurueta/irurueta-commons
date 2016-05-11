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

import com.aeat.valida.Validador;
import java.lang.ref.SoftReference;

/**
 * Validates provided NIF (Número de Identificación Fiscal) values for Spain.
 * This class is a wrapper for the library provided by Spain's Ministerio de 
 * Hacienda to validate DNI's, NIF's, NIE's, CIF's, etc.
 *
 */
public class NIFValidator {
    /**
     * Reference to the internal validator provided by Ministerio de
     * Hacienda.
     */
    private static SoftReference<Validador> mValRef;

    /**
     * Constructor.
     */
    protected NIFValidator() { }

    /**
     * Checks whether provided value is a valid DNI, NIF, NIE or CIF.
     * @param value DNI, NIF, NIE or CIF to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValid(String value) {
        int code = getOrCreateValidador().checkNif(value);
        return isValidDNICode(code) || isValidNIFCode(code) ||
                isValidNIFNonResidentsCode(code) ||
                isValidNIFMinorsCode(code) || isValidNIECode(code) ||
                isValidCIFCode(code) ||
                isValidCIFOrganizationCode(code) ||
                isValidCIFNonResidentsCode(code);
    }

    /**
     * Checks whether provided value is a valid DNI (Documento Nacional de
     * Identidad).
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidDNI(String value) {
        return isValidDNICode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to the code of a valid DNI.
     * @param code code to be validated.
     * @return true if code corresponds to a valid DNI, false otherwise.
     */
    protected static boolean isValidDNICode(int code) {
        return code == Validador.DNI_OK;
    }

    /**
     * Checks whether provided value is a valid NIF (Número de
     * Identificación Fiscal).
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidNIF(String value) {
        return isValidNIFCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks if provided code corresponds to a valid NIF code.
     * @param code code to be validated.
     * @return true if code corresponds to a valid NIF code, false
     * otherwise.
     */
    protected static boolean isValidNIFCode(int code) {
        return code == Validador.NIF_OK;
    }

    /**
     * Checks whether provided value corresponds to a valid non-resident
     * NIF.
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidNIFNonResidents(String value) {
        return isValidNIFNonResidentsCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid non-resident NIF.
     * @param code code to be validated.
     * @return true if code corresponds to a valid non-resident  NIF, false
     * otherwise.
     */
    protected static boolean isValidNIFNonResidentsCode(int code) {
        return code == Validador.NIF_NORESIDENTES;
    }

    /**
     * Checks whether provided value corresponds to a valid NIF for minors
     * having less than 14 years old.
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidNIFMinors(String value) {
        return isValidNIFMinorsCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid NIF for minors
     * having less than 14 years old.
     * @param code code to be validated.
     * @return true if code corresponds to a valid NIF for minors having
     * less than 14 years old, false otherwise.
     */
    protected static boolean isValidNIFMinorsCode(int code) {
        return code == Validador.NIF_MENORES14ANOS;
    }

    /**
     * Checks whether provided value corresponds to a valid NIE (Número de
     * Identificación de Extranjeros).
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidNIE(String value) {
        return isValidNIECode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid NIE (Número de
     * Identificación de Extranjeros).
     * @param code code to be validated.
     * @return true if code corresponds to a valid NIE, false otherwise.
     */
    protected static boolean isValidNIECode(int code) {
        return code == Validador.NIF_EXTRANJEROS;
    }

    /**
     * Checks whether provided value corresponds to a valid CIF (Código de
     * Identificación Fiscal).
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidCIF(String value) {
        return isValidCIFCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid CIF (Código de
     * Identificación Fiscal).
     * @param code code to be validated.
     * @return true if code corresponds to a valid CIF, false otherwise.
     */
    public static boolean isValidCIFCode(int code) {
        return code == Validador.CIF_OK;
    }

    /**
     * Checks whether provided value corresponds to a valid Organization
     * CIF.
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidCIFOrganization(String value) {
        return isValidCIFOrganizationCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid Organization CIF
     * code.
     * @param code code to be validated.
     * @return true if code corresponds to a valid Organization CIF, false
     * otherwise.
     */
    public static boolean isValidCIFOrganizationCode(int code) {
        return code == Validador.CIF_ORGANIZACION_OK;
    }

    /**
     * Checks whether provided value corresponds to a valid non-resident
     * CIF.
     * @param value value to be validated.
     * @return true if value is valid, false otherwise.
     */
    public static boolean isValidCIFNonResidents(String value) {
        return isValidCIFNonResidentsCode(getOrCreateValidador().checkNif(value));
    }

    /**
     * Checks whether provided code corresponds to a valid non-resident CIF.
     * @param code code to be validated.
     * @return true if code corresponds to a valid non-resident CIF, false
     * otherwise.
     */
    public static boolean isValidCIFNonResidentsCode(int code) {
        return code == Validador.CIF_NORESIDENTES_OK;
    }

    /**
     * Gets or creates singleton instance to validate DNI's, NIF's, CIF's,
     * etc using the library provided by the Ministerio de Hacienda.
     * @return internal validator provided by Ministerio de Hacienda.
     */
    private static synchronized Validador getOrCreateValidador() {
        if (mValRef == null || mValRef.get() == null) {
            mValRef = new SoftReference<>(new Validador());
        }
        return mValRef.get();
    }
}
