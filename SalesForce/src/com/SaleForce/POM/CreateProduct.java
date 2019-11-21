package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateProduct {

	public By Tab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Tab", "Product"));
		return Source;
	}
	
	public By PopUpWindow() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("PopUpWindow", "Product"));
		return Source;
	}
	
	public By Product_Name() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Product_Name", "Product"));
		return Source;
	}	
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Product"));
		return Source;
	}
	
	public By Product_Code() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Product_Code", "Product"));
		return Source;
	}
	
	public By Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save", "Product"));
		return Source;
	}	
	
	public By ActiveCheck() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ActiveCheck", "Product"));
		return Source;
	}
	
	public By Verify() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Verify", "Product"));
		return Source;
	}
}
