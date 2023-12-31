package com.hbrooks.trainmileage.mileagedatamodel;

import com.hbrooks.trainmileage.mileagedatamodel.MileageRow;

import java.util.ArrayList;
import java.util.List;

public class MileageTable {

    private List<MileageRow> rows = new ArrayList<>();

    public MileageTable(){};

    public MileageTable(List<MileageRow> rows) {
        this.rows = rows;
    }

    public List<MileageRow> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        return "MileAgeTable{" +
                "rows=" + rows +
                '}';
    }

    public void setRows(List<MileageRow> rows) {
        this.rows = rows;
    }

    public MileageRow getRowByStationName(String stationName){

        for (MileageRow row : this.rows){

            if (row.getStationName().toLowerCase().equals(stationName.toLowerCase())){
                //System.out.println("FOUND station: " + stationName);
                return row;
            }
        }
        System.out.println("Station not found in table");
        return null;
    }
}