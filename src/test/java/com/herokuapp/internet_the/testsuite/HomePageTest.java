package com.herokuapp.internet_the.testsuite;

import com.herokuapp.internet_the.pages.HomePage;
import com.herokuapp.internet_the.pages.LoginPage;
import com.herokuapp.internet_the.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        homePage.enterUsername("tomsmith");
        homePage.enterPassword("SuperSecretPassword!");
        homePage.clickOnLoginButton();
        Assert.assertTrue(loginPage.verifyTheLoggedInText().contains("Secure Area"),"Not logged in");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyTheUsernameErrorMessage(){
        homePage.enterUsername("tomsmith1");
        homePage.enterPassword("SuperSecretPassword!");
        homePage.clickOnLoginButton();
        Assert.assertTrue(homePage.verifyInvalidCredentialsErrorMessage().contains("Your username is invalid!"),"Username error message is not displayed");
    }

    @Test(groups = "regression")
    public void verifyThePasswordErrorMessage(){
        homePage.enterUsername("tomsmith");
        homePage.enterPassword("SuperSecretPassword");
        homePage.clickOnLoginButton();
        Assert.assertTrue(homePage.verifyInvalidCredentialsErrorMessage().contains("Your password is invalid!"),"Password error message is not displayed");
    }
}
