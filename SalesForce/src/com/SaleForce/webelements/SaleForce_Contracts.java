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
	
	public void Create_Contracts(String CustomerName,String CustomerTitle,String PriceBook,String ContractMonth,String OwnerExpiration,String CompanySigned,String DescriptionArea) throws Throwable
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
			Thread.sleep(2000);
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
			 	
	        driver.findElement(CreateContractPOM.CustomerName()).sendKeys(CustomerName);
	        driver.findElement(CreateContractPOM.CustomerTitle()).sendKeys(CustomerTitle);
			driver.findElement(CreateContractPOM.CustomerDate()).sendKeys(CurrentDate);
			Select priceBook = new Select(driver.findElement(CreateContractPOM.PriceBook()));
			priceBook.selectByVisibleText(PriceBook);
			driver.findElement(CreateContractPOM.ContractDate()).sendKeys(CurrentDate);
			driver.findElement(CreateContractPOM.ContractMonth()).sendKeys(ContractMonth);
			Select OwnerExpirationNotice = new Select(driver.findElement(CreateContractPOM.OwnerExpirationNotice()));
			OwnerExpirationNotice.selectByVisibleText(OwnerExpiration);
			driver.findElement(CreateContractPOM.CompanySigned()).sendKeys(CompanySigned);
			driver.findElement(CreateContractPOM.DescriptionArea()).sendKeys(DescriptionArea);
			//-------------------------Billing Address----------------------------------------/
			Thread.sleep(3000);
			driver.findElement(CreateContractPOM.SaveButton()).click();
			
			//----------------------Verification Contract is Created-------------------------/
			
			String ContractNumber =  driver.findElement(CreateContractPOM.PageDescription()).getText();
				if(ContractNumber!=""){
			    //-----------------------------Reporter------------------------------------------/
				UtilityObject.fReportpass("Contract create", "Contract is successfully created", logger, driver);
				//-------------------------------------------------------------------------------
				}else{
				//-----------------------------Reporter------------------------------------------/
				UtilityObject.fReportfail("Contract create", "Contract is not successfully created", logger, driver, Extndreport);
				//-------------------------------------------------------------------------------/
				}
	}

}
