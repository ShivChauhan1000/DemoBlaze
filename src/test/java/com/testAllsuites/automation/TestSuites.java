package com.testAllsuites.automation;

import org.testng.annotations.*;

public class TestSuites {
    @Test
    public void tester(){

        System.out.println("This is normal test method..");
    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("This is before class");
    }
    @AfterClass
    public void afterClass(){

        System.out.println("This is after class");
    }
    @BeforeTest
    public void beforeTest(){

        System.out.println("This is before Test");
    }
    @AfterTest
    public void afterTest() {

        System.out.println("This is after Test");
    }
    @BeforeMethod
    public void beforeMethod(){

        System.out.println("This is before Method");
    }
    @AfterMethod
    public void afterMethod(){

        System.out.println("This is after Method");
    }
    @BeforeSuite
    public void beforeSuite(){

        System.out.println("This is Before suite.");
    }
    @AfterSuite
    public void afterSuite(){

        System.out.println("This is After suite.");
    }
}
