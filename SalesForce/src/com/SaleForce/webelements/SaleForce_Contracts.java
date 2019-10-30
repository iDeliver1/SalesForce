package com.SaleForce.webelements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SaleForce.POM.CreateContract;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Contracts {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	CreateContract CreateContractPOM = new CreateContract();
	
	public SaleForce_Contracts(ExtentTest logger,WebDriver driver,ExtentReports Extndreport)
	{
		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}
	
	public void Create_Contracts() throws Throwable
	{
			driver.findElement(CreateContractPOM.ContractTab()).click();
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(CreateContractPOM.PopUpWindow()));
			driver.findElement(CreateContractPOM.PopUpWindow()).click();
		 	driver.findElement(CreateContractPOM.NewLink()).click();
	        driver.findElement(CreateContractPOM.CustomerName()).sendKeys("Amazon");
	        driver.findElement(CreateContractPOM.CustomerSigned()).sendKeys("ABC Company");
	        driver.findElement(CreateContractPOM.CustomerTitle()).sendKeys("NewContract");
	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	        Date dateobj = new Date();
			driver.findElement(CreateContractPOM.CustomerDate()).sendKeys(df.format(dateobj));
			Select priceBook = new Select(driver.findElement(CreateContractPOM.PriceBook()));
			priceBook.selectByVisibleText("Standard");
			driver.findElement(CreateContractPOM.ContractDate()).sendKeys(df.format(dateobj));
			driver.findElement(CreateContractPOM.ContractMonth()).sendKeys("12");
			Select OwnerExpiration = new Select(driver.findElement(CreateContractPOM.OwnerExpirationNotice()));
			OwnerExpiration.selectByValue("120 Days");
			driver.findElement(CreateContractPOM.CompanySigned()).sendKeys("Chris Carpenter");
			//-------------------------Billing Address----------------------------------------//
			driver.findElement(CreateContractPOM.BillingStreet()).sendKeys("Uslapur");
			driver.findElement(CreateContractPOM.BillingState()).sendKeys("Chhattisgarh");
			driver.findElement(CreateContractPOM.BillingCountry()).sendKeys("India");
			driver.findElement(CreateContractPOM.BillingDescription()).sendKeys("This is contract");
			driver.findElement(CreateContractPOM.SaveButton()).click();
	}

}
