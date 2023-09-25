package com.payback.core;

import com.payback.adapters.externalmodels.Place;
import com.payback.model.AddressDTO;
import com.payback.model.PlaceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationMapper {

    private final DistanceCalculator distanceCalculator;

    public PlaceDTO map(Place place){

        PlaceDTO placeDTO = new PlaceDTO();

        placeDTO.setName(place.getName());
        placeDTO.setAddress(getAddress(place));
        placeDTO.setDistance(place.getDistance());

        return placeDTO;

    }

    private AddressDTO getAddress(Place place) {

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setCity(place.getCity());
        addressDTO.setStreet(place.getStreet());
        addressDTO.setZipCode(place.getZipCode());

        return addressDTO;

    }


}
