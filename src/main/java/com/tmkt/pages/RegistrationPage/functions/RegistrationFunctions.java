package com.tmkt.pages.RegistrationPage.functions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmkt.tools.FormValuesParser;

public class RegistrationFunctions {
    
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final com.tmkt.pages.RegistrationPage.repository.RegistrationPageRepository repo = new com.tmkt.pages.RegistrationPage.repository.RegistrationPageRepository();
    
    public RegistrationFunctions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait((driver), Duration.ofSeconds(5));
    }

    public void WaitForRegistrationFormToLoad() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.RegistrationForm));
    }

    public void FillOutTheForm() {
        String nickname = FormValuesParser.getNickname();
        String firstName = FormValuesParser.getFirstname();
        String lastName = FormValuesParser.getLastname();
        String email = FormValuesParser.getEmail();
        String password = FormValuesParser.getPassword();
        System.out.println(nickname);
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(email);
        System.out.println(password);
        driver.findElement(repo.UserNickname).sendKeys(nickname);
        driver.findElement(repo.FirstName).sendKeys(firstName);
        driver.findElement(repo.LastName).sendKeys(lastName);
        driver.findElement(repo.Email).sendKeys(email);
        driver.findElement(repo.RepeatEmail).sendKeys(email);
        driver.findElement(repo.Password).sendKeys(password);
        driver.findElement(repo.RepeatPassword).sendKeys(password);
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView(true);", 
            driver.findElement(repo.AcceptTerms));
        driver.findElement(repo.AcceptTerms).click();
    }

    public void SubmitForm() {
        driver.findElement(repo.SubmitBtn).click();
    }

    public void WaitForRegistrationSuccessPage() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.RegistrationSuccessful));
    }
}
