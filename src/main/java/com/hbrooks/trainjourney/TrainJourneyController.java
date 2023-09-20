package com.hbrooks.trainjourney;


import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import com.hbrooks.trainmileage.trainstation.TrainStation;
import com.hbrooks.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journey")
@CrossOrigin
public class TrainJourneyController {

    private TrainJourneyService trainJourneyService;

    @Autowired
    public TrainJourneyController(TrainJourneyService trainJourneyService) {
        this.trainJourneyService = trainJourneyService;
    }

    @PostMapping("/journeys")
    public TrainJourney addJourney(@RequestBody TrainJourneyRequest trainJourneyRequest, @AuthenticationPrincipal CustomUserDetails userDetails){

        return trainJourneyService.createJourney(trainJourneyRequest, userDetails.getId());
    }

    @GetMapping("/service-details-list")
    public List<ServiceDetails> serviceDetailsList(@RequestBody TrainJourneyRequest trainJourneyRequest){

        return trainJourneyService.findServicesForJourney(trainJourneyRequest);
    }

    //should only be for admins
    @GetMapping("/journeys")
    public List<TrainJourney> getAllJourneys(){

        return trainJourneyService.findAllJourneys();
    }

    //make it so admin can also do this
    @GetMapping("/journeys/{id}")
    @PreAuthorize(value = "authentication.principal.id == #id" + " or hasRole('ROLE_ADMIN')")
    public List<TrainJourney> getJourneysByUserId(@PathVariable("id") Integer id, @AuthenticationPrincipal CustomUserDetails userDetails){


        return trainJourneyService.findJourneysByUserId(id);
    }

    @DeleteMapping("/journeys/{id}/{journeyId}")
    @PreAuthorize(value = "authentication.principal.id == #id" + " or hasRole('ROLE_ADMIN')")
    public String deleteEmployee(@PathVariable int journeyId, @PathVariable("id") Integer id){

        TrainJourney journey = trainJourneyService.findById(journeyId);

        if (journey == null){
            throw new RuntimeException("Journey with id " + journeyId + " not found");
        }

        trainJourneyService.deleteJourneyById(journeyId);

        return "Deleted journey with id " + journeyId;
    }

    @GetMapping("/journeys/stations/{id}/{journeyId}")
    @PreAuthorize(value = "authentication.principal.id == #id" + " or hasRole('ROLE_ADMIN')")
    public List<TrainStation> getStationsForJourneyById(@PathVariable("journeyId") Integer journeyId, @PathVariable("id") Integer id){

        return trainJourneyService.findStationsForJourneyById(journeyId);
    }
}
