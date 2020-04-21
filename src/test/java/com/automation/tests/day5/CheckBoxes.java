package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
    driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        //<input type="checkbox" checked=""
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        for(int i=0;i<checkBoxes.size();i++) {
            checkBoxes.get(i).click();
            BrowserUtils.wait(1);
        }




    driver.quit();

    }
}
