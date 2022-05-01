package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class ImportLineItem extends OrdersExecution1{
	public static String CustomerCompanyName;
	public static boolean Customername=true;
static OrdersLocators ImportLineItem = PageFactory.initElements(driver, OrdersLocators.class);	
	
	
	public static void Import_LineItem() throws IOException, InterruptedException, AWTException
	{
        try{
        		SoftAssert assertion=new SoftAssert();
        		Conversions.CreateOrder2ImportLineItem();
        		CreateOrder.AddProductConfiguration_Order();
        		CustomerCompanyName=ImportLineItem.SelectCompany.getText();
        		System.out.println(CustomerCompanyName);
        		List<WebElement> LineItemBeforeImport=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]"));
        		int LineItemBeforeImportSize= LineItemBeforeImport.size();
        		System.out.println(LineItemBeforeImportSize);
        		Click("Click on Import Line Item",ImportLineItem.ImportLineItem);
        		ImportLineItem.SearchLineItem.sendKeys(Conversions.Orderno);
        		String SearchedLineItem=ImportLineItem.VerifySearchehLineItemByOrderNo.getText();
        		System.out.println(SearchedLineItem);
        		SearchedLineItem=SearchedLineItem.replaceAll("[-+.^:,#a-zA-Z]","");
        		SearchedLineItem=SearchedLineItem.trim();
        		System.out.println(SearchedLineItem+'\n');
        		
        		Assert.assertEquals( SearchedLineItem,Conversions.Orderno);
        		Thread.sleep(2000);
        		Click("Click on OrderLine",ImportLineItem.ClickOrderLine);
        		Thread.sleep(2000);
        		Click("a",ImportLineItem.SelectOrderLine);
        		//ImportLineItem.SelectOrderLine.isSelected();
        		
        		assertion.assertAll();
        		Click("a",ImportLineItem.ImportLineItembutton);
        		waitForPageLoading();
        		Thread.sleep(5000);
        		//List<WebElement> LineItemAfterImport=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]"));
        		List<WebElement> LineItemAfterImport=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]"));
        		int LineItemAfterImportSize= LineItemAfterImport.size();
        		System.out.println(LineItemAfterImportSize+'\n');
        		Thread.sleep(2000);
        		Assert.assertTrue(LineItemAfterImportSize>1);
        		//Assert.assertNotEquals(LineItemAfterImportSize, LineItemBeforeImportSize);
        		
        		
        	
        }
        
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }

	}
	public static void SelectCurrentCustomerOnly() throws IOException, InterruptedException, AWTException
	{
        try{
        		
        	Click("Click on Import Line Item",ImportLineItem.ImportLineItem);
        	if(!ImportLineItem.SelectCurrentCustomerOnly.isSelected())
        	
        	{
        		Click("Click on Current Customer Only",ImportLineItem.SelectCurrentCustomerOnly);
        	}
        	Select filter=new Select(driver.findElement(By.xpath("//select[contains(@ng-model,'vm.configs.filter.type')]")));
        	filter.selectByVisibleText("Quote");
        	List<WebElement> ImportLineItemTableSize=driver.findElements(By.xpath("//tr[contains(@ng-repeat-start, 'order in $data')]/td[4]"));
        	int ImportTableSize=ImportLineItemTableSize.size();
        	
        	
        	System.out.println(ImportTableSize);
        	for(int i=0;i<ImportTableSize;i++)
        	{
        		String CustomerName=ImportLineItemTableSize.get(i).getText();
        		System.out.println(CustomerName);
        		//	String CustomerName=driver.findElement(By.xpath(ImportLineItem.BeforeXpath_Customer+ i + ImportLineItem.AfterXpath_Customer)).getText();
        			
        	 if (CustomerName.equalsIgnoreCase(CustomerCompanyName));
        		 
        	 {
        		 Assert.assertTrue(Customername);
        	 }
        	 
        	}
        }
        
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }

	}
	
	public static void DefaultDropDownValue() throws IOException, InterruptedException, AWTException
	{
        try{
        		String DefaultFilterValue=ImportLineItem.DefaultFilter.getText();
        		System.out.println(DefaultFilterValue);
        		Thread.sleep(2000);
        		Assert.assertTrue(DefaultFilterValue.contains("All"));
        		
        
        }
        
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }

	}

}
