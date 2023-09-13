package com.hbrooks.trainjourney;

import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;

import java.util.List;

public interface TrainJourneyService {

    TrainJourney createJourney(TrainJourneyRequest trainJourneyRequest, int userId);

    List<ServiceDetails> findServicesForJourney(TrainJourneyRequest trainJourneyRequest);

    List<TrainJourney> findAllJourneys();

    TrainJourney findById(int id);

    List<TrainJourney> findJourneysByUserId(int id);

    void deleteJourneyById(int id);
}
