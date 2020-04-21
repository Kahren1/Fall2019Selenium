package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(2);
 //<input type="radio" id="black" name="color">
        WebElement blackButton = driver.findElement(By.id("black"));
        if(blackButton.isDisplayed()&&blackButton.isEnabled()){
            blackButton.click();
            System.out.println("clicked on black button");
        }else{
            System.out.println("button was not displayed or enabled, failed to click");
        }


//how do we verify that button clicked:
        if(blackButton.isSelected())
            System.out.println("test passed");
        else
            System.out.println("test failed");
        driver.quit();

    }
}
