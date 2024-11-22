package com.cydeo.step_definitions;

import com.cydeo.pages.CloudLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CloudWebAppStepDefs {

    CloudLoginPage page;
    AppiumDriver driver;

    String url= ConfigurationReader.getProperty("url");
    String username= ConfigurationReader.getProperty("cloudUserName");
    String password= ConfigurationReader.getProperty("cloudPassword");
    @When("User navigates to web application of Cloud on a Mobile Device")
    public void userNavigatesToWebApplicationOfCloudOnAMobileDevice() {
            page = new CloudLoginPage();
            driver = Driver.getDriver("webPlatform");
            driver.get(url);
    }

    @And("User logins with valid credentials")
    public void userLoginsWithValidCredentials() {
        page.userLoginBox.sendKeys(userName);
        page.userPasswordBox.sendKeys(password);
        page.loginButton.click();
        MobileUtils.wait(3);
    }

    @Then("User verifies successful login action")
    public void userVerifiesSuccessfulLoginAction() {
        Assertions.assertTrue(page.menuItems.isDisplayed());
    }
}
