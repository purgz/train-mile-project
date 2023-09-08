package com.hbrooks.trainmileage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TrainMileageController {

   //simple rest controller to return distance between stations

    private MileageService mileageService;

    @Autowired
    public TrainMileageController(MileageService mileageService) {
        this.mileageService = mileageService;
    }

    @GetMapping("/mileage")
    public String getDistanceBetweenStations(@RequestParam("origin") String origin, @RequestParam("destination") String destination){

        return "distance is " + mileageService.getDistanceBetweenTwoStations(origin, destination);
    }

    //add support for list of stations
    @GetMapping("/mileage/via")
    public float getDistanceWithExtraLocations(@RequestBody MileageRequest mileageRequest){

        return mileageService.getDistanceWithExtraLocations(mileageRequest);
    }
}
