package com.automation.tests.vytrack.login;

import com.automation.pages.LoginTests;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTests extends AbstractTestBase {
    /*Login and verify that page title is a "Dashboard"
     */
    @Test
    public void verifyPageTitle(){
        LoginTests loginPage = new LoginTests();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }
}
