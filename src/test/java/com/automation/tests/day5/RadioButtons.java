package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(2);
        //<input type = "radio"
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        /**
         * <input type = "radio" id="red" name="color">
         *     radiobutton.getAttribute("id") returns red
         *     radiobutton.getAttribute("type") returns radio
         *     radiobutton.get.attribute("name") returns color
         */

        //.isDisplayed() -returns true, if element is visible.
        // applies to any kind of WebElement, not just radiobuttons




        for(WebElement radioButton: radioButtons){
            String id = radioButton.getAttribute("id");
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected: " +isSelected);
            //to check if button can be clicked
            //returns true if you can click on that button
            if(radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("clicked on " + id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("button is disabled, not clicked at "+id);
            }
        }
        driver.quit();
    }
}
