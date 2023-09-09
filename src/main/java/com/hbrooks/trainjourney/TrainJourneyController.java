package com.hbrooks.trainjourney;


import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journey")
public class TrainJourneyController {

    private TrainJourneyService trainJourneyService;

    @Autowired
    public TrainJourneyController(TrainJourneyService trainJourneyService) {
        this.trainJourneyService = trainJourneyService;
    }

    @GetMapping("/add")
    public TrainJourney addJourney(@RequestBody TrainJourneyRequest trainJourneyRequest){

        //creates a new journey with all the stops given and returns journey object

        //journey object not includes all the stops which the train will make along the journey

        //this data can be used to make a more accurate plot of the route the train will take

        return trainJourneyService.createJourney(trainJourneyRequest);
    }

    @GetMapping("/service-details-list")
    public List<ServiceDetails> serviceDetailsList(@RequestBody TrainJourneyRequest trainJourneyRequest){

        return trainJourneyService.findServicesForJourney(trainJourneyRequest);
    }

    //not finished yet
    @GetMapping("/journeys")
    public List<TrainJourney> getAllJourneys(){

        return trainJourneyService.findAllJourneys();
    }
}
