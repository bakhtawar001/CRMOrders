package OrdersTestcases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class CreateQuote extends OrdersExecution1 
{

	 static File QuoteDownloadPDF;
	 static String DownloadQuotePDF;
	 static Set<String>windowhandles;
	 static Iterator<String>It;
	 static String ParentWindow;
	 static String ChildWindow;
	 static WebElement DocumentSelection_Dropdown;
	 static Select DocumentDropdownValue_Selection;
	 public static String SelectedImprintLocation;
	 static OrdersLocators CreateQuote = PageFactory.initElements(driver, OrdersLocators.class);
	
	 
	 public static void CustomerFacingDoc_CPN_Visible_Enable_FromSettings() throws InterruptedException{
		 try
		 {
		
			 //Go to settings
			 Thread.sleep(10000);
			 CreateQuote.OrderListing_UserInfoIcon.click();
			 Thread.sleep(1000);
			 CreateQuote.UserInfoIcon_Settings.click();
			 Thread.sleep(2000);
			 //Press the Document Design option in settings
			 CreateQuote.Settings_DocumentDesign_Option.click();
			 Thread.sleep(1000);
			 DocumentSelection_Dropdown=CreateQuote.Settings_DocumentDesign_DocumentSelectionDropdown;	 
			 DocumentDropdownValue_Selection=new Select(DocumentSelection_Dropdown);
			 DocumentDropdownValue_Selection.selectByVisibleText("Acknowledgment");
			 if(!CreateQuote.CustomerFacingDoc_CPNNumber_Selection.isSelected())
			{
				 CreateQuote.CustomerFacingDoc_CPNNumber_Selection.click();
			}
				 JavascriptExecutor je = (JavascriptExecutor) driver;
				 // now execute query which actually will scroll until that element is not appeared on page.
				 je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//a[contains(@id,'saveDocSettings')]")));
				 //Press the Save Button
				 Click("Click the Saving Doc",CreateQuote.SavingDocSettings);
				 //CreateQuote.SavingDocSettings.click();
				 Thread.sleep(5000);
				 DocumentSelection_Dropdown=CreateQuote.Settings_DocumentDesign_DocumentSelectionDropdown;	 
				 DocumentDropdownValue_Selection=new Select(DocumentSelection_Dropdown);
			 if(!CreateQuote.CustomerFacingDoc_CPNNumber_Selection.isSelected())
			 {
				 CreateQuote.CustomerFacingDoc_CPNNumber_Selection.click();
			 }
			     //Press the Save Button
				Click("Click the Saving Doc",CreateQuote.SavingDocSettings);
				//CreateQuote.SavingDocSettings.click();
				Thread.sleep(5000);
				DocumentSelection_Dropdown=CreateQuote.Settings_DocumentDesign_DocumentSelectionDropdown;	 
				DocumentDropdownValue_Selection=new Select(DocumentSelection_Dropdown);
				DocumentDropdownValue_Selection.selectByVisibleText("Quote");
			if(!CreateQuote.CustomerFacingDoc_CPNNumber_Selection.isSelected())
			{
				CreateQuote.CustomerFacingDoc_CPNNumber_Selection.click();
			}
				//Press the Save Button
				CreateQuote.SavingDocSettings.click();
				Thread.sleep(5000);
		 }
		 catch(NoSuchElementException e)
		 {
			 e.getMessage();
		 }
	 }
	 
	 
	 
	 public static void QuoteCreation_BillingAddressVerification() throws IOException, InterruptedException, ParseException{
        try
        {
        	Thread.sleep(5000);
        	Click("Click order home page", CreateQuote.ESPWebHomePage_OrdersTab);
        	Click("Click order button", CreateQuote.OrdersScreen_OrderButton);
        	Click("Click create quote button", CreateQuote.CreateOrder_QuoteOption);
        	waitForPageLoading();
        	//Select the Sales Order option from toggle dropdown
        	Thread.sleep(2000);
        	//Select the company first on create order screen
        	Click("Select a company from list",  CreateQuote.CreateOrderScreen_CompanySearch_Textfield);
        	Thread.sleep(2000);
        	CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
        	Thread.sleep(10000);
        	CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
        	//Select company from company dropdown
        	CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
        	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
        	waitForPageLoading();
        	Thread.sleep(2000);
        	String QuoteBillingAddress=driver.findElement(By.cssSelector("order-contact[ng-model='vm.order.BillingContact']")).getText();
        	boolean testQuoteBillingAddress=driver.getPageSource().contains("Feasterville-Trevose, PA 19053");
        	System.out.println(testQuoteBillingAddress);
        	Assert.assertTrue(!QuoteBillingAddress.isEmpty());
	
        }
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }
	}
	 public static void FieldsData_Verification_AfterRequote() throws IOException, InterruptedException{
			try
			{
		
				SoftAssert softAssertion=new SoftAssert();
				Click("Click To Close Order", CreateQuote.CloseOrder_Icon_SampleRequest);
			
				Thread.sleep(2000);
				
	        	Click("Click order button", CreateQuote.OrdersScreen_OrderButton);
	        	Click("Click create quote button", CreateQuote.CreateOrder_QuoteOption);
	        	Input("Provide PO Refrence", CreateQuote.Order_POReferenceField, "Ref#123");
	        	//Select the In-hand date
	        	Click("Select the In-hand date",	 CreateQuote.Inhand_Orderdate_CalenderIcon);
				Thread.sleep(1000);
				//Move to next month through next icon in date picker
				Click("Date picker",	 CreateQuote.CalenderMoveNextMonthIcon);
				Thread.sleep(2000);
				Click("Date picker",	 CreateQuote.CalenderMoveNextMonthIcon);
				Thread.sleep(2000);
				//Select the In-hand date
				Click("Select the In-hand date",	 CreateQuote.InhandDate_Selection);	 
			    Thread.sleep(2000);
			    Click("Apply In-hand date",	 CreateQuote.InHandDate_Apply_Button);	 
				Thread.sleep(7000);
				WebElement InhandDate= CreateQuote.SamplerRequest_Inhand_Date;
				String Inhandvalue=InhandDate.getAttribute("value");
				System.out.println(Inhandvalue);
				
				
				//Select the In-Ship date
	        	Click("Select the In-hand date",	 CreateQuote.InShip_Orderdate_CalenderIcon);
				Thread.sleep(1000);
				//Move to next month through next icon in date picker
				Click("Date picker",	 CreateQuote.CalenderMoveNextMonthIcon);
				Thread.sleep(2000);
				
				//Select the In-hand date
				Click("Select the In-hand date",	 CreateQuote.InhandDate_Selection);	 
			   
			   // Click("Apply In-hand date",	 CreateQuote.InHandDate_Apply_Button);	 
				Thread.sleep(7000);
				WebElement InShipDate= CreateQuote.ShipdateField;
				String InShipvalue=InhandDate.getAttribute("value");
				System.out.println(InShipvalue);
				
				Click("Select the In-hand date",	 CreateQuote.SaveQuote);	
				Thread.sleep(2000);
				//First store parent window to switch back
				 Click("Click at OK button to confirm",    CreateQuote.Orderdetails_MoreButton);
				 Thread.sleep(2000);
				 Click("Click at OK button to confirm",   CreateQuote.MoreButton_Requote);
				 
				 waitForPageLoading();
				 Thread.sleep(6000);
				 if(CreateQuote.Order_POReferenceField_Checkbox.isSelected())
				 {
					 Click("Uncheck PO Refrence",  CreateQuote.Order_POReferenceField_Checkbox);
				 }
				 Click("Continue",  CreateQuote.CreateQuote_CopyOptions_Continue_Button);
				 
				 String POFieldAfter_Requote=CreateQuote.Order_POReferenceField.getText();
				 
				 String Inhanddate_AfterRequote=CreateQuote.SamplerRequest_Inhand_Date.getText();
				 
				 String ShipDate_AfterRequote=CreateQuote.ShipdateField.getText();
				 Thread.sleep(2000);
				 Assert.assertTrue(POFieldAfter_Requote.isEmpty() && Inhanddate_AfterRequote.isEmpty() && ShipDate_AfterRequote.isEmpty());
				
				
			}
			catch(NoSuchElementException e){
			  e.getStackTrace();
			}
		}
	 public static void ReviewSupplierAS_DefaultDecorator() throws IOException, InterruptedException, AWTException{
			try
			{
		
				SoftAssert softAssertion=new SoftAssert();
				CreateOrder.AddProductConfiguration_Order();
				List<WebElement>SupplierName=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]/descendant::a[contains(@ui-sref, 'companies.company.view({ id: lineItem.Supplier.Id })')]"));
				String Suppliername=SupplierName.get(0).getText();
				System.out.println(Suppliername);
				Click("Click on Edit button",CreateQuote.OrdersDetails_EditButton);
		    	
		  		waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			
		  		Thread.sleep(2000);

			    //Go to Decoration Tab
		  		Click("Decoration tab ", CreateQuote.EditOrder_DecorationTab);
		  		List<WebElement>DecoratorName=driver.findElements(By.xpath("//span[contains(@aria-label,'Select a Decorator activate')]/span"));
				String Decoratorname=DecoratorName.get(1).getText();
				System.out.println(Decoratorname);
		  		
				Thread.sleep(2000);
		  		Assert.assertEquals(Suppliername, Decoratorname);
		  		softAssertion.assertAll();
		  		driver.navigate().refresh();
			}
			catch(NoSuchElementException e){
			  e.getStackTrace();
			}
		
		}
	 
	
	 public static void InHandsDateButtonOptions_POPUpVerification() throws IOException, InterruptedException, AWTException{
			try
			{
		
				SoftAssert softAssertion=new SoftAssert();
				 waitForPageLoading();
				 Thread.sleep(6000);

				//Select the company first on create order screen
				CreateQuote.CreateOrderScreen_CompanySearch_Textfield.click();
				Thread.sleep(2000); 
				CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
				Thread.sleep(6000);
				CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
				Thread.sleep(1000);
				//Select company from company dropdown
				CreateQuote.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
				Thread.sleep(2000);
				//Press the save button
				Click("Click at save button", CreateQuote.SampleRequestSaveButton);
				waitForPageLoadSave();
				Click("Select the In-hand date",	 CreateQuote.Inhand_Orderdate_CalenderIcon);
				Thread.sleep(1000);
				//Move to next month through next icon in date picker
				Click("Date picker",	 CreateQuote.CalenderMoveNextMonthIcon);
				Thread.sleep(2000);
				Click("Date picker",	 CreateQuote.CalenderMoveNextMonthIcon);
				Thread.sleep(2000);
				//Select the In-hand date
				Click("Select the In-hand date",	 CreateQuote.InhandDate_Selection);	 
			    Thread.sleep(2000);
			   if(! CreateQuote.ShipDateFirmButtonOption.isSelected())
			   {
			    Click("Select the In-hand date",	 CreateQuote.ShipDateFirmButtonOption);	 
			   }
			    Click("Apply In-hand date",	 CreateQuote.InHandDate_Apply_Button);	 
				Thread.sleep(7000);
				Assert.assertTrue(CreateQuote.ConfirmationMessageonDateSelection.getText().contains("Would you like to apply your date changes to all products?"));
				softAssertion.assertAll();
				 Click("Apply In-hand date",	 CreateQuote.DeleteOrder_Okbutton);
				
			}
			catch(NoSuchElementException e){
			  e.getStackTrace();
			}
			finally
			{
				
	    		Click("Close Order",CreateQuote.CloseOrder_Icon_SampleRequest);
	    		Click("Close Order",CreateQuote.CloseAndExit);
	    		//waitForPageLoading();
	    		Thread.sleep(7000);
			}
		}

	public static void QuoteCreation_ShippingAddressVerification() throws IOException, InterruptedException{
		try
		{
	
			String QuoteShippingAddress=driver.findElement(By.cssSelector("address[ng-show='$ctrl.ngModel.Address']")).getText();
			boolean testQuoteShippingAddress=driver.getPageSource().contains("Feasterville-Trevose, PA 19053");
			System.out.println(testQuoteShippingAddress);
			Assert.assertTrue(!QuoteShippingAddress.isEmpty());
		}
		catch(NoSuchElementException e){
		  e.getStackTrace();
		}
	}
	public static void ProductAddedToQuote() throws IOException, InterruptedException{
		try
		{
			
			//Press Add Product Button
			CreateQuote. CreateOrder_AddProductButton.click();
			waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			Thread.sleep(2000);
			//Go To Product Search Tab in popup
			CreateQuote.AddProduct_Clipboard_US_Product.click();
			//Press the Add Products Button to complete the process
			CreateQuote.CreateOrder_AddProductPopup_AddProductsButton.click();
			waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			Thread.sleep(2000);
			String ProductAddedToOrderSuccess=CreateQuote.CreateOrder_ProductAddedToOrder_Successfull.getText();
			Thread.sleep(2000);
			Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));

		}
		catch(NoSuchElementException e)
		{
			e.getStackTrace();
		}
	}
	
	public static void QuoteCreation_Verification() throws IOException, InterruptedException{
		try
		{
			Thread.sleep(5000);
			Click("Confiure Product", CreateQuote.CreateOrders_ConfigureButton);
			List<WebElement> records = CreateQuote.Price_Grid;
			int record=records.size();
			//Enter The Quantity on Quatity screen
			if(record>=1) 
			{
				Click("Click at Select button of price grid", CreateQuote.ClickAtSelect);
				Thread.sleep(2000);
				CreateQuote.CreateOrder_Configure_Continue_Button.click();
				Thread.sleep(2000);
				CreateQuote.CreateOrder_Configure_QTY_TextField.sendKeys("5");
			}
			else 
			{
	
				CreateQuote.CreateOrder_Configure_Continue_Button.click();
				Thread.sleep(2000);
				CreateQuote.CreateOrder_Configure_QTY_TextField.sendKeys("5");
			}

				//Enter The Quantity on Quatity screen
				Thread.sleep(5000);
				//Press the continue Button
				CreateQuote.CreateOrder_Configure_Continue_Button.click();
				Thread.sleep(5000);
				//Decoration Optional Screen Appear Press the save button now to create a Order
				CreateQuote.CreateOrder_DecoratorScreen_Save_Button.click();
				Thread.sleep(5000);
				Assert.assertTrue(CreateQuote.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
				waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
    
		}
	
			catch(NoSuchElementException e)
		{
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	   }
	}  
	public static void AddImprintLocation() throws IOException, InterruptedException{
		try
		{
			 Click("a",CreateQuote.OrdersDetails_EditButton);
			 waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			 Thread.sleep(1000);
			 Click("Decoration tab ", CreateQuote.EditOrder_DecorationTab);
			 Thread.sleep(2000);
			 Click("Click on Location Dropdown",CreateQuote.EditOrder_Decoration_Location);
			 List<WebElement>ImprintLocationValue=driver.findElements(By.xpath("//div[contains(@ng-if,'vm.imprintLocations')]/descendant::div[contains(@ng-repeat,'imprintLocation in $select.items')]"));
			 int size =ImprintLocationValue.size();
			 Random rand21 = new Random();
				// Obtain a number between [0 - size].
				  int n21 = rand21.nextInt(size);
				  ImprintLocationValue.get(n21).click();
				 Thread.sleep(2000);
				 SelectedImprintLocation=CreateQuote.EditOrder_Decoration_Location.getText();
				 System.out.println(SelectedImprintLocation);
				 Click("Save Decoration",CreateQuote.SaveDecoration);
		}
	
			catch(NoSuchElementException e)
		{
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	   }
	}  
	
	public static void VerifyTermandPay_QuoteRequest_Preview() throws InterruptedException, IOException{
		try{
			
			SoftAssert softassert=new SoftAssert();
			//CreateQuote.Quote_Request.get(3).click();
			List<WebElement> Quote_Request=driver.findElements(By.xpath("//li[contains(@class,'ng-pristine ng-untouched ng-valid ng-scope ng-not-empty')]"));
			Quote_Request.get(3).click();
			//Click("Click Quote Requests",CreateQuote.Quote_Request);
			Thread.sleep(2000);
			Click("Click on Preview", CreateQuote.Preview_QuoteRequest);
			waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			Thread.sleep(35000);
			windowhandles=driver.getWindowHandles();
			It=windowhandles.iterator();
		    ParentWindow=It.next();
			System.out.println(ParentWindow);
		    ChildWindow=It.next();
			System.out.println(ChildWindow);
			driver.switchTo().window(ChildWindow);
			Thread.sleep(15000);
			List<WebElement> Termsvalue=driver.findElements(By.xpath("//*[contains(text(),'Terms:')]"));
			int Termscount=Termsvalue.size();
			Thread.sleep(2000);
			Assert.assertEquals(Termscount, 0);
			List<WebElement> Paywith=driver.findElements(By.xpath("//*[contains(text(),'Pay With:')]"));
			int Paywithcount=Termsvalue.size();
			Thread.sleep(2000);
			Assert.assertEquals(Paywithcount, 0);
			softassert.assertAll();
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(ParentWindow);
			
		}
		
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		
	}
	public static void ShipAccountNo_Checkbox_Uncheck_ByDefault_Verification() throws IOException, InterruptedException{
		try
		{
			
			Thread.sleep(2000);
			//CreateQuote.Pricingtab.click();
			CreateQuote.PriceTab.click();
			Thread.sleep(2000);
			Assert.assertTrue(!CreateQuote.AccountNo_Visible_Checkbox.isSelected());
		
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
	}
	
	
		
	public static void ShipAccountNotVisible_Visible_Checkbox_UncheckFor_AccountNo() throws InterruptedException, IOException{
		try
		{
			Click("Click the Preview Button on quote detail Page for Account No Verification", CreateQuote.Quote_Preview_Button);
			waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
			Thread.sleep(35000);
			windowhandles=driver.getWindowHandles();
			It=windowhandles.iterator();
		    ParentWindow=It.next();
			System.out.println(ParentWindow);
		    ChildWindow=It.next();
			System.out.println(ChildWindow);
			driver.switchTo().window(ChildWindow);
			Thread.sleep(15000);
			List<WebElement>ShipAccountNo=CreateQuote.ShipAccount_QuotePreview_Verification_ListCount;
			int count=ShipAccountNo.size();
			System.out.println(count);
			Assert.assertEquals(count, 0);
			
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}

	}
	public static void VendorInformation() throws IOException, InterruptedException
	{
	try{
			List<WebElement> VendorInformation=driver.findElements(By.xpath("//tbody[contains(@ng-repeat,'group in vm.groupedLineItems')]/descendant::a[contains(@ui-sref,'companies.company.view({ id: lineItem.Supplier.Id })')]"));
			int size=VendorInformation.size();
			if(size==0)
			{
				Assert.assertTrue(true);
			}
		
			
		}catch(NoSuchElementException e){
			e.getMessage();
		}
	}
	public static void VerifyImprintLocation() throws IOException, InterruptedException
	{
	try{
		Thread.sleep(2000);
		Assert.assertTrue(CreateQuote.ImprintLocation.getText().contains(SelectedImprintLocation));
		
			
		}catch(NoSuchElementException e){
			e.getMessage();
		}
	}
	public static void CPN_Number_QuoteDoc_Preview_Verification() throws IOException, InterruptedException{
		try{
			Thread.sleep(2000);
			Assert.assertTrue(CreateQuote.CustomerFacingDoc_CPN_Visible_Verification.getText().contains("CPN-"));
		
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
		finally 
		{
			driver.close();
			Thread.sleep(2000);
			driver.switchTo().window(ParentWindow);
		}

	}

	public static void VendorNotes_DecoratorNotes_DecoratorInstructions_Visible_checkbox_SelectedAtProductLevel_QuotePreview_Verification() throws InterruptedException, IOException{
	 try{
		 
		 Click("Click the Edit Button", CreateQuote.OrdersDetails_EditButton);
		 wait = new WebDriverWait(driver, 180);
		 wait.until(ExpectedConditions.elementToBeClickable(CreateQuote.EditOrder_DecorationTab));
		 Thread.sleep(2000);
		 //Goto Shipping Tab
		 CreateQuote.EditOrder_DecorationTab.click();
		 //Enter the Vendor Notes in vendor notes Textarea
		 CreateQuote.EditOrder_Decoration_VendorNotes.sendKeys("Test Vendor Notes");
		 //Select the Visible Checkbox for Vendor Notes
		 Click("Select the Visible checkbox for Vendor Notes In Decoration tab", CreateQuote.VendorNotes_Visible_Checkbox);
		 //Enter the Decoration Instructions
		 CreateQuote.DecorationInstructions_Textarea.sendKeys("Test Decorator Instructions");
		 Click("Select the Visible checkbox for Decorator Instructions In Decoration tab", CreateQuote.DecorationInstructions_Visible_Checkbox);
		 Click("Click the Save Button", CreateQuote.ProductConfiguration_AddCharge_SaveButton);
		 Thread.sleep(8000);
		 Click("Click the Preview Button on quote detail Page for Account No Verification", CreateQuote.Quote_Preview_Button);
		 Thread.sleep(40000);
		 windowhandles=driver.getWindowHandles();
		 It=windowhandles.iterator();
		 ParentWindow=It.next();
		 System.out.println(ParentWindow);
		 ChildWindow=It.next();
		 System.out.println(ChildWindow);
		 driver.switchTo().window(ChildWindow);
		 Thread.sleep(30000);
		 Assert.assertTrue(CreateQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText().contains("Notes:") && CreateQuote.DecoratorInstructions_QuotePreview_Verification.getText().contains("Instructions:") && CreateQuote.VendorNotes_DecoratorInstructions_QuotePreview_Verification.getText().contains("Test Vendor Notes") && CreateQuote.DecoratorInstructions_QuotePreview_Verification.getText().contains("Test Decorator Instructions"));
		
	
		
	 }catch(NoSuchElementException e){
		 e.getMessage();
	 }
 finally
 
 {
	 Thread.sleep(2000);
	 driver.close();
	Thread.sleep(2000);
	driver.switchTo().window(ParentWindow);
 }
 }
	
	public static void ShipAccountNo_Visibility_QuoteDocument_Verification() throws InterruptedException, IOException{
		try
		{
			
		Click("Click the Account No Visibilty Checkbox",CreateQuote.AccountNo_Visible_Checkbox );
		Thread.sleep(2000);
		Click("Click the Ok button to confirm Account Number Visibilty", CreateQuote.AccountNo_Visible_Confirm);
		Thread.sleep(2000);
		Click("Click the Preview Button on quote detail Page for Account No Verification", CreateQuote.Quote_Preview_Button);
		waitForPageLoadSave();
		Thread.sleep(6000);
		windowhandles=driver.getWindowHandles();
		It=windowhandles.iterator();
	    ParentWindow=It.next();
		System.out.println(ParentWindow);
	    ChildWindow=It.next();
		System.out.println(ChildWindow);
		driver.switchTo().window(ChildWindow);
		Thread.sleep(2000);
		Assert.assertTrue(CreateQuote.ShipAccount_QuotePreview_Verification.isDisplayed() & CreateQuote.ShipAccount_QuotePreview_Verification.getText().contains("Ship Account:"));

		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
	
	}
		
    public static void AccountNo_Visible_Checkbox_Selected_Verification_At_ProductLevel() throws InterruptedException, IOException{
    	try{
    		driver.close();
    		
    		Thread.sleep(8000);
    		
    		driver.switchTo().window(ParentWindow);
    		Thread.sleep(2000); 
    		Click("Click the Edit Button",  CreateQuote.OrdersDetails_EditButton);
    		
    		wait = new WebDriverWait(driver, 180);
    		wait.until(ExpectedConditions.elementToBeClickable(CreateQuote.EditOrder_ShippingTab));  
    		Thread.sleep(2000);   
    		//Goto Shipping Tab
    		CreateQuote.EditOrder_ShippingTab.click();  
    		Thread.sleep(2000);
    		//Validate if the Account No Visible box shuld be selected
    		Assert.assertTrue(CreateQuote.AccountNo_Visible_Checkbox.isSelected());
    	}
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    
      
    }
    
    public static void QuoteDownload() throws InterruptedException, IOException{
    	try
    	{
    		CreateQuote.ProductConfiguration_AddCharge_SaveButton.click();
        	waitForElementNotVisible(120, driver,CreateQuote.SpinnerLoader);
    	    Thread.sleep(2000);
    		//Click the download button to download the Quote Document
    		Click("Click the Quote Download Button", CreateQuote.QuoteDownload_Button);
    		Thread.sleep(20000);
    		File QuoteDoc = getLatestFilefromDir(downloadPath);
    		String QuoteDocDownload = QuoteDoc.getName();
    		Thread.sleep(2000);
    		Assert.assertTrue(QuoteDocDownload.contains("Quote #"));

    	}
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    }
    public static void ExportQuote() throws InterruptedException, IOException{
    	try
    	{
    		
    		 Click("a", CreateQuote.Quotetab);
    		 Thread.sleep(10000);
    		 Click("Order1 selection",CreateQuote.Quote1Selection);
 	  		Click("Order2 selection",CreateQuote.Quote2Selection);
 	  		Thread.sleep(2000);
 	  		Click("Export Orders",CreateQuote.ExportOrders);
 	  		Thread.sleep(2000);
 	  		Click("Export Orders",CreateQuote.ExportOrdersExcel);
 	  		Thread.sleep(2000);
 	  		
 	  		
 	  		Assert.assertTrue(CreateQuote.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
    	}
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    	
    }
    public static void Selection_AllQuotes() throws InterruptedException, IOException{
    	try
    	{
    		Click("a", CreateQuote.Quotetab);
   		 	Thread.sleep(10000);
   			Click("Select first 10 Orders",CreateQuote.SelectAllOrders);
   			Thread.sleep(2000);
   			Assert.assertTrue(CreateQuote.SelectAllMessage.isDisplayed());
   			Click("Select All Orders",CreateQuote.SelectAllMessage);
   			Thread.sleep(2000);
   			Assert.assertTrue(CreateQuote.ClearSelection.getText().contains("Clear Selection"));
	  		Click("Click to clear all selection",CreateQuote.ClearSelection);
	  		Thread.sleep(2000);
   			Assert.assertTrue(!CreateQuote.SelectAllOrders.isSelected());
    	}
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    	
    }
    public static void DeleteProductFromQuoteWhenOrderIsAssociated() throws InterruptedException, IOException, ParseException, AWTException{
    	try
    	{
    		QuoteCreation_BillingAddressVerification();
    		CreateOrder.AddProductConfiguration_Order();
    		CreateOrder_FromQuote.CreateOrders_FromQuote_LinkedTraction_VerificationInvoice();
    		Click("Delete Product",CreateQuote.DeleteProduct);
	  		Thread.sleep(2000);
	  		Click("Delete Product",CreateQuote.	ConfirmationButton);
	  		String ProductAddedToOrderSuccess=CreateQuote.CreateOrder_ProductAddedToOrder_Successfull.getText();
	  		Thread.sleep(2000);
			Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
	  	
    	}
    	catch(NoSuchElementException e)
    	{
    		e.getMessage();
    	}
    	
    }
	
	
   
	public static File getLatestFilefromDir(String dirPath)
	{
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) 
	    {
	        return null;
	    }

	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) 
	       {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}











}
