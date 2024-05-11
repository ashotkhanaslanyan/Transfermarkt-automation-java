package NavigationTests;

import java.net.URL;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import pages.HomePage.functions.AcceptCookies;
import pages.HomePage.functions.Navigations;

import pages.HomePage.assertions.HomePageAssertions;
import pages.EuropeanLeaguesAndCupsPage.assertions.EuroLeaguesAndCupsAssertions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EuropeanLeaguesMapTest {
    
    // private RemoteWebDriver driver;
    private WebDriver driver;
    private AcceptCookies objAcceptCookies;
    private Navigations objNavigations;

    private HomePageAssertions objHomePageAssertions;
    private EuroLeaguesAndCupsAssertions objEuroLeaguesAndCupsAssertions;

    ChromeOptions chromeOptions = new ChromeOptions();

    @BeforeAll
    public void setup() throws Exception {
        
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        // this.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.get("https://www.transfermarkt.com");

        objAcceptCookies = new AcceptCookies(driver);
        objNavigations = new Navigations(driver);

        objHomePageAssertions = new HomePageAssertions(driver);
        objEuroLeaguesAndCupsAssertions = new EuroLeaguesAndCupsAssertions(driver);

        // Accept cookies and ads and continue
        objAcceptCookies.AcceptCookiesAndCloseNotice();
        objHomePageAssertions.ValidateHomePageOpen();
    }

    @Test
    public void navigate_to_all_european_competitions_page() {
        objNavigations.GoToEuropeanCompetitionsPage();
        objEuroLeaguesAndCupsAssertions.ValidateEuroLeaguesAndCupsPageOpen();
    }

    @AfterAll
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}
