package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateCampaign {

	public By Tab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Tab", "Campaign"));
		return Source;
	}
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Campaign"));
		return Source;
	}
	
	public By Name() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Name", "Campaign"));
		return Source;
	}
	
	public By Status() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Status", "Campaign"));
		return Source;
	}
	
	public By S_Date() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("S_Date", "Campaign"));
		return Source;
	}
	
	public By E_Date() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("E_Date", "Campaign"));
		return Source;
	}
	
	public By Expected_rev() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Expected_rev", "Campaign"));
		return Source;
	}
	
	public By Budget_cost() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Budget_cost", "Campaign"));
		return Source;
	}
	
	public By Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save", "Campaign"));
		return Source;
	}
	
	public By HeadName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("HeadName", "Campaign"));
		return Source;
	}
	
	public By Close() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Close", "Login"));
		return Source;
	}
}
