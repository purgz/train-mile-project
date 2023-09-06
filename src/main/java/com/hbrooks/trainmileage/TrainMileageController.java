package com.hbrooks.trainmileage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
