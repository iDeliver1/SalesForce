package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class Logout {

	public By Account() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Account", "Logout"));
		return Source;
	}
	
	public By Logout_() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Logout", "Logout"));
		return Source;
	}
	
}
