package com.qa.auto.pages;

import com.qa.auto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/3/17.
 */
public class SignUpPage extends WebPage {
    public final String PAGE_URL = "http://52.210.246.113:8080/jpetstore/actions/Account.action?newAccountForm=";
    private WebDriver driver = null;

    @FindBy(name = "username")
    public WebElement userName;

    @FindBy(name = "newAccount")
    public WebElement submitSignUpBtn;

    @FindBy(name = "password")
    public WebElement userPassword;

    @FindBy(name = "repeatedPassword")
    public WebElement userRepeatedPassword;

    @FindBy(name = "account.lastName")
    public WebElement accountLastName;

    @FindBy(name = "account.firstName")
    public WebElement accountFirstName;

    @FindBy(name = "account.email")
    public WebElement accountEmail;

    @FindBy(name = "account.phone")
    public WebElement accountPhone;

    @FindBy(name = "account.address1")
    public WebElement accountAddress1;

    @FindBy(name = "account.city")
    public WebElement accountCity;

    @FindBy(name = "account.state")
    public WebElement accountState;

    @FindBy(name = "account.zip")
    public WebElement accountZip;

    @FindBy(name = "account.country")
    public WebElement accountCountry;

    public SignUpPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        if (!this.PAGE_URL.equals(driver.getCurrentUrl())) {
            // Alternatively, we could navigate to the login page, perhaps logging out first
            throw new IllegalStateException("This is not the sign up page");
        }

        PageFactory.initElements(driver, this);
    }

    public CatalogPage signUpNewUser() {
        typeUserName(User.userID);
        typeUserPassword(User.userPass);
        typeUserRepeatPassword(User.userPass);
        typeUserFirstName(User.userFirstName);
        typeUserLastName(User.userLastName);
        typeUserEmail(User.userEmail);
        typeUserPhone(User.userPhoneNumb);
        typeUserAddress1(User.userAddress1);
        typeUserCity(User.userCity);
        typeUserState(User.userState);
        typeUserZip(User.userZip);
        typeUserCountry(User.userCountry);
        return submitSignUpAction();
    }

    private SignUpPage typeUserCountry(String userCountry) {
        accountCountry.sendKeys(userCountry);
        return this;
    }

    private SignUpPage typeUserZip(String userZip) {
        accountZip.sendKeys(userZip);
        return this;
    }

    private SignUpPage typeUserState(String userState) {
        accountState.sendKeys(userState);
        return this;
    }

    private SignUpPage typeUserCity(String userCity) {
        accountCity.sendKeys(userCity);
        return this;
    }

    private SignUpPage typeUserAddress1(String userAddress1) {
        accountAddress1.sendKeys(userAddress1);
        return this;
    }

    private SignUpPage typeUserPhone(String userPhoneNumb) {
        accountPhone.sendKeys(userPhoneNumb);
        return this;
    }

    private SignUpPage typeUserEmail(String userEmail) {
        accountEmail.sendKeys(userEmail);
        return this;
    }

    private SignUpPage typeUserLastName(String userLastName) {
        accountLastName.sendKeys(userLastName);
        return this;
    }

    private SignUpPage typeUserFirstName(String userFirstName) {
        accountFirstName.sendKeys(userFirstName);
        return this;
    }

    private SignUpPage typeUserRepeatPassword(String userPass) {
        userRepeatedPassword.sendKeys(userPass);
        return this;
    }

    private SignUpPage typeUserPassword(String userPass) {
        userPassword.sendKeys(userPass);
        return this;
    }

    private SignUpPage typeUserName(String userID) {
        userName.sendKeys(userID);
        return this;
    }

    private CatalogPage submitSignUpAction() {
        submitSignUpBtn.click();
        return new CatalogPage(driver);
    }

    @Override
    public String getPageUrl() {
        return PAGE_URL;
    }
}
