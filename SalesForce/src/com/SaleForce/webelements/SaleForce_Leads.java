package com.SaleForce.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Leads {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	
	public SaleForce_Leads(ExtentTest logger,WebDriver driver, ExtentReports Extndreport) {

		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}

	public void Create_Leads()
	{
		driver.findElement(By.xpath("//li[@id='Lead_Tab']")).click();
		driver.findElement(By.xpath("//input[@name='new']")).click();
		driver.findElement(By.xpath("//input[@id='name_firstlea2']")).sendKeys("sou");
		driver.findElement(By.xpath("//input[@id='name_lastlea2']")).sendKeys("cha");
		driver.findElement(By.xpath("//input[@id='lea3']")).sendKeys("ideliver");
		Select Status = new Select( driver.findElement(By.xpath("//select[@id='lea13']")));
		Status.selectByValue("Working - Contacted");
		driver.findElement(By.xpath("//td[@id='bottomButtonRow']/input[@title='Save']")).click();
		String LeadName = driver.findElement(By.xpath("//div[@class='textBlock']/h2")).getText();
		WebDriverWait wait = new WebDriverWait(driver,6);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='textBlock']/h2")));
		System.out.println(LeadName);
	}
	
}
