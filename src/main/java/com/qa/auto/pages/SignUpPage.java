package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexey on 9/3/17.
 */
public class SignUpPage extends WebPage {
    public static final String signUpPageURL = "http://localhost:8080/jpetstore/actions/Account.action?newAccountForm=";

    @FindBy(name = "username")
    public static WebElement userID;

    @FindBy(name = "newAccount")
    public static WebElement submitSignUpBtn;

    @FindBy(name = "password")
    public static WebElement userPassword;

    @FindBy(name = "repeatedPassword")
    public static WebElement userRepeatedPassword;

    @FindBy(name = "account.lastName")
    public static WebElement accountLastName;

    @FindBy(name = "account.firstName")
    public static WebElement accountFirstName;

    @FindBy(name = "account.email")
    public static WebElement accountEmail;

    @FindBy(name = "account.phone")
    public static WebElement accountPhone;

    @FindBy(name = "account.address1")
    public static WebElement accountAddress1;

    @FindBy(name = "account.city")
    public static WebElement accountCity;

    @FindBy(name = "account.state")
    public static WebElement accountState;

    @FindBy(name = "account.zip")
    public static WebElement accountZip;

    @FindBy(name = "account.country")
    public static WebElement accountCountry;

    SignUpPage(WebDriver driver) {
        super(driver);
    }
}
