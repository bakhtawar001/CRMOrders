package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class CreateOrderwhenAddressnotmatching extends OrdersExecution1 
{
	static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Tax_not_calculating_if_Canadian_address_is_not_matching() throws IOException, InterruptedException, AWTException{
    try
    {
		// This is to Instantiate CreateOrders  class  
   	 	Thread.sleep(15000);

   	 	//Press the Edit Button
   	 //	CreateOrder.EditShippingAddressButton.click();
   	 	Click("Edit shipping Address button",  CreateOrder.EditShippingAddressButton);
   	 	Thread.sleep(5000);
   	 	//Update the shipping contact name
		Input("Please Enter Contact name no",  CreateOrder.ContactName, "Shipping Updated Name");
		Thread.sleep(1000);
	 
		//Enter New Address
	 
		Input("Please Enter new address",  CreateOrder.EditShippingAddressField, "AZ, USA");
		Thread.sleep(4000);
		CreateOrder.EditShippingAddressField.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
	 
		CreateOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
	 
		Thread.sleep(5000);
		//Press the save Button
		
		Click("Save it ",CreateOrder.EditShippingSaveButton);
		//CreateOrder.EditShippingSaveButton.click();
	 
		Thread.sleep(3000);
	 
		CreateOrder.EditingConfirm.click();
		waitForPageLoading();
	 	Thread.sleep(10000);
	 	Click("Please click at use current rates", CreateOrder.Orderdetails_UseCurrentRates_Button);
	 	waitForPageLoading();
	 	Thread.sleep(30000);

	 	String SalesTax=CreateOrder.Orderdetails_SalesTax.getText();
	 	System.out.println(SalesTax);
	 	SalesTax=SalesTax.replace("C", "");
	 	Thread.sleep(2000);
	 	Assert.assertEquals(SalesTax, "$0.00");
	 
      }
    catch(NoSuchElementException e)
    {
        	   e.getMessage();
           }
           
	} 
           
	 	
	////////////////////////// For Canadian Address //////////////////////////////////////////
	public static void  Tax_is_not_calculating_if_Canadian_addressis_notmatching() throws IOException, InterruptedException{
	try
	{
			
	 Click("Click at edit button", CreateOrder.EditShippingAddressButton);
	 Thread.sleep(5000);
	 //Update the shipping contact name
	 Input("Please Enter Contact name no",  CreateOrder.ContactName, "Shipping Updated Name");
	 Thread.sleep(1000); 
	 //Enter New Address
	 Input("Please Enter new address",  CreateOrder.EditShippingAddressField, "Address Signage Co ");
	 Thread.sleep(6000);
	 CreateOrder.EditShippingAddressField.sendKeys(Keys.ARROW_DOWN);
	 Thread.sleep(2000);
	 CreateOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
	 Thread.sleep(5000);

	 //Press the save Button
	 Click("Save it ",CreateOrder.EditShippingSaveButton);
	// waitForPageLoading();
	 Thread.sleep(4000);
	 
	 CreateOrder.EditingConfirm.click();
	// waitForPageLoading();
	 Thread.sleep(5000);
	Click("Please click at use current rates", CreateOrder.Orderdetails_UseCurrentRates_Button);
	 waitForPageLoading(); 
	 Thread.sleep(20000);

	 String SalesTax1=CreateOrder.Orderdetails_SalesTax.getText();
	 Thread.sleep(2000);
	 SalesTax1=SalesTax1.replace("C", "");
	 Assert.assertEquals(SalesTax1, "$0.00");

           }
	
	   catch(NoSuchElementException e){
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	   }
	}  
	



}