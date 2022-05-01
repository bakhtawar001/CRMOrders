package OrdersTestcases;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;


public class EditOrderProduct_Configuration extends OrdersExecution1 {
    
	static List<WebElement> rows;
	static int count;
	static OrdersLocators EditOrderConfiguration = PageFactory.initElements(driver, OrdersLocators.class);
	public static void OrderProductConfig_NewAddCharge_in_Configuration_With_Amount_Verification() throws IOException, InterruptedException, ParseException{
    try
    {
		  
	    Click("Press the Back Button",EditOrderConfiguration.Backbutton1);	   
        Thread.sleep(3000);
        Click("Close Popup", EditOrderConfiguration.ClosePreviewPopup);
	   	Thread.sleep(2000);
	   	
	   //	String text=EditOrderConfiguration.GrossSubTotal.getText();
	 /*  List<	WebElement> gross=driver.findElements(By.xpath("//tr[contains(@class,'subtotals')]/following-sibling::tr[1]/descendant::td/p[contains(@class,'ng-binding')]/text()[1]"));
	   int j=gross.size();
	   String i=gross.get(0).getText();
	   System.out.println(i);*/
	   //Converting subtotal from string to int
	   	 Conversions.Subtotal_String_To_Int_Conversion();
	   //Calculating Tax
	   	 Conversions.Tax_Calculation_Automatic();
	    // Conversions.Tax_Calculation_Manual();
	   	//Sales Tax Conversion from String to integer with $ removing done 
	     Conversions.SalesTax_String_To_Int_Conversion();
	     //Calculating the SubTotal
	   	 Conversions.SubTotal_Calculation();
	   //Rounding off the value SubTotal and Sum tax
	   	 Conversions.RoundingOffTotalAmount();	 
	   //Now Converting the Amountdue from string to Int
	   	Conversions.AmountDue_String_To_Int_Conversion();
	   //Now Validating the Total Amount due 
	   if(Conversions.bd.doubleValue()==Conversions.AmountDue)
	   	 {
	   		 System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is correct");
	   	 }
	   	 else{
	   		System.out.println("Total Amount Due:"+""+Conversions.TotalAmountDueWithTaxInclude+""+"is not correct");
	   	 }
	   Click("a", EditOrderConfiguration.OrdersDetails_EditButton);
	   waitForElementNotVisible(120, driver,EditOrderConfiguration.SpinnerLoader);
	   Thread.sleep(1000);
	   //Press the Add Charge Button
	 	EditOrderConfiguration.ProductConfiguration_AddChargeLinkText.click();
	 	Thread.sleep(2000); 	
	 	//Add the Quantity
	 	EditOrderConfiguration.ProductConfiguration_AddCharge_QTY.click();
	 	EditOrderConfiguration.ProductConfiguration_AddCharge_QTY.sendKeys("1");
	 	//Add the Netcost
	 	EditOrderConfiguration.ProductConfiguration_AddCharge_NetCost.click();
	 	EditOrderConfiguration.ProductConfiguration_AddCharge_NetCost.sendKeys("50");
	 	EditOrderConfiguration.ProductConfiguration_AddCharge_NetCost.click();
	 	//Press the save button
	 	Click("Click Save button", EditOrderConfiguration.ProductConfiguration_AddCharge_SaveButton);
	 	waitForElementNotVisible(120, driver,EditOrderConfiguration.SpinnerLoader);
	 	Thread.sleep(2000);
	 	//Converting subtotal from string to int
	   	 Conversions.Subtotal_String_To_Int_Conversion();
	   //Calculating Tax	
	     Conversions.Tax_Calculation_Automatic();
	  //Sales Tax Conversion from String to integer with $ removing done 
	     Conversions.SalesTax_String_To_Int_Conversion();
	   //Calculating the SubTotal
	   	 Conversions.SubTotal_Calculation();
	   //Rounding off the value SubTotal and Sum tax
	   	 Conversions.RoundingOffTotalAmount();
	   //Now Converting the Amountdue from string to Int
	   	Conversions.AmountDue_String_To_Int_Conversion();
	   	Thread.sleep(5000);
	   //Now Validating the Total Amount due 
	   	Assert.assertEquals(Conversions.bd.doubleValue(),Conversions.AmountDue);
    }
    catch(NoSuchElementException e)
    {
           
             e.getMessage();
           }
	}       
	 
