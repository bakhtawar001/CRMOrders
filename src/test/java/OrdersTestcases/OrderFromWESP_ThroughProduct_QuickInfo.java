package OrdersTestcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;

public class OrderFromWESP_ThroughProduct_QuickInfo extends WESPORDER {

	public static void OrderFromWESP_ProductQuickInfo() throws InterruptedException, IOException{
	  	  
	  	  try{
	  		
	  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	  		 
	  		 
	  		  //Hover to the Order button on searched product
	  		  
	  		 WespOrder.ProductImageHover.click();
	  		 
	  		 //Wait for Order button to appear
	  		wait = new WebDriverWait(driver, 180);
	  	   wait.until(ExpectedConditions.elementToBeClickable(WespOrder.ProductOrderButton_QuickInfo));
	  		 
	  			
	  		  Thread.sleep(2000); 
	  		  
	  		  //Click the E-Comm order button now
	  		  WespOrder.ProductOrderButton_QuickInfo.click();
	  		  
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
	  		 
	           //WespOrder.CreateOrder_Configure_Continue_Button.click();
	  		 
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
	  	     WespOrder.ProductQuickInfo_Close.click();
	  	     
	  	     Thread.sleep(3000);
	  	  
	  	  
	  	  }
	    
	    catch(NoSuchElementException e)
	  	  {
	  	  e.getStackTrace();
	  	  }
	    }





}
