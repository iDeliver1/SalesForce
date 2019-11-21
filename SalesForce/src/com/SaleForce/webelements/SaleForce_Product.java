package com.SaleForce.webelements;

import org.openqa.selenium.WebDriver;
import com.SaleForce.POM.CreateProduct;
import com.SaleForce.libraries.Utility_Libraries;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class SaleForce_Product {

	WebDriver driver;
	ExtentTest logger;
	ExtentReports Extndreport;
	Utility_Libraries Utility_Object = new Utility_Libraries();
	CreateProduct CreateProductPOM = new CreateProduct();
	
	public SaleForce_Product(ExtentTest logger,WebDriver driver, ExtentReports Extndreport) {

		this.driver = driver;
		this.logger = logger;
		this.Extndreport = Extndreport;
	}

	public String Create_Product(String Product_Name, String Product_Code) throws Throwable
	{
		try
		{
			driver.findElement(CreateProductPOM.Tab()).click();
			driver.findElement(CreateProductPOM.New()).click();
			driver.findElement(CreateProductPOM.Product_Name()).sendKeys(Product_Name);
			driver.findElement(CreateProductPOM.Product_Code()).sendKeys(Product_Code);
			driver.findElement(CreateProductPOM.Save()).click();
			String Product = driver.findElement(CreateProductPOM.Verify()).getText();
				if(Product.contains(Product_Name))
				{
					//-----------------------------Reporter
					Utility_Object.fReportpass("Create Product", "product has been successfully created " + Product, logger, driver);
					//------------------------------------
					return Product;
				}
				else
				{
					//-----------------------------Reporter
					Utility_Object.fReportfail("Create Product", "product has been not successfully created", logger, driver, Extndreport);
					//------------------------------------
				}
		}
		catch(Exception e)
		{
			//-----------------------------Reporter
			Utility_Object.fReportfail("Error", "Error :" + e , logger, driver, Extndreport);
			//------------------------------------
		}
	return null;
	}
}
