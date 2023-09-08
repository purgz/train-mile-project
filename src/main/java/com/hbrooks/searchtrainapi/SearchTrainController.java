package com.hbrooks.searchtrainapi;

import com.hbrooks.searchtrainapi.searchresponsemodel.TrainSearchResponse;
import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping("/service/{originCRS}/{destinationCRS}")
   public ServiceDetails getServiceDetails(@PathVariable String originCRS,
                                       @PathVariable String destinationCRS){

        String[] idAndDate = searchTrainService.getIdAndDate(originCRS, destinationCRS);

        return searchTrainService.findServiceDetails(idAndDate[0],idAndDate[1]);
   }
}
