package Master;

import static CrmTestCases.StartBrowser.StartupBrowser;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import CrmTestCases.CompanyScenarios;
import CrmTestCases.ContactScenarios;
import CrmTestCases.Email;
import CrmTestCases.Login;
import CrmTestCases.SettingsScenarios;
import CrmTestCases.Tasks;
import CrmTestCases.VirtualSample;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;

public class CRMSanityCheckList1 extends HelpingFunction{
	
	static String Suite="IDAHO_CRMSanityCheckList1.html";

	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException
	{

	  StartupBrowser(Suite);
	} 
	

	@Test(priority=0)
	public void LoginIdaho() throws InterruptedException, AWTException, IOException
	{
		Login.login();
				 	
	}
	
	@Test(priority=1)
	public static void VerifyOrdersDomain() throws InterruptedException, AWTException, IOException
	{
		Login.VerifyExistingDomain();
					 	
	}
		
/*	@Test (priority=2)
	public static void DeleteAllDefualtTask() throws InterruptedException, AWTException, IOException
	{

	
		Tasks.AllDeleteDefaultTask();
	 }*/
 	
	@Test (priority=2)
	public static void CreateContactUnderCompany() throws InterruptedException, AWTException, IOException
	{

		ContactScenarios.CreateContact(false);  
	
	 }
	@Test (priority=3)
	public static void EditContact_Details() throws InterruptedException, AWTException, IOException
	{
	
		ContactScenarios.EditContact_Details();  

 	}
	
	@Test (priority=4)
	public static void Inactive_Contact() throws InterruptedException, AWTException, IOException
	{
	
		ContactScenarios.Inactive_Conatct();

 	}
	@Test (priority=5)
	public static void DeleteContact() throws InterruptedException, AWTException, IOException
	{
	
		ContactScenarios.Delete_Contact();

 	}
	
