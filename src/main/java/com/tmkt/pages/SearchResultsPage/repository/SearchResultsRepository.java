package com.tmkt.pages.SearchResultsPage.repository;

import org.openqa.selenium.By;

public class SearchResultsRepository {

    // Items in search result page
    public By NothingFoundMessage = By.xpath(".//main//div[@class='box']/h2[contains(text(), 'Nothing found?')]");

    public By GetFirstResultName(String playerName) {
        return By.xpath(String.format("(.//div[@id='yw0']//tr[@class='odd'])[1]//a[@title='%s']", playerName));
    }

    public By GetFirstResultClub(String clubName) {
        return By.xpath(String.format("(.//div[@id='yw0']//tr[@class='odd'])[1]//a[@title='%s']", clubName));
    }
}