package com.tmkt.pages.BundesLigaPage.repository;

import org.openqa.selenium.By;

public class BundesligaRepository {
    
    // Bundesliga header
    public By BundesligaHeader = By.xpath(".//h1[contains(text(), 'Bundesliga')]");

    public By SortByTMVBtn = By.xpath(".//div[@id='yw1']//thead//a[contains(text(), 'Total market value')]");
    public By SortByAgeBtn = By.xpath(".//div[@id='yw1']//thead//a[contains(text(), 'age')]");

    public By TMVColumn = By.xpath(".//div[@id='yw1']//tbody//td[@class='rechts'][2]/a");
    public By AgeColumn = By.xpath(".//div[@id='yw1']//tbody//td[@class='zentriert'][2]");

    public By BundesligaTable = By.id("yw1");
    public By InfoBox = By.xpath(".//div[@class='box']/h2[contains(text(), 'Info')]");
}
