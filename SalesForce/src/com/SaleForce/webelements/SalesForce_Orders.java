package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.SaleForce.POM.CreateContract;
import com.SaleForce.POM.CreateOrder;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SalesForce_Orders {
		
		WebDriver driver;
		ExtentTest logger;
		ExtentReports Extndreport;
		CreateOrder CreateOrderPOM = new CreateOrder();
		Utility_Libraries UtilityObject = new Utility_Libraries();
		
		public SalesForce_Orders(ExtentTest logger,WebDriver driver,ExtentReports Extndreport)
		{
			this.driver = driver;
			this.logger = logger;
			this.Extndreport = Extndreport;
		}
		
		public void Create_Orders(String AccountName,String OrderStartDate,String ContractNumber,String OrderDescription) throws Throwable
		{
				driver.findElement(CreateOrderPOM.OrderTab()).click();
				Thread.sleep(3000);
				try
				{
					//Close the popup window
					driver.findElement(CreateOrderPOM.PopUpWindow()).click();
				}
				catch(Exception f) {}
				Thread.sleep(2000);
			 	driver.findElement(CreateOrderPOM.NewLink()).click();
				 	try
				 	{
				 		driver.findElement(CreateOrderPOM.AccountName()).isDisplayed();
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
				 	
		        driver.findElement(CreateOrderPOM.AccountName()).sendKeys(AccountName);
		        driver.findElement(CreateOrderPOM.OrderStartDate()).sendKeys(OrderStartDate);
				driver.findElement(CreateOrderPOM.ContractNumber()).sendKeys(ContractNumber);
				driver.findElement(CreateOrderPOM.OrderDescription()).sendKeys(OrderDescription);
				//-------------------------Billing Address----------------------------------------/
				Thread.sleep(3000);
				driver.findElement(CreateOrderPOM.OrderSaveButton()).click();
				
				//----------------------Verification Contract is Created-------------------------/
				
				String OrderNumber_ =  driver.findElement(CreateOrderPOM.OrderNumber()).getText();
				String OrderNumberCreate = OrderNumber_.replace("Order ","");
					if(OrderNumberCreate.matches("[0-9]{8}")){
				    //-----------------------------Reporter------------------------------------------/
					UtilityObject.fReportpass("Order create", "Order is successfully created", logger, driver);
					//-------------------------------------------------------------------------------
					}else{
					//-----------------------------Reporter------------------------------------------/
					UtilityObject.fReportfail("Order create", "Order is not successfully created", logger, driver, Extndreport);
					//-------------------------------------------------------------------------------/
					}
		}

		
	

}