	public static void AddVendor_Charge_With_Amount_calculation() throws InterruptedException, IOException, ParseException{
	try
	{
	 	
	 //Click the Edit button
	   Click("a", EditOrderConfiguration.OrdersDetails_EditButton);
	   waitForElementNotVisible(120, driver,EditOrderConfiguration.SpinnerLoader);
	   Thread.sleep(2000);
       EditOrderConfiguration.EditProduct_ShowAllVendorChargesButton.click();
       Thread.sleep(2000);
       EditOrderConfiguration.VendorCharges_LessThanMinimumAddButton.click();
       Thread.sleep(2000);
	 	//Add the Net Cost 50
       EditOrderConfiguration.ProductConfiguration_VendorChargeNetCost.click();
       EditOrderConfiguration.ProductConfiguration_VendorChargeNetCost.sendKeys("50");
	 	//Press the save Button
       WebElement el = EditOrderConfiguration.ProductConfiguration_AddCharge_SaveButton;
	   Actions builder = new Actions(driver);
	   builder.moveToElement( el ).click( el );
	   builder.perform();
	 	//EditOrderConfiguration.ProductConfiguration_AddCharge_SaveButton.click();
	   waitForElementNotVisible(120, driver,EditOrderConfiguration.SpinnerLoader);
	 	//Converting subtotal from string to int
	   Conversions.Subtotal_String_To_Int_Conversion();
	   //Calculating Tax	
	   Conversions.Tax_Calculation_Automatic();
	  //Sales Tax Conversion from String to integer with $ removing done 
	   Conversions.SalesTax_String_To_Int_Conversion();
	   //Calculating the SubTotal
	   Conversions.SubTotal_Calculation();
	   //Rounding off the value SubTotal and Sum tax
	   Conversions.RoundingOffTotalAmount();
	   //Now Converting the Amountdue from string to Int
	   	Conversions.AmountDue_String_To_Int_Conversion();
	   	Thread.sleep(5000);
	   //Now Validating the Total Amount due 
	   	Assert.assertEquals(Conversions.bd.doubleValue(),Conversions.AmountDue);
	
      }
       catch (NoSuchElementException e) 
	{
			// TODO: handle exception
          	 System.err.println("NoSuchElementException: " + e.getMessage());
     }
	
	}
	public static void EditProductModal_Configurationtab_VariantAttributesVerification() throws InterruptedException, IOException{
   	 try{
   		 Click("Click to cancel import line item screen",EditOrderConfiguration.CancelImportLineItemScreen);    
   		 Click("Click To Close Order Screen",EditOrderConfiguration.CloseOrder_Icon_SampleRequest);
   		 //CreateOrder.ESPWebHomePage_OrdersTab.click();
   		 Thread.sleep(2000);
   		 EditOrderConfiguration.OrderlistingSearch.sendKeys(Conversions.Orderno);
   		 //waitForPageLoading();
   		 Thread.sleep(2000);
   		 Click("Select Order",EditOrderConfiguration.OrderListing_Orderselection);
   		 Click("Click on Edit button",  	EditOrderConfiguration.OrdersDetails_EditButton);
		
	 	 waitForElementNotVisible(120, driver, 	EditOrderConfiguration.SpinnerLoader);
	 	
	    Thread.sleep(2000);
	   // EditOrderConfiguration.ProductConfiguration_SKU.sendKeys("1");
	    WebElement el = 	  EditOrderConfiguration.ProductConfiguration_SKU;
	    Actions builder = new Actions(driver);
		builder.moveToElement( el ).click( el );
		builder.perform();
	    
   		 Thread.sleep(2000);
   		 Assert.assertTrue(EditOrderConfiguration.ProductConfiguration_VariantAttributes.isDisplayed());
   		
   		 WebElement QTY = 	   EditOrderConfiguration.ProductConfiguration_QTY;
   		 Actions builder1 = new Actions(driver);
   		 builder1.moveToElement( QTY ).click( QTY );
   		 builder1.perform();
   		 List<WebElement> VariantAttributes=driver.findElements(By.xpath("//th[contains(text(),'Variant Attributes')]"));
   		 int QTYSize=VariantAttributes.size();
   		 System.out.println(QTYSize);
   		 Thread.sleep(2000);
   		 Assert.assertTrue(QTYSize==0);
   		 
   		 WebElement description = 	  EditOrderConfiguration.ProductConfiguration_Description;
   		 Actions Dbuilder = new Actions(driver);
   		 Dbuilder.moveToElement( description ).click( description );
   		 Dbuilder.perform();
   		 Thread.sleep(2000);
    	Assert.assertTrue(EditOrderConfiguration.ProductConfiguration_VariantAttributes.isDisplayed());
    	
    	 WebElement Cost = 	   EditOrderConfiguration.ProductConfiguration_Cost;
   		 Actions Cbuilder = new Actions(driver);
   		 builder1.moveToElement( Cost ).click( Cost );
   		 builder1.perform();
   		 List<WebElement> VariantAttributes_Cost=driver.findElements(By.xpath("//th[contains(text(),'Variant Attributes')]"));
   		 int VariantAttributesSize=VariantAttributes_Cost.size();
   		 System.out.println(VariantAttributesSize);
   		 Thread.sleep(2000);
   		 Assert.assertTrue(VariantAttributesSize==0);
	
              }
              catch (NoSuchElementException e) {
				// TODO: handle exception
             	 System.err.println("NoSuchElementException: " + e.getMessage());
              }
	}
	
