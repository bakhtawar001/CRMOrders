package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Functions.ConversionsWithoutOtherCharges;
import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderFromWESP_WithCanadian_Product extends WESPORDER {


	 public static void OrderFromWESP_With_CanadianProduct() throws InterruptedException, IOException, ParseException{
   	  
   	  try{
   		
   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
   		 
   		  
   		  //Go to ESP Web Tab
   		  WespOrder.ESPWeb_Tab.click();
   		  
   		  Thread.sleep(5000);
   		  
   		  //Search for the Product
   		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.CanadianProduct);
   		  
   		  Thread.sleep(1000);
   		  
   		  //Press the search button
   		  WespOrder.ProductQuickSearchButton.click();
   		  
   		  Thread.sleep(6000);
   		  
   		  //Search asi number within search terms
   		  WespOrder.SearchWithinTerms_SearchField.sendKeys("79540");
   		  
   		  Thread.sleep(1000);
   		  
   		  //Press the search with terms go button
   		  WespOrder.SearchWithinTerms_GoButton.click();
   		  
   		  Thread.sleep(6000);
   		  
   		  //Hover to the Order button on searched product
   		  
   		  WebElement HoverOrder=WespOrder.CanadianProduct_OrderButton;
   		  Hover(HoverOrder);
   			
   		  Thread.sleep(1000); 
   		  
   		  //Click the E-Comm order button now
   		  WespOrder.CanadianProduct_OrderButton.click();
   		  
   		  Thread.sleep(2000);
   		  
   		//Enter The Quantity on Quatity screen
   		  List<WebElement> records = WespOrder.Price_Grid;
		  int record=records.size();
		  //Enter The Quantity on Quatity screen
		  if(record>=1) {
		  	
		  	Thread.sleep(2000);
		  	  Click("Click at Select button of price grid", WespOrder.ClickAtSelect);
		  	Thread.sleep(2000);
		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		  }
		  else {
		  	Thread.sleep(2000);
		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		  }
   			
   		 Thread.sleep(1000);
   			
   		//Press the continue Button
   		 WespOrder.CreateOrder_Configure_Continue_Button.click();
   		 
   		 Thread.sleep(1000);
   		 
            WespOrder.CreateOrder_Configure_Continue_Button.click();
   		 
   		 Thread.sleep(1000);
   		 
   	   //Choose the customer to create Order
   		 WespOrder.ChooseCustomer_TextField.click();
   		 
   		 Thread.sleep(2000);
   		 
   		 WespOrder.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
   		 
   		 Thread.sleep(6000);
   		 
   		 WespOrder.ChooseCustomer_SearchInsertion.sendKeys(Keys.ENTER);
   		 
   		 Thread.sleep(10000);
   		 
   		//First store parent window to switch back
   		 String parentWindow = driver.getWindowHandle();
   		 
   		 //Press the Create Order Button
   		 WespOrder.ChooseCustomer_CreateOrderButton.click();
   		 
   		 Thread.sleep(15000);
   		 
   		//Switch to new window opened
   		  	for(String winHandle : driver.getWindowHandles()){
   		  	    if(!winHandle.equals(parentWindow)) {
   		  	        driver.switchTo().window(winHandle);
   		  	    }
   		  	}
   		  	
   		//Validating as if the Order Created Successfully Or Not From WESP
   		 if(WespOrder.OrderCreation_FromWESP_Verification.isDisplayed())
   		 {
   			 System.out.println("Canadian Product Order created from WESP Successfully");
   			 resultPass("CanadianProductOrder_FromWESP", "Canadian Product Order created from WESP Successfully");
   		 }
   		 else{
   			 System.out.println("Canadian Product Order created from WESP UnSuccessfully");
   			 resultFail("CanadianProductOrder_FromWESP", "Canadian Product Order created from WESP UnSuccessfully");
   		 }
   	  
   		
   		
   		 //Canadian Product SubTotal Conversion
   		 ConversionsWithoutOtherCharges.CanadianProduct_Subtotal_String_To_Int_Conversion();
   		 
   			 
   		 //Sales Tax Conversion
   		 ConversionsWithoutOtherCharges.CanadianProduct_SalesTax_String_To_Int_Conversion();
   		 
   		 
   	     //Tax Calculation
   		 ConversionsWithoutOtherCharges.Tax_Calculation_Manual();
   		 
   		 
   		 
   		 //Total Amount Tax+Subtotal
   		 ConversionsWithoutOtherCharges.SubTotal_Calculation();
   		 
   		 
   		//Rounding off sum amount
   		 ConversionsWithoutOtherCharges.RoundingOffTotalAmount();
   		 
   		 
   		 //Amount Due Conversions
   		 ConversionsWithoutOtherCharges.CanadianProduct_AmountDue_String_To_Int_Conversion();
   		 
   		 if(ConversionsWithoutOtherCharges.bd.doubleValue()==ConversionsWithoutOtherCharges.AmountDue)
   		 {
   			 System.out.println("Total Amount Calculated Successfully");
   			 resultPass("TotalAmount_Calculation_CanadianProduct", "Total Amount Calculated Successfully");
   		 }
   		 else{
   			System.out.println("Total Amount Calculated UnSuccessfully");
  			resultFail("TotalAmount_Calculation_CanadianProduct", "Total Amount Calculated UnSuccessfully");
   		 }
   		 
   	//Conversion TotalCost
   		 ConversionsWithoutOtherCharges.CanadianProduct_TotalCost_String_To_Int_Conversion();
   		 
   		 //Press the Preview Button on order details
   		WespOrder.PreviewButton_Orderdetails.click();
   		 
   		 Thread.sleep(6000);
   		 
   		 //Press the Purchase Order document
   		WespOrder.PreviewPopUp_PurchaseOrder.click();
   		 
   		 Thread.sleep(3000);
   		 
   		//Select the Purchase Order Option
   		WespOrder.PreviewPopup_PurchaseOrderSelection.click();
   		 
   		 Thread.sleep(3000);
   		 //First store parent window to switch back
   		 String parentWindow1 = driver.getWindowHandle();
   		 
   		 //Press the Preview Button
   		WespOrder.PreviewPopUp_PreviewButton.click();
   		 
   		//Switch to new window opened
   		  	for(String winHandle : driver.getWindowHandles()){
   		  	    if(!winHandle.equals(parentWindow1)) {
   		  	        driver.switchTo().window(winHandle);
   		  	    }
   		  	}
   		  	  
   		  	Thread.sleep(5000);
   		 //Purchase Order Preview Total Conversion
   		ConversionsWithoutOtherCharges.CanadianProduct_PurchaseOrderAmount_String_To_Int_Conversion(); 
   		 
   		if(ConversionsWithoutOtherCharges.TotalCost==ConversionsWithoutOtherCharges.TotalPrice)
   		{
   			System.out.println("Canadian Purchase Order Preview Total Display Successfully with correct amount");
   			resultPass("Canadian_PurchaseOrder_TotalAmount_Calculation", "Canadian Purchase Order Preview Total Display Successfully with correct amount");
   		}
   		else{
   			System.out.println("Canadian Purchase Order Preview Total Display UnSuccessfully with correct amount");
   			resultFail("Canadian_PurchaseOrder_TotalAmount_Calculation", "Canadian Purchase Order Preview Total Display UnSuccessfully with correct amount");
   		}
   	   Thread.sleep(2000);
   		
   		driver.close();
   		
   		Thread.sleep(1000);
   	   
   	   //Switch back to parent window 
  	     driver.switchTo().window(parentWindow1);
   		 
   		//AmountDue Conversion
  	  ConversionsWithoutOtherCharges.CanadianProduct_AmountDue_String_To_Int_Conversion();
  	     
  	 //Press the Purchase Order document
  	   WespOrder.PreviewPopUp_SalesOrder.click();
  		 
  		 Thread.sleep(3000);
  		 
  		//First store parent window to switch back
  		 String parentWindow2 = driver.getWindowHandle();
  		 
  		 //Press the Preview Button
  		WespOrder.PreviewPopUp_PreviewButton.click();
  		 
  		//Switch to new window opened
  		  	for(String winHandle : driver.getWindowHandles()){
  		  	    if(!winHandle.equals(parentWindow2)) {
  		  	        driver.switchTo().window(winHandle);
  		  	    }
  		  	}
  		  	  
  		  	Thread.sleep(5000);     
  	     
  	    //Sales Order Preview Total Conversion 
  		ConversionsWithoutOtherCharges.CanadianProduct_SalesOrder_String_To_Int_Conversion();
  	     
  	    if(ConversionsWithoutOtherCharges.AmountDue==ConversionsWithoutOtherCharges.TotalPrice)
  	    {
  	    	System.out.println("Canadian Product Sales Order Calculated Successfully");
  	    	resultPass("Sales Order Calculation_Verification_CanadianProduct", "Canadian Product Sales Order Calculated Successfully");
  	    }
  	    else{
  	    	System.out.println("Canadian Product Sales Order Calculated UnSuccessfully");
  	    	resultFail("Sales Order Calculation_Verification_CanadianProduct", "Canadian Product Sales Order Calculated UnSuccessfully");
  	    }
  	     
  	    driver.close();
  	    
  	    Thread.sleep(2000);
  	//Switch back to parent window 
 	     driver.switchTo().window(parentWindow2);
  	    
  	    
  	    //Close new Browser Tab
   		 driver.close();
   		 
   		 Thread.sleep(2000);
   		 
   		 //Switch back to parent window 
   	     driver.switchTo().window(parentWindow);
   	        
   	  
   	  
   	  
   	  }
     
     catch(NoSuchElementException e)
   	  {
   	  e.getStackTrace();
   	  }
     }

 





}
