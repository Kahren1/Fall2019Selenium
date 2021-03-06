package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp_Tables {
    //go to the right page
    //click on "Last name" column name
    //verify that table is sorted by last name in alphabetic order


    @Test
    public void test() {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column (td[1])
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));

        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a next string
            String nextValue = column.get(i + 1).getText();
            System.out.println(value.compareTo(nextValue));

            //difference should be negative
            // "a".compareTo("b)=-1;
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
        driver.quit();
    }
}


