package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSelenimScript {
    public static void main(String[] args) {
        //setup chromedriver
        //WebDriverManager is used to easily download webdrivers. Browser driver aka webdriver connects
        //java code to browser
        //Webdriver (browser driver) can be set up manually without WebDriverManager,
        //but it is just easier to set it up with Webdrivermanager
        WebDriverManager.chromedriver().setup();
        //chreate chromedriver object
        ChromeDriver driver = new ChromeDriver();
        //open some website
        driver.get("http://google.com");
    }
}
