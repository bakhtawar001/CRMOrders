
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Functions.Conversions;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;


public class SettingsScenarios extends HelpingFunction {
	public static String Headertext;
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
				public static void AddAddress() throws InterruptedException, AWTException, IOException{
						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 Click("Please click at aviator",GetData.aviator);
						 Click("Please click at Settings",GetData.settings);
						 Click("Please click at Sales Tax",GetData.salestax);
						 System.out.println(GetData.getalladdresses.getText());
						 if(GetData.getalladdresses.getText().contains("Trevose, PA")) {
							 System.out.println("Address is exists");
							 
						 }
						 else{
							 Click("Please click at aviator",GetData.AddAdress);
							 Input("Please Enter address Name", GetData.AddressName, CrmTestData.AddressName);
							 Input("Please Enter address", GetData.Address, CrmTestData.Address);
							 Thread.sleep(2000);
							 GetData.Address.sendKeys(Keys.ARROW_DOWN);
							 Thread.sleep(1000);
							 GetData.Address.sendKeys(Keys.ENTER);
							 Thread.sleep(2000);
							 Click("Please click at aviator",GetData.SaveSettingsAddress);
						 }
 
					
				} 
				
				public static void DeleteAddress() throws InterruptedException, AWTException, IOException{
					 

					 	test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 	 
					  	 List<WebElement> rowbreforeDel = GetData.GetNoOfAddress;
						 System.out.println("No of Address brfore deletion "+ rowbreforeDel.size());
						 
						 int rowbrefore=rowbreforeDel.size();
						 Click("Please click at Del icon",GetData.DelIcon);
						 Thread.sleep(2000);
						 Click("Please click at Confirm deletion button",GetData.ConfirmDel);
						 
						 

						 List<WebElement> rowAfterDel = GetData.GetNoOfAddress;
						 System.out.println("No of Address After deletion "+ rowAfterDel.size());
						 
						 int rowAfter=rowbreforeDel.size();
						 
						 RefreshPage();
						 Thread.sleep(5000);
						 
						 if(rowbrefore!=rowAfter) {
							System.out.println("Address is Deleted");
							Assert.assertNotEquals(rowbrefore, rowAfter);

						 }
						 else {
							 Assert.assertEquals(rowbrefore, rowAfter);
						 }


				}	
				
				public static void CreateRelationship() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 	 Click("Please click at Relationship link",GetData.Relationships);
					 	 
					  	 List<WebElement> rowbreforeCreate = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables before are "+ rowbreforeCreate.size());
						 Click("Please click at Add Relationship button",GetData.AddRelatonShip);
						 Input("Please Enter Farward", GetData.RShipFarward, CrmTestData.RShipFarward);
						 Input("Please Enter Farward Title", GetData.RShipFarwardTitle, CrmTestData.RShipFarwardTitle);
						 Input("Please Enter Reverse", GetData.RShipReverse, CrmTestData.RShipReverse);
						 Input("Please Enter Reverse Title", GetData.RShipReverseTitle, CrmTestData.RShipReverseTitle);
						 Click("Please check the relationship is for Contact",GetData.RShipForContact);
						 Click("Please check the relationship is for Company",GetData.RShipForCompany);
						 Click("Please Click at Save RShip button",GetData.SaveRship);
						 RefreshPage();
					  	 List<WebElement> rowsafter = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables After are "+ rowsafter.size());

