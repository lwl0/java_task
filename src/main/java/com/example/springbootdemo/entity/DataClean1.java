package com.example.springbootdemo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
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


}