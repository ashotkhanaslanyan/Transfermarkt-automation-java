package com.tmkt.SearchTests;

import java.net.URL;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import com.tmkt.pages.HomePage.assertions.HomePageAssertions;
import com.tmkt.pages.HomePage.functions.AcceptCookies;
import com.tmkt.pages.HomePage.functions.Search;
import com.tmkt.pages.SearchResultsPage.assertions.SearchResultAssertions;
import com.tmkt.utilities.WebDriverProvider;

public class PlayerSearchTest implements WebDriverProvider {
    
    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Search objSearch;

    private HomePageAssertions objHomePageAssertions;
    private SearchResultAssertions objSearchResultAssertions;

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
        objSearch = new Search(driver);
        objHomePageAssertions = new HomePageAssertions(driver);
        objSearchResultAssertions = new SearchResultAssertions(driver);

        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();
    }

    @Test
    public void search_player_by_full_name() {
        objSearch.SearchByText("Cristiano Ronaldo");
        objSearchResultAssertions.ValidateCorrectPlayerIsShown("Cristiano Ronaldo");
        objSearchResultAssertions.ValidateCorrectClubIsShown("Cristiano Ronaldo");
    }

    @Test
    public void search_player_by_first_name() {
        objSearch.SearchByText("Lionel");
        objSearchResultAssertions.ValidateCorrectPlayerIsShown("Lionel Messi");
        objSearchResultAssertions.ValidateCorrectClubIsShown("Lionel Messi");
    }

    @Test
    public void search_non_existing_player() {
        objSearch.SearchByText("Ashot Khan-Aslanyan");
        objSearchResultAssertions.ValidateNoResultsFound();
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public RemoteWebDriver getDriver() {
        return driver;
    }
}
