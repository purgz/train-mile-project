package com.hbrooks.trainjourney;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrainJourneyRequest {

    private String startStation;

    @JsonProperty("stations")
    private List<String> viaStations;

    private String endStation;

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

    public TrainJourneyRequest() {
    }

    public TrainJourneyRequest(String startStation, List<String> viaStations, String endStation) {
        this.startStation = startStation;
        this.viaStations = viaStations;
        this.endStation = endStation;
    }
}
