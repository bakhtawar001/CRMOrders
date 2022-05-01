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

public class ManualSalesTax_Calculation extends OrdersExecution1 {

	public static void ManualSalesTax_Calculation_Order() throws IOException, InterruptedException, ParseException{
	try
	{
		// This is to Instantiate CreateOrders  class  
	   	 OrdersLocators ManualSalesTax = PageFactory.initElements(driver, OrdersLocators.class);
	 	Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();",ManualSalesTax.Settings_SalesTax_EditTaxButton);
	    ManualSalesTax.Settings_SalesTax_EditTaxButton.click();
	    Thread.sleep(1000); 
		Input("Please enter Quantity", ManualSalesTax.Settings_SalesTax_EditTaxField, "5");
		Thread.sleep(1000);
		Thread.sleep(1000);	 
		if(!ManualSalesTax .ChargeTaxOnShipping_Checkbox.isSelected())
		    {
		    	ManualSalesTax.ChargeTaxOnShipping_Checkbox.click();
		    	
		    	Thread.sleep(4000);
		    }
		   	 
		   	//Now Press the save button
		    ManualSalesTax .Settings_SalesTax_EditTaxField_SaveButton.click();
		   	Thread.sleep(2000);
		   	//Click the Order tab
		   	ManualSalesTax.ESPWebHomePage_OrdersTab.click();
		   	ManualSalesTax.OrderlistingSearch.sendKeys(Conversions.Orderno);
		   	Thread.sleep(7000);
		   	//Select existing created order from Top of the list
		   	ManualSalesTax.OrderListing_Orderselection.click();
		   	waitForPageLoading();
		   	Thread.sleep(2000);
		   	//click the current rates button
		   	ManualSalesTax.Orderdetails_UseCurrentRates_Button.click();
		   	waitForPageLoading();
		   	Thread.sleep(30000);
	
		   	//Converting subtotal from string to int
		   	Conversions.Subtotal_String_To_Int_Conversion();
	   	 
		   	//Calculating Tax	
	   	 
		   	Conversions.Tax_Calculation_Manual();
	   	 
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
		catch(NoSuchElementException e){
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
		}
		
}  

	
		}
	
	
