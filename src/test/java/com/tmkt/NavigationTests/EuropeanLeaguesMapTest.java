package com.tmkt.NavigationTests;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.tmkt.utilities.WebDriverProvider;

import com.tmkt.pages.HomePage.functions.AcceptCookies;
import com.tmkt.pages.HomePage.functions.Navigations;
import com.tmkt.pages.EuropeanLeaguesAndCupsPage.functions.EuropeMap;

import com.tmkt.pages.HomePage.assertions.HomePageAssertions;
import com.tmkt.pages.EuropeanLeaguesAndCupsPage.assertions.CountrywiseAssertions;
import com.tmkt.pages.EuropeanLeaguesAndCupsPage.assertions.EuroLeaguesAndCupsAssertions;

public class EuropeanLeaguesMapTest implements WebDriverProvider {

    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;
    private EuropeMap objEuropeMap;

    private HomePageAssertions objHomePageAssertions;
    private EuroLeaguesAndCupsAssertions objEuroLeaguesAndCupsAssertions;
    private CountrywiseAssertions objCountrywiseAssertions;

    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeClass
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

    @AfterClass
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }

    @Override
    public RemoteWebDriver getDriver() {
        return driver;
    }
}
