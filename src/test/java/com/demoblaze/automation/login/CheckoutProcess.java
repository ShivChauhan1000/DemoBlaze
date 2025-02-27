package com.demoblaze.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.ServerSocket;

public class CheckoutProcess extends BaseClass{
@Test(priority = 10)
    public void completePurchaseTest(){

    WebElement loginButton = driver.findElement(By.id("login2"));
    loginButton.click();
    WebElement usernameField = driver.findElement(By.id("loginusername"));
    WebElement passwordField = driver.findElement(By.id("loginpassword"));
    usernameField.sendKeys("Admin.user");
    passwordField.sendKeys("Adminuser@1234");
    WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
    clickonLoginbutton.click();
    waitForSomeTime();
    WebElement element = driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].scrollIntoView();",element );
    js.executeScript("window.scrollBy(0,250)", "");
    WebElement selectedProduct = driver.findElement(By.xpath("//*[text()='HTC One M9']"));
    selectedProduct.click();
    WebElement addCartButton = driver.findElement(By.xpath("//a[text()='Add to cart']"));
    addCartButton.click();
    driver.navigate().back();

    //Add a product to the cart.
    WebElement cartButton = driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[4]/a"));
    cartButton.click();
    waitForSomeTime();

    //Click "Place Order".
    WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
    placeOrderButton.click();

    //Enter billing details.
    WebElement formName = driver.findElement(By.id("name"));
    WebElement formCountry = driver.findElement(By.id("country"));
    WebElement formCity = driver.findElement(By.id("city"));
    WebElement formCreditCard = driver.findElement(By.id("card"));
    WebElement formMonth = driver.findElement(By.id("month"));
    WebElement formYear = driver.findElement(By.id("year"));
    WebElement purchaseButton = driver.findElement(By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]"));

    formName.sendKeys("Shiv");
    formCountry.sendKeys("India");
    formCity.sendKeys("Lucknow");
    formCreditCard.sendKeys("234567890989876");
    formMonth.sendKeys("March");
    formYear.sendKeys("2023");

    //Confirm the purchase.
    purchaseButton.click();

    //Expected Result: A confirmation message should appear.
    String expectedMessage = "Thank you for your purchase!";
    String actualMessage = driver.getPageSource();
    WebElement thankYouButton = driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));
    Assert.assertTrue(thankYouButton.isDisplayed(),"Thank you button is not displayed.");
    Assert.assertTrue(actualMessage.contains(expectedMessage));
    System.out.println("Thank You Message Displayed : TC Passed.");
    }

@Test(priority = 11, groups = {"smoke"})
    public void checkOutWithEmptyCart(){
    WebElement loginButton = driver.findElement(By.id("login2"));
    loginButton.click();
    WebElement usernameField = driver.findElement(By.id("loginusername"));
    WebElement passwordField = driver.findElement(By.id("loginpassword"));
    usernameField.sendKeys("Admin.user");
    passwordField.sendKeys("Adminuser@1234");
    WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
    clickonLoginbutton.click();
    waitForSomeTime();
    WebElement cartButton = driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[4]/a"));
    cartButton.click();

    //Click "Place Order" with no items in the cart.
    WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button"));
    placeOrderButton.click();

    //Expected Result: The system should display a warning message.
    System.out.println("Test Case Failed : There is no items in cart");
    }
}
