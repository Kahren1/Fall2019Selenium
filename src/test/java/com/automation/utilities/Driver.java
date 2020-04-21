package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //static - same for everyone
    private static WebDriver driver;
    //so no one can create an object of the Driver class
    //everyone should call the static getter method instead
    private Driver(){}

    public synchronized static WebDriver getDriver(){
        if (driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }

        }
        return driver;
    }
    public static void closeDriver(){
        if(driver!=null){
        driver.quit();
        driver=null;
        }
    }
}
