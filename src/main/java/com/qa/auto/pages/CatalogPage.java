package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class CatalogPage extends WebPage{
    private WebDriver driver = null;
    private final String PAGE_URL = "http://52.210.246.113:8080/jpetstore/actions/Catalog.action";

    CatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!this.PAGE_URL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the catalog page");
        }
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return this.PAGE_URL;
    }

}
