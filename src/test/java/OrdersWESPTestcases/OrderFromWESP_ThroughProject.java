package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderFromWESP_ThroughProject extends WESPORDER {

	public static void OrderFromWESP_Projects() throws InterruptedException, IOException{
	  	  
	  	  try{
	  		
	  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	  		 
	  		  //Now Delete the Product from Compare
	 //	WespOrder.RemoveProductButton_FromCompare.click();
	  		  
	  		  Thread.sleep(5000);
	  		  
	  		//Go to ESP Web Tab
    //		  WespOrder.ESPWeb_Tab.click();
    		  
    		  Thread.sleep(5000);
    		  
    		  //Search for the Product
    		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.Project_ProductName);
    		  
    		  Thread.sleep(1000);
    		  JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].click();", WespOrder.ProductQuickSearchButton);
    		  //Press the search button
    		 // WespOrder.ProductQuickSearchButton.click();
    		  
    		  waitForPageLoad();
    		  RefreshPage();
    		  Thread.sleep(2000);
    		  //Search asi number within search terms
    		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.Project_ProductNumber);
    		  
    		  Thread.sleep(1000);
    		  
    		  //Press the search with terms go button
    		  WespOrder.SearchWithinTerms_GoButton.click();
    		 
    		  waitForPageLoad();
    		  Thread.sleep(6000);
	  		 
	  		  //Checked the Searched Product Checkbox
	  		  WespOrder.ProductMark_Checkbox.click();
	  		  
	  		  Thread.sleep(3000);
	  		  
	  		  WespOrder.CopyTo_Toggledropdown.click();
	  		  
	  		  Thread.sleep(2000);
	  		  
	  		  //Hover the Project Option
	  		WebElement HoverProject=WespOrder.CopyTo_Toggledropdown_Project;
	  		Hover(HoverProject);
	  		
	  		Thread.sleep(2000);
	  		
	  		//Click the My Project Sub Option
	  		WespOrder.CopyTo_Toggledropdown_Project_MyProjects.click();
			   // Click("A", WespOrder.CopyTo_Toggledropdown_Project_MyProjects);

	  		
	  		Thread.sleep(6000);
	  		
	  		 //Hover the Product on My Project Screen
	  		Click("Click at Saved Product tab", WespOrder.Projects_SavedProductsTab);
	  		Thread.sleep(3000);
	  		Click("abc", WespOrder.ProductHover_OrderButton);
	  	//Click the E-Comm order button now
  	//	  WespOrder.ProductHover_OrderButton.click();
  		  
  
    		 Thread.sleep(15000);
    		  
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
	  			 System.out.println("Order Created from WESP through Projects Successfully");
	  			 resultPass("OrderCreation_FromWESP_ThroughProjects", "Order Created from WESP through Projects Successfully");
	  		 }
	  		 else{
	  			 System.out.println("Order Created from WESP through Projects UnSuccessfully");
	  			 resultFail("OrderCreation_FromWESP_ThroughProjects", "Order Created from WESP through Projects UnSuccessfully");
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
