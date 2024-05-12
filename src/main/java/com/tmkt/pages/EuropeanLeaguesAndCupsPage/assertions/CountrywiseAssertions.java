package com.tmkt.pages.EuropeanLeaguesAndCupsPage.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.openqa.selenium.WebDriver;

public class CountrywiseAssertions {
    
    private final WebDriver driver;
    private final com.tmkt.pages.EuropeanLeaguesAndCupsPage.repository.CountryLeaguesPageRepository repo = new com.tmkt.pages.EuropeanLeaguesAndCupsPage.repository.CountryLeaguesPageRepository();
    private final com.tmkt.tools.CountryLeagueParser CountryLeagueParser = new com.tmkt.tools.CountryLeagueParser();

    public CountrywiseAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void ValidateCountryLeaguesPageOpen() {
        assertDoesNotThrow(() -> driver.findElement(repo.CountryLeaguesPageHeader),
            "Couldn't find the domestic leagues header");
    }

    public void ValidateNationalTeamExists(String countryName) {
        assertDoesNotThrow(() -> driver.findElement(repo.GetNationalTeamsFirstTeam(countryName)),
            "Couldn't find the national team");      
    }

    public void ValidateFirstTierLeagueExists(String countryName) {
        String leagueName = CountryLeagueParser.getLeague(countryName);
        assertDoesNotThrow(() -> driver.findElement(repo.GetFirstTierLeague(leagueName)),
            "Couldn't find the first tier league");      
    }
}
