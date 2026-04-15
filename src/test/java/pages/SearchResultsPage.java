package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class SearchResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class,'flight-result') or contains(@class,'flight-card')]")
    private List<WebElement> flightResults;

    @FindBy(xpath = "//span[contains(@class,'price') or contains(@class,'amount')]")
    private List<WebElement> priceElements;

    @FindBy(xpath = "//h1[contains(text(),'flights') or contains(text(),'Results')]")
    private WebElement resultsHeader;

    @FindBy(xpath = "//div[contains(@class,'no-result') or contains(text(),'No flights')]")
    private WebElement noResultsMessage;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public boolean areFlightResultsDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(flightResults));
            return !flightResults.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public int getFlightResultCount() {
        return flightResults.size();
    }

    public String getFirstFlightPrice() {
        if (!priceElements.isEmpty()) {
            return priceElements.get(0).getText();
        }
        return "Price not found";
    }

    public boolean isResultsPageLoaded() {
        try {
            wait.until(ExpectedConditions.urlContains("booking"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
