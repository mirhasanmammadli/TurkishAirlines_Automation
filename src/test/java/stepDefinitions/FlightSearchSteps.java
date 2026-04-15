package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchResultsPage;
import utilities.BaseDriver;
import org.openqa.selenium.WebDriver;

public class FlightSearchSteps {

    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        driver = BaseDriver.getDriver();
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    @Given("I am on the Turkish Airlines homepage")
    public void iAmOnTheTurkishAirlinesHomepage() {
        homePage.navigateToHomePage();
        homePage.acceptCookiesIfPresent();
    }

    @When("I enter origin {string} and destination {string}")
    public void iEnterOriginAndDestination(String origin, String destination) {
        homePage.enterOrigin(origin);
        homePage.enterDestination(destination);
    }

    @And("I click the search button")
    public void iClickTheSearchButton() {
        homePage.clickSearch();
    }

    @Then("flight results should be displayed")
    public void flightResultsShouldBeDisplayed() {
        boolean resultsLoaded = searchResultsPage.isResultsPageLoaded();
        Assert.assertTrue(resultsLoaded, "Flight results page did not load as expected.");
    }

    @Then("the page title should contain {string}")
    public void thePageTitleShouldContain(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Expected title to contain: " + expectedTitle + " but was: " + actualTitle);
    }

    @After
    public void tearDown() {
        BaseDriver.closeDriver();
    }
}
