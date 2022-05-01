package OrdersWESPTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import FunctionsWESP.Conversions;
import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderCreation_FromIdahoMultipleProd extends WESPORDER {
	static WebElement ClearField;
	public static  void TaxAppliedonMultipleProductsAtCandaianAddress() throws InterruptedException, IOException, ParseException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
   // 		  WespOrder.ESPWeb_Tab.click();
	   		  driver.navigate().refresh();
    		  Thread.sleep(10000);
	   		//Go to ESP Web Tab
    		  WespOrder.ESPWebHomePage_OrdersTab1.click();
    		  Thread.sleep(5000);
    		  

			  WespOrder.CreateOrder_SalesOrderOption.click();
			   
			   Thread.sleep(6000);
				 //Select the company first on create order screen
			  WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
			   	 
			   Thread.sleep(2000);
			   	 
			   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
			   	 
			   	 Thread.sleep(6000);
			   	//Select company from company dropdown
			   	WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
			   	 
			   	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
			   	
			   	Thread.sleep(5000);
			   	
			  //Press Add Product Button
    		   Click("a", WespOrder. CreateOrder_AddProductButton);
			
    		  
    		  Thread.sleep(5000);
    		  	
    		//Go To Product Search Tab in popup
    		  WespOrder.AddProduct_Clipboard_US_Product.click();
    		    Thread.sleep(5000);

    		  //Press the Add Products Button to complete the process
    		    WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
    		    Thread.sleep(5000);
    		   
   		   
    		   Click("a", WespOrder. CreateOrder_AddProductButton);

    		    
    		    Thread.sleep(5000);
    		    
    		    //Go To Product Search Tab in popup
    		    WespOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();
    		    Thread.sleep(1000);
    		    //Search the Product which want to associate with order
    		    WespOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct);
    		    
    		    Thread.sleep(1000);
    		    
    		    //Now press Search Button
    		    WespOrder.CreateOrder_AddProductPopup_SearchButton.click();
    		 	Thread.sleep(100);
    		    wait = new WebDriverWait(driver, 180);
    		    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_AddProductPopup_ProductSelection));
    		    
    		    Click ("Select Product", WespOrder.CreateOrder_AddProductPopup_ProductSelection);
    		    //Now Select the Product
    		    
    		    Thread.sleep(2000);
    		    
    		    //Press the Add Products Button to complete the process
    		    WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
    		    
    		    
    		   
	   		  
    		    Thread.sleep(5000);
	   			  	 
	  	 
	  	 
	  	 
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
	    	 
	    	
	    		 Click("a", WespOrder.CreateOrders_ConfigureButton);		   		
			   		Thread.sleep(4000);
			   		/*
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
	    		  	Thread.sleep(100);
	    		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
	    		  }
			   		
	    		*/  
	    		Thread.sleep(100);
    		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
	    		  
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
	   			 resultPass("TaxAppliedonMultipleProductsAtCandaianAddress", "Order created from Clipboard in WESP Successfully");

		   		 System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is correct");
		   	 }
		   	 else{
		   		System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is not correct");
	   			 resultFail("TaxAppliedonMultipleProductsAtCandaianAddress", "Order created from Clipboard in WESP UnSuccessfully");

		   	 }
	      
	   		
	   		Thread.sleep(10000);
	   		
//	   		WespOrder.CloseOrder_Icon.click();

	   		 //Close new Browser Tab
	   		 
	   		
   	  }
	     
	     catch(NoSuchElementException e)
	   	  {
	   	  e.getStackTrace();
	   	  }
	     }




}
