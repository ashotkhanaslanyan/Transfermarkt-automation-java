package com.tmkt.pages.RegistrationPage.repository;

import org.openqa.selenium.By;

public class RegistrationPageRepository {
    
    // Registration form
    public By RegistrationForm = By.id("register-form");

    public By UserNickname = By.id("user_nick");
    public By FirstName = By.id("vorname");
    public By LastName = By.id("nachname");
    public By Email = By.id("email");
    public By RepeatEmail = By.id("RegisterForm_email2");
    public By Password = By.id("passwort1");
    public By RepeatPassword = By.id("passwort2");
    public By AcceptTerms = By.id("RegisterForm_nutzungsbedingungen_flag");

    public By SubmitBtn = By.xpath(".//input[@value='Register now']");

    public By RegistrationSuccessful = By.xpath(".//div[@id='main']//h2[contains(text(), 'Registration successful')]");
    public By RegistrationSuccessfulMessage = By.xpath(".//div[contains(text(), 'Thank you for registering with us. Please check your inbox and activate your account by clicking on the activation link.')]");
}
