package com.hbrooks.service.trainmileage;

import com.hbrooks.dao.TrainStationLocationRepository;
import com.hbrooks.entity.TrainStationLocation;
import com.hbrooks.service.TrainStationLocationService;
import com.hbrooks.service.realtimetrainapi.SearchTrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MileageService {

    private TrainStationLocationService trainStationLocationService;

    //need to inject the station repo to convert CRS code to station name
    @Autowired
    public MileageService(TrainStationLocationService trainStationLocationService){
        this.trainStationLocationService = trainStationLocationService;
    }


    //finds table with mileage data for given tableId - tableId can be extracted from StationIndex.csv
    private MileageTable findMileageTable(int tableId){

        String line;
        MileageTable table = new MileageTable();

        try {
            String mileageFilePath = "src/main/resources/static/NRT May 2023 Mileages.csv";
            BufferedReader br = new BufferedReader(new FileReader(mileageFilePath));

            while((line = br.readLine()) != null){
                if (line.equals(tableId + ",,,,,,")){

                    //skip over the header lines
                    line = br.readLine();
                    line = br.readLine();

                    List<MileageRow> rows = new ArrayList<>();
                    while (!line.matches("\\d+,,,,,,")){

                        if (!line.equals("DISTANCES (MILES),,,,,,") && !line.equals("Table,M1,M2,M3,M4,M5,M6")){
                            String[] values = line.split(",",-1);
                            String[] distances = new String[6];

                            for (int i = 1; i <= distances.length; i++){
                                distances[i-1] = values[i];
                            }

                            MileageRow row = new MileageRow(values[0], distances);

                            rows.add(row);
                        }

                        line = br.readLine();
                    }
                    table.setRows(rows);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return table;
    }

    //now works - improved efficiency by adding breaks to stop searching once station is found
    private List<Integer> getStationsTables(String crsCode){

        List<Integer> result = new ArrayList<>();
        String line;

        try {
            String stationIndexFilePath = "src/main/resources/static/NRT May 2023 Station Index.csv";
            BufferedReader br = new BufferedReader(new FileReader(stationIndexFilePath));


            /*
             ** two options
             *  -code - station - table1,...
             *      for this option can just read all the table columns at the right
             *
             *  -code -station - blank
             *      -routes - table name
             *      -routes - table name...
             *       ..
             *          .
             *      for this option need to read all the following rows until a new code is found - at each row with no code
             *      add to the results for the code.
             */
            while ((line = br.readLine()) != null){

                String[] values = line.split(",", -1);
                if (values[0].equals(crsCode)){

                    //check if following column is empty
                    if (values[2].equals("")){
                        //need to read rows until next station code found and add the tables

                        line = br.readLine();
                        String[] newValues = line.split(",");

                        //keep reading next line as long as code is empty
                        while(newValues[0].equals("")){



                            //if the last value in the row is a number add it to the results
                            if (newValues[newValues.length - 1].matches("\\d+")){
                                result.add(Integer.parseInt(newValues[newValues.length-1]));
                            }

                            //next line
                            line = br.readLine();
                            newValues = line.split(",");

                            //if a new page is found then skip over the titles
                            if (line.equals("STATION INDEX,,,,,")){
                                line = br.readLine();
                                line = br.readLine();
                                newValues = line.split(",");
                            }

                            //if new page and on a 'continued' section then skip one line and continue from there
                            if (newValues[0].equals(crsCode)){
                                line = br.readLine();
                                newValues = line.split(",");
                            }
                        }
                        break;

                    } else {

                        //add the 4 table ids into result if not null
                        for (int i = 2; i < values.length; i++){
                            if (!values[i].equals("")){
                                result.add(Integer.parseInt(values[i]));
                            }
                        }
                        break;
                    }

                }
            }

            //if nothing found just returns empty list

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public float getDistanceBetweenTwoStations(String originCrs, String destinationCrs){

        List<Integer> originTableIdList = getStationsTables(originCrs);
        List<Integer> destinationTableIdList = getStationsTables(destinationCrs);

        //retain all means first list only contains values which are also present in second list
        List<Integer> commonTables = new ArrayList<>(originTableIdList);
        commonTables.retainAll(destinationTableIdList);

        //no direct route between stations
        if (commonTables.isEmpty()) return -1;

        //get location object
        TrainStationLocation originStation = trainStationLocationService.findByCrs(originCrs);
        TrainStationLocation destinationStation = trainStationLocationService.findByCrs(destinationCrs);

        //extract station name and format - remove trailing white space
        String originFullName = originStation.getStationName().replace("Rail Station", "").trim();
        String destinationFullName = destinationStation.getStationName().replace("Rail Station", "").trim();

        //find the common mileage table
        MileageTable mileageTable = findMileageTable(commonTables.get(0));

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

        System.out.println("No route from " + originFullName + " to " + destinationFullName + " found");
        //not found
        return -1;
    }

}
