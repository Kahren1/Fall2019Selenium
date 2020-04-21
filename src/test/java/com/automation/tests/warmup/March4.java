package com.automation.tests.warmup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class March4 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79.0").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://ebay.com");
        WebElement input = driver.findElement(By.id("gh-ac"));
        input.sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println("results of search: "+ searchResults.getText());
        Thread.sleep(2000);
        driver.quit();


    }
}
