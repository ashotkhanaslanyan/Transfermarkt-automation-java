package pages.HomePage.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.openqa.selenium.WebDriver;

public class HomePageAssertions {

    private final WebDriver driver;
    private final pages.HomePage.repository.HomePageRepository repo = new pages.HomePage.repository.HomePageRepository();

    public HomePageAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void ValidateHomePageOpen() {
        assertDoesNotThrow(() -> driver.findElement(repo.SpotlightHeader),
            "Couldn't find the SPOTLIGHT");
    }
    
}
