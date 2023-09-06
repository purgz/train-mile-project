
package com.hbrooks.searchtrainapi.apiresponsemodel;

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
    "location",
    "filter",
    "services"
})

//generated POJO for the api response from realtimetrains
public class TrainSearchResponse {

    @JsonProperty("location")
    private Location location;
    @JsonProperty("filter")
    private Filter filter;
    @JsonProperty("services")
    private List<Service> services;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonProperty("filter")
    public Filter getFilter() {
        return filter;
    }

    @JsonProperty("filter")
    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    @JsonProperty("services")
    public List<Service> getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(List<Service> services) {
        this.services = services;
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
