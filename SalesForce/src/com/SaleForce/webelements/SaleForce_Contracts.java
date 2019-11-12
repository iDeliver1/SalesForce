package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.SaleForce.POM.CreateContract;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Contracts {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	CreateContract CreateContractPOM = new CreateContract();
	Utility_Libraries UtilityObject = new Utility_Libraries();
	
	public SaleForce_Contracts(ExtentTest logger,WebDriver driver,ExtentReports Extndreport)
	{
		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}
	
	public void Create_Contracts() throws Throwable
	{
			String CurrentDate = UtilityObject.fGetCurrentDate();
			driver.findElement(CreateContractPOM.ContractTab()).click();
			Thread.sleep(3000);
			try
			{
				//Close the popup window
				driver.findElement(CreateContractPOM.PopUpWindow()).click();
			}
			catch(Exception f) {}
			Thread.sleep(3000);
		 	driver.findElement(CreateContractPOM.NewLink()).click();
			 	try
			 	{
			 		driver.findElement(CreateContractPOM.CustomerName()).isDisplayed();
					//-----------------------------Reporter
			 		UtilityObject.fReportpass("Create Contract", "Create Contract page is open successfully", logger, driver);
					//------------------------------------
			 	}
			 	catch(Exception e)
			 	{
			 		//-----------------------------Reporter
			 		UtilityObject.fReportfail("Create Contract", "Error :" + e +" Create Contract page is not open successfully", logger, driver, Extndreport);
					//------------------------------------
			 	}
			 	
	        driver.findElement(CreateContractPOM.CustomerName()).sendKeys("Amazon");
	        driver.findElement(CreateContractPOM.CustomerSigned()).sendKeys("ABC Company");
	        driver.findElement(CreateContractPOM.CustomerTitle()).sendKeys("NewContract");
			driver.findElement(CreateContractPOM.CustomerDate()).sendKeys(CurrentDate);
			Select priceBook = new Select(driver.findElement(CreateContractPOM.PriceBook()));
			priceBook.selectByVisibleText("Standard");
			driver.findElement(CreateContractPOM.ContractDate()).sendKeys(CurrentDate);
			driver.findElement(CreateContractPOM.ContractMonth()).sendKeys("12");
			Thread.sleep(3000);
			Select OwnerExpiration = new Select(driver.findElement(CreateContractPOM.OwnerExpirationNotice()));
			OwnerExpiration.selectByVisibleText("120 Days");
			driver.findElement(CreateContractPOM.CompanySigned()).sendKeys("Candyce Webber");
			driver.findElement(CreateContractPOM.DescriptionArea()).sendKeys("This is contract");
			//-------------------------Billing Address----------------------------------------/
			Thread.sleep(5000);
			driver.findElement(CreateContractPOM.SaveButton()).click();
	}

}
