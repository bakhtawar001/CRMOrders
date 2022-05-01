package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class OrdersCustomProduct extends OrdersExecution1 {
	public static String AddCustomProductAttribute1Value;
	public static String AddCustomProductAttribute2Value;
	public static String AddCustomProductAttribute1ValueAfterModify;
	public static String AddCustomProductAttribute2ValueAfterModify;
	static OrdersLocators CustomField = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void CreateOrder_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 
			SoftAssert softassertion=new SoftAssert();
			Thread.sleep(3000);
			//Click("Click to Orders tab",CustomField.ESPWebHomePage_OrdersTab);
			Click("Click orders title tab",CustomField.Orders_Title_Tab);
  			Thread.sleep(2000);
  			Click("Create Order",CustomField.CreateOrder_SalesOrderOption);
  			ProvideCompanyDetail_ConfigurationWindow_AddCustomProductAttribute();
		   	Assert.assertTrue(CustomField.AddCustomProductAttribute.isDisplayed());
	    	
	}
	
	public static void AddCustomProductAttribute_WaterMarkTextVerification() throws IOException, InterruptedException, AWTException
	{
		 
			List<WebElement> AddCustomProductAttribute1=driver.findElements(By.xpath("//td[contains(@class,'item-selection')]//span[contains(@aria-label,'Select box activate')]"));
			AddCustomProductAttribute1Value=AddCustomProductAttribute1.get(0).getText();
			System.out.println(AddCustomProductAttribute1Value);
			AddCustomProductAttribute2Value=AddCustomProductAttribute1.get(1).getText();
			System.out.println(AddCustomProductAttribute2Value);
			
			Click("Click To AddCustomProductAttribute", CustomField.AddCustomProductAttribute);
			List<WebElement> AddCustomProductAttribute_WaterMarkText=driver.findElements(By.xpath("//span[contains(text(),'Enter or select product attribute')]"));
			AddCustomProductAttribute_WaterMarkText.get(2).click();
			String AddCustomProductAttribute_WaterMark=CustomField.WaterMarkAddCustomProductAttribute.getAttribute("placeholder");
			System.out.println(AddCustomProductAttribute_WaterMark);
			Thread.sleep(2000);
			Assert.assertTrue(AddCustomProductAttribute_WaterMark.contains("Enter or select product attribute"));
			
	    	
	}
	
	public static void AddCustomProductAttribute_SelectAttribute() throws IOException, InterruptedException, AWTException
	{
		 
			List<WebElement> AddCustomProductAttribute_TextField=driver.findElements(By.xpath("//input[contains(@placeholder,'Enter or select product attribute')]"));
			AddCustomProductAttribute_TextField.get(2).sendKeys("Material");
			Thread.sleep(2000);
			Assert.assertTrue(CustomField.TypeAheadAddProductAttribute.isDisplayed());
			AddCustomProductAttribute_TextField.get(2).sendKeys(Keys.ARROW_DOWN);
			AddCustomProductAttribute_TextField.get(2).sendKeys(Keys.ENTER);
			
	    	
	}
	public static void DeleteCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 	
			Thread.sleep(2000);
			Click("Remove Product Attribute",CustomField.DeleteAddProductAttribute);
			List<WebElement> AddCustomProductAttribute_WaterMarkText=driver.findElements(By.xpath("//span[contains(text(),'Enter or select product attribute')]"));
			String AddCustomProductAttribute_WaterMark=AddCustomProductAttribute_WaterMarkText.get(2).getText();
			System.out.println(AddCustomProductAttribute_WaterMark);
			Thread.sleep(2000);
			Assert.assertTrue(AddCustomProductAttribute_WaterMark.contains("Enter or select product attribute"));
 
	}
	
	public static void ExistingOrder_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
		Thread.sleep(2000);
		Click("Close order window",CustomField.CloseOrder_Icon);
		Thread.sleep(5000);
		Click("Click orders title tab",CustomField.Orders_Title_Tab);
		ExistingOrder_ConfigurationWindow_ReviewAddCustomProductAttribute();
	    	
	}
	
	public static void CreateInvoice_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 	
			SoftAssert softassertion=new SoftAssert();
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
			Click("Close order window",CustomField.CloseOrder_Icon);
			Thread.sleep(5000);
			Click("a", CustomField.Invoicetab);
	  		Thread.sleep(10000);
	  		Click("Create Invoice",CustomField.CreateOrder_InvoiceOption);
  			Thread.sleep(10000);
  			ProvideCompanyDetail_ConfigurationWindow_AddCustomProductAttribute();
  			Assert.assertTrue(CustomField.AddCustomProductAttribute.isDisplayed());
  			
	    	
	}
	
	public static void Invoice_AddCustomProductAttribute_WaterMarkTextVerification() throws IOException, InterruptedException, AWTException
	{
		
		
		AddCustomProductAttribute_WaterMarkTextVerification();
	    	
	}
	
	public static void Invoice_AddCustomProductAttribute_SelectAttribute() throws IOException, InterruptedException, AWTException
	{
		
		
		AddCustomProductAttribute_SelectAttribute();
	    	
	}
	
	public static void Invoice_DeleteCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
			
		DeleteCustomProductAttribute();
	    	
	}
	
	public static void ExistingInvoice_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
		Click("Close order window",CustomField.CloseOrder_Icon);
		Thread.sleep(5000);
		Click("a", CustomField.Invoicetab);
  		Thread.sleep(5000);
		ExistingOrder_ConfigurationWindow_ReviewAddCustomProductAttribute();
	    	
	}
	
	public static void CreateQuote_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 	
			SoftAssert softassertion=new SoftAssert();
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
			Click("Close order window",CustomField.CloseOrder_Icon);
			Thread.sleep(5000);
   	 		Click("a", CustomField.Quotetab);
	  		Thread.sleep(5000);
	  		Click("Create Quote",CustomField.Orderdetails_MoreButton_CreateQuote);
	  		Thread.sleep(5000);
  			ProvideCompanyDetail_ConfigurationWindow_AddCustomProductAttribute();
  			Assert.assertTrue(CustomField.AddCustomProductAttribute.isDisplayed());
  			
	    	
	}
	
	public static void Quote_AddCustomProductAttribute_WaterMarkTextVerification() throws IOException, InterruptedException, AWTException
	{
		
		 
		AddCustomProductAttribute_WaterMarkTextVerification();
	    	
	}
	
	public static void Quote_AddCustomProductAttribute_SelectAttribute() throws IOException, InterruptedException, AWTException
	{
		
		
		AddCustomProductAttribute_SelectAttribute();
	    	
	}
	
	public static void Quote_DeleteCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
			
		DeleteCustomProductAttribute();
	    	
	}
	
	public static void ExistingQuote_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
		Click("Close order window",CustomField.CloseOrder_Icon);
		Thread.sleep(5000);
		Click("a", CustomField.Quotetab);
  		Thread.sleep(5000);
		ExistingOrder_ConfigurationWindow_ReviewAddCustomProductAttribute();
	    	
	}
	public static void CreateSampleRequest_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
			
			SoftAssert softassertion=new SoftAssert();
			JavascriptExecutor je = (JavascriptExecutor) driver;
			je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
			waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
			Click("Close order window",CustomField.CloseOrder_Icon);
			Thread.sleep(5000);
			Click("Sample Request Tab", CustomField.Orders_SampleRequestTab);
	  		Thread.sleep(10000);
	  		Click("Create Sample Request",CustomField.CreateSampleRequest);
  			Thread.sleep(10000);
  			ProvideCompanyDetail_ConfigurationWindow_AddCustomProductAttribute();
  			Assert.assertTrue(CustomField.AddCustomProductAttribute.isDisplayed());
  			
	    	
	}
	
	public static void SampleRequest_AddCustomProductAttribute_WaterMarkTextVerification() throws IOException, InterruptedException, AWTException
	{
		
		 
		AddCustomProductAttribute_WaterMarkTextVerification();
	    	
	}
	
	public static void SampleRequest_AddCustomProductAttribute_SelectAttribute() throws IOException, InterruptedException, AWTException
	{
		
		
		AddCustomProductAttribute_SelectAttribute();
	    	
	}
	
	public static void SampleRequest_DeleteCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
		 
		DeleteCustomProductAttribute();
	    	
	}
	
	public static void ExistingSampleRequest_EditConfiguration_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
		Thread.sleep(2000);
		Click("Close Sample Request Order window",CustomField.CloseSampleRequest_Icon);
		Thread.sleep(5000);
		Click("Sample Request Tab", CustomField.Orders_SampleRequestTab);
  		Thread.sleep(10000);
		ExistingOrder_ConfigurationWindow_ReviewAddCustomProductAttribute();
	    	
	}
	
	public static void CreateOrder_ShippingField_CloseIcon() throws IOException, InterruptedException, AWTException
	{
		
		SoftAssert softassertion=new SoftAssert();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		Click("Save Configuration window",CustomField.CreateOrder_DecoratorScreen_Save_Button);
		waitForElementNotVisible(120, driver, CustomField.SpinnerLoader);
		Click("Close Sample Request Order window",CustomField.CloseSampleRequest_Icon);
		/*Thread.sleep(5000);
		Click("Click to Orders tab",CustomField.ESPWebHomePage_OrdersTab);*/
		Thread.sleep(5000);
		Click("Click orders title tab",CustomField.Orders_Title_Tab);
		Thread.sleep(10000);
		Click("Create Order",CustomField.CreateOrder_SalesOrderOption);
		Click("Company Search",CustomField.CreateOrderScreen_CompanySearch_Textfield);
   	 	Thread.sleep(2000);
   	 	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
   	 	Thread.sleep(6000);
   	 	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(1000);
    	//Select company from company dropdown
    	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	//Press the save button
    	Click("Click at save button", CustomField.SampleRequestSaveButton);
    	waitForPageLoadSave();
    	Conversions.OrdernumberRegularExpressionStringConversion();
    	Thread.sleep(6000);
    	CreateOrder.AddProductConfiguration_Order();
    	Click("Click on Edit button",  	CustomField.OrdersDetails_EditButton);
	 	waitForElementNotVisible(120, driver, 	CustomField.SpinnerLoader);
	    Thread.sleep(2000);
	    Click("Shipping Tab",CustomField.Shipping_Tab);
	    Click("Cancel Shipping Address",CustomField.CancelShippingAddress);
	    String customfield=CustomField.CustomerFieldShippingAddress.getText();
	    System.out.println(customfield);
	    Thread.sleep(2000);
	    Verify(customfield,"","Shiping address is displayed even on click close icon");
	   
	}
	
	public static void Select_Customer_ShippingAddress() throws IOException, InterruptedException, AWTException
	{
		 
		Click("Select Customer",CustomField.CustomerFieldShippingAddress);
		Thread.sleep(3000);
		Input("Provide Customer Shipping Address",CustomField.ProvideCustomerShippingAddress,"Auto Supplier ASIQA I");
   	 	Thread.sleep(6000);
   	 	CustomField.ProvideCustomerShippingAddress.sendKeys(Keys.ARROW_DOWN);
    	Thread.sleep(1000);
    	//Select company from company dropdown
    	CustomField.ProvideCustomerShippingAddress.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	String ShippingAddress=CustomField.ShippingAddressVerification.getText();
    	System.out.println(ShippingAddress);
    	Thread.sleep(2000);
    	Assert.assertTrue(ShippingAddress.contains("Auto Supplier ASIQA I"));
	    String customfield=CustomField.CustomerFieldShippingAddress.getText();
	    System.out.println(customfield);
	    
	    Thread.sleep(2000);
	    Verify(customfield,"Customer","Shiping address is displayed even on click close icon");
	    
	 
	}
	
	
	
	public static void Select_MyCompany_ShippingAddress() throws IOException, InterruptedException, AWTException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Click("Cancel Shipping Address",CustomField.CancelShippingAddress);
		Thread.sleep(2000);
		Click("Select My Company",CustomField.CustomerFieldShippingAddress);

		Thread.sleep(3000);
		List<WebElement> MyComapnyList=driver.findElements(By.xpath("//li[2]//address[contains(@ng-if, 'contact.Address')]"));
		int MyComapnyListSize=MyComapnyList.size();
		Random rand2 = new Random();
		// Obtain a number between [0 - size].
		int n2 = rand2.nextInt(MyComapnyListSize);
		MyComapnyList.get(n2).click();
		String customfield=CustomField.CustomerFieldShippingAddress.getText();
	    System.out.println(customfield);
	    Thread.sleep(2000);
	    Verify(customfield,"My Company","Shiping address is displayed even on click close icon");
	    
	 
	}
	
	public static void MyCompany_ShippingAddress_CloseIcon() throws IOException, InterruptedException, AWTException
	{
		 
		Click("Cancel Shipping Address",CustomField.CancelShippingAddress);
		String customfield=CustomField.CustomerFieldShippingAddress.getText();
	    System.out.println(customfield);
	    Thread.sleep(2000);
	    Verify(customfield,"","Shiping address is displayed even on click close icon");
	    
	 
	}
	public static void ProvideCompanyDetail_ConfigurationWindow_AddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
			
  			Click("Company Search",CustomField.CreateOrderScreen_CompanySearch_Textfield);
	   	 	Thread.sleep(2000);
	   	 	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
	   	 	Thread.sleep(6000);
	   	 	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	    	//Select company from company dropdown
	    	CustomField.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	Thread.sleep(2000);
	    	//Press the save button
	    	Click("Click at save button", CustomField.SampleRequestSaveButton);
	    	waitForPageLoadSave();
	    	Conversions.OrdernumberRegularExpressionStringConversion();
	    	Thread.sleep(6000);
	    	CreateOrder.AddProductConfiguration_Order();
	    	Click("Click on Edit button",  	CustomField.OrdersDetails_EditButton);
		 	waitForElementNotVisible(120, driver, 	CustomField.SpinnerLoader);
		    Thread.sleep(2000);
			WebElement el = 	 CustomField.ProductConfiguration_SKU;
			Actions builder = new Actions(driver);
			builder.moveToElement( el ).click( el );
			builder.perform();
		   	Thread.sleep(2000);
		   	
	    	
	}
	
	public static void ExistingOrder_ConfigurationWindow_ReviewAddCustomProductAttribute() throws IOException, InterruptedException, AWTException
	{
		
		 	
			Input("Enter Order NO", CustomField.OrderlistingSearch,Conversions.Orderno);
			Thread.sleep(2000);
			//Select existing created order from Top of the list
			Click("Select Order",CustomField.OrderListing_Orderselection);
			waitForPageLoading();
			Click("Click on Edit button",  	CustomField.OrdersDetails_EditButton);
		 
		    Thread.sleep(2000);
		    WebElement el = CustomField.ProductConfiguration_SKU;
			Actions builder = new Actions(driver);
			builder.moveToElement( el ).click( el );
			builder.perform();
			
		    List<WebElement> AddCustomProductAttribute1=driver.findElements(By.xpath("//td[contains(@class,'item-selection')]//span[contains(@aria-label,'Select box activate')]"));
			AddCustomProductAttribute1ValueAfterModify=AddCustomProductAttribute1.get(0).getText();
			Verify(AddCustomProductAttribute1ValueAfterModify,AddCustomProductAttribute1Value,"Attribute Values discard after modifications");
			List<WebElement> AddCustomProductAttribute2=driver.findElements(By.xpath("//td[contains(@class,'item-selection')]//span[contains(@aria-label,'Select box activate')]"));
			AddCustomProductAttribute2ValueAfterModify=AddCustomProductAttribute2.get(1).getText();
			Verify(AddCustomProductAttribute2ValueAfterModify,AddCustomProductAttribute2Value,"Attribute Values discard after modifications");
		
		   	
	    	
	}
	
	
}
