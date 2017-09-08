package com.qa.auto;



import com.qa.auto.data.User;
import com.qa.auto.drivers.Driver;
import com.qa.auto.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserSignUpTest {
    private static WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        driver =  Driver.initDriver();
        PageFactory.initElements(driver, SignUpPage.class);
        driver.get(SignUpPage.signUpPageURL);
    }

    @Test
    public void verifyUserSignUpWorks() {
        SignUpPage.userID.sendKeys(User.userID);
        SignUpPage.userPassword.sendKeys(User.userPass);
        SignUpPage.userRepeatedPassword.sendKeys(User.userPass);
        SignUpPage.accountFirstName.sendKeys("alex");
        SignUpPage.accountLastName.sendKeys("alexey");
        SignUpPage.accountEmail.sendKeys(User.userEmail);
        SignUpPage.accountPhone.sendKeys("00000");
        SignUpPage.accountAddress1.sendKeys("address");
        SignUpPage.accountCity.sendKeys("lviv");
        SignUpPage.accountState.sendKeys("-");
        SignUpPage.accountZip.sendKeys("000");
        SignUpPage.accountCountry.sendKeys("ukraine");
        SignUpPage.submitSignUpBtn.click();
    }

    @AfterClass
    public void quitDriver(){
        Driver.closeDriver();
    }
}
