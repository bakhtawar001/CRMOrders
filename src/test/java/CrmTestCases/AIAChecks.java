package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;

public class AIAChecks extends HelpingFunction  {
	
public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void Login_ParentAdmin() throws InterruptedException, AWTException, IOException
	{
		  test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			SoftAssert assertion =new SoftAssert();
	    	if(driver.getCurrentUrl().contains("uat"))
	    	 {
	    		Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINo_Corp);
	    		Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.Username_Corp);
	    		Input("Please Enter Password", GetData.Password, CrmTestData.Password_Corp);
	    		Click("Please click login button",GetData.LoginButton);
	    	 }
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	}
	
	public static void VerifyEmailNotifications_TurnOff_ParentAdmin() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("Please click at aviator",GetData.aviator);
		 Click("Please click at Settings",GetData.settings);
		 Thread.sleep(5000);
		 List<WebElement> ElementCount =GetData.TurnOffNotifications;
		
		 System.out.println(ElementCount.size());
		 Thread.sleep(2000);
		 Assert.assertTrue(ElementCount.size()==0);
		
		
	}
	public static void VerifyInAPPNotifications_TurnOff_ParentAdmin() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		
		 List<WebElement> ElementCount =GetData.TurnOffNotificationsInApp;
		
		 System.out.println(ElementCount.size());
		 Thread.sleep(2000);
		 Assert.assertTrue(ElementCount.size()==0);
		
		
	}
	
	public static void ChildLogin() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 GetData.OrderListing_UserInfoIcon.click();
	 	 Click("Click on Logout",GetData.LogoutButton);
		 Thread.sleep(5000);
	 	if(driver.getCurrentUrl().contains("uat"))
	 	 {
	 		Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINo_Child);
	 		Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.Username_Child);
	 		Input("Please Enter Password", GetData.Password, CrmTestData.Password_Child);
	 		Click("Please click login button",GetData.LoginButton);
	 	 }
	 	else
   		{
   			Assert.assertTrue(false);
   		}
	}
	public static void VerifyEmailNotifications_TurnOff_ChildAdmin() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Thread.sleep(5000);
		 Click("Please click at aviator",GetData.aviator);
		 Click("Please click at Settings",GetData.settings);
		 Thread.sleep(5000);
		 List<WebElement> ElementCount =GetData.TurnOffNotifications;
		
		 System.out.println(ElementCount.size());
		 Thread.sleep(2000);
		 Assert.assertTrue(ElementCount.size()==0);
		
		
	}
	public static void VerifyInAPPNotifications_TurnOff_ChildAdmin() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		
		 List<WebElement> ElementCount =GetData.TurnOffNotificationsInApp;
		
		 System.out.println(ElementCount.size());
		 Thread.sleep(2000);
		 Assert.assertTrue(ElementCount.size()==0);
		
		
	}
	
	public static void AIA_CustomProductCategories() throws InterruptedException, AWTException, IOException
	{
		 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("Click to Orders tab",CreateOrder.ESPWebHomePage_OrdersTab);
		 Thread.sleep(10000);
		 Click("Click orders title tab",CreateOrder.Orders_Title_Tab);
		 Click("Click Sales Orders",CreateOrder.CreateOrder_SalesOrderOption);
			
		 Click("Add New Product dropdown Icon",CreateOrder.CreateCustomProduct_CreateIcon);
		 Click("Add New Product",CreateOrder.NewProduct_Link_CustomPro);
	
		  List<String> options= Arrays.asList("Clocks","Printing Consumables","Memo Pad & Paper Holders","Beverage Holders","Toys","Badge & Button Accessories/Finding","Custom Products","Gloves","Antibacterial Products",
				  "Kits","Awards","Travel Amenities","Umbrellas","Blankets","Caps & Hats","Markers","Highlighters","Pencils","Trade Show Displays","Special Packaging","AUTO ACCESSORIES","BAG","BUSINESS FORMS","CALENDARS",
				  "CLOTHING","COMPUTER ACCESSORIES","DECALS","DESK ACCESSORIES","ELECTRONIC DEVICES","FOOD GIFTS","GAMES","JEWELRY","LABELS","LETTERHEAD & STATIONERY","MAGNETS","MAKE-UP/COSMETICS","PENS","SHIRTS",
				  "SPORTS EQUIPMENT & ACCESS","TOOLS-KITCHEN","TOWELS","TRAVEL MUGS/CUPS","WATCHES","CLOCKS","PRINTING CONSUMABLES","MEMO PAD & PAPER HOLDERS","BEVERAGE HOLDERS","TOYS","BADGE & BUTTON ACCESSORIES/FINDINGS",
				  "CUSTOM PRODUCTS-General","GLOVES","ANTIBACTERIAL PRODUCTS","Kits-Grooming","TRAVEL AMENITIES","Awards-Trophies","UMBRELLAS","BLANKETS","CAPS & HATS","MARKERS","HIGHLIGHTERS","PENCILS","TRADE SHOW DISPLAYS",
				  "SPECIAL PACKAGING");
		 Click("Add New Product",CreateOrder.CategoryDropDown);
		
		  int i = 1;
		          for (String option : options) {
		        	  Input("Search Categories", CreateOrder.SearchCategories, option);
		        	 
		              String val=driver.findElement(By.xpath("//span[contains(@class,'ui-select-highlight')]")).getText();
		            if(val=="")
		           break;
		              Assert.assertEquals(option.equalsIgnoreCase(val), true);
		                  i++;
		                 
		              }
		      }
		
}

	

