package com.SaleForce.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RunTest {


	@Test
	public void Test111() throws Exception {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\iDeliver20\\Desktop\\Driver\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://login.salesforce.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rpatestuser31@yopmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Cloud_123");
		driver.findElement(By.xpath(" //input[@id='Login']")).click();
		
		/*List<WebElement> elements = driver.findElements(By.xpath("//ul[@id='tabBar']"));
        System.out.println("Test1 number of elements: " + elements.size()); */
        driver.findElement(By.xpath("//li[@id='Contract_Tab']//a[contains(text(),'Contracts')]")).click();
        driver.findElement(By.xpath("//input[@name='new']")).click();
        driver.findElement(By.xpath("//input[@id='ctrc7']")).sendKeys("Arti Sahu");
        driver.findElement(By.xpath("//input[@id='ctrc16']")).sendKeys("ABCCompany");
        driver.findElement(By.xpath("//input[@id='CustomerSignedTitle']")).sendKeys("NewContract");
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date dateobj = new Date();
        System.out.println(df.format(dateobj));
		driver.findElement(By.xpath("//input[@id='ctrc6']")).sendKeys(df.format(dateobj));
		Select priceBook = new Select(driver.findElement(By.xpath("//select[@id='ctrc17']")));
		priceBook.selectByVisibleText("Standard");
		driver.findElement(By.xpath("//input[@id='ctrc40']")).sendKeys("12");
		//input[@id='ctrc5']
		
		
			
	}
}
