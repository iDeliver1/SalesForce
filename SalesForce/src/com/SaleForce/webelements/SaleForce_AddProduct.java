package com.SaleForce.webelements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_AddProduct {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	Utility_Libraries UtilityObject = new Utility_Libraries();
	
	public SaleForce_AddProduct(ExtentTest logger,WebDriver driver,ExtentReports Extndreport) {

		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}

	public void Product()
	{
		driver.findElement(By.xpath("//input[@name='addProd']")).click();
		
		List<WebElement> list_  = driver.findElements(By.xpath("//input[@name='addProd']"));
		for(int i=1;i<=list_.size();i++)
		{
			if(list_.get(i).getText().compareTo(""))
			{
				
			}
		}
	}
}
