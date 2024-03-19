package com.cydeo.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileBrowserType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {

    private static AppiumDriver driver;
    private  static URL url;
    private static UiAutomator2Options caps= new UiAutomator2Options();
    private Driver(){

    }
    public static AppiumDriver getDriver(String platformType){
        String platform=ConfigurationReader.getProperty(platformType);
        if(Objects.isNull(driver)) {
            switch (platform) {
                case "android-calculator":
                    caps.setApp("https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
                case "local-android-swaglabs":
                    String testDir = System.getProperty("user.dir");
                    caps.setApp(testDir+"/swaglabsApp.apk");
                    caps.setAppPackage("com.swaglabsmobileapp");
                    caps.setAppActivity("com.swaglabsmobileapp.MainActivity");
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
                case "webapp-cydeoCloud":
                    caps.withBrowserName(MobileBrowserType.CHROME);
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(Objects.nonNull(driver)){
            driver.quit();
            driver=null;
        }
    }

}
