package Master;

import static CrmTestCases.StartBrowser.StartupBrowser;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CrmTestCases.Login;
import CrmTestCases.MergeContact;
import PageFactoryandTestdata.HelpingFunction;

public class Feb2020Release extends HelpingFunction {
	static String Suite="IDAHO_FebReleaseCRM.html";

	

	@BeforeTest
			public void Startup() throws InterruptedException, AWTException, IOException{

					StartupBrowser(Suite);
			} 
	

	@Test(priority=0)
	 		public   void LoginIdaho() throws InterruptedException, AWTException, IOException{
				 	Login.login();
				 	
}
	@Test  (priority=1)
	  public static void VerifyOrdersDomain() throws InterruptedException, AWTException, IOException{
			 	Login.VerifyExistingDomain();
			 	
		 	}
	@Test  (priority=2)
	  public static void CreateContact() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.CreateContact(true); 	  
	 	}
	@Test  (priority=3)
	  public static void CreateContact_MergeContactB() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.CreateContact_MergeContactB(); 	  
	 	}
	@Test  (priority=4)
	  public static void CreateContactA_MergeContactBToContactA() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.CreateContactA_MergeContactBToContactA(); 	  
	 	}
	@Test  (priority=5)
	  public static void CreateContactB_MergeContactBToContactA() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.CreateContactB_MergeContactBToContactA(); 	  
	 	}
	
	@Test  (priority=6)
	  public static void MergeContactAInToContactB() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.MergeContactAInToContactB(true); 	  
	 	}
	
	@Test  (priority=7)
	  public static void AfterMergeContactA_VerifyContactInfoInContactB() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.AfterMergeContactA_VerifyContactInfoInContactB(); 	  
	 	}
	@Test  (priority=8)
	  public static void AfterMergeContactA_VerifyContactANotAvailable() throws InterruptedException, AWTException, IOException{
				 
				MergeContact.AfterMergeContactA_VerifyContactANotAvailable(); 	  
	 	}
	
	
}
