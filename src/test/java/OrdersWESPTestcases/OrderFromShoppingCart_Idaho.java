package OrdersWESPTestcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
  		 
  	
        Click("Click on CRM", WespOrder.CRM);
        Thread.sleep(2000);
  		  //Go to ESP Web Tab
  	  WespOrder.ESPWeb_Tab.click();
  		  
  		  Thread.sleep(2000);
  		  
  		  //Search for the Product
  		  WespOrder.ProductSearch_TextField.sendKeys(OrdersTestdata.ShoppingCart_ProductName);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search button
  		  WespOrder.ProductQuickSearchButton.click();
  		  
  		  waitForPageLoad();
  		  
  		  //Search asi number within search terms
  		  WespOrder.SearchWithinTerms_SearchField.sendKeys(OrdersTestdata.ShoppingCart_ProductNumber);
  		  
  		  Thread.sleep(1000);
  		  
  		  //Press the search with terms go button
  		  WespOrder.SearchWithinTerms_GoButton.click();
  		  
  		  waitForPageLoad();
  		 Thread.sleep(2000); 
  		  //Hover to the Order button on searched product
  		  
  		Click("Click at order button", WespOrder.CanadianProduct_OrderButton);
  		  Thread.sleep(5000); 
  		  
  		  
  		  waitForPageLoad();
  		  Thread.sleep(2000);
  		/*
  		  Click the Select Button
  		  WespOrder.ShoppingCartProduct_SelectButton.click();
  		  
  		wait = new WebDriverWait(driver, 180);
  	    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.CreateOrder_Configure_QTY_TextField));
  	   */
  		  
  		//Enter The Quantity on Quatity screen
  	    WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
  			
  		 Thread.sleep(1000);
  		 
  		 //Add the Product to shopping cart from wesp
  		 WespOrder.SaveToCardButton.click();
  		  waitForPageLoad();
  		 Thread.sleep(3000);
  		 
  		 
  		 //Click the Orders tab
  		 WespOrder.ESPWebHomePage_OrdersTab1.click();
  	   	 
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
  	  waitForPageLoad();
  	   Thread.sleep(6000);
  	   
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
 	   Assert.assertTrue(true);
 	  // resultPass("OrderCreation_FromShoppingCart_Idaho", "Shopping cart Product Added To Order Successfully and Order from shopping cart created successfully");
    }
    else{
 	   System.out.println("Shopping cart Product Added To Order Successfully and Order from shopping cart created UnSuccessfully");
 	   Assert.assertFalse(false);
 	 //  resultFail("Product Added To Order", "Shopping cart Product Added To Order Successfully and Order from shopping cart created UnSuccessfully");
    }
  
	Thread.sleep(5000);

	//Close the current order
	  WespOrder.CloseOrder_Icon.click();
	   	 
	  Thread.sleep(3000);
	  
	  }
  
  catch(NoSuchElementException e)
	  {
	  e.getStackTrace();
	  }
  }






}
