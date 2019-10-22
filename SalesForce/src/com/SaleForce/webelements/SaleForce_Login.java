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
				driver.findElement(By.xpath("//input[@id='ecm']")).isDisplayed();
				String Code = SaleForce_Login.Email_Verification(Username);
				driver.findElement(By.xpath("//input[@id='ecm']")).sendKeys(Code);
				driver.findElement(By.xpath("//input[@id='save']")).click();
			}
			catch(Exception e)
			{
				try
				{
					driver.findElement(By.xpath("//div[@id='error']")).isDisplayed();
					//Fail
				}
				catch(Exception f)
				{
					driver.findElement(By.xpath("//div[@id='tabContainer']")).isDisplayed();
					//Pass
				}
			}
	}
	
	public static String Email_Verification(String Username)
	{
		WebDriver objdriver = Utility_Libraries.getBrowser("internetexplore");
		objdriver.get("http://www.yopmail.com/en/");
		objdriver.findElement(By.xpath("//input[@id='login']")).sendKeys("rpatestuser33@yopmail.com");
		objdriver.findElement(By.xpath("//input[@type='submit']")).click();
		objdriver.switchTo().frame(2);
		//Get the code from the email0
		String Code = objdriver.findElement(By.xpath("//div[@id='mailmillieu']/div[2]")).getText();
		objdriver.close();
		return Code.substring(290, 315).replaceAll("[^0-9]", "");
	}
}
