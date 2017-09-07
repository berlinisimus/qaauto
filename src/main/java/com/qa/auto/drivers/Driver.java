package com.qa.auto.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexey on 9/3/17.
 */
public class Driver {
    private static WebDriver driver;

    public static WebDriver initDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://localhost:8080/jpetstore");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("JPetStore Demo"));

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
    }
}
