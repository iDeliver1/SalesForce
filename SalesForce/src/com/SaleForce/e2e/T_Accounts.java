package com.SaleForce.e2e;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SaleForce.libraries.Excel_Libraries;
import com.SaleForce.libraries.Utility_Libraries;
import com.SaleForce.webelements.SaleForce_Accounts;
import com.SaleForce.webelements.SaleForce_Login;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class T_Accounts {
	WebDriver driver;						
	ExtentTest logger;						
	ExtentReports Extndreport;  			
	String testName = T_Accounts.class.getName();

	@BeforeTest
	public void Create() throws Throwable 
		{	 
			//--------------------------------------------Calling report-----------------------------------------------
			Extndreport = Utility_Libraries.fReport();
			//------------------------------------------Create a Excel file--------------------------------------------
			Excel_Libraries.fCreateExcelfile(); 
			logger 		= Extndreport.startTest(testName); 
		}
	
		@Parameters({ "Browser" , "Url" })
		@Test(priority=1)
		public void Launch(String Browser, String Url) throws Throwable
			{
			    //----------------------------------------------Start report test-------------------------------------------------
				testName	= new Object(){}.getClass().getEnclosingMethod().getName();
				logger 		= Extndreport.startTest(testName);
					
				driver = Utility_Libraries.fgetBrowser(Browser, driver);					 
				driver.navigate().to(Url);	
				driver.manage().window().maximize();
			}
		
		@Parameters({ "Username" , "Password" })
		@Test(priority=2)
		public void Login(String Username,String Password) throws Throwable
			{
			 	//----------------------------------------------Start report test-------------------------------------------------
				testName	= new Object(){}.getClass().getEnclosingMethod().getName();
				logger 		= Extndreport.startTest(testName);
				
				//--------------------------------------------------------------------------------			
				SaleForce_Login objLoginClass =  new SaleForce_Login(logger, driver, Extndreport);						
				objLoginClass.Login(Username,Password);							
			}
		
		@Test(priority=3)
		public void Account_Create() throws Throwable
		{	
			SaleForce_Accounts objAccountClass = new SaleForce_Accounts(logger, driver, Extndreport);
			objAccountClass.Create_Accounts();
		}

}
