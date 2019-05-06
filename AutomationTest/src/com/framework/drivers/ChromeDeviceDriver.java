package com.framework.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class ChromeDeviceDriver implements IDriverTemplate {	
	
	public WebDriver initDriver() {
			WebDriver driver = null;
		   
			//Created object of DesiredCapabilities class
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//The kind of mobile device or emulator to use - iPad Simulator, iPhone Retina 4-inch, Android Emulator, Galaxy S4 etc
			//Find your device name by running command 'adb devices' from command prompt
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "988d503843524d4a3930");
		
			//Which mobile OS platform to use - iOS, Android, or FirefoxOS
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
			
			//Java package of the Android app you want to run- Ex: com.example.android.myApp
			//For Android calculator app, package name is 'com.android.calculator2'
			capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			ChromeOptions options=new ChromeOptions();
			options.setExperimentalOption("androidPackage", "com.android.chrome");
			System.setProperty("webdriver.chrome.driver", "/Users/apple/rose/testingframework/AutomationTest/drivers/mac/chromedriver");

			
			// Initialize the driver object with the URL to Appium Server and pass capabilities
			try {
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
		}
	
}