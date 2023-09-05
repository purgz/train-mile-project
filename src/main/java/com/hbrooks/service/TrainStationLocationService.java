package com.hbrooks.service;

import com.hbrooks.entity.TrainStationLocation;

public interface TrainStationLocationService {

    TrainStationLocation findByCrs(String crs);
}
