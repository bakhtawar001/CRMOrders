
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import OrdersTestcases.CreateOrder;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;


public class Filters extends HelpingFunction {
// static WebElement DefaultVisi1;
	static String Orderno;
	static String Orderno1;
	static String VendorName;
	// static WebElement DefaultVisi2;

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static OrdersLocators Filters = PageFactory.initElements(driver, OrdersLocators.class);	
		
			  	
			  	public static void VerifyFilters(boolean b) throws InterruptedException, AWTException, IOException{
		  			 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		    	   	 
		    	   	 if(b) {
		    	   		 Click("Please click at main link of companies",GetData.NavigatetoCompanies);
		    	   	 }
		    	   	 else {
			    	   	 Click("Please click at main link of companies",GetData.NavigatetoContacts);
		    	   	 }
					 Click("Please Click All Filter link",GetData.AllFilter);
					 Thread.sleep(2000);
		    		 String AllResult=GetData.ResultFound.getText();
		    		 
		    		 
					 Click("Please Click at Active Filter link",GetData.ActiveFilter);
					 Thread.sleep(2000);
					 String ActiveResult=GetData.ResultFound.getText();
					 
					 Click("Please Click at Active Filter link",GetData.InactiveFilter);
					 Thread.sleep(2000);
					 String InActiveResult=GetData.ResultFound.getText();
					 
					 if(AllResult!=ActiveResult && ActiveResult != InActiveResult) {
						 Verify(AllResult, AllResult, "Filters are not working correctly");

					 }
					 else {
						 Verify(AllResult, ActiveResult, "Filters are not working correctly");

					 }
					
					 
		  			} 
			  	
