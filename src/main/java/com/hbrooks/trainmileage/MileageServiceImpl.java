package com.hbrooks.trainmileage;

import com.hbrooks.searchtrainapi.ServiceNotFoundException;
import com.hbrooks.trainmileage.mileagedatamodel.MileageRow;
import com.hbrooks.trainmileage.mileagedatamodel.MileageTable;
import com.hbrooks.trainstation.TrainStation;
import com.hbrooks.trainstation.TrainStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MileageServiceImpl implements MileageService{

    private TrainStationService trainStationLocationService;

    //inject helper class to read mileage data from csv files
    private MileageCsvReader mileageCsvReader;

    //need to inject the station repo to convert CRS code to station name
    @Autowired
    public MileageServiceImpl(TrainStationService trainStationLocationService, MileageCsvReader mileageCsvReader){
        this.trainStationLocationService = trainStationLocationService;
        this.mileageCsvReader = mileageCsvReader;
    }


    @Override
    public float getDistanceBetweenTwoStations(String originCrs, String destinationCrs){

        List<Integer> originTableIdList = mileageCsvReader.getStationsTables(originCrs);
        List<Integer> destinationTableIdList =mileageCsvReader.getStationsTables(destinationCrs);

        //retain all means first list only contains values which are also present in second list
        List<Integer> commonTables = new ArrayList<>(originTableIdList);
        commonTables.retainAll(destinationTableIdList);

        //add custom exception here
        //no direct route between stations
        if (commonTables.isEmpty()) {

            //failed to calculate distance between stations - check they have direct service
            //throw exception
            throw new ServiceNotFoundException("Could not find distance between stations - check you entered valid stations");
        }

        //get location object
        TrainStation originStation = trainStationLocationService.findByCrs(originCrs);
        TrainStation destinationStation = trainStationLocationService.findByCrs(destinationCrs);

        //extract station name and format - remove trailing white space
        String originFullName = originStation.getStationName().replace("Rail Station", "").trim();
        String destinationFullName = destinationStation.getStationName().replace("Rail Station", "").trim();


        //goes through all tables and all distance values and returns the first match
        for (int tableId : commonTables){
            //go through each common table
            //find the common mileage table
            MileageTable mileageTable = mileageCsvReader.findMileageTable(tableId);

            //get each row
            MileageRow originRow = mileageTable.getRowByStationName(originFullName);
            MileageRow destinationRow = mileageTable.getRowByStationName(destinationFullName);

            //check if origin and destination have a matching column value in distance array
            for (int i = 0; i < originRow.getDistances().length; i++){

                if (!originRow.getDistances()[i].equals("") && !destinationRow.getDistances()[i].equals("")){

                    //System.out.println("MATCH FOUND INDEX : " + i);
                    float result = Float.parseFloat(originRow.getDistances()[i]) - Float.parseFloat(destinationRow.getDistances()[i]);

                    return Math.abs(result);
                }
            }
        }

        System.out.println("No route from " + originFullName + " to " + destinationFullName + " found");
        //not found
        throw new ServiceNotFoundException("No direct route from " + originFullName + " to " + destinationFullName + " could be found");
    }


    public float getDistanceWithExtraLocations(MileageRequest mileageRequest) {

        float totalDistance = 0;

        //find distance from start station to mileageRequest.getViaStations().get(0);

        //find distance from mileageRequest.getViaStations().get(0) to mileageRequest.getViaStations().get(1);

        //find distance from last in list to last

        totalDistance += getDistanceBetweenTwoStations(mileageRequest.getStartStation(), mileageRequest.getViaStations().get(0));
        totalDistance += getDistanceBetweenTwoStations(mileageRequest.getViaStations().get(mileageRequest.getViaStations().size() -1 ), mileageRequest.getEndStation());


        for (int i = 0; i < mileageRequest.getViaStations().size() - 1; i++){
            totalDistance += getDistanceBetweenTwoStations(mileageRequest.getViaStations().get(i),
                                                        mileageRequest.getViaStations().get(i+1));
        }

        return totalDistance;
    }

}
