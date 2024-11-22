package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudLoginPage {
    public CloudLoginPage() {
        PageFactory.initElements(Driver.getDriver("webPlatform"),this);
    }

    @FindBy (id = "user")
    public WebElement userLoginBox;

    @FindBy (id = "password")
    public WebElement userPasswordBox;

    @FindBy (id = "submit-form")
    public WebElement loginButton;

    @FindBy (id = "appmenu")
    public WebElement menuItems;




}
