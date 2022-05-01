package Master;

import java.awt.AWTException;
import java.io.IOException;
import java.text.ParseException;

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
import CrmTestCases.SettingsScenarios;
import CrmTestCases.StartBrowser;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.CreateQuote;
import OrdersTestcases.Login;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.HelpingFunction;

public class OrdersSanityCheckList1 extends HelpingFunction {
	static String Suite="IDAHO_SanityCheckList1.html";
	@BeforeTest
	 public void Startup() throws InterruptedException, AWTException, IOException{

		StartBrowser.StartupBrowser(Suite);
		 }

	@Test(priority=0, description="Validate that user is able to login with orders application successfully")
		public void LoginApp() throws IOException, InterruptedException, AWTException{
		 Login.login();
	}
	@Test(priority=1)
	public void ExportOrders() throws IOException, InterruptedException, AWTException{
	 CreateOrder.ExportOrders();
	}
	@Test(priority=2)
	public void ExportQuotes() throws IOException, InterruptedException, AWTException{
	 CreateQuote.ExportQuote();
}
	@Test(priority=3)
	public void Selection_AllOrderds() throws IOException, InterruptedException, AWTException{
		 CreateOrder.Selection_AllOrderds();
}
	@Test(priority=4)
	public void Selection_AllQuotes() throws IOException, InterruptedException, AWTException{
		 CreateQuote.Selection_AllQuotes();
}
	@Test(priority=5)
	public void Settings_HeaderFooterContent() throws IOException, InterruptedException, AWTException{
		SettingsScenarios.HeaderFooterContentVerification();
}
	@Test(priority=6)
	public void HeaderContentVerification_OutPutDocument() throws IOException, InterruptedException, AWTException{
		CreateOrder.HeaderContentVerification_OutPutDocument();
}
	@Test(priority=7)
	public void VerifySupplierPhoneno_OutputDocument() throws IOException, InterruptedException, AWTException{
		CreateOrder.VerifySupplierPhoneno_OutputDocument();
}
	
	@Test(priority=8)
	public void OrdersDetail_ProspectComapnySelection() throws IOException, InterruptedException, AWTException{
		CreateOrder.OrdersDetail_ProspectComapnySelection();
}
	@Test(priority=9)
	public void OrdersDetail_DecoratorComapnySelection() throws IOException, InterruptedException, AWTException{
		CreateOrder.OrdersDetail_DecoratorComapnySelection();
}
	@Test(priority=10)
	public void OrdersDetail_SupplierComapnySelection() throws IOException, InterruptedException, AWTException{
		CreateOrder.OrdersDetail_SupplierComapnySelection();
}
	@Test(priority=11)
	public void OrdersDetail_CustomerComapnySelection() throws IOException, InterruptedException, AWTException{
		CreateOrder.OrdersDetail_CustomerComapnySelection();
}
	@Test(priority=12)
	public void Products_AttributeVarients()  throws IOException, InterruptedException, AWTException
	{
		CreateOrder.Products_AttributeVarients() ;
    }
	
	@Test(priority=13)
	public void DeleteProductFromOrder()  throws IOException, InterruptedException, AWTException
	{
		CreateOrder.DeleteProductFromOrder() ;
    }
	@Test(priority=14)
	public void DeleteProductFromQuoteWhenOrderIsAssociated()  throws IOException, InterruptedException, AWTException, ParseException
	{
		CreateQuote.DeleteProductFromQuoteWhenOrderIsAssociated();
	}
	
	@Test(priority=15)
	public void VerifySentToASISamrtBookLink_WhenProductIsNotConfig() throws IOException, InterruptedException, AWTException{
		CreateOrder.VerifySentToASISamrtBookLink();
}
	@Test(priority=16)
	public void Ground_ShppingMethod_Verification() throws IOException, InterruptedException, AWTException{
		CreateOrder.Ground_ShppingMethod_Verification();
}
	@Test(priority=17)
	public void SendPackingList_MyCompany() throws IOException, InterruptedException, AWTException{
		CreateOrder.SendPackingList_MyCompany();
}
	@Test(priority=18)
	public void SendPackingList_SupplierCompany() throws IOException, InterruptedException, AWTException{
		CreateOrder.SendPackingList_SupplierCompany();
}
	
	@Test(priority=19)
	public void SupplierName_Navigation() throws IOException, InterruptedException, AWTException{
		CreateOrder.SupplierName_Navigation();
}
	@Test(priority=20)
	public void Product_Navigation() throws IOException, InterruptedException, AWTException{
		CreateOrder.Product_Navigation();
}
	@Test(priority=21)
	public void SearchInvoiceFromOrderPage_WhenInvoiceIsAssociatedWithOrder() throws IOException, InterruptedException, AWTException{
		CreateOrder.SearchInvoiceFromOrderPage();
}
	@Test  (priority=22)
	  public static void CustomerPrimaryEmailAddress_AsBillingShppingAck() throws InterruptedException, AWTException, IOException{
			CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			GetData.CRM.click();
			Thread.sleep(2000);
		 	CompanyScenarios.CreateCompany("Customer");	
		 	CreateOrder.CustomerPrimaryEmailAddress_BillingShppingAck();
		 	
	 	}
	@Test(priority=23)
	public void EditBillingEmailAddress() throws IOException, InterruptedException, AWTException{
		CreateOrder.EditBillingEmailAddress();
}
	@Test(priority=24)
	public void EditBillingContact_VerifyLinkedCompany() throws IOException, InterruptedException, AWTException{
		CreateOrder.EditBillingContact_VerifyLinkedCompany();
}
	
	@Test(priority=25)
	public void Verify_EditedBillingEmailAddress_CRM() throws IOException, InterruptedException, AWTException{
		CreateOrder.Verify_EditedBillingEmailAddress_CRM();
}
	
	@Test(priority=26)
	public void OrdersPrefrence_ReadOnly() throws IOException, InterruptedException, AWTException{
		
		SettingsScenarios.OrdersPrefrence_ReadOnly();
}
	@Test(priority=27)
	public void NonAdmin_OrdersPrefrence_ReadOnly() throws IOException, InterruptedException, AWTException{
		
		SettingsScenarios.NonAdmin_OrdersPrefrence_ReadOnly();
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
