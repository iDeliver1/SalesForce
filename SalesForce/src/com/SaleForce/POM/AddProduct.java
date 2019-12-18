package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class AddProduct {

	public By AddProduct_() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AddProduct_", "Account"));
		return Source;
	}
		
	public By ProductName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ProductName", "Account"));
		return Source;
	}
	
	public By CheckBox() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("CheckBox", "Account"));
		return Source;
	}	
	
	public By ProSelect() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ProSelect", "Account"));
		return Source;
	}
	
	public By Quantity() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Quantity", "Account"));
		return Source;
	}
	
	public By Save_() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save_", "Account"));
		return Source;
	}
	
	public By EditAll() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("EditAll", "Account"));
		return Source;
	}
}
