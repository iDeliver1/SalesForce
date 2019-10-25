package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateLead {

	public By LeadTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("LeadTab", "Login"));
		return Source;
	}
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Login"));
		return Source;
	}
	
	public By FName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("FName", "Login"));
		return Source;
	}
	
	public By LName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("LName", "Login"));
		return Source;
	}
	
	public By CompanyName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("CompanyName", "Login"));
		return Source;
	}
	
	public By Close() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Close", "Login"));
		return Source;
	}
	
	public By Status() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Status", "Login"));
		return Source;
	}
	
	public By Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save", "Login"));
		return Source;
	}
	
	public By HeadName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("HeadName", "Login"));
		return Source;
	}
}
