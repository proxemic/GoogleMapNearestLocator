/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.base;

import com.fsecure.business.LocationManager;

/**
 *
 * @author Dickson
 */
public class ManagerService {
    private static LocationManager locationManager;
    
    public static LocationManager getLocationManager(){
        if (locationManager == null) {
            locationManager = new LocationManager();
        }
        return locationManager;
    }
}
