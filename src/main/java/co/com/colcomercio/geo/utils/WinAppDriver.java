package co.com.colcomercio.geo.utils;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;


public class WinAppDriver {

    private AppiumDriver appiumDriverDriver;
    public WinAppDriver (String winName) {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("app", winName);
        capabilities.setCapability("platformName", "windows");
        capabilities.setCapability("automationName","windows");
        appiumDriverDriver = null;


        try {
            appiumDriverDriver = new AppiumDriver(new java.net.URL("http://127.0.0.1:4723/"), capabilities);
            appiumDriverDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AppiumDriver connect(){
        return appiumDriverDriver;
    }

    public static WinAppDriver theApplication(String winName) {
        return new WinAppDriver(winName);
    }

    public AppiumDriver switchWindow(String name) {
        WebElement winName = appiumDriverDriver.findElement(By.name(name));
        String winNameTopLevelWindowHandle = winName.getAttribute("NativeWindowHandle");
        winNameTopLevelWindowHandle = Integer.toHexString(Integer.parseInt(winNameTopLevelWindowHandle));

        DesiredCapabilities capabilities= new DesiredCapabilities();

        capabilities.setCapability("platformName", "windows");
        capabilities.setCapability("automationName","windows");
        capabilities.setCapability("appTopLevelWindow", winNameTopLevelWindowHandle);

        try {
            appiumDriverDriver = new AppiumDriver(new java.net.URL("http://127.0.0.1:4723/"), capabilities);
            appiumDriverDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return appiumDriverDriver;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void close() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM vncviewer.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

