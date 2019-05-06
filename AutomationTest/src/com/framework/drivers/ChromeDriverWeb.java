package com.framework.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeDriverWeb implements IDriverTemplate {

	@Override
	public WebDriver initDriver() {
		// TODO Auto-generated method stub
		System.out.println("driver");
		System.setProperty("webdriver.chrome.driver", "/Users/apple/rose/testingframework/AutomationTest/drivers/mac/chromedriver");
		WebDriver driver = new ChromeDriver(); 
		return driver;
		
	}
}
