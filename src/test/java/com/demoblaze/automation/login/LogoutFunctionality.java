package com.demoblaze.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutFunctionality extends BaseClass{

    @Test(priority = 12,groups = {"login","random"})
    public void successfulLogout(){
        //Log in to the website.
        WebElement loginButton = driver.findElement(By.id("login2"));
        loginButton.click();
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        usernameField.sendKeys("Admin.user");
        passwordField.sendKeys("Adminuser@1234");
        WebElement clickonLoginbutton = driver.findElement(By.xpath("//*[@id='logInModal']//button[2]"));
        clickonLoginbutton.click();
        waitForSomeTime();

        //Click "Log out".
        WebElement logOutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        logOutButton.click();
        System.out.println("Successful LogOut; Tc Passed");
    }
}