						 if(rowbreforeCreate!=rowsafter) {
							System.out.println("Rship is created");

						 }


				}	
				
				
				public static void CreateRelationshipBetweenCompCont() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 	 Click("Please click at Relationship link",GetData.Relationships);
					 	 
					  	 List<WebElement> rowbreforeCreate = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables before are "+ rowbreforeCreate.size());
						 Click("Please click at Add Relationship button",GetData.AddRelatonShip);
						 Input("Please Enter Farward", GetData.RShipFarward, CrmTestData.RShipFarward);
						 Input("Please Enter Farward Title", GetData.RShipFarwardTitle, CrmTestData.RShipFarwardTitle);
						 Input("Please Enter Reverse", GetData.RShipReverse, CrmTestData.RShipReverse);
						 Input("Please Enter Reverse Title", GetData.RShipReverseTitle, CrmTestData.RShipReverseTitle);
						 Click("Please check the relationship is for Contact",GetData.RShipForContact);
						 Click("Please check the relationship is for Company",GetData.RShipForCompany);
						 Click("Please Click at Save RShip button",GetData.SaveRship);
						 RefreshPage();
					  	 List<WebElement> rowsafter = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables After are "+ rowsafter.size());

						 if(rowbreforeCreate!=rowsafter) {
							System.out.println("Rship is created");

						 }
						 Click("Please click at Relationship link",GetData.CRM);
						 Thread.sleep(10000);
						 Click("Please click at Relationship link",GetData.CompDetails);
						 Click("Please click at Relationship link",GetData.AddNewLink);
						 Click("Please click at Relationship link",GetData.AddNewLinkSelect);
						 Thread.sleep(10000);
				//		 Select oSelect = new Select(GetData.RshipDD);
					/*	
						 if(driver.findElement(By.xpath("//label[contains(text(), 'Relationship')]")).isDisplayed()) {
							 Select oSelect = new Select(driver.findElement(By.xpath("//Select[contains(@class, 'form-control ng-pristine ng-valid ng-empty ng-touched')]")));
							 oSelect.selectByIndex(1);
						 }
						*/



				}	
				
				public static void DeleteRelationship() throws InterruptedException, AWTException, IOException{
					 

						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 JavascriptExecutor js = (JavascriptExecutor) driver;
					 	 Click("Please click at Relationship link",GetData.Relationships);
					  	 List<WebElement> rowbreforeDel = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables before Deleting "+ rowbreforeDel.size());
						 int rowbrefore=rowbreforeDel.size();
						  js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(".//*[@class='table-responsive']/table/tbody/tr[" + rowbrefore +"]/td[5]/span/button[2]/i")));
						 driver.findElement(By.xpath(".//*[@class='table-responsive']/table/tbody/tr[" + rowbrefore +"]/td[5]/span/button[2]/i")).click();
						 RefreshPage();
					  	 List<WebElement> rowsafterDel = GetData.GetNoOfRshipRows;
						 System.out.println("No of rows in a tables After are "+ rowsafterDel.size());
						 int rowsafter=rowsafterDel.size();
						 Assert.assertTrue(rowbrefore!=rowsafter);
						


				}	
				public static void AddTeam() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				 	 Click("Please click at Teams link",GetData.Teams);
				 	/* List<WebElement> rowbreforeCreate = GetData.GetNoOfTeamRows;
					 System.out.println("No of teams in a tables before Adding "+ rowbreforeCreate.size());
					 int rowbrefore=rowbreforeCreate.size();*/
					 
					 Click("Please click at Add team button",GetData.AddteamButton);
					 Input("Please Enter Team Name", GetData.TeamName, CrmTestData.TeamName);
					 
					 
					 for (int li=0; li<2; li++) {
						 driver.findElement(By.xpath("//i[contains(@class, 'caret pull-right')]")).click();
						 Thread.sleep(2000);
						 List<WebElement> records = GetData.GetNoOfRecords;

						// Get a random value to pick				 
												 	Random rr = new Random();
													int Low = 0;
													int High = records.size();
													int Result = rr.nextInt(High-Low) + Low;
												    System.out.println(Result);
												    records.get(li).click();
					 }
					 Click("Please click at Save team button",GetData.SaveTeam);
					 Thread.sleep(5000);
					 RefreshPage();
				    Thread.sleep(2000);
				    Input("Search Team",GetData.VerifyTeam,CrmTestData.TeamName);
				    String ab=CrmTestData.TeamName;
				    List<WebElement> rowsafterCreate = driver.findElements(By.xpath("//*[contains(text(), '"+ab+"')]"));
				    int findteam=rowsafterCreate.size();
				    System.out.println(findteam);
					if(findteam==1)
					{
						Verify(CrmTestData.TeamName+" (2)", driver.findElement(By.xpath("//*[contains(text(), '"+ab+"')]")).getText(),  "Team members are not shwoing correctly");


					 }
					else
					{
						Assert.assertTrue(false);
					}
					
				}

				
				public static void DeleteTeam() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 JavascriptExecutor js = (JavascriptExecutor) driver;
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Click("Please click at Teams link",GetData.Teams);
					 
				  	 List<WebElement> rowbreforeCreate = GetData.GetNoOfTeamRows;
					 System.out.println("No of rows in a tables before Deleting "+ rowbreforeCreate.size());
					 int rowbrefore=rowbreforeCreate.size();
					 js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(". //*[@class='table table-striped table-hover table-condensed']/tbody/tr[" + rowbrefore +"]/td[2]/a[2]")));
					 driver.findElement(By.xpath(". //*[@class='table table-striped table-hover table-condensed']/tbody/tr[" + rowbrefore +"]/td[2]/a[2]")).click();
					 RefreshPage();
				  	 List<WebElement> rowsafterCreate = GetData.GetNoOfTeamRows;
					 System.out.println("No of rows in a tables After Deleting "+ rowsafterCreate.size());
					 int rowsafter=rowsafterCreate.size();
					 if(rowbrefore!=rowsafter) {
						System.out.println("team is Deleted");

					 }


			}	
				
				public static void Logout() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(5000);
					 Verify("Dashboard - Login", driver.getTitle(),  "User is not logged out");

			}	
				public static void EditCheckbox_CustomizeOrderNo() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Thread.sleep(2000);
					 Click("Please click at Settings",GetData.settings);
					 
					 
					 Thread.sleep(5000);
					 driver.findElement(By.xpath("//a[contains(text(),'Document Numbers')]")).click();
					 Thread.sleep(2000);
					 if(driver.findElement(By.xpath("//input[contains(@ng-change, 'vm.updateAllowEdit()')]")).isDisplayed())
					 {
						 Assert.assertTrue(true);
					 }
					
					 
		  			} 
				
				public static void CustomizeOrderNo() throws InterruptedException, AWTException, IOException{
					try
					{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Input("Please Enter address Name", GetData.Prefix, "Pre");
					 Thread.sleep(2000);
					 Input("Please Enter address Name", GetData.PostFix, "Post");
					 if(driver.findElement(By.xpath("//input[contains(@ng-change, 'vm.updateAllowEdit()')]")).isSelected()) {
						 driver.findElement(By.xpath("//input[contains(@ng-change, 'vm.updateAllowEdit()')]")).click();
					 }
					 Click("Please click at Settings",GetData.SaveSettingsAddress);
					 Thread.sleep(5000);
					 Click("Please click at Settings",GetData.Orders);
					 Thread.sleep(5000);
					 Click("Please click at Settings",GetData.CreateOrder);
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.Save);
					 Thread.sleep(2000);
					 String orderno=driver.findElement(By.xpath("//span[contains(@ng-show, 'vm.model.Number')]")).getText();
					 Assert.assertTrue(orderno.contains("Pre"));
					 int element = GetData.EditOrderNo.size();
					 Assert.assertEquals(element, 0);
					 

		  			
				}
				catch(NoSuchElementException e){
		   			e.getStackTrace();
		   		}
				finally
				{
					Click("Please click at Settings",GetData.CloseOrder_Icon);
				
				}
}
				
				public static void EditCompanyProfile() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Thread.sleep(2000);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(3000);
					 Click("Please click at Settings",GetData.CompanyProfile);
					 Thread.sleep(3000);
					 String CompanyProfileName=GetData.CompanyProfileName.getText();
					 Input("Provide Company Name",GetData.CompanyProfileName,CrmTestData.CPCompanyName);
					
					 String Email=GetData.CompanyEmailAddress.getText();
					 Input("Provide Email",GetData.CompanyEmailAddress,CrmTestData.CPEmail);
					 String Phone=GetData.Phone.getText();
					 Input("Provide Phoneno",GetData.Phone,CrmTestData.CPPhone);
					 String Website=GetData.CompanyWebsite.getText();
					 Input("Provide Phoneno",GetData.CompanyWebsite,CrmTestData.CPWebsite);
					 Thread.sleep(2000);
					 Click("Save Company Profile",GetData.SaveCompanyProfile);
					 if(CompanyProfileName!=CrmTestData.CPCompanyName)
					 {
						 Assert.assertTrue(true);
					 }
					 if(Email!=CrmTestData.CPEmail)
					 {
						 Assert.assertTrue(true);
					 }
					 if(Phone!=CrmTestData.CPPhone)
					 {
						 Assert.assertTrue(true);
					 }
					 if(Website!=CrmTestData.CPWebsite)
					 {
						 Assert.assertTrue(true);
					 }
					 
				}
				
				public static void ThirdPartySystemName() throws InterruptedException, AWTException, IOException{
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Thread.sleep(2000);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(3000);
					 Click("Please click at Settings",GetData.CompanyProfile);
					 Thread.sleep(3000);
					
					 Input("Provide thirdpartysystemname",GetData.thirdpartysystemname,CrmTestData.thirdpartysystemID);
					
					
					 Thread.sleep(2000);
					 Click("Save Company Profile",GetData.SaveCompanyProfile);
					 String thirdpartyname=GetData.thirdpartysystemname.getAttribute("value");
					 System.out.println(thirdpartyname);
					 Thread.sleep(2000);
					Assert.assertTrue(GetData.thirdpartysystemname.getAttribute("value").contains(CrmTestData.thirdpartysystemID));
				}
				
				public static void SalesTax_MessageValidationOnMorethan100Value() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 RefreshPage();
					 Thread.sleep(2000);
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(5000);
					 Click("Sales Tax", GetData.Settings_SalesTax);
					 if(GetData.Settings_SalesTax_AutoCalculateTaxes_Checkbox.isSelected())
				   	 {
						 GetData.Settings_SalesTax_AutoCalculateTaxes_Checkbox.click();
				   	  		List<WebElement> EditSalesTax=driver.findElements(By.xpath("//button[contains(@title,'Edit')]//ancestor::span"));
				   	  		EditSalesTax.get(0).click();
				   	  		List<WebElement> EditSalesTaxRate=driver.findElements(By.xpath("//tr[contains(@ng-form,'taxForm')]/descendant::td[3]"));
				   	  		EditSalesTaxRate.get(0).sendKeys("101");
				   	  		Thread.sleep(2000);
				   	  		Assert.assertTrue(GetData.SalesTaxValidation.isDisplayed());
				   	  		
				   	 
				   	 }
					 else
					 {
						 List<WebElement> EditSalesTax=driver.findElements(By.xpath("//button[contains(@title,'Edit')]//ancestor::span"));
				   	  		EditSalesTax.get(0).click();
				   	  		Input("Provide Sales Tax",GetData.SalesTaxRate,"101");
				   	  		
				   	  		Thread.sleep(2000);
				   	  		Assert.assertTrue(GetData.SalesTaxValidation.isDisplayed());
					 }
				}	   	

				public static void HeaderFooterContentVerification() throws InterruptedException, AWTException, IOException{
					 

					 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at aviator",GetData.aviator);
					 Click("Please click at Settings",GetData.settings);
					 Thread.sleep(5000);
					 Click("Please click at Settings",GetData.DocumentDesign);
					 List<WebElement> Header= driver.findElements(By.xpath("//div[contains(@class,'note-editable panel-body')]"));
					 Headertext=Header.get(0).getText();
					 System.out.println(Headertext);
					 
					
			}			
				
		public static void OrdersPrefrence_ReadOnly() throws InterruptedException, AWTException, IOException
		{
	 

			test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			Click("Please click at aviator",GetData.aviator);
			Click("Please click at Settings",GetData.settings);
			Thread.sleep(5000);
			Click("Defualt Item Visibilty",GetData.DefaultItemVisibilty);
			if(!GetData.OrdersPrefrence.isSelected())
			{
				Click("Defualt Item Visibilty",GetData.OrdersPrefrence);
			}
			 Click("Save Private Visibility",GetData.TaskDefaultItemVisibilty_Save);
			Thread.sleep(2000);
			Assert.assertTrue(GetData.OrdersPrefrence.isEnabled());

}		
		public static void NonAdmin_OrdersPrefrence_ReadOnly() throws InterruptedException, AWTException, IOException
		{
	 

			 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 JavascriptExecutor executor = (JavascriptExecutor)driver;
			 executor.executeScript("arguments[0].scrollIntoView();", GetData.OrderListing_UserInfoIcon);
			 Click("Profile", GetData.OrderListing_UserInfoIcon);
			 Thread.sleep(2000);
		 	 Click("Click on Logout",GetData.LogoutButton);
		 	 Thread.sleep(2000);
			 Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINONAdmin);
			 Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USERNONAdmin);
			 Input("Please Enter Password", GetData.Password, CrmTestData.PASSNONAdmin);
			 Click("Please click login button",GetData.LoginButton);
			 Thread.sleep(3000);
			 Click("Click orders title tab",CreateOrder.Orders);
			 Thread.sleep(2000);
			 Input("Enter Order NO", CreateOrder.OrderlistingSearch,Conversions.Orderno);
			
			 Thread.sleep(7000);
			 //Select existing created order from Top of the list
			 Click("Click orders title tab",CreateOrder.OrderListing_Orderselection);
			   	
			 waitForPageLoading();
			 List<WebElement> DiscountField=driver.findElements(By.xpath("//input[contains(@name,'defaultDiscount')]"));
			 int DF=DiscountField.size();
			 System.out.println(DF);
			 if(DF==0)
			 {
				Assert.assertTrue(true);
			 }
			 List<WebElement> SalesTax=driver.findElements(By.xpath("//button[contains(text(),'Use Current Rates')]"));
			 int  STax=DiscountField.size();
			 System.out.println( SalesTax);
			 if(STax==0)
			 {
				Assert.assertTrue(true);
			 }
			 
			 
}		
				
}

