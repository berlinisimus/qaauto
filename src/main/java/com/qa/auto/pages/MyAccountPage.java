package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class MyAccountPage extends WebPage{
    private WebDriver driver = null;
    private final String PAGE_URL = "http://52.210.246.113:8080/jpetstore/actions/Account.action?editAccountForm=";

    @FindBy(xpath = "//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[1]/td[2]")
    public WebElement userID;

    @FindBy(name = "account.email")
    public WebElement userEmail;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!this.PAGE_URL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the my account page");
        }
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }
}
