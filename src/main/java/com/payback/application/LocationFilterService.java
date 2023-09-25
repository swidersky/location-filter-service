package com.payback.application;

import com.payback.adapters.externalmodels.Place;
import com.payback.model.PlaceDTO;

import java.util.List;

public interface LocationFilterService {

    List<PlaceDTO> filter(List<Place> places, String filter, double lat, double lng);

}
