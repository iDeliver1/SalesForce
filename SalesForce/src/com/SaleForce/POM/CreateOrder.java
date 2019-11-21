package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateOrder {
	
	public By OrderTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderTab", "Orders"));
		return Source;
	}
	
	public By AccountName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccountName", "Orders"));
		return Source;
	}
	
	public By OrderStartDate() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderStartDate", "Orders"));
		return Source;
	}
	
	public By ContractNumber() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ContractNumber", "Orders"));
		return Source;
	}
	
	public By OrderDescription() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderDescription", "Orders"));
		return Source;
	}
	
	public By OrderSaveButton() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderSaveButton", "Orders"));
		return Source;
	}
	
	public By OrderNumber() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OrderNumber", "Orders"));
		return Source;
	}
	
	public By PopUpWindow() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("PopUpWindow", "Orders"));
		return Source;
	}
	
	public By NewLink() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("NewLink", "Orders"));
		return Source;
	}
		
}
