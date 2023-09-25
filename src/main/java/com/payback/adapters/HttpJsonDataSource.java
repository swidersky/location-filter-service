package com.payback.adapters;

import com.payback.ports.DataSource;
import com.payback.ports.LocationServiceClient;
import com.payback.adapters.externalmodels.LocationServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HttpJsonDataSource implements DataSource<LocationServiceResponse> {

    private final LocationServiceClient locationServiceClient;

    @Override
    public LocationServiceResponse getData() {

        log.info("Fetching locations");
        return locationServiceClient.getLocations();

    }

}
