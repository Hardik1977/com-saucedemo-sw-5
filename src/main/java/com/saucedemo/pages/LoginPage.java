package com.saucedemo.pages;

import com.saucedemo.utilities.Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utilities {

    @CacheLookup
    @FindBy(id ="user-name")
    WebElement userNameField;
    @CacheLookup
    @FindBy( id="password" )
    WebElement passwordField;
    @CacheLookup
    @FindBy( id="login-button" )
    WebElement loginButton;

    public void enterUserName(String userName){
        Reporter.log("Enter Username " + userName + " to email field " + userName.toString());
        sendTextToElement(userNameField,userName);
    }

    public void enterPassword(String password){
        Reporter.log("Enter Password " + password  + " to email field " + password.toString());
        sendTextToElement(passwordField,password);
    }

    public void clickOnLoginButton(){
        Reporter.log("Clicking on Login Button " + loginButton.toString());
        clickOnElement(loginButton);
    }

}
