package com.hbrooks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train_station_locations")
public class TrainStationLocation {

    @Id
    @Column(name = "crs_code")
    private String crsCode;

    @Column(name = "station_name")
    private String stationName;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    public TrainStationLocation(String crsCode, String stationName, String latitude, String longitude) {
        this.crsCode = crsCode;
        this.stationName = stationName;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public TrainStationLocation() {
    }

    public String getCrsCode() {
        return crsCode;
    }

    @Override
    public String toString() {
        return "TrainStationLocation{" +
                "crsCode='" + crsCode + '\'' +
                ", stationName='" + stationName + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public void setCrsCode(String crsCode) {
        this.crsCode = crsCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
