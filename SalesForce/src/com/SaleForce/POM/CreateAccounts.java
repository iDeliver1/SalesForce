package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateAccounts {

	public By AccoutTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccoutTab", "Account"));
		return Source;
	}	
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Account"));
		return Source;
	}

}
