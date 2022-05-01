package OrdersTestcases;

import java.awt.AWTException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Functions.Conversions;
import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;



public class OrderDeletion extends OrdersExecution1 
{
     static OrdersLocators  DeleteOrder = PageFactory.initElements(driver, OrdersLocators.class);
	 public static String Projectpath;
	 public static void PayWith_ElectronicFundsOption_DropdownVerification() throws IOException, InterruptedException, AWTException{
       try
       {
		
        	Click("Click order home page", DeleteOrder.ESPWebHomePage_OrdersTab);
        	Click("Click order button", DeleteOrder.OrdersScreen_OrderButton);
        	//Select the Sales Order option from toggle dropdown
        	Click("Click  button", DeleteOrder.CreateOrder_SalesOrderOption);
        	Thread.sleep(5000);
        	Assert.assertTrue(driver.getPageSource().contains("Electronic Funds Transfer"));
        }
       catch(NoSuchElementException e)
        {
        	e.getStackTrace();
        }
	} 
        public static void ShipVia_LoomisGroundOption_DropdownVerifcation() throws IOException, InterruptedException{
    	try
    	   {
    		   Assert.assertTrue(driver.getPageSource().contains("Loomis Ground"));
		   
    	   }
    	   catch(NoSuchElementException e)
    	   {
    	   e.getStackTrace();
    	   }
	   
        }
        
       public static void OrderSaving_WithoutSalesPerson_Validation_Verification() throws InterruptedException, IOException{
    	   try 
    	   {
    		   SoftAssert softAssertion= new SoftAssert();
    		   Click("Click the Remove (X) for Sales Person Remove", DeleteOrder.SalesPerson_Remove_FromOrder_Icon);
    		   Thread.sleep(2000);
    		   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
    		   Thread.sleep(3000);
    		   Assert.assertTrue(DeleteOrder.OrderSaving_WithoutSalesPerson_Validation_Verification.isDisplayed());
    		   DeleteOrder.SalesPerson_Validation_Check_OK_Button.click();
    		   Thread.sleep(1000);
    		   Click("Please click on close button to close order", DeleteOrder.CloseOrder_Icon);
    		   Thread.sleep(3000);
    		   Click("Please click on close button to close order", DeleteOrder.CloseOrderAfterEditing_Button);
    		   Thread.sleep(3000);
    		   softAssertion.assertAll();
    		   
    	   }
    	   catch(NoSuchElementException e)
    	   {
    		   e.getMessage();
    	   }
       
     
       }

