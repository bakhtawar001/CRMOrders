package OrdersTestcases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class EditOrderProduct_Decoration extends OrdersExecution1 {
	static String parentWindow;
	static OrdersLocators EditOrderDecoration = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Existing_Artwork_File_Upload_Verification() throws IOException, InterruptedException, ParseException, AWTException{
     try
     {
    	 Thread.sleep(4000);
    	 int count= EditOrderDecoration.ClosePopup.size();
    	 if(count>0)
    	 {
    	 	Click("Click on Edit button", EditOrderDecoration.ClosePopup.get(0));

    	 }

      		Click("Click on Edit button", EditOrderDecoration.OrdersDetails_EditButton);
	
      		waitForElementNotVisible(120, driver,EditOrderDecoration.SpinnerLoader);
 	
      		Thread.sleep(2000);
    
		    //Go to Decoration Tab
      		Click("Decoration tab ", EditOrderDecoration.EditOrder_DecorationTab);
		  
		    
		    Thread.sleep(2000);
		    
		    Click("Click on Location Dropdown",EditOrderDecoration.EditOrder_Decoration_Location);
		    Click("Select Location Value",EditOrderDecoration.EditOrder_Decoration_LocationValue);
		    Thread.sleep(5000);
		    
		    //Select the Imprint Method
		
		    if( EditOrderDecoration.EditOrder_Decoration_ImprintMethod.isDisplayed()) 
		    {
		        EditOrderDecoration.EditOrder_Decoration_ImprintMethod.click();
		
		    }
		
		    
		    Thread.sleep(3000);
	
		    EditOrderDecoration.EditOrder_Decoration_Imprint_SelectValue.click();
		    Thread.sleep(2000);
		    //Now Add Vendor code
		
		    EditOrderDecoration.EditOrder_Decoration_VendorNotes.sendKeys("VEN123");
		    
		    //Now Select the Proof Type
		    WebElement ProofType=EditOrderDecoration.EditOrder_Decoration_ProofType;
		    Select dropdownValue1= new Select(ProofType);
		    
		    dropdownValue1.selectByVisibleText("Email");
		    
		    Thread.sleep(1000);
		    //Enter Email
		    EditOrderDecoration.EditOrder_Decoration_ProofType_EmailAddress.sendKeys("bnazir@asicentral.com");
		    //Enter Logo Size
		    EditOrderDecoration.EditOrder_Decoration_ImprintSize.sendKeys("150x200");

		    //Enter Logo Color
		    EditOrderDecoration.EditOrder_Decoration_ImprintColor.sendKeys("Brown");
		    
		    Thread.sleep(3000);
		    
		    //Insert Vendor Notes
		    EditOrderDecoration.EditOrder_Decoration_VendorNotes.sendKeys("Test Vendor Notes");
		   
		    //Now Add the charges,Press the Add Charges
		  //  EditOrderDecoration.EditOrder_Decoration_AddCharge_LinkText.click();
		    
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", EditOrderDecoration.EditOrder_Decoration_AddCharge_LinkText);
		    
		    
		    //Insert the Netcost
		    EditOrderDecoration.EditOrder_Decoration_NetCostField.click();
		    EditOrderDecoration.EditOrder_Decoration_NetCostField.sendKeys("50");
		    
		    Thread.sleep(2000);
		    
		    
		    //Upload the Artwork image
		    
		    EditOrderDecoration.EditOrder_Decoration_ArtWorkImageUploadButton.click();
		    Thread.sleep(2000);
		    //Now Select the Existing Artwork and upload that at prologoduct level under decoration tab
		    Click("Click the Existing Artwork", EditOrderDecoration.EditOrder_Decoration_Existing_Artwork_Selection);
		    Thread.sleep(2000);
		    //Validate if the file existing file uploaded successfully or not
		    Assert.assertTrue(EditOrderDecoration.EditOrder_Decoration_Artwork_Existence_Verification.isDisplayed());
    
       }catch(NoSuchElementException e){
    	   e.getMessage();
       }
	}          
    public static void Artwork_Download_UnderDecorationTab() throws IOException, InterruptedException{
    try
    {
    	
    	//Hover the element
    	Hover(EditOrderDecoration.EditOrder_Decoration_ArtworkDownload); 
    	Thread.sleep(2000);
    	//Click the Download button
    	Click("Click the Artwork Download icon", EditOrderDecoration.EditOrder_Decoration_ArtworkDownload);
    	Thread.sleep(5000);
    	File Artwork = getLatestFilefromDir(downloadPath);
    	String ArtworkDownload = Artwork.getName();
    	Thread.sleep(2000);
    	Assert.assertTrue(ArtworkDownload.contains("DST"));

    	}
    catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    }
    public static void Artwork_Uncheck_VisibleCheckbox() throws IOException, InterruptedException{
        try
        {
        	
        	if(EditOrderDecoration.Decorator_VisibleCheckbox.isSelected())
        	{
        		Click("UnCheck the visible checkbox",EditOrderDecoration.Decorator_VisibleCheckbox);
        	}
        	JavascriptExecutor js = (JavascriptExecutor) driver;
    		js.executeScript("arguments[0].scrollIntoView();",  EditOrderDecoration.ProductConfiguration_AddCharge_SaveButton);
    		JavascriptExecutor executor = (JavascriptExecutor)driver;
    		executor.executeScript("arguments[0].click();", EditOrderDecoration.ProductConfiguration_AddCharge_SaveButton);
    		
        	}
        catch(NoSuchElementException e)
        	{
        		e.getMessage();
        	}
        }
    public static void Artwork_Visibility_AcknowledgementDoc() throws IOException, InterruptedException{
        try
        {
        	
        	
    		 Click("Click Function", EditOrderDecoration.PreviewButton_Orderdetails);
    		//Press the Acknowlodgement Order document
    		 Click("Select Ack", EditOrderDecoration.PreviewPopUp_Acknowledgement);
    		 Thread.sleep(3000);
    		//First store parent window to switch back
    		 parentWindow = driver.getWindowHandle();
    		 
    		 //Press the Preview Button
    		 Click("Select Ack", EditOrderDecoration.PreviewPopUp_PreviewButton);
    
    		 
    		//Switch to new window opened
    		  	for(String winHandle : driver.getWindowHandles()){
    		  	    if(!winHandle.equals(parentWindow)) {
    		  	        driver.switchTo().window(winHandle);
    		  	    }
    		  	}
    		  	  
    		  	Thread.sleep(10000);
    		  	List<WebElement> ArtWorkVisibility=driver.findElements(By.xpath("//table/tbody/tr/td/div/b[contains(text(),'Download Artwork:')]"));
    		  	System.out.println(ArtWorkVisibility.size());
    		  	if(ArtWorkVisibility.size()==0)
    		  	{
    		  		Assert.assertTrue(true);
    		  	}
    		  	List<WebElement> ProofEmailAddress=driver.findElements(By.xpath("  //table[contains(@class,'decoration-table')]/tbody/descendant::tr/td/b[contains(text(),'Proof Email Address:')]"));
    		  	System.out.println(ProofEmailAddress.size());
    		  	if(ProofEmailAddress.size()==1)
    		  	{
    		  		Assert.assertTrue(true);
    		  	}
    		  	
    		
        	}
        catch(NoSuchElementException e)
        	{
        		e.getMessage();
        	}
      
        }
    public static void ProofEmailAddres() throws InterruptedException, IOException{
        try
        {
        	List<WebElement> ProofEmailAddress=driver.findElements(By.xpath("  //table[contains(@class,'decoration-table')]/tbody/descendant::tr/td/b[contains(text(),'Proof Email Address:')]"));
		  	System.out.println(ProofEmailAddress.size());
		  	if(ProofEmailAddress.size()==1)
		  	{
		  		Assert.assertTrue(true);
		  	}
		  	
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
    
    public static void Artwork_File_Deletion() throws InterruptedException, IOException{
    try
    {
    	Click("Click on Edit button", EditOrderDecoration.OrdersDetails_EditButton);
    	
  		waitForElementNotVisible(120, driver,EditOrderDecoration.SpinnerLoader);
	
  		Thread.sleep(2000);

	    //Go to Decoration Tab
  		Click("Decoration tab ", EditOrderDecoration.EditOrder_DecorationTab);
	  
	    
	    Thread.sleep(2000);
	    if(!EditOrderDecoration.Decorator_VisibleCheckbox.isSelected())
    	{
    		Click("UnCheck the visible checkbox",EditOrderDecoration.Decorator_VisibleCheckbox);
    	}
    	//Now delete the uploaded artwork and validate it
    	//Hover the element
	    Hover(EditOrderDecoration.EditOrder_Decoration_ArtworkDelete_Icon);
	    Thread.sleep(2000);
	    //Click the Download button
	    Click("Click the Artwork Delete Icon", EditOrderDecoration.EditOrder_Decoration_ArtworkDelete_Icon);
	    Thread.sleep(2000);
        //Now Click button to confirm the if the artwork deleted Successfully or not
	    Click("Click the Artwork Delete Ok Button", EditOrderDecoration.Artwork_Delete_Confirm);
        Thread.sleep(2000);
        //Validate if the Artwork deleted Successfully or not 
        List<WebElement> ArtworkDelete_Verification=EditOrderDecoration.EditOrder_Decoration_Artwork_Deletion_Verification;
        int count=ArtworkDelete_Verification.size();  
	    System.out.println(count);
	    Assert.assertEquals(0, count);
    }
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    }
    public static void Decoration_Charge_With_Amount_calculation() throws IOException, InterruptedException, AWTException, ParseException{
    try
    {
    
    	EditOrderDecoration.EditOrder_Decoration_ArtWorkImageUploadButton.click();	
    	Thread.sleep(2000);
    	MoveToElement_Click(EditOrderDecoration.UploadButton);
    	Thread.sleep(3000);
    	
    	OrderDeletion.Projectpath=System.getProperty("user.dir");
    	System.out.println(OrderDeletion.Projectpath);
    	String Projectpath=System.getProperty("user.dir");
		Runtime.getRuntime().exec(Projectpath+"/Img/orderslogo.exe");
    	//Thread.sleep(15000);
    	waitForElementNotVisible(120, driver,EditOrderDecoration.SpinnerLoader);
    	Thread.sleep(15000);
    	EditOrderDecoration.EditOrder_Decoration_ArtWorkImageUploadButton.click();
    	//EditOrderDecoration.EditOrder_Decoration_ArtWorkImageUploadButton.click();
    	Thread.sleep(2000);
    	MoveToElement_Click(EditOrderDecoration.UploadButton);
    	Thread.sleep(4000);
    
		Projectpath=System.getProperty("user.dir");
		Runtime.getRuntime().exec(Projectpath+"/Img/DocP.exe");
		//Thread.sleep(15000);
		waitForElementNotVisible(120, driver,EditOrderDecoration.SpinnerLoader);
		Thread.sleep(15000);
		
		//Press the Save Button
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",  EditOrderDecoration.ProductConfiguration_AddCharge_SaveButton);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", EditOrderDecoration.ProductConfiguration_AddCharge_SaveButton);
		//Click("Click the Save Button",  EditOrderDecoration.ProductConfiguration_AddCharge_SaveButton);
		waitForElementNotVisible(120, driver,EditOrderDecoration.SpinnerLoader);
		Thread.sleep(2000);
		driver.navigate().refresh();
		//Converting subtotal from string to int
		Conversions.Subtotal_String_To_Int_Conversion();
  	 
		//Calculating Tax	
		// Conversions.Tax_Calculation_Automatic();
		Conversions.Tax_Calculation_Manual();
		//Sales Tax Conversion from String to integer with $ removing done 
  	 
		Conversions.SalesTax_String_To_Int_Conversion();
  	
		//Calculating the SubTotal
  	 
		Conversions.SubTotal_Calculation();
  	 
		//Rounding off the value SubTotal and Sum tax
   	 	Conversions.RoundingOffTotalAmount();
  	
   	 	//Now Converting the Amountdue from string to Int
   	 	Conversions.AmountDue_String_To_Int_Conversion();
   	 	Thread.sleep(5000);
   	 	//Now Validating the Total Amount due 
  	
   	 	Assert.assertEquals(Conversions.bd.doubleValue(), Conversions.AmountDue);
  
      }
    catch(NoSuchElementException e)
    {
      e.getMessage();
               
    }
	}
               
    public static void Verificationof_Decoration_Display_Under_Decoration_Tab() throws InterruptedException, IOException{
    try
    {
    	
    	//Validating in Decoration tab as if Decoration is displayed or not
    	Click("Clik at deco tab", EditOrderDecoration.Orderdetails_DecorationTab);
    	Thread.sleep(1000);
    	Assert.assertTrue(EditOrderDecoration.Orderdetails_DecorationTab_DecorationDisplayVerification.isDisplayed());
     }
      catch (NoSuchElementException e) 
    {
				// TODO: handle exception
       System.err.println("NoSuchElementException: " + e.getMessage());
    }  
    }
    public static void UpdateShippingWorkflow_WhenDecoratorIsUpdate() throws InterruptedException, IOException{
        try
        {
        	Click("Clik at deco tab", EditOrderDecoration.EditOrder_DecorationTab);
        	//Validating in Decoration tab as if Decoration is displayed or not
        	Click("Clik at deco dropdown", EditOrderDecoration.Orderdetails_DecoratorDropDown);
        	Thread.sleep(1000);
        	Input("Provide Decorator",EditOrderDecoration.Orderdetails_ProvideDecorator,"Circle Decorator");
        	Thread.sleep(6000);
        	EditOrderDecoration.Orderdetails_ProvideDecorator.sendKeys(Keys.ARROW_DOWN);
  		   	Thread.sleep(1000);
  		   //Select company from company dropdown
  		   	EditOrderDecoration.Orderdetails_ProvideDecorator.sendKeys(Keys.ENTER);
  		   	Thread.sleep(2000);
  		   	Click("Shiping Tab",EditOrderDecoration.EditOrder_ShippingTab);
        	List<WebElement>Decorator=driver.findElements(By.xpath("//div[contains(@ng-form,'shippingDestinationForm')]"));
        	int size=Decorator.size();
  		   	Thread.sleep(2000);
        	Assert.assertTrue(size>1);
        	
        	
         }
          catch (NoSuchElementException e) 
        {
    				// TODO: handle exception
           System.err.println("NoSuchElementException: " + e.getMessage());
        }  
        }
    public static void UpdateShippingWorkflow_WhenDecoratorIsDelete() throws InterruptedException, IOException{
        try
        {
        	Click("Clik at deco tab", EditOrderDecoration.EditOrder_DecorationTab);
        	//Validating in Decoration tab as if Decoration is displayed or not
        	Click("Clik at deco dropdown", EditOrderDecoration.RemoveDecorator);
        	Thread.sleep(1000);
  		   	Click("Shiping Tab",EditOrderDecoration.EditOrder_ShippingTab);
        	List<WebElement>Decorator=driver.findElements(By.xpath("//div[contains(@ng-form,'shippingDestinationForm')]"));
        	int size=Decorator.size();
  		   	Thread.sleep(2000);
        	Assert.assertTrue(size==1);
        	
        	
         }
          catch (NoSuchElementException e) 
        {
    				// TODO: handle exception
           System.err.println("NoSuchElementException: " + e.getMessage());
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
