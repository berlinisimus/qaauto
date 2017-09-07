package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexey on 9/3/17.
 */
public class SignInPage extends WebPage{
    public static final String signInPageURL = "http://localhost:8080/jpetstore/actions/Account.action?signonForm=";

    @FindBy(name = "username")
    public static WebElement userName;

    @FindBy(name = "password")
    public static WebElement userPassword;

    @FindBy(name = "signon")
    public static WebElement submitLgnBtn;
}