	@Test (priority=6)
	public static void HashPromoOffice() throws InterruptedException, AWTException, IOException
	{
	
		Email.PromoOfficeDomain();

 	}
	@Test (priority=7)
	public static void ImportContact_ConflictCheckBox() throws InterruptedException, AWTException, IOException
	{
	
		ContactScenarios.ImportConatct_ConflictCheckBox();

 	}
	@Test (priority=8)
	public static void Settings_EditCompanyProfile() throws InterruptedException, AWTException, IOException
	{
	
		SettingsScenarios.EditCompanyProfile();

 	}
	@Test (priority=9)
	public static void Tasks_DefaultVisibilityPrivate() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.TasksDefaultVisibility(true);

 	}
	@Test (priority=10)
	public static void ReviewTaskVisibility_MainTaskPage_AsPrivate() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_MainTaskPage(true);

 	}
	@Test (priority=11)
	public static void ReviewTaskVisibility_CompanyPage_AsPrivate() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_UnderCompany(true);

 	}
	@Test (priority=12)
	public static void ReviewTaskVisibility_AppointmentPage_AsPrivate() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_AppointmentPage(true);

 	}
	@Test (priority=13)
	public static void Tasks_DefaultVisibilityPublic() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.TasksDefaultVisibility(false);

 	}
	@Test (priority=14)
	public static void ReviewTaskVisibility_MainTaskPage_AsPublic() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_MainTaskPage(false);

 	}
	@Test (priority=15)
	public static void ReviewTaskVisibility_CompanyPage_AsPublic() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_UnderCompany(false);

 	}
	@Test (priority=16)
	public static void ReviewTaskVisibility_AppointmentPage_AsPublic() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.ReviewTaskVisibility_AppointmentPage(false);

 	}
	

	@Test (priority=18)
	public static void AppointmentDefaultVisibility_CreatorOnly() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.AppointmentDefaultVisibility(true);

 	}
	@Test (priority=19)
	public static void AppointmentDefaultVisibility_EveryOne() throws InterruptedException, AWTException, IOException
	{
	
		Tasks.AppointmentDefaultVisibility(false);

 	}
	
	@Test  (priority=20)
 	public static void CommonTaskCreation() throws InterruptedException, AWTException, IOException{
	
	 Tasks.CommonTaskCreation();
 	}


 @Test  (priority=21)
 	public static void Unique_CommonTaskCreation() throws InterruptedException, AWTException, IOException{
	
	 Tasks.Unique_CommonTaskCreation();
 	}
 @Test  (priority=22)
 	public static void VerifyDueInTextField() throws InterruptedException, AWTException, IOException{
	
	 Tasks.CommonTaskForm_DueDate();
 	}
 
 @Test  (priority=24)
 	public static void Settings_EditCommonTask() throws InterruptedException, AWTException, IOException{
		Tasks.EditCommonTask();
 	}
 @Test  (priority=25)
 	public static void AddTaskFromMain_AfterEditCommonTaskFromSettings() throws InterruptedException, AWTException, IOException{
		Tasks.CreateTaskFromMainTask_AfterEditTaskNameFromSettings();
 	}
 
 
 @Test  (priority=26)
 	public static void DeleteCommonTask() throws InterruptedException, AWTException, IOException{
		Tasks.DeleteCommonTask();
 	}
 @Test  (priority=27)
 	public static void VerityCommonTask_FromMain_AddTaskDropDown_NotDisplayed__AfterDeleteCommonTask_() throws InterruptedException, AWTException, IOException{
		Tasks.DeleteCommonTask_VerityFromMainAddTaskDropDown();
	 	  
 	}
 @Test  (priority=28)
 	public static void VerityCreatedTask_NotDelete_FromMainTask_AfterDeleteCommonTask() throws InterruptedException, AWTException, IOException{
		Tasks.DeleteCommonTask_VerityCreatedTaskFromMainTask();
	 	  
 	}
 
	 @Test  (priority=29)
	 	public static void Task_CreateDefaultTaskDefaultItemVisibility_Private() throws InterruptedException, AWTException, IOException{
			Tasks.CreateDefaultTask_DefaultItemVisibilityPrivate() ;
		 	  
	 	}
	
	 @Test  (priority=30)
	 	public static void Task_CreateDefaultTaskDefaultItemVisibility_Public() throws InterruptedException, AWTException, IOException{
			Tasks.CreateDefaultTask_DefaultItemVisibilityPublic();
		 	  
			
	 	}
	 @Test  (priority=31)
	 	public static void VerifyPrivateDefaultTask_OrdersTask() throws InterruptedException, AWTException, IOException{
			Tasks.VerifyPrivateDefaultTask_Order();
		 	  
			
	 	}
	 
	  @Test  (priority=32)
 	public static void UpdatePrivateDefaultTaskVisibiltyToPublic_VerifyOrderLevelImpact() throws InterruptedException, AWTException, IOException{
		Tasks.UpdatePrivateDefaultTaskVisibiltyToPublic_OrderLevelImpact();
	 	  
		
 	}
	 @Test  (priority=33)
	 	public static void PresentationDefaultVisibility() throws InterruptedException, AWTException, IOException{
			Tasks.PresentationDefaultVisibility();
		 	  
			
	 	}
	 @Test  (priority=34)
	 public static void CreateDefaultTaskPerOrderLinkToSupplier() throws InterruptedException, AWTException, IOException{
		
		Tasks. CreateDefaultTask_PerOrderLinkToSupplierORDecorator(true);
	 	}
	@Test  (priority=35)
	 public static void Verify_SupplierDefaultTask() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorDefaultTask(true);
	 	}
	@Test  (priority=36)
	 public static void CreateDefaultTask_PerProductLineItemLinkToSupplier() throws InterruptedException, AWTException, IOException{
		
		Tasks.CreateDefaultTask_PerProductLineItemLinkToSupplierORDecorator(true);
	 	}
	@Test  (priority=37)
	 public static void VerifySupplierDefaultTask_ProductLineItem() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorDefaultTask_ProductLineItem(true);
	 	}
	@Test  (priority=38)
	 public static void VerifySupplierProductLineItemDefaultTask_TaskPane() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane(true);
	 	}
	@Test  (priority=39)
	 public static void VerifySupplierProductLineItemDefaultTask_TaskPane_AfterDeleteProductLineItem() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane_AfterDeleteProductLineItem(true);
	 	}
	
	@Test  (priority=40)
	 public static void CreateDefaultTask_PerOrderLinkToDecorator() throws InterruptedException, AWTException, IOException{
		
		CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		Click("Please click to Close Project",GetData.CloseOrder_Icon);
		Tasks. CreateDefaultTask_PerOrderLinkToSupplierORDecorator(false);
	 	}
	@Test  (priority=41)
	 public static void Verify_DecoratorDefaultTask() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorDefaultTask(false);
	 	}
	@Test  (priority=42)
	 public static void CreateDefaultTask_PerProductLineItemLinkToDecorator() throws InterruptedException, AWTException, IOException{
		
		Tasks.CreateDefaultTask_PerProductLineItemLinkToSupplierORDecorator(false);
	 	}
	@Test  (priority=43)
	 public static void VerifyDecoratorDefaultTask_ProductLineItem() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorDefaultTask_ProductLineItem(false);
	 	}
	@Test  (priority=44)
	 public static void VerifyDecoratorProductLineItemDefaultTask_TaskPane() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane(false);
	 	}
	@Test  (priority=45)
	 public static void VerifyDecoratorProductLineItemDefaultTask_TaskPane_AfterDeleteProductLineItem() throws InterruptedException, AWTException, IOException{
		
		Tasks.VerifySupplierORDecoratorProductLineItemDefaultTask_TaskPane_AfterDeleteProductLineItem(false);
	 	}
	
	 
	@Test (priority=46)
	public static void  SalesTax_MessageValidationOnMorethan100Value() throws InterruptedException, AWTException, IOException
	{
		/*CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		Thread.sleep(3000);
		Click("Please click to Close Project",GetData.CloseOrder_Icon);
		Thread.sleep(2000);*/
		SettingsScenarios.SalesTax_MessageValidationOnMorethan100Value();

 	}
	@Test  (priority=47)
	  public static void CreateCustomerCompanyAForRelationship() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
		 	CompanyScenarios.CreateCompanyB("Customer");	
		 	 
	 	}
	@Test  (priority=48)
	  public static void CreateRelationShipbetweentwoCompanies() throws InterruptedException, AWTException, IOException{
			
		 	CompanyScenarios.CreateRelationShipbetweentwoCompanies();	
		 	 
	 	}
	@Test  (priority=49)
	  public static void CrossVerificationbetweenRelationShipoftwoComapnies() throws InterruptedException, AWTException, IOException{
			
		 	CompanyScenarios.CrossVerificationbetweenRelationShipoftwoComapnies();	
		 	 
	 	}
	@Test  (priority=50)
	  public static void CreateCustomerCompany_SpecialCharacterPhoneno() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
			
		 	Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.SpecialCHaCompPhone);
		 	Thread.sleep(3000);
			Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");
	 	}
	
	@Test  (priority=51)
	  public static void ThirdPartySystemName() throws InterruptedException, AWTException, IOException{
			
			
		  SettingsScenarios.ThirdPartySystemName();	
		 	
	 	}
	  
	  @Test  (priority=52)
	  public static void VerifyShipVia_GroundOption_CRM() throws InterruptedException, AWTException, IOException{
		
		 	CompanyScenarios.ShipVia_CRM();	
		 	
	 	}
	  @Test  (priority=53)
	  public static void ThirdPartySystemName_VerificationCompanyPage() throws InterruptedException, AWTException, IOException{
			
			
		 	CompanyScenarios.ThirdPartySystemName_VerificationCompanyPage();	
		 	
	 	}
	  @Test  (priority=54)
	  public static void ThirdPartySystemName_VerificationContactPage() throws InterruptedException, AWTException, IOException{
			
			
		 	CompanyScenarios.ThirdPartySystemName_VerificationContactPage();	
		 	
	 	}
	/*	@Test  (priority=29)
	 	  public static void CreateCustomerCompany() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			Thread.sleep(3000);
			CompanyScenarios.CreateCompany("Customer");	
			 	 
		 	}*/
		@Test  (priority=55)
		 public static void AddBillingAddress_UnderCompany() throws InterruptedException, AWTException, IOException{
			 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			 Thread.sleep(3000);
			 GetData.CRM.click();
			 Thread.sleep(2000);
			 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			 Thread.sleep(3000);
			 GetData.CompDetails.click();
			ContactScenarios.AddBillingAddress();
			 	
		 	}


		@Test  (priority=56 )
		public static void CreateContactWithBillingAddress() throws InterruptedException, AWTException, IOException
		{
		
		 ContactScenarios.CreateContactWithBillingAddress(true); 
	
	 	}

  
		@Test  (priority=57)
		public static void VerifyContactPrimaryBillingAddress_InOrder() throws InterruptedException, AWTException, IOException
		{
			ContactScenarios.VerifyContactBillingAddressInOrder(true);
	 	}
	/*	@Test  (priority=5)
		public static void VerifyContactBillingAddressInOutPutDocument_SalesOrder() throws InterruptedException, AWTException, IOException
		{
			ContactScenarios.VerifyContactBillingAddressInOrder_OutputDocument();;
	 	}*/
		
		@Test  (priority=58)
		public static void VerifyContactBillingAddress_InInvoice() throws InterruptedException, AWTException, IOException
		{
			ContactScenarios.VerifyContactBillingAddressInInvoice();
	 	}
		
		
		@Test  (priority=59)
	 	  public static void DeleteCustomerCompany() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			Thread.sleep(3000);
			GetData.CloseOrder_Icon.click();
			CompanyScenarios.DeleteCompany1();	
			Thread.sleep(5000);
		 	}
		      
		@Test  (priority=60)
	 	  public static void CreateDecoratorCompany() throws InterruptedException, AWTException, IOException{
			 	  CompanyScenarios.CreateCompany("Decorator");	  
		 	}
		@Test  (priority=61)
		 public static void AddBillingAddress_Decorator() throws InterruptedException, AWTException, IOException{
			 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			 Thread.sleep(3000);
			 GetData.CompDetails.click();
			ContactScenarios.AddBillingAddress();
			 	
		 	}
		@Test  (priority=62)
		public static void VerifyCompanyBillingAddressInOrder() throws InterruptedException, AWTException, IOException
		{
		
			ContactScenarios.VerifyCompanyBillingAddressInOrder();
	 	}
		@Test  (priority=63)
		public static void VerifyCompanyBillingAddressInQuotee() throws InterruptedException, AWTException, IOException
		{
			ContactScenarios.VerifyCompanyBillingAddressInQuote();
	 	}
		@Test  (priority=64)
	 	  public static void DeleteDecoratorCompany() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			Thread.sleep(3000);
			GetData.CloseOrder_Icon.click();
			CompanyScenarios.DeleteCompany1();	
			Thread.sleep(5000);
		 	}
		@Test  (priority=65)
	 	  public static void CreateSupplierCompany() throws InterruptedException, AWTException, IOException{
	      CompanyScenarios.CreateCompany("Supplier");	  
		 	}
		@Test  (priority=66)
		 public static void AddBillingAddressSupplierCompany() throws InterruptedException, AWTException, IOException{
			 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			 Thread.sleep(3000);
			 GetData.CompDetails.click();
			ContactScenarios.AddBillingAddress();
			 	
		 	}
		@Test  (priority=67)
		public static void CreateContactUnderSupplierCompany() throws InterruptedException, AWTException, IOException
		{
		
		 ContactScenarios.CreateContactWithBillingAddress(true); 
	
	 	}
		@Test  (priority=68)
		 public static void AddBillingAddressToContact() throws InterruptedException, AWTException, IOException{
			 
			ContactScenarios.AddBillingAddress();
			 	
		 	}
		@Test  (priority=69)
		public static void VerifyContactBillingAddress_InOrder() throws InterruptedException, AWTException, IOException
		{
			 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			 Thread.sleep(3000);
			 GetData.About.click();
			ContactScenarios.VerifyContactBillingAddressInOrder(false);
	 	}
			@Test (priority=70)
		public static void VerifyCreatedPresentationForCompany_UnderCRM() throws InterruptedException, AWTException, IOException
		{
		
			VirtualSample.CreatePresentation_UnderCustomer();

	 	}
	/*@Test (priority=25)
	public static void Elevoio_AddCompany() throws InterruptedException, AWTException, IOException
	{
	
		CompanyScenarios.Elevoio_AddCompany();

 	}
	
	@Test (priority=26)
	public static void Elevoio_AddContact() throws InterruptedException, AWTException, IOException
	{
	
		CompanyScenarios.Elevoio_AddContact();

 	}*/
	
	 @AfterMethod

		public void getResult(ITestResult result ) throws IOException, InterruptedException{
		
			if(result.getStatus()==ITestResult.SUCCESS){
				test.log(Status.PASS, result.getMethod().getDescription());
				test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
				test.log(Status.PASS, " Please see attached screenshot");
				String screenshotPath = HelpingFunction.capture(result.getName());
				test.addScreenCaptureFromPath(screenshotPath);
		 
	 			extent.flush();
				}

			
			if(result.getStatus()==ITestResult.FAILURE){

			 	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
		/*
		 * String screenshotPath = HelpingFunction.capture(result.getName());
		 * test.addScreenCaptureFromPath(screenshotPath);
		 */
		 		test.fail(result.getThrowable());
		 		extent.flush();
		 		}
				 			
			
			if(result.getStatus()==ITestResult.SKIP){
				System.out.print("Test cases is skipped");
				 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
				 test.skip(result.getThrowable());
			    }				 		
			
		 }
		 
}

