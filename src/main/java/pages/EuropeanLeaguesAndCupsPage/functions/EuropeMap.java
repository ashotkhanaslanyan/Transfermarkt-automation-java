package pages.EuropeanLeaguesAndCupsPage.functions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.CountryLeagueParser;

public class EuropeMap {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;
    private final pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository repo = new pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository();
    private final CountryLeagueParser CLParser = new CountryLeagueParser();

    public EuropeMap(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
        this.action = new Actions(driver);
    }
    
    public void GoToGivenCountryLeague(String countryName) {
        driver.findElement(repo.GetCountry(countryName)).click();
    }
    
}
