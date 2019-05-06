package com.framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commonutils.SeleniumCommonUtils;

public class IndeedAutomationJobPageObjects {

	protected WebDriver driver;
	@FindBy(xpath="//h2[@class='headerBannerTitle']")
	WebElement jobTitle;
	SeleniumCommonUtils selenies = new SeleniumCommonUtils(driver);
	
	public IndeedAutomationJobPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getJobTitle(String expected) {
		boolean value = false;
		String actualJobTitle = selenies.getText(jobTitle);
		if(actualJobTitle.equals(expected)) {
			value= true;;
		}
		return value;
	}
}
