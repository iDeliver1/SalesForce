package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;

import com.SaleForce.POM.CreateAccounts;
import com.SaleForce.POM.CreateContract;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Accounts {
	
	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	CreateContract CreateContractPOM = new CreateContract();
	CreateAccounts CreateAccountPOM = new CreateAccounts();
	Utility_Libraries UtilityObject = new Utility_Libraries();
	
	public SaleForce_Accounts(ExtentTest logger,WebDriver driver,ExtentReports Extndreport) {

		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}
	
	public void Create_Contracts() throws Throwable
	{
			driver.findElement(CreateAccountPOM.AccoutTab()).click();
			Thread.sleep(3000);
			try
			{
				//Close the popup window
				driver.findElement(CreateContractPOM.PopUpWindow()).click();
			}
			catch(Exception f) {}
			Thread.sleep(3000);
		 	driver.findElement(CreateAccountPOM.New()).click();
	}

}
