package com.qa.auto;

import com.qa.auto.helpers.PropertyWorker;
import com.qa.auto.pages.*;
import com.qa.auto.wrapper_factories.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by alexey on 9/3/17.
 */
public class UserSignInTest {
    private WebDriver driver = null;

    @BeforeClass
    public void setUp(){
        driver =  BrowserFactory.initDriver("chrome");
    }

    @Test
    public void verifyUserSignInWorks() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.open(WelcomePage.APP_INDEX_PAGE_URL);

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
        BrowserFactory.closeDriver();
    }
}
