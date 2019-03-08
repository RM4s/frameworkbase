package com.everis.automationtraining.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserDriver {


    private static WebDriver mDriver;

    public static WebDriver getCurrentDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");

        if (mDriver == null) {
            initDriver();
        } else if (mDriver instanceof ChromeDriver && ((ChromeDriver) mDriver).getSessionId() == null) {
            initDriver();
        }

        return mDriver;
    }

    private static void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        mDriver = new ChromeDriver(chromeOptions);
    }

    public static void closeBrowser() {
        getCurrentDriver().quit();
    }
}