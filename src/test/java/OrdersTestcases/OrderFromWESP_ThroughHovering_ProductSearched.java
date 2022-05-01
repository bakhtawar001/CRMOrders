package OrdersTestcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;


public class OrderFromWESP_ThroughHovering_ProductSearched extends WESPORDER{

	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static JavascriptExecutor jse2;
	public static void OrderFromWESP_WithHoveringProduct() throws InterruptedException, IOException{
  	  
  	  try{
  		
  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
  		 
  	
  		  
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
		  
		  Thread.sleep(16000);
  		  
  		  
  		  //Hover to the Order button on searched product
  		  
  		  WebElement HoverOrderQuickInfo=WespOrder.ProductImageHover;
  		  Hover(HoverOrderQuickInfo);
  			
  		  Thread.sleep(3000); 
  		  
  		  //Click the E-Comm order button now
  		  WespOrder.Product_OrderButton.click();
  		  
  		  Thread.sleep(3000);
  		  
  		  
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
  		 
          // WespOrder.CreateOrder_Configure_Continue_Button.click();
  		 
  		 //Thread.sleep(1000);
  		 
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
  			 System.out.println("Order Created from WESP through Hovering Product  Successfully");
  			 resultPass("OrderCreation_FromWESP_ThroughHoveringProduct", "Order Created from WESP through Hovering Product  Successfully");
  		 }
  		 else{
  			 System.out.println("Order Created from WESP through Hovering Product  UnSuccessfully");
  			 resultFail("OrderCreation_FromWESP_ThroughHoveringProduct", "Order Created from WESP through Hovering Product  UnSuccessfully");
  		 }
  	  
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
