package pages.HomePage.repository;

import org.openqa.selenium.By;

public class NavbarRepository {

    // Main Navbar
    public By CompetitionsNavBtn = By.xpath(".//nav//li[@class='main-navbar__list' and @data-nav-group='wettbewerbe']");
    
    // Competitions Dropdown Navbar
    public By AllEuropeanCompetitionsLink = By.xpath(".//nav//li[@class='main-navbar__list' and @data-nav-group='wettbewerbe']//a[contains(text(), 'All European Competitions')]");
}
