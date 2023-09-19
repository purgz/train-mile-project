package com.hbrooks.trainmileage.trainstation;

import com.hbrooks.trainjourney.TrainJourney;

import java.util.List;

public interface TrainStationService {

    TrainStation findByCrs(String crs);

    List<TrainStation> findStationsForJourney(TrainJourney trainJourney);
}
