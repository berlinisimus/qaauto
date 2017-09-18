package com.qa.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alexey on 9/7/17.
 */
public class SearchPage extends WebPage {
    private WebDriver driver = null;

    @FindBy(name = "keyword")
    private WebElement keyWordField;

    @FindBy(name = "searchProducts")
    private WebElement searchProductsBtn;

    //TODO check all locators and me private access to them via creating getters or 'verify' mehthods
    @FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]/b/a/font")
    public WebElement ProductIdElem;

    public String ProuductIdStr = "FL-DLH-02";

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public String getPageUrl() {
        return null;
    }


    public SearchPage searchForProductName(String persian) {
        typeSearchQuery(persian);
        return submitSearchAction();
    }

    private SearchPage submitSearchAction() {
        searchProductsBtn.click();
        return new SearchPage(driver);
    }

    private SearchPage typeSearchQuery(String persian) {
        keyWordField.sendKeys(persian);
        return this;
    }


}
