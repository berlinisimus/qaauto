package com.qa.auto;

import com.qa.auto.data.User;
import com.qa.auto.drivers.Driver;
import com.qa.auto.pages.CatalogPage;
import com.qa.auto.pages.MyAccountPage;
import com.qa.auto.pages.SignInPage;
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
    public void setUp(){
        driver =  Driver.initDriver();
        driver.get(SignInPage.signInPageURL);
    }

    @Test
    public void verifyUserSignInWorks() {
        SignInPage signInPage =  new SignInPage(driver);
        CatalogPage catalogPage = signInPage.loginAs(User.userID,User.userPass);

        Assert.assertTrue(catalogPage.myAccountLink.isDisplayed());

        catalogPage.selectMenuItem("My Account");
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        Assert.assertEquals(myAccountPage.userID.getText(),User.userID);
        Assert.assertEquals(myAccountPage.userEmail.getAttribute("value"),User.userEmail);
    }

    @AfterClass
    public void quitDriver(){
        Driver.closeDriver();
    }
}
