package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;
import com.SaleForce.POM.CreateCampaign;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Campaign {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	CreateCampaign CreateCampaignPOM = new CreateCampaign();
	Utility_Libraries Utility_Object = new Utility_Libraries();
	
	public SaleForce_Campaign(ExtentTest logger,WebDriver driver, ExtentReports Extndreport) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}
	
	public void Create_Campaign(String Name, String S_Date, String E_Date, String Expected_rev, String Budget_cost) throws Throwable
	{
		try
		{
			try
			{
				//Close the popup window
				driver.findElement(CreateCampaignPOM.Close()).click();
			}
			catch(Exception f) {}
			driver.findElement(CreateCampaignPOM.Tab()).click();
			driver.findElement(CreateCampaignPOM.New()).click();
				try
				{
					driver.findElement(CreateCampaignPOM.Name()).isDisplayed();
					//-----------------------------Reporter
					Utility_Object.fReportpass("Create Campaign", "Create Campaign page is open successfully", logger, driver);
					//------------------------------------
				}
				catch(Exception e)
				{
					//-----------------------------Reporter
					Utility_Object.fReportfail("Create Campaign", "Error :" + e +" Create Campaign page is not open successfully", logger, driver, Extndreport);
					//------------------------------------
				}
			driver.findElement(CreateCampaignPOM.Name()).sendKeys(Name);
			driver.findElement(CreateCampaignPOM.S_Date()).sendKeys(S_Date);
			driver.findElement(CreateCampaignPOM.E_Date()).sendKeys(E_Date);
			driver.findElement(CreateCampaignPOM.Expected_rev()).sendKeys(Expected_rev);
			driver.findElement(CreateCampaignPOM.Budget_cost()).sendKeys(Budget_cost);
			driver.findElement(CreateCampaignPOM.Save()).click();
			String LeadName = driver.findElement(CreateCampaignPOM.HeadName()).getText();
				if(LeadName.contains(Name))
				{
					//-----------------------------Reporter
					Utility_Object.fReportpass("Campaign create", "Campaign is successfully created", logger, driver);
					//------------------------------------
				}
				else
				{
					//-----------------------------Reporter
					Utility_Object.fReportfail("Campaign create", "Campaign is not successfully created", logger, driver, Extndreport);
					//------------------------------------
				}
		}
		catch(Exception r)
		{
			//-----------------------------Reporter
			Utility_Object.fReportfail("Error message", "Error : "+ r, logger, driver, Extndreport);
			//------------------------------------
		}
	}

}
