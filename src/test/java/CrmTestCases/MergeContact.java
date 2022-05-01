package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;

public class MergeContact extends HelpingFunction {
	static String parentWindow;
	static boolean contact;
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	
	public static void CreateContact(boolean contact) throws InterruptedException, AWTException, IOException{
	 	 
	 	 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	 	 if(contact)
	 	 {
	 		 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
	 		 Click("Please click at add Contact button",GetData.AddContact);
	 		Input("Please Enter First Name", GetData.ContactFName, CrmTestData.ContactFName);
	 	 	Input("Please Enter Last Name", GetData.ContactLName, CrmTestData.ContactLName);
	 	 	Select phone = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list =driver.findElements(By.xpath("//select[contains(@ng-model, 'phone.Type')]/option"));	  
	 	 	int size=list.size();
	 	 	Random rand = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n = rand.nextInt(size);
	 	 	phone.selectByIndex(n);
	 	 	Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.CompPhone);
	 	 	Select email = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'email.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list1 =driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]/option"));	  
	 	 	int emailsize=list1.size();
	 	 	Random rand1 = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n1 = rand1.nextInt(emailsize);
	 	 	email.selectByIndex(n1);
	 	 	Input("Please Enter Email", GetData.ContactEMail, CrmTestData.CompEmail);
	 	 	Select website = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'website.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list2 =driver.findElements(By.xpath("//select[contains(@ng-model, 'website.Type')]/option"));	  
	 	 	int websize=list2.size();
	 	 	Random rand2 = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n2 = rand2.nextInt(websize);
	 	 	website.selectByIndex(n2);
	 	 	Input("Please Enter Website", GetData.ContactWebsite, CrmTestData.CompWebsite);
	 	 	Thread.sleep(2000);
	 	 	Input("Please Enter Website", GetData.ContactAddress, CrmTestData.ContactAddress);
	 	 	Thread.sleep(2000);
	 	 	GetData.ContactAddress.sendKeys(Keys.ARROW_DOWN);
	 	 	Thread.sleep(2000);
	 	 	GetData.ContactAddress.sendKeys(Keys.ENTER);
	 	 	Thread.sleep(2000);
	 	 	RecordOwnerAndVisi.SelectUser();
	 	 	RecordOwnerAndVisi.RecordOwn();		 
	 	 	ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
	 	 	Thread.sleep(2000);
	 	 	 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.CompPhone));
	 	 }
	 	 else
	 	 {
	 		Click("Please click at  Contact Link",GetData.NavigatetoContacts);
	 		 Click("Please click at add Contact button",GetData.AddContact);
	 	 	Input("Please Enter First Name", GetData.ContactFName, CrmTestData.ContactBFName);
	 	 	Input("Please Enter Last Name", GetData.ContactLName, CrmTestData.ContactBLName);
	 	 	Select phone = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list =driver.findElements(By.xpath("//select[contains(@ng-model, 'phone.Type')]/option"));	  
	 	 	int size=list.size();
	 	 	Random rand = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n = rand.nextInt(size);
	 	 	phone.selectByIndex(n);
	 	 	Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.ContactBCompPhone);
	 	 	Select email = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'email.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list1 =driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]/option"));	  
	 	 	int emailsize=list1.size();
	 	 	Random rand1 = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n1 = rand1.nextInt(emailsize);
	 	 	email.selectByIndex(n1);
	 	 	Input("Please Enter Email", GetData.ContactEMail, CrmTestData.ContactBCompEmail);
	 	 	Select website = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'website.Type')]")));
	 	 	Thread.sleep(2000);					
	 	 	List<WebElement> list2 =driver.findElements(By.xpath("//select[contains(@ng-model, 'website.Type')]/option"));	  
	 	 	int websize=list2.size();
	 	 	Random rand2 = new Random();
	 	 	// Obtain a number between [0 - size].
	 	 	int n2 = rand2.nextInt(websize);
	 	 	website.selectByIndex(n2);
	 	 	Input("Please Enter Website", GetData.ContactWebsite, CrmTestData.ContactBCompWebsite);
	 	 	Thread.sleep(2000);
	 	 	Input("Please Enter Website", GetData.ContactAddress, CrmTestData.ContactAddress);
	 	 	Thread.sleep(2000);
	 	 	GetData.ContactAddress.sendKeys(Keys.ARROW_DOWN);
	 	 	Thread.sleep(2000);
	 	 	GetData.ContactAddress.sendKeys(Keys.ENTER);
	 	 	Thread.sleep(2000);
	 	 	RecordOwnerAndVisi.SelectUser();
	 	 	RecordOwnerAndVisi.RecordOwn();		 
	 	 	ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
	 	 	Thread.sleep(6000);
	 	 	 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.ContactBCompPhone));
	 	 
	 	 }
		 		
		} 
	
