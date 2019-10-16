package net.jamie.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("/watchlist")
public class WatchListPage extends HomePage {

    By theCurrenciesResultItemLocator = By.cssSelector("table#currencies tbody tr");


    public WatchListPage(WebDriver driver) {
        super(driver);
    }

    public List<CurrencyItem> getAllCurrencyResults() {
        return findAll (theCurrenciesResultItemLocator )
                .stream()
                .map( elm -> new CurrencyItem( elm ) )
                .collect( Collectors.toList() )
                ;
    }
}
