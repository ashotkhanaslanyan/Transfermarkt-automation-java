package com.tmkt.pages.BundesLigaPage.functions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BundesligaPageFunctions {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final com.tmkt.pages.BundesLigaPage.repository.BundesligaRepository repo = new com.tmkt.pages.BundesLigaPage.repository.BundesligaRepository();

    public BundesligaPageFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
    }

    public void WaitForBundesligaPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.BundesligaHeader));
    }

    public void WaitForBundesligaTableToLoad() {
        wait.until(ExpectedConditions.attributeToBe(repo.BundesligaTable, "class", "grid-view"));
    }

    public void ScrollTableToView() {
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", 
            driver.findElement(repo.InfoBox));
    }

    public void SortClubsByTMVAsc() {
        if (driver.findElement(repo.SortByTMVBtn).getAttribute("class") != "sort-link asc") {
            driver.findElement(repo.SortByTMVBtn).click();
            WaitForBundesligaTableToLoad();
            if (driver.findElement(repo.SortByTMVBtn).getAttribute("class") != "sort-link asc") {
                driver.findElement(repo.SortByTMVBtn).click();
                WaitForBundesligaTableToLoad();
            }
        }
    }

    public void SortClubsByTMVDesc() {
        if (driver.findElement(repo.SortByTMVBtn).getAttribute("class") != "sort-link desc") {
            driver.findElement(repo.SortByTMVBtn).click();
            WaitForBundesligaTableToLoad();
        }
    }

    public void SortClubsByAgeAsc() {
        if (driver.findElement(repo.SortByAgeBtn).getAttribute("class") != "sort-link asc") {
            driver.findElement(repo.SortByAgeBtn).click();
            WaitForBundesligaTableToLoad();
            if (driver.findElement(repo.SortByAgeBtn).getAttribute("class") != "sort-link asc") {
                driver.findElement(repo.SortByAgeBtn).click();
                WaitForBundesligaTableToLoad();
            }
        }
    }

    public void SortClubsByAgeDesc() {
        if (driver.findElement(repo.SortByAgeBtn).getAttribute("class") != "sort-link desc") {
            driver.findElement(repo.SortByAgeBtn).click();
            WaitForBundesligaTableToLoad();
        }
    }

    public void OpenTeamPage(String teamName) {
        driver.findElement(repo.getTeam(teamName)).click();
    }
}
