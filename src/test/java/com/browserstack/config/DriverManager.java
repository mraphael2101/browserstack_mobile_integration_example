package com.browserstack.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AppiumDriver<?> driver;
    private static String app = "POPULATE IF APPLICABLE",
            browser = "POPULATE IF APPLICABLE",
            device = "NOT DECLARED",
            osVersion = "NOT DECLARED",
            platform = "NOT DECLARED",
            build = "NOT DECLARED",
            project = "NOT DECLARED",
            testName = "NOT DECLARED",
            realMobile = "false",
            browserstackSeleniumVersion = "3.141.59",
            browserstackAppiumVersion = "1.20.2",
            browserstackDebug = "false";

    public static AppiumDriver<?> getDriver() {
        return driver;
    }

    public static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("seleniumVersion", browserstackSeleniumVersion);
        capabilities.setCapability("browserstack.appium_version", browserstackAppiumVersion);
        capabilities.setCapability("browserstack.debug", browserstackDebug);
        capabilities.setCapability("real_mobile", realMobile);
        capabilities.setCapability("build", build);
        capabilities.setCapability("project", project);
        capabilities.setCapability("name", testName);

        switch (platform.toLowerCase()) {
            case "ios_app":
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability("autoWebView", false);
                capabilities.setCapability("app", app);
                capabilities.setCapability("device", device);
                capabilities.setCapability("os_version", osVersion);
                try {
                    driver = new IOSDriver<IOSElement>(new URL("http://" + FmwkConstants.USERNAME + ":"
                            + FmwkConstants.ACCESS_KEY + "@" + FmwkConstants.SERVER + "/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "ios_web":
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                capabilities.setCapability("autoWebView", true);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
                capabilities.setCapability("device", device);
                capabilities.setCapability("os_version", osVersion);
                try {
                    driver = new IOSDriver<IOSElement>(new URL("http://" + FmwkConstants.USERNAME + ":"
                            + FmwkConstants.ACCESS_KEY + "@" + FmwkConstants.SERVER + "/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "android_app":
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability("autoWebView", false);
                capabilities.setCapability("app", app);
                capabilities.setCapability("device", device);
                capabilities.setCapability("os_version", osVersion);
                try {
                    driver = new AndroidDriver<AndroidElement>(new URL("http://" + FmwkConstants.USERNAME + ":"
                            + FmwkConstants.ACCESS_KEY + "@" + FmwkConstants.SERVER + "/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            case "android_web":
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
                capabilities.setCapability("autoWebView", true);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browser);
                capabilities.setCapability("device",  device);
                capabilities.setCapability("os_version", osVersion);
                try {
                    driver = new AndroidDriver<AndroidElement>(new URL("http://" + FmwkConstants.USERNAME + ":"
                            + FmwkConstants.ACCESS_KEY + "@" + FmwkConstants.SERVER + "/wd/hub"), capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;

            default:
                throw new RuntimeException("The platform and channel was not defined");
        }
    }
    public static void setAppOnCloud(String app) {
        DriverManager.app = app;
    }

    public static void setBrowser(String browser) {
        DriverManager.browser = browser;
    }

    public static void setDevice(String device) {
        DriverManager.device = device;
    }

    public static void setOsVersion(String osVersion) {
        DriverManager.osVersion = osVersion;
    }

    public static void setBuild(String build) {
        DriverManager.build = build;
    }

    public static void setProject(String project) {
        DriverManager.project = project;
    }

    public static void setTestName(String testName) {
        DriverManager.testName = testName;
    }

    public static void setRealMobile(String realMobile) {
        DriverManager.realMobile = realMobile;
    }

    public static void setPlatform(String platform) {
        DriverManager.platform = platform;
    }

    public static void setBrowserstackSeleniumVersion(String browserstackSeleniumVersion) {
        DriverManager.browserstackSeleniumVersion = browserstackSeleniumVersion;
    }

    public static void setBrowserstackAppiumVersion(String browserstackAppiumVersion) {
        DriverManager.browserstackAppiumVersion = browserstackAppiumVersion;
    }

    public static void setBrowserstackDebug(String browserstackDebug) {
        DriverManager.browserstackDebug = browserstackDebug;
    }

}
