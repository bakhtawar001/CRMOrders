package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderFromShoppingCart_Idaho extends WESPORDER{
	public static JavascriptExecutor jse;
	public static JavascriptExecutor jse1;
	public static JavascriptExecutor jse2;
	public static JavascriptExecutor jse3;
	public static JavascriptExecutor jse4;
	public static void ShoppingCartOrder_FromIdaho() throws InterruptedException, IOException{
		
  	  try{
  		
  		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
  		 
  		  
  		
        
        Thread.sleep(3000);
  		  
  		  //Go to ESP Web Tab
  		  WespOrder.ESPWeb_Tab.click();
  		  
  		  Thread.sleep(5000);
  		  
  		  //Search for the Product
  		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.ShoppingCart_ProductName);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search button
  		  WespOrder.ProductQuickSearchButton.click();
  		  
  		  Thread.sleep(10000);
  		  
  		  //Search asi number within search terms
  		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.ShoppingCart_ProductNumber);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search with terms go button
  		  WespOrder.SearchWithinTerms_GoButton.click();
  		  
  		  Thread.sleep(12000);
  		  
  		  //Hover to the Order button on searched product
  		  
  		  WebElement HoverOrder=WespOrder.CanadianProduct_OrderButton;
  		  Hover(HoverOrder);
  			
  		  Thread.sleep(1000); 
  		  
  		  //Click the E-Comm order button now
  		  WespOrder.CanadianProduct_OrderButton.click();
  		  
  		  Thread.sleep(5000);
  		  
  		  //Click the Select Button
  		
  		  WespOrder.ShoppingCartProduct_SelectButton.click();
  		  
  		wait = new WebDriverWait(driver, 180);
  	    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_Configure_QTY_TextField));
  	   
  	   Thread.sleep(2000);
  		  
  		//Enter The Quantity on Quatity screen
  	    WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
  			
  		 Thread.sleep(1000);
  		 
  		 //Add the Product to shopping cart from wesp
  		 WespOrder.SaveToCardButton.click();
  		 
  		 Thread.sleep(6000);
  		 
  		 
  		 //Click the Orders tab
  		 WespOrder.ESPWebHomePage_OrdersTab.click();
  	   	 
  	   	 Thread.sleep(5000);
  	   	 
  	   //Click the Create new Order button
  	  // WespOrder.OrdersScreen_OrderButton.click();
  		   
  	  // Thread.sleep(2000);
  	   
  	//Select the Sales Order option from toggle dropdown
  	 WespOrder.CreateOrder_SalesOrderOption.click();
	   
	   Thread.sleep(4000);
  		 //Select the company first on create order screen
  		 WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
  	   	 
  	   	 Thread.sleep(2000);
  	   	 
  	   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
  	   	 
  	   	 Thread.sleep(6000);
  	   	//Select company from company dropdown
  	   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
  		 
  	   Thread.sleep(15000);
  	   
  	//Press Add Product Button
  	 WespOrder. CreateOrder_AddProductButton.click();
  	   
  	   Thread.sleep(2000);
  	   
  	   //Go To Product Search Tab in popup
  	 WespOrder.ProductSearch_ShoppingCart_Idaho_Tab.click();
  	 
  	wait = new WebDriverWait(driver, 180);
    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.ProductSearch_ShoppingCart_Idaho_Selection));
    
    Thread.sleep(6000);
	Click("Product Selection", WespOrder.ProductSearch_ShoppingCart_Idaho_Selection);
//    WespOrder.ProductSearch_ShoppingCart_Idaho_Selection.click();
    
    Thread.sleep(2000);
    
    //Press the Add Products Button to complete the process
    WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
    
    
 	
    String ProductAddedToOrderSuccess=WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
    
    if(ProductAddedToOrderSuccess.contains("Success"))
    {
 	   System.out.println("Shopping cart Product Added To Order Successfully and Order from shopping cart created successfully");
 	   resultPass("OrderCreation_FromShoppingCart_Idaho", "Shopping cart Product Added To Order Successfully and Order from shopping cart created successfully");
    }
    else{
 	   System.out.println("Shopping cart Product Added To Order Successfully and Order from shopping cart created UnSuccessfully");
 	   resultFail("Product Added To Order", "Shopping cart Product Added To Order Successfully and Order from shopping cart created UnSuccessfully");
    }
    Thread.sleep(10000);
	  
  
	Click("a", WespOrder.CreateOrders_ConfigureButton);
	Thread.sleep(2000);
	
	//Enter The Quantity on Quatity screen
	WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
	
	Thread.sleep(1000);
	
	//Press the continue Button
	//WespOrder.CreateOrder_Configure_Continue_Button.click();
	
	//Decoration Optional Screen Appear Press the save button now to create a Order
	WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
	
	if(WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
	{
	 System.out.println("Order Created Successfully through Shopping Cart in IDAHO");
	 resultPass("OrderCreation_ThroughShoppingCart_IDAHO", "Order Created Successfully through Shopping Cart in IDAHO");
	}
	else{
	
		System.out.println("Order Created UnSuccessfully through Shopping Cart in IDAHO");
		resultFail("OrderCreation_ThroughShoppingCart_IDAHO", "Order Created UnSuccessfully through Shopping Cart in IDAHO");
	}	
	Thread.sleep(9000);
	  
	  }
  
  catch(NoSuchElementException e)
	  {
	  e.getStackTrace();
	  }
  }






}
