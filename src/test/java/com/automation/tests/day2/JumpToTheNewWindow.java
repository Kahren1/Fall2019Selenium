package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);
        //every window has an id called window handle
        //based on window handle we can switch between windows

        String windowHandle = driver.getWindowHandle();
        System.out.println(windowHandle);
        //used Set because it does not allow duplicates
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles);
        System.out.println("before switch: "+ driver.getCurrentUrl());

        for(String windowID: windowHandles) {
            if (!windowID.equals(windowHandle))
                driver.switchTo().window(windowID);
        }
Thread.sleep(3000);
        //since we have all windows and we know the id of the original window
        //we can say switch to something w different windowHandle
        System.out.println("after switch: "+ driver.getCurrentUrl());
        driver.quit();


    }
}
