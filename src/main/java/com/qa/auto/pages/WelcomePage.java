package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/9/17.
 */
public class WelcomePage extends WebPage {
    private final String PAGE_URL = "http://52.210.246.113:8080/jpetstore/";
    private WebDriver driver = null;

    @FindBy(linkText = "Enter the Store")
    private WebElement enterStoreLink;

    public WelcomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CatalogPage enterStore() {
        enterStoreLink.click();
        return new CatalogPage(driver);
    }

    public String getPageUrl() {
        return PAGE_URL;
    }

}
