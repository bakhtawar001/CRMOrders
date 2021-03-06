package OrdersWESPTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Master.WESPORDER;
import PageFactoryandTestdata.OrdersLocators;

public class SearchOrderByInvoice extends WESPORDER {
	static WebElement ClearField;
	public static  void SearchOrderWithInvoice() throws InterruptedException, IOException, ParseException{
	   	  
	   	  try{
	   		
	   		  OrdersLocators WespOrder = PageFactory.initElements(driver, OrdersLocators.class);
	   		  driver.navigate().refresh();
	   		 Thread.sleep(5000);
    		  String orderID=WespOrder.OrderNumber.getText();
    		  orderID=orderID.replaceAll("[-+.^:,#a-zA-Z]", "");
    		  System.out.println(orderID);
    		  Thread.sleep(2000);
	   		//Go to ESP Web Tab
    		  WespOrder.Order_CreateInvoice.click();
    		  
    		  Thread.sleep(4000);

    		  String InvoiceID=WespOrder.OrderNumber.getText();	
    		  InvoiceID=InvoiceID.replaceAll("[-+.^:,#a-zA-Z]", "");
			   Thread.sleep(3000);
			   System.out.println(InvoiceID);
			   Click("Close the order detail", WespOrder.CloseOrder_Icon);
			   Thread.sleep(6000);

			   WespOrder.OrderlistingSearch.sendKeys(InvoiceID);
			   Thread.sleep(6000);
			   List<WebElement> RecordAfterSearch = WespOrder.GetNoOfRecords;
			   int record=RecordAfterSearch.size();
			   if(record>0)
	       		 {
				   System.out.println("Search By Invoice is working");
	       			 resultPass("Search By Invoice is working", "Search By Invoice is working");
	       		 }
	       		 else{
					   System.out.println("Search By Invoice is not working");

	      			 resultFail("Search By Invoice is not working", "Search By Invoice is not working");
	       		 }
			   WespOrder.CloseOrder_Icon.click();
			  
   	  }
	     
	     catch(NoSuchElementException e)
	   	  {
	   	  e.getStackTrace();
	   	  }
	     }




}
