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

	public void Login(String Username,String Password)
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='Login']")).click();
			try
			{
				driver.findElement(By.xpath("//input[@id='emc']")).isDisplayed();
				String Code = SaleForce_Login.Email_Verification(Username);
				driver.findElement(By.xpath("//input[@id='emc']")).sendKeys(Code);
				driver.findElement(By.xpath("//input[@id='save']")).click();
				driver.findElement(By.xpath("//div[@id='tabContainer']")).isDisplayed();
				
			}
			catch(Exception e)
			{
				try
				{
					driver.findElement(By.xpath("//div[@id='error']")).isDisplayed();
				}
				catch(Exception f)
				{
					
					//Fail
				}
			}
	}
	
	public static String Email_Verification(String Username)
	{
		WebDriver objdriver1 = Utility_Libraries.fgetBrowser("firefox");
		objdriver1.get("http://www.yopmail.com/en/");
		objdriver1.findElement(By.xpath("//input[@id='login']")).sendKeys("rpatestuser33@yopmail.com");
		objdriver1.findElement(By.xpath("//input[@type='submit']")).click();
		objdriver1.switchTo().frame(2);
		//Get the code from the email0
		String Code = objdriver1.findElement(By.xpath("//div[@id='mailmillieu']/div[2]")).getText();
		objdriver1.close();
		return Code.substring(290, 315).replaceAll("[^0-9]", "");
	}
}
