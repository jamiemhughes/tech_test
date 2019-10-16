package net.jamie.pages;

import com.paulhammant.ngwebdriver.ByAngularModel;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.text.JTextComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("/")
public class HomePage extends PageObject {

    @FindBy(linkText = "View All")
    public WebElementFacade getViewAllButton;

    @FindBy(linkText = "Watchlist")
    public WebElementFacade getWatchList;

    By theCurrenciesResultItemLocator = By.cssSelector("table#currencies tbody tr");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public List<CurrencyItem> getAllCurrencyResults() {
        return findAll (theCurrenciesResultItemLocator )
                .stream()
                .map( elm -> new CurrencyItem( elm ) )
                .collect( Collectors.toList() )
                ;
    }

    public void openWatchListInNewTab(){
        //TODO: This needs to be moved to a base PageObject class to contain helpers for these type of hacks.
        WebDriver myDriver = HomePage.this.getDriver();

        JavascriptExecutor executor = (JavascriptExecutor)myDriver;
        String url = this.getWatchList.getAttribute("href");
        String a = "window.open('"+url+"','_blank');";
        executor.executeScript(a);

        ArrayList<String> tabs2 = new ArrayList<> (myDriver.getWindowHandles());
        myDriver.switchTo().window(tabs2.get(2));

    }


    public class CurrencyItem extends PageObject{
        WebElementFacade theRootElm;
        By theNameBy = By.cssSelector("td[class*='currency-name']");
        By theMcapBy = By.cssSelector("td[class*='market-cap']");
        By thePriceBy = By.cssSelector("a[class*='price']");
        By theVolumeBy = By.cssSelector("a[class*='volume']");
        By theSupplyBy = By.cssSelector("td[class*='circulating-supply']");
        By theEllipsisBy = By.cssSelector("td.dropdown button span");
        By theWatchListBy = By.linkText("Add to Watchlist");

        public CurrencyItem(WebElementFacade aRootElm) {
            theRootElm = aRootElm;
        }

        public WebElementFacade getName(){
            return theRootElm.find(theNameBy);
        }

        public WebElementFacade getMcap(){
            return theRootElm.find(theMcapBy);
        }

        public WebElementFacade getPrice(){
            return theRootElm.find(thePriceBy);
        }

        public WebElementFacade getVolume(){
            return theRootElm.find(theVolumeBy);
        }

        public WebElementFacade getSupply(){
            return theRootElm.find(theSupplyBy);
        }

        public WebElementFacade getEllipsis(){
            return theRootElm.find(theEllipsisBy);
        }

        public void addToWatchList() {
            //TODO: Refactor out of here to make reusable. Its a javascript click to get around the selenium intercept problem .

            JavascriptExecutor executor = (JavascriptExecutor)HomePage.this.getDriver();

            executor.executeScript("arguments[0].click();", getEllipsis());
            WebElement watchList = theRootElm.find(theWatchListBy);
            ((WebElementFacade) watchList).waitUntilClickable();
            executor.executeScript("arguments[0].click();", watchList);

        }

    }
}