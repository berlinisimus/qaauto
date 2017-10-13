package com.qa.auto;

import com.qa.auto.helpers.PropertyWorker;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by alexey on 9/22/17.
 */
public class SeleniumGridRunner {
    private static WebDriver driver = null;

    @BeforeClass
    public static void initDriver() {

        DesiredCapabilities capabilities = new DesiredCapabilities().chrome();

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.get("https://google.com.ua");

    }

    @Test
    public void closeDriver(){
        if(driver != null)
            driver.quit();
    }
}
