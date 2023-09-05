
package com.hbrooks.model;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "locationDetail",
    "serviceUid",
    "runDate",
    "trainIdentity",
    "runningIdentity",
    "atocCode",
    "atocName",
    "serviceType",
    "isPassenger"
})

public class Service {

    @JsonProperty("locationDetail")
    private LocationDetail locationDetail;
    @JsonProperty("serviceUid")
    private String serviceUid;
    @JsonProperty("runDate")
    private String runDate;
    @JsonProperty("trainIdentity")
    private String trainIdentity;
    @JsonProperty("runningIdentity")
    private String runningIdentity;
    @JsonProperty("atocCode")
    private String atocCode;
    @JsonProperty("atocName")
    private String atocName;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("isPassenger")
    private Boolean isPassenger;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("locationDetail")
    public LocationDetail getLocationDetail() {
        return locationDetail;
    }

    @JsonProperty("locationDetail")
    public void setLocationDetail(LocationDetail locationDetail) {
        this.locationDetail = locationDetail;
    }

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

    @JsonProperty("trainIdentity")
    public String getTrainIdentity() {
        return trainIdentity;
    }

    @JsonProperty("trainIdentity")
    public void setTrainIdentity(String trainIdentity) {
        this.trainIdentity = trainIdentity;
    }

    @JsonProperty("runningIdentity")
    public String getRunningIdentity() {
        return runningIdentity;
    }

    @JsonProperty("runningIdentity")
    public void setRunningIdentity(String runningIdentity) {
        this.runningIdentity = runningIdentity;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
