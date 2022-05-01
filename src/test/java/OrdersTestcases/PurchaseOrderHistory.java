package OrdersTestcases;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;

public class PurchaseOrderHistory extends OrdersExecution1 {
	public static String OrdernoPO;
	static OrdersLocators POHistory = PageFactory.initElements(driver, OrdersLocators.class);
	
	public static  void PurchaseOrder_POSend_POHistroy() throws InterruptedException, IOException
	{
		try
		{
			POHistory.ClosePreviewPopup.click();
			Thread.sleep(2000);
			POHistory.SampleRequestSaveButton.click();
			Thread.sleep(5000);
			POHistory.Cancel.click();
			Thread.sleep(5000);
			POHistory.PO_HistoryTab.click();
			POHistory.SearchPO_HistoryTab.sendKeys(Conversions.Orderno);
			String OrdernoPOHistory=POHistory.PO_verify_HistoryTab.getText();
			System.out.println(OrdernoPOHistory+'\n');
			 OrdernoPO=OrdernoPOHistory.replaceAll("[-+.^:,#a-zA-Z]","");
			 Thread.sleep(2000);
			//Assert.assertEquals(OrdernoPO,Conversions.Orderno);
			 Assert.assertEquals(OrdernoPO,Conversions.Orderno);
			 
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
	}
	public static  void VerifyOrder_CRM() throws InterruptedException, IOException
	{
		try
		{
			
			 Thread.sleep(2000);
			 POHistory.CRM.click();
			 Click("Please click at add company button", POHistory.NavigatetoCompanies);
			 POHistory.CRM_Supplier.click();
			 Thread.sleep(2000);
			 POHistory.Search_Supplier.sendKeys("Auto Supplier ASIQA I");
			 Thread.sleep(2000);
			 POHistory.Select_order.click();
			 POHistory.CRM_Orders.click();
			// POHistory.PO_HistoryTab.click();
			// List<WebElement> ordertablebeforesearch=driver.findElements(By.xpath("//table[contains(@ng-table,'vm.orderTable')]"));
			 List<WebElement> ordertablebeforesearch=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'order in $data')]"));
			 int  tablesizebefore= ordertablebeforesearch.size();
			 System.out.println(tablesizebefore+'\n');
			 Thread.sleep(2000);
			 POHistory.Search_Orders.sendKeys(Conversions.Orderno);
			 Thread.sleep(2000);
			 
			 List<WebElement> ordertableaftersearch=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'order in $data')]"));
			 int  tablesizeafter= ordertableaftersearch.size();
			 System.out.println(tablesizeafter+'\n');
			 
			 Assert.assertNotEquals(tablesizebefore, tablesizeafter);
			
			
			
		}
		catch(NoSuchElementException e)
		{
			e.getMessage();
		}
	}
	

}
