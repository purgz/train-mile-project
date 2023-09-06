package com.hbrooks.trainstation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainStationServiceImpl implements TrainStationService {

    private TrainStationRepository trainStationLocationRepository;

    @Autowired
    public TrainStationServiceImpl(TrainStationRepository trainStationLocationRepository){
        this.trainStationLocationRepository = trainStationLocationRepository;
    }

    //finds the location info for a train station based on the CRS code - unique 3 letter identifier
    @Override
    public TrainStation findByCrs(String crs) {

        Optional<TrainStation> result = trainStationLocationRepository.findById(crs);

        TrainStation trainStationLocation = null;

        if (result.isPresent()){
            trainStationLocation = result.get();
        } else {
            System.out.println("Couldn't find station " + crs);
        }

        return trainStationLocation;
    }
}
