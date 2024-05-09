package NavigationTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.homePage.functions.AcceptCookies;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EuropeanLeaguesMapTest {
    
    private WebDriver driver;
    private AcceptCookies objAcceptCookies;

    @BeforeAll
    public void setup() throws Exception {
        
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.transfermarkt.com");

        objAcceptCookies = new AcceptCookies(driver);
    }

    @Test
    public void open_and_close_notice() {
        objAcceptCookies.AcceptCookiesAndCloseNotice();
    }
}
