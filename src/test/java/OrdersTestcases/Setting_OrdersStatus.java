package OrdersTestcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;

public class Setting_OrdersStatus extends OrdersExecution1 {

	static OrdersLocators Settings_orderstatus = PageFactory.initElements(driver, OrdersLocators.class);
	public static void Create_NewOrderStatus() throws IOException, InterruptedException
	
	
	{
		try
		{
			 //Click the order status option 
			Click("Select Status Option",Settings_orderstatus.Settings_OrderStatus);
			 //Click to add order status option 
			 Click("Add Status",Settings_orderstatus.Settings_AddOrderStatus);
			 Input("Provide Status", Settings_orderstatus.Settings_Ordername,OrdersTestdata.orderstatusname);
			 Click("Select Color",Settings_orderstatus.Settings_Orderstatus_SelectColor);
			 Settings_orderstatus.Settings_Ordernotes.sendKeys(OrdersTestdata.orderstatuswithnotes);
			 Click("Save Settings", Settings_orderstatus.Settings_Orderstatus_savebutton);
			 Thread.sleep(2000);
			 Assert.assertTrue(driver.findElement(By.xpath("//strong[contains(text(),'"+OrdersTestdata.orderstatusname+"')]")).isDisplayed());
			
		 
		}
		catch(NoSuchElementException e) {
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	    }
	}
	
	public static void CreateOrder_OrderStatusDropdown() throws IOException, InterruptedException
	
	
	{
		try
		{
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			
			 //Click the order status option 
			Click("Drop Down",Settings_orderstatus.Orderdetailpage_OrderStatusDropdown);
			 //Click to add order status option 
			 String selectstatus=driver.findElement(By.xpath("//a[contains(.,'"+OrdersTestdata.orderstatusname+"')]")).getText();
			 System.out.print(selectstatus+'\n');
			 String selectstatusremovespace=selectstatus.trim();
			 System.out.print(selectstatusremovespace);
			 Thread.sleep(2000);
			 Assert.assertEquals(selectstatusremovespace, OrdersTestdata.orderstatusname);
			 
			
		}
		catch(NoSuchElementException e) {
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	    }
	}
public static void CreateOrder_NewOrderStatus_NotesVerification() throws IOException, InterruptedException
	
	
	{
		try
		{
			SoftAssert soft=new SoftAssert();
			//Notes Verification while selecting orders status
			driver.findElement(By.xpath("//a[contains(.,'"+OrdersTestdata.orderstatusname+"')]")).click();
			Thread.sleep(2000);
			 String NotesVerificationdropdown=Settings_orderstatus.Ordersdetail_OrdernotesVerification.getAttribute("value");
			 System.out.print(NotesVerificationdropdown+'\n');
			 Thread.sleep(2000);
			 Assert.assertEquals(NotesVerificationdropdown,OrdersTestdata.orderstatuswithnotes);
			 soft.assertAll();
			 Click("Save status",Settings_orderstatus.Settings_OrderstatusForm_savebutton);
			 Thread.sleep(6000);
			 //Notes verification in notes push menu
			 Click("Notes Push Menu",Settings_orderstatus.Pushmenu_notes);
			 Thread.sleep(2000);
			 String notesverificationpushmenu= Settings_orderstatus.Pushmenu_NotesVerification.getText();
			 System.out.print(notesverificationpushmenu+'\n');
			 //String notesverification=driver.findElement(By.xpath("//div[contains(text(),'"+OrdersTestdata.orderstatuswithnotes+"')]")).getText();
			 Thread.sleep(3000);
			 Assert.assertEquals(notesverificationpushmenu, OrdersTestdata.orderstatuswithnotes);
			 soft.assertAll();
			 Click("Notes Push Menu",Settings_orderstatus.Pushmenu_notes);
		}
		catch(NoSuchElementException e) {
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	    }
	}
}
