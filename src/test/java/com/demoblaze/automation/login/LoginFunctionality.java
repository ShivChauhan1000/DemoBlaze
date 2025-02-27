package com.demoblaze.automation.login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginFunctionality extends BaseClass {

    @Test(priority = 4, groups = {"login","random"})
    public void validLogin(){

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
        clickonLoginbutton.click();
        System.out.println("Login Test Successfully Passed");
    }

    @Test(priority=5,groups = {"login"})
    public void inValidLogin(){

        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter an invalid username or password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys("Admin.user11");
        passwordField.sendKeys("Adminuser@1234");

        //Click on the "Log in" button.

        WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
        clickonLoginbutton.click();

        //Expected Result: An error message should be displayed. (User does not exist.)
        wait.until(ExpectedConditions.alertIsPresent());
        String ExpectedMsg = "User does not exist.";

        Alert al = driver.switchTo().alert();
        String ActualMsg = al.getText();
        Assert.assertEquals(ActualMsg,ExpectedMsg);
        System.out.println("Invalid Login Test Successfully Passed");
    }

    @Test(priority=6,groups = {"login"})
    public void inValidPassword(){

        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter an invalid username or password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys("Admin.user");
        passwordField.sendKeys("Adminuser@12345");

        //Click on the "Log in" button.

        WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
        clickonLoginbutton.click();

        //Expected Result: An error message should be displayed. (User does not exist.)
        wait.until(ExpectedConditions.alertIsPresent());
        String ExpectedMsg = "Wrong password.";

        Alert al = driver.switchTo().alert();
        String ActualMsg = al.getText();
        Assert.assertEquals(ActualMsg,ExpectedMsg);
        System.out.println("Invalid Password Test Successfully Passed");
    }

}
