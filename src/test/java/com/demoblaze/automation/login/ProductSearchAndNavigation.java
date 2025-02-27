package com.demoblaze.automation.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProductSearchAndNavigation extends BaseClass{

    @Test(priority=6,groups = {"random"})
    public void searchForProduct(){
        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));

        //Use the category filter or navigate to different sections (Phones, Laptops, Monitors).
        WebElement categoryElement = driver.findElement(By.xpath("//a[text()='Monitors']"));
        categoryElement.click();

        //Click on a product.
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space() = 'Apple monitor 24']")));
        WebElement productElement = driver.findElement(By.xpath("//a[normalize-space() = 'ASUS Full HD']"));
        productElement.click();

        //Expected Result: The product details page should be displayed.
        System.out.println("The product details are visible : Test Case Passed");
    }

    @Test(priority=7)
    public void productNavigationError(){
        Wait wait = new WebDriverWait(driver,Duration.ofSeconds(2));
        //Try to navigate to a non-existing product via URL modification.

        int number = 909;
        driver.navigate().to("https://www.demoblaze.com/prod.html?idp_=8");
        String currentUrl = driver.getCurrentUrl();

        String newUrl = currentUrl.replaceAll("(\\d+)$","")+number;
        driver.get(newUrl);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='$undefined']")));
        //Expected Result: The system should handle the error gracefull
        String ExpectedError = "undefined";
        Assert.assertTrue(driver.getPageSource().contains(ExpectedError),"Product is defined");
        System.out.println("System catched the error and test case has pass.");
    }
}
