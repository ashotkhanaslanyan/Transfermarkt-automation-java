package com.tmkt.pages.EuropeanLeaguesAndCupsPage.repository;

import org.openqa.selenium.By;

public class CountryLeaguesPageRepository {

    // Country leagues page header
    public By CountryLeaguesPageHeader = By.xpath(".//main//div[@class='box']/h2[contains(text(), 'National leagues and domestic cups')]");
    
    // Retun the locator of the first national team that appears in National Teams page
    public By GetNationalTeamsFirstTeam(String countryName) {
        return By.xpath(String.format(".//main//div[@class='box']//li/a[@title='%s']", countryName));
    }

    // Return the locator of the first tier league
    public By GetFirstTierLeague(String leagueName) {
        return By.xpath(String.format(".//td[contains(text(), 'First Tier')]/following::tr[contains(@class, 'odd')]//a[@title='%s']", leagueName));
    }
}
