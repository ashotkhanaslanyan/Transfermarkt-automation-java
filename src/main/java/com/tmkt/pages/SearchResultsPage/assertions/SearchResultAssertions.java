package com.tmkt.pages.SearchResultsPage.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.openqa.selenium.WebDriver;

public class SearchResultAssertions {

    private final WebDriver driver;
    private final com.tmkt.pages.SearchResultsPage.repository.SearchResultsRepository repo = new com.tmkt.pages.SearchResultsPage.repository.SearchResultsRepository();
    private final com.tmkt.tools.PlayerClubParser PlayerClubParser = new com.tmkt.tools.PlayerClubParser();

    public SearchResultAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void ValidateNoResultsFound() {
        assertDoesNotThrow(() -> driver.findElement(repo.NothingFoundMessage),
            "We didn't expect results to show");
    }

    public void ValidateCorrectPlayerIsShown(String playerName) {
        assertDoesNotThrow(() -> driver.findElement(repo.GetFirstResultName(playerName)),
            String.format("Player %s is not the first result", playerName));
    }

    public void ValidateCorrectClubIsShown(String playerName) {
        String clubName = PlayerClubParser.getClub(playerName);
        assertDoesNotThrow(() -> driver.findElement(repo.GetFirstResultClub(clubName)),
            String.format("Club %s did not show for player %s", clubName, playerName));
    }
}
