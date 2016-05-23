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

import net.sf.geographiclib.Geodesic;
import net.sf.geographiclib.GeodesicData;
import net.sf.geographiclib.GeodesicMask;

/**
 * Helper class to estimate dinstance between two points expressed in latitude
 * and longitude coordinates in degrees.
 * This method assumes that Earth is a perfect sphere.
 */
public class LocationDistanceEstimator {
    /**
     * Earth radius expressed in kilometers.
     */
    public static final double EQUATORIAL_EARTH_RADIUS = 6378.1370;
    
    /**
     * Conversion factor to convert degrees to radians.
     */
    public static final double DEGREES_TO_RADIANS = Math.PI / 180.0;

    /**
     * Conversion factor of Kilometers to meters.
     */
    public static final double KILOMETERS_TO_METERS = 1000.0;

    /**
     * Constructor.
     */
    protected LocationDistanceEstimator() { }

    /**
     * Returns distance in meters between provided points.
     * This method assumes that Earth is an ellipsoid and computes the geodesic
     * distance between provided points.
     * @param latitude1 latitude of 1st point expressed in degrees.
     * @param longitude1 longitude of 1st point expressed in degrees.
     * @param latitude2 latitude of 2nd point expressed in degrees.
     * @param longitude2 longitude of 2nd point expressed in degrees.
     * @return distance in meters between provided points.
     */
    public static double distanceInMeters(double latitude1, double longitude1, 
            double latitude2, double longitude2) {
        GeodesicData g = Geodesic.WGS84.Inverse(latitude1, longitude1, 
                latitude2, longitude2, GeodesicMask.DISTANCE); 
        return g.s12;
    }

    /**
     * Returns distance in kilometers between provided points.
     * This method assumes that Earth is an ellipsoid and computes the geodesic
     * distance between provided points.
     * @param latitude1 latitude of 1st point expressed in degrees.
     * @param longitude1 longitude of 1st point expressed in degrees.
     * @param latitude2 latitude of 2nd point expressed in degrees.
     * @param longitude2 longitude of 2nd point expressed in degrees.
     * @return distance in kilometers between provided points.
     */
    public static double distanceInKilometers(double latitude1, 
            double longitude1, double latitude2, double longitude2) {
        return distanceInMeters(latitude1, longitude1, latitude2, longitude2) /
                KILOMETERS_TO_METERS;
    }    
    
    /**
     * Returns distance in kilometers between provided points assuming that
     * Earth is perfectly spherical.
     * Computed distances are only accurate for small distances.
     * If more precise (although more expensive to compute) distances are 
     * required then use distanceInKilometers(double, double, double, double)
     * instead.
     * @param latitude1 latitude of 1st point expressed in degrees.
     * @param longitude1 longitude of 1st point expressed in degrees.
     * @param latitude2 latitude of 2nd point expressed in degrees.
     * @param longitude2 longitude of 2nd point expressed in degrees.
     * @return distance in kilometers between provided points.
     */
    public static double approximateDistanceInKilometers(double latitude1,
            double longitude1, double latitude2, double longitude2) {
        return approximateDistanceInKilometers(latitude1, longitude1,
                latitude2, longitude2, EQUATORIAL_EARTH_RADIUS);
    }
    
    /**
     * Computes distance between two points using units of provided radius on
     * a given Spehere.
     * This method assumes that Earth is perfectly spherical, hence distance
     * computations are only accurate for small distances.
     * If more precise (although more expensive to compute) distances are 
     * required then use distanceInKilometers(double, double, double, double)
     * instead.
     * @param latitude1 latitude of 1st point expressed in degrees.
     * @param longitude1 longitude of 1st point expressed in degrees.
     * @param latitude2 latitude of 2nd point expressed in degrees.
     * @param longitude2 longitude of 2nd point expressed in degrees.
     * @param radius radius of a Sphere.
     * @return distance expressed in same units as provided radius.
     * @throws IllegalArgumentException if radius is negative.
     */
    public static double approximateDistanceInKilometers(double latitude1, 
            double longitude1, double latitude2, double longitude2, 
            double radius) throws IllegalArgumentException {

        if (radius < 0.0) {
            throw new IllegalArgumentException();
        }
        double dlong = (longitude2 - longitude1) * DEGREES_TO_RADIANS;
        double dlat = (latitude2 - latitude1) * DEGREES_TO_RADIANS;
        double a = Math.pow(Math.sin(dlat / 2D), 2D) + 
                Math.cos(latitude1 * DEGREES_TO_RADIANS) * 
                Math.cos(latitude2 * DEGREES_TO_RADIANS)
                * Math.pow(Math.sin(dlong / 2D), 2D);
        double c = 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
        double d = radius * c;

        return d;        
    }
}
