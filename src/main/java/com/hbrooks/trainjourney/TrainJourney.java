package com.hbrooks.trainjourney;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

import java.util.Date;
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

    @Column(name = "user_id")
    private int userId;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "journey_stop_join_table",
            joinColumns = @JoinColumn(name = "journey_id"),
            inverseJoinColumns = @JoinColumn(name = "journey_stop_id"))
    @OrderBy("stop_order")
    private List<TrainJourneyStop> allStops;

    @Column(name = "date")
    @JsonFormat
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TrainJourney() {
    }

    public List<TrainJourneyStop> getAllStops() {
        return allStops;
    }

    public void setAllStops(List<TrainJourneyStop> allStops) {
        this.allStops = allStops;
    }

    public TrainJourney(String startStation, List<TrainJourneyStop> allStops, String endStation, float mileage, Date date, int userId) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.mileage = mileage;
        this.allStops = allStops;
        this.date = date;
        this.userId = userId;
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
                ", endStation='" + endStation + '\'' +
                ", mileage=" + mileage +
                ", userId=" + userId +
                ", allStops=" + allStops +
                ", date=" + date +
                '}';
    }

    public int getJourneyId() {
        return journeyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}
