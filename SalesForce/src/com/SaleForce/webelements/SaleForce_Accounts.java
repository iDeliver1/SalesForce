package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	public void Create_Accounts(String AccountName,String AccountNumber,String AccountDescription) throws Throwable
	{
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			driver.findElement(CreateAccountPOM.AccoutTab()).click();
			 
			wait.until(ExpectedConditions.visibilityOfElementLocated(CreateContractPOM.PopUpWindow()));
			
			try
			{
				//Close the popup window
				driver.findElement(CreateContractPOM.PopUpWindow()).click();
			}
			catch(Exception f) {}
			
			Thread.sleep(3000);
			
		 	driver.findElement(CreateAccountPOM.New()).click();
			try
			{
				driver.findElement(CreateAccountPOM.AccountName()).isDisplayed();
				//-----------------------------Reporter
				UtilityObject.fReportpass("Create Account", "Create Account page is open successfully", logger, driver);
				//------------------------------------
			}
			catch(Exception e)
			{
				//-----------------------------Reporter
				UtilityObject.fReportfail("Create Account", "Error :" + e +" Create Account page is not open successfully", logger, driver, Extndreport);
				//------------------------------------
			}
			
			driver.findElement(CreateAccountPOM.AccountName()).sendKeys(AccountName);
			driver.findElement(CreateAccountPOM.AccountNumber()).sendKeys(AccountNumber);
			driver.findElement(CreateAccountPOM.Account_Description()).sendKeys(AccountDescription);
			driver.findElement(CreateAccountPOM.Account_Save()).click();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountPOM.AccountVerification()));
		
			String Account_Created = driver.findElement(CreateAccountPOM.AccountVerification()).getText();
			if(Account_Created.contains(AccountName))
			{
				UtilityObject.fReportpass("Account create", "Account is created successfully", logger, driver);
			}
			
			else 
			{
				UtilityObject.fReportfail("Account create", "Account is not created successfully", logger, driver, Extndreport);
			}	
		
	}

}
