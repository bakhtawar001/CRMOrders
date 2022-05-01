package OrdersTestcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class BlindShip_WithConfirmations extends OrdersExecution1{

	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static void BlindShipWithConfirmation() throws IOException, InterruptedException{
    try
    {
		// This is to Instantiate CreateOrders  class  
    	OrdersLocators BlindShip = PageFactory.initElements(driver, OrdersLocators.class);	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	//Scroll Up
    	Thread.sleep(1000);
    	js.executeScript("arguments[0].click();",  BlindShip.Orderdetails_ShippingTab);
    	Thread.sleep(1000);
	    js.executeScript("window.scrollTo(document.body.scrollHeight,0)",  BlindShip.Orderdetail_BlindShipCheckbox);
	    //Check Blind Ship Checkbox
	    WebElement el = 	  BlindShip.Orderdetail_BlindShipCheckbox;
	    Actions builder = new Actions(driver);
	    builder.moveToElement( el ).click( el );
	    builder.perform();
	    Thread.sleep(4000);
	    //Press the Yes button to confirm blind ship
    	BlindShip.Order_BlindShipConfirm.click();
    	waitForPageLoading();
    	Thread.sleep(10000);
    	Click("click save button", BlindShip.SampleRequestSaveButton);
    	Thread.sleep(10000);
    	Assert.assertTrue(BlindShip.ShippingDestination_WithNewDecoratorCompany_ShippingAddress_Verification.getText().contains("Blind Ship"));
            
        }
	   catch(NoSuchElementException e)
    {
	    System.err.println("NoSuchElementException: " + e.getMessage());
	 }
	}  
	


}
