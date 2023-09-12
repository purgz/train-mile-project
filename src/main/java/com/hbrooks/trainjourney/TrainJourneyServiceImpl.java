package com.hbrooks.trainjourney;

import com.hbrooks.searchtrainapi.SearchTrainService;
import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.Location;
import com.hbrooks.searchtrainapi.servicedetailsresponsemodel.ServiceDetails;
import com.hbrooks.trainmileage.MileageRequest;
import com.hbrooks.trainmileage.MileageService;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainJourneyServiceImpl implements TrainJourneyService {

    private MileageService mileageService;

    private SearchTrainService searchTrainService;

    private TrainJourneyRepository trainJourneyRepository;

    @Autowired
    public TrainJourneyServiceImpl(MileageService mileageService, SearchTrainService searchTrainService,
                                   TrainJourneyRepository trainJourneyRepository) {

        this.mileageService = mileageService;
        this.searchTrainService = searchTrainService;
        this.trainJourneyRepository = trainJourneyRepository;
    }

    @Override
    public TrainJourney createJourney(TrainJourneyRequest trainJourneyRequest) {

        //want to extract only the locations in the service which the journey will go through
        List<ServiceDetails> serviceDetailsList = findServicesForJourney(trainJourneyRequest);
        List<String> allStops = new ArrayList<>();

        //case where there is no via stops


        if (trainJourneyRequest.getViaStations().size() == 0){

            List<Location> locations = serviceDetailsList.get(0).getLocations();

            for (Location location : locations){
                if (location.getCrs().equals(trainJourneyRequest.getStartStation())){
                    while(!location.getCrs().equals(trainJourneyRequest.getEndStation())){
                        allStops.add(location.getCrs());

                        int index = locations.indexOf(location);
                        location = locations.get(index + 1);
                    }
                    allStops.add(trainJourneyRequest.getEndStation());
                }
            }
        } else {


            //finds all the stops for each part of the journey and adds to all stops list
            List<Location> firstLegLocations = serviceDetailsList.get(0).getLocations();
            List<Location> lastLegLocations = serviceDetailsList.get(serviceDetailsList.size() - 1).getLocations();

            //find the list of stations for the first leg
            for (Location location : firstLegLocations){
                if (location.getCrs().equals(trainJourneyRequest.getStartStation())){
                    while(!location.getCrs().equals(trainJourneyRequest.getViaStations().get(0))){
                        allStops.add(location.getCrs());

                        int index = firstLegLocations.indexOf(location);
                        location = firstLegLocations.get(index + 1);
                    }
                }
            }
            allStops.add(trainJourneyRequest.getViaStations().get(0));
            //allStops.add("****");

            //find list of stations for all via stations.
            for (int i = 1; i < serviceDetailsList.size() - 1; i++){

                List<Location> locationList = serviceDetailsList.get(i).getLocations();

                //get the current pair of locations
                String firstViaStation = trainJourneyRequest.getViaStations().get(i - 1);
                String nextViaStation = trainJourneyRequest.getViaStations().get(i);
                System.out.println("STATIONS " + firstViaStation + " " + nextViaStation);

                for (Location location : locationList){
                    if (location.getCrs().equals(firstViaStation)){
                        int index = locationList.indexOf(location);
                        location = locationList.get(index + 1);
                        while(!location.getCrs().equals(nextViaStation)){
                            allStops.add(location.getCrs());

                            index = locationList.indexOf(location);
                            location = locationList.get(index + 1);
                        }
                        allStops.add(nextViaStation);
                    }
                }

                //allStops.add("****");
            }

            //find the list of stations for the last leg
            for (Location location : lastLegLocations){
                if (location.getCrs().equals(trainJourneyRequest.getViaStations().get(
                        trainJourneyRequest.getViaStations().size() - 1))){

                    int index = lastLegLocations.indexOf(location);
                    location = lastLegLocations.get(index + 1);
                    while(!location.getCrs().equals(trainJourneyRequest.getEndStation())){
                        allStops.add(location.getCrs());

                        index = lastLegLocations.indexOf(location);
                        location = lastLegLocations.get(index + 1);
                    }
                    allStops.add(trainJourneyRequest.getEndStation());
                }
            }

        }

        //System.out.println(allStops);

        //calculate mileage
        MileageRequest mileageRequest = new MileageRequest(
                trainJourneyRequest.getStartStation(),
                trainJourneyRequest.getViaStations(),
                trainJourneyRequest.getEndStation());

        float mileage = mileageService.getDistanceWithExtraLocations(mileageRequest);

        TrainJourney newJourney = new TrainJourney();

        List<TrainJourneyStop> allStations = new ArrayList<>();

        for (int i = 0; i < allStops.size(); i++){

            boolean isViaStation = trainJourneyRequest.getViaStations().contains(allStops.get(i));

            TrainJourneyStop stop = new TrainJourneyStop(
                    i + 1,
                    allStops.get(i),
                    isViaStation);

            allStations.add(stop);
        }

        newJourney.setAllStops(allStations);
        newJourney.setMileage(mileage);
        newJourney.setStartStation(trainJourneyRequest.getStartStation());
        newJourney.setEndStation(trainJourneyRequest.getEndStation());
        newJourney.setDate(trainJourneyRequest.getDate());

        trainJourneyRepository.save(newJourney);

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

    @Override
    public List<TrainJourney> findAllJourneys() {

        // System.out.println(trainJourneyRepository.findStops());

        return trainJourneyRepository.findAll();
    }

    public TrainJourney findById(int id){

        Optional<TrainJourney> result = trainJourneyRepository.findById(id);

        TrainJourney journey = null;

        if (result.isPresent()){
            journey = result.get();
        } else {
            throw new RuntimeException("Did not find journey with id " + id);
        }

        return journey;
    }

    @Override
    public List<TrainJourney> findJourneysByUserId(int id) {

        //System.out.println(id);
        return trainJourneyRepository.findByUserId(id);
    }

    public void deleteJourneyById(int id){

        trainJourneyRepository.deleteById(id);
    }


}
