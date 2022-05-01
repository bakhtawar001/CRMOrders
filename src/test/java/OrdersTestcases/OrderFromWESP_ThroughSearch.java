package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Functions.ConversionsWithoutOtherCharges;
import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderFromWESP_ThroughSearch extends WESPORDER {

	public static String parentWindow3;
      public static void OrderFromWESP_WithSearchProduct() throws InterruptedException, IOException, ParseException{
    	  
    	  try{
    		
    		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);

    		   	
    		  Thread.sleep(3000);
    		
    		  //Go to ESP Web Tab
    		  WespOrder.ESPWeb_Tab.click();
    		  
    		  Thread.sleep(5000);
    		  
    		  //Search for the Product
    		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.SearchResult_ProductName);
    		  
    		  Thread.sleep(1000);
    		  
    		  //Press the search button
    		  WespOrder.ProductQuickSearchButton.click();
    		  
    		  Thread.sleep(10000);
    		  
    		  //Search asi number within search terms
    		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.SearchResult_ProductNumber);
    		  
    		  Thread.sleep(1000);
    		  
    		  //Press the search with terms go button
    		  WespOrder.SearchWithinTerms_GoButton.click();
    		  
    		  Thread.sleep(12000);
    		  
    		  //Hover to the Order button on searched product
    		  
    	
    		  
    		  Click("a", WespOrder.Product_OrderButton);
    		  
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
    			 System.out.println("Order Created from WESP through Product Searching Successfully");
    			 resultPass("OrderCreation_FromWESP_ThroughSearching", "Order Created from WESP through Product Searching Successfully");
    		 }
    		 else{
    			 System.out.println("Order Created from WESP through Product Searching UnSuccessfully");
    			 resultFail("OrderCreation_FromWESP_ThroughSearching", "Order Created from WESP through Product Searching UnSuccessfully");
    		 }
    	  
    		 Thread.sleep(4000);
    		 
    		 //Conversion TotalCost
       		 ConversionsWithoutOtherCharges.CanadianProduct_TotalCost_String_To_Int_Conversion();
       		 
       		 //Conversion TotalPrice
       		 ConversionsWithoutOtherCharges.CanadianProduct_TotalPrice_String_To_Int_Conversion();
       		 
        	//Discount Conversion
       		 ConversionsWithoutOtherCharges.CanadianProduct_Discount_String_To_Int_Conversion(); 
       		 
       		 
       		 ConversionsWithoutOtherCharges.BookedMarginCalculation();
       		 
       		 //Rounding off
       		 ConversionsWithoutOtherCharges.RoundingOffBooked();
       		 
       		 //BookedMargin Conversion
       		 ConversionsWithoutOtherCharges.CanadianProduct_BookedMargin_String_To_Int_Conversion();
       		 
       		 if(ConversionsWithoutOtherCharges.bd1.doubleValue()==ConversionsWithoutOtherCharges.BookedMargin)
       		 {
       			 System.out.println("Booked Margin Calculated Successfully after creating Order and Product");
       			 resultPass("BookedMargin_Verification_AfterOrderandProduct_Creation", "Booked Margin Calculated Successfully after creating Order and Product");
       		 }
       		 else{
       			System.out.println("Booked Margin Calculated UnSuccessfully");
      			 resultFail("BookedMargin_Verification_AfterOrderandProduct_Creation", "Booked Margin Calculated UnSuccessfully after creating Order and Product");
       		 }
       		 
       	//Hover the Edit button
     	 /*   WebElement HoverEdit= WespOrder.OrdersDetails_EditButton;
     	 	Hover(HoverEdit);
     	 	
     	 	Thread.sleep(1000);
     	 	
     	 
       	//Click the Edit button
       		 WespOrder.OrdersDetails_EditButton.click();*/
       		 Click("a", WespOrder.OrdersDetails_EditButton);
       		
       	     Thread.sleep(7000);
    		 
       	//Change the cost
       	     WespOrder.Netcost_Field_BookedMargin.click();
       	     
       	     WespOrder.Netcost_Field_BookedMargin.sendKeys("35");
       	     
       	     Thread.sleep(1000);
       	     
       	 //Change the Margin
       	    
       	     WespOrder.Margin_Field_BookedMargin.click();
       	     
       	     WespOrder.Margin_Field_BookedMargin.sendKeys("25");
       	     
       	     Thread.sleep(1000);
       	     
       	 //Change the Price
       	     WespOrder.Price_Field_BookedMargin.click();
       	     
       	     WespOrder.Price_Field_BookedMargin.sendKeys("40");
       	     
       	     Thread.sleep(1000);
       	     
       	 //Save the Details
       	     WespOrder.ProductConfiguration_AddCharge_SaveButton.click();
       	     
       	     Thread.sleep(10000);
    		 
       	  //Conversion TotalCost
       		 ConversionsWithoutOtherCharges.CanadianProduct_TotalCost_String_To_Int_Conversion();
       		 
       		 //Conversion TotalPrice
       		 ConversionsWithoutOtherCharges.CanadianProduct_TotalPrice_String_To_Int_Conversion();
       		 
        	//Discount Conversion
       		 ConversionsWithoutOtherCharges.CanadianProduct_Discount_String_To_Int_Conversion(); 
       		 
       		 
       		 ConversionsWithoutOtherCharges.BookedMarginCalculation();
       		 
       		 //Rounding off
       		 ConversionsWithoutOtherCharges.RoundingOffBooked();
       		 
       		 //BookedMargin Conversion
       		 ConversionsWithoutOtherCharges.CanadianProduct_BookedMargin_String_To_Int_Conversion();
       		 
       		 if(ConversionsWithoutOtherCharges.bd1.doubleValue()==ConversionsWithoutOtherCharges.BookedMargin)
       		 {
       			 System.out.println("Booked Margin Calculated Successfully after Editing Product Cost,Margin and Price");
       			 resultPass("BookedMargin_Verification_AfterEditing_Product(Cost,Margin,Price)", "Booked Margin Calculated Successfully after Editing Product Cost,Margin and Price");
       		 }
       		 else{
       			System.out.println("Booked Margin Calculated Successfully after Editing Product Cost,Margin and Price");
      			 resultFail("BookedMargin_Verification_AfterEditing_Product(Cost,Margin,Price)", "Booked Margin Calculated UnSuccessfully after Editing Product Cost,Margin and Price");
       		 }
       		Thread.sleep(4000);
       	//Press Add Product Button
       		WespOrder. CreateOrder_AddProductButton.click();

       	    Thread.sleep(4000);

       	//Go To Product Search Tab in popup
       	 WespOrder.AddProduct_Clipboard_US_Product.click();

       	    Thread.sleep(2000);

       	  //Press the Add Products Button to complete the process
       	 WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


       		
       	String ProductAddedToOrderSuccess=WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

       	if(ProductAddedToOrderSuccess.contains("Success"))
       	{
       		   System.out.println("New Product Added  Successfully");
       		  
       	}
       	else{
       		   System.out.println("New Product Added  UnSuccessfully");
       		  
       	}
       	  Thread.sleep(10000);
       		 
       	//Hover the configure button
       /*   WebElement HoverConfigure=WespOrder.CreateOrders_ConfigureButton;
      	Hover(HoverConfigure);
      	
      	Thread.sleep(1000);
      	
      	//Now Click the Configure Button
      	WespOrder.CreateOrders_ConfigureButton.click();*/
       	  Click("A", WespOrder.CreateOrders_ConfigureButton);
      	
      	Thread.sleep(2000);
      	
      	//Enter The Quantity on Quatity screen
        List<WebElement> records1 = WespOrder.Price_Grid;
		  int record1=records1.size();
		  //Enter The Quantity on Quatity screen
		  if(record1>=1) {
		  	
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
      	
      	//Decoration Optional Screen Appear Press the save button now to create a Order
      	WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
      	
      	if(WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
      	{
      	 System.out.println("New Product Configured Successfully");
      	 
      	}
      	else{
      	
      		System.out.println("New Product Configured UnSuccessfully");
      		
      	}
      //Conversion TotalCost
  		 ConversionsWithoutOtherCharges.CanadianProduct_TotalCost_String_To_Int_Conversion();
  		 
  		 //Conversion TotalPrice
  		 ConversionsWithoutOtherCharges.CanadianProduct_TotalPrice_String_To_Int_Conversion();
  		 
   	//Discount Conversion
  		 ConversionsWithoutOtherCharges.CanadianProduct_Discount_String_To_Int_Conversion(); 
  		 
  		 
  		 ConversionsWithoutOtherCharges.BookedMarginCalculation();
  		 
  		 //Rounding off
  		 ConversionsWithoutOtherCharges.RoundingOffBooked();
  		
  		 //Conversion 2nd Product TotalCost
  		 ConversionsWithoutOtherCharges.BookedMargin_TotalCost_String_To_Int_Conversion();
  		
  		 //Conversion 2nd Product TotalPrice
  		 ConversionsWithoutOtherCharges.BookedMargin_TotalPrice_String_To_Int_Conversion();
  		
  		 //2nd Product Calculation for Margin
  		 ConversionsWithoutOtherCharges.BookedMarginCalculation_With_MultipleProducts();
  		 //Sum for both Products Margin Total
  		 ConversionsWithoutOtherCharges.BookedMarginCalculation_MultipleProducts_Sum();
  		 
  		 //Rounding off Total value
  		 ConversionsWithoutOtherCharges.RoundingOffMultipleProducts_BookedMargin();
  		 
  		 //BookedMargin Conversion
  		 ConversionsWithoutOtherCharges.CanadianProduct_BookedMargin_String_To_Int_Conversion();
       	
  		if(ConversionsWithoutOtherCharges.bd2.doubleValue()==ConversionsWithoutOtherCharges.BookedMargin)
  		{
  		 System.out.println("Booked Margin With Multiple Products Calculated Successfully");
  		 resultPass("BookedMargin_Calculation_With_MultipleProducts", "Booked Margin With Multiple Products Calculated Successfully"); 
  		}
  		else{
  			System.out.println("Booked Margin With Multiple Products Calculated UnSuccessfully");
  	  		 resultFail("BookedMargin_Calculation_With_MultipleProducts", "Booked Margin With Multiple Products Calculated UnSuccessfully"); 
  		}
  			
  			Thread.sleep(2000);  
       	     //Close new Browser Tab
    		 driver.close();
    		 
    		 Thread.sleep(2000);
    		 
    		 //Switch back to parent window 
    	     driver.switchTo().window(parentWindow);
    	        
    	  //Now Search A QUR Product now
    	   //Search for the Product
   		  if(driver.getCurrentUrl().contains("stage"))
   		  {	  
    	  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.QURProduct_BookedMargin);
   		  
   		  Thread.sleep(1000);
   		  
   		  //Press the search button
   		  WespOrder.ProductQuickSearchButton.click();
   		  
   		  Thread.sleep(15000);
   
   		 //Hover to the Order button on searched product
		  
   		  driver.navigate().refresh();
   		  
   		  Thread.sleep(5000);
   		  
   		  
   		  WebElement HoverOrder1=WespOrder.ProductImageHover;
		  Hover(HoverOrder1);
			
		  Thread.sleep(4000); 
		  
		  //Click the E-Comm order button now
		  WespOrder.Product_OrderButton.click();
		  
		  Thread.sleep(5000);
		  
		//Click the Select Button
  		  WespOrder.ShoppingCartProduct_SelectButton.click();
  		  
  		wait = new WebDriverWait(driver, 180);
  	    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_Configure_QTY_TextField));
  	   
  	   Thread.sleep(2000);
  		  
  		//Enter The Quantity on Quatity screen
  	  List<WebElement> records2 = WespOrder.Price_Grid;
	  int record2=records2.size();
	  //Enter The Quantity on Quatity screen
	  if(record2>=1) {
	  	
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
		 
		//Press the continue Button
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
		 parentWindow3 = driver.getWindowHandle();
		 
		 //Press the Create Order Button
		 WespOrder.ChooseCustomer_CreateOrderButton.click();
		 
		 Thread.sleep(15000);
   		  
		 
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow3)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	
   		  }
   		 
   		  else{
   			WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.QURProduct_BookedMarginUATProd);
     		  
     	    Thread.sleep(1000); 
   		 
   		  
     	 //Press the search button
     		  WespOrder.ProductQuickSearchButton.click();
     		  
     		  Thread.sleep(15000);
     
     		 //Hover to the Order button on searched product
  		  
     		  driver.navigate().refresh();
     		  
     		  Thread.sleep(5000);
     		  
     		  
     		  WebElement HoverOrder1=WespOrder.ProductImageHover;
     		  Hover(HoverOrder1);
  			
  		  Thread.sleep(4000); 
  		  
  		  //Click the E-Comm order button now
  		  WespOrder.ProductHover_OrderButton.click();
  		  
  		  Thread.sleep(5000);
  		  
  		//Click the Select Button
    		  WespOrder.ShoppingCartProduct_SelectButton.click();
    		  
    		wait = new WebDriverWait(driver, 180);
    	    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_Configure_QTY_TextField));
    	   
    	   Thread.sleep(2000);
    		  
    		//Enter The Quantity on Quatity screen
    	   List<WebElement> records3 = WespOrder.Price_Grid;
 		  int record3=records3.size();
 		  //Enter The Quantity on Quatity screen
 		  if(record3>=1) {
 		  	
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
   		  
  		 //Choose the customer to create Order
		 WespOrder.ChooseCustomer_TextField.click();
		 
		 Thread.sleep(2000);
		 
		 WespOrder.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
		 
		 Thread.sleep(6000);
		 
		 WespOrder.ChooseCustomer_SearchInsertion.sendKeys(Keys.ENTER);
		 
		 Thread.sleep(10000);
		 
		//First store parent window to switch back
		 parentWindow3 = driver.getWindowHandle();
		 
		 //Press the Create Order Button
		 WespOrder.ChooseCustomer_CreateOrderButton.click();
		 
		 Thread.sleep(15000);
   		  
		 
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow3)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
   		  
   		  }
   		  
		  //Validating as if the Order Created Successfully Or Not From WESP
   		 if(WespOrder.CanadianProductOrder_BookedMargin.getText().contains("$0.00"))
   		 {
   			 System.out.println("Order created with QUR Product Successfully with Booked Margin value 0.00 display successfully");
   			 resultPass("OrderCreation_FromWESP_WithQURProduct_WithBookedMargin_Verification", "Order created with QUR Product Successfully with Booked Margin value 0.00 display successfully");
   		 }
   		 else{
   			 System.out.println("Order created with QUR Product UnSuccessfully with Booked Margin value 0.00 display unsuccessfully");
   			 resultFail("OrderCreation_FromWESP_WithQURProduct_WithBookedMargin_Verification", "Order created with QUR Product UnSuccessfully with Booked Margin value 0.00 display unsuccessfully");
   		 }
   	  
   		 Thread.sleep(4000);
		  
   		driver.close();
		 
		 Thread.sleep(2000);
		 
		 //Switch back to parent window 
	     driver.switchTo().window(parentWindow3);

    	  }
      
      catch(NoSuchElementException e)
    	  {
    	  e.getStackTrace();
    	  }
      }



















}
