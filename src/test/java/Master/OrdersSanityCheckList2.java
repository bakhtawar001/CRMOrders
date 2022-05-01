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

import CrmTestCases.StartBrowser;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.CreateQuote;
import OrdersTestcases.Login;
import OrdersTestcases.OrdersCustomProduct;
import OrdersTestcases.Settings_SalesTaxDisabling_WithConfiguration;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;

public class OrdersSanityCheckList2 extends HelpingFunction {
	static String Suite="IDAHO_SanityCheckList2.html";
	@BeforeTest
	 public void Startup() throws InterruptedException, AWTException, IOException{

		StartBrowser.StartupBrowser(Suite);
		 }

	@Test(priority=0, description="Validate that user is able to login with orders application successfully")
		public void LoginApp() throws IOException, InterruptedException, AWTException{
		 Login.login();
	}
	@Test(priority=1)
	public void LoggedinUserNameToVerify_SalesPersonOfOrder() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.Loggedin_UserName();
	}
	@Test(priority=2)
	public void ViewNotesLink_UnderTasks () throws InterruptedException, AWTException, IOException	
	{
	CreateOrder.CreateOrder_WithTaskandNotes();
		 	
	}
	@Test(priority=3)
	public void CreateOrder_ReviewHideNotesLink() throws InterruptedException, AWTException, IOException	
	{
	CreateOrder.CreateOrder_ReviewHideNotesLink();
		 	
	}
	@Test(priority=4)
	public void CreateOrder_ReviewNotes() throws InterruptedException, AWTException, IOException	
	{
	CreateOrder.CreateOrder_ReviewNotes();
		 	
	}
	@Test(priority=5)
	public void CreateOrder_WithTaskOnly () throws InterruptedException, AWTException, IOException	
	{
	
	CreateOrder.CreateOrder_WithTaskOnly();
		 	
	}
	
	@Test(priority=6)
	public void FieldsData_Verification_AfterRequote() throws IOException, InterruptedException, AWTException{
		CreateQuote.FieldsData_Verification_AfterRequote();
	}
	
	@Test(priority=7)
	public void ReviewSupplierAS_DefaultDecorator() throws IOException, InterruptedException, AWTException{
		CreateQuote.ReviewSupplierAS_DefaultDecorator();
	}
	@Test(priority=8)
	public void InHandsDateButtonOptionsPOPUpVerification() throws IOException, InterruptedException, AWTException{
		CreateQuote.InHandsDateButtonOptions_POPUpVerification();
	}
	@Test(priority=9)
	public void OrderTracking_OrderContact_CheckboxFunctionality() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.OrderTracking_OrderContact_CheckboxFunctionality(true);
	}
	@Test(priority=10)
	public void ImpactofOrderContact_AtOrderLevel() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.ImpactofOrderContact_AtOrderLevel(true);
	}
	@Test(priority=11)
	public void ImpactofOrderTracking_AtOrderLevel() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.ImpactofOrderTracking_AtOrderLevel(true);
	}
	@Test(priority=12)
	public void OrderTracking_Uncheck_OrderContact_CheckboxFunctionality() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.OrderTracking_OrderContact_CheckboxFunctionality(false);
	}
	@Test(priority=13)
	public void ImpactofOrderContact_Uncheck_AtOrderLevel() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.ImpactofOrderContact_AtOrderLevel(false);
	}
	@Test(priority=14)
	public void ImpactofOrderTracking__Uncheck_AtOrderLevel() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.ImpactofOrderTracking_AtOrderLevel(false);
	}
	
	@Test(priority=15)
	public void Default_SalesPersonForOrders() throws IOException, InterruptedException, AWTException{
		Settings_SalesTaxDisabling_WithConfiguration.Default_SalesPerson();
	}
	
	@Test(priority=16)
 	public void Verify_AddCustomProductAttribute_Orders() throws InterruptedException, AWTException, IOException	
	{
		OrdersLocators CustomField = PageFactory.initElements(driver, OrdersLocators.class);	
		Click("Close order window",CustomField.CloseOrder_Icon);
		Thread.sleep(5000);
		OrdersCustomProduct.CreateOrder_EditConfiguration_AddCustomProductAttribute();
			 	
	}
	@Test(priority=17)
	public void Verify_AddCustomProductAttribute_WaterMarkTextFieldVerification_Orders() throws InterruptedException, AWTException, IOException	
	{
	
		OrdersCustomProduct .AddCustomProductAttribute_WaterMarkTextVerification();
	 	
	}

	@Test(priority=18)
	public void Verify_AddCustomProductAttribute_DropDown_SelectAttribute_Orders() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .AddCustomProductAttribute_SelectAttribute();
 	
	}

	@Test(priority=19)
	public void Delete_CustomProductAttribute_Orders() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .DeleteCustomProductAttribute();
	
	}
	@Test(priority=20)
	public void ExistingOrder_CustomProductAttribute_CreateOrder() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct.ExistingOrder_EditConfiguration_AddCustomProductAttribute();

	}

	@Test(priority=21)
		public void Verify_AddCustomProductAttribute_Invoice() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct.CreateInvoice_EditConfiguration_AddCustomProductAttribute();
		 	
	}
	@Test(priority=22)
	public void Verify_AddCustomProductAttribute_WaterMarkTextFieldVerification_Invoice() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Invoice_AddCustomProductAttribute_WaterMarkTextVerification();
 	
	}

	@Test(priority=23)
	public void Verify_AddCustomProductAttribute_DropDown_SelectAttribute_Invoice() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Invoice_AddCustomProductAttribute_SelectAttribute();
	
	}

	@Test(priority=24)
	public void Delete_CustomProductAttribute_Invoice() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Invoice_DeleteCustomProductAttribute();

	}

	@Test(priority=25)
	public void ExistingQuote_CustomProductAttribute_CreateInvoice() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .ExistingInvoice_EditConfiguration_AddCustomProductAttribute();

	}
	@Test(priority=26)
	public void Verify_AddCustomProductAttribute_Quote() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .CreateQuote_EditConfiguration_AddCustomProductAttribute();
	 	
	}
	@Test(priority=27)
	public void Verify_AddCustomProductAttribute_WaterMarkTextFieldVerification_Quote() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Quote_AddCustomProductAttribute_WaterMarkTextVerification();
		
	}

	@Test(priority=28)
	public void Verify_AddCustomProductAttribute_DropDown_SelectAttribute_Quote() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Quote_AddCustomProductAttribute_SelectAttribute();

	}

	@Test(priority=29)
	public void Delete_CustomProductAttribute_Quote() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Quote_DeleteCustomProductAttribute();

	}


	@Test(priority=30)
	public void Verify_AddCustomProductAttribute_SampleRequest() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .CreateSampleRequest_EditConfiguration_AddCustomProductAttribute();
 	
	}

	@Test(priority=31)
	public void Verify_AddCustomProductAttribute_WaterMarkTextFieldVerification_SampleRequest() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .SampleRequest_AddCustomProductAttribute_WaterMarkTextVerification();

	}
	
	@Test(priority=32)
	public void Verify_AddCustomProductAttribute_DropDown_SelectAttribute_SampleRequest() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .SampleRequest_AddCustomProductAttribute_SelectAttribute();

	}

	@Test(priority=33)
	public void Delete_CustomProductAttribute_SampleRequest() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .SampleRequest_DeleteCustomProductAttribute();

	}
	@Test(priority=34)
	public void ExistingSampleRequest_CustomProductAttribute_SampleRequest() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .ExistingSampleRequest_EditConfiguration_AddCustomProductAttribute();

	}
	@Test(priority=35)
	public void CreateOrder_ShippingField_CloseIcon() throws InterruptedException, AWTException, IOException	
	{
	
		OrdersCustomProduct .CreateOrder_ShippingField_CloseIcon();

	}
	@Test(priority=36)
	public void Select_Customer_ShippingAddress() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Select_Customer_ShippingAddress();

	}
	@Test(priority=37)
	public void Select_MyCompany_ShippingAddress() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .Select_MyCompany_ShippingAddress();

	}
	@Test(priority=38)
	public void MyCompany_ShippingAddress_CloseIcon() throws InterruptedException, AWTException, IOException	
	{
		OrdersCustomProduct .MyCompany_ShippingAddress_CloseIcon();

	}
	
	   @AfterMethod
		public void getResult(ITestResult result){
			test = extent.createTest(result.getName());
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getMethod().getDescription());
	        test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case is Passed", ExtentColor.GREEN));
			extent.flush();
		}
			if(result.getStatus()==ITestResult.FAILURE)
			{
				test.log(Status.FAIL, result.getMethod().getDescription());
				test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
				test.fail(result.getThrowable());
				extent.flush();
			}
			
			
		}
	   @AfterTest
		public void teardown()
		{
			driver.close();
	}
}
