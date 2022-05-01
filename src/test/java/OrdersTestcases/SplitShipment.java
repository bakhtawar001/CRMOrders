package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class SplitShipment extends OrdersExecution1 {

	static OrdersLocators EditOrderSplitShipment = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Zero_Quantity_Validation_Message_Verification() throws IOException, InterruptedException, ParseException{
    try
    {
        	
       Click("a", EditOrderSplitShipment.OrdersDetails_EditButton);
	   wait = new WebDriverWait(driver, 180);
	   wait.until(ExpectedConditions.elementToBeClickable(EditOrderSplitShipment.EditOrder_ShippingTab));
	   Thread.sleep(2000);
	  //Goto Shipping Tab
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].scrollIntoView();", EditOrderSplitShipment.EditOrder_ShippingTab);
	   EditOrderSplitShipment.EditOrder_ShippingTab.click();
	   waitForPageLoading();
	   Thread.sleep(2000);
	 
	 //Press the Split shipment button
	    EditOrderSplitShipment.EditOrder_ShippingTab_SplitShipmentButton.click();
	    waitForPageLoading();
	    Thread.sleep(1000);
	    
	//Press the Ok button to proceed to split shipment popup screen
	    EditOrderSplitShipment.EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton.click();
	    waitForPageLoading();
	    Thread.sleep(3000);
	    EditOrderSplitShipment.EditOrder_ShippingTab_SplitShipmentButton_RemoveCrossIcon_CustomerAddressField1.click();
	    Thread.sleep(3000); 
  
	 //Select the first Company Address
	    Thread.sleep(5000);
	//Select the address
	    EditOrderSplitShipment.EditOrder_ShippingTab_SplitShipmentButton_OKProceedButton_CustomerAddressField_AddressSelection.click();
	    Thread.sleep(3000);

	 //Press the Next-Enter Quantity button
	    EditOrderSplitShipment.EditOrder_Splitshipment_EnterQuantityNextButton.click();
	    Thread.sleep(3000);
	    WebElement el = 	 EditOrderSplitShipment.EditOrder_Splitshipment_SaveButton;
	    Actions builder = new Actions(driver);
	    builder.moveToElement( el ).click( el );
	    builder.perform();
	    //waitForPageLoading();
	    Thread.sleep(2000);
	    Assert.assertTrue(EditOrderSplitShipment.ErrorMessage_Verification_QuantityCheck.isDisplayed());
	 
        }catch(NoSuchElementException e){
           e.getMessage();
        }
	}
	
	public static void SplitShipment_not_showing_in_shippingtab() throws InterruptedException, IOException{
		
	try
	{
	    EditOrderSplitShipment.EditOrder_Splitshipment_Shipment2_QTY.click();
	    EditOrderSplitShipment.EditOrder_Splitshipment_Shipment2_QTY.sendKeys("2");
	    
	    Thread.sleep(2000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();",EditOrderSplitShipment.EditOrder_Splitshipment_SaveButton);
	   //Press the save button to complete split shipment process
	    EditOrderSplitShipment.EditOrder_Splitshipment_SaveButton.click();
	    waitForPageLoading();
	    Thread.sleep(1000);
	    
	  //Now Validate if the split shipment process successfully done
	    Assert.assertTrue(EditOrderSplitShipment.Orderdetails_shippingTab_SplitshipmentExistence_Verification.isDisplayed());
	    
     }
		catch(NoSuchElementException e)
		{
           e.getMessage();
        }
	} 
        public static void SplitShipment_Showing_in_Pricing_tab() throws IOException, InterruptedException{
        try
        {
        	Thread.sleep(3000);
        	JavascriptExecutor js = (JavascriptExecutor)driver;
        	js.executeScript("arguments[0].click();", EditOrderSplitShipment.Orderdetails_PricingTab);
        	Thread.sleep(2000);
        	Assert.assertTrue(EditOrderSplitShipment.Orderdetails_shippingTab_SplitshipmentExistence_Verification.isDisplayed());
	    
        	}catch(NoSuchElementException e){
        		e.getMessage();
        	}
        }	
        	
        public static void SplitShipment_Showing_in_Decoration_tab() throws IOException, InterruptedException{
        	
        try
        {
           Thread.sleep(3000);
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView();",EditOrderSplitShipment.Orderdetails_DecorationTab);
           EditOrderSplitShipment.Orderdetails_DecorationTab.click();
           Thread.sleep(3000);
           Assert.assertTrue(EditOrderSplitShipment.Orderdetails_shippingTab_SplitshipmentExistence_Verification.isDisplayed());
	
             }
        catch(NoSuchElementException e)
        {
            	 
        	e.getMessage();
        }
             
        }
        
        public static void SplitShipment_Showing_in_PurchaseOrder_tab() throws IOException, InterruptedException{
        try
        {
           Thread.sleep(3000);
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].scrollIntoView();",  EditOrderSplitShipment.Orderdetails_PurchaseOrderTab);
           EditOrderSplitShipment.Orderdetails_PurchaseOrderTab.click();
           Thread.sleep(3000);
      }
     catch (NoSuchElementException e) 
      {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}



}
