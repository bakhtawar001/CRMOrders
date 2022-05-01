package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class CreateOrderServices_WithTax extends OrdersExecution1 {

	//Developing new function for Services Functionality
		public static void Services_WithTax_TypeCredit() throws IOException, InterruptedException, ParseException{
		try
		{
			// This is to Instantiate Services  class  
			OrdersLocators Services = PageFactory.initElements(driver, OrdersLocators.class);	
			//Now click Services toggle
			List< WebElement> servicetoggle= driver.findElements(By.xpath("//button[contains(@class,'btn btn-default btn-sm dropdown-toggle')]"));
			servicetoggle.get(1).click();
			Thread.sleep(1000);	 
			//Click the Freight Option
			Services.OrderDetails_Service_Freight.click();
			Thread.sleep(2000);
			//Change the service type to credit 
			WebElement Servicetype=Services.OrderDetails_Service_Freight_Popup_ServiceType;
			Select dropdownValueServiceType= new Select(Servicetype);
			dropdownValueServiceType.selectByVisibleText("Credit");;
			Thread.sleep(1000);
			//Click the netcost field
			Services.OrderDetails_Service_Freight_Popup_Netcost.click();
			//Enter charges cost for freight
			Services.OrderDetails_Service_Freight_Popup_Netcost.sendKeys("50"); 
			//Press the save Button
			Services.OrderDetails_Service_Freight_Popup_SaveButton.click();
			waitForPageLoading();
			Thread.sleep(25000);    
			//Click the use current rates button
			Services.Orderdetails_UseCurrentRates_Button.click();
			waitForPageLoading();
			Thread.sleep(17000);
			//Converting TotalPrice from string to int
			Conversions.TotalPrice_String_To_Int_Conversion();   
			//Converting freight with credit service with tax
			Conversions.FreightNewPriceWithCreditService_String_To_Int_Conversion();  
			//Calculating freight service credit type tax
	        Conversions.CreditServiceTaxCalculation();   
			//Converting subtotal from string to int
	        Conversions.Subtotal_String_To_Int_Conversion();
	        //Sales Tax Conversion from String to integer with $ removing done 
			Conversions.SalesTax_String_To_Int_Conversion();
			//Calculating the SubTotal
			Conversions.SubTotal_Calculation();
			//Rounding off the value SubTotal and Sum tax
			Conversions.RoundingOffTotalAmount();	
			//Now Converting the Amountdue from string to Int
			Conversions.AmountDue_String_To_Int_Conversion();
			//Now Validating the Total Amount due 
			Assert.assertEquals(Conversions.bd.doubleValue(), Conversions.AmountDue);
		}
					     	   
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
			System.err.println("NoSuchElementException: " + e.getMessage());
		}
					
					
		}
			
	}



