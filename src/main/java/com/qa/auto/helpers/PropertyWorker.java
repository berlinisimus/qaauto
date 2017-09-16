package com.qa.auto.helpers;

/**
 * Created by alexey on 9/9/17.
 */
public class PropertyWorker {
    private static String browserTypeProperty = null;

    public static String retrieveProperty() {
        browserTypeProperty = System.getProperty("browser");

        if (browserTypeProperty != null) {
            return browserTypeProperty;
        }else
            return browserTypeProperty="chrome";
    }
}
