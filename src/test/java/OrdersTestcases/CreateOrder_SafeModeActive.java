package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class CreateOrder_SafeModeActive extends WESPORDER {

	 public static void OrderFromWESP_SafeModeActive() throws InterruptedException, IOException, ParseException{
   	  
   	  try{
   		
   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);

   		  //Go to ESP Web Tab
   		  WespOrder.ESPWeb_Tab.click();
   		  
   		  Thread.sleep(5000);
   		  
   		//Click the userInfoIcon on My Order screen	 
   		WespOrder.OrderListing_UserInfoIcon.click();
   		 
   		 Thread.sleep(3000);
   		 
   		 WespOrder.Settings_SafeMode_ToggleStatusButton.click();
   		 
   		 Thread.sleep(3000);
   		  
   	//Go to ESP Web Tab
  		  WespOrder.ESPWeb_Tab.click();
  		  
  		  Thread.sleep(5000);
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
   		  
   		  //Hover to the Order button on searched product
   		  
   		  WebElement HoverOrder=WespOrder.Product_OrderButton;
   		  Hover(HoverOrder);
   			
   		  Thread.sleep(1000); 
   		  
   		  //Click the E-Comm order button now
   		  WespOrder.Product_OrderButton.click();
   		  
   		  Thread.sleep(6000);
   		  
   		if(driver.getCurrentUrl().contains("stage"))
   		{
   		
   		//Enter The Quantity on Quatity screen
    		  WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("500");
   		}
   			
   		else{
   			
  		//Click the Select Button
   		
		 WespOrder.ShoppingCartProduct_SelectButton.click();
		  
		wait = new WebDriverWait(driver, 180);
	    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_Configure_QTY_TextField));
	   
	   Thread.sleep(2000);
		
	 //Enter The Quantity on Quatity screen
		  WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("500");
   		
   		
   		}	
   			
   		 Thread.sleep(1000);
   			
   		//Press the continue Button
   		 WespOrder.CreateOrder_Configure_Continue_Button.click();
   		 
   		 Thread.sleep(1000);
   		 
   	//Press the continue Button
   		 WespOrder.CreateOrder_Configure_Continue_Button.click();
   		 
   		 Thread.sleep(2000);
   		  
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
   	     
   	//Click the userInfoIcon on My Order screen	 
    		WespOrder.OrderListing_UserInfoIcon.click();
    		 
    		 Thread.sleep(3000);
    		 
    		 WespOrder.Settings_SafeMode_ToggleStatusButton.click();
    		 
    		 Thread.sleep(3000);
   	  
   	  }
     
     catch(NoSuchElementException e)
   	  {
   	  e.getStackTrace();
   	  }
     }




}
