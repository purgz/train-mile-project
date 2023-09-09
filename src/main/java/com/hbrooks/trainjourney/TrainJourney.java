package com.hbrooks.trainjourney;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;

import java.util.List;

@Entity
@Table(name = "journey")
public class TrainJourney {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_id")
    private int journeyId;

    @Column(name = "start_station")
    private String startStation;

    @Column(name = "end_station")
    private String endStation;

    @Column(name = "mileage")
    private float mileage;

    private List<String> viaStations;

    private List<String> allStops;

    public TrainJourney() {
    }

    public List<String> getAllStops() {
        return allStops;
    }

    public void setAllStops(List<String> allStops) {
        this.allStops = allStops;
    }

    public TrainJourney(String startStation, List<String> viaStations, List<String> allStops, String endStation, float mileage) {
        this.startStation = startStation;
        this.viaStations = viaStations;
        this.endStation = endStation;
        this.mileage = mileage;
        this.allStops = allStops;
    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "TrainJourney{" +
                "journeyId=" + journeyId +
                ", startStation='" + startStation + '\'' +
                ", viaStations=" + viaStations +
                ", endStation='" + endStation + '\'' +
                ", mileage=" + mileage +
                '}';
    }

    public int getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(int journeyId) {
        this.journeyId = journeyId;
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
}
