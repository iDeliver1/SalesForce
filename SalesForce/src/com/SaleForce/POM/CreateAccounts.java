package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;


public class CreateAccounts {

	public By AccoutTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccoutTab", "Account"));
		return Source;
	}	
	
	public By New() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New", "Account"));
		return Source;
	}
	
	public By AccountName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccountName", "Account"));
		return Source;
	}
	
	public By AccountNumber() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccountNumber", "Account"));
		return Source;
	}
	
	public By Account_Description() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccountDescription", "Account"));
		return Source;
	}
	
	public By Account_Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Account_Save", "Account"));
		return Source;
	}
	
	public By AccountVerification() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("AccountVerification", "Account"));
		return Source;
	}

}
