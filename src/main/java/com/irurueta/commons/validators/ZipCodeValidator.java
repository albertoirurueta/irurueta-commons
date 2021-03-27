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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Validates post codes based on county ISO codes.
 */
public class ZipCodeValidator implements Validator<String> {

    /**
     * Regular expression to validate post codes in Spain.
     */
    public static final String ES_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in France.
     */
    public static final String FR_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in Germany.
     */
    public static final String DE_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in Italy.
     */
    public static final String IT_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in Portugal.
     */
    public static final String PT_ZIPCODE_REGEX = "^[0-9]{4}(-[0-9]{3})?(\\s.*)?$";

    /**
     * Regular expression to validate post codes in UK.
     */
    public static final String GB_ZIPCODE_REGEX = "^(GIR 0AA)|(((A[BL]|B[ABDHLNRSTX]?|C[ABFHMORTVW]|D[ADEGHLNTY]|E[HNX]?|F[KY]|G[LUY]?|H[ADGPRSUX]|I[GMPV]|JE|K[ATWY]|L[ADELNSU]?|M[EKL]?|N[EGNPRW]?|O[LX]|P[AEHLOR]|R[GHM]|S[AEGKLMNOPRSTY]?|T[ADFNQRSW]|UB|W[ADFNRSV]|YO|ZE)[1-9]?[0-9]|((E|N|NW|SE|SW|W)1|EC[1-4]|WC[12])[A-HJKMNPR-Y]|(SW|W)([2-9]|[1-9][0-9])|EC[1-9][0-9]) [0-9][ABD-HJLNP-UW-Z]{2})$";

    /**
     * Regular expression to validate post codes in Austria.
     */
    public static final String AT_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Ireland.
     */
    public static final String IE_ZIPCODE_REGEX = "^.*$";

    /**
     * Regular expression to validate post codes in Belgium.
     */
    public static final String BE_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Netherlands.
     */
    public static final String NL_ZIPCODE_REGEX = "^[0-9]{4}[A-Z]{2}$";

    /**
     * Regular expression to validate post codes in Luxembourg.
     */
    public static final String LU_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Monaco.
     */
    public static final String MC_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in Switzerland.
     */
    public static final String CH_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Norway.
     */
    public static final String NO_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Denmark.
     */
    public static final String DK_ZIPCODE_REGEX = "^[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Sweden.
     */
    public static final String SE_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in Finland.
     */
    public static final String FI_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Regular expression to validate post codes in USA.
     */
    public static final String US_ZIPCODE_REGEX = "^([0-9]{5}|[0-9]{5}-[0-9]{4}|[0-9]{5}-[0-9]{5})$";

    /**
     * Regular expression to validate post codes in Japan.
     */
    public static final String JP_ZIPCODE_REGEX = "^[0-9]{3}-[0-9]{4}$";

    /**
     * Regular expression to validate post codes in Poland.
     */
    public static final String PL_ZIPCODE_REGEX = "^[0-9]{2}-[0-9]{3}$";

    /**
     * Regular expression to validate post codes in China.
     */
    public static final String CN_ZIPCODE_REGEX = "^[0-9]{6}$";

    /**
     * Regular expression to validate post codes in Canada.
     */
    public static final String CA_ZIPCODE_REGEX = "^[A-Z]{1}\\d{1}[A-Z]{1} *\\d{1}[A-Z]{1}\\d{1}$";

    /**
     * Regular expression to validate post codes in Russia.
     */
    public static final String RU_ZIPCODE_REGEX = "^[0-9]{6}$";

    /**
     * Regular expression to validate post codes in Greece.
     */
    public static final String GR_ZIPCODE_REGEX = "^\\d{3} ?\\d{2}$";

    /**
     * Regular expression to validate post codes in South Korea.
     */
    public static final String KR_ZIPCODE_REGEX = "^[0-9]{3}-[0-9]{3}$";

    /**
     * Regular expression to validate post codes in Romania.
     */
    public static final String RO_ZIPCODE_REGEX = "^[0-9]{6}$";

    /**
     * Regular expression to validate post codes in Mexico.
     */
    public static final String MX_ZIPCODE_REGEX = "^\\d{5}$";

    /**
     * Regular expression to validate post codes in Taiwan.
     */
    public static final String TW_ZIPCODE_REGEX = "^[1-9]{1}[0-9]{2}";

    /**
     * Regular expression to validate post codes in Macao.
     */
    public static final String MO_ZIPCODE_REGEX = "^\\d*$";

    /**
     * Regular expression to validate post codes in Hong Kong.
     */
    public static final String HK_ZIPCODE_REGEX = "^\\d*$";

