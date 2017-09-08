package com.qa.auto;

import com.qa.auto.data.User;
import com.qa.auto.drivers.Driver;
import com.qa.auto.pages.SignInPage;
import com.qa.auto.pages.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by alexey on 9/3/17.
 */
public class UserSignInTest {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver =  Driver.initDriver();
        PageFactory.initElements(driver,SignInPage.class);
        driver.get(SignInPage.signInPageURL);
    }

    @Test
    public void verifyUserSignInWorks() {
        SignInPage.userName.sendKeys(User.userID);
        SignInPage.userPassword.clear();
        SignInPage.userPassword.sendKeys(User.userPass);
        SignInPage.submitLgnBtn.click();

        Assert.assertTrue(WebPage.myAccountBtn.isDisplayed());
        WebPage.myAccountBtn.click();
        Assert.assertEquals(WebPage.userID.getText(),User.userID);
        Assert.assertEquals(WebPage.userEmail.getAttribute("value"),User.userEmail);
    }

    @AfterClass
    public void quitDriver(){
        Driver.closeDriver();
    }
}
