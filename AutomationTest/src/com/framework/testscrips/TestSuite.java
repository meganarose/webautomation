package com.framework.testscrips;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.framework.commonutils.CommonProperties;
import com.framework.commonutils.Log;
import com.framework.drivers.DriverFactory;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public class TestSuite {
	
	static WebDriver driver;
	static Map<Object,Object> uiConfigURLs;

  
  @BeforeSuite
  @Parameters({"typeName"})
  public void beforeSuite(String typeName) {
	  Log.startLog("Start of suite");
	  System.out.println("At before suite");
	  driver = new DriverFactory().driverInstance(typeName).initDriver();
	  CommonProperties prop = new CommonProperties();
	  uiConfigURLs = prop.readPropertiesFile("UIconfi.properties");
			
  }

  @AfterSuite
  public void afterSuite() {
	  driver.quit();
	  Log.endLog("End of test suite");
  }

public static WebDriver getDriver() {
	return driver;
}

public void setDriver(WebDriver driver) {
	this.driver = driver;
}

public static Map<Object, Object> getUiConfigURLs() {
	return uiConfigURLs;
}

public  void setUiConfigURLs(Map<Object, Object> uiConfigURLs) {
	this.uiConfigURLs = uiConfigURLs;
}

}
