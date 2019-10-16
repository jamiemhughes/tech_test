
package net.jamie.datamodels.mapresponse;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;
import net.jamie.datamodels.priceconversion.Status;

import java.util.HashMap;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "status"
})
public class MapResponse {

    @JsonProperty("data")
    private List<MapData> data = null;
    @JsonProperty("status")
    private Status status;
    @JsonIgnore
    private java.util.Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public List<MapData> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<MapData> data) {
        this.data = data;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonAnyGetter
    public java.util.Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
