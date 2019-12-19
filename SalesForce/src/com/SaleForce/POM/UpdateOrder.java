package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class UpdateOrder {

	public By OrderTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderTab", "UpdateOrder"));
		return Source;
	}
	
	public By PopUpWindow() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("PopUpWindow", "UpdateOrder"));
		return Source;
	}
	
	public By View() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("View", "UpdateOrder"));
		return Source;
	}
	
	public By Go() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Go", "UpdateOrder"));
		return Source;
	}
	public By OrderList() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderList", "UpdateOrder"));
		return Source;
	}
}
