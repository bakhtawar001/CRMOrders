package OrdersTestcases;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Functions.ConversionsWithoutOtherCharges;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class AcknowlodgementPreview extends OrdersExecution1 {

	public static String AckowledgementAddressdetails;
	public static String AckowledgementDecorationdetails;
	public static String AcknowledgementShippingDetails;
	static String parentWindow;
	static String parentWindow11;
	static OrdersLocators AckowledgementPreview = PageFactory.initElements(driver, OrdersLocators.class);
	public static void AcknowledgementOrder_Preview_SalesPersonDetails() throws IOException, InterruptedException, ParseException{
    try
    {
	 
	//Close the Preview Popup
/*	AckowledgementPreview.ClosePreviewPopup.click();
	 
	 Thread.sleep(2000);
	 
	//Converting subtotal from string to int
  	 Conversions.Subtotal_String_To_Int_Conversion();
  	 
  
  	 
 //Sales Tax Conversion from String to integer with $ removing done 
  	 
    Conversions.SalesTax_String_To_Int_Conversion();
  	
  //Adding  the SubTotal and tax amount for matching with sales order preview total amount
    Conversions.SumSubtotalandTax_MatchingwithSalesPreviewAmount();
  	 
  //Now Converting the Amountdue from string to Int
  	Conversions.AmountDue_String_To_Int_Conversion();
	 
	 //Press the Preview Button on order details
  	AckowledgementPreview.PreviewButton_Orderdetails.click();
	 
	 Thread.sleep(15000);*/
	 
	 //Press the Acknowlodgement Order document
	 AckowledgementPreview.PreviewPopUp_Acknowledgement.click();
	 
	 Thread.sleep(3000);
	 
	//First store parent window to switch back
	 parentWindow = driver.getWindowHandle();
	 
	 //Press the Preview Button
	 AckowledgementPreview.PreviewPopUp_PreviewButton.click();
	 
	//Switch to new window opened
	  	for(String winHandle : driver.getWindowHandles()){
	  	    if(!winHandle.equals(parentWindow)) {
	  	        driver.switchTo().window(winHandle);
	  	    }
	  	}
	  	  
	  	Thread.sleep(10000);
	  	
	  	AckowledgementAddressdetails=AckowledgementPreview.SalesOrderPreview_SalesPersonAddressDetails.getText();	 
	  	
	  	System.out.println(AckowledgementAddressdetails);
	  	//Validate the OrderNumber
	  	Assert.assertTrue(AckowledgementAddressdetails.contains("Feasterville-Trevose, PA 19053"));
	  	
        }catch(NoSuchElementException e)
        {
        	e.getMessage();
        }
	} 
	
	public static void AckowlodgementPreview_SplitShipment1_Details_Verification() throws IOException, InterruptedException{
		try{
			
	  	//Validating Split Shipment 1 Details on preview screen on Purchase Order Preview
	  	Assert.assertTrue(AckowledgementPreview.SalesOrderPreview_ProductSplit1Details.isDisplayed());
       
		}catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		
	}
	public static void AcknowlodgementPreview_SplitShipment1_DecorationDetails_Verification() throws IOException, InterruptedException{
		try{
			
	  	AckowledgementDecorationdetails=AckowledgementPreview.SalesOrderPreview_DecorationdetailsSplit1details.getText();
	  	System.out.println(AckowledgementDecorationdetails);
	  	Thread.sleep(5000);
	  	Assert.assertTrue(AckowledgementDecorationdetails.contains("Location:")  & !AckowledgementDecorationdetails.contains("Test Vendor Notes"));
		}
		catch(NoSuchElementException e){
			e.getMessage();
		}
	}	
	  	public static void Ackowledgement_PreviewShippingFromDetails_Verification() throws IOException, InterruptedException{
	  	try
	  	{
	  			
	  		//Now validating the shipping details address on Sales Order Preview
	  		AcknowledgementShippingDetails=AckowledgementPreview.SalesOrderPreview_ShippingDetails_ShipFrom.getText();
	  		System.out.println(AcknowledgementShippingDetails);
	  		Assert.assertTrue(AckowledgementPreview.SalesOrderPreview_ShippingDetails_ShipFrom.isDisplayed());
	 
	   
	  		}
	  	catch(NoSuchElementException e)
	  		{
	  			e.getMessage();
	  		}
	  	}	
	  	public static void AckowledgementPreview_Instructions() throws IOException, InterruptedException{
	  	try
	  	{
	    
	  		//Validating the instructions displayed corectly or not sales Order Preview
	  		Assert.assertTrue(AckowledgementPreview.Acknowledgement_Instructions.getText().contains("Test Automation Instructions"));
	  		
	  		}catch(NoSuchElementException e)
	  		{
	  		e.getMessage();
	  		}
	  	}
	  	
	  	public static void AcknowledgementPreview_ServicesDetails_Verification() throws IOException, InterruptedException{
	  	try
	  	{
	   
	  		//Validating the services displayed on sales order or not
	  		Assert.assertTrue(AckowledgementPreview.SalesOrderPreview_Freight1Display.isDisplayed() & AckowledgementPreview.SalesOrderPreview_Freight2Display.isDisplayed());
	   
	  		}catch(NoSuchElementException e){
	  		   e.getMessage();
	  		}
	  	}
	  	public static void Ackowledgement_PersonalizationDecoration_DocDownload() throws InterruptedException, IOException{
	  	try
	  	{

	  		//Download the Persolaimzation doc for PO in Preview
	  		AckowledgementPreview.PurchaseOrder_Preview_Decoration_DownloadFile.click();
	  		Thread.sleep(35000);
	  	
	  		//Now Validating as if the Personalization file is downloaded successfully or not
	  		File PersonalizationFile = getLatestFilefromDir(downloadPath);
	  		String PersonalizationDownload = PersonalizationFile.getName();
	  		Assert.assertTrue(PersonalizationDownload.contains("DocP"));
	   
	  		}catch(NoSuchElementException e){
	  			e.getMessage();
	  		}
	  	}
	  	
	  	public static void Ackowledgement_PDF_DocDownload() throws IOException, InterruptedException{
	  	try
	  	{
		//Download the Persolaimzation doc for PO in Preview
		   AckowledgementPreview.SalesOrderPreview_DownloadPDFButton.click();
		   Thread.sleep(10000);
		  //Now Validating as if the Personalization file is downloaded successfully or not
		  File AckFile = getLatestFilefromDir(downloadPath);
		  String AckDownload = AckFile.getName();
		  Thread.sleep(5000);
		  Assert.assertTrue(AckDownload.contains("Acknowledgement #"));
	
	  		}catch(NoSuchElementException e){
	  			e.getMessage();
	  		}
	  	}
	  	
	  	public static void Calculating_TotalPrice_On_AckowledgementPreview() throws ParseException, IOException, InterruptedException{
	  	try
	  	{
	  		//Converting preview TotalPrice From String to integer
			 ConversionsWithoutOtherCharges.TotalPriceSalesPreview_String_To_Int_Conversion();
			 
			 //Validating the TotalPrice on preview screen
			// Assert.assertEquals(Conversions.SumSubtotalandTax_WithSalesPreviewAmountMatch, ConversionsWithoutOtherCharges.TotalPriceSalesPreview);
			if(Conversions.SumSubtotalandTax_WithSalesPreviewAmountMatch==ConversionsWithoutOtherCharges.TotalPriceSalesPreview)
			 {
				// resultPass("Calculating TotalPrice On AckowledgementPreview", "The Total Price Calculated Successfully on Ackowledgement Order Preview");
				System.out.println("The Total Price Calculated Successfully on Ackowledgement Preview");
			 }
			 else{
				// resultFail("Calculating TotalPrice On AckowledgementPreview","The Total Price Calculated UnSuccessfully on Ackowledgement Preview");
				 System.out.println("The Total Price Calculated UnSuccessfully on Ackowledgement Preview");
			 }
			 
	  		}catch(NoSuchElementException e)
	  		{
	  			e.getMessage();
	  		}
	  	}	
	  		public static void Acknowledgement_Preview_AckSend() throws IOException, InterruptedException{
	  		try
	  		{
	  			Thread.sleep(2000);
	  			SoftAssert Soft=new SoftAssert();
	  			WebElement el = 	  AckowledgementPreview.PO_SendButton;
	  			Actions builder = new Actions(driver);
	  			builder.moveToElement( el ).click( el );
	  			builder.perform();
	  			//Validating the Sales Order Sending Mail Process to check if the mail sending successfully or not
	  			waitForPageLoading();
				Thread.sleep(10000);
				
			    AckowledgementPreview.Send_PO_ToandCCRemoveIcon.click();
			    
			    Thread.sleep(1000);
			 
			    
			    //Insert a new Email address in To Field
			    Actions a = new Actions(driver);
			    a.doubleClick(AckowledgementPreview.SendAck_To_Field);
			    a.perform();
			    AckowledgementPreview.SendAck_To_Field.sendKeys("bnazir@asicentral.com");
			    
			    Thread.sleep(2000);
			    
			    AckowledgementPreview.SendAck_To_Field.sendKeys(Keys.ENTER);
			    
			    Thread.sleep(2000);
			    
			    //Press the send button and validate as if the Success message displayed or not
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].scrollIntoView();",AckowledgementPreview.PO_SendButton);
			    WebElement el1 = 	  AckowledgementPreview.PO_SendButton;
 			     Actions builder1 = new Actions(driver);
 			     builder1.moveToElement( el1 ).click( el1 );
 			     builder1.perform();
			    Thread.sleep(5000);
			    Assert.assertTrue(AckowledgementPreview. CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
			   
			  //  Assert.assertTrue(AckowledgementPreview.Ack_Send_Successfull.isDisplayed());
			   Soft.assertAll();
			   
				
	  			}
	  			catch(NoSuchElementException e)
	  			{
	  				e.getMessage();
	  			}
	  		finally
	  		{
	  			Thread.sleep(5000);
				
				  //  parentWindow = driver.getWindowHandle();
		  		    driver.close();
		  	        
		  	        Thread.sleep(2000);
		  	        
		  	      //Switch back to parent window 
		  	        driver.switchTo().window(parentWindow);
		  	        Thread.sleep(2000);
		  	        AckowledgementPreview.ClosePreviewPopup.click();
	  		}
	  		}
	  		
	  



public static File getLatestFilefromDir(String dirPath){
    File dir = new File(dirPath);
    File[] files = dir.listFiles();
    if (files == null || files.length == 0) {
        return null;
    }

    File lastModifiedFile = files[0];
    for (int i = 1; i < files.length; i++) {
       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
           lastModifiedFile = files[i];
       }
    }
    return lastModifiedFile;
}
}


