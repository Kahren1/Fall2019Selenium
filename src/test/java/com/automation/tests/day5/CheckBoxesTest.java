package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.SeleniumServerStandaloneManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        //verify that the 1st checkbox is not selected, but the 2nd isSelected
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        if(!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected())
            System.out.println("test passed");
        else
            System.out.println("test failed");

        BrowserUtils.wait(2);


     driver.quit();

    }
}
