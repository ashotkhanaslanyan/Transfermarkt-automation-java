package com.tmkt.pages.HomePage.functions;

import org.openqa.selenium.WebDriver;

public class Search {
    
    private final WebDriver driver;
    private final com.tmkt.pages.HomePage.repository.HomePageRepository repo = new com.tmkt.pages.HomePage.repository.HomePageRepository();

    public Search(WebDriver driver) {
        this.driver = driver;
    }

    public void SearchByText(String searchInput) {
        driver.findElement(repo.Searchbar).click();
        driver.findElement(repo.Searchbar).clear();
        driver.findElement(repo.Searchbar).sendKeys(searchInput);
        driver.findElement(repo.SearchbarSubmit).click();
    }
}
