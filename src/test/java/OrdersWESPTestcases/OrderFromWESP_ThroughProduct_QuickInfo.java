package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;

public class OrderFromWESP_ThroughProduct_QuickInfo extends WESPORDER {

	public static void OrderFromWESP_ProductQuickInfo() throws InterruptedException, IOException{
	  	  
	  	  try{
	  		
	  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	  		 
	  		 
	  		  //Hover to the Order button on searched product
	  		  
	  		
	  		  Click("Click order button",   WespOrder.ProductImageHover);

	  	
	  		  
	  		  Click("Click order button",  WespOrder.ProductOrderButton_QuickInfo);
	  		  
	  		  Thread.sleep(2000);
	  
	  		 
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
	  			 System.out.println("Order Created from WESP through Product QuickInfo  Successfully");
	  			 resultPass("OrderCreation_FromWESP_ThroughProductQuickInfo", "Order Created from WESP through Product QuickInfo  Successfully");
	  		 }
	  		 else{
	  			 System.out.println("Order Created from WESP through Product QuickInfo  UnSuccessfully");
	  			 resultFail("OrderCreation_FromWESP_ThroughProductQuickInfo", "Order Created from WESP through Product QuickInfo UnSuccessfully");
	  		 }
	  	  
	  		 //Close new Browser Tab
	  		 driver.close();
	  		 
	  		 Thread.sleep(2000);
	  		 
	  		 //Switch back to parent window 
	  	     driver.switchTo().window(parentWindow);
	  	        
	  	    //Close Quick Info for Product
	  	//     WespOrder.ProductQuickInfo_Close.click();
	  	     
	  	     Thread.sleep(3000);
	  	  
	  	  
	  	  }
	    
	    catch(NoSuchElementException e)
	  	  {
	  	  e.getStackTrace();
	  	  }
	    }





}
