package com.tmkt.LeagueTests;

import java.net.URL;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.tmkt.utilities.WebDriverProvider;

import com.tmkt.pages.HomePage.functions.AcceptCookies;
import com.tmkt.pages.HomePage.functions.Navigations;

import com.tmkt.pages.HomePage.assertions.HomePageAssertions;
import com.tmkt.pages.BundesLigaPage.assertions.BundesligaAsserions;
import com.tmkt.pages.BundesLigaPage.functions.BundesligaPageFunctions;

public class BundesligaSortTest implements WebDriverProvider {

    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;
    private BundesligaPageFunctions objBundesligaPageFunctions;

    private HomePageAssertions objHomePageAssertions;
    private BundesligaAsserions objBundesligaAsserions;

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
        objBundesligaPageFunctions = new BundesligaPageFunctions(driver);
        
        objHomePageAssertions = new HomePageAssertions(driver);
        objBundesligaAsserions = new BundesligaAsserions(driver);
        
        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();

        // Go to Bundesliga page
        objNavigations.GoToBundesligaPage();
        objBundesligaPageFunctions.WaitForBundesligaPageToLoad();
        objBundesligaPageFunctions.ScrollTableToView();
    }

    @Test
    public void check_sorting_tmv_in_descending_order() {
        objBundesligaPageFunctions.SortClubsByTMVDesc();
        objBundesligaAsserions.ValidateTMVSortedDescending();
    }

    @Test
    public void check_sorting_tmv_in_ascending_order() {
        objBundesligaPageFunctions.SortClubsByTMVAsc();
        objBundesligaAsserions.ValidateTMVSortedAscending();
    }
    
    @Test
    public void check_sorting_age_in_descending_order() {
        objBundesligaPageFunctions.SortClubsByAgeDesc();
        objBundesligaAsserions.ValidateAgeSortedDescending();
    }

    @Test
    public void check_sorting_age_in_ascending_order() {
        objBundesligaPageFunctions.SortClubsByAgeAsc();
        objBundesligaAsserions.ValidateAgeSortedAscending();
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