        public static void UploadDSTFile_Orderlevel() throws IOException, InterruptedException, AWTException{
    	try
    	  {
    		  SoftAssert softassertion=new SoftAssert();
    		  Click("a", DeleteOrder.ESPWebHomePage_OrdersTab);
    		   Thread.sleep(10000);
    			Click("a", DeleteOrder.CreateOrder_SalesOrderOption);
    		   //Select the company first on create order screen
    		   DeleteOrder.CreateOrderScreen_CompanySearch_Textfield.click();
    		   Thread.sleep(2000); 
    		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
    		   Thread.sleep(6000);
    		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
    		   Thread.sleep(1000);
    		   //Select company from company dropdown
    		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
    		   Thread.sleep(2000);
    		   //Press the save button
    		   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
    		   waitForPageLoadSave();
    		   // Thread.sleep(2000);
    		   //waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
    		   Thread.sleep(6000);
    		   DeleteOrder.PushMenu.click();
    		   Thread.sleep(2000);
    		   DeleteOrder.UploadFile.click();
    		   Thread.sleep(3000);
    		   Projectpath=System.getProperty("user.dir");
    		   System.out.println(Projectpath);
    		   Runtime.getRuntime().exec(Projectpath+"/Img/DST.exe");
       		
       			Thread.sleep(5000);
    		/*   ProcessBuilder pb = new ProcessBuilder(Projectpath+"/Img/upload.exe", Projectpath+"\\Img\\foil.DST");
    		   Thread.sleep(5000);
    		   pb.start();
    		   Thread.sleep(15000);*/
    		   waitForPageLoading();  
    		   Thread.sleep(8000);
    		   Assert.assertTrue(DeleteOrder.DSTFileVerification.isDisplayed());
    		   softassertion.assertAll();
    		   DeleteOrder.PushMenu.click();
    		   Thread.sleep(2000);
    		   Conversions.OrdernumberRegularExpressionStringConversion();
    		   String dir=System.getProperty("user.dir");
    	       System.out.println(dir);
    	       String filepath= dir+"\\OrdersID.xlsx";
    		   File file= new File(filepath);
    		   FileOutputStream fos=new FileOutputStream(file);
    		   //create the blank workbook
    		   Workbook wb= new XSSFWorkbook();
    		   //create the blank excel sheet
    		   Sheet sh= wb.createSheet("OrderID");
    		   //define the position in the excel sheet where write operation needs to perform
    			Row rw0= sh.createRow(0);
    			Row rw1= sh.createRow(1);
    			// OrderID
    			 Cell cl00=rw0.createCell(0);
    			 Cell cl10=rw1.createCell(0);		 
    			 cl00.setCellValue("OrderID");
    			 cl10.setCellValue( Conversions.Orderno);
    			 wb.write(fos);	
    	  }
    	catch(NoSuchElementException e)
    	{
    		  e.getStackTrace();
    	}

      }
        public static void UploadSVG() throws InterruptedException, IOException{
      	  try
      	  {
      		  DeleteOrder.PushMenu.click();
      		  Thread.sleep(2000);
      		  DeleteOrder.UploadFile.click();
      		  Thread.sleep(3000);
      		  Projectpath=System.getProperty("user.dir");
      		  System.out.println(Projectpath);
      		  Runtime.getRuntime().exec(Projectpath+"/Img/ordersSVG.exe");
    		
      		
      		  Thread.sleep(15000);
      		  Assert.assertTrue(DeleteOrder.SVGFileVerification.isDisplayed());

      	  }
      	  catch(NoSuchElementException e)
      	  {
      		  e.getStackTrace();
      	  
      	  }
        finally
        {
      	  DeleteOrder.PushMenu.click();
  	      Thread.sleep(2000);
        }
        
        }
        
