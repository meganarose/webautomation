package com.framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.commonutils.Log;
import com.framework.commonutils.SeleniumCommonUtils;

public class IndeedJobSearchPObj {
	protected WebDriver driver;

	public IndeedJobSearchPObj(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	SeleniumCommonUtils selenies = new SeleniumCommonUtils(driver);

	@FindBy(xpath = "//input[@class='searchBoxField' and @placeholder='Job title, keywords']")
	WebElement jobSearchBox;

	@FindBy(xpath = "//span[@role='combobox']/span/span[normalize-space(@text='Select an option')]")
	WebElement locationSearchBox;

	@FindBy(xpath = "//span[@class='select2-selection__arrow']/b")
	WebElement expandSelectLocationAria;

	@FindBy(xpath = "//span[@class='select2-selection__arrow']/b/../..")
	WebElement checkLocationExpanded;

	@FindBy(xpath = "//span/descendant::input[@class='select2-search__field' and @role='textbox']")
	WebElement locationtxtbox;

	@FindBy(xpath = "//span/descendant::ul[@class='select2-results__options' and @role='listbox']")
	WebElement locationListExpanded;

	@FindBy(xpath = "//span[@class='select2-container select2-container--default select2-container--open']/span/span[@class='select2-results']/ul/li")
	List<WebElement> locationList;

	@FindBy(xpath = "//button[@name='action']")
	WebElement findJobsBtn;

	public void enterJobTitle(String txt) {
		selenies.enterTextValue(jobSearchBox, txt);

	}

	public void selectLocation(String jobLocation) {
		List<WebElement> locationOptions;

		selenies.clickOnElement(locationSearchBox);

		if (selenies.checkLocationSelectExpanded(checkLocationExpanded, "aria-expanded")) {
			selenies.enterTextValue(locationtxtbox, jobLocation);
			WebDriverWait wait = new WebDriverWait(driver, 100);
			wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//span[@class='select2-container select2-container--default select2-container--open']"
							+ "/span/span[@class='select2-results']/ul/li[@class='select2-results__option select2-results__option--highlighted']")));

			locationOptions = selenies.checkListOfLocations(locationListExpanded);
			if (selenies.checkLocationSelectExpanded(locationListExpanded, "aria-expanded")) {
				if (!locationOptions.isEmpty()) {
					for (WebElement ele : locationOptions) {
						selenies.clickOnElement(ele);
					}
				} else {
					Log.error("Location options are empty to click the text " +jobLocation);
				}
			}
		} else
			Log.error("Location element is not expanded");

	}

	public void clickOnFindJobsBtn() {
		selenies.clickOnElement(findJobsBtn);
	}

}
