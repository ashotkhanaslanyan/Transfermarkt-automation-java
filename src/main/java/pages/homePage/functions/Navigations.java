package pages.homePage.functions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Navigations {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;
    private final pages.homePage.repository.NavbarRepository repo = new pages.homePage.repository.NavbarRepository();
    
    public Navigations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
        this.action = new Actions(driver);
    }

    public void GoToEuropeanCompetitionsPage() {
        action.moveToElement(driver.findElement(repo.CompetitionsNavBtn)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(repo.AllEuropeanCompetitionsLink));
        driver.findElement(repo.AllEuropeanCompetitionsLink).click();
    }
}
