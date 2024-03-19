package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SwagLabAppPage {
    public  SwagLabAppPage(String platformEnv){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver(platformEnv)),this);
    }
    @AndroidFindBy(accessibility = "test-Username")
    public WebElement userNameBox;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passwordBox;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    public WebElement sampleItem;

}
