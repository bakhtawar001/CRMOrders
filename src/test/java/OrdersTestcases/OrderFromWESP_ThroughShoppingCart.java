package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class OrderFromWESP_ThroughShoppingCart extends WESPORDER{

	
	public static void OrderFromWESP_FromShoppingCart() throws InterruptedException, IOException{
	
	try{
		
		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	
	
	//Close the current order
	  WespOrder.CloseOrder_Icon.click();
	   	 
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
	  
	  //Press the shopping cart Icon
	  WespOrder.ShoppingCart_Icon.click();
	  
	  Thread.sleep(2000);
	  
	  //Select the product now in shopping cart
	  WespOrder.ShoppingCart_ProductSelection_Checkbox.click();
	  
	  Thread.sleep(2000);
	  
	//First store parent window to switch back
		 String parentWindow = driver.getWindowHandle();
	  
	  
	  
	  WespOrder.ShoppingCart_OrderButton.click();
	  
	  Thread.sleep(15000);
	  
	//Switch to new window opened
	  	for(String winHandle : driver.getWindowHandles()){
	  	    if(!winHandle.equals(parentWindow)) {
	  	        driver.switchTo().window(winHandle);
	  	    }
	  	}
	  	
	  //Select the company first on create order screen
	  	WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
	   	 
	   	 Thread.sleep(2000);
	   	 
	   	WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
	   	 
	   	 Thread.sleep(6000);
	   	//Select company from company dropdown
	   	WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
	   	 
	   	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
	   	
	   	Thread.sleep(12000);
	  	
	  	
	  //Validating as if the Order Created Successfully Or Not From WESP
	 if(WespOrder.OrderCreation_FromWESP_Verification.isDisplayed())
	 {
		 System.out.println("Order Created from WESP through Shopping Cart Successfully");
		 resultPass("OrderCreation_FromWESP_ShoppingCart", "Order Created from WESP through Shopping Cart Successfully");
	 }
	 else{
		 System.out.println("Order Created from WESP through Product Searching UnSuccessfully");
		 resultFail("OrderCreation_FromWESP_ShoppingCart", "Order Created from WESP through Shopping Cart UnSuccessfully");
	 }

	 //Close new Browser Tab
	 driver.close();
	 
	 Thread.sleep(2000);
	 
	 //Switch back to parent window 
   driver.switchTo().window(parentWindow);
      

	  
	  


}

catch(NoSuchElementException e)
{
e.getStackTrace();
}
}















}
