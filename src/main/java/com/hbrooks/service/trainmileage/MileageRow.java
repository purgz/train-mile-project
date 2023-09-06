package com.hbrooks.service.trainmileage;

import java.util.Arrays;

public class MileageRow {

    private String stationName;
    private String[] distances;

    public MileageRow(String stationName, String[] distances) {
        this.stationName = stationName;
        this.distances = distances;
    }

    @Override
    public String toString() {
        return "MileageRow{" +
                "stationName='" + stationName + '\'' +
                ", distances=" + Arrays.toString(distances) +
                '}';
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String[] getDistances() {
        return distances;
    }

    public void setDistances(String[] distances) {
        this.distances = distances;
    }
}