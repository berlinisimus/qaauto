package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class MyAccountPage extends WebPage{
    private final WebDriver driver;
    public static final String MyAccountPageURL = "http://localhost:8080/jpetstore/actions/Account.action?editAccountForm=";

    @FindBy(xpath = "//*[@id=\"Catalog\"]/form/table[1]/tbody/tr[1]/td[2]")
    public WebElement userID;

    @FindBy(name = "account.email")
    public WebElement userEmail;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!MyAccountPage.MyAccountPageURL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the my account page");
        }

        PageFactory.initElements(driver, this);
    }
}
