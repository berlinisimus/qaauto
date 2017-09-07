package com.qa.auto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by alexey on 9/7/17.
 */
public class SearchPage {

    @FindBy(name = "keyword")
    public static WebElement keyWordField;

    @FindBy(name = "searchProducts")
    public static WebElement searchProductsBtn;

    @FindBy(xpath = "//*[@id=\"Catalog\"]/table/tbody/tr[2]/td[2]/b/a/font")
    public static WebElement ProductIdElem;

    public static String ProuductIdStr = "FL-DLH-02";
}
