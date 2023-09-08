package com.hbrooks.trainstation;

import com.hbrooks.searchtrainapi.SearchTrainService;
import com.hbrooks.trainjourney.TrainJourney;
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

        Optional<TrainStation> startStation = trainStationLocationRepository.findById(trainJourney.getStartStation());

        if (startStation.isPresent()){
            stationList.add(startStation.get());
        } else {
            System.out.println("didnt find");
            //throw station not found exception
        }

        for (String crs : trainJourney.getViaStations()){
            Optional<TrainStation> station = trainStationLocationRepository.findById(crs);

            if (station.isPresent()){
                stationList.add(station.get());
            } else {
                System.out.println("didnt find");
                //throw station not found exception
            }
        }

        Optional<TrainStation> endStation = trainStationLocationRepository.findById(trainJourney.getEndStation());

        if (endStation.isPresent()){
            stationList.add(endStation.get());
        } else {
            System.out.println("didnt find");
            //throw station not found exception
        }

        return stationList;
    }


}
