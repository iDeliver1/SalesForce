package com.SaleForce.POM;

import org.openqa.selenium.By;
import com.SaleForce.libraries.Utility_Libraries;

public class Login {
	
	public By Username() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Username", "Login"));
		return Source;
	}
	
	public By Password() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Password", "Login"));
		return Source;
	}

	public By Signin() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Signin", "Login"));
		return Source;
	}
	
	public By OTPText() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("OTPText", "Login"));
		return Source;
	}
	
	public By Save() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save", "Login"));
		return Source;
	}

	public By Tab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Tab", "Login"));
		return Source;
	}
	
	public By UserError() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("UserError", "Login"));
		return Source;
	}
	
	public By YopUser() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("YopUser", "Login"));
		return Source;
	}

	public By YopSubmit() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("YopSubmit", "Login"));
		return Source;
	}
	
	public By Message() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Message", "Login"));
		return Source;
	}
}
