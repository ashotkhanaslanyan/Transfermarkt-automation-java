package com.tmkt.pages.TeamPage.functions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamPageFunctions {

    private final WebDriverWait wait;
    private final com.tmkt.pages.TeamPage.repository.TeamPageRepository repo = new com.tmkt.pages.TeamPage.repository.TeamPageRepository();
    
    public TeamPageFunctions(WebDriver driver) {
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
    }

    public void WaitForTeamPageToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.TeamPageHeader));
    }
}
