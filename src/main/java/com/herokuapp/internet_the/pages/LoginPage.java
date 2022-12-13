package com.herokuapp.internet_the.pages;

import com.herokuapp.internet_the.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'example']/h2")
    WebElement secureAreaText;


    public String verifyTheLoggedInText(){
        Reporter.log("Verify the Login text message" + secureAreaText.toString());
        return getTextFromElement(secureAreaText);
    }
}
