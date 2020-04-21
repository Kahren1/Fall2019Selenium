package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VehiclePageTests {
    private WebDriver driver;

    private String URL = "https://qa2.vytrack.com/user/login";
    //credentials for store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    //xpath allows to specify multiple search criteria. In this locator, we are looking for element
    //that has class name and contains text. We use contains due to spaces.
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    //private By subtitleBy = By.xpath ();
//@Test
//public void verifyPageNumber(){
//    driver.findElement(usernameBy).sendKeys(username);
//    driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
//    BrowserUtils.wait(5);
//

//
//    String expected = "1";
//    String actual= driver.findElement(pageNumberby).getAttribute("value");
//            assertEquals(actual, expected, "page not matching");
//}

    //need to navigate to Fleet --> Vehicles, then verify the page subtitle
    @Test(description = "verify that page subtitle is equal to All Cars")
    public void verifyPageSubTitle() {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

        //driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interactions

        //move (moving mouse) to element instead of click
        //the dropdown gets highlighted
        // a lot of things is based on hover over actions
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        BrowserUtils.wait(5);
        //click on vehicles
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);

//        WebElement subTitleElement = driver.findElement(subtitleBy);
//        System.out.println(subTitleElement.getText());

        String expected = "All Cars";
        String actual = driver.getTitle();

        assertEquals(actual, expected, "page subtitle is not equal to All Cars");
        //use assertions for validation

    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        //if webdriver object is alive

        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy driver object
            driver = null;
        }
    }


}
