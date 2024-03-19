package com.cydeo.step_definitions;

import com.cydeo.pages.SwagLabAppPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.MobileUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SwagLabsStepDefs {
    SwagLabAppPage page;
    String username = ConfigurationReader.getProperty("userName");
    String password = ConfigurationReader.getProperty("password");
    @When("User navigates to login page of swaglabs native application on {string}")
    public void user_navigates_to_login_page_of_swaglabs_native_application_on(String env) {
        page= new SwagLabAppPage(env+"-swagPlatform");
    }
    @When("User logins with valid username and password")
    public void user_logins_with_valid_username_and_password() {
        page.userNameBox.sendKeys(username);
        page.passwordBox.sendKeys(password);
        page.loginButton.click();

        MobileUtils.wait(3);

    }
    @Then("Verifies user can see a sample product item on the homepage")
    public void verifies_user_can_see_a_sample_product_item_on_the_homepage() {
        Assertions.assertTrue(page.sampleItem.getText().contains("Sauce"));
        Driver.closeDriver();
    }

}
