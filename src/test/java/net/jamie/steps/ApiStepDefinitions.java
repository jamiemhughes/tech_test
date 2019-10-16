package net.jamie.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.jamie.client.CryptoClient;
import net.jamie.datamodels.inforesponse.InfoResponse;
import net.jamie.datamodels.mapresponse.MapResponse;
import net.jamie.datamodels.priceconversion.PriceConversionResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiStepDefinitions {

    CryptoClient cryptoClient = new CryptoClient();
    private MapResponse myMapResponseResponse;
    private PriceConversionResponse myPriceConversionResponse;
    private InfoResponse myInfoResponse;
    private String myid;


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
        assertThat( myPriceConversionResponse.getData().getId()).isNotNull();
    }


    @Given("I make a request to retrieve the technical documentation for {string} with id {string}")
    public void iMakeARequestToRetrieveTheTechnicalDocumentationForWithId(String name, String id) {
       cryptoClient.getInfo(id);
        myid=id;
    }

    @Then("a status of {int} should be received")
    public void aStatusOfShouldBeReceived(int status) {


        assertThat(cryptoClient.getLatestResponse().getStatusCode()).isEqualTo(status);
    }

    @And("the logo should be {string}")
    public void theLogoShouldBe(String logo) {
        //Can also use JSON path to check result
        assertThat(
         cryptoClient.getLatestResponse().getBody().jsonPath().getString("data."+myid+".logo")
        ).isEqualTo(logo);
    }

    @And("the technical doc uri should be {string}")
    public void theTechnicalDocUriShouldBe(String techuri) {
        assertThat(
                cryptoClient.getLatestResponse().getBody().jsonPath().getList("data."+myid+".urls.technical_doc").get(0)
        ).isEqualTo(techuri);
    }

    @And("the symbol should be {string}")
    public void theSymbolShouldBe(String symbol) {
        assertThat(
                cryptoClient.getLatestResponse().getBody().jsonPath().getString("data."+myid+".symbol")
        ).isEqualTo(symbol);
    }

    @And("the date added should be {string}")
    public void theDateAddedShouldBe(String date) {
        assertThat(
                cryptoClient.getLatestResponse().getBody().jsonPath().getString("data."+myid+".date_added")
        ).isEqualTo(date);
    }

    @And("the platform should be {string}")
    public void thePlatformShouldBe(String platform) {
        if (platform.equals("null")) {platform=null;}
        assertThat(
                cryptoClient.getLatestResponse().getBody().jsonPath().getString("data."+myid+".platform")
        ).isEqualTo(platform);
    }

    @And("the tags contain {string}")
    public void theTagsContain(String tag) {
        assertThat(
                cryptoClient.getLatestResponse().getBody().jsonPath().getString("data."+myid+".tags")
        ).contains(tag);
    }
}
