package com.hbrooks.trainmileage;

public interface MileageService {

    float getDistanceBetweenTwoStations(String originCRS, String destinationCRS);

    float getDistanceWithExtraLocations(MileageRequest mileageRequest);
}
