package pages.homePage.repository;

import org.openqa.selenium.By;

public class CookiePopupRepository {

    // Notification frame
    public By NotificationIframe = By.xpath(".//iframe[@title='Iframe title']");

    // Cookies notification items
    public By NotificationsWindow = By.id("notice");
    public By AcceptAndContinueBtn = By.xpath(".//div[@id='notice']//button[@title='Accept & continue']");

}