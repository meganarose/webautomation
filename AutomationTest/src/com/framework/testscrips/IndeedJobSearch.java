package com.framework.testscrips;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.commonutils.IndeedJobSearchDataProvider;
import com.framework.pageobjects.IndeedAutomationJobPageObjects;
import com.framework.pageobjects.IndeedJobListing;
import com.framework.pageobjects.IndeedJobSearchPObj;

public class IndeedJobSearch extends TestSuite{

	@BeforeTest
	public void openWebSite() {
		driver.get("https://www.indeed.jobs/career");
		//driver.manage().window().maximize();
	}
	
	@Test(dataProvider = "dataFromCSV", dataProviderClass = IndeedJobSearchDataProvider.class)
	public void searchJob(HashMap<String,String> csvJobData) throws InterruptedException {
		IndeedJobSearchPObj  indeedjobSearchPO = new IndeedJobSearchPObj(driver);
		indeedjobSearchPO.enterJobTitle(csvJobData.get("JobTitle"));
		indeedjobSearchPO.selectLocation(csvJobData.get("JobLocation"));
	    indeedjobSearchPO.clickOnFindJobsBtn();
		Reporter.log("Job Searched Successfully");
		
	}
	
	@Test(dependsOnMethods = {"searchJob"})
	public void selectOpenJobs() {
		System.out.println("calling second method");
		IndeedJobListing indeedJoblisting = new IndeedJobListing(driver);
		indeedJoblisting.findEquivalentJob("Automation");
	}
	
	@Test(dependsOnMethods = {"selectOpenJobs"})
	public void verifyJobAppeared() {
		IndeedAutomationJobPageObjects indeedexpectedJob = new IndeedAutomationJobPageObjects(driver);
	    Assert.assertTrue(indeedexpectedJob.getJobTitle("Quality Assurance Automation Engineer"), "Result Pass");
	}
}
