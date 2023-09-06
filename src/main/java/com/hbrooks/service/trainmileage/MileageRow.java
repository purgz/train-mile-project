package com.hbrooks.service.trainmileage;

public class MileageRow {

    private String stationName;
    private String m1;
    private String m2;
    private String m3;
    private String m4;
    private String m5;
    private String m6;

    public MileageRow(String stationName, String m1, String m2, String m3, String m4, String m5, String m6) {
        this.stationName = stationName;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.m5 = m5;
        this.m6 = m6;
    }

    @Override
    public String toString() {
        return "MileageRow{" +
                "stationName='" + stationName + '\'' +
                ", m1=" + m1 +
                ", m2=" + m2 +
                ", m3=" + m3 +
                ", m4=" + m4 +
                ", m5=" + m5 +
                ", m6=" + m6 +
                '}';
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


}