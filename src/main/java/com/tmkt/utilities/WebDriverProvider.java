package com.tmkt.utilities;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverProvider {
    RemoteWebDriver getDriver();
}
