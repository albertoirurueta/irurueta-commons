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
package com.irurueta.commons;

/**
 * Utility class to compute Levenshtein distance (number of
 * substitutions/modifications) between two arrays or strings.
 * Levenshtein distance is an approximate comparison measure that has into
 * account the number of modifications, added or removed elements required to
 * make two collections equal. Thus, this distance measure is appropriate to
 * compare similar but not exactly equal Strings (to take into account
 * typographic errors, etc).
 */
public class EditDistance {

    /**
     * Constructor.
     */
    protected EditDistance() {
    }

    /**
     * Computes Levenshtein distance between two Strings.
     *
     * @param x 1st String.
     * @param y 2nd String.
     * @return Levenshtein distance.
     */
    public static int stringDistance(final String x, final String y) {
        return distance(new StringArrayWrapper(x), new StringArrayWrapper(y));
    }

    /**
     * Computes Levenshtein distance between two arrays of objects of type
     * T.
     * NOTE: this method cannot be used with arrays of primitive types,
     * instead an array of wrappers of primitive objects must be used or
     * this class must be extended to add implementations of ArrayWrappers
     * for all primitive types that must be supported.
     *
     * @param x   1st array of objects of type T.
     * @param y   2nd array of objects of type T.
     * @param <T> type of arrays.
     * @return Levenshtein distance.
     */
    public static <T> int distance(final T[] x, final T[] y) {
        return distance(new GenericArrayWrapper<>(x),
                new GenericArrayWrapper<>(y));
    }

    /**
     * Computes Levenshtein distance between two arrays of type T. To compute
     * this distance an ArrayWrapper is used to make a more efficient access to
     * primitive datatypes or strings.
     *
     * @param x   1st array of objects of type T.
     * @param y   2nd array of objects of type T.
     * @param <T> type of arrays.
     * @return Levenshtein distance.
     */
    private static <T> int distance(final ArrayWrapper<T> x, final ArrayWrapper<T> y) {

        // validate parameters
        if (x == null || y == null) {
            throw new IllegalArgumentException();
        }

        // Obtains length of both parameters. If one of them is 0, we return the
        // length of the other, since that number of insertions will be required
        final int n = x.length();
        final int m = y.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }

        // Instead of keeping a whole matrix (which would require an O(n*m)
        // space, we just keep current and next rows, both of which have a length
        // of m+1, and hence only O(n) space is required.
        // Initialize current row.
        int curRow = 0;
        int nextRow = 1;
        final int[][] rows = new int[][]{new int[m + 1], new int[m + 1]};
        for (int j = 0; j <= m; ++j) {
            rows[curRow][j] = j;
        }

        // for each virtual row (since we only keep two)
        for (int i = 1; i <= n; ++i) {
            // fill values of row
            rows[nextRow][0] = i;
            for (int j = 1; j <= m; ++j) {
                final int dist1 = rows[curRow][j] + 1;
                final int dist2 = rows[nextRow][j - 1] + 1;
                final int dist3 = rows[curRow][j - 1] +
                        (x.equals(y, i - 1, j - 1) ? 0 : 1);

                rows[nextRow][j] = Math.min(dist1, Math.min(dist2, dist3));
            }

            // exchanges current and next rows
            if (curRow == 0) {
                curRow = 1;
                nextRow = 0;
            } else {
                curRow = 0;
                nextRow = 1;
            }
        }

        // returns computed distance
        return rows[curRow][m];
    }

    /**
     * Interface used as a wrapper for arrays of type T used to generalized
     * efficient acces to elements of an array of a generic data type T.
     * String implementations are provided as well as implementations for
     * generic objects of type T. If primitive data types arrays must be
     * supported, theen the necessary implementation will need to be added
     * similarly to existent ones.
     *
     * @param <T> generic data type.
     */
    protected interface ArrayWrapper<T> {
        /**
         * Obtains length of array.
         *
         * @return length of array.
         */
        int length();

        /**
         * Compares this array in position x, with the other object at position
         * y.
         *
         * @param other the other array wrapper.
         * @param posX  position within this array that must be comapared.
         * @param posY  position within the other array that must be compared.
         * @return true if elements in provided positions are equal, false
         * otherwise.
         */
        boolean equals(final ArrayWrapper<T> other, final int posX, final int posY);
    }

    /**
     * Specific implementation of ArrayWrapper for Strings.
     * Allows efficient comparison of String elements in a generic way.
     *
     * @author Alberto Irurueta Carro
     */
    protected static class StringArrayWrapper implements ArrayWrapper<String> {
        /**
         * String to be compared.
         */
        private final String mObject;

        /**
         * Constructor.
         *
         * @param object string to be compared.
         */
        public StringArrayWrapper(final String object) {
            mObject = object;
        }

        /**
         * Length of the string to be compared.
         */
        @Override
        public int length() {
            return mObject.length();
        }

        /**
         * Compares the string contained in this instance at position x with
         * the string contained in the other array wrapper at position y.
         *
         * @param other the other String array wrapper.
         * @param posX  position in this array to be compared.
         * @param posY  position in the other array to be compared.
         * @return true if elements in provided positions are considered to
         * be equal, false otherwise.
         */
        @Override
        public boolean equals(final ArrayWrapper<String> other, final int posX,
                              final int posY) {

            if (!(other instanceof StringArrayWrapper)) {
                return false;
            }

            final String otherObject = ((StringArrayWrapper) other).mObject;
            return mObject.charAt(posX) == otherObject.charAt(posY);
        }
    }

    /**
     * Implementation of ArrayWrapper for generic objects of type T.
     * Allows the efficient and generic comparison of objects of type T, as long
     * as T is not a primitive data type.
     *
     * @param <T> generic data type.
     */
    protected static class GenericArrayWrapper<T> implements ArrayWrapper<T[]> {
        /**
         * Generic array of type T to be compared.
         */
        private final T[] mObject;

        /**
         * Constructor.
         *
         * @param object generic array of type T to be compared.
         */
        public GenericArrayWrapper(final T[] object) {
            mObject = object;
        }

        /**
         * Length of array to be compared.
         */
        @Override
        public int length() {
            return mObject.length;
        }

        /**
         * Compares the array contained in this instance at position X with the
         * array contained in the other array wrapper at position Y.
         *
         * @param other the other generic array wrapper.
         * @param posX  position in this array to be compared.
         * @param posY  position in the other array to be compared.
         * @return true if elements in both arrays at provided positions are
         * considered to be equal, false otherwise.
         */
        @Override
        public boolean equals(final ArrayWrapper<T[]> other, final int posX, final int posY) {
            if (!(other instanceof GenericArrayWrapper)) {
                return false;
            }

            final T[] otherObject = ((GenericArrayWrapper<T>) other).mObject;
            return mObject[posX].equals(otherObject[posY]);
        }
    }
}
