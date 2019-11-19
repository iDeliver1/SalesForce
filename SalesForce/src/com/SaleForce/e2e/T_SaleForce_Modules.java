package com.SaleForce.e2e;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SaleForce.libraries.Excel_Libraries;
import com.SaleForce.libraries.Utility_Libraries;
import com.SaleForce.webelements.SaleForce_Accounts;
import com.SaleForce.webelements.SaleForce_Campaign;
import com.SaleForce.webelements.SaleForce_Contracts;
import com.SaleForce.webelements.SaleForce_Leads;
import com.SaleForce.webelements.SaleForce_Login;
import com.SaleForce.webelements.SaleForce_Logout;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class T_SaleForce_Modules {

	WebDriver driver;						
	ExtentTest logger;						
	ExtentReports Extndreport;  			
	String testName = T_Leads.class.getName();
	
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
	@Test(priority=1,enabled=true)
	public void Launch(String Browser, String Url) throws Throwable
		{
		    //----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
				
			//---------------------------------Variables--------------------------------------
			String[] Launch = {Browser, Url};
			Utility_Libraries.fVerifyvalue(Launch,logger);
			Browser 	= Launch[0];
			Url 	    = Launch[1];
			//--------------------------------------------------------------------------------
			
			driver = Utility_Libraries.fgetBrowser(Browser, driver);					 
			driver.navigate().to(Url);	
			driver.manage().window().maximize();
		}
	
	@Parameters({ "Username" , "Password" })
	@Test(priority=2,enabled=true)
	public void Login(String Username, String Password) throws Throwable
		{
		 	//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			//---------------------------------Variables--------------------------------------
			String[] Login = {Username, Password};
			Utility_Libraries.fVerifyvalue(Login,logger);
			Username 	= Login[0];
			Password 	= Login[1];
			//--------------------------------------------------------------------------------
			
			SaleForce_Login objLoginClass =  new SaleForce_Login(logger, driver, Extndreport);						
			objLoginClass.Login(Username,Password);						
		}
	
	@Test(priority=3,enabled=true)
	public void Account_Create() throws Throwable
		{	
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			//---------------------------------Variables--------------------------------------
			String AccountName 	    = Excel_Libraries.fRead("AccountName", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Account");
			String AccountNumber 	= Excel_Libraries.fRead("AccountNumber", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Account");
			String AccountDescription = Excel_Libraries.fRead("AccountDescription", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Account");
			
			String[] Account = {AccountName, AccountNumber, AccountDescription};
			Utility_Libraries.fVerifyvalue(Account,logger);
			AccountName 			= Account[0];
			AccountNumber 		    = Account[1];
			AccountDescription      = Account[2];
			
			//--------------------------------------------------------------------------------
			SaleForce_Accounts objAccountClass = new SaleForce_Accounts(logger, driver, Extndreport);
			objAccountClass.Create_Accounts(AccountName,AccountNumber,AccountDescription);
		}
	
	@Test(priority=4,enabled=true)
	public void Contract_Create() throws Throwable
		{	
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			//---------------------------------Variables--------------------------------------
			String CustomerName 	    = Excel_Libraries.fRead("CustomerName", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String CustomerTitle 	    = Excel_Libraries.fRead("CustomerTitle", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String PriceBook            = Excel_Libraries.fRead("PriceBook", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String ContractMonth 	    = Excel_Libraries.fRead("ContractMonth", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String OwnerExpiration      = Excel_Libraries.fRead("OwnerExpiration", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String CompanySigned        = Excel_Libraries.fRead("CompanySigned", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			String DescriptionArea      = Excel_Libraries.fRead("DescriptionArea", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Contracts");
			
			String[] Contracts = {CustomerName, CustomerTitle, PriceBook, ContractMonth, OwnerExpiration,CompanySigned,DescriptionArea};
			Utility_Libraries.fVerifyvalue(Contracts,logger);
			CustomerName 			= Contracts[0];
			CustomerTitle 		    = Contracts[1];
			PriceBook            	= Contracts[2];
			ContractMonth 	        = Contracts[3];
			OwnerExpiration 		= Contracts[4];
			CompanySigned 			= Contracts[5];
			DescriptionArea 		= Contracts[6];
			
			//--------------------------------------------------------------------------------
			SaleForce_Contracts objContractClass = new SaleForce_Contracts(logger, driver, Extndreport);
			objContractClass.Create_Contracts(CustomerName,CustomerTitle,PriceBook,ContractMonth,OwnerExpiration,CompanySigned,DescriptionArea);
		}
	
	@Test(priority=5,enabled=true)
	public void Campaign_Create() throws Throwable
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			//---------------------------------Variables--------------------------------------
			String Name 	    = Excel_Libraries.fRead("Name", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Campaigns");
			String Expected_rev = Excel_Libraries.fRead("Expected_rev", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Campaigns");
			String Budget_cost  = Excel_Libraries.fRead("Budget_cost", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Campaigns");
			String Status_ 	    = Excel_Libraries.fRead("Status", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Campaigns");
			
			String[] Campaign = {Name, Expected_rev, Budget_cost,Status_};
			Utility_Libraries.fVerifyvalue(Campaign,logger);
			Name 			= Campaign[0];
			Expected_rev    = Campaign[1];
			Budget_cost 	= Campaign[2];
			Status_         = Campaign[3];
			//--------------------------------------------------------------------------------
			
			SaleForce_Campaign objCampaignClass = new SaleForce_Campaign(logger, driver, Extndreport);
			objCampaignClass.Create_Campaign(Name, Expected_rev, Budget_cost, "day", Status_);	
		
		}
	
	@Test(priority=6,enabled=true)
	public void Lead_Create() throws Throwable
		{	
		 	//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			//---------------------------------Variables--------------------------------------
			String FName 	    = Excel_Libraries.fRead("Fname", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Leads");
			String LName 	    = Excel_Libraries.fRead("Lname", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Leads");
			String CompanyName  = Excel_Libraries.fRead("CompanyName", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Leads");
			String Status 	    = Excel_Libraries.fRead("Status", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Leads");
			String Campaign     = Excel_Libraries.fRead("Status", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\data\\Data.xlsx", "Campaigns");
			
			String[] Leads = {FName, LName, CompanyName, Status, Campaign};
			Utility_Libraries.fVerifyvalue(Leads,logger);
			FName 			= Leads[0];
			LName 		    = Leads[1];
			CompanyName 	= Leads[2];
			Status 	        = Leads[3];
			Campaign 		= Leads[4];
			//--------------------------------------------------------------------------------
			
			SaleForce_Leads objLeadClass = new SaleForce_Leads(logger, driver, Extndreport);
			objLeadClass.Create_Leads(FName, LName, CompanyName, Status, Campaign);
		}
	
	@Test(priority=7,enabled=true)
	public void Logout() throws Throwable
		{
		
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
		
			SaleForce_Logout objLogoutClass =  new SaleForce_Logout(logger, driver, Extndreport);	
			objLogoutClass.Logout();
		}
	
	@AfterMethod	
	public void Flush(ITestResult result) throws Throwable		
		{
				if(result.getStatus()==ITestResult.FAILURE) 
				{ 			
					logger.log(LogStatus.FAIL,"Error :"+result.getThrowable());//+report.getClass()+" Test "+logger.getTest().statusMessage);//,ClassTest.takeScreenShot());			
				}		
				  if (result.getStatus() == ITestResult.FAILURE) {
			            logger.log(LogStatus.FAIL, "Test '"+ testName+ "' Failed : Cause>>"+result.getThrowable(),logger.addScreenCapture(Utility_Libraries.fScreenReport(driver)));
			            Excel_Libraries.fExcelReporter( ""+result.getThrowable()+"" , "Condition must be fullfill", "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date()));
			            Extndreport.endTest(logger);
			            Extndreport.flush();
			            System.exit(1);
				  	} else if (result.getStatus() == ITestResult.SKIP) {
			        	logger.log(LogStatus.SKIP, "Test '"+ testName+ "' skipped : Cause>>"+ result.getThrowable(),logger.addScreenCapture(Utility_Libraries.fScreenReport(driver)));
			        } else {
			        	logger.log(LogStatus.PASS, "Test  '"+ testName+"'  passed");
			        }	  
				  Extndreport.endTest(logger);
				  Extndreport.flush();
		}

	@AfterTest
	public void Close()
		{
			//----------------------------------------------Start report test-------------------------------------------------
			testName	= new Object(){}.getClass().getEnclosingMethod().getName();
			logger 		= Extndreport.startTest(testName);
			
			driver.close();
		}
}
