package OrdersTestcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class Settings_SalesTax_ShippingTax_Enabling extends OrdersExecution1 {

	public static String AddressVerification;
	static OrdersLocators Settings_SalesTax = PageFactory.initElements(driver, OrdersLocators.class);	
	
	public static void OrdersListing_SearchOrderField_Placeholder_Verification() throws IOException, InterruptedException{
	try
	{

   	 	//Click the Orders tab
		Settings_SalesTax.ESPWebHomePage_OrdersTab.click();
		Thread.sleep(3000);
		WebElement FieldSearchText=Settings_SalesTax.OrdersTab_SearchOrder_Field_Placeholder;
		String SearchField_Placeholder_Value=FieldSearchText.getAttribute("placeholder");
		Assert.assertTrue(SearchField_Placeholder_Value.contains("Search by product, supplier, etc."));
 
	 }
	catch(NoSuchElementException e)
	{
	   e.getMessage();
	 
	}
	}
	
	public static void AutomaticSalesTax_checked() throws InterruptedException, IOException{
	try
	{
		//Click the userInfoIcon on My Order screen	 
		Settings_SalesTax.OrderListing_UserInfoIcon.click();
		//Click the settings option
		Settings_SalesTax.UserInfoIcon_Settings.click();
		//Now Select the sales tax option in settings
		Settings_SalesTax.Settings_SalesTax.click();
		AddressVerification=Settings_SalesTax.Settings_AddressExistenceVerification.getText();
		System.out.println(AddressVerification);
		if(!AddressVerification.contains("PA"))
		{
		 //Create the Address with state 'PA'
		 Settings_SalesTax.Settings_AddAddressButton.click();
		 waitForPageLoading();
		 Thread.sleep(2000);
		 //Enter the Address 1
		 Settings_SalesTax.Settings_AddAddress_AddressNameField.sendKeys("4800 E Street Rd Feasterville-Trevose, PA");
		 Thread.sleep(5000);
		 //Press the Enter key
		 Settings_SalesTax.Settings_AddAddress_AddressNameField.sendKeys(Keys.ENTER);
		 Thread.sleep(4000);
		 //Press the save button
		 Settings_SalesTax.Settings_AddAddress_SaveButton.click();
		 if(Settings_SalesTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
		 {
			 System.out.println("Address with PA State Added Successfully");
			 
		 }
		
	 }
	 else
	 {
		 System.out.println("Address with PA state Already Exist");
	 }
	//Check if the automatically taxes calculation checkbox is selected or not
   	 if(!Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
   	 {
   	   Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
   	   Thread.sleep(1000);
   	   Assert.assertTrue(Settings_SalesTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));         
   	 }
   	
   	Thread.sleep(2000);
  
	}

	catch(NoSuchElementException e){
   	  
		System.err.println("NoSuchElementException: " + e.getMessage());
	}
	
	finally 
	{
		Click("Click order home page", Settings_SalesTax.ESPWebHomePage_OrdersTab);
		Thread.sleep(3000);
	}
	}

}