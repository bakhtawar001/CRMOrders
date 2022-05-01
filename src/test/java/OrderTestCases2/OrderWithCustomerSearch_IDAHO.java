package OrderTestCases2;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

//import Functions.ConversionsWithoutOtherCharges;
import Functions.ConversionsWithoutOtherCharges2;
import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderWithCustomerSearch_IDAHO extends OrdersExecution3 {
    public static String OldBillingAddress;
    public static String NewBillingAddress;
    public static String OldShippingAddress;
    public static String NewShippingAddress;
    public static String OldAcKnowledgementAddress;
    public static String NewAcknowledgementAddress;
	static WebElement ClearField;
	public static String SalesOrderPreviewBillToAddress;
	public static String SalesOrderPreviewShipToAddress;
	public static String AcknowledgementPreviewShipToAddress;
	public static String AcknowledgementPreviewAddress;
	
	public static void OrderCreation_WithCustomerSearchIDAHO() throws IOException, InterruptedException, ParseException{
        try{
		// This is to Instantiate CreateOrders  class  
	 OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	
	 
	 
	 //Click the Orders tab
	 CreateOrder.ESPWebHomePage_OrdersTab.click();
	 
	 //Click the Create new Order button
	 CreateOrder.OrdersScreen_OrderButton.click();
	   Thread.sleep(2000);
	 //Select the Sales Order option from toggle dropdown
	   CreateOrder.CreateOrder_SalesOrderOption.click();
	   
	   Thread.sleep(8000);
	   
	 //Select the company first on create order screen
	 CreateOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	 
	 Thread.sleep(6000);
	//Select company from company dropdown
	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	 
	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
	
	Thread.sleep(10000);
	
	

//Press Add Product Button
CreateOrder. CreateOrder_AddProductButton.click();

Thread.sleep(2000);

//Go To Product Search Tab in popup
CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

//Search the Product which want to associate with order
CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.CustomerSearchProductIDAHO);

Thread.sleep(1000);

//Now press Search Button
CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
	
wait = new WebDriverWait(driver, 180);
wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

Thread.sleep(2000);

//Now Select the Product
CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

Thread.sleep(2000);

//Press the Add Products Button to complete the process
CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


	
String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

if(ProductAddedToOrderSuccess.contains("Success"))
{
	   System.out.println("Product Added To Order Successfully");
	   resultPass("Product Added To Order", "Product Added To Order Successfully");
}
else{
	   System.out.println("Product Added To Order UnSuccessfully");
	   resultFail("Product Added To Order", "Product Added To Order UnSuccessfully");
}
Thread.sleep(10000);

driver.navigate().refresh();

Thread.sleep(25000);
//Now select the ship via option to UPS ground
     CreateOrder.OrderShipVia.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.ShipviaSelection.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.ShipViaLabel.click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.DateConfirm));
     
     Thread.sleep(2000);
     
     CreateOrder.DateConfirm.click();
  	 
  	 Thread.sleep(3000);

//Hover the configure button

	Click("Plz configure product", CreateOrder.CreateOrders_ConfigureButton);
	
	Thread.sleep(2000);
	
	if(driver.getCurrentUrl().contains("uat") || driver.getCurrentUrl().equals("https://espweb.asicentral.com/"))
	{
		//Click the Select Button
		CreateOrder.ShoppingCartProduct_SelectButton.click();
	
		Thread.sleep(3000);
		
		//Press the continue Button
		CreateOrder.CreateOrder_Configure_Continue_Button.click();
		
		
		
		wait = new WebDriverWait(driver, 180);
  	    wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_Configure_QTY_TextField));
  	   
  	   Thread.sleep(2000);
  	
