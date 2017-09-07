package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by alexey on 9/3/17.
 */
public class WebPage {

    @FindBy(linkText = "Sign In")
    public static WebElement signInBtn;

    @FindBy(linkText = "My Account")
    public static WebElement myAccountBtn;

    @FindBy(name = "account.email")
    public static WebElement userEmail;

    @FindBy(name = "username")
    public static WebElement userName;
}
