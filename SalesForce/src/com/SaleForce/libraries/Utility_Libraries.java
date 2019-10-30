package com.SaleForce.libraries;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

	static String Report_Folder_path = "C:\\Reporting\\Report"+Utility_Libraries.fTimestamp();
	static String Report_Excel_path = Report_Folder_path+"\\Excelreport"+Utility_Libraries.fTimestamp()+".xls";

  public static WebDriver fgetBrowser(String strBrowserName, WebDriver driver)
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
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		break;
		//------------------------------------------------		
		//launch in internetexplore
		case "internetexplore":
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\driver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		
		case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\com\\SaleForce\\driver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		//------------------------------------------------
		default:
			System.out.println("Driver is not found "+strBrowserName);
		}
		return driver;
	}
	
	public static ExtentReports fReport()
	{	
	 	ExtentReports report1 = new ExtentReports(Report_Folder_path+"\\Test"+Utility_Libraries.fTimestamp()+".html");
		report1.addSystemInfo("Java version", "JDK 8");
		report1.addSystemInfo("Machine", "SourabhLaptop");
		report1.config().documentTitle("Sourabh");
		report1.config().reportHeadline("Selenium");
		report1.config().reportName("Automation");
		return report1;
	}
	
   public static String fTimestamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}
	 
   public static String fScreenReport(WebDriver scrdriver) throws Throwable
	{
    	File source_image = ((TakesScreenshot)scrdriver).getScreenshotAs(OutputType.FILE);
		String Image_path = Report_Folder_path+"\\Screeshot"+Utility_Libraries.fTimestamp()+".png";
		File Desti_image = new File(Image_path);
		FileUtils.copyFile(source_image,Desti_image);
		return ""+Desti_image;
	}

   public static String fGetElement(String Keys,String FileName) throws Throwable
	{
		FileInputStream pagobj =null;
		Properties obj = new Properties();
		try
		{ 
			pagobj = new FileInputStream (System.getProperty("user.dir")+"\\src\\com\\SaleForce\\properties\\" + FileName + ".properties");
		}
		catch (Exception e) 
		{	
			System.out.println("File is not found");
		}
			obj.load(pagobj);
			return obj.getProperty(Keys);
	}
   
   public static String[] fVerifyvalue(String[] Array,ExtentTest logger)
   {
	   for(int i=0;i<=Array.length-1;i++)
	   {
		   Assert.assertNotNull(Array[i].toString(), "Value is present");
		   logger.log(LogStatus.PASS,Array[i].toString(), "Value is present");
	   }
	   return Array;
   }
   public void fReportpass(String Step_details,String Actual,ExtentTest logger, WebDriver repdriver) throws Throwable
	{
		  //===========================Reporter======================================================================================
		  //=========================================================================================================================
	      logger.log(LogStatus.PASS,Step_details,Actual);
	      logger.log(LogStatus.PASS,logger.addScreenCapture(Utility_Libraries.fScreenReport(repdriver)));
	      Excel_Libraries.fExcelReporter(Step_details,Actual, "PASS",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
		  //=========================================================================================================================
		  //=========================================================================================================================
	}
	
	public void fReportfail(String Step_details,String Actual,ExtentTest logger,WebDriver repdriver,ExtentReports Extndreport) throws Throwable
	{
		  //===========================Reporter=====================================================================================
		  //========================================================================================================================
	      logger.log(LogStatus.FAIL,Step_details,Actual);
	      logger.log(LogStatus.FAIL,logger.addScreenCapture(Utility_Libraries.fScreenReport(repdriver)));
	      Excel_Libraries.fExcelReporter(Step_details,Actual, "FAIL",""+new SimpleDateFormat("MM_dd_y_hhmmssa").format(new Date(0)));
	      Extndreport.endTest(logger);
	      Extndreport.flush();
	      repdriver.close();
	      System.exit(0);
		  //========================================================================================================================
		  //========================================================================================================================
	}
	
	public String fGetCurrentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = dateformat.format(date); 
	    return strDate;
	}
	
	public String fAddDate(String strDate, int Num, String Condition) throws ParseException
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		Calendar calender = Calendar.getInstance();
		calender.setTime(dateformat.parse(strDate));
			if(Condition.equalsIgnoreCase("year"))
			{
				calender.add(Calendar.DAY_OF_YEAR, Num);
			}
			else if (Condition.equalsIgnoreCase("month")) 
			{
				calender.add(Calendar.MONTH, Num);
			}
			else if (Condition.equalsIgnoreCase("day")) 
			{
				calender.add(Calendar.DAY_OF_MONTH, Num);
			}
		String newDate = dateformat.format(calender.getTime());
		return newDate;
	}
}
