/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Dickson
 */
@Entity
@Table(name = "LOCATION", catalog = "", schema = "APP")
public class LocationEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocationPK locationPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_BUILDING", nullable = false)
    private boolean isBuilding;
    
    public LocationEntity() {
    }

    public LocationEntity(LocationPK locationPK) {
        this.locationPK = locationPK;
    }

    public LocationEntity(LocationPK locationPK, String name, boolean isBuilding) {
        this.locationPK = locationPK;
        this.name = name;
        this.isBuilding = isBuilding;
    }

    public LocationEntity(BigDecimal longitude, BigDecimal latitude) {
        this.locationPK = new LocationPK(longitude, latitude);
    }

    public LocationPK getLocationPK() {
        return locationPK;
    }

    public void setLocationPK(LocationPK locationPK) {
        this.locationPK = locationPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsBuilding() {
        return isBuilding;
    }

    public void setIsBuilding(boolean isBuilding) {
        this.isBuilding = isBuilding;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationPK != null ? locationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof LocationEntity)) {
            return false;
        }
        LocationEntity other = (LocationEntity) object;
        if (this.locationPK.getLatitude() == other.locationPK.getLatitude() && this.locationPK.getLongitude() == other.locationPK.getLongitude()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "LocationEntity[ "
                + "longitude=" + locationPK.getLongitude() + ", "
                + "latitude=" + locationPK.getLatitude() + ", "
                + "name=" + getName() + ", "
                + "isBuilding=" + getIsBuilding() + " "
                + "]";
    }
}
