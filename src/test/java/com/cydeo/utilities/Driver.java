package com.cydeo.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileBrowserType;
import org.openqa.selenium.MutableCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

public class Driver {

    private static AppiumDriver driver;

    private static URL url;

    private static UiAutomator2Options caps = new UiAutomator2Options();

    private Driver(){

    }

    public static AppiumDriver getDriver(String platformType){
        String platform = ConfigurationReader.getProperty(platformType);
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
                    caps.setApp(testDir + "/swaglabsApp.apk");
                    caps.setAppPackage("com.swaglabsmobileapp");
                    caps.setAppActivity("com.swaglabsmobileapp.MainActivity");
                    caps.setUiautomator2ServerInstallTimeout(Duration.ofSeconds(60));
                    try {
                        url = new URL("http://localhost:4723/");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, caps);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
                case "remote-android-swaglabs":
                    MutableCapabilities capsRA = new MutableCapabilities();
                    capsRA.setCapability("platformName", "Android");
                    capsRA.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");  // The filename of the mobile app
                    capsRA.setCapability("appium:deviceName", "Google Pixel 5 GoogleAPI Emulator");
                    capsRA.setCapability("appium:automationName", "UiAutomator2");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    sauceOptions.setCapability("username", "oscartestqa001");
                    sauceOptions.setCapability("accessKey", "6c06ace9-5515-4945-b677-b97c3207cbf2");
                    sauceOptions.setCapability("build", "Cydeo01");
                    sauceOptions.setCapability("name", "LoginTestforSwagLabs");
                    sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                    capsRA.setCapability("sauce:options", sauceOptions);


                    MutableCapabilities caps = new MutableCapabilities();
                    caps.setCapability("platformName", "Android");
                    caps.setCapability("appium:app", "storage:filename=swaglabsApp.apk");  // The filename of the mobile app
                    caps.setCapability("appium:deviceName", "Google Pixel 5 GoogleAPI Emulator");
                    //caps.setCapability("appium:platformVersion", "11.0");
                    caps.setCapability("appium:automationName", "UiAutomator2");
                    MutableCapabilities sauceOptions = new MutableCapabilities();
                    //sauceOptions.setCapability("appiumVersion", "2.0.0");
                    sauceOptions.setCapability("username", "oauth-arthur.rule-b08cf");
                    sauceOptions.setCapability("accessKey", "5a19891e-bdbe-4895-b1c2-8a611d23f370");
                    sauceOptions.setCapability("build", "<your build id>");
                    sauceOptions.setCapability("name", "<your test name>");
                    sauceOptions.setCapability("deviceOrientation", "PORTRAIT");
                    caps.setCapability("sauce:options", sauceOptions);

                    URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
                    AndroidDriver driver = new AndroidDriver(url, caps);










                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new AndroidDriver(url, capsRA);
                    break;
                case "remote-ios-swaglabs":
                    MutableCapabilities capsIR = new MutableCapabilities();
                    capsIR.setCapability("platformName", "iOS");
                    capsIR.setCapability("appium:app", "https://github.com/saucelabs/sample-app-mobile/releases/download/2.7.1/iOS.RealDevice.SauceLabs.Mobile.Sample.app.2.7.1.ipa");  // The filename of the mobile app
                    capsIR.setCapability("appium:deviceName", "iPhone Simulator");
                    capsIR.setCapability("appium:platformVersion", "current_major");
                    capsIR.setCapability("appium:automationName", "XCUITest");
                    capsIR.setCapability("appPackage","com.swaglabsmobileapp");
                    capsIR.setCapability("appActivity","com.swaglabsmobileapp.SplashActivity");
                    MutableCapabilities sauceOptionsIR = new MutableCapabilities();
                    sauceOptionsIR.setCapability("username", "oscartestqa001");
                    sauceOptionsIR.setCapability("accessKey", "6c06ace9-5515-4945-b677-b97c3207cbf2");
                    sauceOptionsIR.setCapability("build", "CydeoIOS001");
                    sauceOptionsIR.setCapability("name", "LoginTestsForIOS");
                    sauceOptionsIR.setCapability("deviceOrientation", "PORTRAIT");
                    capsIR.setCapability("sauce:options", sauceOptionsIR);

                    try {
                        url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    }
                    driver = new IOSDriver(url, capsIR);
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
