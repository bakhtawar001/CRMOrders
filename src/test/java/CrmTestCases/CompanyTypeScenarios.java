
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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


public class CompanyTypeScenarios extends HelpingFunction {

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void VerifyStateDD() throws InterruptedException, AWTException, IOException{
		//	CrmTestData obj = new CrmTestData();
			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(10000);
			 Click("Please click at add company button",GetData.AddComp);
			 Input("Please Enter address", GetData.Address, "Country");
			 Select dropdown = new Select(driver.findElement(By.xpath("//select[contains(@id, 'country')]")));
			 dropdown.selectByVisibleText("United States");
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector("#state > div.ui-select-match.ng-scope > span")).click();
				String[] expected = {"Alabama (AL)","Alaska (AK)","Arizona (AZ)","Arkansas (AR)", "California (CA)", "Colorado (CO)", "Connecticut (CT)", "Delaware (DE)", "District of Columbia (DC)", "Florida (FL)", "Georgia (GA)", "Hawaii (HI)", "Idaho (ID)", "Illinois (IL)", "Indiana (IN)", "Iowa (IA)", "Kansas (KS)", "Kentucky (KY)", "Louisiana (LA)", "Maine (ME)", "Maryland (MD)", "Massachusetts (MA)", "Michigan (MI)", "Minnesota (MN)", "Mississippi (MS)", "Missouri (MO)", "Montana (MT)", "Nebraska (NE)", "Nevada (NV)", "New Hampshire (NH)", "New Jersey (NJ)", "New Mexico (NM)", "New York (NY)", "North Carolina (NC)", "North Dakota (ND)", "Ohio (OH)", "Oklahoma (OK)", "Oregon (OR)", "Pennsylvania (PA)", "Puerto Rico (PR)", "Rhode Island (RI)", "South Carolina (SC)", "South Dakota (SD)", "Tennessee (TN)","Texas (TX)", "Utah (UT)", "Vermont (VT)", "Virginia (VA)", "Washington (WA)", "West Virginia (WV)", "Wisconsin (WI)", "Wyoming (WY)"};
				for(int i=0; i<expected.length; i++) {
					System.out.println(expected[i]);
					String abc="ui-select-choices-row";
					int j=i+1;
				//	System.out.println("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div");
					String str=driver.findElement(By.xpath("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div")).getText();
				
					if(expected[i].equals(str)) {
						 Verify(expected[i], str,  "State is not matching");

					}
					else {
						 Verify(expected[i], str,  "State is not matching");

					}
					
			}
				 Thread.sleep(5000);
				
				
				 dropdown.selectByVisibleText("Canada");
				 Thread.sleep(2000);
				 driver.findElement(By.cssSelector("#state > div.ui-select-match.ng-scope > span")).click();
					String[] expectedcan = {"Alberta (AB)","British Columbia (BC)","Manitoba (MB)","New Brunswick (NB)", "Newfoundland and Labrador (NL)", "Northwest Territories (NT)", "Nova Scotia (NS)", "Nunavut (NU)", "Ontario (ON)", "Prince Edward Island (PE)", "Quebec (QC)", "Saskatchewan (SK)", "Yukon (YT)"};
					for(int m=0; m<expectedcan.length; m++) {
						System.out.println(expectedcan[m]);
						String abc="ui-select-choices-row";
						int n=m+1;
					//	System.out.println("//div[contains(@ng-attr-id, '"+abc+"')]["+j+"]/span/div");
						String str1=driver.findElement(By.xpath("//div[contains(@ng-attr-id, '"+abc+"')]["+n+"]/span/div")).getText();
					
						if(expectedcan[m].equals(str1)) {
							 Verify(expectedcan[m], str1,  "Canadian State is not matching");
						}
						else {
							 Verify(expectedcan[m], str1,  "Canadian State is not matching");
						}
						
						
						
				
					}
					Click("Navigate to companies", GetData.NavigatetoCompanies);
				
			
	}
	
				public static void CreateComp(String cus) throws InterruptedException, AWTException, IOException{
					//	CrmTestData obj = new CrmTestData();
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Thread.sleep(5000);
						 //String notes=GetData.ResultFound.getText();
						 String notes=driver.findElement(By.cssSelector("div[ng-if^='resultList.totalResults']")).getText();
						 System.out.println(notes);
						 Click("Please click at add company button",GetData.AddComp);
						 Thread.sleep(5000);
						
									 
						 if(cus == "Supplier")
						 {
							
							 driver.findElement(By.cssSelector("span[translate*='LABELS.SUPPLIER']")).click(); 
						 }
						 if(cus == "Customer")
						 {
							 driver.findElement(By.cssSelector("span[translate*='LABELS.CUSTOMER']")).click(); 
						 }
						 if(cus == "Decorator")
						 {
							
							 driver.findElement(By.cssSelector("span[translate*='LABELS.DECORATOR']")).click(); 
						 }
						 if(cus == "Prospect")
						 {
							
							 driver.findElement(By.cssSelector("span[translate*='CRM.COMPANIES.PROSPECT']")).click(); 
						 }
						
						// driver.findElement(By.xpath("//span[contains(text(), '"+cus+"')]//../input[contains(@type, 'checkbox')]")).click();

						 Thread.sleep(3000);						
						 Input("Please Enter Company Name", GetData.CompName, CrmTestData.Company);
					//	 String sCustName = driver.findElement(By.cssSelector("input[ng-model='vm.currentCompany.Name']")).getText();
						 Input("Please Enter Phone", GetData.PhoneNo, CrmTestData.CompPhone);
						 Input("Please Enter Email", GetData.EmailAddress, CrmTestData.CompEmail);
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
						 Thread.sleep(3000);
						 Verify(CrmTestData.Company, GetData.CompVerify.getText(),  "Comp is not Creaed");
						 Thread.sleep(3000);
						 
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
						 ClickAt("Please click at Save button",GetData.SaveAddress);
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
				
 	
			    public static void InactiveCompany(boolean b) throws InterruptedException, AWTException, IOException{
			    			
			    			test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
		//Inactive Company	
			    			if(b) {
			    			

			    				
							Click("Please click Main companies link",GetData.NavigatetoCompanies);
			    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
			    			Thread.sleep(2000);
							Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);
							Click("Please click at Active button",GetData.ActiveDropDown);
							Thread.sleep(3000);
							Click("Please click at InActive button",GetData.InactiveLink);
							Click("Please click Main companies link",GetData.NavigatetoCompanies);
							Click("Please click Active filter DD companies link",GetData.ActiveFilter);
							Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
							Thread.sleep(15000);
							System.out.println(GetData.ResultFound.getText());
							Verify("No Companies Found", GetData.ResultFound.getText(), "Inactive Company is showing in Active Filter");
							Click("Please click InActive filter DD companies link",GetData.InactiveFilter);
							Thread.sleep(3500);
							Verify("Number of Companies: 1", GetData.ResultFound.getText(), "Inactive Company is not showing in Inactive Filter");
			    			}
			    			else {
			    				Click("Please click Main companies link",GetData.NavigatetoContacts);
				    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ContactFName);
				    			Thread.sleep(2000);
								Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);
				    			Thread.sleep(3500);
								Click("Please click at Active button",GetData.ActiveDropDown);
							//	Click("Please click at Active button",GetData.InactiveLink);
								driver.findElement(By.cssSelector("#pad-wrapper > div.page-header.clearfix > div.pull-right.actions > div.btn-group.dropdown.open > ul > li > a > ng-content")).click();

								Click("Please click Main companies link",GetData.NavigatetoContacts);
								Click("Please click Active filter DD companies link",GetData.ActiveFilter);
								Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.ContactFName);
								Thread.sleep(5000);
								Verify("No Contacts Found", GetData.ResultFound.getText(), "Inactive contacts is showing in Active Filter");
								Click("Please click InActive filter DD companies link",GetData.InactiveFilter);
								Thread.sleep(3500);
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
					Click("Please click Main companies link",GetData.Save);
					
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
					
					 	Click("Please click Main companies link",GetData.NavigatetoCompanies);
					//	Input("Please Enter Company Name", GetData.CompaniesSearchField, CrmTestData.Delcomp);
						Thread.sleep(2000);
					 	Click("Please click Main checkbox",GetData.SelectAllCheckbox);
					 	Thread.sleep(15000);
					 	Click("Please click Inactive",GetData.Status);
						Thread.sleep(4000);
					 	Click("Please click Inactive",GetData.InactiveFromDB);
					 	Thread.sleep(4000);
				 	  	Alert alert=driver.switchTo().alert();
				 	  	alert.accept();
					 
					    Thread.sleep(5000);
						Verify("No Companies Found", GetData.ResultFound.getText(), " company is  showig in irrelevant filter all filter");
					 	Click("Please click Inactive link",GetData.InactiveFilter);
					 	 Thread.sleep(5000);
						Verify("Number of Companies: 1", GetData.ResultFound.getText(), " company is  showig in irrelevant filter all filter");
	 
				 }			
				
				public static void DeleteComp() throws InterruptedException, AWTException, IOException{

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
				
	public static void DelOrderCompany() throws InterruptedException, AWTException, IOException{
		 			test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
    				Click("Please click Main companies link",CreateOrder.CloseOrder_Icon);
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
	    			Input("Please Enter in search field", GetData.CompaniesSearchField, CrmTestData.Company);
	    			Thread.sleep(2000);
					Click("Please click at company name to see detail  of company",GetData.ClickCompanyName);		
					Thread.sleep(5000);
					Click("Please click at Edit Company link",GetData.EditComp);		

					Click("Please click at Billing Information link",GetData.BillingInfoLink);		
					Click("Please click at Exempt tax checkbox",GetData.ExemptCheckbox);		
					Click("Please click at Save button",GetData.SaveButton);	
					Thread.sleep(5000);
					}
				
			
		  		
				public static void CreateOrder() throws InterruptedException, AWTException, IOException{
					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

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
					   CreateOrder.CreateOrder_AddProductPopup_AddProductsButton.click();
					   
					   Thread.sleep(25000);
					   //Now configuring the product
					  
					   //Hover the configure button
					   WebElement HoverConfigure=CreateOrder.CreateOrders_ConfigureButton;
						Hover(HoverConfigure);
						
						Thread.sleep(1000);
						
						//Now Click the Configure Button
						CreateOrder.CreateOrders_ConfigureButton.click();
						
						Thread.sleep(2000);
						
						//Enter The Quantity on Quatity screen
						CreateOrder.CreateOrder_Configure_QTY_TextField.sendKeys("5");
						
						Thread.sleep(1000);
						
						//Press the continue Button
						CreateOrder.CreateOrder_Configure_Continue_Button.click();
						
						//Decoration Optional Screen Appear Press the save button now to create a Order
						CreateOrder.CreateOrder_DecoratorScreen_Save_Button.click();
				//		Verify("$0.00", GetData.CalculatedTax.getText(),  "Company is not deleted");
					 
					}
				public static void Hover(WebElement element) {
					Actions action = new Actions(driver);
					action.moveToElement(element).perform();
			}
				
}
