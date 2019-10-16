package net.jamie.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jnr.ffi.annotations.In;
import net.jamie.datamodels.CurrencyItem;
import net.jamie.pages.HomePage;
import net.jamie.pages.WatchListPage;
import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.linesOf;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepageViewsStepDefinitions {

    HomePage theHomepage;
    WatchListPage theWatchList;
    List<CurrencyItem> myChosenWatchListItems= new ArrayList<>();

    @Given("I am not logged in")
    public void iAmNotLoggedIn() {
        //TODO:
        //Clear cookies to be safe
    }

    @And("have navigated to the homepage")
    public void haveNavigatedToTheHomepage() {
        theHomepage.open();
    }


    @When("\"View All\" is chosen")
    public void isChosen() {
        theHomepage.getViewAllButton.click();
    }

    @Then("more than {int} currency results should be displayed")
    public void moreThanCurrencyResultsShouldBeDisplayed(int aNumberOfResults) {
        assertThat( theHomepage.getAllCurrencyResults().size() ).isGreaterThan( aNumberOfResults );
    }

    @When("between {int} and {int} random currencies are added to the watchlist")
    public void betweenAndRandomCurrenciesAreAddedToTheWatchlist(int aStartNumber, int aEndNumber) {
        int myRandomInt = generateRandomIntRange(aStartNumber,aEndNumber);

        List<Integer> blacklist= new ArrayList<>();

        for ( int i=0; i<myRandomInt; i++ ){
                int myIndex = generateRandomIntRange(1,theHomepage.getAllCurrencyResults().size(),blacklist);
                blacklist.add(myIndex);

                HomePage.CurrencyItem actualCurrencyItem = theHomepage.getAllCurrencyResults().get(myIndex-1);
                actualCurrencyItem.addToWatchList();

                CurrencyItem testDataItem = new CurrencyItem()
                        .setMcap( actualCurrencyItem.getMcap().getText() )
                        .setName( actualCurrencyItem.getName().getText() )
                        .setPrice( actualCurrencyItem.getPrice().getText() )
                        .setSupply( actualCurrencyItem.getSupply().getText() )
                        .setVolume( actualCurrencyItem.getVolume().getText() )
                ;

                myChosenWatchListItems.add( testDataItem );
        }
    }

    @And("the watchlist is viewed in a different browser tab")
    public void theWatchlistIsViewedInADifferentBrowserTab() {
        theHomepage.openWatchListInNewTab();
        theWatchList.shouldBeDisplayed();
    }

    @Then("the previously chosen currencies are correctly displayed in the watchlist")
    public void thePreviouslyChosenCurrenciesAreCorrectlyDisplayedInTheWatchlist() {
        List<CurrencyItem> actualCurrencyResults = new ArrayList<>();
        actualCurrencyResults =
                theWatchList.getAllCurrencyResults()
                .stream()
                .map( actualCurrencyItem -> {
                    return new CurrencyItem()
                            .setMcap( actualCurrencyItem.getMcap().getText() )
                            .setName( actualCurrencyItem.getName().getText() )
                            .setPrice( actualCurrencyItem.getPrice().getText() )
                            .setSupply( actualCurrencyItem.getSupply().getText() )
                            .setVolume( actualCurrencyItem.getVolume().getText() );
                })
                .collect(Collectors.toList())
        ;

        assertThat(myChosenWatchListItems).isSubsetOf(actualCurrencyResults);



    }

    @Then("exactly {int} currency results should be displayed")
    public void exactlyCurrencyResultsShouldBeDisplayed(int aNumberOfResults) {
        assertThat(  theHomepage.getAllCurrencyResults().size() ).isEqualTo( aNumberOfResults);
    }

    private int generateRandomIntRange(int aStart, int aEnd){
        if ( aStart >=  aEnd) {
            throw new IllegalArgumentException("Maximum range integer must be greater than minumum");
        }

        Random r = new Random();
        return r.nextInt((aEnd - aStart) + 1) + aStart;
    }


    private int generateRandomIntRange(int aStart, int aEnd, List<Integer> blacklist){
        int chosen = generateRandomIntRange(aStart,aEnd);

        while(blacklist.contains(chosen)){
            chosen = generateRandomIntRange(aStart,aEnd);
        }

        return chosen;

    }


    @When("the full list of currencies is chosen")
    public void theFullListOfCurrenciesIsChosen() {
        theHomepage.getViewAllButton.click();
    }


    @And("a market cap filter of {string} is chosen")
    public void aMarketCapFilterOfMCAPIsChosen(String aMcap) {
       // theHomepage.chooseMcap();
    }
}
