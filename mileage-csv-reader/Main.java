import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "files/NRT May 2023 Mileages.csv";
        String line = "";
        int tableId = 113;
        MileAgeTable table = new MileAgeTable();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null){

                //find the starting point for given table id
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

                    //bicester north can be found in table 113.
                    //table number would be found from the other csv file 'station index'
                    //then compared here to find mileage
                    //can subtract destination mileage from current mileage to find distance
                    System.out.println(table.getRowByStationName("bicester north"));
                    System.out.println(table.getRowByStationName("birmingham moor street"));
                    break;
                }
            }

            System.out.println(table);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
