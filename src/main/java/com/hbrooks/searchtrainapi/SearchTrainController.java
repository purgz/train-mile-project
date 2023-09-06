package com.hbrooks.searchtrainapi;

import com.hbrooks.searchtrainapi.apiresponsemodel.TrainSearchResponse;
import com.hbrooks.searchtrainapi.SearchTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchTrainController {

    private SearchTrainService searchTrainService;

    @Autowired
    public SearchTrainController(SearchTrainService searchTrainService) {
        this.searchTrainService = searchTrainService;
    }

    //simple mapping to return the response as JSON
    @GetMapping("/{originCRS}/{destinationCRS}")
    public TrainSearchResponse searchJourney(@PathVariable String originCRS,
                                             @PathVariable String destinationCRS){

        return searchTrainService.findTrainJourney(originCRS,destinationCRS);
    }

    @GetMapping("/id/date/{originCRS}/{destinationCRS}")
    public String[] getIdAndDate(@PathVariable String originCRS,
                                 @PathVariable String destinationCRS){

        return searchTrainService.getIdAndDate(originCRS, destinationCRS);
   }
}