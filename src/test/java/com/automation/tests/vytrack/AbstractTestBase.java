package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.interactions.Actions;

import javax.security.auth.login.Configuration;

public abstract class AbstractTestBase {
    //will be visible in the subclass anywhere

    //abstract class used as a base for all test classses
    //we made it abstract - we want it to be extended
    //it's a bluesprint for all test classes

    protected WebDriverWait wait;
    protected Actions actions;

    @BeforeMethod
    public void setup(){
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        //used for drag and drop, hover over, so object needs to be created first
        actions = new Actions(Driver.getDriver());

    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();;
    }
}
