
package net.jamie.datamodels;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "priceConversionData",
    "status"
})
public class PriceConversionResponse {

    @JsonProperty("priceConversionData")
    private PriceConversionData priceConversionData;
    @JsonProperty("status")
    private Status status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("priceConversionData")
    public PriceConversionData getPriceConversionData() {
        return priceConversionData;
    }

    @JsonProperty("priceConversionData")
    public void setPriceConversionData(PriceConversionData priceConversionData) {
        this.priceConversionData = priceConversionData;
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
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
