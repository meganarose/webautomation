package com.framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.framework.commonutils.Log;
import com.framework.commonutils.SeleniumCommonUtils;

public class IndeedJobListing {

	protected WebDriver driver;
	@FindBy(xpath="//ul[@class='listSingleColumn']/li/h3/a")
	List<WebElement> jobsListing;
	SeleniumCommonUtils selenies = new SeleniumCommonUtils(driver);
	
	public IndeedJobListing(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void findEquivalentJob(String txt) {
	     System.out.println(driver.getTitle());
	      
		for(WebElement ele:jobsListing) {
			
			if(ele.getText().contains(txt)) {
				selenies.clickOnElement(ele);
				break;
			}else
				Log.info("Job not found with the search string "+ele.getText()) ;
		}
		
	}
}


