
package com.hbrooks.searchtrainapi.apiresponsemodel;

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
    "name",
    "crs",
    "tiploc",
    "country",
    "system"
})

public class Destination {

    @JsonProperty("name")
    private String name;
    @JsonProperty("crs")
    private String crs;
    @JsonProperty("tiploc")
    private String tiploc;
    @JsonProperty("country")
    private String country;
    @JsonProperty("system")
    private String system;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("crs")
    public String getCrs() {
        return crs;
    }

    @JsonProperty("crs")
    public void setCrs(String crs) {
        this.crs = crs;
    }

    @JsonProperty("tiploc")
    public String getTiploc() {
        return tiploc;
    }

    @JsonProperty("tiploc")
    public void setTiploc(String tiploc) {
        this.tiploc = tiploc;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
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
