package com.hbrooks.controller;

import com.hbrooks.model.TrainSearchResponse;
import com.hbrooks.service.SearchTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class TrainController {

    private SearchTrainService searchTrainService;

    @Autowired
    public TrainController(SearchTrainService searchTrainService) {
        this.searchTrainService = searchTrainService;
    }

    //simple mapping to return the response as JSON
    @GetMapping("/{originCRS}/{destinationCRS}")
    public TrainSearchResponse searchJourney(@PathVariable String originCRS,
                                             @PathVariable String destinationCRS){

        return searchTrainService.findTrainJourney(originCRS,destinationCRS);
    }
}
