package net.jamie.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jamie.client.CryptoClient;
import net.jamie.datamodels.MapResponse;
import net.jamie.datamodels.PriceConversionResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiStepDefinitions {

    CryptoClient cryptoClient = new CryptoClient();
    private MapResponse myMapResponseResponse;
    private PriceConversionResponse myPriceConversionResponse;


    @Given("a request is made to retrieve the ID for the crypto:{string}")
    public void aRequestIsMadeToRetrieveTheIDForTheCryptoCrypto(String crypto) {
        myMapResponseResponse = cryptoClient.getMap(crypto);
    }


    @When("the price conversion is requested for {string}")
    public void thePriceConversionIsRequestedFor(String currency) {
        myPriceConversionResponse = cryptoClient.getPrice( myMapResponseResponse.getData().get(0).getId(), currency);

    }

    @Then("then a conversion reponse should be received")
    public void thenAConversionReponseShouldBeReceived() {
        assertThat( myPriceConversionResponse.getStatus().getErrorCode() ).isEqualTo(0);
    }
}
