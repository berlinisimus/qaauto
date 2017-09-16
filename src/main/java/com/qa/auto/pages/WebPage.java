package com.qa.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by alexey on 9/3/17.
 */
public abstract class WebPage {
    private WebDriver driver = null;
    private static String PAGE_URL = null;

    @FindBy(linkText = "Sign In")
    public WebElement signInBtn;

    @FindBy(linkText = "My Account")
    public WebElement myAccountLink;

    WebPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectMenuItem(String item) {
        driver.findElement(By.linkText(item)).click();
    }

    public void open(String pageUrl) {
        driver.get(pageUrl);
    }

    public abstract String getPageUrl();
}
