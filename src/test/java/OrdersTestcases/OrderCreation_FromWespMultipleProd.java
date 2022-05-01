package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Functions.Conversions;
import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;

public class OrderCreation_FromWespMultipleProd extends WESPORDER {
	static WebElement ClearField;
	public static  void TaxAppliedonMultipleProductsAtCandaianAddress1() throws InterruptedException, IOException, ParseException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	   		 
	   		//Go to ESP Web Tab
    		  WespOrder.ESPWeb_Tab.click();
    		  
    		  Thread.sleep(5000);
   /* 		  
    		  //Search for the Product
    		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.Clipboard_ProductName);
    		  
    		  Thread.sleep(1000);
    		  
    		  //Press the search button
    		  WespOrder.ProductQuickSearchButton.click();
    		  
    		  Thread.sleep(10000);
    		  
    		  //Search asi number within search terms
    		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.Clipboard_ProductNumber);
    		  
    		  Thread.sleep(1000);
    		  
    		  //Press the search with terms go button
    		  WespOrder.SearchWithinTerms_GoButton.click();
    		  
    		  Thread.sleep(12000);  
	   		 
    		  WebElement HoverOrder=WespOrder.Order_SavetoclipboardButton;
    		  Hover(HoverOrder);
    			
    		  Thread.sleep(1000); 

    		  WespOrder.Order_SavetoclipboardButton.click();
    		  
    		  Thread.sleep(10000);*/
	   		  
	   		  //Click the Clip board ICon
	   		  WespOrder.Clipboard_Icon.click();
	   		  
	   		  Thread.sleep(5000);
	   		  
	   		  //Check the first Product in clipboard list
	   		  WespOrder.ClipboardProduct_CheckboxSelection.click();
	   		  
	   		  Thread.sleep(2000);
	   		  WespOrder.ClipboardProduct_CheckboxSelectionSecondProduct.click();
	   		  Thread.sleep(2000);

	   		 
	   		//Press the Order button next screen
	   	  //Click the E-Comm order button now
	   		  WespOrder.ShoppingCart_OrderButton.click();
	   		  
	   		  Thread.sleep(15000);
	   		  
	   		
	   		 
	   		//First store parent window to switch back
	   		 String parentWindow = driver.getWindowHandle();
	   		 

	   		//Switch to new window opened
	   		  	for(String winHandle : driver.getWindowHandles()){
	   		  	    if(!winHandle.equals(parentWindow)) {
	   		  	        driver.switchTo().window(winHandle);
	   		  	    }
	   		  	}
	   		  	
	   		//Validating as if the Order Created Successfully Or Not From WESP
	   		 if(WespOrder.OrderCreation_FromWESP_Verification.isDisplayed())
	   		 {
	   			 System.out.println("Order created from Clipboard in WESP Successfully ");
	   			 resultPass("OrderFromWESP_FromClipboard_OrderCreation", "Order created from Clipboard in WESP Successfully");
	   		 }
	   		 else{
	   			 System.out.println("Order created from from Clipboard in WESP UnSuccessfully");
	   			 resultFail("OrderFromWESP_FromClipboard_OrderCreation", "Order created from Clipboard in WESP UnSuccessfully");
	   		 }
	   		 
	   		 Thread.sleep(2000);
	   		 
	   		 //Select the company first on create order screen
	   		WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	  	 
	  	   Thread.sleep(2000);
	  	 
	  	   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	   		
	  	   Thread.sleep(6000);
	  	   
	  	 WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	  	 
	  	 Thread.sleep(10000);
	  	 
	  	 
	  	 
	  	 
	  	WespOrder.EditShippingAddressButton.click();
		 
		
		 Thread.sleep(1000);
	   
		 
		 //Update the shipping contact name
		 WespOrder.ContactName.clear();
		 WespOrder.ContactName.sendKeys("Shipping Updated Name");
		 
		 
		 
		 
	//Enter New Address
		 WespOrder.EditShippingAddressField.clear();
		 WespOrder.EditShippingAddressField.sendKeys("Canadian Tire Centre - Parking");
		 
		 Thread.sleep(6000);
		// WespOrder.EditShippingAddressField.sendKeys(Keys.ARROW_DOWN);
		 Thread.sleep(1000);
		 WespOrder.EditShippingAddressField.sendKeys(Keys.ENTER);
		 Thread.sleep(1000);
		 WespOrder.EditShippingSaveButton.click();
		 Thread.sleep(1000);
		 WespOrder.EditingConfirm.click();
	  	 Thread.sleep(3000);
	     for (int a=0; a<2; a++) {
	    	 
	    	// if(WespOrder.CreateOrders_ConfigureButton.isDisplayed()) {
	    		 Click("a", WespOrder.CreateOrders_ConfigureButton);		   		
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
			   		WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	    //	 }
	    		

	     }
	  	    
	  	 
	   		
	   		
	   		//Decoration Optional Screen Appear Press the save button now to create a Order
	   		
	   		if(WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	   		{
	   		 System.out.println("Order Created from clipboard Successfully");
	   		 
	   		}
	   		else{
	   		
	   			System.out.println("Order Created from clipboard UnSuccessfully");
	   			
	   		}	
	   		Thread.sleep(10000);
	   		WespOrder.Orderdetails_UseCurrentRates_Button.click();
	   		Thread.sleep(10000);
	   		
	    	 Conversions.Subtotal_String_To_Int_Conversion();
	   	  //Calculating Tax	
		   	 
		     Conversions.Tax_Calculation_Automatic_Canadian();
		   	 
		  //Sales Tax Conversion from String to integer with $ removing done 
		   	 
		     Conversions.SalesTax_String_To_Int_Conversion();
		   	
		   //Calculating the SubTotal
		   	 
		   	 Conversions.SubTotal_Calculation();
		   
		   //Rounding off the value SubTotal and Sum tax
		   	 Conversions.RoundingOffTotalAmount();	 
		   	
		   //Now Converting the Amountdue from string to Int
		   	Conversions.AmountDue_String_To_Int_Conversion();
		   	
		   //Now Validating the Total Amount due 
		   if(Conversions.bd.doubleValue()==Conversions.AmountDue)
		   	 {
		   		 System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is correct");
		   	 }
		   	 else{
		   		System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is not correct");
		   	 }
	      
	   		

	   		Thread.sleep(10000);
	   		
	   		WespOrder.SampleRequestSaveButton.click();
	   		
	   		Thread.sleep(10000);
	   		 //Close new Browser Tab
	   		 driver.close();
	   		 
	   		 Thread.sleep(2000);
	   		 
	   		 //Switch back to parent window 
	   	     driver.switchTo().window(parentWindow);
	   	       
	   	     Thread.sleep(1000);
   	  }
	     
	     catch(NoSuchElementException e)
	   	  {
	   	  e.getStackTrace();
	   	  }
	     }




}
