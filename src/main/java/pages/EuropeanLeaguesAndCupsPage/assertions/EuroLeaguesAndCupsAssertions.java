package pages.EuropeanLeaguesAndCupsPage.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.openqa.selenium.WebDriver;

public class EuroLeaguesAndCupsAssertions {
    
    private final WebDriver driver;
    private final pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository repo = new pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository();
    
    public EuroLeaguesAndCupsAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void ValidateEuroLeaguesAndCupsPageOpen() {
        assertDoesNotThrow(() -> driver.findElement(repo.EuropeMap),
            "Couldn't find the map of Europe");
    }
    
}
