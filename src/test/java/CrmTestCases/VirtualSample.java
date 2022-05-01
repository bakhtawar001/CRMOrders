package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;

public class VirtualSample extends HelpingFunction {
	static String parentWindow;
	static String SearchVS;
	static JavascriptExecutor  js = (JavascriptExecutor) driver;
	
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	
	public static void CreateVirtualSample_Admin() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		// waitForPageLoading();
		 Click("ESP WEb", GetData.ESPWeb);
		 waitForPageLoading();
		 Thread.sleep(7000);
		 Click("Advanced Search", GetData.AdvanceSearch);
		 
		 js.executeScript("arguments[0].scrollIntoView();",GetData.VirtualSampleLabel );
		 if(!GetData.VirtualSampleCheckbox.isSelected());
		 {
			 Click("Select virtual sample Checkbox",GetData.VirtualSampleCheckbox);
		 }
		 Click("Search",GetData.SearchButton);
		 waitForPageLoading();
		 parentWindow = driver.getWindowHandle();
		 WebElement VSicon =GetData.VirtualSampleIcon;
		 VSicon.findElements(By.xpath("//div[contains(@ng-repeat,'product in items track by product.TrackingId')]/descendant::i")).get(0).click();
		//Switch to new window opened
		  	for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		  	WebDriverWait wait = new WebDriverWait(driver, 500);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[contains(text(),'Initializing Design Studio')]")));
		  	Thread.sleep(3000);
		  	
