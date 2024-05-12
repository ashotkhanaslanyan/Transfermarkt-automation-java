package com.tmkt.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File srcFile = screenshotDriver.getScreenshotAs(OutputType.FILE);

            Path destinationPath = Paths.get("screenshots", fileName + ".png");
            Files.createDirectories(destinationPath.getParent());

            Files.copy(srcFile.toPath(), destinationPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
