package com.tmkt.pages.HomePage.repository;

import org.openqa.selenium.By;

public class NavbarRepository {

    // Main Navbar
    public By CompetitionsNavBtn = By.xpath(".//nav//li[@data-nav-group='wettbewerbe']");
    
    // Competitions Dropdown Navbar
    public By AllEuropeanCompetitionsLink = By.xpath(".//nav//li[@data-nav-group='wettbewerbe']//a[contains(text(), 'All European Competitions')]");
    public By BundesligaLink = By.xpath(".//nav//li[@data-nav-group='wettbewerbe']//a/img[@alt='Bundesliga']");

    // Log in
    public By LoginBtn = By.id("login");
    public By RegisterLink = By.xpath(".//form[@id='login-form']//a[contains(text(), 'Register now')]");
}
