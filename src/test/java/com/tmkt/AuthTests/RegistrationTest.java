package com.tmkt.AuthTests;

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
import com.tmkt.pages.RegistrationPage.assertions.RegistrationPageAssertions;
import com.tmkt.pages.RegistrationPage.functions.RegistrationFunctions;
import com.tmkt.pages.HomePage.assertions.HomePageAssertions;


public class RegistrationTest implements WebDriverProvider {
    
    private RemoteWebDriver driver;

    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;
    private RegistrationFunctions objRegistrationFunctions;

    private HomePageAssertions objHomePageAssertions;
    private RegistrationPageAssertions objRegistrationPageAssertions;

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
        objRegistrationFunctions = new RegistrationFunctions(driver);
        
        objHomePageAssertions = new HomePageAssertions(driver);
        objRegistrationPageAssertions = new RegistrationPageAssertions(driver);
        
        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();
        objNavigations.GoToRegistrationPage();
        objRegistrationFunctions.WaitForRegistrationFormToLoad();
    }

    @Test
    public void fill_out_and_submit_registration_form() {
        objRegistrationFunctions.FillOutTheForm();
        objRegistrationFunctions.SubmitForm();
        objRegistrationFunctions.WaitForRegistrationSuccessPage();
        objRegistrationPageAssertions.ValidateSuccessfulRegistrations();
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
