package com.demoblaze.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends BaseClass{

    @Test(priority=8,groups = {"random"})
    public void addItemInCart(){
        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter a valid username and password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys("Admin.user");
        passwordField.sendKeys("Adminuser@1234");

        //Click on the "Log in" button.

        WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
        clickonLoginbutton.click();////////////////////////////////////////

        waitForSomeTime();

        WebElement element = driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element );
        js.executeScript("window.scrollBy(0,250)", "");

        //Select a product.
        WebElement selectedProduct = driver.findElement(By.xpath("//*[text()='HTC One M9']"));
        selectedProduct.click();

        //Click "Add to cart".
        WebElement addCartButton = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        addCartButton.click();

        //Navigate to the cart page.
        driver.navigate().back();

        WebElement cartButton = driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[4]/a"));
        cartButton.click();
        waitForSomeTime();

        //Expected Result: The selected product should appear in the cart.
        String expectedResult = "HTC One M9";
        Assert.assertTrue(driver.getPageSource().contains(expectedResult));
        System.out.println("Test case passed : product is displayed.");
    }

    @Test(priority=9,groups = {"smoke"})
    public void addItemInCartWithoutLogin(){
        WebElement element = driver.findElement(By.xpath("//a[text()='Iphone 6 32gb']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element );
        js.executeScript("window.scrollBy(0,250)", "");

        //Select a product.
        WebElement selectedProduct = driver.findElement(By.xpath("//*[text()='HTC One M9']"));
        selectedProduct.click();

        //Click "Add to cart".
        WebElement addCartButton = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        addCartButton.click();

        //Navigate to the cart page.
        driver.navigate().back();

        WebElement cartButton = driver.findElement(By.xpath("//*[@id='navbarExample']/ul/li[4]/a"));
        cartButton.click();
        waitForSomeTime();

        //Expected Result: The selected product should appear in the cart.
        String expectedResult = "HTC One M9";
        Assert.assertTrue(driver.getPageSource().contains(expectedResult));
        System.out.println("Test case Failed : product should not display without login.");
    }
}
