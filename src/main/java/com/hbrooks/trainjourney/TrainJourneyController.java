package com.hbrooks.trainjourney;


import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        return trainJourneyService.createJourney(trainJourneyRequest);
    }
}
