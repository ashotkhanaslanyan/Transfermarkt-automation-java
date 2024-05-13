package com.tmkt.TeamTests;

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
import com.tmkt.pages.BundesLigaPage.functions.BundesligaPageFunctions;
import com.tmkt.pages.TeamPage.functions.TeamPageFunctions;

import com.tmkt.pages.HomePage.assertions.HomePageAssertions;
import com.tmkt.pages.TeamPage.assertions.TeamPageAssertions;

public class TeamValueTest implements WebDriverProvider {

    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;
    private BundesligaPageFunctions objBundesligaPageFunctions;
    private TeamPageFunctions objTeamPageFunctions;

    private HomePageAssertions objHomePageAssertions;
    private TeamPageAssertions objTeamPageAssertions;

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
        objTeamPageFunctions = new TeamPageFunctions(driver);
        
        objHomePageAssertions = new HomePageAssertions(driver);
        objTeamPageAssertions = new TeamPageAssertions(driver);
        
        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();

        // Go to Bundesliga page
        objNavigations.GoToBundesligaPage();
        objBundesligaPageFunctions.WaitForBundesligaPageToLoad();
        objBundesligaPageFunctions.ScrollTableToView();
        objBundesligaPageFunctions.OpenTeamPage("VfB Stuttgart");
        objTeamPageFunctions.WaitForTeamPageToLoad();
    }
    
    @Test
    public void check_team_market_value_equals_sum_of_player_market_values() {
        objTeamPageAssertions.ValidateTeamPageOpen("VfB Stuttgart");
        objTeamPageAssertions.ValidateHeaderMVEqualsSumOfPlayersMV();
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
