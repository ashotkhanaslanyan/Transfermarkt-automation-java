package com.tmkt.pages.BundesLigaPage.functions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;;

public class HelperFunctions {

    private final WebDriver driver;
    
    public HelperFunctions(WebDriver driver) {
        this.driver = driver;
    }

    public String[] getColumnToList(By columnLocator) {
        List<WebElement> elements = driver.findElements(columnLocator);
        String[] innerTextValues = new String[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            innerTextValues[i] = elements.get(i).getText();
        }
        return innerTextValues;
    }
}
