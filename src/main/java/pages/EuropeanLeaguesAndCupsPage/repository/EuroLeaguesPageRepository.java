package pages.EuropeanLeaguesAndCupsPage.repository;

import org.openqa.selenium.By;

public class EuroLeaguesPageRepository {
    
    // Europa map
    public By EuropeMap = By.xpath(".//map[@name='europa_Map' and @id='europa_Map']");

    // Return the locator of given country
    public By GetCountry(String countryName) {
        return By.xpath(String.format(".//map[@name='europa_Map' and @id='europa_Map']//area[@title='%s']", countryName));
    }

}
