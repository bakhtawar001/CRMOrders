package OrdersTestcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
 

public class OrderFromWESP_FromCreatePresentation_Order extends WESPORDER {

	public static void OrderFromWESP_FromCreatePresenation_OrderCreation() throws InterruptedException, IOException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	   		 
	   		  
	   		  //Go to ESP Web Tab
	   		  WespOrder.ESPWeb_Tab.click();
	   		  
	   		  Thread.sleep(5000);
	   		  
	   		  //Click the Clip board ICon
	   		  WespOrder.Clipboard_Icon.click();
	   		  
	   		  Thread.sleep(5000);
	   		  
	   		  //Check the first Product in clipboard list
	   		  WespOrder.ClipboardProduct_CheckboxSelection.click();
	   		  
	   		  Thread.sleep(2000);
	   		  
	   		  //Now the click the create Presentation button
	   		  WespOrder.Clipboard_CreatePresentation.click();
	   		  
	   		  Thread.sleep(3000);
	   		  
	   		  //Enter the Presenation Name
	   		  WespOrder.CreatePresentation_NameField.sendKeys("Test Automation Presentation");
	   		  
	   		  //Click the company field and search the company
	   		  WespOrder.CreatePresentation_CompanyField.click();
	   		  
	   		  Thread.sleep(4000);
	   		  
	   		  //Now Search the company
	   		  WespOrder.CreatePresentation_CompanyFieldSearch.sendKeys("Auto-");
	   		  
	   		  Thread.sleep(6000);
	   		  
	   		WespOrder.CreatePresentation_CompanyFieldSearch.sendKeys(Keys.ENTER);
	   		
	   		Thread.sleep(2000);
	   		
	   		//Press the create Presentation button
	   		WespOrder.CreatePresentation_CreateButton.click();
	   		
	   		Thread.sleep(12000);
	   		
	   		//Press the Order button next screen
	   	  //Click the E-Comm order button now
	   		  WespOrder.Presentation_OrderButton.click();
	   		  
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
	   		 
	         WespOrder.CreateOrder_Configure_Continue_Button.click();
	   		 
	   		 Thread.sleep(5000);
	   		 
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
	   			 System.out.println("Order created from Create Presentation in WESP Successfully ");
	   			 resultPass("OrderFromWESP_FromCreatePresenation_OrderCreation", "Order created from Create Presentation in WESP Successfully");
	   		 }
	   		 else{
	   			 System.out.println("Order created from Create Presentation in WESP UnSuccessfully");
	   			 resultFail("OrderFromWESP_FromCreatePresenation_OrderCreation", "Order created from Create Presentation in WESP UnSuccessfully");
	   		 }
	   	  
	   		 //Close new Browser Tab
	   		 driver.close();
	   		 
	   		 Thread.sleep(2000);
	   		 
	   		 //Switch back to parent window 
	   	     driver.switchTo().window(parentWindow);
	   	       
	   	     Thread.sleep(1000);
	   	  
	   	  
	   	  
	   	  }
	     
	     catch(NoSuchElementException e)
	   	  {
	   	  e.getStackTrace();
	   	  }
	     }

	



















}
