package NavigationTests;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.HomePage.functions.AcceptCookies;
import pages.HomePage.functions.Navigations;
import pages.EuropeanLeaguesAndCupsPage.functions.EuropeMap;

import pages.HomePage.assertions.HomePageAssertions;
import pages.EuropeanLeaguesAndCupsPage.assertions.CountrywiseAssertions;
import pages.EuropeanLeaguesAndCupsPage.assertions.EuroLeaguesAndCupsAssertions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EuropeanLeaguesMapTest {
    
    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;
    private EuropeMap objEuropeMap;

    private HomePageAssertions objHomePageAssertions;
    private EuroLeaguesAndCupsAssertions objEuroLeaguesAndCupsAssertions;
    private CountrywiseAssertions objCountrywiseAssertions;

    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeAll
    public void setup() throws Exception {
        try {
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            driver.get("https://www.transfermarkt.com");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }

        objAcceptCookies = new AcceptCookies(driver);
        objNavigations = new Navigations(driver);
        objEuropeMap = new EuropeMap(driver);

        objHomePageAssertions = new HomePageAssertions(driver);
        objEuroLeaguesAndCupsAssertions = new EuroLeaguesAndCupsAssertions(driver);
        objCountrywiseAssertions = new CountrywiseAssertions(driver);

        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();
    }

    @Test
    public void check_top_five_leagues_map_navigation() {
        List<String> countriesList = Arrays.asList("France", "Germany", "Spain", "Italy", "England");
        for (String country : countriesList) {
            objNavigations.GoToEuropeanCompetitionsPage();
            objEuroLeaguesAndCupsAssertions.ValidateEuroLeaguesAndCupsPageOpen();
            objEuropeMap.GoToGivenCountryLeague(country);
            objCountrywiseAssertions.ValidateCountryLeaguesPageOpen();
            objCountrywiseAssertions.ValidateNationalTeamExists(country);
            objCountrywiseAssertions.ValidateFirstTierLeagueExists(country);
        }
    }

    @AfterAll
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
