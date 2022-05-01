
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;



public class CompanyScenarios extends HelpingFunction {

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void VerifyStateDD() throws InterruptedException, AWTException, IOException
	{
		
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Input("Please Enter address", GetData.Address, "Country");
			 Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'country')]")));
			 dropdown.selectByVisibleText("United States");
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector("#state > div.ui-select-match.ng-scope > span")).click();
			 String[] expected = {"Alabama (AL)","Alaska (AK)","Arizona (AZ)","Arkansas (AR)", "California (CA)", "Colorado (CO)", "Connecticut (CT)", "Delaware (DE)", "District of Columbia (DC)", "Florida (FL)", "Georgia (GA)", "Hawaii (HI)", "Idaho (ID)", "Illinois (IL)", "Indiana (IN)", "Iowa (IA)", "Kansas (KS)", "Kentucky (KY)", "Louisiana (LA)", "Maine (ME)", "Maryland (MD)", "Massachusetts (MA)", "Michigan (MI)", "Minnesota (MN)", "Mississippi (MS)", "Missouri (MO)", "Montana (MT)", "Nebraska (NE)", "Nevada (NV)", "New Hampshire (NH)", "New Jersey (NJ)", "New Mexico (NM)", "New York (NY)", "North Carolina (NC)", "North Dakota (ND)", "Ohio (OH)", "Oklahoma (OK)", "Oregon (OR)", "Pennsylvania (PA)", "Puerto Rico (PR)", "Rhode Island (RI)", "South Carolina (SC)", "South Dakota (SD)", "Tennessee (TN)","Texas (TX)", "Utah (UT)", "Vermont (VT)", "Virginia (VA)", "Washington (WA)", "West Virginia (WV)", "Wisconsin (WI)", "Wyoming (WY)"};
			 for(int i=0; i<expected.length; i++) 
			 {
					System.out.println(expected[i]);
					String abc="ui-select-choices-row";
					int j=i+1;
				//	System.out.println("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div");
					String str=driver.findElement(By.xpath("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div")).getText();
					if(expected[i].equals(str)) 
					{
						 Verify(expected[i], str,  "State is not matching");

					}
					else 
					{
						 Verify(expected[i], str,  "State is not matching");

					}
					
			}
				 Thread.sleep(5000);
				
				
				 dropdown.selectByVisibleText("Canada");
				 Thread.sleep(2000);
				 driver.findElement(By.cssSelector("#state > div.ui-select-match.ng-scope > span")).click();
				 String[] expectedcan = {"Alberta (AB)","British Columbia (BC)","Manitoba (MB)","New Brunswick (NB)", "Newfoundland and Labrador (NL)", "Northwest Territories (NT)", "Nova Scotia (NS)", "Nunavut (NU)", "Ontario (ON)", "Prince Edward Island (PE)", "Quebec (QC)", "Saskatchewan (SK)", "Yukon (YT)"};
				 for(int m=0; m<expectedcan.length; m++)
				 {
						System.out.println(expectedcan[m]);
						String abc="ui-select-choices-row";
						int n=m+1;
					//	System.out.println("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div");
						String str1=driver.findElement(By.xpath("//div[contains(@ng-attr-id, '"+abc+"')]["+n+"]/span/div")).getText();
					
						if(expectedcan[m].equals(str1)) 
						{
							 Verify(expectedcan[m], str1,  "Canadian State is not matching");
						}
						else
						{
							 Verify(expectedcan[m], str1,  "Canadian State is not matching");
						}

					}
					Click("Navigate to companies", GetData.NavigatetoCompanies);
	}
	
	
	
	
	public static void ValidatingRequiredField() throws InterruptedException, AWTException, IOException
	{
	
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Click("a", GetData.CRM);
			 Thread.sleep(2000);
			 Click("Please click at add company button",GetData.AddComp);
			 Thread.sleep(2000);
			 Click("Please click at Save company button",GetData.SaveButton);
			 Thread.sleep(5000);
			 Assert.assertTrue(driver.findElement(By.xpath("//p[contains(@ng-if, 'vm.form.crmForm.name.$error.required')]")).isDisplayed());
			
	}


	
	public static void CreateComp(String cus) throws InterruptedException, AWTException, IOException
	{
	
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Thread.sleep(5000);
						 String notes=GetData.ResultFound.getText();
						 System.out.println(notes);
						 Click("Please click at add company button",GetData.AddComp);
						 driver.findElement(By.xpath("//span[contains(text(), '"+cus+"')]//../input[contains(@type, 'checkbox')]")).click();
						 Input("Please Enter Company Name", GetData.CompName, CrmTestData.Company);
						 Select phone = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")));
						 Thread.sleep(2000);					
					//	 driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")).click();
						 List<WebElement> list =driver.findElements(By.xpath("//select[contains(@ng-model, 'phone.Type')]/option"));	  
						 int size=list.size();
						 Random rand = new Random();
					    // Obtain a number between [0 - size].
					    int n = rand.nextInt(size);
					    phone.selectByIndex(n);
					    Input("Please Enter Phone", GetData.PhoneNo, CrmTestData.CompPhone);
					    
					    
						 Select email = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'email.Type')]")));
						 Thread.sleep(2000);					
					//	 driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")).click();
						 List<WebElement> list1 =driver.findElements(By.xpath("//select[contains(@ng-model, 'email.Type')]/option"));	  
						 int emailsize=list1.size();
						 Random rand1 = new Random();
					    // Obtain a number between [0 - size].
					    int n1 = rand1.nextInt(emailsize);
					    email.selectByIndex(n1);
 
						 Input("Please Enter Email", GetData.EmailAddress, CrmTestData.CompEmail);
						 
						 Select website = new Select(driver.findElement(By.xpath("//select[contains(@ng-model, 'website.Type')]")));
						 Thread.sleep(2000);					
					//	 driver.findElement(By.xpath("//select[contains(@ng-model, 'phone.Type')]")).click();
						 List<WebElement> list2 =driver.findElements(By.xpath("//select[contains(@ng-model, 'website.Type')]/option"));	  
						 int websize=list2.size();
						 Random rand2 = new Random();
					    // Obtain a number between [0 - size].
					    int n2 = rand2.nextInt(websize);
					    website.selectByIndex(n2);
						 Input("Please Enter Website", GetData.Website, CrmTestData.CompWebsite);
						 
						 Input("Please Enter address", GetData.Address, CrmTestData.Address);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);
					/*
						 driver.findElement(By.cssSelector("#state > div.ui-select-match.ng-scope > span > span.ui-select-match-text.pull-left")).click();
							String[] expected = {"Alabama (AL)","Alaska (AK)","Arizona (AZ)", "Awards & Trophies"};
							for(int i=0; i<expected.length; i++) {
								System.out.println(expected[i]);
								String abc="ui-select-choices-row";
								int j=i+1;
								System.out.println("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div");
								String str=driver.findElement(By.xpath("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div")).getText();
								System.out.println(str);
								if(expected[i].equals(str))
										System.out.println("Verification of values at Position");
								}
					*/		
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						 RecordOwnerAndVisi.Visibility();
						 Click("Please click at Save company button",GetData.BillingInformation);
						 Click("Please click at Save company button",GetData.OpenTerms);
						 Click("Please click at Save company button",GetData.SelectTerms);
						 Click("Please click at Save company button",GetData.OpenPayWith);
						 Click("Please click at Save company button",GetData.SelectPayWith);
						 Click("Please click at Save company button",GetData.OpenShipVia);
						 Click("Please click at Save company button",GetData.SelectShipVia);
			    		Input("Please Enter in search field", GetData.ShipAccountNo, "41111111111111");

						 Click("Please click at Save company button",GetData.SaveButton);
						 Verify(CrmTestData.Company, GetData.CompVerify.getText(),  "Comp is not Creaed");
						 
						 
						 	Click("Please click Main companies link",GetData.NavigatetoCompanies);
						 	 String notes1=GetData.ResultFound.getText();
							 System.out.println(notes1);
							 if(!notes.equals(notes1)) {
								 Assert.assertTrue(true);
							 }
							 else {
								 Assert.assertTrue(false);
							 }
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			    			Thread.sleep(3000);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");
							Click("Please click Main companies link",GetData.Customer);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");
						
							Click("Please click Main companies link",GetData.Supplier);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Supplier company is not showig in all filter");
							Click("Please click Main companies link",GetData.Decorators);
							Verify("No Companies Found", GetData.ResultFound.getText(), " company is  showig in irrelevant filter all filter");
							Click("Please click Main companies link",GetData.Prospects);
							Verify("No Companies Found", GetData.ResultFound.getText(), " company is  showig in irrelevant  filter");
							Click("Please click Main companies link",GetData.Customer);
							Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);
						
						
							}

				public static void CreateCompany(String cus) throws InterruptedException, AWTException, IOException
				{
					
						 Thread.sleep(15000);
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Click("Please click at add company button",GetData.NavigatetoCompanies);
						 Thread.sleep(5000);
						 String notes=GetData.ResultFound.getText();
						 System.out.println(notes);
						 Click("Please click at add company button",GetData.AddComp);
						 Thread.sleep(6000);
						 if(!cus.equals("Customer")) {
							 driver.findElement(By.xpath("//span[contains(text(), 'Customer')]//../input[contains(@type, 'checkbox')]")).click();
							 driver.findElement(By.xpath("//span[contains(text(), '"+cus+"')]//../input[contains(@type, 'checkbox')]")).click();							 
						 }

						 Thread.sleep(2000);						
						 Input("Please Enter Company Name", GetData.CompName, CrmTestData.Company);
						 Input("Please Enter Phone", GetData.PhoneNo, CrmTestData.CompPhone);
						 Input("Please Enter Email", GetData.EmailAddress, CrmTestData.CompEmail);
						 Input("Please Enter Website", GetData.Website, CrmTestData.CompWebsite);
						 Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.SpecialCHaCompPhone);
						 Input("Please Enter address", GetData.Address, CrmTestData.Address);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						 RecordOwnerAndVisi.Visibility();
						 Click("Please click at Save company button",GetData.BillingInformation);
						 Click("Please click at Save company button",GetData.OpenTerms);
						 Click("Please click at Save company button",GetData.SelectTerms);
						 Click("Please click at Save company button",GetData.OpenPayWith);
						 Click("Please click at Save company button",GetData.SelectPayWith);
						 Click("Please click at Save company button",GetData.OpenShipVia);
						 Click("Please click at Save company button",GetData.SelectShipVia);
						 Input("Please Enter in search field", GetData.ShipAccountNo, "41111111111111");
						 Thread.sleep(2000);
						 Click("Please click at Save company button",GetData.SaveButton);
						 Thread.sleep(2000);
						 Verify(CrmTestData.Company, GetData.CompVerify.getText(),  "Comp is not Creaed");
						 Click("Please click Main companies link",GetData.NavigatetoCompanies);
						 String notes1=GetData.ResultFound.getText();
						 System.out.println(notes1);
						/*	 if(!notes.equals(notes1)) 
							 {
								 Assert.assertTrue(true);
							 }
							 else 
							 {
								 Assert.assertTrue(false);
							 }*/
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			    			Thread.sleep(3000);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");

					}

				public static void CreateCompanyB(String cus) throws InterruptedException, AWTException, IOException
				{
					
						 Thread.sleep(15000);
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Click("Please click at add company button",GetData.NavigatetoCompanies);
						 Thread.sleep(5000);
						 String notes=GetData.ResultFound.getText();
						 System.out.println(notes);
						 Click("Please click at add company button",GetData.AddComp);
						 Thread.sleep(6000);
						 if(!cus.equals("Customer")) {
							 driver.findElement(By.xpath("//span[contains(text(), 'Customer')]//../input[contains(@type, 'checkbox')]")).click();
							 driver.findElement(By.xpath("//span[contains(text(), '"+cus+"')]//../input[contains(@type, 'checkbox')]")).click();							 
						 }

						 Thread.sleep(2000);						
						 Input("Please Enter Company Name", GetData.CompName, CrmTestData.CompanyB);
						 Input("Please Enter Phone", GetData.PhoneNo, CrmTestData.CompPhone);
						 Input("Please Enter Email", GetData.EmailAddress, CrmTestData.CompEmail);
						 Input("Please Enter Website", GetData.Website, CrmTestData.CompWebsite);
						 Input("Please Enter  Phone", GetData.ContactPhone, CrmTestData.SpecialCHaCompPhone);
						 Input("Please Enter address", GetData.Address, CrmTestData.Address);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						 RecordOwnerAndVisi.Visibility();
						 Click("Please click at Save company button",GetData.BillingInformation);
						 Click("Please click at Save company button",GetData.OpenTerms);
						 Click("Please click at Save company button",GetData.SelectTerms);
						 Click("Please click at Save company button",GetData.OpenPayWith);
						 Click("Please click at Save company button",GetData.SelectPayWith);
						 Click("Please click at Save company button",GetData.OpenShipVia);
						 Click("Please click at Save company button",GetData.SelectShipVia);
						 Input("Please Enter in search field", GetData.ShipAccountNo, "41111111111111");
						 Thread.sleep(2000);
						 Click("Please click at Save company button",GetData.SaveButton);
						 Thread.sleep(2000);
						 Verify(CrmTestData.CompanyB, GetData.CompVerify.getText(),  "Comp is not Creaed");
						 Click("Please click Main companies link",GetData.NavigatetoCompanies);
						 String notes1=GetData.ResultFound.getText();
						 System.out.println(notes1);
							 if(!notes.equals(notes1)) 
							 {
								 Assert.assertTrue(true);
							 }
							 else 
							 {
								 Assert.assertTrue(false);
							 }
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.CompanyB);
			    			Thread.sleep(3000);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");

					}

				public static void VerifyBillingInfoInOrder() throws InterruptedException, AWTException, IOException{
					//	CrmTestData obj = new CrmTestData();
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Thread.sleep(5000);
						 
						 Click("Please click at add company button",GetData.CompanyOrder);

						 Thread.sleep(2000);
						 Click("Please click at add company button",GetData.CreateOrder);
						 Thread.sleep(10000);
						String CreditTerm= GetData.OpenTerms.getText();
						System.out.println(CreditTerm);
						String PayWith= GetData.OpenPayWith.getText();
						System.out.println(PayWith);
						Assert.assertEquals("Net 15", CreditTerm);
						Assert.assertEquals("MasterCard", PayWith);
						 Click("Please click at add company button",GetData.CloseOrder_Icon);

				}
				
				public static void AddAddress() throws InterruptedException, AWTException, IOException{
					
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 
						 
						 
						 if(GetData.AddressBook.isDisplayed()) {
							 Click("Please click at Address Book link",GetData.AddressBook);
						 }
						 
						 Click("Please click at Address button",GetData.AddAdress);
						 Input("Please Enter address Name", GetData.AddressName, CrmTestData.AddressName);
						 Input("Please Enter address", GetData.Address, CrmTestData.Address);
						 Thread.sleep(2000);
						 GetData.Address.sendKeys(Keys.ARROW_DOWN);
						 Thread.sleep(1000);
						 GetData.Address.sendKeys(Keys.ENTER);
						 Thread.sleep(2000);
						 Input("Please Enter Company Phone", GetData.AddressPhone, CrmTestData.CompPhone);
					if(!GetData.MakePrimary.isSelected()) {
							 ClickAt("Please click at Make Primary checkbox ",GetData.MakePrimary);
						 }
						 Click("Please click at Save button",GetData.SaveAddress);
						 Thread.sleep(1500);
						 System.out.println(GetData.GetPriAdd.getText());
						 Verify(CrmTestData.AddressLine1, GetData.GetPriAdd.getText(), "Address is not matching");
					
						} 
		
			    public static void RShipVerifBwContAndComp() throws InterruptedException, AWTException, IOException{
				    	 
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Verify(CrmTestData.Company, GetData.RshipVericationbetContandComp.getText(), "Company is not linked with contact");
					
						 Click("Please click at company to navigate contact Detail",GetData.RshipVericationbetContandComp);
						 Thread.sleep(5000);
						 Click("Please click at Contact to navigate Company Detail",GetData.RshipVericationbetContandComp);
						 Thread.sleep(5000);
					
			    		} 
				
 	
			    public static void InactiveCompany(boolean b) throws InterruptedException, AWTException, IOException
			    {
			    			
			    			test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			    			//Inactive Company	
			    			if(b) {
			    			

			    				
							Click("Please click Main companies link",GetData.NavigatetoCompanies);
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			    			Thread.sleep(2000);
							Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);
							Thread.sleep(5000);
							Click("Please click at Active button",GetData.ActiveDropDown);
							Thread.sleep(3000);
							Click("Please click at InActive button",GetData.InactiveLink);
							Thread.sleep(2000);
							Click("Please click Main companies link",GetData.NavigatetoCompanies);
							
							Click("Please click Active filter DD companies link",GetData.ActiveFilter);
							Thread.sleep(2000);
							Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
						
							Thread.sleep(10000);
							System.out.println(GetData.ResultFound.getText());
							Verify("No Companies Found", GetData.ResultFound.getText(), "Inactive Company is showing in Active Filter");
							Click("Please click InActive filter DD companies link",GetData.InactiveFilter);
							Thread.sleep(5000);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Inactive Company is not showing in Inactive Filter");
			    			}
			    			else {
			    				Click("Please click Main companies link",GetData.NavigatetoContacts);
				    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ContactFName);
				    			Thread.sleep(2000);
								Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);
				    			Thread.sleep(3500);
								Click("Please click at Active button",GetData.ActiveDropDown);
								Thread.sleep(5000);
							//	Click("Please click at Active button",GetData.InactiveLink);
								driver.findElement(By.cssSelector("#pad-wrapper > div.page-header.clearfix > div.pull-right.actions > div.btn-group.dropdown.open > ul > li > a > ng-content")).click();

								Click("Please click Main companies link",GetData.NavigatetoContacts);
								Thread.sleep(5000);
								Click("Please click Active filter DD companies link",GetData.ActiveFilter);
								Thread.sleep(5000);
								Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ContactFName);
								Click("Please click InActive filter DD companies link",GetData.InactiveFilter);
								Thread.sleep(10000);
								Verify("Number of Contacts: 1", GetData.ResultFound.getText(), "Inactive Contact is not showing in Inactive Filter");
			    			}
			    	} 
			    	
			    public static void CreateCompanyFromMain() throws InterruptedException, AWTException, IOException{
							test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
							Click("Please click Main companies link",GetData.NavigatetoCompanies);

							 Click("Please click at add company button",GetData.AddComp);
							 
							 Input("Please Enter Company Name", GetData.CompName, CrmTestData.Delcomp);
							 Click("Please click at Save company button",GetData.SaveButton);
							 Verify(CrmTestData.Delcomp, GetData.CompVerify.getText(),  "Comp is not Creaed");

			    		
						} 
			    	
			    public static void AddContactToCompany() throws InterruptedException, AWTException, IOException{
					test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(3000);
					 RecordOwnerAndVisi.SelectUser();
					 Thread.sleep(3000);
					 WebElement element1=  GetData.Save;
					 // Configure the Action
					 Actions action = new Actions(driver);

					 //Focus to element
					 action.moveToElement(element1).perform();

					 // To click on the element
					 action.moveToElement(element1).click().perform();
					
					
					 Thread.sleep(2500);
					 Verify("Success", GetData.Success.getText(),  "Contact is not Linked");

					 
				} 

			  
			    

				public static void VerifyCompDetail() throws InterruptedException, AWTException, IOException{
					
					
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Thread.sleep(5000);
						 Verify(CrmTestData.Company,     GetData.CompVerify.getText(), "Comp is not showing similar as we entered");
						 Verify(CrmTestData.CompPhone,   GetData.PhnVerify.getText(), "Phn is not showing similar as we entered");
						 Verify(CrmTestData.CompWebsite, GetData.WebVerify.getText(), "Website is not showing similar as we entered");
						 Verify(CrmTestData.CompEmail,   GetData.EmailVerify.getText(), "Email is not showing similar as we entered");
						 Verify(CrmTestData.AddressLine1, GetData.GetPriAdd.getText(), "Address is not matching");
						 
						 	
				}

		
				
				public static void InactiveCompFromDBoard() throws InterruptedException, AWTException, IOException{
					test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

					 	Click("Please click Main companies link",GetData.NavigatetoCompanies);
					//	Input("Please Enter Company Name", GetData.CompaniesSearchField, CrmTestData.Delcomp);
						Thread.sleep(2000);
					 	Click("Please click Main checkbox",GetData.SelectAllCheckbox);
					 	Thread.sleep(10000);
					 	Click("Please click Inactive",GetData.Status);
						Thread.sleep(3000);
					 	Click("Please click Inactive",GetData.InactiveFromDB);
					 	Thread.sleep(3000);
				 	  	Alert alert=driver.switchTo().alert();
				 	  	alert.accept();
					 
					    Thread.sleep(5000);
						Verify("No Companies Found", GetData.ResultFound.getText(), " company is  showig in irrelevant filter all filter");
					 	Click("Please click Inactive link",GetData.InactiveFilter);
					 	 Thread.sleep(5000);
						Verify("Number of Companies: 1", GetData.ResultFound.getText(), " company is  showig in irrelevant filter all filter");
	 
				 }			
				
				public static void DeleteComp() throws InterruptedException, AWTException, IOException{
					test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

				 Click("Please click Main companies link",GetData.NavigatetoCompanies);
				 Thread.sleep(5000);
				 Click("Please click Inactive",GetData.AllFilter);
				 Thread.sleep(5000);
				 Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Delcomp);
				 Thread.sleep(5000);
    			Click("Please Click at  company",GetData.ClickCompanyName);
    			 Thread.sleep(2000);
    			Click("Please Click at Delete company",GetData.DeleteComp);

				Thread.sleep(1000);
				Click("Please Click at Delete company",GetData.ConfirmDel);
				Thread.sleep(5000);
				//Update Delte company Asserion
				Verify("No Companies Found", GetData.ResultFound.getText(),  "Company is not deleted");
				Click("Please click Inactive",GetData.AllFilter);
				Thread.sleep(5000);
				Verify("No Companies Found", GetData.ResultFound.getText(),  "Company is not deleted");
				
			 	
				}
				

				
				public static void DeleteCompany1() throws InterruptedException, AWTException, IOException{
					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

				 Thread.sleep(5000);
    	//		Click("Please Click at  company",GetData.ClickCompanyName);
    			 Thread.sleep(2000);
    			Click("Please Click at Delete company",GetData.DeleteComp);

				Thread.sleep(1000);
				Click("Please Click at Delete company",GetData.ConfirmDel);
				Thread.sleep(5000);

				
			 	
				}
				
				public static void DeleteCompany() throws InterruptedException, AWTException, IOException{
				 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				 Thread.sleep(5000);
				 Click("Please Click at  company",GetData.ClickCompanyName);
				 Thread.sleep(2000);
				 Click("Please Click at Delete company",GetData.DeleteComp);

				Thread.sleep(1000);
				Click("Please Click at Delete company",GetData.ConfirmDel);
				Thread.sleep(5000);
				//Update Delte company Asserion
				Verify("No Companies Found", GetData.ResultFound.getText(),  "Company is not deleted");
				
			 	
				}
				
				
				public static void DelOrderCompany() throws InterruptedException, AWTException, IOException{
		 			test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
    				Click("Please click Main companies link",CreateOrder.CloseOrder_Icon);
    				 Thread.sleep(5000);
					Click("Please click Main companies link",GetData.CRM);
					Click("Please click	 Main companies link",GetData.NavigatetoCompanies);
	    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
	    			Thread.sleep(2000);
					Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);		
					Thread.sleep(5000);
	    			Click("Please Click at Delete company",GetData.DeleteComp);
	    			Thread.sleep(2000);
					Click("Please click	 Main companies link",GetData.NavigatetoCompanies);
					Verify("Number of Companies: 1", GetData.ResultFound.getText(),  "Company having order not deleted");

					
					}
				
	  		
				public static void ExemptTax() throws InterruptedException, AWTException, IOException{
					Click("Please click	 at CRM ",GetData.CRM);
					Click("Please click	 Main companies link",GetData.NavigatetoCompanies);
				 	//	Input("Please Enter in search field", GetData.CompaniesSearchField,"Auto Thu Mar 04 18:28:50 PKT 2021");
	    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
	    			Thread.sleep(2000);
					Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);		
					Thread.sleep(5000);
					Click("Please click at Edit Company link",GetData.EditComp);		

					Click("Please click at Billing Information link",GetData.BillingInfoLink);		
					Click("Please click at Exempt tax checkbox",GetData.ExemptCheckbox);		
				
					Thread.sleep(5000);
					Click("Please click at Save button",GetData.AddTaxCertificate);	
					Click("Please click at Save button",GetData.AddTaxCertificate);	
					List<WebElement>Certificate=driver.findElements(By.xpath("//tbody/tr"));
					int Size=Certificate.size();
					for(int i=1;i<=Size;i++)
					{
						if(i==1)
						{
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@ng-model,'certificate.Name')]")).sendKeys("C1");
							driver.findElement(By.xpath("//tbody/tr["+i+"]//div[contains(@ng-model,'certificate.State')]/descendant::span")).click();
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys("Alaska");
							Thread.sleep(6000);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys(Keys.ARROW_DOWN);
							Thread.sleep(1000);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys(Keys.ENTER);
				
							Select certificatereason = new Select(driver.findElement(By.xpath("//tbody/tr["+i+"]//select[contains(@ng-model, 'certificate.Reason')]")));
							Thread.sleep(2000);					

							 List<WebElement> list1 =driver.findElements(By.xpath("//tbody/tr["+i+"]//select[contains(@ng-model,'certificate.Reason')]/option"));	  
							 int emailsize=list1.size();
							 Random rand1 = new Random();
						    // Obtain a number between [0 - size].
						    int n1 = rand1.nextInt(emailsize);
						    certificatereason.selectByIndex(n1);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//span[contains(@ng-click,'certificate.showDatePicker=true;')]")).click();
							Click("Move to next month",GetData.CalenderMoveNextMonthIcon);	
							Click("Select the In-hand date",	 GetData.InhandDate_Selection);	 
							Thread.sleep(2000);
						}
						if(i==2)
						{
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@ng-model,'certificate.Name')]")).sendKeys("C2");
							driver.findElement(By.xpath("//tbody/tr["+i+"]//div[contains(@ng-model,'certificate.State')]/descendant::span")).click();
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys("California");
							Thread.sleep(6000);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys(Keys.ARROW_DOWN);
							Thread.sleep(1000);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//input[contains(@type,'search')]")).sendKeys(Keys.ENTER);
				
							Select certificatereason = new Select(driver.findElement(By.xpath("//tbody/tr["+i+"]//select[contains(@ng-model, 'certificate.Reason')]")));
							Thread.sleep(2000);					

							 List<WebElement> list1 =driver.findElements(By.xpath("//tbody/tr["+i+"]//select[contains(@ng-model,'certificate.Reason')]/option"));	  
							 int emailsize=list1.size();
							 Random rand1 = new Random();
						    // Obtain a number between [0 - size].
						    int n1 = rand1.nextInt(emailsize);
						    certificatereason.selectByIndex(n1);
							driver.findElement(By.xpath("//tbody/tr["+i+"]//span[contains(@ng-click,'certificate.showDatePicker=true;')]")).click();
							Click("Move to next month",GetData.CalenderMoveNextMonthIcon);	
							Click("Select the In-hand date",	 GetData.InhandDate_Selection);	 
							Thread.sleep(2000);
						}
					}
					
			
				
				    Click("Please click at Save button",GetData.SaveButton);	
				    
				    Click("Please click at Edit Company link",GetData.EditComp);		
					Click("Please click at Billing Information link",GetData.BillingInfoLink);	
					Thread.sleep(2000);
					Assert.assertTrue(Size>=2);
					}
				
			
		  		
				public static void CreateOrder() throws InterruptedException, AWTException, IOException{
					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 Click("Please click	 at Order ",GetData.Orders);
					 Click("Please click	 at Create Order ",GetData.CreateOrder);
					 Thread.sleep(5000);
					 Click("Please click	 at Create Order ",CreateOrder.CreateOrder_AddProductButton);
					 Thread.sleep(2000);
					 //Go To Product Search Tab in popup
					 CreateOrder.CreateOrder_AddProductPopup_ProductSearchTab.click();
					 //Search the Product which want to associate with order
					 CreateOrder.CreateOrder_AddProductPopup_SearchKeywordField.sendKeys(OrdersTestdata.OrderProduct);
					 Thread.sleep(1000);
					 //Now press Search Button
					 CreateOrder.CreateOrder_AddProductPopup_SearchButton.click();
					 wait = new WebDriverWait(driver, 180);
					 wait.until(ExpectedConditions.elementToBeClickable(CreateOrder.CreateOrder_AddProductPopup_ProductSelection));
					 Thread.sleep(2000);
					 //Now Select the Product
					 CreateOrder.CreateOrder_AddProductPopup_ProductSelection.click();
					 Thread.sleep(2000);
					 //Press the Add Products Button to complete the process
					 js.executeScript("arguments[0].scrollIntoView();",  CreateOrder.CreateOrder_AddProductPopup_AddProductsButton);
					 CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
					 Thread.sleep(25000);
					 //Hover the configure button
					 js.executeScript("arguments[0].scrollIntoView();",  CreateOrder.CreateOrders_ConfigureButton);
					 WebElement HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
					 Hover(HoverConfigure);
					 Thread.sleep(2000);
					 //Now Click the Configure Button
					 CreateOrder.CreateOrders_ConfigureButton.click();
					 Thread.sleep(2000);
					 //Enter The Quantity on Quatity screen
					 CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
					 Thread.sleep(1000);
					 //Press the continue Button
					 Click("a",CreateOrder.CreateOrder_Configure_Continue_Button);
					 //Decoration Optional Screen Appear Press the save button now to create a Order
					 Click("a",CreateOrder.CreateOrder_DecoratorScreen_Save_Button);
					 Thread.sleep(1000);
					 Assert.assertTrue(GetData.CalculatedTax.getText().contains("0.00"));
					// Verify("$0.00", GetData.CalculatedTax.getText(),  "Tax is calculated");
					 
					}
				
				public static void CreateCompany_StateValidation() throws InterruptedException, AWTException, IOException
				{
					
						 Thread.sleep(15000);
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Thread.sleep(5000);
						 Click("Access Companies Tab",GetData.NavigatetoCompanies);
						 Thread.sleep(5000);
						 Click("Please click at add company button",GetData.AddComp);						
						 Input("Please Enter Company Name", GetData.CompName, CrmTestData.CompanyState);
						 Input("Please Enter Phone", GetData.PhoneNo, CrmTestData.CompPhone);
						 Input("Please Enter Email", GetData.EmailAddress, CrmTestData.CompEmail);
						 Input("Please Enter Website", GetData.Website, CrmTestData.CompWebsite);
						 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
						 Input("Please Enter State", GetData.State, CrmTestData.State);
						 Click("Please click at country dropdown",GetData.Country);
						 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
						 Country.selectByVisibleText("United States");
						 
						 Click("Please click at country dropdown",GetData.Statedropdown);
						 List<WebElement> NoOfState=GetData.NoOfStates;
						 int sizestate=NoOfState.size();
						// Get a random value to pick			
						  Random rand21 = new Random();
						// Obtain a number between [0 - size].
						  int n21 = rand21.nextInt(sizestate);
						  NoOfState.get(n21).click();
						 Thread.sleep(2000);
						 String SelectedState=GetData.Statedropdown.getText();
						 System.out.println(SelectedState);
						 RecordOwnerAndVisi.SelectUser();
						 RecordOwnerAndVisi.RecordOwn();
						 RecordOwnerAndVisi.Visibility();
						 Thread.sleep(2000);
						 Click("Please click at Save company button",GetData.SaveButton);
						 Thread.sleep(2000);
						 Click("Please click Main companies link",GetData.NavigatetoCompanies);
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.CompanyState);
			    			Thread.sleep(3000);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Customer company is not showig in all filter");
							Thread.sleep(2000);
							GetData.CompDetails.click();
							Thread.sleep(2000);
							String VerifyState=GetData.StatePostalName.getText();
							System.out.println(VerifyState);
							Thread.sleep(2000);
							Assert.assertTrue(GetData.StatePostalName.getText().contains(SelectedState));
					}
				public static void ValidateState_AddressBook_AddCompanyAddress() throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(3000);
					 Click("Please click at Address Book link",GetData.AddressBook);
					 Click("Please click at Address button",GetData.AddAdress);
					 Input("Please Enter address Name", GetData.AddressName, CrmTestData.SecandaryCompAddress);
					 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
					 Thread.sleep(2000);
					 Input("Please Enter Company Phone", GetData.AddressPhone, CrmTestData.CompPhone);
					 Input("Please Enter State", GetData.State, CrmTestData.State);
					 Click("Please click at country dropdown",GetData.Country);
					 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
					 Country.selectByVisibleText("United States");
					 
					 Click("Please click at country dropdown",GetData.Statedropdown);
					 List<WebElement> NoOfState=GetData.NoOfStates;
					 int sizestate=NoOfState.size();
					// Get a random value to pick				 
					  Random rand21 = new Random();
					// Obtain a number between [0 - size].
					  int n21 = rand21.nextInt(sizestate);
					  NoOfState.get(n21).click();
					 Thread.sleep(2000);
					 String SelectedState=GetData.Statedropdown.getText();
					 System.out.println(SelectedState);
					 Click("Please click at Save button",GetData.SaveAddress);
					 Thread.sleep(1500);
					 List<WebElement> StateOfSecondAddress=driver.findElements(By.xpath("//span[contains(@ng-show,'address.State')]"));
					 String StateOfOtherAddress=StateOfSecondAddress.get(1).getText();
					 System.out.println(StateOfOtherAddress);
					 Verify(StateOfOtherAddress, SelectedState, "State is not matching");
				
					} 
				
				public static void ValidateState_CreateCompanyWhileCreatingOrder() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Settings",GetData.Orders);
					 Thread.sleep(2000); 
					 Click("Please click at Settings",GetData.CreateOrder);
					 
					 GetData.CreateOrderScreen_CompanySearch_Textfield.click();
		    		 Thread.sleep(2000); 
		    		 Input("Provide Company name",GetData.CreateOrderScreen_CompanyField_SendData,"Auto");
		    		 Thread.sleep(6000);
					 Click("Click To Create New Company",GetData.CreateNewCompany);
					 
					 Input("Please Enter address", GetData.CompanyName_Orders, CrmTestData.ContactFirstName);
					 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
					 Input("Please Enter State", GetData.State, CrmTestData.State);
					 Click("Please click at country dropdown",GetData.Country);
					 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
					 Country.selectByVisibleText("United States");
					 
					 Click("Please click at country dropdown",GetData.Statedropdown);
					 List<WebElement> NoOfState=GetData.NoOfStates;
					 int sizestate=NoOfState.size();
					// Get a random value to pick				 
					 Random rand21 = new Random();
						// Obtain a number between [0 - size].
					 int n21 = rand21.nextInt(sizestate);
					 NoOfState.get(n21).click();
					 Thread.sleep(2000);
					 String SelectedState=GetData.Statedropdown.getText();
					 System.out.println(SelectedState);
					 Thread.sleep(2000);
					 Input("Please Enter City", GetData.City, CrmTestData.City);
					 Input("Please Enter PostalCode", GetData.PostalCode, CrmTestData.PostalCode);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.Save);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Thread.sleep(3000);
					 driver.findElement(By.xpath("//button[contains(@ng-click, 'saveAndClose()')]")).click();
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.CRM);
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.NavigatetoCompanies);
					 Thread.sleep(3000);
					 Input("Please Enter address", GetData.CompaniesSearchField, CrmTestData.ContactFirstName);
					 Thread.sleep(2000);
					 GetData.CompDetails.click();
					 Thread.sleep(2000);
					 String VerifyState=GetData.PrimaryAddressCompanyStateName.getText();
					 System.out.println(VerifyState);
					 Thread.sleep(2000);
					 Verify(VerifyState,SelectedState,"State is not matching");
					
		
		  			} 
				public static void CreateContact_StateValidation() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
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
					 RecordOwnerAndVisi.SelectUser();
					 RecordOwnerAndVisi.RecordOwn();
					 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
					 Input("Please Enter State", GetData.State, CrmTestData.State);
					 Click("Please click at country dropdown",GetData.Country);
					 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
					 Country.selectByVisibleText("United States");
					 
					 Click("Please click at country dropdown",GetData.Statedropdown);
					 List<WebElement> NoOfState=GetData.NoOfStates;
					 int sizestate=NoOfState.size();
					// Get a random value to pick			
					 Random rand21 = new Random();
					 // Obtain a number between [0 - size].
					 int n21 = rand21.nextInt(sizestate);
					 NoOfState.get(n21).click();
					// int randomNumber = ThreadLocalRandom.current().nextInt(0, sizestate);
					// Selecting random value
					// NoOfState.get(randomNumber).click();
					 Thread.sleep(2000);
					 String SelectedState=GetData.Statedropdown.getText();
					 System.out.println(SelectedState);
					 ClickAt("Please click at Save Contact Save button ",GetData.EditContactSaveButton);
					
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.PrimaryConatctDetails.getText().contains(SelectedState));
					 //Verify(CrmTestData.CompPhone, GetData.PhnVerify.getText(), "Phone content is not matching");
			
					}
				public static void ValidateState_AddressBook_AddContactAddress() throws InterruptedException, AWTException, IOException{
					
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 if(GetData.AddressBook.isDisplayed()) {
						 Click("Please click at Address Book link",GetData.AddressBook);
					 }
					 
					 Click("Please click at Address button",GetData.AddAdress);
					 Input("Please Enter address Name", GetData.AddressName, CrmTestData.SecandaryCompAddress);
					 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
					 Thread.sleep(2000);
					 Input("Please Enter Company Phone", GetData.AddressPhone, CrmTestData.CompPhone);
					 Input("Please Enter State", GetData.State, CrmTestData.State);
					 Click("Please click at country dropdown",GetData.Country);
					 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
					 Country.selectByVisibleText("United States");
					 
					 Click("Please click at country dropdown",GetData.Statedropdown);
					 List<WebElement> NoOfState=GetData.NoOfStates;
					 int sizestate=NoOfState.size();
					// Get a random value to pick				 
					 Random rand21 = new Random();
						// Obtain a number between [0 - size].
					 int n21 = rand21.nextInt(sizestate);
					 NoOfState.get(n21).click();
					 Thread.sleep(2000);
					 String SelectedState=GetData.Statedropdown.getText();
					 System.out.println(SelectedState);
					 Click("Please click at Save button",GetData.SaveAddress);
					 Thread.sleep(1500);
					
					 List<WebElement> StateOfSecondAddress=driver.findElements(By.xpath("//span[contains(@ng-show,'address.State')]"));
					 String StateOfOtherAddress=StateOfSecondAddress.get(1).getText();
					 System.out.println(StateOfOtherAddress);
					 Thread.sleep(1500);
					 Verify(StateOfOtherAddress, SelectedState, "State is not matching");
				
					} 
				public static void ValidateState_CreateContactWhileCreatingOrder() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at Settings",GetData.Orders);
					 Click("Please click at Settings",GetData.CreateOrder);
					 driver.findElement(By.xpath("//span[contains(text(), 'Enter or Choose Contact')]")).click();
					 driver.findElement(By.xpath("//input[contains(@placeholder, 'Enter or Choose Contact')]")).sendKeys(CrmTestData.ContactFromOrder);
					 driver.findElement(By.xpath("//ng-content[contains(text(), 'Create a new contact named')]")).click();	
					 
					 Input("Please Enter address", GetData.ContactFirstName, CrmTestData.ContactFirstName);
					 Input("Please Enter address", GetData.Address, CrmTestData.CompAddress);
					 Input("Please Enter State", GetData.State, CrmTestData.State);
					 Click("Please click at country dropdown",GetData.Country);
					 Select Country = new Select(driver.findElement(By.xpath("//Select[contains(@id,'country')]")));
					 Country.selectByVisibleText("United States");
					 
					 Click("Please click at country dropdown",GetData.Statedropdown);
					 List<WebElement> NoOfState=GetData.NoOfStates;
					 int sizestate=NoOfState.size();
					// Get a random value to pick				 
					  Random rand21 = new Random();
						// Obtain a number between [0 - size].
					  int n21 = rand21.nextInt(sizestate);
					  NoOfState.get(n21).click();
					 Thread.sleep(2000);
					 String SelectedState=GetData.Statedropdown.getText();
					 System.out.println(SelectedState);
					 Thread.sleep(2000);
					 Input("Please Enter City", GetData.City, CrmTestData.City);
					 Input("Please Enter PostalCode", GetData.PostalCode, CrmTestData.PostalCode);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.Save);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.CloseOrder_Icon);
					 Thread.sleep(3000);
					 Click("Save and close",GetData.SaveandClose);
					 waitForPageLoadSave();
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.CRM);
					 Thread.sleep(3000);
					 Click("Please click at aviator",GetData.NavigatetoContacts);
					 Thread.sleep(3000);
					 Input("Please Enter address", GetData.CompaniesSearchField, CrmTestData.ContactFirstName);
					 Thread.sleep(5000);
					 GetData.CompDetails.click();
					 Thread.sleep(2000);
					 String VerifyState=GetData.PrimaryAddressStateName.getText();
					 System.out.println(VerifyState);
					 Thread.sleep(2000);
					 Verify(VerifyState,SelectedState,"State is not matching");
					//Assert.assertTrue(GetData.PrimaryAddressStateName.getText().contains(SelectedState));
					// Verify("Number of Contacts: 1", GetData.ResultFound.getText(), "Contact is not created");
		
		  			} 
				public static void Elevoio_AddCompany() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click Main companies link",GetData.NavigatetoCompanies);
					 Thread.sleep(2000);
					 Click("Click Elevio Add Company",GetData.elevio_AddCompany);
					// driver.switchTo().frame(nameOrId);
					 Thread.sleep(2000);
					 
					 Assert.assertTrue(GetData.elevio_AddCompany_description.isDisplayed());
				}
				public static void Elevoio_AddContact() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 
					 Click("Click Elevio Add Company",GetData.elevio_AddCompany_CloseWindow);
					 Thread.sleep(2000);
					 Click("Please click Main companies link",GetData.NavigatetoContacts);
					 Thread.sleep(2000);
					 Click("Click Elevio Add Company",GetData.elevio_Contact_Filter);
					 Thread.sleep(2000);
					 Assert.assertTrue(GetData.elevio_Contact_FilterDescription.isDisplayed());
				}
				public static void CreateRelationShipbetweentwoCompanies() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					Click("Please click Main companies link",GetData.NavigatetoCompanies);
					Input("Please Enter in search field", GetData.CompaniesSearchField, "Auto Supplier ASIQA I");
					Thread.sleep(2000);
					GetData.CompDetails.click();
					Click("Click on Link",GetData.AddNewLink);
					Input("Click on Link",GetData.ProvideCompany,CrmTestData.Company);
					Thread.sleep(6000);
					GetData.ProvideCompany.sendKeys(Keys.ARROW_DOWN);
		    		Thread.sleep(1000);
		    		//Select company from company dropdown
		    		GetData.ProvideCompany.sendKeys(Keys.ENTER);
		    		Thread.sleep(2000);
		    		Select Relationship=new Select(GetData.SelectRelationship);
		    		Relationship.selectByVisibleText("is a customer of / is a supplier to");
		    		Click("Save Relationship",GetData.SaveRelationship);
		    		Thread.sleep(2000);
		    		List<WebElement> RelationshipCompanies=driver.findElements(By.xpath("//li[contains(@ng-repeat,'relationship in vm.companyLinks')]/descendant::a"));
		    		System.out.println(RelationshipCompanies.size());
		    		for(int i=1; i<=RelationshipCompanies.size();i++)
		    		{
		    			
		    			System.out.println("//li[" +i+ "][contains(@ng-repeat,'relationship in vm.companyLinks')]/descendant::a");
		    			String CompanyName=driver.findElement(By.xpath("//li[" +i+ "][contains(@ng-repeat,'relationship in vm.companyLinks')]/descendant::a")).getText();
		    			System.out.println(CompanyName);
		    			if(CompanyName.equalsIgnoreCase(CrmTestData.Company))
		    			{
		    				Thread.sleep(2000);
		    				Assert.assertTrue(CompanyName.contains(CrmTestData.Company));
		    				driver.findElement(By.xpath("//li["+i+"][contains(@ng-repeat,'relationship in vm.companyLinks')]/descendant::a")).click();
		    				
		    			}
		    			
		    		}
		    		
		    		Thread.sleep(2000);
		    		Assert.assertEquals(GetData.RelationshipVerification.getText(), CrmTestData.Company);
					
					
				}
				
				public static void CrossVerificationbetweenRelationShipoftwoComapnies() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Click on Supplier Company",GetData.CompanyRelationship);
					 Thread.sleep(2000);
					 Assert.assertEquals(GetData.RelationshipVerification.getText(), "Auto Supplier ASIQA I");
	
				}
				public static void ShipVia_CRM() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 GetData.CRM.click();
					 Thread.sleep(2000);
					 Click("Please click at add company button",GetData.NavigatetoCompanies);
					 Thread.sleep(5000);
					 Click("Please click at add company button",GetData.AddComp);
					 Thread.sleep(6000);
					 Click("Please click at Save company button",GetData.BillingInformation);
					 Click("Please click at Save company button",GetData.OpenShipVia);
					 Input("Enter Order NO", GetData.ProvideShipVia,"Ground");
			   			List<WebElement> list =CreateOrder.Ground_ShipViaDropdown_Values;
			   			int size=list.size();
			   			System.out.println("size of list is:"+size);
			   			for(int i=0;i<size;i++)
			   			{
			   	    	   System.out.println(list.get(i).getText());
			   	    	   if (list.get(i).getText().equalsIgnoreCase("Ground"))
			   	    	   {
			   	    		Assert.assertTrue(true);
			   	    		break;
			   	    	   }
			   			}
			   			
	
				}
				public static void ThirdPartySystemName_VerificationCompanyPage() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Assert.assertTrue(GetData.thirdpartysystemnameVerification_CompanyPage.getText().contains(CrmTestData.thirdpartysystemID));
					 
				}
				public static void ThirdPartySystemName_VerificationContactPage() throws InterruptedException, AWTException, IOException
				{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at add company button",GetData.ContactNavigation);
					 Thread.sleep(5000);
					 Click("Please click at add company button",GetData.AddContact);
					 Thread.sleep(6000);
					 Assert.assertTrue(GetData.thirdpartysystemnameVerification_CompanyPage.getText().contains(CrmTestData.thirdpartysystemID));
					 
				}
				public static void Hover(WebElement element) {
					Actions action = new Actions(driver);
					action.moveToElement(element).perform();
			}
				
}
