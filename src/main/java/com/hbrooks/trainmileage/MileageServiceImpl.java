package com.hbrooks.trainmileage;

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


    public float getDistanceBetweenTwoStations(String originCrs, String destinationCrs){

        List<Integer> originTableIdList = mileageCsvReader.getStationsTables(originCrs);
        List<Integer> destinationTableIdList =mileageCsvReader.getStationsTables(destinationCrs);

        //retain all means first list only contains values which are also present in second list
        List<Integer> commonTables = new ArrayList<>(originTableIdList);
        commonTables.retainAll(destinationTableIdList);

        //no direct route between stations
        if (commonTables.isEmpty()) return -1;

        //get location object
        TrainStation originStation = trainStationLocationService.findByCrs(originCrs);
        TrainStation destinationStation = trainStationLocationService.findByCrs(destinationCrs);

        //extract station name and format - remove trailing white space
        String originFullName = originStation.getStationName().replace("Rail Station", "").trim();
        String destinationFullName = destinationStation.getStationName().replace("Rail Station", "").trim();

        //find the common mileage table
        MileageTable mileageTable = mileageCsvReader.findMileageTable(commonTables.get(0));

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
        System.out.println(commonTables.get(1));
        System.out.println("No route from " + originFullName + " to " + destinationFullName + " found");
        //not found
        return -1;
    }

}
