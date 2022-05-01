package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;


public class OrderFromWESP_ThroughCompare extends WESPORDER {

	public static void OrderFromWESP_Comparing() throws InterruptedException, IOException{
  	  
  	  try{
  		
  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
  		 
  		  
  		  //Hover to the Compare button on searched product
  		  
  		  WebElement HoverCompare=WespOrder.Product_CompareDefaultButton;
  		  Hover(HoverCompare);
  			
  		  Thread.sleep(1000); 
  		  
  		  //Click the Compare button now
  		  WespOrder.Product_CompareDefaultButton.click();
  		  
  		  Thread.sleep(8000);
  		  
  		//Click the Product Compare Count Button
  		  WespOrder.ProductCompare_CountButton.click();
  		  
  		  Thread.sleep(3000);
  		  
  	   //Press the Order button on compare Screen
  		  WespOrder.ProductCompare_OrderButton.click();
  		  
  		  Thread.sleep(3000);
  		  
  	 //Enter The Quantity on Quatity screen
  		  WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
  			
  		 Thread.sleep(1000);
  			
  		//Press the continue Button
  		 WespOrder.CreateOrder_Configure_Continue_Button.click();
  		 
  		 Thread.sleep(1000);
  		 
          // WespOrder.CreateOrder_Configure_Continue_Button.click();
  		 
  		// Thread.sleep(1000);
  		 
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
  			 System.out.println("Order Created from WESP through Product Compare Successfully");
  			 resultPass("OrderCreation_FromWESP_ThroughCompare", "Order Created from WESP through Product Compare Successfully");
  		 }
  		 else{
  			 System.out.println("Order Created from WESP through Product Compare UnSuccessfully");
  			 resultFail("OrderCreation_FromWESP_ThroughCompare", "Order Created from WESP through Product Compare UnSuccessfully");
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



