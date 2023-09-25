package com.payback.adapters.externalmodels;

import lombok.Data;

import java.util.List;

@Data
public class Place {

    private int id;
    private double lat;
    private double lon;
    private String name;
    private String partnerId;
    private String placeId;
    private boolean wifiCheckinEnabled;
    private List<Wifi> wifis;
    private String city;
    private String countryCode;
    private String street;
    private String zipCode;
    private List<String> features;
    // extra field which should be enrich by the logic
    private Double distance;

}
