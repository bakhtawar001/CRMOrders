package Master;

import static CrmTestCases.StartBrowser.StartupBrowser;

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

import CrmTestCases.AIAChecks;
import CrmTestCases.Login;
import PageFactoryandTestdata.HelpingFunction;

public class UAT_AIAChecks extends HelpingFunction {
	
static String Suite="AIAChecks.html";

	
	

	@BeforeTest
			public void Startup() throws InterruptedException, AWTException, IOException{

					StartupBrowser(Suite);
			} 
	

	@Test(priority=0)
	 		public  void LoginIdaho() throws InterruptedException, AWTException, IOException
	{
				AIAChecks. Login_ParentAdmin();
				 	
	}
	
	@Test(priority=1)
	  	public static void VerifyOrdersDomain() throws InterruptedException, AWTException, IOException
	{
				Login.VerifyExistingDomain();
					 	
	}
	
	@Test(priority=2)
		public void VerifyNotifications_TurnOff_ParentAdmin() throws InterruptedException, AWTException, IOException
	{
		AIAChecks.VerifyEmailNotifications_TurnOff_ParentAdmin();
		 	
	}
	@Test(priority=3)
	public void VerifyInAPPNotifications_TurnOff_ParentAdmin() throws InterruptedException, AWTException, IOException
	{
		AIAChecks.VerifyInAPPNotifications_TurnOff_ParentAdmin();
	 	
	}
	@Test(priority=4)
	public void ChildLogin() throws InterruptedException, AWTException, IOException
	{
		AIAChecks.ChildLogin();
	 	
	}
	@Test(priority=5)
	public void VerifyNotifications_TurnOff_ChildAdmin() throws InterruptedException, AWTException, IOException
	{
		AIAChecks.VerifyEmailNotifications_TurnOff_ChildAdmin();
	 	
	}
	@Test(priority=6)
	public void VerifyInAPPNotifications_TurnOff_ChildAdmin() throws InterruptedException, AWTException, IOException
	{
		AIAChecks. VerifyInAPPNotifications_TurnOff_ChildAdmin();
 	
	}
	  @AfterMethod
	 	public void getResult(ITestResult result){
	 		test = extent.createTest(result.getName());
	 	if(result.getStatus()==ITestResult.SUCCESS){
	 		test.log(Status.PASS, result.getMethod().getDescription());
	 			
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "Test Case is Passed", ExtentColor.GREEN));
	 			 extent.flush();
	 		}
	 		if(result.getStatus()==ITestResult.FAILURE){
	 			test.log(Status.FAIL, result.getMethod().getDescription());
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "Test Case is Failed due to Below Issue", ExtentColor.RED));
	 			 test.fail(result.getThrowable());
	 			 extent.flush();
	 		}
	 		
	 		
	 	}

	@AfterTest
	public void teardown(){
	 	
	 	
	 driver.close();
	}
	
}
