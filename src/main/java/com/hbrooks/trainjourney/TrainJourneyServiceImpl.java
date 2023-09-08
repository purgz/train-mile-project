package com.hbrooks.trainjourney;

import com.hbrooks.searchtrainapi.SearchTrainService;
import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import com.hbrooks.trainmileage.MileageRequest;
import com.hbrooks.trainmileage.MileageService;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainJourneyServiceImpl implements TrainJourneyService {

    private MileageService mileageService;

    private SearchTrainService searchTrainService;

    @Autowired
    public TrainJourneyServiceImpl(MileageService mileageService, SearchTrainService searchTrainService) {

        this.mileageService = mileageService;
        this.searchTrainService = searchTrainService;
    }

    @Override
    public TrainJourney createJourney(TrainJourneyRequest trainJourneyRequest) {

        //want to extract only the locations in the service which the journey will go through 

        //calculate mileage
        MileageRequest mileageRequest = new MileageRequest(
                trainJourneyRequest.getStartStation(),
                trainJourneyRequest.getViaStations(),
                trainJourneyRequest.getEndStation());

        float mileage = mileageService.getDistanceWithExtraLocations(mileageRequest);

        TrainJourney newJourney = new TrainJourney(
                trainJourneyRequest.getStartStation(),
                trainJourneyRequest.getViaStations(),
                null,
                trainJourneyRequest.getEndStation(),
                mileage);

        //will add database support later

        return newJourney;
    }

    public List<ServiceDetails> findServicesForJourney(TrainJourneyRequest trainJourneyRequest) {
        //search for services
        //list of all the services of the journey
        List<ServiceDetails> serviceDetailsList = new ArrayList<>();

        //if there are no via stations - get direct service
        if (trainJourneyRequest.getViaStations().size() == 0){
            serviceDetailsList.add(searchTrainService.findServiceDetailsByCRS(
                    trainJourneyRequest.getStartStation(),
                    trainJourneyRequest.getEndStation()));
        } else {

            ServiceDetails firstLegServiceDetails = searchTrainService.findServiceDetailsByCRS(
                    trainJourneyRequest.getStartStation(), trainJourneyRequest.getViaStations().get(0));
            serviceDetailsList.add(firstLegServiceDetails);

            for (int i = 0; i < trainJourneyRequest.getViaStations().size() - 1; i++){
                ServiceDetails serviceDetails = searchTrainService.findServiceDetailsByCRS(
                        trainJourneyRequest.getViaStations().get(i),
                        trainJourneyRequest.getViaStations().get(i + 1));
                serviceDetailsList.add(serviceDetails);
            }

            ServiceDetails lastLegServiceDetails = searchTrainService.findServiceDetailsByCRS(
                    trainJourneyRequest.getViaStations().get(trainJourneyRequest.getViaStations().size() - 1),
                    trainJourneyRequest.getEndStation());
            serviceDetailsList.add(lastLegServiceDetails);
        }

        return serviceDetailsList;
    }
}
