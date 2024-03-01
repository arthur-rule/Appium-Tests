package com.cydeo.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TC01_FirstAppiumTest {
@Test
    public void FirstTest() throws MalformedURLException {
    AndroidDriver driver;
    URL url;
    UiAutomator2Options options=new UiAutomator2Options();
    options.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");

    url=new URL("http://localhost:4723/");
    driver=new AndroidDriver(url,options);
    System.out.println(driver.getDeviceTime());
    driver.quit();

}
}
