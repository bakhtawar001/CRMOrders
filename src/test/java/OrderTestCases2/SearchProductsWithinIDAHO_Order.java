package OrderTestCases2;

import java.io.IOException;
import java.text.ParseException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Functions.ConversionsWithoutOtherCharges2;
import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class SearchProductsWithinIDAHO_Order extends OrdersExecution3{

	static WebElement HoverConfigure;
	public static void OrderCreation_WithProductSearchIDAHO() throws IOException, InterruptedException, ParseException{
        try{
		// This is to Instantiate CreateOrders  class  
	 OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	
	 
	 
	 //Click the Orders tab
	 CreateOrder.ESPWebHomePage_OrdersTab.click();
	 
	 //Click the Create new Order button
	 CreateOrder.OrdersScreen_OrderButton.click();
	  
	 Thread.sleep(2000);
	 //Select the Sales Order option from toggle dropdown
	   CreateOrder.CreateOrder_SalesOrderOption.click();
	   
	   Thread.sleep(8000);
	   
	 //Select the company first on create order screen
	 CreateOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	 
	 Thread.sleep(6000);
	//Select company from company dropdown
	CreateOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	 
	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
	
	Thread.sleep(5000);
	
//Now Adding configuring first product through searching in IDAHO	

//Press Add Product Button
CreateOrder. CreateOrder_AddProductButton.click();

Thread.sleep(2000);

//Go To Product Search Tab in popup
CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

//Search the Product which want to associate with order
CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.GolfTriumphCalender_Products);

Thread.sleep(1000);

//Now press Search Button
CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
	
wait = new WebDriverWait(driver, 180);
wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

Thread.sleep(2000);

//Now Select the Product
CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

Thread.sleep(2000);

//Press the Add Products Button to complete the process
CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


	
String ProductAddedToOrderSuccess=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

if(ProductAddedToOrderSuccess.contains("Success"))
{
	   System.out.println("Product 1 Added To Order Successfully");
	  
}
else{
	   System.out.println("Product 1 Added To Order UnSuccessfully");
	   
}
Thread.sleep(10000);

driver.navigate().refresh();

Thread.sleep(25000);
//Now select the ship via option to UPS ground
     CreateOrder.OrderShipVia.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.ShipviaSelection.click();
	 
	 Thread.sleep(2000);
	 
	 CreateOrder.ShipViaLabel.click();
	 
	 wait = new WebDriverWait(driver, 180);
     wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.DateConfirm));
     
     Thread.sleep(2000);
     
     CreateOrder.DateConfirm.click();
  	 
  	 Thread.sleep(3000);

//Hover the configure button
   HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
	Hover(HoverConfigure);
	
	Thread.sleep(1000);
	if(driver.getCurrentUrl().contains("stage"))
	{	
	//Now Click the Configure Button
	CreateOrder.CreateOrders_ConfigureButton.click();
	
	Thread.sleep(2000);
	
	//Enter The Quantity on Quatity screen
	CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
	
	Thread.sleep(1000);
	
	//Press the continue Button
	CreateOrder.CreateOrder_Configure_Continue_Button.click();
	
	//Decoration Optional Screen Appear Press the save button now to create a Order
	CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	}
	else{
		//Now Click the Configure Button
		CreateOrder.CreateOrders_ConfigureButton.click();
		
		Thread.sleep(3000);
		
		//Press the continue Button
	    CreateOrder.CreateOrder_Configure_Continue_Button.click();
	    
	    Thread.sleep(3000);
		
		//Enter The Quantity on Quatity screen
		CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		
		Thread.sleep(1000);
		
		//Press the continue Button
	    CreateOrder.CreateOrder_Configure_Continue_Button.click();
	    
	    Thread.sleep(3000);
		
		
		//Decoration Optional Screen Appear Press the save button now to create a Order
		CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	}
	if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	{
	 System.out.println("Product 1 Added and configure successfully");
	 
	}
	else{
	
		System.out.println("Product 1 Added and configure Unsuccessfully");
		
	}	

	
	Thread.sleep(10000);
     
	//Now Adding and configuring 2nd Product
	
	//Press Add Product Button
	CreateOrder. CreateOrder_AddProductButton.click();

	Thread.sleep(2000);

	//Go To Product Search Tab in popup
	CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

	//Search the Product which want to associate with order
	CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.Triumphbeaches_Product);

	Thread.sleep(1000);

	//Now press Search Button
	CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
		
	wait = new WebDriverWait(driver, 180);
	wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

	Thread.sleep(2000);

	//Now Select the Product
	CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

	Thread.sleep(2000);

	//Press the Add Products Button to complete the process
	CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


		
	String ProductAddedToOrderSuccess1=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

	if(ProductAddedToOrderSuccess1.contains("Success"))
	{
		   System.out.println("Product 2 Added To Order Successfully");
		  
	}
	else{
		   System.out.println("Product 2 Added To Order UnSuccessfully");
		   
	}
	Thread.sleep(10000);

	//Hover the configure button
	   HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
		Hover(HoverConfigure);
		
		Thread.sleep(1000);
		
		//Now Click the Configure Button
		CreateOrder.CreateOrders_ConfigureButton.click();
		
		Thread.sleep(2000);
		if(driver.getCurrentUrl().contains("uat") || driver.getCurrentUrl().equals("https://esp.asicentral.com/"))
		{
			//Enter The Quantity on Quatity screen
			CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
			
			//Decoration Optional Screen Appear Press the save button now to create a Order
			CreateOrder.CreateOrder_Configure_Continue_Button.click();

			CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
			
		}
		else{
		//Enter The Quantity on Quatity screen
		CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
		
		Thread.sleep(1000);
		
		//Press the continue Button
		CreateOrder.CreateOrder_Configure_Continue_Button.click();
		
		//Decoration Optional Screen Appear Press the save button now to create a Order
		CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
		}
		
		if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
		{
		 System.out.println("Product 2 Added and configure successfully");
		 
		}
		else{
		
			System.out.println("Product 2 Added and configure Unsuccessfully");
			
		}	


		Thread.sleep(10000);
	   
