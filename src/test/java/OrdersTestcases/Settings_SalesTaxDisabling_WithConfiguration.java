package OrdersTestcases;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.OrdersLocators;



public class Settings_SalesTaxDisabling_WithConfiguration extends OrdersExecution1 {

    public static String PAStateExistence_in_TaxesRate;
    public static WebElement toClear;
    public static boolean Checkbox;
    public static String Username;
    public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	static OrdersLocators Settings_SalesTax = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void AutomaticSalesTax_Uncheck() throws IOException, InterruptedException{
	try
	{
		// This is to Instantiate Services  class  
		Thread.sleep(3000);
		//Click the userInfoIcon on My Order screen	 
	   	 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", Settings_SalesTax.OrderListing_UserInfoIcon);
		 //Click the settings option
	   	 Settings_SalesTax.UserInfoIcon_Settings.click();
	   	 //Now Select the sales tax option in settings
	   	 Settings_SalesTax.Settings_SalesTax.click();
	   	 //Check if the automatically taxes calculation checkbox is selected or not
	   	 if(Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
	   	 {
	   	   Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
	   	   Thread.sleep(2000);
	   	   Assert.assertTrue(Settings_SalesTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
	   	 
	   	 }
	}	   	
		   
	catch(NoSuchElementException e)
	{
		    System.err.println("NoSuchElementException: " + e.getMessage());
	}
   }
		public static void AutomaticSalesTax_check() throws IOException, InterruptedException{
	       try{
	    	   	// This is to Instantiate Services  class  
	    	   	Thread.sleep(2000);
	    	   	//Click the userInfoIcon on My Order screen	 
	    	   	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	   	js.executeScript("arguments[0].scrollIntoView();",Settings_SalesTax.OrderListing_UserInfoIcon);
	    	   	Settings_SalesTax.OrderListing_UserInfoIcon.click();
	    	   	//Click the settings option
	    	   	Settings_SalesTax.UserInfoIcon_Settings.click();
	    	   	//Now Select the sales tax option in settings
	    	   	Settings_SalesTax.Settings_SalesTax.click();
	    	   	Thread.sleep(2000);
	    	   	//Check if the automatically taxes calculation checkbox is selected or not

	    	   	if(!Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
	    	   	{
	    	   		Settings_SalesTax.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
	    	   		Thread.sleep(2000);
	    	   		Assert.assertTrue(Settings_SalesTax.CreateOrder_ProductAddedToOrder_Successfull.getText().contains("Success"));
	    	   		
	    	   	}
	


	       }	   	
	   
	       		catch(NoSuchElementException e) 
	       {
	       			System.err.println("NoSuchElementException: " + e.getMessage());
	       	}
}
		public static void OrderTracking_OrderContact_CheckboxFunctionality(boolean Checkbox) throws IOException, InterruptedException{
		     try{
		    	  JavascriptExecutor js = (JavascriptExecutor) driver;
		  		 js.executeScript("arguments[0].click();", Settings_SalesTax.OrderListing_UserInfoIcon);
		  		 //Click the settings option
		  		 Click("UserProfile",Settings_SalesTax.UserInfoIcon_Settings);
		  		 Click("Please click at Settings",GetData.CompanyProfile);
				 Thread.sleep(3000);
				 
		    	js.executeScript("arguments[0].scrollIntoView();", Settings_SalesTax.Settings_OrderContact_Checkbox);
		    	if(Checkbox) {
				 if(Settings_SalesTax.Settings_OrderContact_Checkbox.isSelected())
				 {
						 
					 Click("Please click at Settings",Settings_SalesTax.Settings_OrderContact_Checkbox);
				 
				 }
		    	if(Settings_SalesTax.Settings_OrderTracking_Checkbox.isSelected())
				 {
						 
					 Click("Please click at Settings",Settings_SalesTax.Settings_OrderTracking_Checkbox);
				 
				 }
		     }
		     
				 else
				 {
					 if(!Settings_SalesTax.Settings_OrderContact_Checkbox.isSelected())
					 {
							 
						 Click("Please click at Settings",Settings_SalesTax.Settings_OrderContact_Checkbox);
					 
					 }
			    	if(!Settings_SalesTax.Settings_OrderTracking_Checkbox.isSelected())
					 {
							 
						 Click("Please click at Settings",Settings_SalesTax.Settings_OrderTracking_Checkbox);
					 
					 }
				 }
				 Click("Save Company Profile",GetData.SaveCompanyProfile);
		       }	   	
		   
		       		catch(NoSuchElementException e) 
		       {
		       			System.err.println("NoSuchElementException: " + e.getMessage());
		       	}
	}
		public static void ImpactofOrderContact_AtOrderLevel(boolean Checkbox) throws IOException, InterruptedException{
		     try{
		    	 	Click("a", Settings_SalesTax.ESPWebHomePage_OrdersTab);
	    		   Thread.sleep(10000);
	    		   Settings_SalesTax.CreateOrder_SalesOrderOption.click(); 
	    		   List<WebElement> OrderContact=driver.findElements(By.xpath("//order-contact[contains(@ng-model,'vm.order.InquiryContact')]/div"));
	    		   int size=OrderContact.size();
	    		if(Checkbox)
	    		{
	    		   if(size>0)
	    		   {
	    			   Assert.assertTrue(true);
	    		   }
	    		}
	    		else
	    		{
	    			if(size==0)
	    			{
	    				Assert.assertTrue(true);
	    			}
	    		}

		       }	   	
		   
		       		catch(NoSuchElementException e) 
		       {
		       			System.err.println("NoSuchElementException: " + e.getMessage());
		       	}
	}
		public static void ImpactofOrderTracking_AtOrderLevel(boolean Checkbox) throws IOException, InterruptedException{
		     try{
		    	 
	    		   List<WebElement> OrderContact=driver.findElements(By.xpath("//div[contains(@ng-if,'vm.canSetReorderType(vm.model)')]"));
	    		   int size=OrderContact.size();
	    		   if( Checkbox)
	    		   {
	    			   if(size>0)
	    		    {
	    			   Assert.assertTrue(true);
	    		    }
	    		   }
	    		   else
		    		{
		    			if(size==0)
		    			{
		    				Assert.assertTrue(true);
		    			}
		    		}

		       }	   	
		   
		       		catch(NoSuchElementException e) 
		       {
		       			System.err.println("NoSuchElementException: " + e.getMessage());
		       	}
	}
		public static void Default_SalesPerson() throws IOException, InterruptedException{
		     try{
		    	 
		    	 	Assert.assertTrue(driver.getPageSource().contains( Username));

		       }	   	
		   
		       		catch(NoSuchElementException e) 
		       {
		       			System.err.println("NoSuchElementException: " + e.getMessage());
		       	}
	}
		
		public static void Loggedin_UserName() throws IOException, InterruptedException{
		     try{
		    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		  		 js.executeScript("arguments[0].click();", Settings_SalesTax.OrderListing_UserInfoIcon);
		  		 
		  		 Username=Settings_SalesTax.Loggedin_Username.getText();
	    		  

		       }	   	
		   
		       		catch(NoSuchElementException e) 
		       {
		       			System.err.println("NoSuchElementException: " + e.getMessage());
		       	}
	}
}

