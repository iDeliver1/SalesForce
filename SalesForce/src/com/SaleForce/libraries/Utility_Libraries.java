package com.SaleForce.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utility_Libraries {

	public static WebDriver driver;
	static String Folder_path = System.getProperty("user.dir")+"\\src\\Test_Result\\Report"+Utility_Libraries.Time_stamp();
	static String Excel_path = Folder_path+"\\Excelreport"+Utility_Libraries.Time_stamp()+".xls";

  public static WebDriver getBrowser(String strBrowserName)
	{
		switch(strBrowserName.toLowerCase())
		{	
		//launch in firefox
		case "firefox":
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\Drivers\\geckodrivers.exe");
		driver=new FirefoxDriver();
		break;
		//------------------------------------------------
		//launch in chrome
		case "chrome":
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
		//------------------------------------------------		
		//launch in internetexplore
		case "internetexplore":
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\Drivers\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		//------------------------------------------------
		default:
			System.out.println("Driver is not found "+strBrowserName);
		}
		return driver;
	}
	
	public static ExtentReports Report()
	{	
	 	ExtentReports report1 = new ExtentReports(Folder_path+"\\Test"+Utility_Libraries.Time_stamp()+".html");
		report1.addSystemInfo("Java version", "JDK 8");
		report1.addSystemInfo("Machine", "SourabhLaptop");
		report1.config().documentTitle("Sourabh");
		report1.config().reportHeadline("Selenium");
		report1.config().reportName("Automation");
		return report1;
	}
	
   public static String Time_stamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}
	    
   public static String Screen_Report(WebDriver driver) throws Throwable
	{
    	File source_image = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String Image_path = Folder_path+"\\Screeshot"+Utility_Libraries.Time_stamp()+".png";
		File Desti_image = new File(Image_path);
		FileUtils.copyFile(source_image,Desti_image);
		return ""+Desti_image;
	}

   public static String GetElement(String Keys,String FileName) throws Throwable
	{
		FileInputStream pagobj =null;
		Properties obj = new Properties();
		try
		{ 
			pagobj = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\FK\\properties\\" + FileName + ".properties");	
		}
		catch (Exception e) 
		{	
			System.out.println("File is not found");
		}
			obj.load(pagobj);
			return obj.getProperty(Keys);
	}
   
   public static String[] Verify_value(String[] Array,ExtentTest logger)
   {
	   for(int i=0;i<=Array.length-1;i++)
	   {
		   Assert.assertNotNull(Array[i].toString(), "Value is present");
		   logger.log(LogStatus.PASS,Array[i].toString(), "Value is present");
	   }
	   return Array;
   }
   public void Report_pass(String Step_details,String Actual,ExtentTest logger) throws Throwable
	{
		  //===========================Reporter======================================================================================
		  //=========================================================================================================================
	      logger.log(LogStatus.PASS,Step_details,Actual);
	      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_Libraries.Screen_Report(driver)));
	      Excel_Libraries.Excel_Reporter(Step_details,Actual, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		  //=========================================================================================================================
		  //=========================================================================================================================
	}
	
	public void Report_fail(String Step_details,String Actual,ExtentTest logger,WebDriver driver,ExtentReports Extndreport) throws Throwable
	{
		  //===========================Reporter=====================================================================================
		  //========================================================================================================================
	      logger.log(LogStatus.FAIL,Step_details,Actual);
	      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_Libraries.Screen_Report(driver)));
	      Excel_Libraries.Excel_Reporter(Step_details,Actual, "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
	      Extndreport.endTest(logger);
	      Extndreport.flush();
	      driver.close();
	      System.exit(0);
		  //========================================================================================================================
		  //========================================================================================================================
	}

}
