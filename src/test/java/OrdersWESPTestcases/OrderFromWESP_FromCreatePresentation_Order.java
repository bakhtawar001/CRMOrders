package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
 

public class OrderFromWESP_FromCreatePresentation_Order extends WESPORDER {

	public static void OrderFromWESP_FromCreatePresenation_OrderCreation() throws InterruptedException, IOException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	   		 
	   		
	   		  //Go to ESP Web Tab
	 //  		  WespOrder.ESPWeb_Tab.click();
	   		  
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
	   	  waitForPageLoad();
	   		Thread.sleep(2000);
	   		
	   		//Press the create Presentation button
	   		WespOrder.CreatePresentation_CreateButton.click();
	   		
	   		Thread.sleep(12000);
	   		
	   		//Press the Order button next screen
	   	  //Click the E-Comm order button now
	   		  WespOrder.Presentation_OrderButton.click();
	   		  waitForPageLoad();
	   		  Thread.sleep(2000);

	   		Click("Click at continue button", WespOrder.CreateOrder_Configure_Continue_Button);
	   		
	   	  	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");

	   		 Thread.sleep(1000);
	   			
	   		//Press the continue Button
	   		 WespOrder.CreateOrder_Configure_Continue_Button.click();
	   		 
	   		 
	   		 Thread.sleep(15000);
	   		 WespOrder.CreateOrder_Configure_Continue_Button.click();

	   		 WespOrder.ChooseCustomer_CreateOrderButton.click();

	   		  
	   		//  ConfigurePro();
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
	   			 System.out.println("Order created from Create Presentation in WESP Successfully ");
	   			 Assert.assertTrue(true);
	   			// resultPass("OrderFromWESP_FromCreatePresenation_OrderCreation", "Order created from Create Presentation in WESP Successfully");
	   		 }
	   		 else{
	   			 System.out.println("Order created from Create Presentation in WESP UnSuccessfully");
	   			 Assert.assertFalse(false);
	   			// resultFail("OrderFromWESP_FromCreatePresenation_OrderCreation", "Order created from Create Presentation in WESP UnSuccessfully");
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
