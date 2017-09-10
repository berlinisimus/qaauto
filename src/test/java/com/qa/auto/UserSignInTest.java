package com.qa.auto;

import com.qa.auto.pages.*;
import org.openqa.selenium.WebDriver;
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
    public void setUp(){
        driver =  Driver.initDriver();
    }

    @Test
    public void verifyUserSignInWorks() {
        WelcomePage welcomePage = new WelcomePage(driver);
        CatalogPage catalogPage = welcomePage.enterStore();
        catalogPage.selectMenuItem("Sign In");

        SignInPage signInPage = new SignInPage(driver);
        catalogPage = signInPage.loginAs(User.userID, User.userPass);

        Assert.assertTrue(catalogPage.myAccountLink.isDisplayed());

        catalogPage.selectMenuItem("My Account");
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertEquals(myAccountPage.userID.getText(), User.userID);
        Assert.assertEquals(myAccountPage.userEmail.getAttribute("value"), User.userEmail);
    }

    @AfterClass
    public void quitDriver(){
        Driver.closeDriver();
    }
}
