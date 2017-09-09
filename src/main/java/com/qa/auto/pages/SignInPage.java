package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class SignInPage extends WebPage{
    private final WebDriver driver;
    public static final String signInPageURL = "http://localhost:8080/jpetstore/actions/Account.action?signonForm=";

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement userPassword;

    @FindBy(name = "signon")
    private WebElement submitLgnBtn;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!SignInPage.signInPageURL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }

        PageFactory.initElements(driver, this);
    }

    public SignInPage typeUserName(String userID){
        userName.sendKeys(userID);
        return this;
    }

    public SignInPage typeUserPassword(String password){
        userPassword.clear();
        userPassword.sendKeys(password);
        return this;
    }

    public CatalogPage submitLoginAction(){
        submitLgnBtn.click();
        return new CatalogPage(driver);
    }

    public CatalogPage loginAs(String userID, String password) {
        typeUserName(userID);
        typeUserPassword(password);
        return submitLoginAction();
    }
}