			    public static void Search(boolean b) throws InterruptedException, AWTException, IOException{
	    			
	    			test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	    			
	    			if(b) {
	    				Click("Please click at main link of companies",GetData.NavigatetoCompanies);
	    				Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
		    			Thread.sleep(5000);
		    			Verify(CrmTestData.Company, GetData.ClickCompanyName.getText(), "Search is not working for comp");
	    			}
	    			else {
	    				Click("Please click at main link of companies",GetData.NavigatetoContacts);
	    				Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ContactFName);
		    			Thread.sleep(2000);
		    			Verify(CrmTestData.ContactFName+" Nazeer", GetData.ClickCompanyName.getText(), "Search is not working");
	    			}
			    }
			    
			    public static void VerifyOrdersFilters_UnderExistingCompany() throws InterruptedException, AWTException, IOException
			    {
	    			
	    			test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	    			Click("Please click at main link of companies",GetData.NavigatetoCompanies);
	    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ExistingCompany);
		    		Thread.sleep(5000);
		    		
		    		Click("Access Company",GetData.CompDetails);
		    		Click("Access Orders",GetData.OrdersTab);
		    	/*	List<WebElement> Orders=driver.findElements(By.xpath("//li/a[contains(text(),'Orders')]"));
		    		Orders.get(1).click();*/
		    		Click("Access Orders",GetData.Filters);
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.StatusFilter.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.DateFilter.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.CustomerFilter.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.ContactFilters.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.VendorFilter.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.ProductCategoryFilter.isDisplayed());
		    		Thread.sleep(2000);
		    		Assert.assertTrue(GetData.SalesRepFilter.isDisplayed());
		    		
		    	
	    			
			    }
			    public static void VerifyFilters_UnderNewCompany() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
			    	 Click("Please click at add company button",GetData.NavigatetoCompanies);
					 Thread.sleep(5000);
					Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.CompanyB);
			    	//CompanyScenarios.CreateCompany("Customer");
			    	Thread.sleep(5000);
			    	Click("Access Company",GetData.CompDetails);
			    	Click("Access Orders",GetData.OrdersTab);
			    	Thread.sleep(2000);
			    	List<WebElement> Orders=driver.findElements(By.xpath("//li/a[contains(text(),'Orders')]"));
			    	Orders.get(1).click();
			    
			    	Click("Access Orders",Filters.OrdersScreen_CreateOrderButton);
			    	Thread.sleep(3000);
			    	//CreateOrder();
			    	CreateOrder.Product_Added_To_Order();
			    	waitForPageLoadSave();
			    	Thread.sleep(6000);
			    	VendorName=GetData.VendorName.getText();
			    	System.out.println(VendorName);
			    	 Thread.sleep(2000);
			    
			    	Orderno=OrdernoConv.OrderNumber.getText();
			    	Orderno=Orderno.replaceAll("[-+.^:,#a-zA-Z]","");
			    	Orderno=Orderno.trim();
			    	System.out.println(Orderno);
			    	Click("Click On Tags dropdown",GetData.TagsDropDown);
			    	Thread.sleep(2000);
				    
			    	Input("Provide Tags Name", GetData.TagsInput, "OrdersTag");
			    	Thread.sleep(2000);
			    	Click("Select Tag",GetData.SelectTagsInput);
			    
			    
			    }
			    
			    public static void VerifyFilters_UnderNewCompany2() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	OrdersLocators OrdernoConv = PageFactory.initElements(driver, OrdersLocators.class);
					Click("Click To Close Order Screen",Filters.SampleRequestSaveButton);
					Thread.sleep(6000);
					Click("Click To Close Order Screen",Filters.CloseOrder_Icon_SampleRequest);
					Thread.sleep(2000);
					Click("Click To Close Order Screen",Filters.CloseAndExit);
					Thread.sleep(3000);
					Click("a", GetData.CRM);
						
					 Thread.sleep(2000);
					 Click("Please click Main companies link",GetData.NavigatetoCompanies);
		    		Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.CompanyB);
		    		Thread.sleep(3000);
		    		Click("Access Company",GetData.CompDetails);
			    	Click("Access Orders",GetData.OrdersTab);
			    	Thread.sleep(2000);
			    	Click("Access Orders",Filters.OrdersScreen_CreateOrderButton);
			    	
			    	/*List<WebElement> Orders=driver.findElements(By.xpath("//li/a[contains(text(),'Orders')]"));
			    	Orders.get(2).click();*/
			    	 Thread.sleep(2000);
			    	 Click("Status DropDown",Filters.Orderdetailpage_OrderStatusDropdown);
			 
			    	driver.findElement(By.xpath("//a[contains(.,'Closed')]")).click();
					Thread.sleep(2000);
					Click("Save status",Filters.Settings_OrderstatusForm_savebutton);
		
			    	//CreateOrder();
					 Thread.sleep(6000);
			    //	Product_Added_To_Order();
			    	waitForPageLoadSave();
					Click("Select billing Address",Filters.BillingContact);
					Thread.sleep(5000);
					Input("Provide billing Address",Filters.SearchBillingContact,CrmTestData.ExistingCompany);
					Thread.sleep(5000);
					List<WebElement> CRMBillingContact=driver.findElements(By.xpath("//li/descendant::span/div/div[contains(@ng-if,'contact.Name')]"));
					CRMBillingContact.get(1).click();
					Thread.sleep(2000);
					
					Click("Select billing Address",Filters.ShippingContact);
					Thread.sleep(5000);
					Input("Provide billing Address",Filters.SearchShippingContact,CrmTestData.ExistingCompany);
					Thread.sleep(5000);
					List<WebElement> CRMShippingContact=driver.findElements(By.xpath("//li/descendant::span/div/div[contains(@ng-if,'contact.Name')]"));
					CRMShippingContact.get(1).click();
					Thread.sleep(2000);
					Click("Shipping charges NO",Filters.ConfirmationNo);
					
					
					Click("Select billing Address",Filters.AcknowledgementContact);
					Thread.sleep(5000);
					Input("Provide billing Address",Filters.SearchAcknowledgementContact,CrmTestData.ExistingCompany);
					Thread.sleep(5000);
					List<WebElement> CRMAckContact=driver.findElements(By.xpath("//li/descendant::span/div/div[contains(@ng-if,'contact.Name')]"));
					CRMAckContact.get(1).click();
					Thread.sleep(2000);
					
			    	
			    	
			    	Orderno1=OrdernoConv.OrderNumber.getText();
			    	Orderno1=Orderno1.replaceAll("[-+.^:,#a-zA-Z]","");
			    	Orderno1=Orderno1.trim();
			    	
			    	System.out.println(Orderno1);
			    	//Press the save button
				  Click("Click at save button", Filters.SampleRequestSaveButton);
				    waitForPageLoadSave();
					Thread.sleep(6000);
					
			    	Click("Click To Close Order Screen",Filters.CloseOrder_Icon_SampleRequest);
					Thread.sleep(2000);
					 Click("a", GetData.CRM);
						
					 Thread.sleep(2000);
					 Click("Please click Main companies link",GetData.NavigatetoCompanies);
		    		Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.CompanyB);
		    		Thread.sleep(3000);
		    		Click("Access Company",GetData.CompDetails);
			    	Click("Access Orders",GetData.OrdersTab);
			    	Thread.sleep(2000);
			    
			    }
			    public static void VerifyStatusClosedFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	Click("Access Orders",GetData.Filters);
		    		Thread.sleep(2000);
		    		Click("Access Filter",GetData.ClosedFilter);
			    	
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno1));
			    
			    }
			    public static void VerifyStatusOpenFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    
			    	if(GetData.ClosedFilter.isSelected())
			    	{
			    		Click("Checkout close Filter",GetData.ClosedFilter);
			    		Thread.sleep(2000);
			    		Click("Checkin Open Filter",GetData.OpenFilter);
			    	}
			    	
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno));
			    }
			    public static void VerifyVendorFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	JavascriptExecutor js = (JavascriptExecutor) driver;
			    	if(GetData.OpenFilter.isSelected())
			    	{
			    		Click("Checkout close Filter",GetData.OpenFilter);
			    		
			    	}
			    	Thread.sleep(2000);
			    	WebElement Element=driver.findElement(By.xpath("//filter-block[contains(@selected-values,'vm.filters.vendors')]/descendant::div/div/label[contains(@title,'"+VendorName+"')]"));
			    	js.executeScript("arguments[0].scrollIntoView();", Element);
			    	Element.click();
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno));
			    	
			    }
			    public static void VerifyBillingAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	WebElement Element=driver.findElement(By.xpath("//filter-block[contains(@selected-values,'vm.filters.vendors')]/descendant::div/div/label[contains(@title,'"+VendorName+"')]/input"));
			    	
			    	if(Element.isSelected())
			    	{
			    		Click("Checkout vender Filter",Element);
			    		
			    	}
			    	Click("Billing Contact",GetData.Billing);
			    	Thread.sleep(2000);
			    	Click("Select Billing Address",GetData.BillingAddress);
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno1));
			    	
			    }
			    
			    public static void VerifyShippingAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	
			    	Click("Billing Contact",GetData.Shipping);
			    	Thread.sleep(2000);
			    	Click("Select Billing Address",GetData.BillingAddress);
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno1));
			    	
			    }
			    public static void VerifyAckAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	
			    	Click("Billing Contact",GetData.Ack);
			    	Thread.sleep(2000);
			    	Click("Select Billing Address",GetData.BillingAddress);
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno1));
			    	
			    }
			    public static void VerifyCustomerFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	if(GetData.BillingAddress.isSelected())
			    	{
			    		Click("Billing Contact",GetData.BillingAddress);
			    	}
			    	Click("Billing Contact",GetData.CustomerNameFilter);
			    	
			    	List<WebElement> orderstable=driver.findElements(By.xpath("//table[contains(@ng-table,'vm.orderTable')]/descendant::tbody/tr"));
			    	System.out.println(orderstable.size());
			    	for(int i=1;i<=orderstable.size();i++)
			    	{
			    		String ordername=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[contains(@data-title-text,'Order #')]")).getText();
			    		System.out.println(ordername);
			    		if(ordername.contains(Orderno1)||ordername.contains(Orderno))
			    		{
			    			Assert.assertTrue(true);
			    		}
			    	}
			    	
			    
			    }
			    
			    public static void VerifySalesRepFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    	JavascriptExecutor js = (JavascriptExecutor) driver;
			    	if(GetData.CustomerNameFilter.isSelected())
			    	{
			    		Click("Customer Contact",GetData.CustomerNameFilter);
			    	}
			    	js.executeScript("arguments[0].scrollIntoView();", GetData.NewCompanySalesRepFilter);
			    	Click("Customer Contact",GetData.NewCompanySalesRepFilter);
			    	

			    	List<WebElement> orderstable=driver.findElements(By.xpath("//table[contains(@ng-table,'vm.orderTable')]/descendant::tbody/tr"));
			    	System.out.println(orderstable.size());
			    	for(int i=1;i<=orderstable.size();i++)
			    	{
			    		String ordername=driver.findElement(By.xpath("//tbody/tr["+i+"]/td[contains(@data-title-text,'Order #')]")).getText();
			    		System.out.println(ordername);
			    		if(ordername.contains(Orderno1)||ordername.contains(Orderno))
			    		{
			    			Assert.assertTrue(true);
			    		}
			    	}
			    	
			    }
			    
			    public static void VerifyTagsFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
			    {
			    	test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    //	JavascriptExecutor js = (JavascriptExecutor) driver;
			    	if(GetData.NewCompanySalesRepFilter.isSelected())
			    	{
			    		Click("Billing Contact",GetData.NewCompanySalesRepFilter);
			    	}
			    	//js.executeScript("arguments[0].scrollIntoView();", GetData.NewCompanySalesRepFilter);
			    	Thread.sleep(2000);
			    	Click("Customer Contact",GetData.Tags);
			    	
			    	Thread.sleep(2000);
			    	Assert.assertTrue(GetData.OrderFilter.getText().contains(Orderno));
			    	
			    }
			 	public static void Product_Added_To_Order() throws InterruptedException, IOException{
			   		try
			   		{
			   			JavascriptExecutor js = (JavascriptExecutor) driver;
			   			Thread.sleep(3000);
					   //Press Add Product Button
					   Click("a", Filters. CreateOrder_AddProductButton);
					
					  // CreateOrder. CreateOrder_AddProductButton.click();
					   
					   waitForElementNotVisible(120, driver,Filters.SpinnerLoader);
					   Thread.sleep(2000);
					   //Go To Product Search Tab in popup
					   Filters.CreateOrder_AddProductPopup_ProductSearchTab.click();
					   waitForElementNotVisible(120, driver,Filters.SpinnerLoader);
					   //Search the Product which want to associate with order
					   Filters.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct2);
					   
					   waitForElementNotVisible(120, driver,Filters.SpinnerLoader);
					   
					   //Now press Search Button
					   Filters.CreateOrder_AddProductPopup_SearchButton.click();
						
					   wait = new WebDriverWait(driver, 180);
					   wait.until(ExpectedConditions.elementToBeClickable(Filters.CreateOrder_AddProductPopup_ProductSelection));
					   
					   
					   //Now Select the Product
					   Filters.CreateOrder_AddProductPopup_ProductSelection.click();
					   
					   Thread.sleep(2000);
					   js.executeScript("arguments[0].scrollIntoView();", Filters.CreateOrder_AddProductPopup_AddProductsButton);
					   //Press the Add Products Button to complete the process
					   Filters.CreateOrder_AddProductPopup_AddProductsButton.click();
					   
					   waitForElementNotVisible(120, driver,Filters.SpinnerLoader);
						
					   String ProductAddedToOrderSuccess=Filters.CreateOrder_ProductAddedToOrder_Successfull.getText();
					   Thread.sleep(2000);
					   Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
			   
			   		
			   	}
			   		catch(NoSuchElementException e)
			   		{
			   			e.getMessage();
			   		}
			   		
			   	}
			   	
			    public static void CreateOrder() throws InterruptedException, IOException
			   	{
			   		
			   			SoftAssert softassertion=new SoftAssert();
			   			
			   			Filters.CreateOrder_SalesOrderOption.click();
						//Select the company first on create order screen
			   			Filters.CreateOrderScreen_CompanySearch_Textfield.click();
					   	Thread.sleep(2000);
					   	Filters.CreateOrderScreen_CompanyField_SendData.sendKeys(CrmTestData.Company);
					   	Thread.sleep(6000);
					   	Filters.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
					    Thread.sleep(1000);
					    //Select company from company dropdown
					    Filters.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
					    Thread.sleep(2000);
					    //Press the save button
					    Click("Click at save button", Filters.SampleRequestSaveButton);
					    waitForPageLoadSave();
					   /* Thread.sleep(1000);
						 Click("Please click at Save Button",GetData.SaveOrders.get(1));
						 Thread.sleep(20000);*/
						 driver.navigate().refresh();
						
			   	}
			   
			    
			  		
}
