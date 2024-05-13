package com.tmkt.pages.BundesLigaPage.assertions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.tmkt.pages.BundesLigaPage.functions.HelperFunctions;
import com.tmkt.tools.TMVSortChecker;
import com.tmkt.tools.AgeSortChecker;

public class BundesligaAsserions {

    private final com.tmkt.pages.BundesLigaPage.repository.BundesligaRepository repo = new com.tmkt.pages.BundesLigaPage.repository.BundesligaRepository();
    private final TMVSortChecker tmvSortChecker = new TMVSortChecker();
    private final AgeSortChecker ageSortChecker = new AgeSortChecker();
    private final HelperFunctions objHelperFunctions;

    public BundesligaAsserions(WebDriver driver) {
        objHelperFunctions = new HelperFunctions(driver);
    }

    public void ValidateTMVSortedAscending() {
        Assert.assertTrue(tmvSortChecker.isSortedAscending(
            objHelperFunctions.getColumnToList(repo.TMVColumn)),
            "Total Market Value column is not sorted in ascending order");
    }

    public void ValidateTMVSortedDescending() {
        Assert.assertTrue(tmvSortChecker.isSortedDescending(
            objHelperFunctions.getColumnToList(repo.TMVColumn)),
            "Total Market Value column is not sorted in descending order");
    }

    public void ValidateAgeSortedAscending() {
        Assert.assertTrue(ageSortChecker.isSortedAscending(
            objHelperFunctions.getColumnToList(repo.AgeColumn)),
            "Age column is not sorted in ascending order");
    }
    
    public void ValidateAgeSortedDescending() {
        Assert.assertTrue(ageSortChecker.isSortedDescending(
            objHelperFunctions.getColumnToList(repo.AgeColumn)),
            "Age column is not sorted in descending order");
    }
}
