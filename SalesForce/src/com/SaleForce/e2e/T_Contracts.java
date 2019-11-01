package com.SaleForce.e2e;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.SaleForce.libraries.Excel_Libraries;
import com.SaleForce.libraries.Utility_Libraries;
import com.SaleForce.webelements.SaleForce_Contracts;
import com.SaleForce.webelements.SaleForce_Login;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class T_Contracts {
	
	WebDriver driver;						
	ExtentTest logger;						
	ExtentReports Extndreport;  			
	String testName = T_Contracts.class.getName();

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
		public void Contract_Create() throws Throwable
		{	
			SaleForce_Contracts objContractClass = new SaleForce_Contracts(logger, driver, Extndreport);
			objContractClass.Create_Contracts();
		}
		
		@Test(priority=4,enabled=true)
		public void Close()
			{
				//----------------------------------------------Start report test-------------------------------------------------
				testName	= new Object(){}.getClass().getEnclosingMethod().getName();
				logger 		= Extndreport.startTest(testName);
				
				driver.close();
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
		
		
}
