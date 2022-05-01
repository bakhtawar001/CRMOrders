package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;


public class OrderFromWESP_ThroughCompare extends WESPORDER {

	public static void OrderFromWESP_Comparing() throws InterruptedException, IOException{
  	  
  	  try{
  		
  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
  		  Thread.sleep(2000);
  		  
  		
  		  Click("Click at compare button", WespOrder.Product_CompareDefaultButton);
  		  
  		  Thread.sleep(5000);
  		  
  		//Click the Product Compare Count Button
  		  WespOrder.ProductCompare_CountButton.click();
  		  
  		  Thread.sleep(3000);
  		  
  	   //Press the Order button on compare Screen
  		  WespOrder.ProductCompare_OrderButton.click();
  		  
  		  Thread.sleep(3000);
  
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



