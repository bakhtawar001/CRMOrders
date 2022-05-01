package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class CopyImportLineItem extends OrdersExecution1 {
	
	static OrdersLocators CopyLineItem = PageFactory.initElements(driver, OrdersLocators.class);	
	
	
	public static void Copy_LineItem() throws IOException, InterruptedException, AWTException
	{
        try{
        	SoftAssert assertion =new SoftAssert();
        	Thread.sleep(2000);
        	Click("a",CopyLineItem.CancelSendWindow);
        	Thread.sleep(2000);
        	String ProductDetailBeforeCopy=CopyLineItem.ProductDetail.getText();
        	System.out.println(ProductDetailBeforeCopy +'\n');
        	Thread.sleep(2000);
        	Click("Click Copy of line item",CopyLineItem.CopyLineItem);
        	waitForPageLoadSave();
        	Assert.assertTrue(CopyLineItem.LineItemCopiedandAdded.isDisplayed());
        	assertion.assertAll();
        	String ProductDetailAfterCopy=CopyLineItem.CopiedProductDetail.getText();
        	System.out.println(ProductDetailAfterCopy +'\n');
        	Thread.sleep(2000);
        	Assert.assertEquals(ProductDetailBeforeCopy, ProductDetailAfterCopy);
        	
        }
        
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }

	}
	public static void VerifyContent_CopyLineItem() throws IOException, InterruptedException, AWTException
	{
        try{
        	
        	SoftAssert assertion =new SoftAssert();
        	Click("a",CopyLineItem.EditCopiedLineItem);
        	waitForPageLoading();
        	Click("a",CopyLineItem.EditOrder_DecorationTab);
        	String CopiedArtfile=CopyLineItem.EditOrder_Decoration_Artwork_Existence_Verification.getText();
        	System.out.println(CopiedArtfile +'\n');
        	Assert.assertEquals(CopiedArtfile, CreateOrder.ArtworkfileBeforeCopy);
        	assertion.assertAll();
        	Click("Click on shipping tab",CopyLineItem.Shipping_Tab);
        	Thread.sleep(2000);
        	String ShipFromAfterCopy=CopyLineItem.ShippingFromaddressBeforeCopyLineItem.getText();
        	System.out.println(ShipFromAfterCopy+'\n');
        	Assert.assertEquals(ShipFromAfterCopy, CreateOrder.ShipFromBeforeCopyLineItem);
        	String ShipToAfterCopy=CopyLineItem.ShippingToaddressBeforeCopyLineItem.getText();
        	System.out.println(ShipToAfterCopy+'\n');
        	Assert.assertEquals(ShipToAfterCopy, CreateOrder.ShippingToaddressBeforeCopyLineItem);
        	JavascriptExecutor je = (JavascriptExecutor) driver;
    	    je.executeScript("arguments[0].scrollIntoView(true);",CopyLineItem.CreateOrder_DecoratorScreen_Save_Button);
    	    Click("Click to save decorator",CopyLineItem.CreateOrder_DecoratorScreen_Save_Button);
    	    Thread.sleep(2000);
        	
        	
        	
        }
        
        catch(NoSuchElementException e)
        {
        	e.getMessage();
        }

	}
	
}
