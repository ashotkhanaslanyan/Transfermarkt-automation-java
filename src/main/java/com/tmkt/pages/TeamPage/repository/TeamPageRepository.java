package com.tmkt.pages.TeamPage.repository;

import org.openqa.selenium.By;

public class TeamPageRepository {

    // Team page header
    public By TeamPageHeader = By.xpath(".//header[@class='data-header']//h1");
    public By TeamMarketValue = By.xpath(".//header[@class='data-header']//a[@class='data-header__market-value-wrapper']");

    public By TeamPlayersValue = By.xpath(".//div[@id='yw1']//tbody//td[@class='rechts hauptlink']/a");
}
