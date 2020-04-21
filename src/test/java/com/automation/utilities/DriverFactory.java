package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    /**
     * Homework - to improve this method
     * This method return WebDriver object based on browser type
     * If you want to use chrome browser, just provide chrome as a parameter
     *
     * @param browserName
     * @return WebDriver object
     */
    //getting a webDriver object
    public static WebDriver createDriver(String browserName){
        if(browserName.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

    }
}
