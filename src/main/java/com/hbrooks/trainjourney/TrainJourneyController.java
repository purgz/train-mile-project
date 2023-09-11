package com.hbrooks.trainjourney;


import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
public class TrainJourneyController {

    private TrainJourneyService trainJourneyService;

    @Autowired
    public TrainJourneyController(TrainJourneyService trainJourneyService) {
        this.trainJourneyService = trainJourneyService;
    }

    @PostMapping("/journeys")
    public TrainJourney addJourney(@RequestBody TrainJourneyRequest trainJourneyRequest){

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

    @DeleteMapping("/journeys/{journeyId}")
    public String deleteEmployee(@PathVariable int journeyId){

        TrainJourney journey = trainJourneyService.findById(journeyId);

        if (journey == null){
            throw new RuntimeException("Journey with id " + journeyId + " not found");
        }

        trainJourneyService.deleteJourneyById(journeyId);

        return "Deleted journey with id " + journeyId;
    }
}
