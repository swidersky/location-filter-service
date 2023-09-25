package com.payback.core;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DistanceCalculator {

    final double R = 6371;

    public Double calculateDistance(double lat1, double lng1, double lat2, double lng2) {

        // Convert latitude and longitude from degrees to radians
        lat1 = Math.toRadians(lat1);
        lng1 = Math.toRadians(lng1);

        lat2 = Math.toRadians(lat2);
        lng2 = Math.toRadians(lng2);

        // Haversine formula
        double dlat = lat2 - lat1;
        double dlon = lng2 - lng1;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        // Calculate the distance
        double distance = R * c;

        return distance;
    }

}
