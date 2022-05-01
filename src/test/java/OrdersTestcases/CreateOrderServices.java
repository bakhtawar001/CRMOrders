package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class CreateOrderServices extends OrdersExecution1 {
	static OrdersLocators Services = PageFactory.initElements(driver, OrdersLocators.class);
	//Developing new function for Services Functionality
	public static void Freight_Service_Popup_Display() throws IOException, InterruptedException, ParseException{
	try
	{
		// This is to Instantiate Services  class  
		Thread.sleep(2000);	
		//Now click Services toggle
		Click("Click at toggle button", Services.OrderDetails_Service_ToggleClick);
		Thread.sleep(1000);
		//Click the Freight Option
		Click("Click at OrderDetails_Service_Freight", Services.OrderDetails_Service_Freight);
		Thread.sleep(8000);  	 
		//Now first validate that popup for add service is occur
		Assert.assertTrue(Services.OrderDetails_Service_Freight_Popup_Heading.getText().equals("Add Service"));
			
				
				}
	catch(NoSuchElementException e)
	{
	e.getMessage();
	}
}		
	public static void Freight_Title_Field_Text_Validation() throws IOException, InterruptedException{
	try
	{
		WebElement FreightTitle=Services.OrderDetails_Service_Freight_Popup_TitleField;
		String value=FreightTitle.getAttribute("value"); 
		System.out.println(value);
		//Now validate as if there is 'freight'text display in title field
		Assert.assertTrue(value.contains("Freight"));
	}
	catch(NoSuchElementException e)
	{
				e.getMessage();
	}
			
		}	
	public static void Freight_Title_Update() throws IOException, InterruptedException{
	try
	{ 
				
		Input("Please enter freight name", Services.OrderDetails_Service_Freight_Popup_TitleField, "Freight1");
		//Enter Description
		Services.OrderDetails_Service_Freight_Popup_DescriptionField.sendKeys("Updated Freight Name");  
		//Select the Vendor Company
		Services.Vendor_CompanySelection_Field_Services.click();	     
		Thread.sleep(1000);  
		Services.VendorCompany_Services.click();
		Thread.sleep(1000);
		//Enter charges cost for freight
		Services.OrderDetails_Service_Freight_Popup_Netcost.sendKeys("50");  
		//Press the save Button
		Thread.sleep(1000);
		Services.OrderDetails_Service_Freight_Popup_SaveButton.click();
		waitForElementNotVisible(120, driver,Services.SpinnerLoader);
		Thread.sleep(60000);	     
		//Validate as if the updated name display on div
		String UpdatedFreightName =Services.Orderdetails_FreightDivDisplay_validation.getText();
		System.out.println(UpdatedFreightName);
		Assert.assertTrue(UpdatedFreightName.contains("Freight1"));
			  
				
			} 
	catch(NoSuchElementException e)
	{
				e.getMessage();
	}
	}	
		
		public static void Services_VendorCompany_Verification() throws InterruptedException, IOException{
		try
		{
				
			SoftAssert softassertion=new SoftAssert();
			//GetText of services vendor added and compare with crm supplier vendor added
			String VendorcompanyText=Services.VendorCompany_FreightServices_OrdersDetails.getText();
			System.out.println(VendorcompanyText);
			
			Services.VendorCompany_FreightServices_OrdersDetails.click();
			
			AcknowlodgementPreview.parentWindow = driver.getWindowHandle();
			 Thread.sleep(60000);
			 //Press the Preview Button
			//AcknowlodgementPreview.AckowledgementPreview.PreviewPopUp_PreviewButton.click();
			 
			//Switch to new window opened
			  	for(String winHandle : driver.getWindowHandles()){
			  	    if(!winHandle.equals(AcknowlodgementPreview.parentWindow)) {
			  	        driver.switchTo().window(winHandle);
			  	    }
			  	}
			
			
			String VendorcompanyText_CRM=Services.ServicesCompany_Verification_AtCrmLevel.getText();
			System.out.println(VendorcompanyText_CRM);
			Assert.assertEquals(VendorcompanyText_CRM, VendorcompanyText);
			softassertion.assertAll();
			Thread.sleep(5000);
			
	   		 
  		    driver.close();
  	        
  	        Thread.sleep(2000);
  	        
  	      //Switch back to parent window 
  	        driver.switchTo().window(AcknowlodgementPreview.parentWindow);
  	        
  	        Thread.sleep(1000);
		
			}catch(NoSuchElementException e){
				e.getMessage();
			}
		
		
		}
			
		public static void Freight_Service_Add_Tax_Calculation_Verification() throws InterruptedException, ParseException, IOException{
		try
		{	
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

				}
			
				catch (NoSuchElementException e) {
					// TODO: handle exception
			    	 System.err.println("NoSuchElementException: " + e.getMessage());
				}
				
				
				}
		
	
		

}

