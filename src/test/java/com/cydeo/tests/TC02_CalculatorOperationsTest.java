package com.cydeo.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class TC02_CalculatorOperationsTest {
    /**
     * We will locate elements of Calculator app with Appium Inspector tool
     * We will create Android driver in before method of Junit, then quit driver at after method
     * Assertions from Junit to verify the result
     */
    AndroidDriver driver;
    @BeforeEach
    public void testSetUp(){
        UiAutomator2Options options = new UiAutomator2Options();
        options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        try {
            driver = new AndroidDriver(new URL("http://localhost:4723/"),options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void addingTest(){
        // Locate elements of numbers, lets add 4 and 5
        WebElement n_four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        n_four.click();

        WebElement plusButton = driver.findElement(new AppiumBy.ByAccessibilityId("plus"));
        plusButton.click();

        WebElement n_five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        n_five.click();

        WebElement equals = driver.findElement(new AppiumBy.ByAccessibilityId("equals"));
        equals.click();

        WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));

        String actualResult = result.getText();
        int expResult = 9;

        Assertions.assertEquals(expResult,Integer.parseInt(actualResult));

    }



}
