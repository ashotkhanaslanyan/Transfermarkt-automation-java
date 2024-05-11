package pages.HomePage.functions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AcceptCookies {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final pages.HomePage.repository.CookiePopupRepository repo = new pages.HomePage.repository.CookiePopupRepository();

    public AcceptCookies(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
    }

    public void AcceptCookiesAndCloseNotice() {
        wait.until(ExpectedConditions.presenceOfElementLocated(repo.NotificationIframe));
        driver.switchTo().frame(driver.findElement(repo.NotificationIframe));
        driver.findElement(repo.AcceptAndContinueBtn).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(repo.NotificationsWindow, 0));
        driver.switchTo().defaultContent();
    }
}
