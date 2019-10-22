package com.SaleForce.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
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
	}
	
	public void Email_Verification(String Username)
	{
		String Parent = driver.getWindowHandle();
		WebDriver objdriver = Utility_Libraries.getBrowser("internetexplore");
		objdriver.get("http://www.yopmail.com/en/");
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		driver.findElement(By.xpath("//input[@id='ecm']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='save']")).click();
		
		
	}
}
