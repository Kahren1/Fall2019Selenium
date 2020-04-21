package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTests {

    @FindBy(id="prepended input")
    private WebElement username;
    //what is the locator type? id, what is the value? - inside double quotes

    //public WebElemeng username
    @FindBy(id="prepended input2")
    private WebElement password;

    @FindBy(id="_submit")
    private WebElement login;

    @FindBy(linkText="Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;


    public LoginTests(){
        //conntecting our webdriver, page class and PageFactory
        // pagefactory - used to use findby annotations
        //pageFactory - helps to find elements easier
        //we say this (LoginPage.class) - we show where @Findby's will be used

        //required to put into the constructor of every page class
        //Driver.getDriver() - what is your driver?
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }
    /**Method to login with specific values
    @param usernameValue
    @param passwordValue
     */
    public void login(String usernameValue, String passwordValue){
        username.sendKeys((usernameValue));
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**Method to login, version #2
     * Login as default user
     * Credential will be retrieved from configuration.properties file
     */

    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
}
