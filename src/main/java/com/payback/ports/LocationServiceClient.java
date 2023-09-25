package com.payback.ports;

import com.payback.adapters.externalmodels.LocationServiceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="locationService", url = "https://payback-coding-challenge.s3.eu-central-1.amazonaws.com/germany.json")
public interface LocationServiceClient {

    @GetMapping
    LocationServiceResponse getLocations();

}
