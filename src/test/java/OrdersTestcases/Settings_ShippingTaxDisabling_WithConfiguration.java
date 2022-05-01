package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class Settings_ShippingTaxDisabling_WithConfiguration extends OrdersExecution1 {

	public static void AutomaticShippingTax_Uncheck() throws IOException, InterruptedException{
	try
	{
		// This is to Instantiate Services  class  
		OrdersLocators Settings_ShippingTax = PageFactory.initElements(driver, OrdersLocators.class);	
		//Now Applying Manual Tax Rate Scenario
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",Settings_ShippingTax.CloseOrder_Icon);
		js.executeScript("arguments[0].click();",Settings_ShippingTax.CloseOrder_Icon);
		//Settings_ShippingTax.CloseOrder_Icon.click();
		Thread.sleep(10000);
		//Click the userInfoIcon on My Order screen	 
		Settings_ShippingTax.OrderListing_UserInfoIcon.click();
		//Click the settings option
		Settings_ShippingTax.UserInfoIcon_Settings.click();
		//Now Select the sales tax option in settings
		Settings_ShippingTax.Settings_SalesTax.click();
		Thread.sleep(5000);
	 if(Settings_ShippingTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
   	 {
   		Settings_ShippingTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
   		Assert.assertTrue(Settings_ShippingTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));

   	 }
	       } 
	       catch (NoSuchElementException e) {
	    	   
			// TODO: handle exception
	              e.getStackTrace();	
	       }
	
	    }   

}
	
