package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class SampleRequest_FromProductDetail extends OrdersExecution3 {

	
	public static void OrderFromWESP_WithSearchProduct() throws InterruptedException, IOException{
  	  
  	  try{
  		
  		  OrdersLocators SampleRequest = PageFactory.initElements(driver, OrdersLocators.class);
  		 
  		 //Go to ESP Web Tab
  		SampleRequest.ESPWeb_Tab.click();
  		  
  		  Thread.sleep(5000);
  		  
  		  //Search for the Product
  		SampleRequest.ProductSearch_TextField.sendKeys(OrdersTestdata.SampleRequest_ProductName);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search button
  		SampleRequest.ProductQuickSearchButton.click();
  		  
  		  Thread.sleep(10000);
  		  
  		  //Search asi number within search terms
  		SampleRequest.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.SampleRequest_ProductNumber);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search with terms go button
  		SampleRequest.SearchWithinTerms_GoButton.click();
  		  
  		  Thread.sleep(12000);
  		  
  		
  		 
  		//First store parent window to switch back
  		 String parentWindow = driver.getWindowHandle();
  		 
  		//Goto Product Detail
  		 SampleRequest.BudgetBarrelProduct_Details_link.click();  
  		 
  		 Thread.sleep(10000);
  		 
  		//Switch to new window opened
  		  	for(String winHandle : driver.getWindowHandles()){
  		  	    if(!winHandle.equals(parentWindow)) {
  		  	        driver.switchTo().window(winHandle);
  		  	    }
  		  	}
  		  	
  		  	Thread.sleep(2000);
  		
  		  	//Click the Request Button
  		  	SampleRequest.ProductDetial_Requestbutton.click();
  		  	
  		  	Thread.sleep(1000);
  		  	
  		  	//Click the Request Sample option
  		  	SampleRequest.RequestSample_Option.click();
  		  	
  		  	Thread.sleep(5000);
  		  	
  		  	//Select the date
  		  	SampleRequest.DateNeeded_RequestSample.click();
  		  	
  		  	Thread.sleep(2000);
  		  	
  		  	SampleRequest.DateSelection.click();
  		  	
  		  	Thread.sleep(1000);
  		  	
  		//Now Select the Proof Type
  		    WebElement shipvia=SampleRequest.ShipVia_SampleRequest;
  		    Select dropdownValue1= new Select(shipvia);
  		    
  		    dropdownValue1.selectByVisibleText("UPS Ground");
  		    
  		    Thread.sleep(1000);
  		    
  		    //Press the contue button
  		    SampleRequest.CreateOrder_Configure_Continue_Button.click();
  		    
  		    Thread.sleep(12000);

  		    //Remove the email from To field on send sample request field
  		    SampleRequest.Send_PO_ToandCCRemoveIcon.click();
  		    
  		    Thread.sleep(2000);
  		    
  		    //Insert the new email address
  		    SampleRequest.SampleRequest_SendTo_Field.sendKeys("mmubarik@asicentral.com");
  		    
  		    Thread.sleep(3000);
  		    
  		  SampleRequest.SampleRequest_SendTo_Field.sendKeys(Keys.ENTER);
  		  
  		  Thread.sleep(2000);
  		  
  		  //Press the send button
  		  SampleRequest.SampleRequest_SendButton.click();
  		  
  		  Thread.sleep(10000);
  		  
  		  //Go to Orders tab
  		//Click the Orders tab
  		 SampleRequest.ESPWebHomePage_OrdersTab.click();
  		    
  		 Thread.sleep(2000);

  		 //Go to Sample Request
  		 SampleRequest.Orders_SampleRequestTab.click();
  		 
  		 Thread.sleep(8000);
  		 
  		 //Go to details of request sample
  		 SampleRequest.RequestDetails.click();
  		 
  		 Thread.sleep(5000);
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

    public static void resultPass(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
			test.log(Status.PASS, sTestName);
			
			 } catch (Exception e)
	{
			 e.printStackTrace();   
	}

	}
	public static void resultFail(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
				test.log(Status.FAIL, sTestName);
		 } catch (Exception e)
	{
			 e.printStackTrace();		 
	}    	
	
	
}
	public static void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
}

}
