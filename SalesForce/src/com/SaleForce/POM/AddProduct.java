package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class AddProduct {

	public By AddProduct_() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AddProduct_", "AddProduct"));
		return Source;
	}
		
	public By ProductName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ProductName", "AddProduct"));
		return Source;
	}
	
	public By CheckBox() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("CheckBox", "AddProduct"));
		return Source;
	}	
	
	public By ProSelect() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ProSelect", "AddProduct"));
		return Source;
	}
	
	public By Quantity() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Quantity", "AddProduct"));
		return Source;
	}
	
	public By Save_() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save_", "AddProduct"));
		return Source;
	}
	
	public By EditAll() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("EditAll", "AddProduct"));
		return Source;
	}
}
