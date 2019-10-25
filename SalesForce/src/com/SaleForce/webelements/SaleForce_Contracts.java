package com.SaleForce.webelements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Contracts {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	
	public SaleForce_Contracts(ExtentTest logger,WebDriver driver,ExtentReports Extndreport)
	{
		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}
	
	public void Create_Contracts()
	{
			driver.findElement(By.xpath("//li[@id='Contract_Tab']//a[contains(text(),'Contracts')]")).click();
		 	driver.findElement(By.xpath("//input[@name='new']")).click();
	        driver.findElement(By.xpath("//input[@id='ctrc7']")).sendKeys("Amazon");
	        driver.findElement(By.xpath("//input[@id='ctrc16']")).sendKeys("ABC Company");
	        driver.findElement(By.xpath("//input[@id='CustomerSignedTitle']")).sendKeys("NewContract");
	        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	        Date dateobj = new Date();
	        System.out.println(df.format(dateobj));
			driver.findElement(By.xpath("//input[@id='ctrc6']")).sendKeys(df.format(dateobj));
			Select priceBook = new Select(driver.findElement(By.xpath("//select[@id='ctrc17']")));
			priceBook.selectByVisibleText("Standard");
			driver.findElement(By.xpath("//input[@id='ctrc5']")).sendKeys(df.format(dateobj));
			driver.findElement(By.xpath("//input[@id='ctrc40']")).sendKeys("12");
			driver.findElement(By.xpath("//input[@id='CompanySigned']")).sendKeys("Chris Carpenter");
			
			//-------------------------Billing Address----------------------------------------//
			driver.findElement(By.xpath("//textarea[@id='ctrc25street']")).sendKeys("Uslapur");
			driver.findElement(By.xpath("//input[@id='ctrc25state']")).sendKeys("Chhattisgarh");
			driver.findElement(By.xpath("//input[@id='ctrc25country']")).sendKeys("India");
			driver.findElement(By.xpath("//textarea[@id='Description']")).sendKeys("This is contract");
			driver.findElement(By.xpath("//div[contains(@class,'pbBottomButtons')]//input[1]")).click();
	}

}
