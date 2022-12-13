package com.herokuapp.internet_the.pages;

import com.aventstack.extentreports.model.Report;
import com.herokuapp.internet_the.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(id = "username")
    WebElement usernameField;

    @CacheLookup
    @FindBy(id = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[@class = 'radius']/i[@class =  'fa fa-2x fa-sign-in' ]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'flash']")
    WebElement invalidCredentialsErrorMessage;


    public void enterUsername(String username) {
        Reporter.log("Enter username "+ username + " in the username field" + usernameField.toString());
        sendTextToElement(usernameField, username);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password "+ password + " in the password field" + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button" + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String verifyInvalidCredentialsErrorMessage() {
        Reporter.log("Verify the invalid Credentials Error message" + invalidCredentialsErrorMessage.toString());
        return getTextFromElement(invalidCredentialsErrorMessage);
    }

}
