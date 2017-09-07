package com.qa.auto;

import com.qa.auto.data.User;
import com.qa.auto.drivers.Driver;
import com.qa.auto.pages.CatalogPage;
import com.qa.auto.pages.SearchPage;
import com.qa.auto.pages.SignInPage;
import com.qa.auto.pages.WebPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by alexey on 9/7/17.
 */
public class SearchTest {
    private static WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver =  Driver.initDriver();
        PageFactory.initElements(driver,SearchPage.class);
        PageFactory.initElements(driver,SignInPage.class);
        driver.get(CatalogPage.CatalogPageURL);
    }

    @Test
    public void verifySearchAsUnauthorizedUserWorks() {
        //add check for checking presenct of sign in button
        SearchPage.keyWordField.sendKeys("Persian");
        SearchPage.searchProductsBtn.click();
        Assert.assertEquals(SearchPage.ProductIdElem.getText(),SearchPage.ProuductIdStr);
    }

    @Test
    public void verifySearchAsAuthorizedUserWorks() {
        driver.get(SignInPage.signInPageURL);

        SignInPage.userName.sendKeys(User.userName);
        SignInPage.userPassword.sendKeys(User.userPass);
        SignInPage.submitLgnBtn.click();

        SearchPage.keyWordField.sendKeys("Persian");
        SearchPage.searchProductsBtn.click();
        Assert.assertEquals(SearchPage.ProductIdElem.getText(),SearchPage.ProuductIdStr);
    }

    @AfterMethod
    public void quitDriver(){
        Driver.closeDriver();
    }
}
