package com.SaleForce.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.SaleForce.webelements.SaleForce_Leads;
import com.SaleForce.webelements.SaleForce_Login;

public class Test_Run {

	@Test
	public void Run()
	{
		WebDriver objdriver = new FirefoxDriver();
		objdriver.get("https://login.salesforce.com/");
		
		SaleForce_Login objLoginClass = new SaleForce_Login(null, objdriver, null);
		objLoginClass.Login("rpatestuser33@yopmail.com", "Cloud_123");
		
		SaleForce_Leads objLeadClass = new SaleForce_Leads(null, objdriver, null);
		objLeadClass.Create_Leads();
	}

}
