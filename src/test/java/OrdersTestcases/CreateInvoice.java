package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class CreateInvoice extends OrdersExecution1 {

	 static OrdersLocators CreateInvoice = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void InvoiceCreation_BillingAddress() throws IOException, InterruptedException, ParseException{
        try{
		
     //Close the Order
//	 Thread.sleep(2000);
//	 Click("click home page", CreateInvoice.CloseOrder_Icon);
//	 waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
	 
	 //Click the Orders tab
	 Click("click home page", CreateInvoice.ESPWebHomePage_OrdersTab);

	 Thread.sleep(1000);
	 Click("click home page", CreateInvoice.OrdersScreen_OrderButton);

	 Thread.sleep(1000);

	//Select the Sales Order option from toggle dropdown
	 Click("click home page", CreateInvoice.CreateOrder_InvoiceOption);
	   Thread.sleep(3000);
	 //Select the company first on create order screen
	   Click("click home page",  CreateInvoice.CreateOrderScreen_CompanySearch_Textfield);
	 
	 
	  CreateInvoice.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	 
	 Thread.sleep(6000);
	//Select company from company dropdown
	 CreateInvoice.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	 
	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
	
	 waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
	 
	 Thread.sleep(2000);
	 //Rest	
	String InvoiceBillingAddress=driver.findElement(By.cssSelector("address[ng-show='$ctrl.ngModel.Address']")).getText();
	 boolean testInvoiceBillingAddress=driver.getPageSource().contains("Feasterville-Trevose, PA 19053");
	 System.out.println(testInvoiceBillingAddress);

	 //String InvoiceBillingAddress=CreateInvoice.CreateInvoice_BillingContactAddress.getText();
	Assert.assertTrue(!InvoiceBillingAddress.isEmpty());
/*	if(!InvoiceBillingAddress.isEmpty())
	{
	resultPass("CreateInvoice_BillingAddress Verification",InvoiceBillingAddress+"Billing Address displayed Successfully");
	System.out.println(InvoiceBillingAddress+""+"Displayed Successfully");
	}
	else{
		resultFail("CreateInvoice_BillingAddress Verification",InvoiceBillingAddress+"Billing Address displayed UnSuccessfully");
	   	System.out.println(InvoiceBillingAddress+""+"Displayed UnSuccessfully");
	}*/
	
        }catch(NoSuchElementException e)
        {
         e.getMessage();
        }
	}
	public static void CreateInvoice_ShippingAddress_Verification() throws IOException, InterruptedException{
		try{
	 boolean testInvoiceShippingAddress=driver.getPageSource().contains("Feasterville-Trevose, PA 19053");
	 System.out.println(testInvoiceShippingAddress);

	 //String InvoiceShippingAddress=CreateInvoice.CreateInvoice_ShippingContactAddress.getText();
	String InvoiceShippingAddress=driver.findElement(By.cssSelector("address[ng-show='$ctrl.ngModel.Address']")).getText();
	Assert.assertTrue(!InvoiceShippingAddress.isEmpty());
	/*if(!InvoiceShippingAddress.isEmpty())
	{
		System.out.println(InvoiceShippingAddress+""+"Displayed Successfully");
		resultPass("CreateInvoice_ShippingAddress Verification", InvoiceShippingAddress+"displayed Successfully");
	   		
	}
	else{
		System.out.println(InvoiceShippingAddress+""+"Displayed UnSuccessfully");
		resultFail("CreateInvoice_ShippingAddress Verification", InvoiceShippingAddress+"displayed UnSuccessfully");
	   	
	}*/
		}catch(NoSuchElementException e){
		   e.getMessage();
		}
	}	
public static void Product_Added_To_Invoice() throws InterruptedException, IOException{
	try{
		
		Thread.sleep(5000);
//Press Add Product Button
	CreateInvoice. CreateOrder_AddProductButton.click();
	waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
    Thread.sleep(1000);

//Go To Product Search Tab in popup
    CreateInvoice.AddProduct_Clipboard_US_Product.click();
    waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
    Thread.sleep(1000);

  //Press the Add Products Button to complete the process
    CreateInvoice.CreateOrder_AddProductPopup_AddProductsButton.click();
    waitForPageLoading();
    Thread.sleep(1000);
    String ProductAddedToOrderSuccess=CreateInvoice.CreateOrder_ProductAddedToOrder_Successfull.getText();
    Assert.assertTrue(ProductAddedToOrderSuccess.contains("Success"));
/*if(ProductAddedToOrderSuccess.contains("Success"))
{
	   System.out.println("Product Added To Invoice Successfully");
	   resultPass("Product Added To Invoice", "Product Added To Invoice Successfully");
}
else{
	   System.out.println("Product Added To Invoice UnSuccessfully");
	   resultFail("Product Added To Invoice", "Product Added To Invoice UnSuccessfully");
}*/
	}catch(NoSuchElementException e){
	   e.getMessage();
	}
}	
    public static void Create_Invoice() throws IOException, InterruptedException{
    	try{
    		SoftAssert softAssertion= new SoftAssert();
    		waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
    		//Now configuring the product

    		//Hover the configure button
    		Click("a", CreateInvoice.CreateOrders_ConfigureButton);
    		
    			waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
	
    			//Enter The Quantity on Quatity screen
    			List<WebElement> records = CreateInvoice.Price_Grid;
    			int record=records.size();
    			//Enter The Quantity on Quatity screen
    			if(record>=1) 
    			{
			
    				Thread.sleep(2000);
    				Click("Click at Select button of price grid", CreateInvoice.ClickAtSelect);
    				Thread.sleep(2000);
    				CreateInvoice.CreateOrder_Configure_Continue_Button.click();
    				CreateInvoice.CreateOrder_Configure_QTY_TextField.sendKeys("5");
    			}
    			
    			else
    			{
    				Thread.sleep(2000);
    				CreateInvoice.CreateOrder_Configure_Continue_Button.click();
    				CreateInvoice.CreateOrder_Configure_QTY_TextField.sendKeys("5");
    			}
	
    				Thread.sleep(1000);
	
    				//Press the continue Button
    				CreateInvoice.CreateOrder_Configure_Continue_Button.click();
    				Thread.sleep(2000);

    				//Decoration Optional Screen Appear Press the save button now to create a Order
    				CreateInvoice.CreateOrder_DecoratorScreen_Save_Button.click();
    				Thread.sleep(3000);
    				Assert.assertTrue(CreateInvoice.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
    				
	
	 
	  	 
	
    	}catch(NoSuchElementException e){
    	  e.getStackTrace();
    	}

	}  
    public static void Send_Invoice_BillingEmailAddress() throws IOException, InterruptedException{
    	try{
    		String BillingEmailAddress=CreateInvoice.Billing_EmailAddress.getText();
    		System.out.println(BillingEmailAddress);
    		Click("Click Send",CreateInvoice.Invoice_Send_Button);
    		waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
    		String SendBillingEmailAddress=CreateInvoice.SendInvoice_Billing_EmailAddress.getText();
    		System.out.println(SendBillingEmailAddress);
    		Thread.sleep(2000);
    		Assert.assertTrue(CreateInvoice.SendInvoice_Billing_EmailAddress.getText().contains(BillingEmailAddress));
	
    	}catch(NoSuchElementException e){
    	  e.getStackTrace();
    	}
finally
{
	driver.navigate().refresh();
	waitForElementNotVisible(120, driver,CreateInvoice.SpinnerLoader);
	CreateInvoice.CloseOrder_Icon.click();
	
}
	}  
	
}


