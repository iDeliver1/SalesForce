package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateLead {

	public By LeadTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("LeadTab", "Leads"));
		return Source;
	}
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Leads"));
		return Source;
	}
	
	public By FName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("FName", "Leads"));
		return Source;
	}
	
	public By LName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("LName", "Leads"));
		return Source;
	}
	
	public By CompanyName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("CompanyName", "Leads"));
		return Source;
	}
	
	public By Close() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Close", "Leads"));
		return Source;
	}
	
	public By Status() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Status", "Leads"));
		return Source;
	}
	
	public By Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save", "Leads"));
		return Source;
	}
	
	public By HeadName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("HeadName", "Leads"));
		return Source;
	}
}
