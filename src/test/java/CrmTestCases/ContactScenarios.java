
package CrmTestCases;


import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class ContactScenarios extends HelpingFunction {
	static String SelectedConROwn;
// static WebElement DefaultVisi1;
	 static boolean bol;
	 static String parentWindow;
	// static WebElement DefaultVisi2;

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			
			
			    public static void CreateContact(boolean b) throws InterruptedException, AWTException, IOException{
			    	  	 
					  	 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 if(b) {
						 Click("Please click at Actionbutton",GetData.ClickAtAction);
						 Thread.sleep(2000);
						 Click("Please click at Create Contact Link",GetData.CreateContactLink);
						 
						 driver.findElement(By.xpath("//span[contains(text(), 'Billing')]/preceding-sibling::input")).click();
						 driver.findElement(By.xpath("//span[contains(text(), 'Shipping')]/preceding-sibling::input")).click();
						 driver.findElement(By.xpath("//span[contains(text(), 'Acknowledgement')]/preceding-sibling::input")).click();

					 }
					 else {
						 Thread.sleep(3000);
						 System.out.println("Else Part is executed");
						 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
						 Click("Please click at add Contact button",GetData.AddContact);
						
				 	}  

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
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						/* Input("Please Enter address", GetData.Address, CrmTestData.ContactAAddress);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);*/
						 ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
						 Thread.sleep(6000);
						 
						 Verify(CrmTestData.CompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
				
						 		
			    		} 


			    public static void CreateContactWithBillingAddress(boolean b) throws InterruptedException, AWTException, IOException{
			    	  	 
					  	 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 if(b) {
						 Click("Please click at Actionbutton",GetData.ClickAtAction);
						 Thread.sleep(2000);
						 Click("Please click at Create Contact Link",GetData.CreateContactLink);
						 
						 driver.findElement(By.xpath("//span[contains(text(), 'Billing')]/preceding-sibling::input")).click();
						// driver.findElement(By.xpath("//span[contains(text(), 'Shipping')]/preceding-sibling::input")).click();
						// driver.findElement(By.xpath("//span[contains(text(), 'Acknowledgement')]/preceding-sibling::input")).click();

					 }
					 else {
						 Thread.sleep(3000);
						 Click("Please click at Actionbutton",GetData.ClickAtAction);
						 Thread.sleep(2000);
						 Click("Please click at Create Contact Link",GetData.CreateContactLink);
						
				 	}  

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
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						 Input("Please Enter address", GetData.Address, CrmTestData.ContactAAddress);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);
						 ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
						 Thread.sleep(6000);
						 
						 Verify(CrmTestData.CompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
				
						 		
			    		} 
			    
			    public static void AddBillingAddress() throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 
					 
					 
					 if(GetData.AddressBook.isDisplayed()) {
						 Click("Please click at Address Book link",GetData.AddressBook);
					 }
					 
					 Click("Please click at Address button",GetData.AddAdress);
					 Input("Please Enter address Name", GetData.AddressName, CrmTestData.CompBillingAddressName);
					 Input("Please Enter address", GetData.Address, CrmTestData.CompBillingAddress);
					 Thread.sleep(2000);
					 GetData.Address.sendKeys(Keys.ARROW_DOWN);
					 Thread.sleep(1000);
					 GetData.Address.sendKeys(Keys.ENTER);
					 Thread.sleep(2000);
					 Input("Please Enter Company Phone", GetData.AddressPhone, CrmTestData.CompPhone);
					 if(!GetData.MakeBillingAddress.isSelected())
					 {
						 ClickAt("Please click at Make Primary checkbox ",GetData.MakeBillingAddress);
					 }
					 Click("Please click at Save button",GetData.SaveAddress);
					 Thread.sleep(1500);
					
				
					} 
			    public static void VerifyContactBillingAddressInOrder(boolean a) throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			    	
					 Thread.sleep(5000);
					 GetData.RshipVericationbetContandComp.click();
					 Thread.sleep(5000);
					 GetData.CompanyOrder.click();
					 Thread.sleep(5000);
					 GetData.CreateCompanyOrder.click();
					 Thread.sleep(5000);
					 if(a)
					 {
					 Assert.assertTrue( GetData.OrdersBillingAddressName.getText().contains(CrmTestData.ContactAAddress));
					 }
					 else
					 {
						 Assert.assertTrue( GetData.OrdersBillingAddressName.getText().contains(CrmTestData.CompBillingAddress));
					 }
			    }
			    
			    public static void VerifyContactBillingAddressInOrder_OutputDocument() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
					 Thread.sleep(5000);
					 GetData.SavedOrder.click();
					 Thread.sleep(5000);
					 //Press the Preview Button on order details
					 Click("Click Function",GetData.PreviewButton_Orderdetails);
					// waitForPageLoading();
					 Thread.sleep(3000);
					 //Press the Purchase Order document
					// PurchaseOrderPreviewWithDownload.PreviewPopUp_PurchaseOrder.click();
					 Click("a", GetData.PreviewPopUp_SalesOrder);
					 Thread.sleep(3000);
					//Select the Purchase Order Option
				
					
					 
					//First store parent window to switch back
					 parentWindow = driver.getWindowHandle();
					 
					 //Press the Preview Button
					GetData.PreviewPopUp_PreviewButton.click();
					 
					//Switch to new window opened
					  	for(String winHandle : driver.getWindowHandles()){
					  	    if(!winHandle.equals(parentWindow)) {
					  	        driver.switchTo().window(winHandle);
					  	    }
					  	}
					  	  
					  	Thread.sleep(10000);
					  	List<WebElement> billingaddress=driver.findElements(By.xpath("//td[contains(@class,'col-xs-4')]/div[contains(@class,'order-contact-wrapper')]/descendant::address"));
					  	
					  	String BillingAddress=billingaddress.get(1).getText();
					  	System.out.println(BillingAddress);
					  	Thread.sleep(3000);
					  	Assert.assertTrue(BillingAddress.contains(CrmTestData.ContactAAddress));
					  	
					 
				  
			    }
			    
			    public static void VerifyContactBillingAddressInInvoice() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			    	 
			 	    
			    	/* Thread.sleep(5000);
				     driver.close();
				     Thread.sleep(3000);
				     JavascriptExecutor js = (JavascriptExecutor)driver;
				 	js.executeScript("arguments[0].click();",  GetData.ClosePreview_Screen);*/
					
					 Thread.sleep(5000);
					 GetData.CloseOrder_Icon.click();
					 Thread.sleep(5000);
					 
					 GetData.CRM.click();
					 Thread.sleep(5000);
					 Click("Please click at add company button",GetData.NavigatetoCompanies);
					 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
		    			Thread.sleep(3000);
		    		
		   			 GetData.CompDetails.click();
		   			Thread.sleep(3000);
		   			GetData.CompanyOrder.click();
		   			Thread.sleep(2000);
					 GetData.CreateCompanyOrderDropDown.click();
					 GetData.CreateInvoice.click();
					 Thread.sleep(5000);
					 Assert.assertTrue( GetData.OrdersBillingAddressName.getText().contains(CrmTestData.ContactAAddress));
					 
			    	
			    }
			    public static void VerifyCompanyBillingAddressInOrder() throws InterruptedException, AWTException, IOException{
			    	
			    	CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
					/* Thread.sleep(5000);
					 GetData.RshipVericationbetContandComp.click();
					 Thread.sleep(5000);*/
					 GetData.CompanyOrder.click();
					 Thread.sleep(5000);
					 GetData.CreateCompanyOrder.click();
					 Thread.sleep(5000);
					 System.out.println(GetData.OrdersBillingAddressName.getText());
					 Assert.assertTrue( CrmTestData.CompBillingAddress.contains(GetData.OrdersBillingAddressName.getText()));
			    	
			    }
			    public static void VerifyCompanyBillingAddressInQuote() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			    	 Thread.sleep(3000);
					 GetData.CloseOrder_Icon.click();
					 Thread.sleep(3000);
					 GetData.CRM.click();
					 Thread.sleep(5000);
					 Click("Please click at add company button",GetData.NavigatetoCompanies);
					 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
		    			
					 Thread.sleep(3000);
		   			 GetData.CompDetails.click();
		   			 Thread.sleep(3000);
		   			GetData.CompanyOrder.click();
		   			Thread.sleep(2000);
					
					 GetData.CreateCompanyOrderDropDown.click();
					 GetData.CreateQuote.click();
					 Thread.sleep(5000);
					 Assert.assertTrue( CrmTestData.CompBillingAddress.contains(GetData.OrdersBillingAddressName.getText()));
					 
			    	
			    }
			    public static void EditContact_Details() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			    	 Thread.sleep(3000);
					 GetData.EditContact.click();
					 Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.EditCompPhone);
					 Click("Add Email",GetData.AddEMail);
					 Thread.sleep(2000);
					 List<WebElement> Emaillist2= driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]"));
					 Emaillist2.get(1);
					 Select Email= new Select( Emaillist2.get(1));
					 Email.selectByIndex(1);
					 List<WebElement> EmailAddress= driver.findElements(By.xpath("//input[contains(@name,'emailAddress')]"));
					 EmailAddress.get(1).sendKeys(CrmTestData.WebsitesEmail);
					// Input("Please Enter Email", GetData.ContactEMail, CrmTestData.WebsitesEmail);
					 Thread.sleep(2000);
					 Click("Save Contact",GetData.SaveButton);
					
					
					 Thread.sleep(3000);
					 Verify(CrmTestData.EditCompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
					 Thread.sleep(3000);
					
					 Assert.assertTrue( GetData.NonPrimaryEmail.getText().contains(CrmTestData.WebsitesEmail));
			    }
			    public static void Inactive_Conatct() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
			    	 Thread.sleep(3000);
			    	// Click("Click Acive/Inactive dropdown",GetData.ActiveInactiveContact);
			    	// Thread.sleep(2000);
			    	 Click("Click Acive/Inactive dropdown",GetData.InactiveContactoption);
			    	 
			    	 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
			    	 Thread.sleep(3000);
			    	 Click("Click on Inactive filter",GetData.InactiveContactFilter);
			    	 Thread.sleep(2000);
			    	 Input("Please Enter First Name", GetData.SearchContact, CrmTestData.ContactFName);
		    		Thread.sleep(3000);
					Verify("Number of Contacts: 1", GetData.ResultFound.getText(), "Contact is not showig in all filter");
			    	 
					
			    }
			    
			    
			    public static void Delete_Contact() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
					 Thread.sleep(3000);
					 Click("Access Contact",GetData.AccessSearchContact);
					 Thread.sleep(2000);
			    	 Click("Please click at Actionbutton",GetData.ClickAtAction);
					 Thread.sleep(2000);
			    	 Click("Click delete button",GetData.DeleteContact);
			    	
			    	 Thread.sleep(2000);
				    Click("Click confirm delete button",GetData.ConfirmDeleteContact);
				    Thread.sleep(2000);
				    Input("Please Enter First Name", GetData.SearchContact, CrmTestData.ContactFName);
				    Thread.sleep(3000);
				    System.out.println( GetData.ResultFound.getText());
				    Verify("No Contacts Found", GetData.ResultFound.getText(),  "Contact is not deleted");
				
					
					
			    }
			    
			    public static void ImportConatct_ConflictCheckBox() throws InterruptedException, AWTException, IOException{
			    	
			    	 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
					 Thread.sleep(3000);
					 Click("Please click at  Contact Link",GetData.NavigatetoContacts);
					  Thread.sleep(2000);
					 Click("Please click at  Import",GetData.ImportContacts);
					  Thread.sleep(2000);
					 Click("Please click at  CSV button",GetData.CSVContacts);
					  Thread.sleep(2000);
					 if(GetData.ConflictCheckbox.isSelected())
					 {
						 Assert.assertTrue(true);
					 }
		
			    }
			    
			    }
			  		

