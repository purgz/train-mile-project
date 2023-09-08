package com.hbrooks.trainmileage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MileageRequest {

    @JsonProperty("startStation")
    private String startStation;

    @JsonProperty("stations")
    private List<String> viaStations;

    @JsonProperty("endStation")
    private String endStation;

    public MileageRequest() {
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public List<String> getViaStations() {
        return viaStations;
    }

    public void setViaStations(List<String> viaStations) {
        this.viaStations = viaStations;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public MileageRequest(String startStation, List<String> viaStations, String endStation) {
        this.startStation = startStation;
        this.viaStations = viaStations;
        this.endStation = endStation;
    }
}
