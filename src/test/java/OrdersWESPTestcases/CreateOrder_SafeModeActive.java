package OrdersWESPTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class CreateOrder_SafeModeActive extends WESPORDER {

	 public static void OrderFromWESP_SafeModeActive() throws InterruptedException, IOException, ParseException{
   	  
   	  try{
   		
   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);

   		  //Go to ESP Web Tab
   //		  WespOrder.ESPWeb_Tab.click();
   		  
   		  Thread.sleep(5000);
   		  
   		//Click the userInfoIcon on My Order screen	 
   		WespOrder.OrderListing_UserInfoIcon.click();
   		 
   		 Thread.sleep(3000);
   		 
   		// WespOrder.Settings_SafeMode_ToggleStatusButton.click();
   		 
   		 if(!WespOrder.Settings_SafeMode_ToggleGetStatusButton.isSelected()) {
   			 WespOrder.Settings_SafeMode_ToggleStatusButton.click();
   		 }
   		 
   		
   	//Go to ESP Web Tab
  		  WespOrder.ESPWeb_Tab.click();
  		  
  		  Thread.sleep(4000);
   		  //Search for the Product
   		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.HitPromotionalProduct);
   		  
   		  Thread.sleep(1000);
   		  
   		  //Press the search button
   		  WespOrder.ProductQuickSearchButton.click();
   		  
   		  Thread.sleep(10000);
   		  
   		  //Search asi number within search terms
   		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.HitPromotionalProductNumber);
   		  
   		  Thread.sleep(1000);
   		  
   		  //Press the search with terms go button
   		  WespOrder.SearchWithinTerms_GoButton.click();
   		  
   		  Thread.sleep(12000);
   		  
   		
   		  
   		  //Click the E-Comm order button now
   		  Click("Click at order button",  WespOrder.Product_OrderButton);
   		  Thread.sleep(6000);
 		  Thread.sleep(2000);
    		 List<WebElement> records = WespOrder.Price_Grid;
    	  int record=records.size();
    	  System.out.println(record);
    	  //Enter The Quantity on Quatity screen
    	  if(record>=1) {
    	  		Click("Click at Select button of price grid", WespOrder.ClickAtSelect);
    	  		Click("Click at continue button", WespOrder.CreateOrder_Configure_Continue_Button);
    	  		WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
    	  }
    	  else {
    	  		Click("Click at continue button", WespOrder.CreateOrder_Configure_Continue_Button);
    		  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
    	  }
    		 
    		  ConfigurePro();
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
   			 System.out.println("Order Created from WESP through Product Searching While Client Safe Mode Active Successfully");
   			 resultPass("OrderCreation_FromWESP_ClientSafeModeActive", "Order Created from WESP through Product Searching While Client Safe Mode Active Successfully");
   		 }
   		 else{
   			 System.out.println("Order Created from WESP through Product Searching While Client Safe Mode Active UnSuccessfully");
   			 resultFail("OrderCreation_FromWESP_ClientSafeModeActive", "Order Created from WESP through Product Searching While Client Safe Mode Active UnSuccessfully");
   		 }
   	  
   		 Thread.sleep(4000);
   		 
   		
 			  
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
