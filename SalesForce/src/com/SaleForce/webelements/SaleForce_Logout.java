package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;

import com.SaleForce.POM.Logout;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Logout {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	Utility_Libraries Utility_Object = new Utility_Libraries();
	Logout LogoutPOM = new Logout();
	
	public SaleForce_Logout(ExtentTest logger,WebDriver driver, ExtentReports Extndreport) {

		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}

	public void Logout() throws Throwable
	{
		try
		{
			driver.findElement(LogoutPOM.Account()).click();
				//-----------------------------Reporter
				Utility_Object.fReportpass("Logout", "User is successfully logout", logger, driver);
				//------------------------------------
			driver.findElement(LogoutPOM.Logout_()).click();
		}
		catch(Exception e)
		{
			//-----------------------------Reporter
			Utility_Object.fReportfail("Logout", "Error :" + e +" User is not successfully logout", logger, driver, Extndreport);
			//------------------------------------
		}
	}
}