      public static void InvalidFileUpload_ErrorMessageVerification() throws InterruptedException, IOException{
      try
      {
    	  SoftAssert softassertion=new SoftAssert();
		  Click("a", DeleteOrder.ESPWebHomePage_OrdersTab);
		   Thread.sleep(10000);
		   DeleteOrder.CreateOrder_SalesOrderOption.click(); 
		   //Select the company first on create order screen
		   DeleteOrder.CreateOrderScreen_CompanySearch_Textfield.click();
		   Thread.sleep(2000); 
		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys("Auto Supplier ASIQA I");
		   Thread.sleep(6000);
		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ARROW_DOWN);
		   Thread.sleep(1000);
		   //Select company from company dropdown
		   DeleteOrder.CreateOrderScreen_CompanyField_SendData.sendKeys(Keys.ENTER);
		   Thread.sleep(2000);
		   //Press the save button
		   Click("Click at save button", DeleteOrder.SampleRequestSaveButton);
		   waitForPageLoadSave();
		   // Thread.sleep(2000);
		   //waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
		   Thread.sleep(6000);
		   Conversions.OrdernumberRegularExpressionStringConversion();
		   DeleteOrder.PushMenu.click();
		   Thread.sleep(2000);
		   DeleteOrder.UploadFile.click();
		   Thread.sleep(3000);
		   Projectpath=System.getProperty("user.dir");
		   System.out.println(Projectpath);
		   Runtime.getRuntime().exec(Projectpath+"/Img/orderstest.exe");
      		
		   Thread.sleep(5000);
		   Assert.assertTrue(DeleteOrder.TitleMesg.getText().contains("Error"));
	

      }
      catch(NoSuchElementException e)
    	  {
    		  e.getStackTrace();
    	  
    	  }
      finally 
      {
    	  DeleteOrder.PushMenu.click();
	      Thread.sleep(2000);
      }
      
      }
      
      public static void Upload_AIExtension_File() throws InterruptedException, IOException{
    	try
    	{
    		  DeleteOrder.PushMenu.click();
    		  Thread.sleep(2000);
    		  DeleteOrder.UploadFile.click();
    		  Thread.sleep(3000);
    		  Projectpath=System.getProperty("user.dir");
    		  System.out.println(Projectpath);
    		  Runtime.getRuntime().exec(Projectpath+"/Img/orderssample.exe");
      		
      			Thread.sleep(5000);
    		/*  ProcessBuilder pb = new ProcessBuilder(Projectpath+"/Img/upload.exe", Projectpath+"\\Img\\Sample.ai");
    		  Thread.sleep(5000);
    		  pb.start();
    		  Thread.sleep(15000);*/
    		  waitForPageLoading(); 
    		  Thread.sleep(12000);
    		  Assert.assertTrue(DeleteOrder.AIFileVerification.isDisplayed());

    	  }
    	catch(NoSuchElementException e)
    	  {
    		  e.getStackTrace();
    	  
    	  }
     finally 
      {
    	  DeleteOrder.PushMenu.click();
	      Thread.sleep(2000);
      }
      
      }
      
      
      public static void CustomProducts_SupplierSelection_Dropdown_Verification() throws InterruptedException, IOException{
		 try
		  {
			/* DeleteOrder.PushMenu.click();
		      Thread.sleep(2000);*/
			 //Press the Custom Product Option
			  DeleteOrder.CreateCustomProduct_CreateIcon.click();
			  DeleteOrder.NewProduct_Link_CustomPro.click();
			  Thread.sleep(3000);
			  //Validate if the Supplier Selection Dropdown occurs or not
			  Assert.assertTrue(DeleteOrder.CustomProduct_SupplierDropdown_Verification.isDisplayed());
			
		  }
		 catch(NoSuchElementException e)
		 {
			  e.getMessage();
			  
		  }
	  }
	  
     public static void cogWheelIcon_CustomProducts_Verification() throws IOException, InterruptedException{
    	 try
    	 {
    		 SoftAssert softassertion=new SoftAssert();
    		 int li = DeleteOrder.CogWheelIcon_CustomProducts.size();
    		 Thread.sleep(2000);
    		 softassertion.assertTrue(li>0);
    		 softassertion.assertAll();
    		 JavascriptExecutor je = (JavascriptExecutor) driver;
    		 // now execute query which actually will scroll until that element is not appeared on page.
    		 je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[contains(@translate,'BUTTONS.CANCEL')]")));
    		 //Press the Cancel Button
    		 Click("Click on cancel button ",DeleteOrder.CustomProduct_Popup_Cancel_Button);
    		 // DeleteOrder.CustomProduct_Popup_Cancel_Button.click();
 			 Thread.sleep(3000);
    
    	 
    	 }
    	 catch(NoSuchElementException e)
    	 {
    		 e.getMessage();
    	 }
     
     }
      
      
      public static void DeleteOrder() throws InterruptedException, IOException{
    	try
		  {
    		//Press the more button
    		Click("Click at more button", DeleteOrder.Orderdetails_MoreButton);
    		Thread.sleep(1000);
    		//Press the Delete Order Button
    		Click("Click at more button",  DeleteOrder.Orderdetails_MoreButton_DeleteOrder);
    		Click("Click at more button",    DeleteOrder.DeleteOrder_Okbutton);
    		//waitForElementNotVisible(120, driver,DeleteOrder.SpinnerLoader);
    		waitForPageLoading();
    		Thread.sleep(2000);
    		DeleteOrder.CloseAndExit.click();
    		System.out.println("Order Deleted Successfully");
        }
	
	   catch(NoSuchElementException e)
    	{
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
    	}
	}  
	
	  
}
