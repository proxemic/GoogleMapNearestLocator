/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsecure.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Dickson
 */
@Embeddable
public class LocationPK implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "LONGITUDE", nullable = false, precision = 10, scale = 6)
    private BigDecimal longitude;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LATITUDE", nullable = false, precision = 10, scale = 6)
    private BigDecimal latitude;

    public LocationPK() {
    }

    public LocationPK(BigDecimal longitude, BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (longitude != null ? longitude.hashCode() : 0);
        hash += (latitude != null ? latitude.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationPK)) {
            return false;
        }
        LocationPK other = (LocationPK) object;
        if ((this.longitude == null && other.longitude != null) || (this.longitude != null && !this.longitude.equals(other.longitude))) {
            return false;
        }
        if ((this.latitude == null && other.latitude != null) || (this.latitude != null && !this.latitude.equals(other.latitude))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.LocationPK[ longitude=" + longitude + ", latitude=" + latitude + " ]";
    }
    
}
