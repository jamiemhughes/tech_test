
package net.jamie.datamodels;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GBP",
    "LTC",
    "USD"
})
public class Quote {

    @JsonProperty("GBP")
    private GBP gBP;
    @JsonProperty("LTC")
    private LTC lTC;
    @JsonProperty("USD")
    private USD uSD;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("GBP")
    public GBP getGBP() {
        return gBP;
    }

    @JsonProperty("GBP")
    public void setGBP(GBP gBP) {
        this.gBP = gBP;
    }

    @JsonProperty("LTC")
    public LTC getLTC() {
        return lTC;
    }

    @JsonProperty("LTC")
    public void setLTC(LTC lTC) {
        this.lTC = lTC;
    }

    @JsonProperty("USD")
    public USD getUSD() {
        return uSD;
    }

    @JsonProperty("USD")
    public void setUSD(USD uSD) {
        this.uSD = uSD;
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
