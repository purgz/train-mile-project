package com.hbrooks.trainjourney;

import jakarta.persistence.*;

@Entity
@Table(name = "journey_stops")
public class TrainJourneyStop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "journey_stop_id")
    private int id;

    @Column(name = "stop_order")
    private int order;

    @Column(name = "crs_code")
    private String crsCode;

    @Column(name = "via_station")
    private boolean viaStation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getCrsCode() {
        return crsCode;
    }

    public void setCrsCode(String crsCode) {
        this.crsCode = crsCode;
    }

    public boolean isViaStation() {
        return viaStation;
    }

    public void setViaStation(boolean viaStation) {
        this.viaStation = viaStation;
    }

    public TrainJourneyStop(int order, String crsCode, boolean viaStation) {
        this.order = order;
        this.crsCode = crsCode;
        this.viaStation = viaStation;
    }

    public TrainJourneyStop() {
    }
}
