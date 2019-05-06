package com.framework.commonutils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonUtils {
	protected WebDriver driver;

	public SeleniumCommonUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTextValue(WebElement ele, String txt) {
		if(isEleemntPresent(ele)) {
			ele.clear();
		    ele.sendKeys(txt);
		    
		}else
		System.out.println("text not entered");
		//implement logger
	}
	
	public boolean isEleemntPresent(WebElement ele) {
		boolean value = false;
		if(ele.isDisplayed()) {
			value = true;
			//implement logger
		}else {
			//implement logger
		}
		return value;
	}
	
	public void pressEnter(WebElement ele) {
		ele.submit();
	}
	
	public void clickOnElement(WebElement ele) {
		
		   ele.click();
		
		
	}
	
	public boolean isElementClicked(WebElement ele) {
		if(ele.isSelected()) {
			return true;
		}else
			return false;
	}
	
	public boolean webdriverWaitForClick(WebElement ele,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
			return true;
		}catch(Exception e) {
			System.out.println("Exception in wait" +e);
			return false;
		}
	}
	
	public boolean checkLocationSelectExpanded(WebElement ele, String attribute) {
		boolean expanded = false;
		String value = ele.getAttribute(attribute);
		if(value.equals("true")) {
			expanded = true;
		}
		return expanded;
	}
	
	public String getText(WebElement ele) {
		String value = ele.getText();
		return value;
	}
	
	public List<WebElement> checkListOfLocations(WebElement ele){
		List<WebElement> locationList;
		locationList = ele.findElements(By.tagName("li"));
		System.out.println(locationList.size());
		return locationList;
		
	}
	
	 public void untilAngularFinishHttpCalls() {
	        final String javaScriptToLoadAngular =
	                "var injector = window.angular.element('body').injector();" + 
	                "var $http = injector.get('$http');" + 
	                "return ($http.pendingRequests.length === 0)";

	        ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
	            }
	        };
	        WebDriverWait wait = new WebDriverWait(driver, 20); // timeout = 20 secs
	        wait.until(pendingHttpCallsCondition);
	    }
	

}
