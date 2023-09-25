package com.payback.core;

import com.payback.application.LocationFilterService;
import com.payback.core.validation.QuerySearchValidator;
import com.payback.adapters.externalmodels.Place;
import com.payback.model.PlaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationFilterServiceImpl implements LocationFilterService {

    private final LocationMapper locationMapper;
    private final DistanceCalculator distanceCalculator;
    private final QuerySearchValidator querySearchValidator;

    @Override
    public List<PlaceDTO> filter(List<Place> places, String filter, double lat, double lng) {

        Consumer<Place> enrichLocationByDistance = place
                -> place.setDistance(distanceCalculator.calculateDistance(
                lat, lng, place.getLat(), place.getLon()));

        return places.stream()
                .filter(location -> querySearchValidator.validate(location, filter))
                .peek(enrichLocationByDistance)
                .map(location -> locationMapper.map(location))
                .sorted(Comparator.comparingDouble(PlaceDTO::getDistance).reversed())
                .collect(Collectors.toList());

    }

}

