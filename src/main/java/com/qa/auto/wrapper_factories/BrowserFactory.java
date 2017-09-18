package com.qa.auto.wrapper_factories;

import com.qa.auto.helpers.PropertyWorker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Olexiy on 9/13/2017.
 */
public class BrowserFactory {
    private static WebDriver driver = null;

    public static WebDriver initDriver() {
        String driverType = PropertyWorker.getProperty();

        switch (driverType) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();
                break;
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}
