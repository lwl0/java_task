package com.example.springbootdemo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "task.data_clean1")
public class DataClean1 {
    @Id
    private String id;

    private String time;

    private Double latitude;

    private Double longitude;

    private Double depth;

    private Double mag;

    @Column(name = "magType")
    private String magtype;

    private Integer nst;

    private Double gap;

    private Double dmin;

    private Double rms;

    private String net;

    private String updated;

    private String place;

    private String type;

    @Column(name = "horizontalError")
    private Double horizontalerror;

    @Column(name = "depthError")
    private Double deptherror;

    @Column(name = "magError")
    private Double magerror;

    @Column(name = "magNst")
    private Integer magnst;

    private String status;

    @Column(name = "locationSource")
    private String locationsource;

    @Column(name = "magSource")
    private String magsource;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * @return depth
     */
    public Double getDepth() {
        return depth;
    }

    /**
     * @param depth
     */
    public void setDepth(Double depth) {
        this.depth = depth;
    }

    /**
     * @return mag
     */
    public Double getMag() {
        return mag;
    }

    /**
     * @param mag
     */
    public void setMag(Double mag) {
        this.mag = mag;
    }

    /**
     * @return magType
     */
    public String getMagtype() {
        return magtype;
    }

    /**
     * @param magtype
     */
    public void setMagtype(String magtype) {
        this.magtype = magtype;
    }

    /**
     * @return nst
     */
    public Integer getNst() {
        return nst;
    }

    /**
     * @param nst
     */
    public void setNst(Integer nst) {
        this.nst = nst;
    }

    /**
     * @return gap
     */
    public Double getGap() {
        return gap;
    }

    /**
     * @param gap
     */
    public void setGap(Double gap) {
        this.gap = gap;
    }

    /**
     * @return dmin
     */
    public Double getDmin() {
        return dmin;
    }

    /**
     * @param dmin
     */
    public void setDmin(Double dmin) {
        this.dmin = dmin;
    }

    /**
     * @return rms
     */
    public Double getRms() {
        return rms;
    }

    /**
     * @param rms
     */
    public void setRms(Double rms) {
        this.rms = rms;
    }

    /**
     * @return net
     */
    public String getNet() {
        return net;
    }

    /**
     * @param net
     */
    public void setNet(String net) {
        this.net = net;
    }

    /**
     * @return updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @param updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
    }

    /**
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return horizontalError
     */
    public Double getHorizontalerror() {
        return horizontalerror;
    }

    /**
     * @param horizontalerror
     */
    public void setHorizontalerror(Double horizontalerror) {
        this.horizontalerror = horizontalerror;
    }

    /**
     * @return depthError
     */
    public Double getDeptherror() {
        return deptherror;
    }

    /**
     * @param deptherror
     */
    public void setDeptherror(Double deptherror) {
        this.deptherror = deptherror;
    }

    /**
     * @return magError
     */
    public Double getMagerror() {
        return magerror;
    }

    /**
     * @param magerror
     */
    public void setMagerror(Double magerror) {
        this.magerror = magerror;
    }

    /**
     * @return magNst
     */
    public Integer getMagnst() {
        return magnst;
    }

    /**
     * @param magnst
     */
    public void setMagnst(Integer magnst) {
        this.magnst = magnst;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return locationSource
     */
    public String getLocationsource() {
        return locationsource;
    }

    /**
     * @param locationsource
     */
    public void setLocationsource(String locationsource) {
        this.locationsource = locationsource;
    }

    /**
     * @return magSource
     */
    public String getMagsource() {
        return magsource;
    }

    /**
     * @param magsource
     */
    public void setMagsource(String magsource) {
        this.magsource = magsource;
    }
}