   	public static void EditProductModal_Configurationtab_AddLineItem_VariantAttributesVerification() throws InterruptedException, IOException{
      	 try
      	 {
      		 
      		 WebElement el = EditOrderConfiguration.ProductConfiguration_SKU;
      		 Actions builder = new Actions(driver);
      		 builder.moveToElement( el ).click( el );
      		 builder.perform();
      		 Click("Add Line Item",EditOrderConfiguration.ProductConfiguration_AddLineItem);
      		 Click("Add Line Item",EditOrderConfiguration.Addlineitem_ProductConfiguration_SKU);
      		 List<WebElement> VariantAttributes_AddLineItem=driver.findElements(By.xpath("//th[contains(text(),'Variant Attributes')]"));
      		 int VariantAttributesSize=VariantAttributes_AddLineItem.size();
      		 System.out.println(VariantAttributesSize);
      		 Thread.sleep(2000);
      		 Assert.assertTrue(VariantAttributesSize>0);

            }
          catch (NoSuchElementException e) 
      	 {
   				// TODO: handle exception
                	 System.err.println("NoSuchElementException: " + e.getMessage());
          }
   }

   	public static void EditProductModal_Configurationtab_ClearVariants() throws InterruptedException, IOException{
     	 try
     	 {
     		 Click("Clear Variants",EditOrderConfiguration.EditOrder_Configuration);
     		Thread.sleep(2000);
     		 Click("Clear Variants",EditOrderConfiguration.ProductConfiguration_ClearAll);
     		 Click("POA Page",EditOrderConfiguration.ProductConfiguration_ClearVariants);
     		Thread.sleep(2000);
     		 Assert.assertTrue(EditOrderConfiguration.POA.isDisplayed());
     		 
     		 

           }
         catch (NoSuchElementException e) 
     	 {
  				// TODO: handle exception
               	 System.err.println("NoSuchElementException: " + e.getMessage());
         }
     	
  }


}



















