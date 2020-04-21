package com.automation.tests.day4;

import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class VerifyThatElementIsGone {
    /**
     * How to verify that the element doesn't exist anymore
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(3000);

        driver.findElement(By.id("disappearing" +
                "_button")).submit();
        Thread.sleep(2000);
//returns a list of Webelements
        if(driver.findElements(By.id("disappearing button")).size()==0) {
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        driver.quit();

    }
}
