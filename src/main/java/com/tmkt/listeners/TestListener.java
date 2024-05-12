package com.tmkt.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.tmkt.utilities.ScreenshotUtil;
import com.tmkt.utilities.WebDriverProvider;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Triggered");
        Object currentClass = result.getInstance();
        RemoteWebDriver driver = null;
        
        if (currentClass instanceof WebDriverProvider) {
            driver = ((WebDriverProvider) currentClass).getDriver();
        }
        
        if (driver != null) {
            ScreenshotUtil.takeScreenshot(driver, result.getName());
        }
    }

    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
