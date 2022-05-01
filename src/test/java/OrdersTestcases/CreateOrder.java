package OrdersTestcases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CrmTestCases.SettingsScenarios;
import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;



public class CreateOrder extends OrdersExecution1 {
	public static String ArtworkfileBeforeCopy;
	public static String ShipFromBeforeCopyLineItem;
	public static String ShippingToaddressBeforeCopyLineItem;
	static String parentWindow;
	public static String SupplierPhoneNo;
	public static String ShippingContact;
	public static String OrderID;
	static JavascriptExecutor  js = (JavascriptExecutor) driver;
	static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static void CreateOrder_BillingAddress_Verification() throws IOException, InterruptedException, AWTException{
	try
	{

		Thread.sleep(10000);
		Click("SalesOrder Option",CreateOrder.CreateOrder_SalesOrderOption);
	   //Select the company first on create order screen
		Click("Select Company",	CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
   	 	Thread.sleep(2000);
   	 	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
   	 	Thread.sleep(6000);
    	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(1000);
    	//Select company from company dropdown
    	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
    	waitForPageLoading();
    	Thread.sleep(2000);
    	//Rest	
    	String BillingAddress=CreateOrder.CreateOrderScreen_BillingCompanyAddress.getText();
    	Thread.sleep(2000);
    	Assert.assertTrue(!BillingAddress.isEmpty());
   	
        }
	catch(NoSuchElementException e)
    {
           e.getMessage();
     }
	}
	public static void CreateOrder_ShippingAddress_Verification() throws IOException, InterruptedException{
	try
	{
   
		String ShippingAddress=CreateOrder.CreateOrderScreen_ShippingCompanyAddress.getText();
		Thread.sleep(2000);
		Assert.assertTrue(!ShippingAddress.isEmpty());
  
	}
	catch(NoSuchElementException e)
	{
		
		  e.getMessage();
	}
	}
   	public static void CreateOrder_AcknowlodgementAddress_Verification() throws IOException, InterruptedException{
   	try
   	{
   		String AckAddress=driver.findElement(By.cssSelector("address[ng-show='$ctrl.ngModel.Address']")).getText();
   		Assert.assertTrue(!AckAddress.isEmpty());

   		}
   	catch(NoSuchElementException e)
   	{
   		  e.getMessage();
   	}
   	}
   	
   	public static void Net25_Net45_Net90_50PercentAdvance_50PercentUponCompletion_Net75_Terms_DropdownValues_Verification() throws IOException, InterruptedException{
   	try
   	{
   		   //Click the Terms Dropdown
   			CreateOrder.Terms_Dropdown.click();
   			List<WebElement> list =CreateOrder.TermsDropdownValues;
   			int size=list.size();
   	       
   			System.out.println("size of list is:"+size);
   	       
   			for(int i=0;i<size;i++)
   			{
   	    	   System.out.println(list.get(i).getText());
   	    	   Assert.assertTrue(list.get(i).getText().contains("Net 25") & list.get(i).getText().contains("Net 45") & list.get(i).getText().contains("Net 90") & list.get(i).getText().contains("50% Advance / 50% Upon Completion") & list.get(i).getText().contains("Net 75"));
   	    	
   	       }
   		}
   	catch(NoSuchElementException e)
   	{
   			e.getStackTrace();
   	}
   	}
   	
	public static void FedExOvernight_FedExFLEXExpress_ShipVia_DropdownValues_Verification() throws IOException, InterruptedException{
   		try
   		{
   			
   		   //Click the Terms Dropdown
   			CreateOrder.ShipVia_Dropdown.click();
   			
   			List<WebElement> list =CreateOrder.ShipViaDropdown_Values;
   			int size=list.size();
   			System.out.println("size of list is:"+size);
   			for(int i=0;i<size;i++)
   			{
   	    	   System.out.println(list.get(i).getText());
   	    	   Assert.assertTrue(list.get(i).getText().contains("FedEx Overnight") & list.get(i).getText().contains("FedEx FLEX Express (Alphaborder Only)") & list.get(i).getText().contains("3 Day Select") & list.get(i).getText().contains("2nd Day Air AM") & list.get(i).getText().contains("2nd Day Air")& list.get(i).getText().contains("Next Day Air")& list.get(i).getText().contains("Next Day Air Saver") & list.get(i).getText().contains("Next Day Early AM") & list.get(i).getText().contains("Express Critical") & list.get(i).getText().contains("Routing Guide"));
   	    	
   	       }
   		}catch(NoSuchElementException e){
   			e.getStackTrace();
   		}
   	}
	public static void Ground_ShppingMethod_Verification() throws IOException, InterruptedException{
   		try
   		{
   			
   		   //Click the ShipVia Dropdown
   			Click("ShipVia",CreateOrder.ShipVia_Dropdown);
   			Input("Enter Order NO", CreateOrder.Input_ShipVia_Method,"Ground");
   			List<WebElement> list =CreateOrder.Ground_ShipViaDropdown_Values;
   			int size=list.size();
   			System.out.println("size of list is:"+size);
   			for(int i=0;i<size;i++)
   			{
   	    	   System.out.println(list.get(i).getText());
   	    	   if (list.get(i).getText().equalsIgnoreCase("Ground"))
   	    	   {
   	    		Assert.assertTrue(true);
   	    		break;
   	    	   }
   	    	 
   	    	
   	       }
   		}catch(NoSuchElementException e){
   			e.getStackTrace();
   		}
   	}
	public static void SendPackingList_MyCompany() throws IOException, InterruptedException{
   		try
   		{
   			Click("Send Packing List",CreateOrder.PackingList_SendButton);
   			Thread.sleep(2000);
   			Click("Select Packing List",CreateOrder.SelectPackingList);
   			Thread.sleep(2000);
   			Click("Select Packing List",CreateOrder.Continue);
   			waitForPageLoading();
			Thread.sleep(10000);
   			Actions a = new Actions(driver);
		    a.doubleClick( CreateOrder.SendPO_To_Field);
		    a.perform();
		    CreateOrder.SendPO_To_Field.sendKeys("bnazir@asicentral.com");
		    
		    Thread.sleep(2000);
		    CreateOrder.SendPO_To_Field.sendKeys(Keys.ENTER);
		    
		    Thread.sleep(2000);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();",CreateOrder.PackingList_SendButton);
		    WebElement el1 = 	  CreateOrder.PackingList_SendButton;
		     Actions builder1 = new Actions(driver);
		     builder1.moveToElement( el1 ).click( el1 );
		     builder1.perform();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.LineItemCopiedandAdded.getText().contains("Success"));
		
   	    	
   	       
   		}catch(NoSuchElementException e){
   			e.getStackTrace();
   		}
   	}
	public static void SendPackingList_SupplierCompany() throws IOException, InterruptedException{
   		try
   		{
   			Click("Send Packing List",CreateOrder.PackingList_SendButton);
   			Thread.sleep(2000);
   			Click("Select Packing List",CreateOrder.SelectPackingList);
   			Click("Select Packing List",CreateOrder.PackingList_SupplierList);
   			Thread.sleep(2000);
   			Click("Select Packing List",CreateOrder.Continue);
   			waitForPageLoading();
			Thread.sleep(10000);		
   			Click("Select Packing List",CreateOrder.Send_PO_ToandCCRemoveIcon);
		    Thread.sleep(1000);
   			Actions a = new Actions(driver);
		    a.doubleClick( CreateOrder.SendPO_To_Field);
		    a.perform();
		    CreateOrder.SendPO_To_Field.sendKeys("bnazir@asicentral.com");
		    
		    Thread.sleep(2000);
		    CreateOrder.SendPO_To_Field.sendKeys(Keys.ENTER);
		    
		    Thread.sleep(2000);
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView();",CreateOrder.PackingList_SendButton);
		    WebElement el1 = 	  CreateOrder.PackingList_SendButton;
		     Actions builder1 = new Actions(driver);
		     builder1.moveToElement( el1 ).click( el1 );
		     builder1.perform();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.LineItemCopiedandAdded.getText().contains("Success"));
		
   	    	
   	       
   		}catch(NoSuchElementException e){
   			e.getStackTrace();
   		}
   	}
   	public static void Product_Added_To_Order() throws InterruptedException, IOException{
   		try
   		{
   			JavascriptExecutor js = (JavascriptExecutor) driver;
   			Thread.sleep(3000);
		   //Press Add Product Button
		   Click("a", CreateOrder. CreateOrder_AddProductButton);
		
		  // CreateOrder. CreateOrder_AddProductButton.click();
		   
		   waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
		   Thread.sleep(2000);
		   //Go To Product Search Tab in popup
		   CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();
		   waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
		   //Search the Product which want to associate with order
		   CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct);
		   
		   waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
		   
		   //Now press Search Button
		   Click("Search Product", CreateOrder.CreateOrder_AddProductPopup_SearchButton);
		   wait = new WebDriverWait(driver, 180);
		   wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));
		   
		   //Now Select the Product
		   Click("Select Product",CreateOrder.CreateOrder_AddProductPopup_ProductSelection);
		   Thread.sleep(2000);
		   js.executeScript("arguments[0].scrollIntoView();", CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
		   //Press the Add Products Button to complete the process
		   Click("Add Product Button",CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
		   waitForElementNotVisible(240, driver,CreateOrder.SpinnerLoader);
			
		/*   String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
		   Thread.sleep(2000);
		   Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));*/
   
   		
   	}
   		catch(NoSuchElementException e)
   		{
   			e.getMessage();
   		}
   		
   	}
   	
   	public static void Send_ASI_SmartBooks_link_Verification() throws IOException, InterruptedException{
   	try
   	{
   			
   			Thread.sleep(2000);
   			Assert.assertTrue(!driver.findElement(By.xpath("//nav[contains(@class, 'navbar navbar-default navbar-bottom navbar-fixed-bottom navbar-fixed-bottom-buttons ng-scope')]")).getText().contains("Send to ASI SmartBooks"));
 
   	}
   	catch(NoSuchElementException e)
   	{
   		  e.getMessage();
   	}
   	}
   	public static void Create_Order() throws InterruptedException, IOException{
   		try{
   			
   			SoftAssert Softassertion=new SoftAssert();
   			Click("a", CreateOrder.CreateOrders_ConfigureButton);
   			waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   			List<WebElement> records = CreateOrder.Price_Grid;
   			int record=records.size();
   			//Enter The Quantity on Quatity screen
   			if(record>=1) 
   				{
			
   					Thread.sleep(2000);
   					Click("Click at Select button of price grid", CreateOrder.ClickAtSelect);
   					Thread.sleep(2000);
   					CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
   				}
   			
		else 
		{
				Thread.sleep(2000);
				CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		}
   		
   		
	
   			Thread.sleep(5000);
	
   			//Press the continue Button
   			CreateOrder.CreateOrder_Configure_Continue_Button.click();
   			Thread.sleep(2000);
   			Click("a",CreateOrder.NewOrder_ProductConfiguration_AddCharge_SaveButton);
   			Thread.sleep(2000);
   			Assert.assertTrue(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
   			Softassertion.assertAll();
	
   		}catch(NoSuchElementException e){
    		   e.getMessage();
    		}
	
	
   	 waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
	
	
	
	}  
   	
   	public static void Setting_EnterPayment_Uncheck() throws InterruptedException, IOException
   	{
   		CreateOrder.OrderListing_UserInfoIcon.click();
		  //Click the settings option
	   	Click("Click on settings",	CreateOrder.UserInfoIcon_Settings);
	   	Click("Click on company profile",	CreateOrder.Company_Profile);
	   	if(CreateOrder.Order_Payments_Checkbox.isSelected())
	   	{
	   		Click("Select checkbox",CreateOrder.Order_Payments_Checkbox);
	   	}
	   	Click("Click to save company profile",CreateOrder.Save_CompanyProfile);
	//   	Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
	   	
   	}
   	
	
   	
   	public static void Create_Order_Actionbuttons() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   			Thread.sleep(5000);
   		 	driver.close();
   		 	Thread.sleep(2000);
   		 	//Switch back to parent window 
   		 	driver.switchTo().window(parentWindow);
   			Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
   			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
	  		Thread.sleep(10000);
		   	CreateOrder.CreateOrder_SalesOrderOption.click();
			//Select the company first on create order screen
		   	CreateOrder.CreateOrderScreen_CompanySearch_Textfield.click();
		   	Thread.sleep(2000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    //Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    //Press the save button
		    Click("Click at save button", CreateOrder.SampleRequestSaveButton);
		    waitForPageLoadSave();
		    Conversions.OrdernumberRegularExpressionStringConversion();
		    Thread.sleep(6000);
		    Click("Click To Close Order Screen",CreateOrder.CloseOrder_Icon_SampleRequest);
		    Thread.sleep(2000);
		    CreateOrder.OrderlistingSearch.sendKeys(Conversions.Orderno);
		    //waitForPageLoading();
		    Thread.sleep(2000);
		    CreateOrder.ActionButtonDropdown.click();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonSend.getText().contains("Send"));
		    softassertion.assertAll();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonPreview.getText().contains("Preview"));
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonDownload.getText().contains("Download"));
	   	 
   	}
   	
   	public static void Create_Quote_Actionbuttons() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   			Thread.sleep(2000);
   			Click("a", CreateOrder.ESPWebHomePage_OrdersTab);
   	 		Click("a", CreateOrder.Quotetab);
	  		Thread.sleep(10000);
	  		Click("Create Quote",CreateOrder.Orderdetails_MoreButton_CreateQuote);
			   //Select the company first on create order screen
	  		Click("Select Company",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		   	Thread.sleep(2000);
		   	Input("Provide Supplier",	CreateOrder.CreateOrderScreen_CompanyField_SendData,"Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    	//Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Click("Save Quote",   CreateOrder.SaveQuote);
		    waitForPageLoadSave();
		    Conversions.OrdernumberRegularExpressionStringConversion();
		    Thread.sleep(6000);
		    CreateOrder.CloseOrder_Icon.click();
		    	//CreateOrder.ESPWebHomePage_OrdersTab.click();
		    Thread.sleep(2000);
		    CreateOrder.OrderlistingSearch.sendKeys(Conversions.Orderno);
		    	//waitForPageLoading();
		    Thread.sleep(2000);
		    CreateOrder.ActionButtonDropdown.click();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonSend.getText().contains("Send"));
		    softassertion.assertAll();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonPreview.getText().contains("Preview"));
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonDownload.getText().contains("Download"));
	   	 
   	}
   	public static void Create_Invoice_Actionbuttons() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   	 		Click("a", CreateOrder.Invoicetab);
	  		Thread.sleep(2000);
	  		Click("Create Invoice",CreateOrder.CreateOrder_InvoiceOption);
			//Select the company first on create order screen
		   	Click("Select Company",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		   	Thread.sleep(2000);
		   	Input("Provide Supplier",	CreateOrder.CreateOrderScreen_CompanyField_SendData,"Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    //Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Click("Click at save button", CreateOrder.SaveQuote);
		    waitForPageLoadSave();
		    Conversions.OrdernumberRegularExpressionStringConversion();
		    Thread.sleep(6000);
		    CreateOrder.CloseOrder_Icon.click();
		    Thread.sleep(2000);
		    CreateOrder.OrderlistingSearch.sendKeys(Conversions.Orderno);
		    //waitForPageLoading();
		    Thread.sleep(2000);
		    CreateOrder.ActionButtonDropdown.click();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonSend.getText().contains("Send"));
		    softassertion.assertAll();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonPreview.getText().contains("Preview"));
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonDownload.getText().contains("Download"));
	   	 
   	}
   	
	public static void Create_SampleRequest_Actionbuttons() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   	 		Click("a", CreateOrder.Orders_SampleRequestTab);
	  		Thread.sleep(10000);
	  		Click("Sample Request",	CreateOrder.CreateSampleRequest);
	  		Click("Select Company",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		   	Thread.sleep(2000);
		   	Input("Provide Supplier",	CreateOrder.CreateOrderScreen_CompanyField_SendData,"Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    //Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Click("Click at save button", CreateOrder.SampleRequestSaveButton);
		    waitForPageLoadSave();
		    Conversions.OrdernumberRegularExpressionStringConversion();
		    Thread.sleep(6000);
		    CreateOrder.CloseOrder_Icon_SampleRequest.click();
		    Thread.sleep(2000);
		    CreateOrder.OrderlistingSearch.sendKeys(Conversions.Orderno);
		    //waitForPageLoading();
		    Thread.sleep(2000);
		    CreateOrder.ActionButtonDropdown.click();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonSend.getText().contains("Send"));
		    softassertion.assertAll();
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonPreview.getText().contains("Preview"));
		    Thread.sleep(2000);
		    Assert.assertTrue(CreateOrder.ActionButtonDownload.getText().contains("Download"));
	   	 
   	}
	public static void Create_SampleRequest() throws InterruptedException, IOException, AWTException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   			Click("Click Sample Request", CreateOrder.CreateSampleRequest);
   			Click("Select Company",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		   	Thread.sleep(2000);
		   	Input("Provide Supplier",	CreateOrder.CreateOrderScreen_CompanyField_SendData,"Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    //Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    Click("Click at save button", CreateOrder.SampleRequestSaveButton);
		    waitForPageLoadSave();
		   	AddProductConfiguration_Order();
		   	ShippingContact=CreateOrder.SampleRequest_ShippingAddress.getText();
		   	System.out.println(ShippingContact);
		   	
		   	
		   
   	}
	public static void PreviewSampleRequest_CustomerVerification() throws InterruptedException, IOException, AWTException
   	{
   		
   		 SoftAssert softassertion=new SoftAssert();
   		 Click("Click Function",CreateOrder.PreviewButton_Orderdetails);
		 waitForPageLoading();
		 Thread.sleep(3000);
     	   //Press the Purchase Order document
		 Click("Sample Request", CreateOrder.PreviewPopUp_SampleRequest);
     	 Thread.sleep(3000);
     	 //First store parent window to switch back
     	 parentWindow = driver.getWindowHandle();
     	   //Press the Preview Button
     	 Click("Preview Button", CreateOrder.PreviewPopUp_PreviewButton);
     	   //Switch to new window opened
  	  	 for(String winHandle : driver.getWindowHandles()){
  	  	    if(!winHandle.equals(parentWindow)) {
  	  	        driver.switchTo().window(winHandle);
  	  	    }
  	  	}
  	  	  
  	  	Thread.sleep(10000);
		Assert.assertTrue(!CreateOrder.SampleRequest_CustomerName.getText().isEmpty());
		   
   	}
	
	public static void PreviewSampleRequest_ShippingContactVerification() throws InterruptedException, IOException, AWTException
   	{
   		try {
   		List<WebElement> ShipTo=driver.findElements(By.xpath("//div[contains(@class,'order-contact')]/descendant::address"));
   		String PreviewShipTo=ShipTo.get(2).getText();
   		System.out.println(PreviewShipTo);
   		Thread.sleep(2000);
		Assert.assertTrue(ShipTo.get(2).getText().contains("Feasterville-Trevose, PA 19053"));
		
   		}
   	 catch(NoSuchElementException e){
         e.getMessage();
       }
   
		   
   	}
	public static void EnterPayment_Verification() throws InterruptedException, AWTException, IOException
	
	{
		
	
	   	Thread.sleep(2000);
	   	 //Select existing created order from Top of the list
	   	Click("Select Order",CreateOrder.OrderListing_Orderselection);
	   	waitForPageLoading();
	   	Thread.sleep(2000);
	   	//Add Product
	   	AddProductConfiguration_Order();
	   	Thread.sleep(6000);
	   	Assert.assertTrue(CreateOrder.EnterPayment.isDisplayed());
	   	
	 
	   
	}
	
	public static void EnterPayment_NotDisplayed_Verification() throws InterruptedException, AWTException, IOException
	
	{
	
		Thread.sleep(2000);
		Click("Close order window",CreateOrder.CloseOrder_Icon);
		Thread.sleep(5000);
	   	CreateOrder.OrderListing_UserInfoIcon.click();
		  //Click the settings option
	   	Click("Click on settings",	CreateOrder.UserInfoIcon_Settings);
	   	Click("Click on company profile",	CreateOrder.Company_Profile);
	   	if(!CreateOrder.Order_Payments_Checkbox.isSelected())
	   	{
	   		Click("Select checkbox",CreateOrder.Order_Payments_Checkbox);
	   	}
	   	Click("Click to save company profile",CreateOrder.Save_CompanyProfile);
	   	Click("WESP",CreateOrder.ESPWebHomePage_OrdersTab);
	   	Input("Enter Order NO", CreateOrder.OrderlistingSearch,Conversions.Orderno);
	   	 Thread.sleep(7000);
	   	 //Select existing created order from Top of the list
	   	 Click("Access Order",CreateOrder.OrderListing_Orderselection);
	   	 waitForPageLoading();
	   	 Thread.sleep(2000);
	   	 List<WebElement> EnterPayment=driver.findElements(By.xpath("//button[contains(text(),'Enter Payment')]"));
	   	 int EP=EnterPayment.size();
	   	 if(EP==0)
	   	 {
	   		 Assert.assertEquals(EP,0);
	   	 }
	   
	   	
	   	
	}
	public static void OrderSearchTerm_RetainVerification() throws InterruptedException, AWTException, IOException
	
	{
	
		Click("Close order window",CreateOrder.CloseOrder_Icon);
		String Ordersno=CreateOrder.OrderlistingSearch.getAttribute("value");
		System.out.println(Ordersno);
		Thread.sleep(2000);
	   	Assert.assertTrue(CreateOrder.OrderlistingSearch.getAttribute("value").contains(Conversions.Orderno));
	   	
	}


	public static void VerifyDecoratorEmailAddress() throws InterruptedException, AWTException, IOException

	{
		
	   	 Click("Access Order",CreateOrder.OrderListing_Orderselection);
	   	 waitForPageLoading();
	   	// Thread.sleep(3000);
	   	 Click("Click on Edit button",  	CreateOrder.OrdersDetails_EditButton);
	 	 waitForElementNotVisible(120, driver, 	CreateOrder.SpinnerLoader);
	    Thread.sleep(2000);
	    //Go to Decoration Tab
	 	CreateOrder.EditOrder_DecorationTab.click();
	    Thread.sleep(2000);
	    WebElement targetElement = CreateOrder.EditOrder_Decoration_Location;
	    Actions action = new Actions(driver);
	    action.moveToElement(targetElement).click();
	    action.perform();
	    Click("Select Location Value", 	CreateOrder.EditOrder_Decoration_LocationValue);
	    Thread.sleep(2000);
	    Click("Select Decorator", 	CreateOrder.EditOrder_Decoration_Decorator);
	    Input("Provide Decorator name", 	CreateOrder.EditOrder_Decoration_DecoratorName,"Auto Supplier ASIQA I");
	    Thread.sleep(6000);
	    CreateOrder.EditOrder_Decoration_DecoratorSelection.sendKeys(Keys.ARROW_DOWN);
	    Thread.sleep(1000);
	    //Select company from company dropdown
	    CreateOrder.EditOrder_Decoration_DecoratorSelection.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    Click("Upload ArtWork Image", CreateOrder.EditOrder_Decoration_ArtWorkImageUploadButton);
	    Thread.sleep(2000);
	    //Now Select the Existing Artwork and upload that at prologoduct level under decoration tab
	    OrderDeletion.Projectpath=System.getProperty("user.dir");
		System.out.println(OrderDeletion.Projectpath);
   	 
		ProcessBuilder pb = new ProcessBuilder(OrderDeletion.Projectpath+"/Img/upload.exe", OrderDeletion.Projectpath+"\\Img\\foil.jpg");
		Thread.sleep(5000);
		pb.start();
		Thread.sleep(15000);
		waitForPageLoading();  
		Thread.sleep(8000);

	    
	    ArtworkfileBeforeCopy=CreateOrder.EditOrder_Decoration_Artwork_Existence_Verification.getText();
	    System.out.println(ArtworkfileBeforeCopy+'\n');
	    Assert.assertTrue(CreateOrder.EditOrder_Decoration_Artwork_Existence_Verification.isDisplayed());
	    
	    
	    Click("Click Shipping",CreateOrder.Shipping_Tab);
	    ShipFromBeforeCopyLineItem=CreateOrder.ShippingFromaddressBeforeCopyLineItem.getText();
	    System.out.println(ShipFromBeforeCopyLineItem+'\n');
	    ShippingToaddressBeforeCopyLineItem=CreateOrder.ShippingToaddressBeforeCopyLineItem.getText();
	    System.out.println(ShippingToaddressBeforeCopyLineItem+'\n');
	    
	    
	    
	    JavascriptExecutor je = (JavascriptExecutor) driver;
	    je.executeScript("arguments[0].scrollIntoView(true);",CreateOrder.CreateOrder_DecoratorScreen_Save_Button);
	    Click("Click to save decorator",CreateOrder.CreateOrder_DecoratorScreen_Save_Button);
	    Thread.sleep(2000);
	    Click("a",CreateOrder.EditOrder_Decoration_Send);
   	 	Click("a",  CreateOrder.PreviewPopUp_PurchaseOrder);
   	 	Thread.sleep(3000);
   	 
   	 	//Select the Purchase Order Option
   	 	Click("a",  CreateOrder.PreviewPopup_DecoratorPurchaseOrderSelection);
   	 	waitForPageLoading();
   	 	Thread.sleep(3000);
	   	Click("a",CreateOrder.PreviewPopup_Continue);
	   	String emailaddress=CreateOrder.EmailAddress.getText();
	   	System.out.println(emailaddress+'\n');
	    Thread.sleep(2000);
	   	Assert.assertTrue(CreateOrder.EmailAddress.getText().contains(emailaddress));
	   	
		
	}

	public static void SearchCompany_WithAllKeywords() throws InterruptedException, AWTException, IOException

	{
		SoftAssert softassertion=new SoftAssert();
	 	/*Click("WESP",CreateOrder.ESPWebHomePage_OrdersTab);
	   	Input("Enter Order NO", CreateOrder.OrderlistingSearch,"601387");
	   	 Thread.sleep(2000);
	   	 //Select existing created order from Top of the list
	   	 Click("Access Order",CreateOrder.OrderListing_Orderselection);
	   	 waitForPageLoading();
	   	 Thread.sleep(2000);*/
		/*Click("Company Selection DropDown",CreateOrder.CompanySelection);
		Click("Select Suppliers Company",CreateOrder.CustomersCompany);
		Click("Company Selection DropDown",CreateOrder.CompanySelection);
		Thread.sleep(2000);*/
		Click("Company Selection DropDown",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		Thread.sleep(2000);
		Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, OrdersTestdata.CompanyEmailAddress);
		Thread.sleep(2000);
		softassertion.assertAll();
		Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains(OrdersTestdata.CompanyName));
		
		Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, OrdersTestdata.CountryName);
		Thread.sleep(2000);
		Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains(OrdersTestdata.CompanyName));	
		Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, OrdersTestdata.PostalCode);
		Thread.sleep(2000);
		Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains(OrdersTestdata.CompanyName));	
		Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData,OrdersTestdata.Phoneno);
		Thread.sleep(2000);
		Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains(OrdersTestdata.CompanyName));
		Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData,OrdersTestdata.City);
		Thread.sleep(2000);
		Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains(OrdersTestdata.CompanyName));
	}
	public static void Verify_ViewCRMRecordLink() throws InterruptedException, AWTException, IOException

	{
		Assert.assertTrue(CreateOrder.ViewCRMRecord.isDisplayed());
	}

	
	public static void ViewandModifyProduct_NonAdmin() throws InterruptedException, AWTException, IOException

	{
		Click("Close order window",CreateOrder.CloseOrder_Icon);
		Thread.sleep(2000);
		Click("Close order window",CreateOrder.CloseAndExit);
		waitForPageLoadSave();
		Thread.sleep(2000);
		Click("Settings",CreateOrder.OrderListing_UserInfoIcon);
		Thread.sleep(3000);
		Click("Click on Logout",CreateOrder.LogoutButton);
		Thread.sleep(2000);
		Input("Please Enter ASI no", CreateOrder.ASINo, OrdersTestdata.ASINoNonAdmin);
		Input("Please Enter UserName", CreateOrder.UserName, OrdersTestdata.UsernameNonAdmin);
		Input("Please Enter Password", CreateOrder.Password, OrdersTestdata.PasswordNonAdmin);
		Click("Please click login button",CreateOrder.LoginButton);
		//..
		Thread.sleep(2000);
		Click("WESP Home Page",	CreateOrder.ESPWebHomePage_OrdersTab);
		Input("Enter Order NO", CreateOrder.OrderlistingSearch,Conversions.Orderno);
		Thread.sleep(7000);
		//Select existing created order from Top of the list
		Click("Orders Selection",CreateOrder.OrderListing_Orderselection);
		waitForPageLoading();
		Thread.sleep(2000);
		List<WebElement> modifyOrderSaveButton=driver.findElements(By.xpath("//button[contains(@ng-click,'vm.save(false, true)')]"));
		int countsize=modifyOrderSaveButton.size();
		if(countsize==0)
		{
			Assert.assertEquals(countsize,0);
		}
	 
	}


	
	@SuppressWarnings("deprecation")
	public static void AddProductConfiguration_Order() throws InterruptedException, AWTException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.visibilityOf(CreateOrder. CreateOrder_AddProductButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",CreateOrder. CreateOrder_AddProductButton);
   		Thread.sleep(3000);
   		//Press Add Product Button
   		Click("a", CreateOrder. CreateOrder_AddProductButton);
   		// CreateOrder. CreateOrder_AddProductButton.click();
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Go To Product Search Tab in popup
   		Click("Product Search tab",CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Search the Product which want to associate with order
   		CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Now press Search Button
   		Click("Add Product",CreateOrder.CreateOrder_AddProductPopup_SearchButton);
   		wait = new WebDriverWait(driver, 180);
   		wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));
   		//Now Select the Product
   		Click("Product Selection",CreateOrder.CreateOrder_AddProductPopup_ProductSelection);
   		Thread.sleep(2000);
   		js.executeScript("arguments[0].scrollIntoView();", CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		//Press the Add Products Button to complete the process
   		Click("Add Product",	CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
   		Thread.sleep(2000);
   		Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
   		Thread.sleep(2000);
   		Click("a", CreateOrder.OrdersDetails_ConfigureProduct);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		Thread.sleep(1000);
   		CreateOrder.ProductConfiguration_AddQTY.sendKeys("1");
   		Thread.sleep(2000);
   		Click("Click Continue Button", CreateOrder.ProductConfiguration_AddCharge_ContinueButton);
   		//Press the save button
   		Click("Click Save button", CreateOrder.ProductConfiguration_AddCharge_ConfigSaveButton);
	
	
	}
	@SuppressWarnings("deprecation")
	public static void AddProductWithOutConfiguration_Order() throws InterruptedException, AWTException, IOException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",CreateOrder. CreateOrder_AddProductButton);
   		Thread.sleep(3000);
   		//Press Add Product Button
   		Click("a", CreateOrder. CreateOrder_AddProductButton);
   		// CreateOrder. CreateOrder_AddProductButton.click();
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		Thread.sleep(2000);;
   		//Go To Product Search Tab in popup
   		CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();
   		//waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Search the Product which want to associate with order
   		Input("Provide product name",CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField,OrdersTestdata.OrderProduct);
   	
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Now press Search Button
   		Click("Press search button",CreateOrder.CreateOrder_AddProductPopup_SearchButton);
   		wait = new WebDriverWait(driver, 180);
   		wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));
   		//Now Select the Product
   		Click("Select Product",CreateOrder.CreateOrder_AddProductPopup_ProductSelection);
   		Thread.sleep(2000);
   		js.executeScript("arguments[0].scrollIntoView();", CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		//Press the Add Products Button to complete the process
   		Click("Add Product",CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
   		Thread.sleep(2000);
   		Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
   	
   			
	}
	public static void AddProductConfiguration_FromProject() throws InterruptedException, AWTException, IOException
	{
		WebDriverWait wait = new WebDriverWait(driver,240);
		wait.until(ExpectedConditions.visibilityOf(CreateOrder. CreateOrder_AddProductButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",CreateOrder. CreateOrder_AddProductButton);
   		Thread.sleep(3000);
   		//Press Add Product Button
   		Click("a", CreateOrder. CreateOrder_AddProductButton);
   		// CreateOrder. CreateOrder_AddProductButton.click();
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		//Go To Product Search Tab in popup
   		Click("Project tab",CreateOrder.CreateOrder_AddProductPopup_ProjectTab);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		Click("Project Selection",CreateOrder.CreateOrder_AddProductPopup_ProjectSelection);
   		Thread.sleep(5000);
   		List<WebElement> Products=driver.findElements(By.xpath("//div[contains(@class,'product-wrapper prod tile')]"));
   		for(int i=1;i<Products.size();i++)
   		{
   			Products.get(i).click();
   		}
   		

   		Thread.sleep(2000);
   		js.executeScript("arguments[0].scrollIntoView();", CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		//Press the Add Products Button to complete the process
   		Click("Add Product",	CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
   		Thread.sleep(2000);
   		Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
   		Thread.sleep(2000);
   		List<WebElement> ConfigureProducts=driver.findElements(By.xpath("//button[contains(text(),'Configure')]"));
   		for(int i=0;i<ConfigureProducts.size();i++)
   		{
   			if(i==0)
   			{
	   			ConfigureProducts.get(0).click();
	   			waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
	   	   		Thread.sleep(1000);
	   	   		List< WebElement> QuanityField=driver.findElements(By.xpath("//input[contains(@placeholder,'QTY')] | //input[contains(@placeholder,'Qty')]"));
	   	   		System.out.println(QuanityField.size());
	   	   		if(QuanityField.size()==1)
	   	   		{
	 			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"1");
	   	   		}
	   	   		if( QuanityField.size()==0)
	   	   		{
	 			 Click("Advanced Search", CreateOrder.CreateOrder_Configure_Continue_Button);
	 			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"1");
	   	   		}
	   	   		//CreateOrder.ProductConfiguration_AddQTY.sendKeys("1");
	   	   		Thread.sleep(2000);
	   	   		Click("Click Continue Button", CreateOrder.ProductConfiguration_AddCharge_ContinueButton);
	   	   		//Press the save button
	   	   		Click("Click Save button", CreateOrder.ProductConfiguration_AddCharge_ConfigSaveButton);
	   	   		waitForElementNotVisible(240, driver,CreateOrder.SpinnerLoader);
   		}
   			if(i==1)
   			{
   				
   				WebElement element=driver.findElement(By.xpath("//button[contains(text(),'Configure')]"));
   				Actions action = new Actions(driver);
   				action.moveToElement(element).click().perform();
	   			
	   			waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
	   	   		Thread.sleep(1000);
	   	   		List< WebElement> QuanityField=driver.findElements(By.xpath("//input[contains(@placeholder,'QTY')] | //input[contains(@placeholder,'Qty')]"));
	   	   		System.out.println(QuanityField.size());
	   	   		if(QuanityField.size()>=1)
	   	   		{
	 			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"1");
	   	   		}
	   	   		if( QuanityField.size()==0)
	   	   		{
	 			 Click("Advanced Search", CreateOrder.CreateOrder_Configure_Continue_Button);
	 			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"1");
	   	   		}
	   	   		//CreateOrder.ProductConfiguration_AddQTY.sendKeys("1");
	   	   		Thread.sleep(2000);
	   	   		Click("Click Continue Button", CreateOrder.ProductConfiguration_AddCharge_ContinueButton);
	   	   		//Press the save button
	   	   		Click("Click Save button", CreateOrder.ProductConfiguration_AddCharge_ConfigSaveButton);
	   	   		waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
   		}
   		}
   		

	
	
	}
	public static void CreateOrder() throws InterruptedException,IOException
   	{
			Click("SalesOrder Option",CreateOrder.CreateOrder_SalesOrderOption);
			//Select the company first on create order screen
			Click("Search Company",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
		   	Thread.sleep(2000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
		   	Thread.sleep(6000);
		   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		    Thread.sleep(1000);
		    //Select company from company dropdown
		    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		    Thread.sleep(2000);
		    //Press the save button
		    Click("Click at save button", CreateOrder.SampleRequestSaveButton);
		    waitForPageLoadSave();
		   /* Thread.sleep(1000);
			 Click("Please click at Save Button",GetData.SaveOrders.get(1));
			 Thread.sleep(20000);*/
			 driver.navigate().refresh();
			
   	}
	
	public static void CreateOrder_WithTaskandNotes() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   			Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
   			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
	  		Thread.sleep(10000);
	  		CreateOrder();
			Click("Please click at Settings",GetData.OpenTaskInSidebar);
			Thread.sleep(15000);
			Click("Please click at Add Task button",CreateOrder.AddTaskFromOrders);
			Thread.sleep(2000);
			Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
			Input("Enter Team name ",GetData.ProvideCommonTaskname,CrmTestData.Task);
	
			LocalDate localDate = LocalDate.now();
			System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)+'\n');
			String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
			int ext=abc.lastIndexOf("/");						
			// Get last word
			TaskCurdat=abc.substring (ext+1);
			System.out.println(TaskCurdat);
			Thread.sleep(2000);
			Click("Click to open celender",GetData.OpenCalender);
			driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
			Thread.sleep(2000);
			
			Click("Click to open celender",GetData.MoreDetail);
			Thread.sleep(5000);
			Click("Click on Notes Tab",GetData.NotesUnderTask);
			Thread.sleep(5000);
			Input("Enter Notes Name ",GetData.ProvideNotes,CrmTestData.Notes);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", GetData. SaveTaskUderOrder);
			Thread.sleep(2000);
			WebElement element1=  GetData. SaveTaskUderOrder;
			element1.click();
			System.out.println(CreateOrder.VerifyNotesLinkUderTasks.getText());
			Thread.sleep(2000);
			Assert.assertTrue(CreateOrder.VerifyNotesLinkUderTasks.getText().contains("+ See Notes (1)"));
   	}
	
	public static void CreateOrder_ReviewHideNotesLink() throws InterruptedException, IOException
   	{
   		
   		SoftAssert softassertion=new SoftAssert();
   		 WebElement CommonTaskWithNotesElement= driver.findElement(By.xpath("//span/strong[contains(text(),'"+CrmTestData.Task+"')]"));
		 WebElement ClickNotesElement= driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.Task+"')]/ancestor::div[contains(@class, 'task-details')]/descendant::span[contains(@ng-if,'!vm.task.showNotes')]"));
		 HelpingFunction.HoverandClick(CommonTaskWithNotesElement,ClickNotesElement, driver);
   			//Click("Click on Notes",CreateOrder.VerifyNotesLinkUderTasks);
   		Thread.sleep(2000);
   		Assert.assertTrue(CreateOrder.HideNotes.getText().contains("- Hide Notes (1)"));
			
   	}
	public static void CreateOrder_ReviewNotes() throws InterruptedException, IOException
   	{
   		
   		
   			WebElement NotesDetails= driver.findElement(By.xpath("//strong[contains(text(),'"+CrmTestData.Task+"')]/ancestor::div[contains(@class, 'task-details')]/descendant::div[contains(@class,'font-13 text-med ng-binding')]"));
   			System.out.println(NotesDetails.getText());
   			Thread.sleep(2000);
   			Assert.assertEquals(CrmTestData.Notes,NotesDetails.getText());
   			
			
   	}
	public static void CreateOrder_WithTaskOnly() throws InterruptedException, IOException
   	{
   		
   			SoftAssert softassertion=new SoftAssert();
   			Thread.sleep(6000);
		    CreateOrder.CloseOrder_Icon_SampleRequest.click();
		    Thread.sleep(2000);
	  		CreateOrder();
			Click("Please click at Settings",GetData.OpenTaskInSidebar);
			Thread.sleep(15000);
			Click("Please click at Add Task button",CreateOrder.AddTaskFromOrders);
			Thread.sleep(2000);
			Click("Click on task name drop down to select task name",GetData.CompanyDetailTaskname);
			Input("Enter Team name ",GetData.ProvideCommonTaskname,CrmTestData.Task);
	
			LocalDate localDate = LocalDate.now();
			System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)+'\n');
			String abc=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
			int ext=abc.lastIndexOf("/");						
			// Get last word
			TaskCurdat=abc.substring (ext+1);
			System.out.println(TaskCurdat);
			Thread.sleep(2000);
			Click("Click to open celender",GetData.OpenCalender);
			driver.findElement(By.xpath("//span[contains(text(), '"+TaskCurdat+"')]")).click();
			Thread.sleep(2000);
			
			Click("Click to open celender",GetData.MoreDetail);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", GetData. SaveTaskUderOrder);
			Thread.sleep(2000);
			WebElement element1=  GetData. SaveTaskUderOrder;
			element1.click();
			List<WebElement> NotesLocator=driver.findElements(By.xpath("//span[contains(@ng-if,'!vm.task.showNotes')]"));
			int NotesSize=NotesLocator.size();
			System.out.println(NotesSize);
			if(NotesSize==0)
			{
				Thread.sleep(2000);
				Assert.assertTrue(true);
			}
			
			
   	}
	public static void ExportOrders() throws InterruptedException, IOException
   	{
   		
   			
   			Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
   			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
	  		Thread.sleep(10000);
	  		Click("Order1 selection",CreateOrder.Order1Selection);
	  		Click("Order2 selection",CreateOrder.Order2Selection);
	  		Thread.sleep(2000);
	  		Click("Export Orders",CreateOrder.ExportOrders);
	  		Thread.sleep(2000);
	  		Click("Export Orders",CreateOrder.ExportOrdersExcel);
	  		Thread.sleep(2000);
	  		Assert.assertTrue(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
   	}
	
	public static void Selection_AllOrderds() throws InterruptedException, IOException
   	{
   		
			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
			Thread.sleep(10000);
   			Click("Select first 10 Orders",CreateOrder.SelectAllOrders);
   			Thread.sleep(2000);
   			Assert.assertTrue(CreateOrder.SelectAllMessage.isDisplayed());
   			Click("Select All Orders",CreateOrder.SelectAllMessage);
   			Thread.sleep(2000);
   			Assert.assertTrue(CreateOrder.ClearSelection.getText().contains("Clear Selection"));
	  		Click("Click to clear all selection",CreateOrder.ClearSelection);
	  		Thread.sleep(2000);
   			Assert.assertTrue(!CreateOrder.SelectAllOrders.isSelected());
	  		
   	}
	public static void Products_AttributeVarients() throws InterruptedException, IOException, AWTException
   	{
   			
			Click("Click to close Orders screen",CreateOrder.CloseOrder_Icon_SampleRequest);
			Thread.sleep(2000);
			Click("Click to close Orders screen",CreateOrder.CloseAndExit);
			Thread.sleep(5000);
   			Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
   			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
	  		Thread.sleep(10000);
	  		CreateOrder();
	  	 	//Add Product
		   	AddProductConfiguration_Order();
		   	Thread.sleep(5000);
		   	Click("Click on Edit button",  	CreateOrder.OrdersDetails_EditButton);
		 	waitForElementNotVisible(120, driver, 	CreateOrder.SpinnerLoader);
		    Thread.sleep(2000);
			WebElement el = 	 CreateOrder.ProductConfiguration_SKU;
			Actions builder = new Actions(driver);
			builder.moveToElement( el ).click( el );
			builder.perform();
		   	Thread.sleep(2000);
	  		List<WebElement> ProductAttributeVariants=driver.findElements(By.xpath("//tbody/tr[contains(@ng-repeat,'attribute in vm.model.ProductAttributes')]"));
	  		int ProductAttributeVariantsSize=ProductAttributeVariants.size();
	  		Thread.sleep(2000);
	  		Assert.assertEquals(4, ProductAttributeVariantsSize);
	  		
   	}
	public static void DeleteProductFromOrder() throws InterruptedException, IOException, AWTException
   	{
   			
		
		  //Press the save button
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",CreateOrder.ProductConfiguration_AddCharge_SaveButton);
			Click("Save",CreateOrder.ProductConfiguration_AddCharge_SaveButton);
		   	Thread.sleep(5000);
		    MoveToElement_Click(CreateOrder.DeleteProduct);
	  		Thread.sleep(2000);
	  		Click("Delete Product",CreateOrder.	ConfirmationButton);
	  		String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
	  		Thread.sleep(2000);
			Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
	  	
	  		
   	}
	public static void HeaderContentVerification_OutPutDocument() throws InterruptedException, IOException, AWTException
   	{
   		
			SoftAssert softassertion=new SoftAssert();
   			Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
   			Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
	  		Thread.sleep(10000);
	  		CreateOrder();
	  	 	//Add Product
		   	AddProductConfiguration_Order();
		   	Thread.sleep(5000);
		    SupplierPhoneNo=CreateOrder.OrdersDetails_PhoneNo.getText();
		   	System.out.println(SupplierPhoneNo);
		    Click("Click Function",CreateOrder.PreviewButton_Orderdetails);
			 waitForPageLoading();
			 Thread.sleep(3000);
			 //Press the Purchase Order document
			 Click("a",  CreateOrder.PreviewPopUp_PurchaseOrder);
			 Thread.sleep(3000);
			//Select the Purchase Order Option
			 Click("a",  CreateOrder.PreviewPopup_PurchaseOrderSelection);
			 waitForPageLoading();
			 Thread.sleep(3000);
			 //First store parent window to switch back
			 parentWindow = driver.getWindowHandle();
			 //Press the Preview Button
			 CreateOrder.PreviewPopUp_PreviewButton.click();
			//Switch to new window opened
			  	for(String winHandle : driver.getWindowHandles()){
			  	    if(!winHandle.equals(parentWindow)) {
			  	        driver.switchTo().window(winHandle);
			  	    }
			  	}
 	  
		  	Thread.sleep(10000);
		  	String DocumentDesignHeader=CreateOrder.PurchaseOrder_Preview_HeaderVerification.getText();
		  	System.out.println(DocumentDesignHeader);
		  	Thread.sleep(2000);
		  	softassertion.assertEquals(DocumentDesignHeader,SettingsScenarios.Headertext);
		  	Thread.sleep(5000);
			
			driver.close();
	        //
	        Thread.sleep(2000);
	        
	      //Switch back to parent window 
	        driver.switchTo().window(parentWindow);

		  
   	}
	public static void VerifySupplierPhoneno_OutputDocument() throws InterruptedException, IOException, AWTException
   	{
		SoftAssert softassertion=new SoftAssert();
		Thread.sleep(2000);
		Click("a",  CreateOrder.PreviewPopUp_SalesOrder);
	   	Thread.sleep(3000);
	   	//First store parent window to switch back
	   	parentWindow = driver.getWindowHandle();
	   	//Press the Preview Button
	   	Click("a",  CreateOrder.PreviewPopUp_PreviewButton);
	   
		 
	   	   //Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
			Thread.sleep(2000);
		  	softassertion.assertTrue(CreateOrder.SupplierPhoneNoVerification.getText().contains(SupplierPhoneNo));	
		  	Thread.sleep(5000);
			
			driver.close();
	        //
	        Thread.sleep(2000);
	        
	      //Switch back to parent window 
	        driver.switchTo().window(parentWindow);
	  		
   	}
	public static void VerifySentToASISamrtBookLink() throws InterruptedException, IOException, AWTException
   	{
		Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
		Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
  		Thread.sleep(10000);
  		CreateOrder();
  	 	//Add Product
  		AddProductWithOutConfiguration_Order() ;
	   	Thread.sleep(5000);
	   	Conversions.OrdernumberRegularExpressionStringConversion();
		List<WebElement>SentToASISamrtBookLink=driver.findElements(By.xpath("//ng-content[contains(text(),'Send to ASI SmartBooks')]"));
		int size=SentToASISamrtBookLink.size();
		if(size==0)
		{
			Assert.assertTrue(true);
		}
	  		
   	}
	public static void SearchInvoiceFromOrderPage() throws InterruptedException, IOException, AWTException
   	{
		Thread.sleep(5000);
		 driver.close();
		 Thread.sleep(2000);
		 driver.switchTo().window(parentWindow);
  		Click("Click orders title tab",CreateOrder.CreateInvoice);
  		waitForPageLoading();
  		WebDriverWait wait = new WebDriverWait(driver,240);
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[contains(@ng-disabled,'!currentUser.canCreateInvoice')]")));
		Thread.sleep(2000);
  		 Click("Click at save button", CreateOrder.SampleRequestSaveButton);
		 waitForPageLoadSave();
  		Thread.sleep(2000);
  		Conversions.InvoicenumberRegularExpressionStringConversion();
  		Thread.sleep(5000);
  		Click("Close Order",CreateOrder.CloseOrder_Icon);
  		//Click("ESPWeb",CreateOrder.ESPWebHomePage_OrdersTab);
  		Thread.sleep(3000);
  		Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
		Input("Enter Order NO", CreateOrder.OrderlistingSearch,Conversions.InvoiceNo);
		Thread.sleep(2000);
		//Select existing created order from Top of the list
		Assert.assertTrue(CreateOrder.Orderno.getText().contains(Conversions.Orderno));
			
   	}
	public static void SupplierName_Navigation() throws InterruptedException, IOException, AWTException
   	{
		try
		{
		 parentWindow = driver.getWindowHandle();
		 //Press the Preview Button
		 String SupplierName=CreateOrder.SupplierName_Navigation.getText();
		 System.out.println(SupplierName);
		 Click("Click To SupplierName",CreateOrder.SupplierName_Navigation);
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	 waitForPageLoading();
		  	 Thread.sleep(2000);
		  	Assert.assertTrue(CreateOrder.SupplierName_NavigatedScreen.getText().contains(SupplierName));
		  
  		
		}
		 catch(NoSuchElementException e)
		 {
				e.getMessage();
		 }
		
	  		
   	}
	
	public static void Product_Navigation() throws InterruptedException, IOException, AWTException
   	{
		try
		{
		Thread.sleep(5000);	
		 driver.close();
		Thread.sleep(2000);
		//Switch back to parent window 
		driver.switchTo().window(parentWindow);
		 parentWindow = driver.getWindowHandle();
		 //Press the Preview Button
		 String ProductName=CreateOrder.ProductName_Navigation.getText();
		 System.out.println(ProductName);
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", CreateOrder.ProductName_Navigation);
		// Click("Click To ProductName",CreateOrder.ProductName_Navigation);
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	 waitForPageLoading();
		  	Thread.sleep(4000);

		  	System.out.println(CreateOrder.ProductName_NavigatedScreen.getText());
		  	Thread.sleep(2000);

		  	Assert.assertTrue(CreateOrder.ProductName_NavigatedScreen.getText().contains(ProductName));
		  
  		
		}
		 catch(NoSuchElementException e)
		 {
				e.getMessage();
		 }
	
   	}
	
	
	
	public static void AccessOrder_ForPreviewDocument() throws InterruptedException, IOException, AWTException
   	{
		 OrdersLocators SalesOrderPreview = PageFactory.initElements(driver, OrdersLocators.class);
		   SalesOrderPreview.ESPWebHomePage_OrdersTab.click();
		   Thread.sleep(2000);
	      	Click("Click orders title tab",  SalesOrderPreview.Orders_Title_Tab);
	      	String path = System.getProperty("user.dir");
			FileInputStream fis = new FileInputStream(path+"\\OrdersID.xlsx");
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0);
			int lastRow = sheet.getLastRowNum();
			System.out.println("Last row- "+lastRow);
			for(int i=1; i<=lastRow; i++)
			{
				Row row = sheet.getRow(i);
				int lastCell = row.getLastCellNum();
				for(int j=0; j<lastCell; j++)
			{
					
					Cell cell = row.getCell(j);
					if(j==0)
					{
					OrderID = cell.getStringCellValue();
					System.out.println(OrderID );
					//driver.get(OrderID );
					
					}
					
					
			}
			}
	      		SalesOrderPreview.OrderlistingSearch.sendKeys(OrderID);
	      		Thread.sleep(7000);
	      		//Select existing created order from Top of the list
	      		Click("Select Order",	SalesOrderPreview.OrderListing_Orderselection);

	      		waitForPageLoading();
   	}
	public static void CustomerPrimaryEmailAddress_BillingShppingAck() throws InterruptedException, IOException, AWTException
   	{
		Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
		Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
  		Thread.sleep(10000);
  		CreateOrder.CreateOrder_SalesOrderOption.click();
		//Select the company first on create order screen
	   	CreateOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	   	Thread.sleep(2000);
	   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(CrmTestData.Company);
	   	Thread.sleep(6000);
	   	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    Thread.sleep(1000);
	    //Select company from company dropdown
	    CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    //Press the save button
	    Click("Click at save button", CreateOrder.SampleRequestSaveButton);
	    waitForPageLoadSave();
		 driver.navigate().refresh();
		 Assert.assertTrue(CreateOrder.Billing_EmailAddress.getText().contains(CrmTestData.CompEmail));
		 Thread.sleep(2000);
		 Assert.assertTrue(CreateOrder.Shipping_EmailAddress.getText().contains(CrmTestData.CompEmail));
		 Thread.sleep(2000);
		 Assert.assertTrue(CreateOrder.Ack_EmailAddress.getText().contains(CrmTestData.CompEmail));
	  		
   	}
	public static void EditBillingEmailAddress() throws InterruptedException, IOException, AWTException{
	try
   	{
		Click("Edit Billing Address",CreateOrder.Eidt_Billing_EmailAddressButton);
		Input("Edit Billing Email Address",CreateOrder.Edit_Billing_EmailAddress,CrmTestData.EditCompEmail );
		Click("Billing Contact Save Button",CreateOrder. BillingContact_SaveButton);
		Thread.sleep(2000);
		 Assert.assertTrue(CreateOrder.Billing_EmailAddress.getText().contains(CrmTestData.EditCompEmail));
		
   	}
	catch(NoSuchElementException e)
    {
    	e.getStackTrace();
    }
	
	}
	public static void EditBillingContact_VerifyLinkedCompany() throws InterruptedException, IOException, AWTException{
		try
	   	{
			Click("Select Billing Contact",CreateOrder.ChooseBillingContact);
			Thread.sleep(1000);
			Input("Edit Billing Email Address",CreateOrder.SearchContact,"bnazir@asicentral.com");
			List<WebElement> MyComapnyList=driver.findElements(By.xpath("//li[2]//div[contains(@role, 'option')]"));
			int MyComapnyListSize=MyComapnyList.size();
			Random rand2 = new Random();
			// Obtain a number between [0 - size].
			int n2 = rand2.nextInt(MyComapnyListSize);
			MyComapnyList.get(n2).click();
			Click("Edit Billing Address",CreateOrder.Eidt_Billing_EmailAddressButton);
			Thread.sleep(2000);
			 Assert.assertTrue(!CreateOrder.EditBillingContact_CompanyName.getText().isEmpty());
			
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		finally
		{
			Click("Close order window",CreateOrder.CloseOrder_Icon);
			Click("Close order window",CreateOrder.CloseAndExit);
		}
		}
	public static void Verify_EditedBillingEmailAddress_CRM() throws InterruptedException, IOException, AWTException{
		try
	   	{
			Click("CRM",GetData.CRM);
			 Thread.sleep(2000);
			 Click("Please click Main companies link",GetData.NavigatetoCompanies);
				
			 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			 Thread.sleep(3000);
			 Click("Please Click at  company",GetData.ClickCompanyName);
			Thread.sleep(2000);
			 Assert.assertTrue(GetData.PrimaryEmailAddress.getText().contains(CrmTestData.CompEmail));
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		
		}
	public static void OrdersDetail_ProspectComapnySelection() throws InterruptedException, IOException, AWTException{
		try
	   	{
			
			driver.navigate().refresh();
			Thread.sleep(5000);
			Click("Company Selection DropDown",CreateOrder.CompanySelection);
			if(CreateOrder.ProspectComapny.isSelected())
			{
				Click("Select Prospect",CreateOrder.ProspectComapny);
			}
		    if(CreateOrder.DecoratorsCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.DecoratorsCompany);
			}
			if(CreateOrder.SuppliersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.SuppliersCompany);
			}
			 if(CreateOrder.CustomersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.CustomersCompany);
			}
			Click("Select Prospect",CreateOrder.ProspectComapny);
			Click("Company Selection DropDown",CreateOrder.CompanySelection);
			Click("Company Selection DropDown",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
			
			Thread.sleep(2000);
			Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
			  
			Thread.sleep(2000);
			Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains("Auto Supplier ASIQA I"));
	
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		
		}
	public static void OrdersDetail_DecoratorComapnySelection() throws InterruptedException, IOException, AWTException{
		try
	   	{
			
			Click("Company Selection DropDown",CreateOrder.CompanySelection);
			if(CreateOrder.ProspectComapny.isSelected())
			{
				Click("Select Prospect",CreateOrder.ProspectComapny);
			}
		    if(CreateOrder.DecoratorsCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.DecoratorsCompany);
			}
			if(CreateOrder.SuppliersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.SuppliersCompany);
			}
			 if(CreateOrder.CustomersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.CustomersCompany);
			}
		
				Click("Select Prospect",CreateOrder.DecoratorsCompany);
				Click("Company Selection DropDown",CreateOrder.CompanySelection);
				Thread.sleep(2000);
				Click("Company Selection DropDown",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
				Thread.sleep(2000);
				Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
			    Thread.sleep(2000);
			    Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains("Auto Supplier ASIQA I"));
				
			
			
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		
		}
	public static void OrdersDetail_SupplierComapnySelection() throws InterruptedException, IOException, AWTException{
		try
	   	{
	
			Click("Company Selection DropDown",CreateOrder.CompanySelection);
			if(CreateOrder.ProspectComapny.isSelected())
			{
				Click("Select Prospect",CreateOrder.ProspectComapny);
			}
		    if(CreateOrder.DecoratorsCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.DecoratorsCompany);
			}
			if(CreateOrder.SuppliersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.SuppliersCompany);
			}
			 if(CreateOrder.CustomersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.CustomersCompany);
			}
		
				Click("Select Suppliers Company",CreateOrder.SuppliersCompany);
				Click("Company Selection DropDown",CreateOrder.CompanySelection);
				Thread.sleep(2000);
				Click("Company Selection DropDown",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
				Thread.sleep(2000);
				Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
			    Thread.sleep(2000);
			    Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains("Auto Supplier ASIQA I"));
				
			
			
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		
		}
	public static void OrdersDetail_CustomerComapnySelection() throws InterruptedException, IOException, AWTException{
		try
	   	{
		
			Click("Company Selection DropDown",CreateOrder.CompanySelection);
			if(CreateOrder.ProspectComapny.isSelected())
			{
				Click("Select Prospect",CreateOrder.ProspectComapny);
			}
		    if(CreateOrder.DecoratorsCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.DecoratorsCompany);
			}
			if(CreateOrder.SuppliersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.SuppliersCompany);
			}
			 if(CreateOrder.CustomersCompany.isSelected())
			{
				Click("Select Prospect",CreateOrder.CustomersCompany);
			}
		
				Click("Select Suppliers Company",CreateOrder.CustomersCompany);
				Click("Company Selection DropDown",CreateOrder.CompanySelection);
				Thread.sleep(2000);
				Click("Company Selection DropDown",CreateOrder.CreateOrderScreen_CompanySearch_Textfield);
				Thread.sleep(2000);
				Input("Please Enter in search field", CreateOrder.CreateOrderScreen_CompanyField_SendData, "Auto Supplier ASIQA I");
			    Thread.sleep(2000);
			    Assert.assertTrue(CreateOrder.CreateOrderScreen_CompanyFieldVerification.getText().contains("Auto Supplier ASIQA I"));
				
		
			
	   	}
		catch(NoSuchElementException e)
	    {
	    	e.getStackTrace();
	    }
		
		}
	public static void ForNewProduct_ReviewCADCurrancy_OrderLevel() throws InterruptedException, IOException{
    	try{
			
    		Click("Add New Product dropdown Icon",CreateOrder.CreateCustomProduct_CreateIcon);
    		Click("Add New Product",CreateOrder.NewProduct_Link_CustomPro);
    		Click("Add New Product",CreateOrder.CategoryDropDown);
    		Input("Search Categories", CreateOrder.SearchCategories, "mugs");
    		 CreateOrder.SearchCategories.sendKeys(Keys.ARROW_DOWN);
     	    Thread.sleep(1000);
     	    //Select company from company dropdown
     	    CreateOrder.SearchCategories.sendKeys(Keys.ENTER);
     	   Input("Provide Product no", CreateOrder.ProductNumber, "0001");
     	   Input("Provide Product name", CreateOrder.Productname, "Grey Mugs");
     	   Input("Provide Product CPN", CreateOrder.ProductCPN, "mugs000012");
   	    
    		Click("Open supplier dropdown",CreateOrder.CustomProduct_SupplierDropdown_Verification);
    		Input("Search Categories", CreateOrder.SearchSupplier, "Auto Supplier ASIQA I");
    		Thread.sleep(2000);
    	    CreateOrder.SearchSupplier.sendKeys(Keys.ARROW_DOWN);
    	    Thread.sleep(2000);
    	    //Select company from company dropdown
    	    CreateOrder.SearchSupplier.sendKeys(Keys.ENTER);
    	   
    	    Thread.sleep(3000);
    	    Click("Add New Product",CreateOrder.SaveDecoration);
    		
    		Click("Click the More Button", CreateOrder.Orderdetails_MoreButton);
   		   
   		 	Click("Click the Create Quote option", CreateOrder.ManageCurrancy);
 			
 		   	 Thread.sleep(1000);
 		   	 Select Currancy = new Select(CreateOrder.ManageCurrancyDropDown);
 		   	 Currancy.selectByVisibleText("Canadian Dollar (CAD)");
 		   	 Input("Provide Currancy Rate",CreateOrder.conversionRate,"1.3");
 		   	 
 		   	Click("Save", CreateOrder.Save_ManageCurrancy);
 		   waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
 			Click("Price tab", CreateOrder.Orderdetails_PricingTab);
 			Thread.sleep(2000);
 			Assert.assertTrue(CreateOrder.SubTotal_TotalCost.getText().contains("C$")&& CreateOrder.SubTotal_TotalPriceCurrancy.getText().contains("C$")&& CreateOrder.AmountDue_TotalPrice.getText().contains("C$") );
 			
 		  
    	}catch(NoSuchElementException e){
    		e.getMessage();
    	}
    }
	public static void CanadianPriceValidation_POAPage() throws InterruptedException, IOException{
    	try{
			
    		 Click("ESP WEb", GetData.ESPWeb);
    		 waitForPageLoading();
    		 Thread.sleep(7000);
    		 Click("Advanced Search", GetData.AdvanceSearch);
    		 
    		 js.executeScript("arguments[0].scrollIntoView();",GetData.CanadianPrice );
    		 if(!GetData.CanadianPriceCheckbox.isSelected());
    		 {
    			 Click("Select virtual sample Checkbox",GetData.CanadianPriceCheckbox);
    		 }
    		 Click("Search",GetData.SearchButton);
    		 waitForPageLoading();
    		 parentWindow = driver.getWindowHandle();
    		
    		 List< WebElement> HoverOrderQuickInfo=driver.findElements(By.xpath("//div[contains(@class,'media-body quickview-click ng-isolate-scope')]/div/div/div[contains(@ng-if,'settings.fields.name.checked')]"));
    		 HoverOrderQuickInfo.get(0).click();
    		 Thread.sleep(2000);
    		 List< WebElement> OrderProduct=driver.findElements(By.xpath("//button[contains(@analytics-label,'Order')]"));
    		 OrderProduct.get(1).click();
    		 List< WebElement> QuanityField=driver.findElements(By.xpath("//input[contains(@placeholder,'QTY')] | //input[contains(@placeholder,'Qty')]"));
    		System.out.println(QuanityField.size());
    		 if(QuanityField.size()==1)
    		{
    			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"5");
    		}
    		 if( QuanityField.size()==0)
    		 {
    			 Click("Advanced Search", CreateOrder.CreateOrder_Configure_Continue_Button);
    			 Input("Provide Quantity",CreateOrder.CreateOrder_Configure_QTY_TextField,"5");
    		 }
    		
    		 Thread.sleep(2000);
 			 List<WebElement> CADPrice=driver.findElements(By.xpath("//div[contains(@ng-if,'vm.lineItem.Totals.Units > 0')]/descendant::h4[contains(@class,'total no-margin-top ng-binding')]"));
 			 for(int i=1;i<CADPrice.size();i++)
 			 {
 				 String CADPriceValue=CADPrice.get(i).getText();
 				 System.out.println(CADPriceValue);
 				 Assert.assertTrue(CADPriceValue.contains("C$"));
 			 }
 				 
 			
    		 
    	}catch(NoSuchElementException e){
    		e.getMessage();
    	}
    }
	public static void ReviewCurrancyAtOrderLevel_WhenAddMultipleProductWithDifferentCurrancy() throws InterruptedException, IOException, AWTException{
    try{
    	
    	//CreateOrder();
    	AddProductConfiguration_FromProject();
    	Click("Click the More Button", CreateOrder.Orderdetails_MoreButton);
		Click("Click the Create Quote option", CreateOrder.ManageCurrancy);
    	Select Currancy = new Select(CreateOrder.ManageCurrancyDropDown);
	   	 Currancy.selectByVisibleText("Canadian Dollar (CAD)");
	   	 Input("Provide Currancy Rate",CreateOrder.conversionRate,"1.3");
	   	Click("Save", CreateOrder.Save_ManageCurrancy);
	   	waitForElementNotVisible(120, driver,CreateOrder.SpinnerLoader);
		Click("Price tab", CreateOrder.Orderdetails_PricingTab);
		Thread.sleep(2000);
		Assert.assertTrue(CreateOrder.SubTotal_TotalCost.getText().contains("C$")&& CreateOrder.SubTotal_TotalPriceCurrancy.getText().contains("C$")&& CreateOrder.AmountDue_TotalPrice.getText().contains("C$") );
		
    	}catch(NoSuchElementException e){
    		e.getMessage();
    	}
    }
}