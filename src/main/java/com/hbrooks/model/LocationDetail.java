
package com.hbrooks.model;

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
    "realtimeActivated",
    "tiploc",
    "crs",
    "description",
    "gbttBookedArrival",
    "gbttBookedDeparture",
    "origin",
    "destination",
    "isCall",
    "isPublicCall",
    "realtimeArrival",
    "realtimeArrivalActual",
    "realtimeDeparture",
    "realtimeDepartureActual",
    "platform",
    "platformConfirmed",
    "platformChanged",
    "displayAs"
})

public class LocationDetail {

    @JsonProperty("realtimeActivated")
    private Boolean realtimeActivated;
    @JsonProperty("tiploc")
    private String tiploc;
    @JsonProperty("crs")
    private String crs;
    @JsonProperty("description")
    private String description;
    @JsonProperty("gbttBookedArrival")
    private String gbttBookedArrival;
    @JsonProperty("gbttBookedDeparture")
    private String gbttBookedDeparture;
    @JsonProperty("origin")
    private List<Origin> origin;
    @JsonProperty("destination")
    private List<Destination__1> destination;
    @JsonProperty("isCall")
    private Boolean isCall;
    @JsonProperty("isPublicCall")
    private Boolean isPublicCall;
    @JsonProperty("realtimeArrival")
    private String realtimeArrival;
    @JsonProperty("realtimeArrivalActual")
    private Boolean realtimeArrivalActual;
    @JsonProperty("realtimeDeparture")
    private String realtimeDeparture;
    @JsonProperty("realtimeDepartureActual")
    private Boolean realtimeDepartureActual;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("platformConfirmed")
    private Boolean platformConfirmed;
    @JsonProperty("platformChanged")
    private Boolean platformChanged;
    @JsonProperty("displayAs")
    private String displayAs;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("realtimeActivated")
    public Boolean getRealtimeActivated() {
        return realtimeActivated;
    }

    @JsonProperty("realtimeActivated")
    public void setRealtimeActivated(Boolean realtimeActivated) {
        this.realtimeActivated = realtimeActivated;
    }

    @JsonProperty("tiploc")
    public String getTiploc() {
        return tiploc;
    }

    @JsonProperty("tiploc")
    public void setTiploc(String tiploc) {
        this.tiploc = tiploc;
    }

    @JsonProperty("crs")
    public String getCrs() {
        return crs;
    }

    @JsonProperty("crs")
    public void setCrs(String crs) {
        this.crs = crs;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("gbttBookedArrival")
    public String getGbttBookedArrival() {
        return gbttBookedArrival;
    }

    @JsonProperty("gbttBookedArrival")
    public void setGbttBookedArrival(String gbttBookedArrival) {
        this.gbttBookedArrival = gbttBookedArrival;
    }

    @JsonProperty("gbttBookedDeparture")
    public String getGbttBookedDeparture() {
        return gbttBookedDeparture;
    }

    @JsonProperty("gbttBookedDeparture")
    public void setGbttBookedDeparture(String gbttBookedDeparture) {
        this.gbttBookedDeparture = gbttBookedDeparture;
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
    public List<Destination__1> getDestination() {
        return destination;
    }

    @JsonProperty("destination")
    public void setDestination(List<Destination__1> destination) {
        this.destination = destination;
    }

    @JsonProperty("isCall")
    public Boolean getIsCall() {
        return isCall;
    }

    @JsonProperty("isCall")
    public void setIsCall(Boolean isCall) {
        this.isCall = isCall;
    }

    @JsonProperty("isPublicCall")
    public Boolean getIsPublicCall() {
        return isPublicCall;
    }

    @JsonProperty("isPublicCall")
    public void setIsPublicCall(Boolean isPublicCall) {
        this.isPublicCall = isPublicCall;
    }

    @JsonProperty("realtimeArrival")
    public String getRealtimeArrival() {
        return realtimeArrival;
    }

    @JsonProperty("realtimeArrival")
    public void setRealtimeArrival(String realtimeArrival) {
        this.realtimeArrival = realtimeArrival;
    }

    @JsonProperty("realtimeArrivalActual")
    public Boolean getRealtimeArrivalActual() {
        return realtimeArrivalActual;
    }

    @JsonProperty("realtimeArrivalActual")
    public void setRealtimeArrivalActual(Boolean realtimeArrivalActual) {
        this.realtimeArrivalActual = realtimeArrivalActual;
    }

    @JsonProperty("realtimeDeparture")
    public String getRealtimeDeparture() {
        return realtimeDeparture;
    }

    @JsonProperty("realtimeDeparture")
    public void setRealtimeDeparture(String realtimeDeparture) {
        this.realtimeDeparture = realtimeDeparture;
    }

    @JsonProperty("realtimeDepartureActual")
    public Boolean getRealtimeDepartureActual() {
        return realtimeDepartureActual;
    }

    @JsonProperty("realtimeDepartureActual")
    public void setRealtimeDepartureActual(Boolean realtimeDepartureActual) {
        this.realtimeDepartureActual = realtimeDepartureActual;
    }

    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    @JsonProperty("platformConfirmed")
    public Boolean getPlatformConfirmed() {
        return platformConfirmed;
    }

    @JsonProperty("platformConfirmed")
    public void setPlatformConfirmed(Boolean platformConfirmed) {
        this.platformConfirmed = platformConfirmed;
    }

    @JsonProperty("platformChanged")
    public Boolean getPlatformChanged() {
        return platformChanged;
    }

    @JsonProperty("platformChanged")
    public void setPlatformChanged(Boolean platformChanged) {
        this.platformChanged = platformChanged;
    }

    @JsonProperty("displayAs")
    public String getDisplayAs() {
        return displayAs;
    }

    @JsonProperty("displayAs")
    public void setDisplayAs(String displayAs) {
        this.displayAs = displayAs;
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
