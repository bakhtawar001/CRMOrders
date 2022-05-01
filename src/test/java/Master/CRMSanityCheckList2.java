package Master;

import static CrmTestCases.StartBrowser.StartupBrowser;

import java.awt.AWTException;
import java.io.IOException;

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
import CrmTestCases.Login;
import CrmTestCases.MergeContact;
import CrmTestCases.Tasks;
import CrmTestCases.VirtualSample;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.HelpingFunction;

public class CRMSanityCheckList2 extends HelpingFunction {

	static String Suite = "IDAHO_CRMSanityCheckList2.html";

	@BeforeTest
	public void Startup() throws InterruptedException, AWTException, IOException {

		StartupBrowser(Suite);
	}

	@Test(priority = 0)
	public void LoginIdaho() throws InterruptedException, AWTException, IOException {
		Login.login();

	}

	@Test(priority = 1)
	public static void VerifyOrdersDomain() throws InterruptedException, AWTException, IOException {
		Login.VerifyExistingDomain();

	}
/*	@Test(priority = 2)
	public static void AIACustomProductCategories() throws InterruptedException, AWTException, IOException {
		AIAChecks.AIACustomProductCategories() ;

	}*/
	@Test(priority = 3)
	public static void CreateDefaultTask() throws InterruptedException, AWTException, IOException {
		CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		Thread.sleep(3000);
		//Click("Please click to Close Project",GetData.CloseOrder_Icon);
		Tasks.CommonTaskCreation();
	}

	@Test(priority = 4)
	public static void AddNotesFromTaskDetailPage() throws InterruptedException, AWTException, IOException {

	//	Tasks.AddNotesFromTaskDetailPage();

	}

	@Test(priority = 6)
	public static void CreateCustomerCompany() throws InterruptedException, AWTException, IOException {
		CrmLocatiors GetData = PageFactory.initElements(driver, CrmLocatiors.class);
		Click("a", GetData.CRM);
		CompanyScenarios.CreateCompany("Customer");
	}
	@Test  (priority=7)
	public static void DataCreate_PrimaryContactSelection_CreateContactUnderCompany() throws InterruptedException, AWTException, IOException
	{
		CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		Thread.sleep(3000);
		GetData.CompDetails.click();
		ContactScenarios.CreateContact(true);  

	}
	@Test  (priority=8)
	 public static void DataCreate_PrimaryContactSelection_CreateContactBFromMain() throws InterruptedException, AWTException, IOException{
	
		MergeContact.CreateContact_MergeContactB();
	 	}
	
	@Test  (priority=9)
	 public static void _PrimaryContactSelection_ContactALinkedwithCompanyPrimaryAddress_MergewithContactB() throws InterruptedException, AWTException, IOException{
		 
		MergeContact.MergeContactAInToContactB(true);
	 	}
	@Test  (priority=10)
	 public static void _PrimaryContactSelection_VerifyCompanyPrimaryContacts_After_MergeContactB() throws InterruptedException, AWTException, IOException{
		
		MergeContact.CompanyPrimaryContacts_IN_MergeContactB();
	 	}
	@Test  (priority=11)
	 public static void VerifyCompanyPrimaryContacts_CreateOrder_FromMergeContactB() throws InterruptedException, AWTException, IOException{
		
		MergeContact.CompanyPrimaryContacts_CreateOrder_MergeContactB();
	 	}
	@Test  (priority=12)
	 public static void DataCreate_PrimaryContactSelection_CreateContactA_PrimaryData() throws InterruptedException, AWTException, IOException{
		CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		Click("Close order window",GetData.CloseOrder_Icon);
		MergeContact.CreateContact(true);
	 	}
	@Test  (priority=13)
	 public static void DataCreate_PrimaryContactSelection_CreateContactB_NoPrimaryData() throws InterruptedException, AWTException, IOException{
		
		MergeContact.CreateContact_MergeContactB();
	 	}
	
	@Test  (priority=14)
	 public static void DataCreate_PrimaryContactSelection_MergeContactAWithPrimaryData_IntoContactB() throws InterruptedException, AWTException, IOException{
		 
		MergeContact.MergeContactAInToContactB(true);
	 	}
	@Test  (priority=15)
	 public static void VerifyContactPrimaryContent_MergeContactAIntoB() throws InterruptedException, AWTException, IOException{
		
		MergeContact.VerityPrimaryContactData_AfterMergeContactAInToContactB(true);
	 	}
	@Test  (priority=16)
	 public static void DataCreate_PrimaryContactSelectionCreateContactA_PrimaryData() throws InterruptedException, AWTException, IOException{
		
		MergeContact.CreateContact(true);
	 	}
	@Test  (priority=17)
	 public static void DataCreate_PrimaryContactSelection_CreateContactB_PrimaryData() throws InterruptedException, AWTException, IOException{
		
		MergeContact.CreateContact(false);
	 	}
	
	@Test  (priority=18)
	 public static void MergeContactAWithPrimaryData_IntoContactBWithPrimaryData() throws InterruptedException, AWTException, IOException{
		 
		MergeContact.MergeContactAInToContactB(false);
	 	}
	@Test  (priority=19)
	 public static void VerifyContactPrimaryContent_MergeContactAIntoB_BothHavePrimaryContact() throws InterruptedException, AWTException, IOException{
		
		MergeContact.VerityPrimaryContactData_AfterMergeContactAInToContactB(false);
	 	}
	
