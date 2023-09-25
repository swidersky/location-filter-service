package com.payback.web;

import com.payback.api.LocationsApi;
import com.payback.ports.DataSource;
import com.payback.adapters.externalmodels.LocationServiceResponse;
import com.payback.adapters.externalmodels.Place;
import com.payback.application.LocationFilterService;
import com.payback.model.PlaceDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class LocationController implements LocationsApi {

    private final DataSource<LocationServiceResponse> locationProvider;
    private final LocationFilterService locationFilterService;


    @Override
    public ResponseEntity<List<PlaceDTO>> getLocations(List<Double> coords, String filter) {
        List<Place> places = locationProvider.getData().getPlaces();
        return ResponseEntity.ok(locationFilterService.filter(places, filter, coords.get(0), coords.get(1)));

    }
}
