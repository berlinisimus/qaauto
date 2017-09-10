package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/9/17.
 */
public class WelcomePage extends WebPage {
    private static final String welcomePageURL = "http://localhost:8080/jpetstore/";
    private final WebDriver driver;

    @FindBy(linkText = "Enter the Store")
    private WebElement enterStoreLink;

    public WelcomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!WelcomePage.welcomePageURL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the welcome page");
        }

        PageFactory.initElements(driver, this);
    }

    public CatalogPage enterStore() {
        enterStoreLink.click();
        return new CatalogPage(driver);
    }
}
