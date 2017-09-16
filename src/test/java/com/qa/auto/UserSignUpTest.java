package com.qa.auto;



import com.qa.auto.helpers.PropertyWorker;
import com.qa.auto.pages.CatalogPage;
import com.qa.auto.pages.SignInPage;
import com.qa.auto.pages.SignUpPage;
import com.qa.auto.pages.WelcomePage;
import com.qa.auto.wrapper_factories.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserSignUpTest {
    private WebDriver driver = null;

    @BeforeClass
    public void setUp() throws InterruptedException {
        String driverType = PropertyWorker.retrieveProperty();
        driver = BrowserFactory.initDriver("chrome");
    }

    @Test
    public void verifyUserSignUpWorks() {
        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.open(welcomePage.getPageUrl());

        CatalogPage catalogPage =  welcomePage.enterStore();
        catalogPage.selectMenuItem("Sign In");

        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = signInPage.navigateSignUpPage();
        signUpPage.signUpNewUser();
        Assert.assertEquals(catalogPage.getPageUrl(),driver.getCurrentUrl());
    }

    @AfterClass
    public void quitDriver(){
        BrowserFactory.closeDriver();
    }
}
