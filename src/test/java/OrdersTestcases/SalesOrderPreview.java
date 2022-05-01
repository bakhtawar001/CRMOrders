package OrdersTestcases;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Functions.ConversionsWithoutOtherCharges;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class SalesOrderPreview extends OrdersExecution1 {
	
	public static String SalesPersonAddressdetails;
	public static String BillingandShippingAddressdetails;
	public static String SalesOrderDecorationDetails;
	public static String SalesOrderShippingfromdetails;
	public static String SalesOrderShippingAddressDetails;
	public static File SalesOrderDownloadPDF;
	public static String SalesOrderDownload;
	public static String parentWindow;
	static OrdersLocators SalesOrderPreview = PageFactory.initElements(driver, OrdersLocators.class);
	public static void SalesOrderPreview_SalesPersonDetails() throws IOException, InterruptedException, ParseException{
    try
    {
	 // This is to Instantiate EditInstruction  class  
	
       //Click the Order tab
      /* SalesOrderPreview.ESPWebHomePage_OrdersTab.click();
       Thread.sleep(2000);
       Click("Click orders title tab",  SalesOrderPreview.Orders_Title_Tab);
       SalesOrderPreview.OrderlistingSearch.sendKeys(Conversions.Orderno);
   	   Thread.sleep(7000);
   	   //Select existing created order from Top of the list
   	   SalesOrderPreview.OrderListing_Orderselection.click();
   	   waitForPageLoading();
   	   Thread.sleep(2000);*/
    	 
         // Thread.sleep(2000);
         // driver.navigate().refresh();
    	//Click("Close Preview Screen",   SalesOrderPreview.ClosePreviewPopup);
   	//   SalesOrderPreview.ClosePreviewPopup.click();
   	   
   //	waitForPageLoading();
  //  Thread.sleep(2000);
   	   //Converting subtotal from string to int
  /* 	   Conversions.Subtotal_String_To_Int_Conversion();
  	 
   	   //Sales Tax Conversion from String to integer with $ removing done 
  	 
   	   Conversions.SalesTax_String_To_Int_Conversion();
  	
   	   //Adding  the SubTotal and tax amount for matching with sales order preview total amount
   	   Conversions.SumSubtotalandTax_MatchingwithSalesPreviewAmount();
  	 
   	   //Now Converting the Amountdue from string to Int
   	   Conversions.AmountDue_String_To_Int_Conversion();*/
	 
   	   //Press the Preview Button on order details
   	//   SalesOrderPreview.PreviewButton_Orderdetails.click();
	 
   	   // Thread.sleep(15000);
   	   Thread.sleep(3000);
   	   //Press the Purchase Order document
   	   SalesOrderPreview.PreviewPopUp_SalesOrder.click();
	 
   	   Thread.sleep(3000);
	 
   	   //First store parent window to switch back
   	   parentWindow = driver.getWindowHandle();
	 
   	   //Press the Preview Button
   	   SalesOrderPreview.PreviewPopUp_PreviewButton.click();
	 
   	   //Switch to new window opened
	  	for(String winHandle : driver.getWindowHandles()){
	  	    if(!winHandle.equals(parentWindow)) {
	  	        driver.switchTo().window(winHandle);
	  	    }
	  	}
	  	  
	  	Thread.sleep(10000);
	  	
	  	SalesPersonAddressdetails=SalesOrderPreview.SalesOrderPreview_SalesPersonAddressDetails.getText();	 
	  	
	  	System.out.println(SalesPersonAddressdetails);
	  	
	  	
	  	Thread.sleep(2000);
	  	
	  	//Validate the OrderNumber
	  	Assert.assertTrue(SalesPersonAddressdetails.contains("Feasterville-Trevose, PA 19053"));

	  	
        }catch(NoSuchElementException e){
           e.getMessage();
        }
	}
	  public static void SalesOrder_BillingShippingDetails_Preview() throws IOException, InterruptedException{
	  try
	  {
	  	BillingandShippingAddressdetails=SalesOrderPreview.SalesOrderPreview_BillingandShippingAddress.getText();
	  	System.out.println(BillingandShippingAddressdetails);
	  	Thread.sleep(2000);
	  	//Validate the Sales Person details is displayed or not
	  	Assert.assertTrue(SalesOrderPreview.SalesOrderPreview_BillingandShippingAddress.isDisplayed() & BillingandShippingAddressdetails.contains("Feasterville-Trevose, PA "));
	   }
	  catch(NoSuchElementException e){
	      e.getMessage();
	   }
	  } 
	  
	  public static void SalesOrder_Blindship_Verification() throws IOException, InterruptedException{
	  try
	  {
			  
		  Thread.sleep(2000);
	  	  //Validating BlindShipment in Sales Order Doc
		  Assert.assertTrue(SalesOrderPreview.BlindShipText_ShippingDetails_PurchaseOrder.getText().contains("Blind Ship"));
		  }
	  catch(NoSuchElementException e)
	  {
		    e.getMessage();
		  }
		  
	  } 
	 public static void SalesOrderPreview_SplitShipment1_Details_Verification() throws IOException, InterruptedException{
	 try
	 {
	  Thread.sleep(2000);
	  //Validating Split Shipment 1 Details on preview screen on Purchase Order Preview
	  Assert.assertTrue(SalesOrderPreview.SalesOrderPreview_ProductSplit1Details.isDisplayed());

	}
	 catch(NoSuchElementException e)
	 {
		      e.getMessage();
	}
		
	   }  
       public static void SalesOrderPreview_SplitShipment1_DecorationDetails_Verification() throws IOException, InterruptedException{
    	try
    	{
    		SalesOrderDecorationDetails=SalesOrderPreview.PurchaseOrder_Preview_DecorationDetails_SplitShipment1Area.getText();
    		System.out.println(SalesOrderDecorationDetails);
	  	
    		//Validate the Decoration details on purchase Order preview
    		Thread.sleep(2000);
    		Assert.assertTrue(SalesOrderDecorationDetails.contains("Location:") &&  SalesOrderDecorationDetails.contains("Proof Required: Email"));
        
    	}	
    	catch(NoSuchElementException e)
    	   {
    	e.getMessage();
    	  }
       }
       
       public static void SalesOrder_PreviewShippingFromDetails_Verification() throws IOException, InterruptedException{
       try
       {
		//Now validating the shipping details address on Sales Order Preview
	  	SalesOrderShippingfromdetails=SalesOrderPreview.SalesOrderPreview_ShippingDetails_ShipFrom.getText();
	  	System.out.println(SalesOrderShippingfromdetails);
	  	Thread.sleep(2000);
	  	Assert.assertTrue(SalesOrderShippingfromdetails.contains("Shipping Details") &SalesOrderShippingfromdetails.contains("From") & SalesOrderPreview.SalesOrderPreview_ShippingDetails_ShipFrom.isDisplayed());
	
    }
       catch(NoSuchElementException e)
    	   {
    	e.getMessage();
    	   }
       }
       public static void SalesOrder_ShippingFrom_BlindShip_Verification() throws IOException, InterruptedException{
    	   try
    	   {
    		   //Now Validating Blind ship on Sales Order Shipping details
    		   Thread.sleep(2000);
    		   Assert.assertTrue(SalesOrderPreview.BlindShipText_ShippingDetails_PurchaseOrder.getText().contains("Blind Ship"));
	   
    	   }
    	   catch(NoSuchElementException e)
    	   {
    	 e.getMessage();
    	   }
       }
       public static void SalesOrderPreview_ShippingToDetails_Verification() throws IOException, InterruptedException{
       try
       {
      //Now Validating the shipping Address details displayed or not
	   SalesOrderShippingAddressDetails=SalesOrderPreview.SalesOrderPreview_CompleteShippingDetails.getText();
	   System.out.println(SalesOrderShippingAddressDetails);
	   Thread.sleep(2000);
	   Assert.assertTrue(SalesOrderShippingAddressDetails.contains("Feasterville-Trevose, PA 19053") & SalesOrderShippingAddressDetails.contains("Ship Via") & SalesOrderShippingAddressDetails.contains("Best Way") & SalesOrderShippingAddressDetails.contains("Account #") & SalesOrderShippingAddressDetails.contains("ABCDE12345") & SalesOrderPreview.SalesOrderPreview_CompleteShippingDetails.isDisplayed());
       }
       catch(NoSuchElementException e)
    	   {
	      e.getMessage();
    	   }
       }
       public static void SalesOrderPreview_Instructions() throws IOException, InterruptedException{
       try
       {
    	Thread.sleep(2000);
        //Validating the instructions displayed corectly or not sales Order Preview
    	Assert.assertTrue(SalesOrderPreview.SalesOrderPreview_InstructionsVerification.getText().contains("Instructions:") & SalesOrderPreview.SalesOrderPreview_InstructionsVerification.getText().contains("Test Automation Instructions"));
       }
       catch(NoSuchElementException e)
    	   {
           e.getMessage();
    	   }
       }  
    	
      public static void SalesOrderPreview_ServicesDetails_Verification() throws IOException, InterruptedException{
      try
      {
    		  
	   Thread.sleep(2000);
	   //Validating the services displayed on sales order or not
	   Assert.assertTrue(SalesOrderPreview.SalesOrderPreview_Freight1Display.isDisplayed() & SalesOrderPreview.SalesOrderPreview_Freight2Display.isDisplayed());
	   
   }
      catch(NoSuchElementException e)
    {
    	  e.getMessage();
    }
   }
      public static void Calculating_TotalPrice_On_SalesPreview() throws IOException, InterruptedException, ParseException{
      try
      {

	   //Converting preview TotalPrice From String to integer
    	ConversionsWithoutOtherCharges.TotalPriceSalesPreview_String_To_Int_Conversion();
			 
    	//Validating the TotalPrice on preview screen
		Thread.sleep(2000);
		Assert.assertEquals(Conversions.SumSubtotalandTax_WithSalesPreviewAmountMatch, ConversionsWithoutOtherCharges.TotalPriceSalesPreview);
	
    	  }catch(NoSuchElementException e)
    	  {
    		  e.getMessage();
    	  }
      }
      
      public static void SalesOrder_PDF_DocDownload() throws IOException, InterruptedException{
      try
      {
        //Validating the as Sales order downloaded Successfully or not
    	  SalesOrderPreview.SalesOrderPreview_DownloadPDFButton.click();
    	  Thread.sleep(35000);
    	  SalesOrderDownloadPDF = getLatestFilefromDir(downloadPath);
    	  SalesOrderDownload= SalesOrderDownloadPDF.getName();
    	  Thread.sleep(2000);
    	  Assert.assertTrue(SalesOrderDownload.contains("Order #"));
		
    	  }catch(NoSuchElementException e){
    		  e.getMessage();
    	  }
      } 
    	  public static void PDFAttach_Checkbox_ischecked_by_default() throws InterruptedException, IOException{
    	  try
    	  {
    			  
			//Validating the Sales Order Sending Mail Process to check if the mail sending successfully or not
			SalesOrderPreview.PO_SendButton.click();
			waitForPageLoading();
			Thread.sleep(12000);
			//Insert a new Email address in To Field
			SalesOrderPreview.SendSales_To_Field.sendKeys("bnazir@asicentral.com");
			Thread.sleep(3000);
			SalesOrderPreview.SendSales_To_Field.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			Assert.assertTrue(SalesOrderPreview.VerifyDocumentCheckbox.isSelected());
			
				    
    		  }catch(NoSuchElementException e)
    		  {
    			  e.getMessage();
    		  }
    	  } 
    	  
    	  public static void SalesOrder_Preview_SalesOrder_Send() throws InterruptedException, IOException{
    	  try
    	  {    			    
    			SoftAssert softassertion=new SoftAssert();
				 //Press the send button and validate as if the Success message displayed or not
    			 JavascriptExecutor js = (JavascriptExecutor) driver;
    			 js.executeScript("arguments[0].scrollIntoView();",SalesOrderPreview.PO_SendButton);
    			 Click("Click to send button",SalesOrderPreview.PO_SendButton);
    			 //SalesOrderPreview.PO_SendButton.click();
				 waitForPageLoading();
				 Thread.sleep(5000);
				 Assert.assertTrue(SalesOrderPreview.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
				 softassertion.assertAll();
				
        
        }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }
finally
{
	 Thread.sleep(5000);
     driver.close();
     Thread.sleep(2000);
    //Switch back to parent window 
     driver.switchTo().window(parentWindow);
	   
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



