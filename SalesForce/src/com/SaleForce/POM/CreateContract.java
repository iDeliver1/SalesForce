package com.SaleForce.POM;

import org.openqa.selenium.By;

import com.SaleForce.libraries.Utility_Libraries;

public class CreateContract {

	public By ContractTab() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("ContractTab", "Contracts"));
		return Source;
	}	
	
	public By NewLink() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("New_Link", "Contracts"));
		return Source;
	}
	
	public By CustomerName() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Customer_Name", "Contracts"));
		return Source;
	}
	
	public By CustomerSigned() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Customer_Signed", "Contracts"));
		return Source;
	}
	
	public By CustomerTitle() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Customer_Title", "Contracts"));
		return Source;
	}
	
	public By CustomerDate() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Customer_Date", "Contracts"));
		return Source;
	}
	
	public By PriceBook() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Price_Book", "Contracts"));
		return Source;
	}
	
	public By ContractDate() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Contract_Date", "Contracts"));
		return Source;
	}
	
	public By ContractMonth() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Contract_Month", "Contracts"));
		return Source;
	}
	
	public By OwnerExpirationNotice() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Owner_Expiration_Notice", "Contracts"));
		return Source;
	}
	
	public By CompanySigned() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Company_Signed", "Contracts"));
		return Source;
	}
	
	public By SaveButton() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Save_Button", "Contracts"));
		return Source;
	}
	
	public By PopUpWindow() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("PopUpWindow", "Contracts"));
		return Source;
	}
	
	public By DescriptionArea() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("Description_Area", "Contracts"));
		return Source;
	}
	
	public By PageDescription() throws Throwable
	{
		By Source = By.xpath(Utility_Libraries.fGetElement("PageDescription", "Contracts"));
		return Source;
	}
	
}
