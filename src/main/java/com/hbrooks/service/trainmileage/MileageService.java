package com.hbrooks.service.trainmileage;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MileageService {


    private String mileageFilePath = "src/main/resources/static/NRT May 2023 Mileages.csv";

    
    //finds table with mileage data for given tableId - tableId can be extracted from StationIndex.csv
    public MileageTable mileageTable(int tableId){

        String line = "";
        MileageTable table = new MileageTable();

        try {
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
                            MileageRow row = new MileageRow(values[0],
                                    values[1],
                                    values[2],
                                    values[3],
                                    values[4],
                                    values[5],
                                    values[6]);
                            //System.out.println(Arrays.toString(values));
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
}
