package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;

public class OctRelease extends HelpingFunction {

	public static String NewDestinationAddress;
	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static void PORefISNULL() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");
		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 Click("a",     GetData.CloseOrder_Icon);


	
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}

	public static void PORefISNOTNULL() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Thread.sleep(3000);
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(3000);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 Click("a",     GetData.VerifyPopUpCheckBox);
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(3000);
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");
		 Click("a",     GetData.Requote_Option_QuoteDetails);
		 Assert.assertFalse(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.VerifyPopUpCheckBox);
		 Click("a",     GetData.ContinueReorder);
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}

	public static void CreateQuoteFromOrder() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateQuoteFromOrderCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");

		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateReorderFromOrder() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	
	public static void CreateReorderFromOrderCBUncheked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateReorderFromOrderCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateInvoicerFromOrder() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.CreateOrder_InvoiceOption);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateInvoicerFromOrderCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.CreateOrder_InvoiceOption);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateRequoteFromQuote() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Requote_Option_QuoteDetails);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateRequoteFromQuoteCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Requote_Option_QuoteDetails);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateOrderFromQuote() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateOrderFromQuoteCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateOrder_QuoteOption);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateOrderFromSampleRequest() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateOrderFromSampleRequestCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.OrdersScreen_CreateOrderButton);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateReOrderFromSampleRequest() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 Thread.sleep(15000);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateReOrderFromSampleRequestCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.MoreButton_Reorder);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}

	
	public static void CreateQuoteFromSampleRequest() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Orderdetails_MoreButton_CreateQuote);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	
	public static void CreateQuoteFromSampleRequestCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 /*
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	*/
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Orderdetails_MoreButton_CreateQuote);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(35000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateInvoiceFromSampleRequest() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Order_CreateInvoice);
		 if(!GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Assert.assertTrue(GetData.VerifyPopUpCheckBox.isSelected());
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
	public static void CreateInvoiceFromSampleRequestCBUnchecked() throws IOException, InterruptedException, ParseException{
        try{
	 // This is to Instantiate EditInstruction  class  
	 OrdersLocators GetData = PageFactory.initElements(driver, OrdersLocators.class);
	 
	//Scroll Up
	 	Thread.sleep(15000);
		 Click("a",     GetData.ESPWebHomePage_OrdersTab);
		 Click("a",     GetData.CreateSampleRequest);
		
		 Click("a",      GetData.ChooseCustomer_TextField);
		 GetData.ChooseCustomer_SearchInsertion.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
	    	Thread.sleep(1000);
	   	//Select company from company dropdown
	   	 
	    	GetData.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	    	
		 Input("Enter PO reference", GetData.Order_POReferenceField, "Test Purchase Order");

		 Click("a",     GetData.SampleRequestSaveButton);
		 Click("a",     GetData.Order_CreateInvoice);
		 if(GetData.VerifyPopUpCheckBox.isSelected()) {
			 Click("a",     GetData.VerifyPopUpCheckBox);
		 }
		 Click("a",     GetData.ContinueReorder);
		 Thread.sleep(15000);
		 String str=GetData.Order_POReferenceField.getAttribute("value");
		 System.out.println(str);
		 Assert.assertNotEquals(str, "Test Purchase Order");
		 Click("a",     GetData.CloseOrder_Icon);
		 
      }
     catch (NoSuchElementException e) {
		// TODO: handle exception
    	 System.err.println("NoSuchElementException: " + e.getMessage());
     }


	}
}