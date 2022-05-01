package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class MultipleShippingAddress extends OrdersExecution1{

	public static String NewDestinationAddress;
	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static void multiShippingAddress() throws IOException, InterruptedException, ParseException{
    try
    {
    	// This is to Instantiate EditInstruction  class  
    	OrdersLocators EditOrderShipping = PageFactory.initElements(driver, OrdersLocators.class);
    	//Scroll Up
    	Click("a",  EditOrderShipping.OrdersDetails_EditButton);
	   wait = new WebDriverWait(driver, 180);
	   wait.until(ExpectedConditions.elementToBeClickable(EditOrderShipping.EditOrder_ShippingTab));
	   
	   Thread.sleep(2000);
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", EditOrderShipping.EditOrder_ShippingTab);
	  //Goto Shipping Tab
	    EditOrderShipping.EditOrder_ShippingTab.click();
	    
	    Thread.sleep(2000);
	    
	  //Press the Add New Destination Button
	    EditOrderShipping.EditOrder_ShippingTab_AddShippingDestinationButton.click();
	    
	    Thread.sleep(2000);
	    
	  //Press the save Button
	    js.executeScript("arguments[0].scrollIntoView();",EditOrderShipping.ProductConfiguration_AddCharge_SaveButton);
	    EditOrderShipping.ProductConfiguration_AddCharge_SaveButton.click();

	    waitForPageLoading();
	    
	    Thread.sleep(5000);
	    
	    //Now Goto Shipping tab for Address inclusion validation
	    Click("shipping tab", EditOrderShipping.Orderdetails_ShippingTab);
	    waitForPageLoading();
	    Thread.sleep(2000);
	    
	    //validating the new destination address exist or not
	    NewDestinationAddress=EditOrderShipping.Orderdetails_ShippingTab_AddNewDestinationAddressVerification.getText();
	    System.out.println(NewDestinationAddress);
	    if(NewDestinationAddress.contains("Ship From My Company") & NewDestinationAddress.contains("Ship Via Best Way") & NewDestinationAddress.contains("Account ABCDE12345") &  NewDestinationAddress.contains("Ship To Auto-") & NewDestinationAddress.contains("Feasterville-Trevose, PA") )
	    {  
	  
	    	System.out.println("MultiDestination Shipping Address Added Successfully");
		
	    }
	  else{
		  System.out.println("MultiDestination Shipping Address Added UnSuccessfully");
		
	  }
        
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}



}