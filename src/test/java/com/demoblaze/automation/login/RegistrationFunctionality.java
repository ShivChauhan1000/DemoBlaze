package com.demoblaze.automation.login;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationFunctionality extends BaseClass{

    @Test(enabled = false, priority=1)
    public void validUserRegistration() {
        //Navigate to the DemoBlaze website.
        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Click on "Sign up".
        WebElement signUpButton = driver.findElement(By.id("signin2"));
        signUpButton.click();

        //Enter a unique username and password.
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        WebElement passwordField = driver.findElement(By.id("sign-password"));

        usernameField.sendKeys("Admin.user1211309");
        passwordField.sendKeys("Admin.user@321");

        //Click on "Sign up".
        WebElement signInbutton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]//button[2]"));
        signInbutton.click();

        //Expected Result : A confirmation message should appear(Sign up successful.)
        String ExpectedMessage = "Sign up successful.";
        wait.until(ExpectedConditions.alertIsPresent()); //Explicit wait for alert

        Alert al = driver.switchTo().alert();
       String ActualAlertText = al.getText();
       Assert.assertEquals(ActualAlertText,ExpectedMessage);
        System.out.println("Registration Test Passed");
    }

    @Test(priority=2,groups = {"random"})
    public void duplicateUsernameRegistration(){

        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        WebElement signUpButton = driver.findElement(By.id("signin2"));
        signUpButton.click();

        //Enter an already registered username.
        WebElement usernameField = driver.findElement(By.id("sign-username"));
        WebElement passwordField = driver.findElement(By.id("sign-password"));

        usernameField.sendKeys("Admin.user121124");
        passwordField.sendKeys("Admin.user@321");

        //Click on "Sign up".
        WebElement signInbutton = driver.findElement(By.xpath("//*[@id=\"signInModal\"]//button[2]"));
        signInbutton.click();

        //Expected Result: The system should display an error message.
        String ExpectedMessage = "This user already exist.";
        wait.until(ExpectedConditions.alertIsPresent()); //Explicit wait for alert

        Alert al = driver.switchTo().alert();
        String ActualAlertText = al.getText();
        Assert.assertEquals(ActualAlertText,ExpectedMessage);
        System.out.println("Duplicate Registration Test Passed");
    }
}