package com.SaleForce.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
						//-----------------------------Reporter
						Utility_Object.fReportpass("OTP Code", "5 digit code have been successfully write", logger, driver);
						//------------------------------------
					driver.findElement(By.xpath("//input[@id='save']")).click();
					WebDriverWait wait = new WebDriverWait(driver,6);
					wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='tabContainer']")));
					driver.findElement(By.xpath("//div[@id='tabContainer']")).isDisplayed();
						//-----------------------------Reporter
						Utility_Object.fReportpass("Login Pass", "User is successfully logged in SaleForce", logger, driver);
						//------------------------------------
				}
				catch(Exception e)
				{
					try
					{
						driver.findElement(By.xpath("//div[@id='error']")).isDisplayed();
					}
					catch(Exception f)
					{
						//-----------------------------Reporter
						Utility_Object.fReportfail("Login failed", "Error : Please check your username and password. If you still can't log in, contact your Salesforce administrator.", logger, driver, Extndreport);
						//------------------------------------
					}
				}	
		}
		catch(Exception G)
		{
			//-----------------------------Reporter
			Utility_Object.fReportfail("Login failed", "Error : " + G, logger, driver, Extndreport);
			//------------------------------------
		}
	}
	
	public String Email_Verification(String Username) throws Throwable
	{
		WebDriver objdriver1 = null;
		objdriver1 = Utility_Libraries.fgetBrowser("firefox", objdriver1);
		objdriver1.get("http://www.yopmail.com/en/");
			try
			{
				objdriver1.findElement(By.xpath("//input[@id='login']")).sendKeys(Username);
				objdriver1.findElement(By.xpath("//input[@type='submit']")).click();
				objdriver1.switchTo().frame(2);
				//Get the code from the email0
				String Code = objdriver1.findElement(By.xpath("//div[@id='mailmillieu']/div[2]")).getText();
				Code = Code.substring(290, 315).replaceAll("[^0-9]", "");
					//-----------------------------Reporter
					Utility_Object.fReportpass("Email_Verification", "Code has been successfully retrive " + Code, logger, objdriver1);
					//------------------------------------
				objdriver1.close();
				return Code;
			}
			catch(Exception e)
			{
				//-----------------------------Reporter
				Utility_Object.fReportfail("Email_Verification Failed", "Error : " + e, logger, objdriver1, Extndreport);
				//------------------------------------
			}
		return null;
	}
}