	@Test  (priority=20)
	 public static void VerifyState_Company() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.CreateCompany_StateValidation();
	 	}
	 @Test  (priority=21)
	 public static void ValidateState_AddressBook_AddCompanyAddress() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.ValidateState_AddressBook_AddCompanyAddress();
	 	}
	 	
	 	@Test  (priority=22)
	 public static void ValidateState_CreateCompanyWhileCreatingOrder() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.ValidateState_CreateCompanyWhileCreatingOrder();
	 	}
	 	
	@Test  (priority=23)
	 public static void VerifyState_Contact() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.CreateContact_StateValidation();
	 	}
	
	@Test  (priority=24)
	 public static void ValidateState_AddressBook_AddContactAddress() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.ValidateState_AddressBook_AddContactAddress();
	 	}
	@Test  (priority=25)
	 public static void ValidateState_CreateContactWhileCreatingOrder() throws InterruptedException, AWTException, IOException{
		
		CompanyScenarios.ValidateState_CreateContactWhileCreatingOrder();
	 	}
	@Test(priority = 26)
	public void CreateVirtualSample_Admin() throws InterruptedException, AWTException, IOException {

		VirtualSample.CreateVirtualSample_Admin();

	}

	@Test(priority = 27)
	public void VerifyVirualSampleName_Clickable() throws InterruptedException, AWTException, IOException {

		VirtualSample.VirtualSample_NameClickAble();

	}

	@Test(priority = 28)
	public void Verify_RecordOwner() throws InterruptedException, AWTException, IOException {

		VirtualSample.Verify_RecordOwnerName();

	}

	@Test(priority = 29)
	public void Verify_VirtualSampleUnderCompany() throws InterruptedException, AWTException, IOException {

		VirtualSample.Verify_VirtualSampleUnderCompany();
	}

	@Test(priority = 30)
	public void EditVirtualSample_Admin() throws InterruptedException, AWTException, IOException {

		VirtualSample.EditVirtualSample();

	}

	@Test(priority = 31)
	public void EditVirualSampleByAdmin_VisibilityRecordOwner_ValidateAtNonadmin()
			throws InterruptedException, AWTException, IOException {

		VirtualSample.EditVirtualSampleByAdmin_VisibilityRecordOwner_ValidateAtNonadmin();

	}

	@Test(priority = 32)
	public void CreateVirualSampleByNonAdmin_VisibilityofVirtualSample_With_Everyone_ValidateAtadmin()
			throws InterruptedException, AWTException, IOException {

		VirtualSample.CreateVirualSampleByNonAdmin_VisibilityofVirtualSample_With_Everyone_ValidateAtadmin();

	}

	@Test(priority = 33)
	public void CreateVirualSampleByNonAdmin_VerifyUnderCompany_ByfiltersMyDesign_ValidateAtadmin()
			throws InterruptedException, AWTException, IOException {

		VirtualSample.CreateVirualSampleByNonAdmin_VerifyUnderCompany_ByfiltersMyDesign_ValidateAtadmin();

	}

	@Test(priority = 34)
	public void SendVirualSample() throws InterruptedException, AWTException, IOException {

		VirtualSample.SendDesign();

	}

	@Test(priority = 35)
	public void CreateOrderFromVirualSample() throws InterruptedException, AWTException, IOException {

		VirtualSample.CreateOrderByVirtualSample();

	}

	@Test(priority = 36)
	public void CreateOrderBySelectVirtualSample() throws InterruptedException, AWTException, IOException {

		VirtualSample.CreateOrderBySelectVirtualSample();

	}

	@Test(priority = 37)
	public void DeleteVirualSample() throws InterruptedException, AWTException, IOException {

		VirtualSample.DeleteVirtualSample();
	}

	@Test(priority = 38)
	public void CreateContactFrom_Websites() throws InterruptedException, AWTException, IOException {

		MergeContact.CreateContactFromWebsites();

	}

	@Test(priority = 39)
	public void MergeWebsitesContact_CRM() throws InterruptedException, AWTException, IOException {

		MergeContact.MergeWebsitesContact_CRM();

	}
	

	@AfterMethod

	public void getResult(ITestResult result) throws IOException, InterruptedException {

		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getMethod().getDescription());
			test.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case is Passed", ExtentColor.GREEN));
			test.log(Status.PASS, " Please see attached screenshot");
			String screenshotPath = HelpingFunction.capture(result.getName());
			test.addScreenCaptureFromPath(screenshotPath);

			extent.flush();
		}

		if (result.getStatus() == ITestResult.FAILURE) {

			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue",
					ExtentColor.RED));
			/*
			 * String screenshotPath = HelpingFunction.capture(result.getName());
			 * test.addScreenCaptureFromPath(screenshotPath);
			 */
			test.fail(result.getThrowable());
			extent.flush();
		}

		if (result.getStatus() == ITestResult.SKIP) {
			System.out.print("Test cases is skipped");
			test.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + "Test Case is SKIPPED", ExtentColor.YELLOW));
			test.skip(result.getThrowable());
		}

	}

}
