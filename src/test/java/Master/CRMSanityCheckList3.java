package Master;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import CrmTestCases.CompanyScenarios;
import CrmTestCases.Filters;
import CrmTestCases.Login;
import CrmTestCases.StartBrowser;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.HelpingFunction;

public class CRMSanityCheckList3 extends HelpingFunction {
	static String Suite="IDAHO_CRMCheckList3.html";

	

	@BeforeTest
			public void Startup() throws InterruptedException, AWTException, IOException
			{

		StartBrowser.StartupBrowser(Suite);
			} 
	

	@Test(priority=0)
	 		public   void LoginIdaho() throws InterruptedException, AWTException, IOException	
		{
				 	Login.login();
				 	
		}
	@Test  (priority=1)
	  public static void VerifyOrdersDomain() throws InterruptedException, AWTException, IOException
		{
			 	Login.VerifyExistingDomain();
			 	
		 }
	@Test  (priority=2)
	  public static void ForFiltersVerifications_CreateCompanyA() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
		 	CompanyScenarios.CreateCompany("Customer");	
		 	 
	 	}
	@Test  (priority=3)
	  public static void ForFiltersVerifications_CreateCompanyB() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
		 	CompanyScenarios.CreateCompanyB("Customer");	
		 	 
	 	}
	@Test  (priority=4)
	  public static void VerifyOrdersFilters_UnderExistingCompany() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyOrdersFilters_UnderExistingCompany();
			 	
		 }
	@Test  (priority=5)
	  public static void CreateNewCompany_WithProduct() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyFilters_UnderNewCompany();
			 	
		 }
	@Test  (priority=6)
	  public static void CreateNewCompany2_WithCloseStatus_WithDifferentBillingAddress() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyFilters_UnderNewCompany2();
			 	
		 }
	@Test  (priority=7)
	  public static void VerifyClosedStatus_UnderCreatedCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyStatusClosedFilters_UnderbothCompanies();
			 	
		 }
	@Test  (priority=8)
	  public static void VerifyOpenStatus_UnderCreatedCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyStatusOpenFilters_UnderbothCompanies();
			 	
		 }
	
	@Test  (priority=9)
	  public static void VerifyVendorFilters_UnderCreatedCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyVendorFilters_UnderbothCompanies();
			 	
		 }
	
	@Test  (priority=10)
	  public static void VerifyBillingAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyBillingAddressFilters_UnderbothCompanies();
			 	
		 }
	@Test  (priority=11)
	  public static void VerifyShippingAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyShippingAddressFilters_UnderbothCompanies();
			 	
		 }
	
	@Test  (priority=12)
	  public static void VerifyAckAddressFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyAckAddressFilters_UnderbothCompanies();
			 	
		 }
	
	@Test  (priority=13)
	  public static void VerifyCustomerFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyCustomerFilters_UnderbothCompanies();
			 	
		 }
	@Test  (priority=14)
	  public static void VerifySalesRepFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifySalesRepFilters_UnderbothCompanies();
			 	
		 }
	@Test  (priority=15)
	  public static void VerifyTagsFilters_UnderbothCompanies() throws InterruptedException, AWTException, IOException
		{
			 	Filters.VerifyTagsFilters_UnderbothCompanies();
			 	
		 }
	
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
		 		test.fail(result.getThrowable());
		 		extent.flush();
		 		}
				 			
			
			if(result.getStatus()==ITestResult.SKIP){
				System.out.print("Test cases is skipped");
				 test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
				 test.skip(result.getThrowable());
			    }				 		
			
		 }
		 
	 @AfterTest
	 public void teardown(){
	  	
	  	
	  	//driver.close();
	 }
		

}