//Now Add and configure Product 3		
	 //Press Add Product Button
		CreateOrder. CreateOrder_AddProductButton.click();

		Thread.sleep(2000);

		//Go To Product Search Tab in popup
		CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

		//Search the Product which want to associate with order
		CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.TriumphAmericanMuscle_Product);

		Thread.sleep(1000);

		//Now press Search Button
		CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
			
		wait = new WebDriverWait(driver, 180);
		wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

		Thread.sleep(2000);

		//Now Select the Product
		CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

		Thread.sleep(2000);

		//Press the Add Products Button to complete the process
		CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


			
		String ProductAddedToOrderSuccess2=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

		if(ProductAddedToOrderSuccess2.contains("Success"))
		{
			   System.out.println("Product 3 Added To Order Successfully");
			  
		}
		else{
			   System.out.println("Product 3 Added To Order UnSuccessfully");
			   
		}
		Thread.sleep(10000);

		//Hover the configure button
		   HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
			Hover(HoverConfigure);
			
			Thread.sleep(1000);
			
			//Now Click the Configure Button
			CreateOrder.CreateOrders_ConfigureButton.click();
			
			Thread.sleep(2000);
			
			//Enter The Quantity on Quatity screen
			CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
			
			Thread.sleep(1000);
			
			//Press the continue Button
			CreateOrder.CreateOrder_Configure_Continue_Button.click();
			
			//Decoration Optional Screen Appear Press the save button now to create a Order
			CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
			
			if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
			{
			 System.out.println("Product 3 Added and configure successfully");
			 
			}
			else{
			
				System.out.println("Product 3 Added and configure Unsuccessfully");
				
			}	

		   Thread.sleep(10000);
		   
		 //Now Add and configure Product 3		
			 //Press Add Product Button
				CreateOrder. CreateOrder_AddProductButton.click();

				Thread.sleep(2000);

				//Go To Product Search Tab in popup
				CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

				//Search the Product which want to associate with order
				CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.TriumphPuppies_Product);

				Thread.sleep(1000);

				//Now press Search Button
				CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
					
				wait = new WebDriverWait(driver, 180);
				wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

				Thread.sleep(2000);

				//Now Select the Product
				CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

				Thread.sleep(2000);

				//Press the Add Products Button to complete the process
				CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


					
				String ProductAddedToOrderSuccess3=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

				if(ProductAddedToOrderSuccess3.contains("Success"))
				{
					   System.out.println("Product 4 Added To Order Successfully");
					  
				}
				else{
					   System.out.println("Product 4 Added To Order UnSuccessfully");
					   
				}
				Thread.sleep(10000);

				//Hover the configure button
				   HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
					Hover(HoverConfigure);
					
					Thread.sleep(1000);
					
					//Now Click the Configure Button
					CreateOrder.CreateOrders_ConfigureButton.click();
					
					Thread.sleep(2000);
					
					//Enter The Quantity on Quatity screen
					CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
					
					Thread.sleep(1000);
					
					//Press the continue Button
					CreateOrder.CreateOrder_Configure_Continue_Button.click();
					
					//Decoration Optional Screen Appear Press the save button now to create a Order
					CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
					
					if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
					{
					 System.out.println("Product 4 Added and configure successfully");
					 
					}
					else{
					
						System.out.println("Product 4 Added and configure Unsuccessfully");
						
					}	

				   Thread.sleep(10000);
	   
	   
				 //Press Add Product Button
					CreateOrder. CreateOrder_AddProductButton.click();

					Thread.sleep(2000);

					//Go To Product Search Tab in popup
					CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();

					//Search the Product which want to associate with order
					CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.MotivationTriumphCalendar_Product);

					Thread.sleep(1000);

					//Now press Search Button
					CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
						
					wait = new WebDriverWait(driver, 180);
					wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));

					Thread.sleep(2000);

					//Now Select the Product
					CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();

					Thread.sleep(2000);

					//Press the Add Products Button to complete the process
					CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();


						
					String ProductAddedToOrderSuccess4=CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();

					if(ProductAddedToOrderSuccess4.contains("Success"))
					{
						   System.out.println("Product 5 Added To Order Successfully");
						  
					}
					else{
						   System.out.println("Product 5 Added To Order UnSuccessfully");
						   
					}
					Thread.sleep(10000);

					//Hover the configure button
					   HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
						Hover(HoverConfigure);
						
						Thread.sleep(1000);
						
						//Now Click the Configure Button
						CreateOrder.CreateOrders_ConfigureButton.click();
						
						Thread.sleep(2000);
						
						//Enter The Quantity on Quatity screen
						CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
						
						Thread.sleep(1000);
						
						//Press the continue Button
						CreateOrder.CreateOrder_Configure_Continue_Button.click();
						
						//Decoration Optional Screen Appear Press the save button now to create a Order
						CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
						
						if(CreateOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
						{
						 System.out.println("Order Created with Multiple Product Search within IDAHO Successfully");
						 resultPass("OrderCreation_WithProductSearchIDAHO", "Order Created with Multiple Product Search within IDAHO Successfully");
						}
						else{
						
							System.out.println("Order Created with Multiple Product Search within IDAHO Unsuccessfully");
							resultFail("OrderCreation_WithProductSearchIDAHO", "Order Created with Multiple Product Search within IDAHO UnSuccessfully");
						}	

					   Thread.sleep(10000);
	
	
	//Canadian Product SubTotal Conversion
		 ConversionsWithoutOtherCharges2.CanadianProduct_Subtotal_String_To_Int_Conversion();
		 
			 
		 //Sales Tax Conversion
		 ConversionsWithoutOtherCharges2.CanadianProduct_SalesTax_String_To_Int_Conversion();
		 
		 
	     //Tax Calculation
		 ConversionsWithoutOtherCharges2.Tax_Calculation_Manual();
		 
		 
		 
		 //Total Amount Tax+Subtotal
		 ConversionsWithoutOtherCharges2.SubTotal_Calculation();
		 
		 
		//Rounding off sum amount
		 ConversionsWithoutOtherCharges2.RoundingOffTotalAmount();
		 
		 
		 //Amount Due Conversions
		 ConversionsWithoutOtherCharges2.CanadianProduct_AmountDue_String_To_Int_Conversion();
		 
		 if(ConversionsWithoutOtherCharges2.bd.doubleValue()==ConversionsWithoutOtherCharges2.AmountDue)
		 {
			 System.out.println("Total Amount Calculated For Muliple Product Search within IDAHO Successfully");
			 resultPass("TotalAmount_Calculation_MultipleProductSearchIDAHO", "Total Amount Calculated For Multiple Product Search within IDAHO Successfully");
		 }
		 else{
			System.out.println("Total Amount Calculated Customer Search IDAHO UnSuccessfully");
			resultFail("TotalAmount_Calculation_MultipleProductSearchIDAHO", "Total Amount Calculated For Multiple Product Search within IDAHO UnSuccessfully");
		 }
		 
	//Conversion TotalCost
		 ConversionsWithoutOtherCharges2.CanadianProduct_TotalCost_String_To_Int_Conversion();
		 
		 //Press the Preview Button on order details
		 CreateOrder.PreviewButton_Orderdetails.click();
		 
		 Thread.sleep(15000);
		 
		 //Press the Purchase Order document
		 CreateOrder.PreviewPopUp_PurchaseOrder.click();
		 
		 Thread.sleep(3000);
		 
		//Select the Purchase Order Option
		 CreateOrder.PreviewPopup_PurchaseOrderSelection.click();
		 
		 Thread.sleep(3000);
		 //First store parent window to switch back
		 String parentWindow1 = driver.getWindowHandle();
		 
		 //Press the Preview Button
		 CreateOrder.PreviewPopUp_PreviewButton.click();
		 
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow1)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	  
		  	Thread.sleep(5000);
		 //Purchase Order Preview Total Conversion
		ConversionsWithoutOtherCharges2.CanadianProduct_PurchaseOrderAmount_String_To_Int_Conversion(); 
		 
		if(ConversionsWithoutOtherCharges2.TotalCost==ConversionsWithoutOtherCharges2.TotalPrice)
		{
			System.out.println("Canadian Purchase Order Preview with Customer Search in IDAHO Total Display Successfully with correct amount");
			resultPass("Canadian_PurchaseOrder_TotalAmount_Calculation_CustomerSearchIDAHO", "Canadian Purchase Order Preview with Customer Search in IDAHO Total Display Successfully with correct amount");
		}
		else{
			System.out.println("Canadian Purchase Order Preview Total with Customer Search in IDAHO Display UnSuccessfully with correct amount");
			resultFail("Canadian_PurchaseOrder_TotalAmount_Calculation_CustomerSearchIDAHO", "Canadian Purchase Order Preview with Customer Search in IDAHO Total Display UnSuccessfully with correct amount");
		}
	   Thread.sleep(2000);
	   
	   driver.close();
  		
  		Thread.sleep(1000);
  	   
  	   //Switch back to parent window 
 	     driver.switchTo().window(parentWindow1);
  		 
  		//AmountDue Conversion
 	  ConversionsWithoutOtherCharges2.CanadianProduct_AmountDue_String_To_Int_Conversion();
 	     
 	 //Press the Purchase Order document
 	 CreateOrder.PreviewPopUp_SalesOrder.click();
 		 
 		 Thread.sleep(3000);
 		 
 		//First store parent window to switch back
 		 String parentWindow2 = driver.getWindowHandle();
 		 
 		 //Press the Preview Button
 		CreateOrder.PreviewPopUp_PreviewButton.click();
 		 
 		//Switch to new window opened
 		  	for(String winHandle : driver.getWindowHandles()){
 		  	    if(!winHandle.equals(parentWindow2)) {
 		  	        driver.switchTo().window(winHandle);
 		  	    }
 		  	}
 		  	  
 		  	Thread.sleep(5000);     
 	     
 	    //Sales Order Preview Total Conversion 
 		ConversionsWithoutOtherCharges2.CanadianProduct_SalesOrder_String_To_Int_Conversion();
 	     
 	    if(ConversionsWithoutOtherCharges2.AmountDue==ConversionsWithoutOtherCharges2.TotalPrice)
 	    {
 	    	System.out.println("Total Amount For Sales Order with Multiple Product Search in IDAHO Calculated Successfully");
 	    	resultPass("Sales Order Calculation_Verification_MultipleProductSearchIDAHO", "Total Amount For Sales Order with Multiple Product Search in IDAHO Calculated Successfully");
 	    }
 	    else{
 	    	System.out.println("Total Amount For Sales Order with Multiple Product Search in IDAHO Calculated UnSuccessfully");
 	    	resultFail("Sales Order Calculation_Verification_MultipleProductSearchIDAHO", "Total Amount For Sales Order with Multiple Product Search in IDAHO Calculated UnSuccessfully");
 	    }
 	     
 	    driver.close();
 	    
 	    Thread.sleep(2000);
 	//Switch back to parent window 
	     driver.switchTo().window(parentWindow2);
  		 
	     Thread.sleep(2000);
  		 
  		 
  	        
  	  
  	  
        
     }
	
	   catch(NoSuchElementException e){
		   e.getStackTrace();
	   }
	}  
	
		
	public static void resultPass(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
				test.log(Status.PASS, sTestName);

			
			 } catch (Exception e)
	{
			 e.printStackTrace();   
	}

	}
	public static void resultFail(String sTestName, String sTestCase) throws IOException, InterruptedException {
		try {
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			   
				test.log(Status.FAIL, sTestName);

		 } catch (Exception e)
	{
			 e.printStackTrace();		 
	}    	
	
	
}
	public static void Hover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
}






}
