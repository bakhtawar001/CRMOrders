package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;


public class OrderFromIdaho_ThroughProjects extends WESPORDER {

	public static void OrderFromIDAHO_FromProjects() throws InterruptedException, IOException{
		
		try{
			
			  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
		
			//Click the Orders tab
			  WespOrder	.ESPWebHomePage_OrdersTab.click();
			   	 
			  Thread.sleep(5000);
			  
			
			  WespOrder.CreateOrder_SalesOrderOption.click();
			   
			   Thread.sleep(6000);
				 //Select the company first on create order screen
			  WespOrder.CreateOrderScreen_CompanySearch_Textfield.click();
			   	 
			   Thread.sleep(2000);
			   	 
			   WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto-");
			   	 
			   	 Thread.sleep(6000);
			   	//Select company from company dropdown
			   	WespOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
			   	 
			   	//CreateOrder.CreateOrderScreen_CompanySearch_Selection.click();
			   	
			   	Thread.sleep(5000);
			   	
			  //Press Add Product Button
			   	WespOrder. CreateOrder_AddProductButton.click();
			    
			    Thread.sleep(2000);
			    
			    //Go To Product Search Tab in popup
			    WespOrder.AddProduct_ProjectsTab.click();
			    	
			   
			    wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.ProjectsProductSelection));
			    
			    Thread.sleep(8000);
			    
			    //Now Select the Product
			    Click("Selecting projct", WespOrder.ProjectsProductSelection);
			   // WespOrder.ProjectsProductSelection.click();
			    
			    Thread.sleep(5000);
			    
			    //Press the Add Products Button to complete the process
			/*    WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
			    
			    Thread.sleep(3000);*/
			    
                WespOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
			    
			   
			    
			    String ProductAddedToOrderSuccess=WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText();
			    
			    if(ProductAddedToOrderSuccess.contains("Success"))
			    {
			 	   System.out.println("Project Product Added To Order Successfully");
			 	   resultPass("ProjectProduct_Added_To_Order_IDAHO", "Project Product Added To Order Successfully");
			    }
			    else{
			 	   System.out.println("Project Product Added To Order UnSuccessfully");
			 	   resultFail("ProjectProduct_Added_To_Order_IDAHO", "Project Product Added To Order UnSuccessfully");
			    }
			    Thread.sleep(10000);
			    
			  //Hover the configure button
			  /*  WebElement HoverConfigure= WespOrder.CreateOrders_ConfigureButton;
				Hover(HoverConfigure);
				
				Thread.sleep(1000);
				
				//Now Click the Configure Button
				 WespOrder.CreateOrders_ConfigureButton.click();*/
			    Click("A", WespOrder.CreateOrders_ConfigureButton);
				
			    
				Thread.sleep(2000);
				  if(WespOrder.CreateOrder_Configure_QTY_TextField.isDisplayed()) {
						Thread.sleep(2000);
						WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");

		  		  }
				  else {
						Thread.sleep(2000);
		  			  Click("Click at Select button of price grid", WespOrder.ClickAtSelect);
		  			Thread.sleep(2000);
						WespOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
				  }
				//Enter The Quantity on Quatity screen
			
				
				Thread.sleep(1000);
				
				if(driver.getCurrentUrl().contains("stage"))	
		  		{
		  		 //Press the continue Button
		  		 WespOrder.CreateOrder_Configure_Continue_Button.click();
		  		 
		  		 Thread.sleep(1000);
		  		 
		  		//Decoration Optional Screen Appear Press the save button now to create a Order
					WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
					
					Thread.sleep(1000);
		  		}
		  		else{
		  		//Press the continue Button
			  		 WespOrder.CreateOrder_Configure_Continue_Button.click();
			  		 
			  		 Thread.sleep(1000);
		  			
		  			//Decoration Optional Screen Appear Press the save button now to create a Order
					WespOrder.CreateOrder_DecoratorScreen_Save_Button.click();
			  		 
			  		 Thread.sleep(1000);
		  		}
	
				if(WespOrder.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"))
				{
				 System.out.println("Order Created Successfully through Projects in IDAHO");
				 resultPass("OrderCreation_ThroughProjects_IDAHO", "Order Created Successfully through Projects in IDAHO");
				}
				else{
				
					System.out.println("Order Created UnSuccessfully through Projects in IDAHO");
					resultFail("OrderCreation_ThroughProjects_IDAHO", "Order Created UnSuccessfully through Projects in IDAHO");
				}	
				Thread.sleep(9000);
				
				//Close the current order
				  WespOrder.CloseOrder_Icon.click();
				   	 
				  Thread.sleep(3000);
				 
				 //Go to ESP Web Tab
		   		  WespOrder.ESPWeb_Tab.click();
		   		  
		   		wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.WESP_ProjectTab));
			    
			    Thread.sleep(2000);
		   		  
		   		//Go to Projects tab in esp web
		   		 WespOrder.WESP_ProjectTab.click();
		   		  
		   		wait = new WebDriverWait(driver, 180);
			    wait.until(ExpectedConditions.elementToBeClickable(WespOrder.Projects_SavedProductsTab));
		   		  
		   		//Go to Saved Products tab
		   		  WespOrder.Projects_SavedProductsTab.click();
		   		  
		   		 Thread.sleep(10000);
		   		  
		   		  //Now Delete the Project Product 
			  	     WespOrder.Projects_ProductCheckBox.click();
			  	     
			  	     Thread.sleep(3000);
			  	     
			  	     WespOrder.Projects_ProductDelete.click();
			  	     
			  	     Thread.sleep(3000);
			  	     
			  	 //Press the Okay Button to confirm project product deletion
			  	     WespOrder.Projects_ProductDeleteConfirm.click();
			  	     
			  	     Thread.sleep(12000);
			  	        
		   		  
		   		  


	}

	catch(NoSuchElementException e)
	{
	e.getStackTrace();
	}
	}
















}
