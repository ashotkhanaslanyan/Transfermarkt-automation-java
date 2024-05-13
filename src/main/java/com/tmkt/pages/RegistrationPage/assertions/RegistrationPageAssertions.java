package com.tmkt.pages.RegistrationPage.assertions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.openqa.selenium.WebDriver;

public class RegistrationPageAssertions {

    private final WebDriver driver;
    private final com.tmkt.pages.RegistrationPage.repository.RegistrationPageRepository repo = new com.tmkt.pages.RegistrationPage.repository.RegistrationPageRepository();
    
    public RegistrationPageAssertions(WebDriver driver) {
        this.driver = driver;
    }

    public void ValidateSuccessfulRegistrations() {
        assertDoesNotThrow(() -> driver.findElement(repo.RegistrationSuccessfulMessage),
            "Successful registration page did not open");
    }
}