		  	 List<WebElement> VSNotFound =driver.findElements(By.xpath("//img[contains(@class,'design-image img-responsive')]"));
		 	 int size=VSNotFound.size();
		 	 System.out.println(size);
		 	 if(size>=2)
		 	 {
		        	Click("Click on Image",GetData.VirtualSampleImage);
		        	WebElement AddText=GetData.AddText;
		   		 	AddText.findElements(By.xpath("//div[contains(@class,'text-center ng-scope col-xs-6')]/descendant::div[contains(@ng-click,'vm.activateTab(tab)')]")).get(0).click();
		   		 	Click("Save Virtual Sample",GetData.VSSaveButton);
		   		 	Input("Provide VS name",GetData.VSName,CrmTestData.VirualSampleName);
		   		 	Click("Click Customer",GetData.CustomerName);
		   		 	Thread.sleep(2000);
		   		 	Input("Provide Customer name",GetData.ProvideCustomerName,CrmTestData.Company);
		   		 	Thread.sleep(3000);
		   		 	GetData.ProvideCustomerName.sendKeys(Keys.ENTER);
		   		 	Thread.sleep(2000);
		   		 	Click("Save Design",GetData.SaveDesign);
		   		 	Thread.sleep(5000);
		   		 	WebDriverWait wait1 = new WebDriverWait(driver, 500);
					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@ng-class,'blockUiMessageClass')]")));
				  	Thread.sleep(3000);
		   		 	driver.close();
		   	     
		   	        Thread.sleep(3000);
		   	        
		   	      //Switch back to parent window 
		   	        driver.switchTo().window(parentWindow);
		   	        
		   	        Click("CRM Tab" ,GetData.CRM);
		   	        Thread.sleep(5000);
		   	     
		   	        Click("Design Tab",GetData.DesignTab);
		   	        Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		   	        
		   	        Thread.sleep(2000);
		   	        
		   	        String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
		   	        System.out.println(SearchVS);
		   	        Thread.sleep(2000);
		   	        Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found");
		   	        Click("My Design",GetData.MyDesign);
		   	        Input("Search created design in My design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		   	        Thread.sleep(2000);
		   	        Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found");
		 	 }
		  	
		 	 else
		 	 {
		 	
				 WebElement AddText=GetData.AddText;
				 AddText.findElements(By.xpath("//div[contains(@class,'text-center ng-scope col-xs-6')]/descendant::div[contains(@ng-click,'vm.activateTab(tab)')]")).get(0).click();
				 Click("Save Virtual Sample",GetData.VSSaveButton);
				 Input("Provide VS name",GetData.VSName,CrmTestData.VirualSampleName);
				 Click("Click Customer",GetData.CustomerName);
				 Thread.sleep(2000);
				 Input("Provide Customer name",GetData.ProvideCustomerName,CrmTestData.Company);
				 Thread.sleep(3000);
				 GetData.ProvideCustomerName.sendKeys(Keys.ENTER);
				 Click("Save Design",GetData.SaveDesign);
				 Thread.sleep(5000);
					WebDriverWait wait1 = new WebDriverWait(driver, 500);
					wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@ng-class,'$_blockUiMessageClass')]")));
				 driver.close();
			        Thread.sleep(3000);
			      //Switch back to parent window 
			        driver.switchTo().window(parentWindow);
			        
			        Click("CRM Tab" ,GetData.CRM);
			        Thread.sleep(5000);
			     
			        Click("Design Tab",GetData.DesignTab);
			        Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
			        
			        Thread.sleep(2000);
			        String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
			        System.out.println(SearchVS);
			        Thread.sleep(2000);
			        Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found");
			        Click("My Design",GetData.MyDesign);
			        Input("Search created design in My design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
			        Thread.sleep(2000);
			        Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found");
		 	 }
	        
	     /*   List<WebElement> VSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
	        int size=VSNotFound.size();
	        System.out.println(size);
	        if(size==0)
	        {
	        String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
	        System.out.println(SearchVS);
	        Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found");
	        }
	        else
	        {
	        	Assert.assertTrue(false);
	        }*/ 
	}
	
		public static void EditVirtualSample() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(3000);
			 Click("Design Tab",GetData.DesignTab);
			 Thread.sleep(3000);
			Click("Click Edit Icon",GetData.EditMyDesign);
			Input("Provide VS name",GetData.VSName,CrmTestData.EditVirualSampleName);
			Thread.sleep(2000);
			if(!GetData.SelectOnlytheRecordCreator.isSelected());
			{
				Click("Select Only the Record Creator",GetData.SelectOnlytheRecordCreator);
			}
			Thread.sleep(2000);
			Click("Save Design After Edit",GetData.SaveMyDesign);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Edit Design')]")));
			Input("Search created design in My design tab",GetData.SearchDesign,CrmTestData.EditVirualSampleName);
			Thread.sleep(2000);
			List<WebElement> EditVSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
		 	 int size=EditVSNotFound.size();
		 	 System.out.println(size);
		 	 if(size==1)
		 	 {
	        	Assert.assertTrue(false);
	        	
		 	 }
		 	 else
		 	 {
		 		String SearchEditedVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.EditVirualSampleName+"')]")).getText();
			    System.out.println(SearchEditedVS);
			    Thread.sleep(2000); 
			    Verify(SearchEditedVS, CrmTestData.EditVirualSampleName,"Virtual Sample Not Found");
		 	 }
			
		    
			 
		 	
			 
		}
		public static void EditVirtualSampleByAdmin_VisibilityRecordOwner_ValidateAtNonadmin() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Click("User info Icon",GetData.OrderListing_UserInfoIcon);
		 	 Click("Click on Logout",GetData.LogoutButton);
		 	 Thread.sleep(2000);
		 	 Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINONAdmin);
		 	 Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USERNONAdmin);
		 	 Input("Please Enter Password", GetData.Password, CrmTestData.PASSNONAdmin);
		 	 Click("Please click login button",GetData.LoginButton);
		 	//..
		 	 Thread.sleep(2000);
		 	 Click("a",GetData.CRM);
		 	 Click("Design Tab",GetData.DesignTab);
		     Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.EditVirualSampleName);
		     Thread.sleep(2000);
		 	 List<WebElement> VSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
		 	 int size=VSNotFound.size();
		 	 System.out.println(size);
		 	 if(size==1)
		 	 {
	        	Assert.assertTrue(true);
		 	 }
		 	 Click("My Design",GetData.MyDesign);
		     Input("Search created design in My design tab",GetData.SearchDesign,CrmTestData.EditVirualSampleName);
		     Thread.sleep(2000);
		 	List<WebElement> MyDesignVSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
		 	 int MyDesignSize=MyDesignVSNotFound.size();
		 	 System.out.println(MyDesignSize);
		 	 if(MyDesignSize==1)
		 	 {
	        	Assert.assertTrue(true);
		 	 }
		     
		 	
		}
		
		public static void CreateVirualSampleByNonAdmin_VerifyUnderCompany_ByfiltersMyDesign_ValidateAtadmin() throws InterruptedException, AWTException, IOException
		{
			test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Thread.sleep(15000);
			Click("a",GetData.OrderListing_UserInfoIcon);
		 	Click("Click on Logout",GetData.LogoutButton);
		 	Thread.sleep(2000);
			Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASI);
			Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USER);
			Input("Please Enter Password", GetData.Password, CrmTestData.PASS);
			Click("Please click login button",GetData.LoginButton);
			 Thread.sleep(3000);
			Click("a",GetData.CRM);
			Click("Please click at add company button",GetData.NavigatetoCompanies);
			 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
 			 Thread.sleep(3000);
			 GetData.CompDetails.click();
			 Click("Design tab",GetData.Designs);
			Thread.sleep(3000);
			Click("Virtual Sample",GetData.CRMCompanyDesign);
			Thread.sleep(3000);
			Click("Virtual Sample",GetData.CRMCompanyDesign);
			Click("FilterDropDown",GetData.CompFilterDropDown);
			Click("My Design",GetData.MyDesignFilter);
			Thread.sleep(3000);
			Input("Provide Design Name",GetData.CRMCompanySearchDesign,CrmTestData.VirualSampleName);
			Thread.sleep(2000);
			List<WebElement> MyDesignVSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
			int MyDesignSize=MyDesignVSNotFound.size();
			System.out.println(MyDesignSize);
			 	 if(MyDesignSize==1)
			 	 {
		        	Assert.assertTrue(true);
			 	 }
			/*	String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
			    System.out.println(SearchVS);
			     Thread.sleep(2000);
			    Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found in All Design Tab");*/
			    
		     
		     
		    
		}
		
		public static void CreateVirualSampleByNonAdmin_VisibilityofVirtualSample_With_Everyone_ValidateAtadmin() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 
			// Create VS from non Admin
			CreateVirtualSample_Admin();
		
			 Thread.sleep(2000);
			 Click("a",GetData.CRM);
			 Thread.sleep(2000);
			 Click("Design Tab",GetData.DesignTab);
		     Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		     Thread.sleep(2000);
		     List<WebElement> VSFound =driver.findElements(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]"));
		 	 int size=VSFound.size();
		 	 System.out.println(size);
		 	 if(size==1)
		 	 {
		 		String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
			    System.out.println(SearchVS);
			    Thread.sleep(2000);
			    Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found in All Design Tab");
		 	 }
		 	 
		 	 Click("My Design",GetData.MyDesign);
		     Input("Search created design in My design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		     Thread.sleep(2000);
		 	 List<WebElement> VSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
		 	 int MyDesignSize=VSNotFound.size();
		 	 System.out.println(size);
		 	 if(MyDesignSize==1)
		 	 {
	        	Assert.assertTrue(true);
		 	 }
		     
		     
		     
		    
		}
		public static void SendDesign() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Click("Design Tab",GetData.DesignTab);
			Thread.sleep(2000);
		    Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		    Thread.sleep(2000);
			Click("Send Design" ,GetData.SendDesignButton);
			WebElement RemoveEmail=GetData.CloseIcon;
			if(RemoveEmail.isDisplayed())
			{
				driver.findElements(By.xpath("//span[contains(@class,'close ui-select-match-close')]")).get(0).click();
			}
			Input("Provide Email Address",GetData.ToEmailAddress,CrmTestData.ProvideEmailAddress);
			GetData.ToEmailAddress.sendKeys(Keys.ENTER);
			Click("Send Design",GetData.SendDesign);
			Thread.sleep(2000);
			Assert.assertTrue(GetData.Success.isDisplayed());
		}
		public static void CreateOrderByVirtualSample() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Thread.sleep(2000);
			Click("Click Order" ,GetData.VirtualSampleOrder);
			 waitForPageLoading();
			List<WebElement> VirtualSampleProduct=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]"));
    		int VirtualSampleProductDisplay= VirtualSampleProduct.size();
    		System.out.println(VirtualSampleProductDisplay);
    		Thread.sleep(2000);
			Assert.assertTrue(VirtualSampleProductDisplay>0);
		}
		public static void CreateOrderBySelectVirtualSample() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Thread.sleep(3000);
			 Click("Close Orders Screen",GetData.CloseOrder_Icon);
			 Thread.sleep(3000);
			 Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
			if(!GetData.SelectVirtualSample.isSelected())
			{
				List<WebElement> VirtualSampleProduct=driver.findElements(By.xpath("//button[contains(text(),'Create Order')]"));
	    		int VirtualSampleProductDisplay= VirtualSampleProduct.size();
	    		System.out.println(VirtualSampleProductDisplay);
	    		Assert.assertTrue(VirtualSampleProductDisplay==0);
	    		Thread.sleep(2000);
				
			}
			if(!GetData.SelectVirtualSample.isSelected())
			{
				
				Click("Select Virtual Sample" ,GetData.SelectVirtualSample);
				Thread.sleep(2000);
				Click("Click Order button",GetData.CreateOrderSelectVirtualSample);
			}
			
			 waitForPageLoading();
			List<WebElement> VirtualSampleProduct=driver.findElements(By.xpath("//tr[contains(@ng-repeat,'lineItem in group')]"));
    		int VirtualSampleProductDisplay= VirtualSampleProduct.size();
    		System.out.println(VirtualSampleProductDisplay);
    		Thread.sleep(2000);
			Assert.assertTrue(VirtualSampleProductDisplay>0);
		}
		
		
		
		public static void VirtualSample_NameClickAble() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			SoftAssert assertion =new SoftAssert();
			parentWindow = driver.getWindowHandle();
			Click("a",driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")));
			//Switch to new window opened
			  	for(String winHandle : driver.getWindowHandles()){
			  	    if(!winHandle.equals(parentWindow)) {
			  	        driver.switchTo().window(winHandle);
			  	    }
			  	}
			  waitForPageLoading();
			  Thread.sleep(15000);
			  Assert.assertTrue(GetData.VSSaveButton.isDisplayed());
			  assertion.assertAll();
			
		}
		
		
		
		public static void Verify_RecordOwnerName() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(3000);
			 driver.close();
		     Thread.sleep(3000);
		      //Switch back to parent window 
		     driver.switchTo().window(parentWindow);
			SoftAssert assertion =new SoftAssert();
			 Thread.sleep(3000);
			 WebElement VSImg=GetData.VSImg;
			 Hover(VSImg);
			// Hover(GetData.RecordOwner);
			 String recordowner=GetData.RecordOwner.getText();
			 System.out.println(recordowner);
			 recordowner=recordowner.replaceAll("Record Owner:","");
			 recordowner=recordowner.trim();
			System.out.println(recordowner);
			Thread.sleep(2000); 
			 Assert.assertTrue(GetData.RecordOwner.getText().contains("Record Owner:"));
			 assertion.assertAll();
			 Click("a",GetData.OrderListing_UserInfoIcon);
			 String username=driver.findElements(By.xpath("//div[contains(@class,'col-xs-7')]")).get(0).getText();
			 System.out.println(username);
			 Thread.sleep(2000); 
			
			 Verify(recordowner,username,"Record owner is not matching");
		}
		public static void Verify_VirtualSampleUnderCompany() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Click("Navigate to company",GetData.NavigatetoCompanies);
			//waitForPageLoading();
			Thread.sleep(3000);
			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			Thread.sleep(3000);
			Click("Click on company detail",GetData.CompDetails);
			//waitForPageLoading();
			Click("Design tab",GetData.Designs);
			Thread.sleep(3000);
			Click("Virtual Sample",GetData.CRMCompanyDesign);
			Input("Provide Design Name",GetData.CRMCompanySearchDesign,CrmTestData.VirualSampleName);
			Thread.sleep(2000);
			String SearchVS=driver.findElement(By.xpath("//p[contains(text(),'"+CrmTestData.VirualSampleName+"')]")).getText();
		    System.out.println(SearchVS);
		     Thread.sleep(2000);
		    Verify(SearchVS, CrmTestData.VirualSampleName,"Virtual Sample Not Found in All Design Tab");
			
			
			
		}
		
		
		public static void DeleteVirtualSample() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(3000);
			 Click("Close Orders Screen",GetData.CloseOrder_Icon);
			 //Click("Design Tab",GetData.DesignTab);
		     Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		     Thread.sleep(2000);
			 Click("Delete Design",GetData.DeleteDesign);
			 Thread.sleep(2000); 
			 Click("Confirm Delete",GetData.ConfirmOk);
			 Input("Search created design in All design tab",GetData.SearchDesign,CrmTestData.VirualSampleName);
		     Thread.sleep(2000);
		     List<WebElement> VSNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No virtual samples found')]"));
		 	 int size=VSNotFound.size();
		 	 System.out.println(size);
		 	 if(size==1)
		 	 {
	        	Assert.assertTrue(true);
		 	 }
		 	 else
		 	 {
		 		Assert.assertTrue(false);
		 	 }
		}
		
		public static void CreatePresentation_UnderCustomer() throws InterruptedException, AWTException, IOException
		{
			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(1000);
			 Click("Close Order",GetData.CloseOrder_Icon);
			 Thread.sleep(1000);
			 Click("ESP WEb", GetData.ESPWeb);
			 waitForPageLoading();
			 Thread.sleep(7000);
			 Input("Provide Supplier Name",GetData.SearchSupplier,"30232");
			 Click("Search Supplier",GetData.WESPSearchButton);
			 waitForPageLoading();
			 Thread.sleep(3000);
			 List<WebElement> ProdSelect=driver.findElements(By.xpath("//div/input[contains(@name,'prodcheckbox')]"));
			 ProdSelect.get(0).click();
			 Thread.sleep(3000);
			 Click("Create Presentation",GetData.CreatePresentation);
			 Thread.sleep(3000);
			 Input("Provide Supplier Name",GetData.PresentationName,CrmTestData.PresentationName);
			 Click("Click on customer dropdown",GetData.CustomerDropDown);
			 Input("Provide Supplier Name",GetData.SelectCompany,"Auto Supplier ASIQA I");
  		   	 Thread.sleep(6000);
  		   	 GetData.SelectCompany.sendKeys(Keys.ARROW_DOWN);
  		     Thread.sleep(1000);
  		     //Select company from company dropdown
  		     GetData.SelectCompany.sendKeys(Keys.ENTER);
  		     Thread.sleep(2000);
  		     Click("Create Presentation",GetData.CreatePresentationbutton);
  		     Thread.sleep(2000);
  		     Input("Provide Supplier Name",GetData. PresentationComment,"PostPresentation");
  		     Thread.sleep(2000);
  		     Click("Post Presentation",GetData.PostPresentation);
  		     Thread.sleep(2000);
  		     Click("Access CRM",GetData.CRM);
  		   
  		     Thread.sleep(3000);
  		     Input("Please Enter in search field", GetData.CompaniesSearchField,"Auto Supplier ASIQA I");
  		   Thread.sleep(3000);
  		     Click("Access Company",GetData.CompDetails);
  		   Thread.sleep(2000);
  		     Click("Access Presentation",GetData.CRMCustomerPresentation);
  		     
  		   Input("Search Presentations", GetData.SearchPresentation,CrmTestData.PresentationName);
  		  List<WebElement> PresentationNotFound =driver.findElements(By.xpath("//ng-content[contains(text(),'No presentations found.')]"));
		 	 int size=PresentationNotFound.size();
		 	 System.out.println(size);
		 	 if(size==0)
		 	 {
	        	Assert.assertTrue(true);
		 	 }
		 	 else
		 	 {
		 		Assert.assertTrue(false);
		 	 }
  		
		}
		
		

}