/*		  if(CreateOrder.Price_Grid.isDisplayed()) {
			  
			  Click("Click at Select button of price grid", CreateOrder.ClickAtSelect);
		  }
  	   
		  if(!CreateOrder.CreateOrder_Configure_QTY_TextField.isDisplayed()) {
			  CreateOrder.Continuebutton.click();
			  
		  }
  	//Enter The Quantity on Quatity screen
  		CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("100");
  		
  		Thread.sleep(1000);
  		
  		
	
	}
	else{
		
  if(CreateOrder.Price_Grid.isDisplayed()) {
			  
			  Click("Click at Select button of price grid", CreateOrder.ClickAtSelect);
		  }
  if(!CreateOrder.CreateOrder_Configure_QTY_TextField.isDisplayed()) {
	  CreateOrder.Continuebutton.click();
	  
  }
	//Enter The Quantity on Quatity screen
	CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("100");
	
	Thread.sleep(1000);
	}*/
  	   
  	 List<WebElement> records = CreateOrder.Price_Grid;
	 int record=records.size();
	//Enter The Quantity on Quatity screen
	 if(record>=1) {
			
			Thread.sleep(2000);
			  Click("Click at Select button of price grid", CreateOrder.ClickAtSelect);
			Thread.sleep(2000);
			CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		}
		else {
			Thread.sleep(2000);
			CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		}
  	   
	
	//Press the continue Button
	CreateOrder.CreateOrder_Configure_Continue_Button.click();
	
	//Decoration Optional Screen Appear Press the save button now to create a Order
	CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	
	if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	{
	 System.out.println("Order Created Successfully With Customer Search Product");
	 resultPass("CreateOrder_CustomerSearch", "Order Created Successfully With Customer Search Product");
	}
	else{
	
		System.out.println("Order Created UnSuccessfully With Customer Search Product");
		resultFail("CreateOrder_CustomerSearch", "Order Created UnSuccessfully With Customer Search Product");
	}	

	
	Thread.sleep(10000);
     //Storing Old Billing Address
	OldBillingAddress=CreateOrder.CreateOrderScreen_BillingCompanyAddress.getText();
	
	//Now Updating All the Address contact details 
	//Update BillingAddress
	CreateOrder.BillingAddress_EditButton.click();
	
	Thread.sleep(2000);
	
	//Insert the Updated Billing Contact Name
	
	 ClearField = CreateOrder.ContactName;
	 ClearField.sendKeys(Keys.CONTROL + "a");
	 ClearField.sendKeys(Keys.DELETE);
	
	 Thread.sleep(1000);

	 CreateOrder.ContactName.sendKeys("Billing Updated Name");
	 
	 //Now Clear the Address field
	 ClearField = CreateOrder.EditShippingAddressField;
	 ClearField.sendKeys(Keys.CONTROL + "a");
	 ClearField.sendKeys(Keys.DELETE);
	 
	 Thread.sleep(1000);
	 
	//Enter New Updated Address
	 CreateOrder.EditShippingAddressField.sendKeys("California Street");
	 
	 Thread.sleep(6000);
	 
	 CreateOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
	 
	 Thread.sleep(5000);
	 
	 ClearField = CreateOrder.EditShippingPostalCodeField;
	 ClearField.sendKeys(Keys.CONTROL + "a");
	 ClearField.sendKeys(Keys.DELETE);
	 
	 Thread.sleep(1000);
	 //Enter New Postal Code
	 CreateOrder.EditShippingPostalCodeField.sendKeys("22366");
	 
	 Thread.sleep(1000);
   //Now Update the Phone Number
	 ClearField = CreateOrder.ContactPhoneNo;
	 ClearField.sendKeys(Keys.CONTROL + "a");
	 ClearField.sendKeys(Keys.DELETE);
	 
	 Thread.sleep(1000);
	 
	 CreateOrder.ContactPhoneNo.sendKeys("111-111-1111");
	 
	 //Now Update the Email
	 ClearField = CreateOrder.ContactEmail;
	 ClearField.sendKeys(Keys.CONTROL + "a");
	 ClearField.sendKeys(Keys.DELETE);
	 
	 Thread.sleep(1000);
	 
	 CreateOrder.ContactEmail.sendKeys("miftikhar@gmail.com");
	 
	 //Press the Save Button to complete Billing Contact Updation
	//Press the save Button
	 CreateOrder.EditShippingSaveButton.click();
	 
	 Thread.sleep(3000);
	 
	 //Storing New Billing Address
		NewBillingAddress=CreateOrder.CreateOrderScreen_BillingCompanyAddress.getText();
	 
	 //Validate if the Billing contact Updated or not
		if(!NewBillingAddress.equals(OldBillingAddress))
		{
			System.out.println("Order Billing Contact Details Updated Successfully");
			resultPass("BillingContact_ContactDetails_Updation", "Order Billing Contact Details Updated Successfully");
		}
		else{
			System.out.println("Order Billing Contact Details Updated UnSuccessfully");
			resultFail("BillingContact_ContactDetails_Updation", "Order Billing Contact Details Updated UnSuccessfully");
		}
	 
	//Now Updating details for shipping Address Contact
		
	 OldShippingAddress=CreateOrder.CreateOrderScreen_ShippingCompanyAddress.getText();	
		
		
		//Press the Edit Button
		 CreateOrder.EditShippingAddressButton.click();
		 
		 Thread.sleep(5000);
		 
		 ClearField = CreateOrder.ContactName;
		 ClearField.sendKeys(Keys.CONTROL + "a");
		 ClearField.sendKeys(Keys.DELETE);
		
		 Thread.sleep(1000);
	   
		 
		 //Update the shipping contact name
		 CreateOrder.ContactName.sendKeys("Shipping Updated Name");
		 
		 
		 //Change the Address from current address to different Address
		  ClearField = CreateOrder.EditShippingAddressField;
		  ClearField.sendKeys(Keys.CONTROL + "a");
		  ClearField.sendKeys(Keys.DELETE);
		 
		 Thread.sleep(1000);
		 
	//Enter New Address
		 CreateOrder.EditShippingAddressField.sendKeys("California Street");
		 
		 Thread.sleep(6000);
		 
		 CreateOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
		 
		 Thread.sleep(5000);
		 
		 ClearField = CreateOrder.EditShippingPostalCodeField;
		 ClearField.sendKeys(Keys.CONTROL + "a");
		 ClearField.sendKeys(Keys.DELETE);
		 
		 Thread.sleep(1000);
		 //Enter New Postal Code
		 CreateOrder.EditShippingPostalCodeField.sendKeys("22355");
		 
		 Thread.sleep(1000);
		 
		 
		 //Now Update the Phone Number
		 ClearField = CreateOrder.ContactPhoneNo;
		 ClearField.sendKeys(Keys.CONTROL + "a");
		 ClearField.sendKeys(Keys.DELETE);
		 
		 Thread.sleep(1000);
		 
		 CreateOrder.ContactPhoneNo.sendKeys("222-222-2222");
		 
		 //Now Update the Email
		 ClearField = CreateOrder.ContactEmail;
		 ClearField.sendKeys(Keys.CONTROL + "a");
		 ClearField.sendKeys(Keys.DELETE);
		 
		 Thread.sleep(1000);
		 
		 CreateOrder.ContactEmail.sendKeys("miftikhar@gmail.com");
		 
		 //Press the save Button
		 CreateOrder.EditShippingSaveButton.click();
		 
		 Thread.sleep(3000);
		 
		 CreateOrder.EditingConfirm.click();
		 
		 Thread.sleep(10000);
		 
		 NewShippingAddress=CreateOrder.CreateOrderScreen_ShippingCompanyAddress.getText();	
	
	//Now Validating if the shipping contact details updated or not
		 if(!NewShippingAddress.equals(OldShippingAddress))
		 {	 
			System.out.println("Order Shipping Contact Details Updated Successfully");
			resultPass("ShippingContact_ContactDetails_Updation", "Order Shipping Contact Details Updated Successfully");
		}
		else{
			System.out.println("Order Shipping Contact Details Updated UnSuccessfully");
			resultFail("ShippingContact_ContactDetails_Updation", "Order Shipping Contact Details Updated UnSuccessfully");
		}
		 
	//Now Updating Acknowledgement contact details
		 OldAcKnowledgementAddress=CreateOrder.CreateOrderScreen_AckCompanyAddress.getText();	
			
			
			//Press the Edit Button
			 CreateOrder.AcknowledgementAddress_EditButton.click();
			 
			 Thread.sleep(5000);
			 
			 ClearField = CreateOrder.ContactName;
			 ClearField.sendKeys(Keys.CONTROL + "a");
			 ClearField.sendKeys(Keys.DELETE);
			
			 Thread.sleep(1000);
		   
			 
			 //Update the shipping contact name
			 CreateOrder.ContactName.sendKeys("Acknowledgement Updated Name");
			 
			 
			 //Change the Address from current address to different Address
			  ClearField = CreateOrder.EditShippingAddressField;
			  ClearField.sendKeys(Keys.CONTROL + "a");
			  ClearField.sendKeys(Keys.DELETE);
			 
			 Thread.sleep(1000);
			 
		//Enter New Address
			 CreateOrder.EditShippingAddressField.sendKeys("California Street");
			 
			 Thread.sleep(6000);
			 
			 CreateOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
			 
			 Thread.sleep(5000);
			 
			 ClearField = CreateOrder.EditShippingPostalCodeField;
			 ClearField.sendKeys(Keys.CONTROL + "a");
			 ClearField.sendKeys(Keys.DELETE);
			 
			 Thread.sleep(1000);
			 //Enter New Postal Code
			 CreateOrder.EditShippingPostalCodeField.sendKeys("22377");
			 
			 Thread.sleep(1000);
			 
			//Now Update the Phone Number
			 ClearField = CreateOrder.ContactPhoneNo;
			 ClearField.sendKeys(Keys.CONTROL + "a");
			 ClearField.sendKeys(Keys.DELETE);
			 
			 Thread.sleep(1000);
			 
			 CreateOrder.ContactPhoneNo.sendKeys("333-333-3333");
			 
			 //Now Update the Email
			 ClearField = CreateOrder.ContactEmail;
			 ClearField.sendKeys(Keys.CONTROL + "a");
			 ClearField.sendKeys(Keys.DELETE);
			 
			 Thread.sleep(1000);
			 
			 CreateOrder.ContactEmail.sendKeys("miftikhar@gmail.com");
			 
			 //Press the save Button
			 CreateOrder.EditShippingSaveButton.click();
			 
			 Thread.sleep(3000);
			 
			
			 
			 NewAcknowledgementAddress=CreateOrder.CreateOrderScreen_AckCompanyAddress.getText();	
		
		//Now Validating if the shipping contact details updated or not
			 if(!NewAcknowledgementAddress.equals(OldAcKnowledgementAddress))
			 {	 
				System.out.println("Order Acknowledgement Contact Details Updated Successfully");
				resultPass("AcknowledgementContact_ContactDetails_Updation", "Order Acknowledgement Contact Details Updated Successfully");
			}
			else{
				System.out.println("Order Acknowledgement Contact Details Updated UnSuccessfully");
				resultFail("AcknowledgementContact_ContactDetails_Updation", "Order Acknowledgement Contact Details Updated UnSuccessfully");
			}
		 
	
	//Canadian Product SubTotal Conversion
		 ConversionsWithoutOtherCharges2.CanadianProduct_Subtotal_String_To_Int_Conversion();
		 
			 
		 //Sales Tax Conversion
		 ConversionsWithoutOtherCharges2.CanadianProduct_SalesTax_String_To_Int_Conversion();
		 
		 
	     //Tax Calculation
		 ConversionsWithoutOtherCharges2.Tax_Calculation_Manual();
		 
		 
		 
		 //Total Amount Tax+Subtotal
		 ConversionsWithoutOtherCharges2.SubTotal_Calculation();
		 
		 
		//Rounding off sum amount
		 ConversionsWithoutOtherCharges2.RoundingOffTotalAmount();
		 
		 
		 //Amount Due Conversions
		 ConversionsWithoutOtherCharges2.CanadianProduct_AmountDue_String_To_Int_Conversion();
		 
		 if(ConversionsWithoutOtherCharges2.bd.doubleValue()==ConversionsWithoutOtherCharges2.AmountDue)
		 {
			 System.out.println("Total Amount Calculated Customer Search IDAHO Successfully");
			 resultPass("TotalAmount_Calculation_CanadianProduct_CustomerSearchIDAHO", "Total Amount Calculated Customer Search IDAHO Successfully");
		 }
		 else{
			System.out.println("Total Amount Calculated Customer Search IDAHO UnSuccessfully");
			resultFail("TotalAmount_Calculation_CanadianProduct_CustomerSearchIDAHO", "Total Amount Calculated Customer Search IDAHO UnSuccessfully");
		 }
		 
	//Conversion TotalCost
		 ConversionsWithoutOtherCharges2.CanadianProduct_TotalCost_String_To_Int_Conversion();
		 
		 //Press the Preview Button on order details
		 CreateOrder.PreviewButton_Orderdetails.click();
		 
		 Thread.sleep(15000);
		 
		 //Press the Purchase Order document
		 CreateOrder.PreviewPopUp_PurchaseOrder.click();
		 
		 Thread.sleep(3000);
		 
		//Select the Purchase Order Option
		 CreateOrder.PreviewPopup_PurchaseOrderSelection.click();
		 
		 Thread.sleep(3000);
		 //First store parent window to switch back
		 String parentWindow1 = driver.getWindowHandle();
		 
		 //Press the Preview Button
		 CreateOrder.PreviewPopUp_PreviewButton.click();
		 
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow1)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	  
		  	Thread.sleep(5000);
		 //Purchase Order Preview Total Conversion
		ConversionsWithoutOtherCharges2.CanadianProduct_PurchaseOrderAmount_String_To_Int_Conversion(); 
		 
		if(ConversionsWithoutOtherCharges2.TotalCost==ConversionsWithoutOtherCharges2.TotalPrice)
		{
			System.out.println("Canadian Purchase Order Preview with Customer Search in IDAHO Total Display Successfully with correct amount");
			resultPass("Canadian_PurchaseOrder_TotalAmount_Calculation_CustomerSearchIDAHO", "Canadian Purchase Order Preview with Customer Search in IDAHO Total Display Successfully with correct amount");
		}
		else{
			System.out.println("Canadian Purchase Order Preview Total with Customer Search in IDAHO Display UnSuccessfully with correct amount");
			resultFail("Canadian_PurchaseOrder_TotalAmount_Calculation_CustomerSearchIDAHO", "Canadian Purchase Order Preview with Customer Search in IDAHO Total Display UnSuccessfully with correct amount");
		}
	   
	   
	 //Validating Shipping to Updated Address details on PurchaseOrder 	
		 AcknowledgementPreviewShipToAddress=CreateOrder.SalesOrderPreview_BillingToAddress.getText();
		 
		 if(AcknowledgementPreviewShipToAddress.contains("Shipping Updated Name") & AcknowledgementPreviewShipToAddress.contains("California Street") & AcknowledgementPreviewShipToAddress.contains("San Francisco, CA 22355") & AcknowledgementPreviewShipToAddress.contains("United States") & !AcknowledgementPreviewShipToAddress.contains("miftikhar@gmail.com") & !AcknowledgementPreviewShipToAddress.contains("222-222-2222"))
		 {
			 System.out.println("Purchase Order Preview Updated ShipTo Address  display Successfully ");
			 resultPass("PurchaseOrderPreview_ShipToAddress_Verification_AfterUpdation", "Purchase Order Preview Updated ShipTo Address  display Successfully");
		 }
		 else{
			 System.out.println("Purchase Order Preview Updated ShipTo Address  display UnSuccessfully ");
			 resultFail("PurchaseOrderPreview_ShipToAddress_Verification_AfterUpdation", "Purchase Order Preview Updated ShipTo Address  displayUnSuccessfully");
		 }
	   
		 Thread.sleep(2000);
	   
	   
	   driver.close();
  		
  		Thread.sleep(1000);
  	   
  	   //Switch back to parent window 
 	     driver.switchTo().window(parentWindow1);
  		 
  		//AmountDue Conversion
 	  ConversionsWithoutOtherCharges2.CanadianProduct_AmountDue_String_To_Int_Conversion();
 	     
 	 //Press the Purchase Order document
 	 CreateOrder.PreviewPopUp_SalesOrder.click();
 		 
 		 Thread.sleep(3000);
 		 
 		//First store parent window to switch back
 		 String parentWindow2 = driver.getWindowHandle();
 		 
 		 //Press the Preview Button
 		CreateOrder.PreviewPopUp_PreviewButton.click();
 		 
 		//Switch to new window opened
 		  	for(String winHandle : driver.getWindowHandles()){
 		  	    if(!winHandle.equals(parentWindow2)) {
 		  	        driver.switchTo().window(winHandle);
 		  	    }
 		  	}
 		  	  
 		  	Thread.sleep(5000);     
 	     
 	    //Sales Order Preview Total Conversion 
 		ConversionsWithoutOtherCharges2.CanadianProduct_SalesOrder_String_To_Int_Conversion();
 	     
 	    if(ConversionsWithoutOtherCharges2.AmountDue==ConversionsWithoutOtherCharges2.TotalPrice)
 	    {
 	    	System.out.println("Canadian Product Sales Order with Customer Search in IDAHO Calculated Successfully");
 	    	resultPass("Sales Order Calculation_Verification_CanadianProduct_CustomerSearchIDAHO", "Canadian Product Sales Order with Customer Search in IDAHO Calculated Successfully");
 	    }
 	    else{
 	    	System.out.println("Canadian Product Sales Order with Customer Search in IDAHO Calculated UnSuccessfully");
 	    	resultFail("Sales Order Calculation_Verification_CanadianProduct_CustomerSearchIDAHO", "Canadian Product Sales Order with Customer Search in IDAHO Calculated UnSuccessfully");
 	    }
 	    
 	    //Storing Sales Order Preview bill Address
 	    SalesOrderPreviewBillToAddress=CreateOrder.SalesOrderPreview_BillingToAddress.getText();
 	    
 	   
 	    
 	    //Storing Sales Order preview ShipTo Address in string
 	    SalesOrderPreviewShipToAddress=CreateOrder.SalesOrderPreview_ShippingToAddress.getText();
 	    
 	  //Now Match UpdatedBill Address with Sales Order Preview Bill Address
 	    if(SalesOrderPreviewBillToAddress.contains("Billing Updated Name") & SalesOrderPreviewBillToAddress.contains("California Street") & SalesOrderPreviewBillToAddress.contains("San Francisco, CA 22366") & SalesOrderPreviewBillToAddress.contains("United States") & SalesOrderPreviewBillToAddress.contains("miftikhar@gmail.com") & SalesOrderPreviewBillToAddress.contains("111-111-1111"))
 	    {
 	    	System.out.println("Billing Contact updated Successfully on sales Order preview");
 	        resultPass("BillingAddress_SalesOrderPreview_AfterUpdation_Verification","Billing Contact updated Successfully on sales Order preview");
 	    
 	    }
 	    else{
 	    	System.out.println("Billing Contact updated UnSuccessfully on sales Order preview");
 	    	resultFail("BillingAddress_SalesOrderPreview_AfterUpdation_Verification","Billing Contact updated UnSuccessfully on sales Order preview");
 	    }
 	    
 	    //Now Validating NewShipping Address with SalesOrderPreviewAddress
 	    if(SalesOrderPreviewShipToAddress.contains("Shipping Updated Name") & SalesOrderPreviewShipToAddress.contains("California Street") & SalesOrderPreviewShipToAddress.contains("San Francisco, CA 22355") & SalesOrderPreviewShipToAddress.contains("United States") & SalesOrderPreviewShipToAddress.contains("miftikhar@gmail.com") & SalesOrderPreviewShipToAddress.contains("222-222-2222"))
 	   {
 	    	System.out.println("Shipping Contact updated Successfully on sales Order preview");
 	    	resultPass("ShippingAddress_SalesOrderPreview_AfterUpdation_Verification","Shipping Contact updated Successfully on sales Order preview");
 	   
 	   }
 	    else{
 	    	System.out.println("Shipping Contact updated UnSuccessfully on sales Order preview");
 	    	resultFail("ShippingAddress_SalesOrderPreview_AfterUpdation_Verification","Shipping Contact updated UnSuccessfully on sales Order preview");
 	     
 	    }
 	    
 	    
 	    
 	    driver.close();
 	    
 	    Thread.sleep(2000);
 	//Switch back to parent window 
	     driver.switchTo().window(parentWindow2);
  		 
	  
	     //Press the Acknowlodgement Order document
		 CreateOrder.PreviewPopUp_Acknowledgement.click();
		 
		 Thread.sleep(3000);
		 
		//First store parent window to switch back
		 String parentWindow10 = driver.getWindowHandle();
		 
		 //Press the Preview Button
		 CreateOrder.PreviewPopUp_PreviewButton.click();
		 
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow10)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	  
		  	Thread.sleep(10000);
		 //Validating Shipping to Updated Address details 	
		 AcknowledgementPreviewShipToAddress=CreateOrder.SalesOrderPreview_BillingToAddress.getText();
		 
		 if(AcknowledgementPreviewShipToAddress.contains("Shipping Updated Name") & AcknowledgementPreviewShipToAddress.contains("California Street") & AcknowledgementPreviewShipToAddress.contains("San Francisco, CA 22355") & AcknowledgementPreviewShipToAddress.contains("United States") & AcknowledgementPreviewShipToAddress.contains("miftikhar@gmail.com") & AcknowledgementPreviewShipToAddress.contains("222-222-2222"))
		 {
			 System.out.println("Acknowledgement Updated ShipTo Address on Acknowledgement preview display Successfully ");
			 resultPass("AcknowledgementPreview_ShipToAddress_Verification_AfterUpdation", "Acknowledgement Updated ShipTo Address on Acknowledgement preview display Successfully");
		 }
		 else{
			 System.out.println("Acknowledgement Updated ShipTo Address on Acknowledgement preview display UnSuccessfully ");
			 resultFail("AcknowledgementPreview_ShipToAddress_Verification_AfterUpdation", "Acknowledgement Updated ShipTo Address on Acknowledgement preview display UnSuccessfully");
		 }
	     
	     //Validating the Acknowledgement Updated Address in Acknowledgement Preview
		 AcknowledgementPreviewAddress=CreateOrder.AcknowledgementPreviewAddress.getText();
		 
		 if(AcknowledgementPreviewAddress.contains("Acknowledgement Updated Name") & AcknowledgementPreviewAddress.contains("California Street") & AcknowledgementPreviewAddress.contains("San Francisco, CA 22377") & AcknowledgementPreviewAddress.contains("United States") & AcknowledgementPreviewAddress.contains("mmubarik@asicentral.com") & AcknowledgementPreviewAddress.contains("333-333-3333"))
		 {
			 System.out.println("Acknowledgement Updated Address on Acknowledgement preview display Successfully ");
			 resultPass("AcknowledgementPreview_AcknowledgementAddress_Verification_AfterUpdation", "Acknowledgement Updated Address on Acknowledgement preview display Successfully ");
		 }
		 else{
			 System.out.println("Acknowledgement Updated ShipTo Address on Acknowledgement preview display UnSuccessfully ");
			 resultFail("AcknowledgementPreview_AcknowledgementAddress_Verification_AfterUpdation", "Acknowledgement Updated Address on Acknowledgement preview display UnSuccessfully ");
		 }
	     
	     driver.close();
	     
	     Thread.sleep(2000);
	   //Switch back to parent window 
	     driver.switchTo().window(parentWindow10);
		 
		 //Close the Doc Popup
		  CreateOrder.ClosePreviewPopup.click();
			 
		  Thread.sleep(2000);
	     
	     //Close the current order
		  CreateOrder.CloseOrder_Icon.click();
		   	 
		  Thread.sleep(3000);
	     
	    
  		 
  		 
  	        
  	  
  	  
	} 
     }
	
	   catch(NoSuchElementException e){
		   e.getStackTrace();
	   }
	}  
	
		
	public static void resultPass(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
				test.log(Status.PASS, sTestName);

			
			 } catch (Exception e)
	{
			 e.printStackTrace();   
	}

	}
	public static void resultFail(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
				test.log(Status.FAIL, sTestName);

		 } catch (Exception e)
	{
			 e.printStackTrace();		 
	}    	
	
	
}
	public static void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
}




}
