package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
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
  		
  		  
  		//  Click("Click at ESP Web tab",  WespOrder.ESPWeb_Tab);
		  Thread.sleep(15000);
		  
		  //Search for the Product
		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.SearchResult_ProductName);
		  
		  Thread.sleep(1000);
		  
		  //Press the search button
		  WespOrder.ProductQuickSearchButton.click();
		  
		  waitForPageLoad();
		  
		  //Search asi number within search terms
		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.SearchResult_ProductNumber);
		  
		  Thread.sleep(1000);
		  
		  //Press the search with terms go button
		  WespOrder.SearchWithinTerms_GoButton.click();
		  
		  waitForPageLoad();
  		  
  		  
  		  //Hover to the Order button on searched product
  		  
  		  WebElement HoverOrderQuickInfo=WespOrder.ProductImageHover;
  		  Hover(HoverOrderQuickInfo);
  			
  		  Thread.sleep(3000); 
  		  
  		  //Click the E-Comm order button now
  		  WespOrder.Product_OrderButton.click();
  		  
  		  Thread.sleep(3000);
  		  
  		//Enter The Quantity on Quatity screen
  	
  		
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
