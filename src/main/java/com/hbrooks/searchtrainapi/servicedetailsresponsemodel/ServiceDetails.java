
package com.hbrooks.searchtrainapi.servicedetailsresponsemodel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "serviceUid",
    "runDate",
    "serviceType",
    "isPassenger",
    "trainIdentity",
    "powerType",
    "trainClass",
    "atocCode",
    "atocName",
    "performanceMonitored",
    "origin",
    "destination",
    "locations",
    "realtimeActivated",
    "runningIdentity"
})

public class ServiceDetails {

    @JsonProperty("serviceUid")
    private String serviceUid;
    @JsonProperty("runDate")
    private String runDate;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("isPassenger")
    private Boolean isPassenger;
    @JsonProperty("trainIdentity")
    private String trainIdentity;
    @JsonProperty("powerType")
    private String powerType;
    @JsonProperty("trainClass")
    private String trainClass;
    @JsonProperty("atocCode")
    private String atocCode;
    @JsonProperty("atocName")
    private String atocName;
    @JsonProperty("performanceMonitored")
    private Boolean performanceMonitored;
    @JsonProperty("origin")
    private List<Origin> origin;
    @JsonProperty("destination")
    private List<Destination> destination;
    @JsonProperty("locations")
    private List<Location> locations;
    @JsonProperty("realtimeActivated")
    private Boolean realtimeActivated;
    @JsonProperty("runningIdentity")
    private String runningIdentity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("serviceUid")
    public String getServiceUid() {
        return serviceUid;
    }

    @JsonProperty("serviceUid")
    public void setServiceUid(String serviceUid) {
        this.serviceUid = serviceUid;
    }

    @JsonProperty("runDate")
    public String getRunDate() {
        return runDate;
    }

    @JsonProperty("runDate")
    public void setRunDate(String runDate) {
        this.runDate = runDate;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("isPassenger")
    public Boolean getIsPassenger() {
        return isPassenger;
    }

    @JsonProperty("isPassenger")
    public void setIsPassenger(Boolean isPassenger) {
        this.isPassenger = isPassenger;
    }

    @JsonProperty("trainIdentity")
    public String getTrainIdentity() {
        return trainIdentity;
    }

    @JsonProperty("trainIdentity")
    public void setTrainIdentity(String trainIdentity) {
        this.trainIdentity = trainIdentity;
    }

    @JsonProperty("powerType")
    public String getPowerType() {
        return powerType;
    }

    @JsonProperty("powerType")
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

    @JsonProperty("trainClass")
    public String getTrainClass() {
        return trainClass;
    }

    @JsonProperty("trainClass")
    public void setTrainClass(String trainClass) {
        this.trainClass = trainClass;
    }

    @JsonProperty("atocCode")
    public String getAtocCode() {
        return atocCode;
    }

    @JsonProperty("atocCode")
    public void setAtocCode(String atocCode) {
        this.atocCode = atocCode;
    }

    @JsonProperty("atocName")
    public String getAtocName() {
        return atocName;
    }

    @JsonProperty("atocName")
    public void setAtocName(String atocName) {
        this.atocName = atocName;
    }

    @JsonProperty("performanceMonitored")
    public Boolean getPerformanceMonitored() {
        return performanceMonitored;
    }

    @JsonProperty("performanceMonitored")
    public void setPerformanceMonitored(Boolean performanceMonitored) {
        this.performanceMonitored = performanceMonitored;
    }

    @JsonProperty("origin")
    public List<Origin> getOrigin() {
        return origin;
    }

    @JsonProperty("origin")
    public void setOrigin(List<Origin> origin) {
        this.origin = origin;
    }

    @JsonProperty("destination")
    public List<Destination> getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(List<Destination> destination) {
        this.destination = destination;
    }

    @JsonProperty("locations")
    public List<Location> getLocations() {
        return locations;
    }

    @JsonProperty("locations")
    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @JsonProperty("realtimeActivated")
    public Boolean getRealtimeActivated() {
        return realtimeActivated;
    }

    @JsonProperty("realtimeActivated")
    public void setRealtimeActivated(Boolean realtimeActivated) {
        this.realtimeActivated = realtimeActivated;
    }

    @JsonProperty("runningIdentity")
    public String getRunningIdentity() {
        return runningIdentity;
    }

    @JsonProperty("runningIdentity")
    public void setRunningIdentity(String runningIdentity) {
        this.runningIdentity = runningIdentity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
