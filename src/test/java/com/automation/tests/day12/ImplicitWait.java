package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        //don't use implicit and explicit wait together
        //here, will be waiting for ANY element up to 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //explicit wait - better wait to wait than implicit wait
        //explicit - exact condition and exact element
        //implicit wait - only one condition(presensce of element in the DOM)
        //it applies to every findElement() method invocation

        //How to implement Explicit wait?
        //for this, we use WebDriverWait class
       //WebDriverWait wait = new WebDriverWait(driver, time in seconds);
        //and you realize the purpose of constructor
        //then, we have ExpectedConditions class that provides wait conditions.
        //ExpectedConditions provides a set of
        // predefined conditions to wait for before proceeding further
        //common explicit wait conditions

        //elementToBeClickable()
        //visibilityOf()
        //presenceOfLocatedElement()
        //titleContains()

        //Example
        //WebElement buttonElement = driver.findElement(By.xpath("//button[6]"))
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.eleementToBeClickable(buttonElement));

        //this wait means: wait for up to 10 sec, until button beomes eligible to click
        //WebDriverWait has a default polling time - 500 milliseconds, checking if condition is true

        //Explicit vs. implicit wait - individual vs. general approach
        //implicit wait - we use only once
        //explicit wait - as many times as needed

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

        @Test
    public void waitTest(){
driver.findElement(By.tagName("Button")).click();
            BrowserUtils.wait(10);
        }
}
