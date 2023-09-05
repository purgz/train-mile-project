
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
    "tiploc",
    "description",
    "workingTime",
    "publicTime"
})
public class Origin {

    @JsonProperty("tiploc")
    private String tiploc;
    @JsonProperty("description")
    private String description;
    @JsonProperty("workingTime")
    private String workingTime;
    @JsonProperty("publicTime")
    private String publicTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("tiploc")
    public String getTiploc() {
        return tiploc;
    }

    @JsonProperty("tiploc")
    public void setTiploc(String tiploc) {
        this.tiploc = tiploc;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("workingTime")
    public String getWorkingTime() {
        return workingTime;
    }

    @JsonProperty("workingTime")
    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    @JsonProperty("publicTime")
    public String getPublicTime() {
        return publicTime;
    }

    @JsonProperty("publicTime")
    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
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
