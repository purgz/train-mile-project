package com.hbrooks.trainjourney;

import com.hbrooks.trainmileage.MileageRequest;
import com.hbrooks.trainmileage.MileageService;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainJourneyServiceImpl implements TrainJourneyService {

    private MileageService mileageService;

    @Autowired
    public TrainJourneyServiceImpl(MileageService mileageService) {
        this.mileageService = mileageService;
    }

    @Override
    public TrainJourney createJourney(TrainJourneyRequest trainJourneyRequest) {

        MileageRequest mileageRequest = new MileageRequest(
                trainJourneyRequest.getStartStation(),
                trainJourneyRequest.getViaStations(),
                trainJourneyRequest.getEndStation());

        float mileage = mileageService.getDistanceWithExtraLocations(mileageRequest);

        TrainJourney newJourney = new TrainJourney(
                trainJourneyRequest.getStartStation(),
                trainJourneyRequest.getViaStations(),
                trainJourneyRequest.getEndStation(),
                mileage);

        //will add database support later

        return newJourney;
    }
}
