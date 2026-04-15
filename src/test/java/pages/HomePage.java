package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // --- Locators ---
    @FindBy(id = "originPort")
    private WebElement originField;

    @FindBy(id = "destinationPort")
    private WebElement destinationField;

    @FindBy(xpath = "//button[contains(@class,'search-btn') or contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='departure-date']//input")
    private WebElement departureDateField;

    @FindBy(xpath = "//input[@aria-label='Return date']")
    private WebElement returnDateField;

    @FindBy(xpath = "//button[contains(@class,'cookie') or contains(text(),'Accept')]")
    private WebElement acceptCookiesButton;

    // --- Constructor ---
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    // --- Actions ---
    public void navigateToHomePage() {
        driver.get("https://www.turkishairlines.com/en-int/");
    }

    public void acceptCookiesIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Cookie popup not found or already dismissed.");
        }
    }

    public void enterOrigin(String origin) {
        wait.until(ExpectedConditions.elementToBeClickable(originField));
        originField.clear();
        originField.sendKeys(origin);
    }

    public void enterDestination(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(destinationField));
        destinationField.clear();
        destinationField.sendKeys(destination);
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
