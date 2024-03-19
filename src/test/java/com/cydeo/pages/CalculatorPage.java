package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    public CalculatorPage(){
        PageFactory.initElements(new AppiumFieldDecorator( Driver.getDriver("calculatorPlatform")),this);
    }
    @AndroidFindBy(accessibility = "plus")
    public WebElement plusButton;

    @AndroidFindBy(accessibility = "multiply")
    public WebElement multiplyButton;

    @AndroidFindBy(accessibility = "equals")
    public WebElement equalsButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/result_final")
    public  WebElement result;

    public void clickSingleDigit(int digit){
        String idLocator= "com.google.android.calculator:id/digit_"+digit;
        WebElement number= Driver.getDriver("calculatorPlatform").findElement(By.id(idLocator));
        number.click();
    }



}
