package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class SignInPage extends WebPage{
    private WebDriver driver = null;
    private final String SIGN_PAGE_URL_IDENTIFIER = "?signonForm=";
    private final String PAGE_URL = "http://52.210.246.113:8080/jpetstore/actions/Account.action?signonForm=";

    @FindBy(name = "username")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement userPassword;

    @FindBy(name = "signon")
    private WebElement submitLgnBtn;

    @FindBy(linkText = "Register Now!")
    private WebElement registerNowLink;

    public SignInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!driver.getCurrentUrl().contains(this.SIGN_PAGE_URL_IDENTIFIER)) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the login page");
        }

        PageFactory.initElements(driver, this);
    }

    private SignInPage typeUserName(String userID){
        userName.sendKeys(userID);
        return this;
    }

    private SignInPage typeUserPassword(String password){
        userPassword.clear();
        userPassword.sendKeys(password);
        return this;
    }

    private CatalogPage submitLoginAction(){
        submitLgnBtn.click();
        return new CatalogPage(driver);
    }

    public CatalogPage loginAs(String userID, String password) {
        typeUserName(userID);
        typeUserPassword(password);
        return submitLoginAction();
    }

    public SignUpPage navigateSignUpPage() {
        registerNowLink.click();
        return new SignUpPage(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }
}