    /**
     * Regular expression to validate post codes in Turkey.
     */
    public static final String TR_ZIPCODE_REGEX = "^[0-9]{5}$";

    /**
     * Map that relates country codes with their respective regular expressions to validate post codes.
     */
    private final Map<String, String> mMap;

    /**
     * ISO 3166 country code to use to validate post codes.
     */
    private String mCountryCode;

    /**
     * Pattern to validate post codes using a regular expression.
     */
    private Pattern mPostCodePattern;

    /**
     * Constructor.
     */
    protected ZipCodeValidator() {
        mMap = new HashMap<>();
        mMap.put("ES", ES_ZIPCODE_REGEX);
        mMap.put("FR", FR_ZIPCODE_REGEX);
        mMap.put("DE", DE_ZIPCODE_REGEX);
        mMap.put("IT", IT_ZIPCODE_REGEX);
        mMap.put("PT", PT_ZIPCODE_REGEX);
        mMap.put("GB", GB_ZIPCODE_REGEX);
        mMap.put("AT", AT_ZIPCODE_REGEX);
        mMap.put("IE", IE_ZIPCODE_REGEX);
        mMap.put("BE", BE_ZIPCODE_REGEX);
        mMap.put("NL", NL_ZIPCODE_REGEX);
        mMap.put("LU", LU_ZIPCODE_REGEX);
        mMap.put("MC", MC_ZIPCODE_REGEX);
        mMap.put("CH", CH_ZIPCODE_REGEX);
        mMap.put("NO", NO_ZIPCODE_REGEX);
        mMap.put("DK", DK_ZIPCODE_REGEX);
        mMap.put("SE", SE_ZIPCODE_REGEX);
        mMap.put("FI", FI_ZIPCODE_REGEX);
        mMap.put("US", US_ZIPCODE_REGEX);
        mMap.put("JP", JP_ZIPCODE_REGEX);
        mMap.put("PL", PL_ZIPCODE_REGEX);
        mMap.put("CN", CN_ZIPCODE_REGEX);
        mMap.put("CA", CA_ZIPCODE_REGEX);
        mMap.put("RU", RU_ZIPCODE_REGEX);
        mMap.put("GR", GR_ZIPCODE_REGEX);
        mMap.put("KR", KR_ZIPCODE_REGEX);
        mMap.put("RO", RO_ZIPCODE_REGEX);
        mMap.put("MX", MX_ZIPCODE_REGEX);
        mMap.put("TW", TW_ZIPCODE_REGEX);
        mMap.put("MO", MO_ZIPCODE_REGEX);
        mMap.put("HK", HK_ZIPCODE_REGEX);
        mMap.put("TR", TR_ZIPCODE_REGEX);
    }

    /**
     * Constructor.
     *
     * @param countryCode ISO 3166 county code.
     */
    public ZipCodeValidator(final String countryCode) {
        this();
        setCountryCode(countryCode);
    }

    /**
     * Constructor.
     *
     * @param locale locale associated to an ISO 3166 county code.
     */
    public ZipCodeValidator(final Locale locale) {
        this();
        setCountryCodeFrom(locale);
    }

    /**
     * Returns ISO 3166 country code associated to this instance.
     *
     * @return ISO 3166 country code associated to this instance.
     */
    public String getCountryCode() {
        return mCountryCode;
    }

    /**
     * Sets ISO 3166 country code associated to this instance.
     *
     * @param countryCode ISO 3166 country code associated to this instance.
     */
    public final void setCountryCode(final String countryCode) {
        mCountryCode = countryCode;
        buildPattern();
    }

    /**
     * Sets ISO 3166 country code associated to this instance.
     *
     * @param locale locale associated to an ISO 3166 country code.
     */
    public final void setCountryCodeFrom(final Locale locale) {
        mCountryCode = locale != null ? locale.getCountry() : null;
        buildPattern();
    }

    /**
     * Checks whether provided post code has a valid format for the configured country.
     *
     * @param zipCode post code to be validated.
     * @return true if post code is valid, false otherwise.
     */
    @Override
    public boolean isValid(final String zipCode) {
        return mPostCodePattern == null || zipCode != null && mPostCodePattern.matcher(zipCode).matches();
    }

    /**
     * Initializes regular expression.
     */
    private void buildPattern() {
        mPostCodePattern = null;

        if (mCountryCode != null) {
            final String regex = mMap.get(mCountryCode);
            if (regex != null) {
                mPostCodePattern = Pattern.compile(regex);
            }
        }
    }
}
