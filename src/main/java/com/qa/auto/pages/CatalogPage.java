package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class CatalogPage extends WebPage{
    private final WebDriver driver;
    public static final String catalogPageURL = "http://localhost:8080/jpetstore/actions/Catalog.action";

    public CatalogPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!CatalogPage.catalogPageURL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the catalog page");
        }
        PageFactory.initElements(driver, this);
    }

}
