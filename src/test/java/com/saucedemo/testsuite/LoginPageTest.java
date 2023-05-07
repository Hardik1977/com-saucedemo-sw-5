package com.saucedemo.testsuite;

import com.saucedemo.basetest.BaseTest;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    InventoryPage inventoryPage;
    LoginPage loginPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        inventoryPage=new InventoryPage();
        loginPage=new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedText = "Products";
        String actualText = inventoryPage.getProductText();
        Assert.assertEquals(actualText, expectedText, "Expected Text does not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        int expectedNumberOfProducts=6;
        int actualNumberOfProducts=inventoryPage.findActualNumberOfProducts();
        Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts, "Number of products are not 6");
    }
}
