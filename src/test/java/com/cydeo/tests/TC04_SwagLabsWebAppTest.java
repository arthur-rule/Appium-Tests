package com.cydeo.tests;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.MobileUtils;
import io.appium.java_client.remote.MobileBrowserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TC04_SwagLabsWebAppTest extends WebAppTestBase {
// appium --allow-insecure chromedriver_autodownload
// sudo spctl --master-disable  :  to disable security for macos so chrome executable operation is allowed

@Test
    public void loginTest (){
    driver.get("https://www.saucedemo.com/v1/");
    WebElement userNameBox=driver.findElement(By.id("user-name"));
    userNameBox.sendKeys(ConfigurationReader.getProperty("userName"));

    WebElement passwordBox=driver.findElement(By.id("password"));
    passwordBox.sendKeys(ConfigurationReader.getProperty("password")+ Keys.ENTER);

    MobileUtils.wait(3);

    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[6]"))).perform();
    MobileUtils.wait(3);


    List<WebElement> productList =  driver.findElements(By.cssSelector(".inventory_item_name"));
//    for(WebElement each:productList){
//        System.out.println(each.getText());
//    }

    for(WebElement each:productList){
        if(each.getText().contains("Test")){
            Assertions.assertTrue(each.getText().toLowerCase().contains("t-shirt"));
        }
    }
}


}
