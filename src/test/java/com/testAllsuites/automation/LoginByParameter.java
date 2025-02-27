package com.testAllsuites.automation;

import com.demoblaze.automation.login.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginByParameter extends BaseClass {

    @Parameters({"Username","Password"})
    @Test
    public void validLogin(String username, String password){

        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter a valid username and password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        //Click on the "Log in" button.

        WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id=\"logInModal\"]//button[2]"));
        clickonLoginbutton.click();
        System.out.println("Login Test Successfully Passed");
    }

    @Parameters({"Username","Password"})
    @Test
    public void inValidLogin(String username, String password){

        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter an invalid username or password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

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
    @Parameters({"Username","Password"})
    @Test
    public void inValidPassword(String username, String password){

        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Click on the "Log in" button.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();

        //Enter an invalid username or password.
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

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
