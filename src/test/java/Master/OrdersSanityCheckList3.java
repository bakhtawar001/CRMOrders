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

import CrmTestCases.StartBrowser;
import OrdersTestcases.AddShipmentAddress_With_DifferentCompany;
import OrdersTestcases.CreateOrder;
import OrdersTestcases.Login;
import PageFactoryandTestdata.HelpingFunction;


public class OrdersSanityCheckList3 extends HelpingFunction {
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
	public void VerifyPOs_WhenSupplierASDecorator() throws IOException, InterruptedException, AWTException, ParseException{
		AddShipmentAddress_With_DifferentCompany.OnePOs_Creation();
	}
	@Test(priority=2)
	public void ForNewProduct_ReviewCADCurrancy_OrderLevel() throws IOException, InterruptedException, AWTException, ParseException{
		CreateOrder.ForNewProduct_ReviewCADCurrancy_OrderLevel();
	}
	@Test(priority=3)
	public void ReviewCurrancyAtOrderLevel_WhenAddMultipleProductWithDifferentCurrancy() throws IOException, InterruptedException, AWTException, ParseException{
		CreateOrder.ReviewCurrancyAtOrderLevel_WhenAddMultipleProductWithDifferentCurrancy();
	}
/*	@Test(priority=4)
	public void CanadianPriceValidation_POAPage() throws IOException, InterruptedException, AWTException, ParseException{
		CreateOrder.CanadianPriceValidation_POAPage();
	}*/
	
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
