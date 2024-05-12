package pages.EuropeanLeaguesAndCupsPage.functions;

import org.openqa.selenium.WebDriver;

public class EuropeMap {

    private final WebDriver driver;
    private final pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository repo = new pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository();

    public EuropeMap(WebDriver driver) {
        this.driver = driver;
    }
    
    public void GoToGivenCountryLeague(String countryName) {
        driver.findElement(repo.GetCountry(countryName)).click();
    }
    
}
