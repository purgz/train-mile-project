package com.hbrooks.trainmileage.trainstation;

import com.hbrooks.trainjourney.TrainJourney;
import com.hbrooks.trainjourney.TrainJourneyStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<TrainStation> findStationsForJourney(TrainJourney trainJourney) {

        List<TrainStation> stationList = new ArrayList<>();

        TrainStation trainStation = null;


        for (TrainJourneyStop stop : trainJourney.getAllStops()){

            String crs = stop.getCrsCode();

            Optional<TrainStation> station = trainStationLocationRepository.findById(crs);

            if (station.isPresent()){
                stationList.add(station.get());
            } else {
                System.out.println("didnt find");
                throw new RuntimeException("Did not find station with crs code " + crs);
            }
        }

        return stationList;
    }


}
