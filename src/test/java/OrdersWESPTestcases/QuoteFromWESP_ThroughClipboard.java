package OrdersWESPTestcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class QuoteFromWESP_ThroughClipboard extends WESPORDER {

	public static void QuoteFromWESP_FromClipboard() throws InterruptedException, IOException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	   		  Thread.sleep(15000);
		//  WespOrder.ESPWeb_Tab.click();
    		  
    		  Thread.sleep(5000);
    		  
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
	   		 
    		
    		  Click("Save to clicpboard", WespOrder.Order_SavetoclipboardButton);
    		  Thread.sleep(10000);
	   		  
	   		  //Click the Clip board ICon
	   		  WespOrder.Clipboard_Icon.click();
	   		  
	   		  Thread.sleep(5000);
	   		  
	   		  //Check the first Product in clipboard list
	   		  WespOrder.ClipboardProduct_CheckboxSelection.click();
	   		  
	   		  Thread.sleep(2000);

	   		  
	   		  Thread.sleep(2000);
	   		  
	   		  //Press the Create Quote toggle
	   		  WespOrder.CreateQuote_Toggle.click();
	   		  
	   		  Thread.sleep(2000);
	   		  
	   		  //Press the Create Quote Option
	   		  WespOrder.CreateQuote_FromClipboard_ThroughOrderButton.click();
	   		  
	   		  Thread.sleep(10000);
	   		  
	   		
	   		 
	   		//First store parent window to switch back
	   		 String parentWindow = driver.getWindowHandle();
	   		 
	   		
	   		 
	   		//Switch to new window opened
	   		  	for(String winHandle : driver.getWindowHandles()){
	   		  	    if(!winHandle.equals(parentWindow)) {
	   		  	        driver.switchTo().window(winHandle);
	   		  	    }
	   		  	}
	   		  
	   		 
	   		 Thread.sleep(2000);
	   		 
	   		 //Select the company first on create order screen
	   		WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	  	 
	  	   Thread.sleep(2000);
	  	 
	  	   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	   		
	  	   Thread.sleep(6000);
	  	   
	  	 WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	  	 
	  	 Thread.sleep(10000);
	   		 
	   		 //Hover the configure button
	   	    WebElement HoverConfigure=WespOrder.CreateOrders_ConfigureButton;
	   		Hover(HoverConfigure);
	   		
	   		Thread.sleep(1000);
	   		
	   		//Now Click the Configure Button
	   		WespOrder.CreateOrders_ConfigureButton.click();
	   		
	   		Thread.sleep(2000);
	   		
	   		//Enter The Quantity on Quatity screen
	   	  List<WebElement> records = WespOrder.Price_Grid;
		  int record=records.size();
		  //Enter The Quantity on Quatity screen
		  if(record>=1) {
		  	
		  	Thread.sleep(2000);
		  	  Click("Click at Select button of price grid", WespOrder.ClickAtSelect);
		  	Thread.sleep(2000);
		  	Click("Click continue button", WespOrder.CreateOrder_Configure_Continue_Button);
		  	Thread.sleep(2000);
		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("70");
		  }
		  else {
		  	Thread.sleep(2000);
		  	Click("Click continue button", WespOrder.CreateOrder_Configure_Continue_Button);
		  	Thread.sleep(2000);
		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("70");
		  }
	   		
	   		Thread.sleep(1000);
	   		
	   		//Press the continue Button
	   		WespOrder.CreateOrder_Configure_Continue_Button.click();
	   		
	   		//Decoration Optional Screen Appear Press the save button now to create a Order
	   		WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	   		
	   		if(WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	   		{
	   		 System.out.println("Quote Created from clipboard Successfully");
	   		 resultPass("QuoteFromWESP_ThroughClipboard", "Quote Created from clipboard Successfully");
	   		}
	   		else{
	   		
	   			System.out.println("Quote Created from clipboard UnSuccessfully");
	   			resultFail("QuoteFromWESP_ThroughClipboard", "Quote Created from clipboard UnSuccessfully");
	   		}	

	   	      Thread.sleep(5000);
	   		 
	   	      //Close new Browser Tab
	   		 driver.close();
	   		 
	   		 Thread.sleep(2000);
	   		 
	   	//Switch back to parent window 
	   	     driver.switchTo().window(parentWindow);
	   		 Thread.sleep(10000);
	   		 //Delete the clipboard Product
	   		 WespOrder.Delete_ClipboardProduct.click();
	   		 
	   		 Thread.sleep(2000);
	   		 
	   		 WespOrder.ClipboardDeleteConfirm.click();
	   		 
	   		 Thread.sleep(5000);
	   		 
	   	       
	
	   	  
	   	  
	   	  }
	     
	     catch(NoSuchElementException e)
	   	  {
	   	  e.getStackTrace();
	   	  }
	     }





}
