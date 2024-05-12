package com.tmkt.pages.EuropeanLeaguesAndCupsPage.functions;

import org.openqa.selenium.WebDriver;

public class EuropeMap {

    private final WebDriver driver;
    private final com.tmkt.pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository repo = new com.tmkt.pages.EuropeanLeaguesAndCupsPage.repository.EuroLeaguesPageRepository();

    public EuropeMap(WebDriver driver) {
        this.driver = driver;
    }
    
    public void GoToGivenCountryLeague(String countryName) {
        driver.findElement(repo.GetCountry(countryName)).click();
    }
    
}
