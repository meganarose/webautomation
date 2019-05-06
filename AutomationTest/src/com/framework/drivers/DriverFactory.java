package com.framework.drivers;

public class DriverFactory  {
	
	public IDriverTemplate driverInstance(String browser) {
		
		//please read -> https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
		
		if(browser == null){
	         return null;
	      }		
	      if(browser.equalsIgnoreCase("chrome")){
	         return new ChromeDriverWeb();
	         
	      } else if(browser.equalsIgnoreCase("chromedevice")){
	         return new ChromeDeviceDriver();
	         
	      } 
		return null;
		
	}	
}