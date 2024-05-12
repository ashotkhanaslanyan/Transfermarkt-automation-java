package com.tmkt.pages.HomePage.repository;

import org.openqa.selenium.By;

public class HomePageRepository {

    // Home (News) page items
    public By SpotlightHeader = By.id("spotlight");

    // Searchbar
    public By Searchbar = By.xpath(".//form[@id='schnellsuche']/input[@type='text']");
    public By SearchbarSubmit = By.xpath(".//form[@id='schnellsuche']/input[@type='submit']");
}