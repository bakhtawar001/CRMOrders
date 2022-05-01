



package Master;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import CrmTestCases.StartBrowser;
import OrdersTestcases.CopyImportLineItem;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.EditOrderProduct_Configuration;
import OrdersTestcases.EditOrderProduct_Decoration;
import OrdersTestcases.ImportLineItem;
import OrdersTestcases.Login;
import PageFactoryandTestdata.HelpingFunction;

public class OrdersExecution3 extends HelpingFunction  {
	
	static String Suite="IDAHO_OrderExecution3.html";

	@BeforeTest
	 public void Startup() throws InterruptedException, AWTException, IOException{

		StartBrowser.StartupBrowser(Suite);
		 }

	@Test(priority=0, description="Validate that user is able to login with orders application successfully")
		public void LoginApp() throws IOException, InterruptedException, AWTException{
		 Login.login();
	}

	
	@Test(priority=1)
	public void Setting_EnterPayment_Uncheck() throws IOException, InterruptedException, AWTException{
		CreateOrder.Setting_EnterPayment_Uncheck();

}
	


	@Test(priority=2)
	public void Create_Quote_Actionbuttons() throws IOException, InterruptedException, AWTException{
		CreateOrder.Create_Quote_Actionbuttons();

}
	
	@Test(priority=3)
	public void Create_Invoice_Actionbuttons() throws IOException, InterruptedException, AWTException{
		CreateOrder.Create_Invoice_Actionbuttons();

}
	
	@Test(priority=4)
	public void Create_SampleRequests_Actionbuttons() throws IOException, InterruptedException, AWTException{
		CreateOrder.Create_SampleRequest_Actionbuttons();

}
	@Test(priority=5)
	public void Create_SampleRequest() throws IOException, InterruptedException, AWTException{
		CreateOrder.Create_SampleRequest();

}
	@Test(priority=6)
	public void PreviewSampleRequest_CustomerVerification() throws IOException, InterruptedException, AWTException{
		CreateOrder.PreviewSampleRequest_CustomerVerification();

}
	@Test(priority=7)
	public void PreviewSampleRequest_ShippingContactVerification() throws IOException, InterruptedException, AWTException{
		CreateOrder.PreviewSampleRequest_ShippingContactVerification();

}
	@Test(priority=8)
	public void Create_Order_Actionbuttons() throws IOException, InterruptedException, AWTException{
		CreateOrder.Create_Order_Actionbuttons();

}
	
	
	@Test(priority=9)
	public void EnterPayment_Verification() throws IOException, InterruptedException, AWTException{
		CreateOrder.EnterPayment_Verification();

}
	
	
	@Test(priority=10)
	public void EnterPayment_NotDisplayed_Verification() throws IOException, InterruptedException, AWTException{
		CreateOrder.EnterPayment_NotDisplayed_Verification();

}
	@Test(priority=11)
	public void OrderSearchTerm_RetainVerification() throws IOException, InterruptedException, AWTException{
		CreateOrder.OrderSearchTerm_RetainVerification();

}
	@Test(priority=12)
	public void VerifyDecoratorEmailAddress() throws IOException, InterruptedException, AWTException{
		CreateOrder.VerifyDecoratorEmailAddress();

}
	
	@Test(priority=13)
	public void Copy_LineItem() throws IOException, InterruptedException, AWTException{
		CopyImportLineItem.Copy_LineItem();

}
	
	@Test(priority=14)
	public void VerifyContentCopyLineItem() throws IOException, InterruptedException, AWTException{
		CopyImportLineItem.VerifyContent_CopyLineItem();

}
	
	@Test(priority=15)
	public void ImportLineItem() throws IOException, InterruptedException, AWTException{
		ImportLineItem.Import_LineItem();

}
	@Test(priority=16)
	public void SelectCurrentCustomerOnly() throws IOException, InterruptedException, AWTException{
		ImportLineItem.SelectCurrentCustomerOnly();

}
	
	@Test(priority=17)
	public void DefaultDropDownValue() throws IOException, InterruptedException, AWTException{
		ImportLineItem.DefaultDropDownValue();

}
	@Test(priority=18)
	public void EditProductModal_Configurationtab_VariantAttributesVerification() throws IOException, InterruptedException, AWTException{
		EditOrderProduct_Configuration.EditProductModal_Configurationtab_VariantAttributesVerification();

}
	@Test(priority=19)
	public void EditProductModal_Configurationtab_AddLineItem_VariantAttributesVerification() throws IOException, InterruptedException, AWTException{
		EditOrderProduct_Configuration.EditProductModal_Configurationtab_AddLineItem_VariantAttributesVerification();

}
	@Test(priority=20)
	public void Update_ShippingWorkflow_WhenDecoratorIsUpdate() throws IOException, InterruptedException, AWTException{
		EditOrderProduct_Decoration.UpdateShippingWorkflow_WhenDecoratorIsUpdate();

}
	@Test(priority=21)
	public void UpdateShippingWorkflow_WhenDecoratorIsDelete() throws IOException, InterruptedException, AWTException{
		EditOrderProduct_Decoration.UpdateShippingWorkflow_WhenDecoratorIsDelete();

}
	@Test(priority=22)
	public void EditProductModal_Configurationtab_ClearAllVariants() throws IOException, InterruptedException, AWTException{
		EditOrderProduct_Configuration.EditProductModal_Configurationtab_ClearVariants();

}
	@Test(priority=23)
	public void SearchCompany_WithAllKeywords() throws IOException, InterruptedException, AWTException{
		CreateOrder.SearchCompany_WithAllKeywords();

}
	@Test(priority=24)
	public void Verify_ViewCRMRecordLink() throws IOException, InterruptedException, AWTException{
		CreateOrder.Verify_ViewCRMRecordLink();

}
	@Test(priority=25)
	public void ViewandModifyProduct_NonAdmin() throws IOException, InterruptedException, AWTException{
		CreateOrder.ViewandModifyProduct_NonAdmin();

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




