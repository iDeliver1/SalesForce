package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateContract {

	public By ContractTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ContractTab", "Contracts"));
		return Source;
	}	
	
	public By NewLink() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New_Link", "Contracts"));
		return Source;
	}

}
