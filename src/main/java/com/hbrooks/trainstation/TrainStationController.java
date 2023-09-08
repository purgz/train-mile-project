package com.hbrooks.trainstation;

import com.hbrooks.trainjourney.TrainJourney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/station")
public class TrainStationController {

    private TrainStationService trainStationService;

    @Autowired
    public TrainStationController(TrainStationService trainStationService) {
        this.trainStationService = trainStationService;
    }

    @GetMapping("/station-locations")
    public List<TrainStation> getStationListForJourney(@RequestBody TrainJourney trainJourney){

        return trainStationService.findStationsForJourney(trainJourney);
    }
}
