package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class Dasboard_Orders extends OrdersExecution1 {
	 static OrdersLocators ToolTip = PageFactory.initElements(driver, OrdersLocators.class);
	
	public static void Percentage_square_in_Orders_SummaryWidget_ToolTip_Text_Verification() throws IOException, InterruptedException, AWTException{
		try
		{
			//Go to Dashboard Tab
			ToolTip.Dasboard_Tab.click();
			waitForElementToBeClickable_Xpath(120, driver,ToolTip.Percentage_Dashboard_Icon);
			Thread.sleep(3000);
			Hover(ToolTip.Percentage_Dashboard);
			Thread.sleep(3000);
			Assert.assertTrue(ToolTip.YearlySummary_Percentage_ToolTipText_Verification.isDisplayed());
		}
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
		}
	
	}

	public static void Percentage_circle_inOrdersSummary_Widget_ToolTip_Text_Verification() throws IOException, InterruptedException, AWTException{
		try
		{
			Hover(ToolTip.Ordersummary_Dashboard_Percentage);
			Thread.sleep(3000);
			Assert.assertTrue(ToolTip.OrderSummary_ToolTip_Text_Verification.isDisplayed());
		}
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
		}
	
		finally 
		{
		ToolTip.Orders_Title_Tab.click();
		Thread.sleep(3000);
		}
	}

	


}
