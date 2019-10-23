package com.SaleForce.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Login {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	Utility_Libraries Utility_Object = new Utility_Libraries();
	
	public SaleForce_Login(ExtentTest logger,WebDriver driver, ExtentReports Extndreport) {
		
		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}

	public void Login(String Username,String Password) throws Throwable
	{
		try
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
			driver.findElement(By.xpath("//input[@id='Login']")).click();
				try
				{
					driver.findElement(By.xpath("//input[@id='emc']")).isDisplayed();
					String Code = this.Email_Verification(Username);
					driver.findElement(By.xpath("//input[@id='emc']")).sendKeys(Code);
					driver.findElement(By.xpath("//input[@id='save']")).click();
					driver.findElement(By.xpath("//div[@id='tabContainer']")).isDisplayed();
					Utility_Object.fReportpass("", "", logger);
				}
				catch(Exception e)
				{
					try
					{
						driver.findElement(By.xpath("//div[@id='error']")).isDisplayed();
					}
					catch(Exception f)
					{
						Utility_Object.fReportfail("Login failed", "Error : Please check your username and password. If you still can't log in, contact your Salesforce administrator.", logger, driver, Extndreport);
					}
				}	
		}
		catch(Exception G)
		{
			Utility_Object.fReportfail("", "", logger, driver, Extndreport);
		}
	}
	
	public String Email_Verification(String Username) throws Throwable
	{
		WebDriver objdriver1 = Utility_Libraries.fgetBrowser("firefox");
		objdriver1.get("http://www.yopmail.com/en/");
			try
			{
				objdriver1.findElement(By.xpath("//input[@id='login']")).sendKeys(Username);
				objdriver1.findElement(By.xpath("//input[@type='submit']")).click();
				objdriver1.switchTo().frame(2);
				//Get the code from the email0
				String Code = objdriver1.findElement(By.xpath("//div[@id='mailmillieu']/div[2]")).getText();
				objdriver1.close();
				Code = Code.substring(290, 315).replaceAll("[^0-9]", "");
				Utility_Object.fReportpass("Email_Verification", "Code has been successfully retrive " + Code, logger);
				return Code;
			}
			catch(Exception e)
			{
				Utility_Object.fReportfail("Email_Verification Failed", "Error : " + e, logger, driver, Extndreport);
			}
		return null;
	}
}
