
package CrmTestCases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class RecordOwnerAndVisi extends HelpingFunction {
	public static String UpdateROwn;

	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
						
						
								public static void VerifyVisibility() throws InterruptedException, AWTException, IOException{
									
									test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
								 	GetData.EditComp.click();
								 	Thread.sleep(2000);
								 	assertEquals(bol, GetData.DefaultVisi1.isSelected(), "Default Visibility is not correct");
								 
								 }
								
								public static void UpdatedVisibility() throws InterruptedException, AWTException, IOException{
									
									test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
									Click("Please click aat only the record Owner",GetData.UpdateVisibility);

								 	WebElement UpdatedVisi1 = GetData.UpdateVisibility;
								 	bol=UpdatedVisi1.isSelected();
									Click("Please click at Save company button",GetData.EditContactSaveButton);
									Thread.sleep(4000);
									Click("Edit Company",GetData.EditComp);
								
									Thread.sleep(2000);
									WebElement UpdatedVisi2 = GetData.UpdateVisibility;
								 	assertEquals(bol, UpdatedVisi2.isSelected(), "Updated Visibility is not correct");
									Click("Please click at Save company button",GetData.SaveButton);
								 }
								public static void VerifyRecordOwn() throws InterruptedException, AWTException, IOException{
									 Thread.sleep(10000);
  									 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
									 String GetOwn =GetData.ROwner.getText();
									
									 Assert.assertTrue(GetOwn.contains(SelectedROwn));
									 }
				
								public static  void SelectUser() throws InterruptedException, AWTException, IOException{
									
										 Click("Please click to open records",GetData.OpenRecordDD);

									
									 Thread.sleep(2000);
									 List<WebElement> records = GetData.GetNoOfRecords;
									 
					// Get a random value to pick				 
										 	Random rr = new Random();
											int Low = 0;
											int High = records.size();
											int Result = rr.nextInt(High-Low) + Low;
											int index1=GetData.Getid.getAttribute("id").lastIndexOf("-");
									 	    System.out.println(index1);
									 	    String FirstPart = GetData.Getid.getAttribute("id").substring(0,index1+1);
									 	    System.out.println("First Word "+FirstPart);
									 // Convert int to String	    
											String numberAsString = Integer.toString(Result);
				//Select user	
										String user = FirstPart+numberAsString;
										driver.findElement(By.id(user)).click();
										
								}
								
								public static void RecordOwn() throws InterruptedException, AWTException, IOException{
									
									System.out.println(GetData.GetSelectedROwn.getText());
									System.out.println("Iftikhar");
									SelectedROwn =GetData.GetSelectedROwn.getText();
									System.out.println(SelectedROwn);
									Thread.sleep(2000);
									
								 }
								
								public static void UpdateRecordOwn() throws InterruptedException, AWTException, IOException{
									test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

								 	Click("Please click Main companies link",GetData.NavigatetoCompanies);
									Input("Please Enter Company Name", GetData.CompaniesSearchField, CrmTestData.Delcomp);
									Thread.sleep(2000);
								 	Click("Please click Main companies link",GetData.SelectAllCheckbox);
								 	Click("Please click Main companies link",GetData.ChangeRecordsOwner);
								 	SelectUser();
									UpdateROwn=driver.findElement(By.xpath("//span[contains(@class, 'ui-select-match-text pull-left')]")).getText();
								 	Click("Please click Save button",GetData.Save);
								 	Thread.sleep(5000);
								 	Click("Please click company",GetData.ClickCompanyName);
									Thread.sleep(5000);
									Assert.assertTrue(GetData.ROwner.getText().contains(UpdateROwn));
								 }	
								
									public static void UpdateVisibility() throws InterruptedException, AWTException, IOException{
										test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

								 	Click("Please click Main companies link",GetData.NavigatetoCompanies);
									Input("Please Enter Company Name", GetData.CompaniesSearchField, CrmTestData.Delcomp);
									Thread.sleep(2000);
								 	Click("Please click Main checkbox",GetData.SelectAllCheckbox);
								 	Click("Please clickVisibility",GetData.SetVisibility);
								 	Click("Please clickVisibility",GetData.UpdateVisibility);
								 	Click("Please click Save button",GetData.Save);
									Thread.sleep(2000);

								 	Click("Please click company",GetData.ClickCompanyName);
								 	Click("Please click Edit Company",GetData.EditComp);


									Assert.assertTrue(GetData.UpdateVisibility.isSelected());
								 }	
								
								
											public static void Visibility() throws InterruptedException, AWTException, IOException{
							
												
												bol=GetData.DefaultVisi1.isSelected();
								 }
			  		
}