/*	public static void CreateContactB_PrimaryContent() throws InterruptedException, AWTException, IOException{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 MergeContact.CreateContact();
		
	}*/
	
	public static void CreateContact_MergeContactB() throws InterruptedException, AWTException, IOException{
		 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
		 Click("Please click at add Contact button",GetData.AddContact);
		 Input("Please Enter First Name", GetData.ContactFName, CrmTestData.MergeContactFName);
		
		 
		 ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
		 Thread.sleep(6000);
		 String SearchVS=driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.MergeContactFName+"')]")).getText();
	     System.out.println(SearchVS);
	     Thread.sleep(2000);
	     Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.MergeContactFName+"')]")).isDisplayed());
		 		
		} 
	
	public static void CreateContactFromWebsites() throws InterruptedException, AWTException, IOException
	{
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		// waitForPageLoading();
		 Click("Websites Admin",GetData.WebsitesAdmin);
		 waitForPageLoading();
		 Thread.sleep(5000);
		 parentWindow = driver.getWindowHandle();
		 Click("Websites Link",GetData.WebsitesLink);
		 for(String winHandle : driver.getWindowHandles()){
		  	    if(!winHandle.equals(parentWindow)) {
		  	        driver.switchTo().window(winHandle);
		  	    }
		  	}
		 Click("Create Account",GetData.CreateAccount);
		 
		 Input("Provide Firstname ",GetData.FirstName,CrmTestData.FirstName);
		 Input("Provide Lastname",GetData.LastName,CrmTestData.LastName);
		 Input("Provide Companyname",GetData.CompanyName,CrmTestData.CompanyName);
		 Input("Provide WebsitesEmail",GetData.Email,CrmTestData.WebsitesEmail);
		 Input("Provide WebsitesPassword",GetData.WebsitesPassword,CrmTestData.WebsitesPassword);
		 Input("Provide ConfirmWebsitesPassword",GetData.ConfirmPasseord,CrmTestData.ConfirmWebsitesPassword);
		 Click("Create Websites Account",GetData.CreateAccountButton);
		 Thread.sleep(5000);
		 WebDriverWait wait = new WebDriverWait(driver,240);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Profile')]")));
		 Assert.assertTrue(GetData.AccountVerification.isDisplayed());
	 
}
	public static void MergeWebsitesContact_CRM() throws InterruptedException, AWTException, IOException
	{
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 driver.close();
	     
	     Thread.sleep(3000);
	   //Switch back to parent window 
	     driver.switchTo().window(parentWindow);
	     Thread.sleep(3000);
	     Click("a", GetData.CRM);
	     Click("a",GetData.NavigatetoContacts);
	     Input("Search contact created from websites",GetData.SearchContact,CrmTestData.WebsitesEmail);
	     Thread.sleep(3000);
	     Click("Select contact",GetData.ContactDetail);
	     Thread.sleep(2000);
	     Click("Please click at Actionbutton",GetData.ClickAtAction);
		 Thread.sleep(2000);
		 Click("Merge Contact Option",GetData.MergeContact);
		 Click("Click Merge contact B",GetData.MergeSelectContactBDropdown);
		 Input("Provide Contact Name B",GetData.MergeSearchContactB,CrmTestData.CompEmail);
		 Thread.sleep(3000);
		 GetData.MergeSearchContactB.sendKeys(Keys.ENTER);
		 Click("Merge Contact",GetData.MergeContactButton);
		 Click("Confirm Merge Contact",GetData.ConfirmMergeContactButton);
		 Thread.sleep(2000);
		 Assert.assertTrue(GetData.MessageVerification.getText().contains("Error!"));

}


	public static void MergeContactAInToContactB(boolean contactB) throws InterruptedException, AWTException, IOException
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
	     Click("a",GetData.NavigatetoContacts);
	     Thread.sleep(2000);
	     Input("Search contact created from CRM",GetData.SearchContact,CrmTestData.ContactFName);
	     Thread.sleep(2000);
	     Click("Select contact",GetData.ContactDetail);
	     Thread.sleep(2000);
	     Click("Please click at Actionbutton",GetData.ClickAtAction);
		 Thread.sleep(2000);
		 Click("Merge Contact Option",GetData.MergeContact);
		 Click("Click Merge contact B",GetData.MergeSelectContactBDropdown);
		 if(contactB)
		 {
			 
				 Input("Provide Contact Name B",GetData.MergeSearchContactB,CrmTestData.MergeContactFName);

		 }
		 else
		 {
			 
				 Input("Provide Contact Name B",GetData.MergeSearchContactB,CrmTestData.ContactBFName);
		
		 
		 }
		 Thread.sleep(3000);
		 GetData.MergeSearchContactB.sendKeys(Keys.ENTER);
		 Click("Merge Contact",GetData.MergeContactButton);
		 Click("Confirm Merge Contact",GetData.ConfirmMergeContactButton);
		 Thread.sleep(2000);
		 if(contactB)
		 {
			 Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.MergeContactFName+"')]")).isDisplayed());
		 }
		 else
		 {
			 Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'"+CrmTestData.ContactBFName+"')]")).isDisplayed());
		 }
	
	} 

	public static void VerityPrimaryContactData_AfterMergeContactAInToContactB(boolean ContactB) throws InterruptedException, AWTException, IOException
	
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 if(ContactB)
		 {
	   
		 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.CompPhone));
		 Thread.sleep(2000);
		 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.CompEmail));
		 Thread.sleep(2000);
		 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.ContactAddress));
		 }
		 else
		 {
			 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.ContactBCompPhone));
			 Thread.sleep(2000);
			 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.ContactBCompEmail));
			 Thread.sleep(2000);
			 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(CrmTestData.ContactAddress));
		 }
	 
	
	} 
	public static void AfterMergeContactA_VerifyContactInfoInContactB() throws InterruptedException, AWTException, IOException
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Thread.sleep(2000);
		 Verify(CrmTestData.CompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
		 Thread.sleep(2000);
		 Verify(CrmTestData.CompEmail, GetData.EmailVerify.getText(), "EmailAddress is not matching");
		 Thread.sleep(2000);
		 Verify(CrmTestData.CompWebsite, GetData.WebVerify.getText(), "Website is not matching");
	
	} 
	public static void AfterMergeContactA_VerifyContactANotAvailable() throws InterruptedException, AWTException, IOException
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("a",GetData.NavigatetoContacts);
	     Input("Search contact created from CRM",GetData.SearchContact,CrmTestData.FirstName);
	     Thread.sleep(2000);
	     List<WebElement> ContactNotFound =driver.findElements(By.xpath("//div[contains(text(),'No Contacts Found')]"));
	 	 int size=ContactNotFound.size();
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

	public static void CreateContactA_MergeContactBToContactA() throws InterruptedException, AWTException, IOException
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
		 Click("Please click at add Contact button",GetData.AddContact);
		 Input("Please Enter First Name", GetData.ContactFName, CrmTestData.ContactFName);
		 Input("Please Enter Last Name", GetData.ContactLName, CrmTestData.ContactLName);
		 List<WebElement> Phonelist =driver.findElements(By.xpath("//select[contains(@ng-model, 'phone.Type')]/option"));	  
		 int size=Phonelist.size();
	 for(int i=0;i<size;i++)
	 {
		
		 List<WebElement> Phonelist2= driver.findElements(By.xpath("//select[contains(@ng-model, 'phone.Type')]"));
		 Phonelist2.get(i);
		 Select phone = new Select(Phonelist2.get(i));
		 phone.selectByIndex(i);
		 List<WebElement> PhoneNo= driver.findElements(By.xpath("//input[contains(@type,'tel')]"));
		 PhoneNo.get(i).sendKeys(CrmTestData.CompPhoneNo);
		 if(i==size-1 )
			 break;
		 Click("Add Phone",GetData.AddPhone);
		
	
	 }
 
	 List<WebElement> Emaillist =driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]/option"));	  
	 int emailsize=Emaillist.size();
	 for(int i=0;i<size;i++)
	 {
		
		 List<WebElement> Emaillist2= driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]"));
		 Emaillist2.get(i);
		 Select Email= new Select( Emaillist2.get(i));
		 Email.selectByIndex(i);
		 List<WebElement> EmailAddress= driver.findElements(By.xpath("//input[contains(@name,'emailAddress')]"));
		 EmailAddress.get(i).sendKeys(CrmTestData.CompEmail);
		 if(i==size-1 )
			 break;
		 Click("Add Email",GetData.AddEMail);
	
	 }
		 List<WebElement> Websitelist =driver.findElements(By.xpath("//select[contains(@ng-model, 'website.Type')]/option"));  
		 int Websitesize=Websitelist.size();
	 for(int i=0;i<size;i++)
	 {
		
		 List<WebElement> Websitelist2= driver.findElements(By.xpath("//select[contains(@ng-model,'website.Type')]"));
		 Websitelist2.get(i);
		 Select Website = new Select( Websitelist2.get(i));
		 Website.selectByIndex(i);
		 List<WebElement> CompWebsite= driver.findElements(By.xpath("//input[contains(@name,'website')]"));
		 CompWebsite.get(i).sendKeys(CrmTestData.CompWebsite);
		 if(i==size-1 )
			 break;
		 Click("Add Email",GetData.AddWebsite);
	
	 }
	 
		 Click("Please click at Save Contact Save button ",GetData.SaveButton);
		 Thread.sleep(6000);
		 
		 System.out.println(GetData.ContactVerify.getText());
		 System.out.println(CrmTestData.ContactFName+" "+CrmTestData.ContactLName);
		 Verify(CrmTestData.ContactFName+" "+CrmTestData.ContactLName, GetData.ContactVerify.getText(), "Contact is not created");

	 		
	} 
	public static void CreateContactB_MergeContactBToContactA() throws InterruptedException, AWTException, IOException

	{
	 
		test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		MergeContact.CreateContactA_MergeContactBToContactA()	;
	} 

	public static void CompanyPrimaryContacts_IN_MergeContactB()throws InterruptedException, AWTException, IOException
	
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 String CompanyA=driver.findElement(By.xpath("//a[contains(text(),'"+CrmTestData.Company+"')]")).getText();
		 System.out.println(CompanyA);
		 driver.findElement(By.xpath("//a[contains(text(),'"+CrmTestData.Company+"')]")).click();
	
		 List<WebElement> PrimaryContact=driver.findElements(By.xpath("//div[contains(@name,'ackContact')]"));
		 int PrimaryContactSize=PrimaryContact.size();
		 for(int i=0;i<PrimaryContactSize;i++)
		 {
			 String Primarycontact=driver.findElement(By.xpath("//div[contains(@name,'ackContact')]")).getText();
			 System.out.println(Primarycontact);
			 Verify(Primarycontact,CrmTestData.MergeContactFName,"Primary Contact is not matching");
		 }
	 
	 
	} 
	
	
	public static void CompanyPrimaryContacts_CreateOrder_MergeContactB()throws InterruptedException, AWTException, IOException
	
	{
	 
		 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		 
		 String PrimaryAddressCompanyName= GetData.PrimaryAddressComapnyName.getText();
		 System.out.println(PrimaryAddressCompanyName);
		 String PrimaryAddressName= GetData.PrimaryAddressName.getText();
		 System.out.println(PrimaryAddressName);
		 String StatePostalName= GetData.StatePostalName.getText();
		 System.out.println(StatePostalName);
		 String PrimaryAddressCountryName= GetData.PrimaryAddressCountryName.getText();
		 System.out.println(PrimaryAddressCountryName);
		 Thread.sleep(2000);
		 Click("Click on Orders tab",GetData.CompanyOrdertab);
		 Thread.sleep(2000);
		 Click("Create an Order",GetData.CreateOrder);
		 List<WebElement> PrimaryContact=driver.findElements(By.xpath("//order-contact[contains(@ng-model,'vm.order.BillingContact')]/descendant::strong[contains(@class,'address-name ng-binding')]"));
		 String OrdersPrimaryContactCompanyName=PrimaryContact.get(1).getText();
		 System.out.println(OrdersPrimaryContactCompanyName);
		 
		 String OrdersPrimaryAddressName= GetData.OrdersPrimaryAddressName.getText();
		 System.out.println(OrdersPrimaryAddressName);
		 String OrdersStatePostalName= GetData.OrdersStatePostalName.getText();
		 System.out.println(OrdersStatePostalName);
		 String OrdersPrimaryAddressCountryName= GetData.OrdersPrimaryAddressCountryName.getText();
		 System.out.println(OrdersPrimaryAddressCountryName);
		
		 
		 Thread.sleep(2000);
		 Verify(PrimaryAddressCompanyName,OrdersPrimaryContactCompanyName,"Company Name is not correct");
		 Thread.sleep(2000);
		 Verify(PrimaryAddressName,OrdersPrimaryAddressName,"Primary Address is not correct");
		 Thread.sleep(2000);
		 Verify(StatePostalName,OrdersStatePostalName,"State and Postal name is not correct");
		 Thread.sleep(2000);
		 Verify(PrimaryAddressCountryName,OrdersPrimaryAddressCountryName,"Country Name is not correct");
		 
			
	 
	} 



}
