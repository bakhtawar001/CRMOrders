package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class ShippingTaxCalculations_Verification_WithoutTaxes extends OrdersExecution1 {

	public static void ShippingTax_Calculation_Order_WithDisablingTax() throws IOException, InterruptedException, ParseException{
	try
	{
		// This is to Instantiate CreateOrders  class  
	   	 OrdersLocators ManualSalesTax = PageFactory.initElements(driver, OrdersLocators.class);
	
	   	 Thread.sleep(1000);
	   	JavascriptExecutor js = (JavascriptExecutor) driver;
	   	js.executeScript("arguments[0].scrollIntoView();",ManualSalesTax.ESPWebHomePage_OrdersTab);
	   	 //Click the Orders tab
	     ManualSalesTax.ESPWebHomePage_OrdersTab.click();
	     
	    // waitForPageLoading();
	     
	     Thread.sleep(8000);

		 //Click the Order tab
	   	 ManualSalesTax.ESPWebHomePage_OrdersTab.click();
	   	 
	   	 //Search the OrderNo 	 
	   	 ManualSalesTax.OrderlistingSearch.sendKeys(Conversions.Orderno);
		 Thread.sleep(7000);
	   	 //Select existing created order from Top of the list
	   	 ManualSalesTax.OrderListing_Orderselection.click();
	   	 waitForPageLoading();
	   	 Thread.sleep(8000);
	   	 
	   	 //click the current rates button
	   	 ManualSalesTax.Orderdetails_UseCurrentRates_Button.click();
	   	 waitForPageLoading();
	   	 Thread.sleep(22000);
	   	 //Converting subtotal from string to int
	   	 Conversions.Subtotal_String_To_Int_Conversion();
	   	 
	    //Converting TotalPrice from string to int
	   	 Conversions.TotalPrice_String_To_Int_Conversion();
	   	 
	   	 //Calculating Tax	
	   	 
	     Conversions.ServicesCalculation_WithTaxes();
	   	 
	     //Sales Tax Conversion from String to integer with $ removing done 
	   	 
	     Conversions.SalesTax_String_To_Int_Conversion();
	   	
	   //Calculating the SubTotal
	   	 
	   	 Conversions.SubTotal_Calculation();
	   	 
	   //Rounding off the value SubTotal and Sum tax
	   	 Conversions.RoundingOffTotalAmount();
	   	
	   //Now Converting the Amountdue from string to Int
	   	Conversions.AmountDue_String_To_Int_Conversion();

	   	
	   //Now Validating the Total Amount due 
	   	Assert.assertEquals(Conversions.bd.doubleValue(),Conversions.AmountDue);
		}
		catch(NoSuchElementException e){
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
		}
	}
	}
