package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //to start Selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        //Selenium requires webdriver setup
        WebDriverManager.chromedriver().setup();
        //need chromedriver object that will send commands to the webdriver
        //need this object to open a website, maximize window, etc
        //get(), close(), getTitle(), quit()
        WebDriver driver = new ChromeDriver();
        //in Selenium, everything starts with WebDriver interface
        //CrhomeDriver extends RemoteWebDriver and implements WebDriver
        driver.get("http://google.com");//to open a website

        driver.manage().window().maximize();
        Thread.sleep(3000);//for demo, wait for 3 secs
        //method that returns the page title
        //you can see it as tab name, in the browser
        String title = driver.getTitle();//returns <title> some title </title> text
        String expectedTitle="Google";
        System.out.println("expected title is: "+ expectedTitle);
        System.out.println("actual title is: "+title);

        if(expectedTitle.equals(title))
            System.out.println("test passed!");
        else
            System.out.println("test failed");

        driver.navigate().to("http://amazon.com");
        Thread.sleep(3000);

        if(driver.getTitle().toLowerCase().contains("amazon"))
        System.out.println("test passed");
        else
        System.out.println("test failed");

        //return to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(), "Google");

        driver.navigate().refresh();
        Thread.sleep(3000);
        System.out.println("current url is: "+driver.getCurrentUrl());

        driver.close();//to close browser - it can't close by itself
        //navigate().to()
        //navigate().forward()
        //navigate().back()
        //navigate().refresh()
        //driver.get()

        driver.get("http://amazon.com");
        Thread.sleep(1000);
        driver.get("http://amazon.com");
        Thread.sleep(1000);
        driver.quit();


    }//end main
    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2))
            System.out.println("test passed");
        else
            System.out.println("test failed");
    }
}
