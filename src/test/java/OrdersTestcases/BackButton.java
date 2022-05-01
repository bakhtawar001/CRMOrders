package OrdersTestcases;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;




public class BackButton extends OrdersExecution1 {

	
	
	public static void BackButtonVerification() throws IOException, InterruptedException{
    try
    {
		// This is to Instantiate CreateOrders  class  
   	 	OrdersLocators BackButton = PageFactory.initElements(driver, OrdersLocators.class);	
   	 	JavascriptExecutor js = (JavascriptExecutor) driver;
   	 	js.executeScript("arguments[0].scrollIntoView();",BackButton.SendButton);
   	 	BackButton.SendButton.click();
   	 	Thread.sleep(10000);
   	 	Click("a",  BackButton.PreviewPopUp_PurchaseOrder);
   	 	Thread.sleep(3000);
	 
   	 	//Select the Purchase Order Option
   	 	//PurchaseOrderPreviewWithDownload.PreviewPopup_PurchaseOrderSelection.click();
   	 	Click("a",  BackButton.PreviewPopup_PurchaseOrderSelection);
   	 	Click("a",  BackButton.Continuebutton);
   	 	Thread.sleep(3000);
		Assert.assertTrue(BackButton.Backbutton1.isDisplayed());

           }
	
	   catch(NoSuchElementException e){
		   e.getStackTrace();
	   }
	}  
	



}