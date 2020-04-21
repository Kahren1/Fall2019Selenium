package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            //if there is a text = print it
            if (!var.isEmpty()) {
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }
    }

    /**Giver user is on amazon.com page
     * When user enters "java" as a search item
     * When user clicks on the search button
     * and user clcks on the first search item
     * and user verifies that title of the search item
     * contains "Java"
     */
    @Test(description="Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("http://amazon.com");
        //there is a chance an item is not visible
        //we need to maximize window before clicking on it
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(5);
//find all links inside h2 elements, because h2 elements are not clickable by themselves
        List<WebElement> searchItems = driver.findElements(By.xpath("//h2//a"));

        for(WebElement searchItem:searchItems){
            if(searchItem.getText().length()!=0)
            System.out.println("Title: "+searchItem.getText());
        }



        //click on the firt item
        searchItems.get(0).click();
        BrowserUtils.wait(5);

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);
        Assert.assertTrue(productTitleString.contains("Java"));


    }

    @BeforeMethod
    public void setup() {
        //set up webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


}
