package com.hbrooks.service;

import com.hbrooks.dao.TrainStationLocationRepository;
import com.hbrooks.entity.TrainStationLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TrainStationLocationServiceImpl implements TrainStationLocationService{

    private TrainStationLocationRepository trainStationLocationRepository;

    @Autowired
    public TrainStationLocationServiceImpl(TrainStationLocationRepository trainStationLocationRepository){
        this.trainStationLocationRepository = trainStationLocationRepository;
    }

    @Override
    public TrainStationLocation findByCrs(String crs) {

        Optional<TrainStationLocation> result = trainStationLocationRepository.findById(crs);

        TrainStationLocation trainStationLocation = null;

        if (result.isPresent()){
            trainStationLocation = result.get();
        } else {
            throw new RuntimeException("Did not find station with crs: " + crs);
        }

        return trainStationLocation;
    }
}
