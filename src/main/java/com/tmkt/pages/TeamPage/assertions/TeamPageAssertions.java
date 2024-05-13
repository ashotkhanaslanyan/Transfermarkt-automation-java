package com.tmkt.pages.TeamPage.assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tmkt.pages.BundesLigaPage.functions.HelperFunctions;
import com.tmkt.tools.PMVSumCalculator;

public class TeamPageAssertions {
    
    private final WebDriver driver;
    private final com.tmkt.pages.TeamPage.repository.TeamPageRepository repo = new com.tmkt.pages.TeamPage.repository.TeamPageRepository();
    private final PMVSumCalculator pmvSumCalculator = new PMVSumCalculator();
    private final HelperFunctions objHelperFunctions;

    public TeamPageAssertions(WebDriver driver) {
        this.driver = driver;
        objHelperFunctions = new HelperFunctions(driver);
    }

    public void ValidateTeamPageOpen(String teamName) {
        Assert.assertEquals(teamName, driver.findElement(repo.TeamPageHeader).getText());
    }

    public void ValidateHeaderMVEqualsSumOfPlayersMV() {
        Assert.assertEquals(pmvSumCalculator.getTMVFromPMVs(
            objHelperFunctions.getColumnToList(repo.TeamPlayersValue)),
            pmvSumCalculator.getTMVFromHeaderValues(
                driver.findElement(repo.TeamMarketValue).getText()));
    }

}
