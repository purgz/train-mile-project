package com.hbrooks.searchtrainapi;

import com.hbrooks.searchtrainapi.searchresponsemodel.TrainSearchResponse;
import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;

public interface SearchTrainService {

    TrainSearchResponse findTrainJourney(String originCRS, String destinationCRS);

    ServiceDetails findServiceDetails(String serviceId, String date);

    String[] getIdAndDate(String originCRS, String destinationCRS);
}
