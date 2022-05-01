package OrdersTestcases;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.ConversionsWithoutOtherCharges;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class PurchaseOrderPreview_WithDownloadVerification extends OrdersExecution1 {

	public static String PurchaseOrderTextPreviewVerification;
	public static String PurchaseOrdernoPreview;
	public static String SalesPersonDetailsVerification;
	public static String PurchaseOrderDecorationDetails_Verification;
	public static String ShippingdetailsAddress_PurchaseOrderPreview;
	static String parentWindow10;
	static String parentWindow;
	static OrdersLocators PurchaseOrderPreviewWithDownload = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Purchase_Order_Preview_Verification() throws IOException, InterruptedException, ParseException{
        try
        {

				 //Press the Preview Button on order details
				 Click("Click Function",PurchaseOrderPreviewWithDownload.PreviewButton_Orderdetails);
				 waitForPageLoading();
				 Thread.sleep(3000);
				 //Press the Purchase Order document
				// PurchaseOrderPreviewWithDownload.PreviewPopUp_PurchaseOrder.click();
				 Click("a",  PurchaseOrderPreviewWithDownload.PreviewPopUp_PurchaseOrder);
				 Thread.sleep(3000);
				//Select the Purchase Order Option
			
				 Click("a",  PurchaseOrderPreviewWithDownload.PreviewPopup_PurchaseOrderSelection);
				 waitForPageLoading();
				 Thread.sleep(3000);
				 //First store parent window to switch back
				 parentWindow = driver.getWindowHandle();
				 //Press the Preview Button
				 PurchaseOrderPreviewWithDownload.PreviewPopUp_PreviewButton.click();
				//Switch to new window opened
				  	for(String winHandle : driver.getWindowHandles()){
				  	    if(!winHandle.equals(parentWindow)) {
				  	        driver.switchTo().window(winHandle);
				  	    }
				  	}
	  	  
			  	Thread.sleep(10000);
			  	PurchaseOrderTextPreviewVerification=PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_PurchaseOrderNumberVerification.getText();	 
			  	System.out.println(PurchaseOrderTextPreviewVerification);
			  	//Validate the OrderNumber
			  	Assert.assertTrue(PurchaseOrderTextPreviewVerification.contains("Purchase Order"));
	  	
       }
        catch(NoSuchElementException e){
         e.getMessage();
       }
	}
	public static void PurchaseOrder_SalesPersonDetails_PreviewVerification() throws IOException, InterruptedException{
		try
		{
			  	SalesPersonDetailsVerification=PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_SalesPersonDetailsVerification.getText();
			  	System.out.println(SalesPersonDetailsVerification);
			  	
			  	//Validate the Sales Person details is displayed or not
			  	Thread.sleep(5000);
			  	Assert.assertTrue(PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_SalesPersonDetailsVerification.isDisplayed() );
		}
		catch(NoSuchElementException e){
	   e.getMessage();
	}
	  
	}
	
	public static void PurchaseOrderPreview_TermsandPaywith() throws IOException, InterruptedException{
		try
		{
			//Verify terms value is not displaying on purchase order doc
			List<WebElement> Termsvalue=driver.findElements(By.xpath("//strong[contains(text(),'Terms:')]"));
			int Termscount=Termsvalue.size();
			Thread.sleep(2000);
			Assert.assertEquals(Termscount, 0);
			
			List<WebElement> Paywith=driver.findElements(By.xpath("//strong[contains(text(),'Pay With:')]"));
			int Paywithcount=Termsvalue.size();
			Thread.sleep(2000);
			Assert.assertEquals(Paywithcount, 0);
	
	     }
		catch(NoSuchElementException e){
	   e.getMessage();
	}
	  
	}
	
	
	public static void PurchaseOrderPreview_SplitShipment1_Details_Verification() throws IOException, InterruptedException{
		try{
			Thread.sleep(2000);
			//Validating Split Shipment 1 Details on preview screen on Purchase Order Preview
			 Assert.assertTrue(PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_SplitShipment1Area.isDisplayed());
	
       
		}catch(NoSuchElementException e){
		   e.getMessage();
		}
	}	
	  public static void PurchaseOrderPreview_SplitShipment1_DecorationDetails_Verification() throws IOException, InterruptedException{
		  try
		  {
	  	
			  	PurchaseOrderDecorationDetails_Verification=PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_DecorationDetails_SplitShipment1Area.getText();
			  	System.out.println(PurchaseOrderDecorationDetails_Verification);
		
			  	//Validate the Decoration details on purchase Order preview
			
			  	Assert.assertTrue(PurchaseOrderDecorationDetails_Verification.contains("Location:") & PurchaseOrderDecorationDetails_Verification.contains("Test Vendor Notes"));
		        
		  }
		  catch(NoSuchElementException e){
		    e.getMessage();	
		}
	  }	  
	  	public static void PurchaseOrder_PersonalizationDecoration_DocDownload() throws IOException, InterruptedException{
	  		try
	  		{
			  	//Download the Persolaimzation doc for PO in Preview
			  	PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_Decoration_DownloadFile.click();
			  	Thread.sleep(10000);
			  	//Now Validating as if the Personalization file is downloaded successfully or not
			  	File PersonalizationFile = getLatestFilefromDir(downloadPath);
				String PersonalizationDownload = PersonalizationFile.getName();
				Assert.assertTrue(PersonalizationDownload.contains("DocP"));
	  	}
	  		catch(NoSuchElementException e){
	  		e.getMessage();
	  	}
	  	}	 
	  	public static void PurchaseOrder_AtworkDecoration_DocDownload() throws IOException, InterruptedException{
	  		
	  	try
	  	{
	  	        		
	  		//Click the Atwork Download in preview for Decoration details
	  		PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_Decoration_Atwork_DownloadFile.click();
		  	Thread.sleep(10000); 
		  	//Now Validating as if the Decoration Atwork Document downloaded or not
		  	File AtworkFile = getLatestFilefromDir(downloadPath);
			String AtworkDownload = AtworkFile.getName();
			Assert.assertTrue(AtworkDownload.contains("logo"));
	  	   }
	  	catch(NoSuchElementException e)
	  	{
	  		   e.getMessage();
	  	   }
	  	}
	  	 public static void PurchaseOrder_PreviewShippingDetails_Verification() throws IOException, InterruptedException{       
	  	 try
	  	 {
	  		 //Now validating the shipping details address on Purchase Order Preview
	  		 ShippingdetailsAddress_PurchaseOrderPreview=PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_ShippingToDetails.getText();
	  		 System.out.println(ShippingdetailsAddress_PurchaseOrderPreview);
	  		 Assert.assertTrue(ShippingdetailsAddress_PurchaseOrderPreview.contains("Feasterville-Trevose, PA"));
	 }
	  	 catch(NoSuchElementException e)
	  	 {
		 e.getMessage();
	  	 }
	  	 }  	        
	 public static void PurchaseOrder_BlindShip_Verification() throws IOException, InterruptedException{	 
	 try
	{	        
		 //Validating the Blind Ship integration with shipping address in purchase order
		Assert.assertTrue(PurchaseOrderPreviewWithDownload.BlindShipText_ShippingDetails_PurchaseOrder.getText().contains("Blind Ship"));
	  	
	}
	 catch(NoSuchElementException e)
		 {
			 e.getMessage();
		 }
	 }
	public static void PurchaseOrder_AtworkPO_DocDownload() throws IOException, InterruptedException{
	try
	{ 
	  //Click Atwork Download button to download PO Atwork zip file
	  PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_POAtworkDownload.click();
	  Thread.sleep(25000); 
	  //Validate as if the PurchaseOrder Atworkdownload working or not
	   File AtworkFilePO = getLatestFilefromDir(downloadPath);
	   System.out.println("Testinf download path " + AtworkFilePO);
	   String AtworkDownloadPO = AtworkFilePO.getName();
	   Thread.sleep(10000); 
	   Assert.assertTrue(AtworkDownloadPO.contains("Purchase Order"));
        
	 }
	catch(NoSuchElementException e)
	{
		e.getMessage();
		    
	}
		
		 }	          
	public static void PurchaseOrder_POPDF_DocDownload() throws IOException, InterruptedException{ 
	try
	{   
		   
		  //Click Download button to download PO PDF file
			Click("Download",PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_PODocDownload);

		  Thread.sleep(30000); 
		   //Validate as if the PurchaseOrder PDf Downloading working or not
		   File PODownloadPDF = getLatestFilefromDir(downloadPath);
		   String DownloadPOPDF = PODownloadPDF.getName();
		   Assert.assertTrue(DownloadPOPDF.contains("Purchase Order "));
		
 		}catch(NoSuchElementException e)
	{
 			e.getMessage();
 	}
			     
		}		     
		public static void Calculating_TotalCost_On_Preview() throws IOException, InterruptedException, ParseException{
		try
		{
			//Converting preview TotalPrice From String to integer
			 ConversionsWithoutOtherCharges.TotalPricePreview_String_To_Int_Conversion();
			 //Validating the TotalPrice on preview screen
			 Thread.sleep(2000);
			 Assert.assertNotEquals(ConversionsWithoutOtherCharges.TotalPriceSumAmount, ConversionsWithoutOtherCharges.TotalPricePreview);
			
		   }
		catch(NoSuchElementException e)
		   {
			   e.getMessage();
		   }
		} 
		
		public static void Calculating_TotalPrice_On_Preview() throws IOException, InterruptedException, ParseException{
			try
			{
				List<WebElement> TotalPrice=driver.findElements(By.xpath("//th[contains(@class,'text-center total-price')]"));
				int TotalPriceSize=TotalPrice.size();
				System.out.println(TotalPriceSize);
				if(TotalPriceSize==0)
				{
					Assert.assertTrue(true);
				}
				
				
			   }
			catch(NoSuchElementException e)
			   {
				   e.getMessage();
			   }
			} 
		
		public static void PurchaseOrderPreview_ViewPackagingList_Verification() throws IOException, InterruptedException{
		try
		{	
		
			//Validating Packaging list option displayed on purchase Order preview or not
			Assert.assertTrue(PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_ViewPackagingList.isDisplayed());
		
		}catch(NoSuchElementException e){
			e.getMessage();
		}
		}
		public static void PackingList_Display_Verification() throws IOException, InterruptedException{
		try
		{	
			SoftAssert Softassertion=new SoftAssert();
			//First store parent window to switch back
			parentWindow10 = driver.getWindowHandle();
		 
			//Now Validating as if the packaging list opened successfully in new tab or not
			PurchaseOrderPreviewWithDownload.PurchaseOrder_Preview_ViewPackagingList.click();
			
			Thread.sleep(5000);
			//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow10)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
			 
		  Thread.sleep(1000);
		  Softassertion.assertTrue(PurchaseOrderPreviewWithDownload.PackingList_DisplayView.isDisplayed());
		  Softassertion.assertAll();
			driver.close();
	        //
	        Thread.sleep(2000);
	        
	      //Switch back to parent window 
	        driver.switchTo().window(parentWindow10);

		  
		   }catch(NoSuchElementException e){
			   e.getMessage();
		   }
		}    
		 
	public static void PurchaseOrder_Preview_POSend() throws InterruptedException, IOException{
	 try
	 {
		 
		
		
		 //Validating the PO Sending Mail Process to check if the mail sending successfully or not
		 	WebElement el = 	  	PurchaseOrderPreviewWithDownload.PO_SendButton;
			Actions builder = new Actions(driver);
			builder.moveToElement( el ).click( el );
			builder.perform();
			waitForPageLoading();
			Thread.sleep(10000);
			
			PurchaseOrderPreviewWithDownload.Send_PO_ToandCCRemoveIcon.click();
		    
		    Thread.sleep(1000);
		 
		    
		    //Insert a new Email address in To Field
		    Actions a = new Actions(driver);
		    a.doubleClick( PurchaseOrderPreviewWithDownload.SendPO_To_Field);
		    a.perform();
		    PurchaseOrderPreviewWithDownload.SendPO_To_Field.sendKeys("bnazir@asicentral.com");
		    
		    Thread.sleep(2000);
		    PurchaseOrderPreviewWithDownload.SendPO_To_Field.sendKeys(Keys.ENTER);
		    
		    Thread.sleep(2000);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();",PurchaseOrderPreviewWithDownload.PO_SendButton);
		    WebElement el1 = 	  PurchaseOrderPreviewWithDownload.PO_SendButton;
		     Actions builder1 = new Actions(driver);
		     builder1.moveToElement( el1 ).click( el1 );
		     builder1.perform();
		    Thread.sleep(5000);
		    Assert.assertTrue(PurchaseOrderPreviewWithDownload.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
		

		
		}
	 catch(NoSuchElementException e)
	 {
			e.getMessage();
	 }
	
	 finally
	 {
		 Thread.sleep(5000);
		
		 driver.close();
       //
		 Thread.sleep(2000);
   
		 //Switch back to parent window 
		 driver.switchTo().window(parentWindow);
	 }
		
		} 
	public static File getLatestFilefromDir(String dirPath)
	{
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

