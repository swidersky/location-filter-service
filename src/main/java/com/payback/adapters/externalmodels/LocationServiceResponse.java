package com.payback.adapters.externalmodels;

import lombok.Data;

import java.util.List;

@Data
public class LocationServiceResponse {

    private List<Place> places;
    private int version;

}
