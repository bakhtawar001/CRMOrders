
package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Functions.Conversions;
import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.HelpingFunction;


public class Email extends HelpingFunction {
	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
							

				public static void MoveEmailToSpam() throws InterruptedException, AWTException, IOException{
					
					 try 
						 {
							 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
							 Click("Please click at Email button",GetData.NavigateToEmails);
							 Thread.sleep(2000);
							 Click("Please click at All Email button",GetData.MoveToAllEmails);
							 Thread.sleep(2000);
							 Click("Please click at checkbox button",GetData.SelectEmailCheckbox);
							 Click("Please click at checkbox button",GetData.EmailSpamButton);
							 Thread.sleep(2000);
							 Click("Please click at checkbox button",GetData.EmailConfirmButton);
							 Thread.sleep(2000);
							 Assert.assertTrue(GetData.Success.getText().contains("Success"));
							 
						 }
					 catch(NoSuchElementException e)
							{
								e.getMessage();
							}

					} 
							
				public static void DeleteEmailFromAllEmail() throws InterruptedException, AWTException, IOException{
					
					 Thread.sleep(15000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at checkbox button",GetData.SelectEmailCheckbox);
					 Click("Please click at checkbox button",GetData.EmailDeleteButton);
					 Click("Please click at checkbox button",GetData.EmailConfirmButton);
					 Assert.assertTrue(GetData.Success.getText().contains("Success"));

				}
				
				public static void MoveEmailToSpamFromDetailPage() throws InterruptedException, AWTException, IOException{
					
					 
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(2000);
					 Click("Please click at Email button",GetData.EmailDetail);
					 Thread.sleep(2000);
					 Click("Please click at checkbox button",GetData.EmailSpamButton1);
					 Assert.assertTrue(GetData.Success.getText().contains("Success"));

				} 
				
				public static void DeleteEmailFromEmailDetailPage() throws InterruptedException, AWTException, IOException{
					
					 Thread.sleep(10000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Thread.sleep(2000);
					 Click("Please click at Email button",GetData.EmailDetail);
					 Thread.sleep(2000);
					 Click("Please click at checkbox button",GetData.EmailDeleteButton);
					 Click("Click on confirmation message",GetData.confirmationdelete);
					 Assert.assertTrue(GetData.Success.getText().contains("Success"));

					
					

				}

				public static void MoveEmailToNotSpam() throws InterruptedException, AWTException, IOException{
					
						 
						 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						
						 Thread.sleep(5000);
						 Click("Please click at All Email button",GetData.MoveToSpamEmails);
						 Thread.sleep(2000);
						 Click("Please click at checkbox button",GetData.SelectEmailCheckbox);
						 Click("Please click at checkbox button",GetData.EmailNotSpamButton);
						 Click("Please click at checkbox button",GetData.EmailConfirmButton);
						 Assert.assertTrue(GetData.Success.getText().contains("Success"));



					} 
							
				public static void DeleteEmailFromSpam() throws InterruptedException, AWTException, IOException{
					
					 Thread.sleep(5000);
					 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					 Click("Please click at checkbox button",GetData.SelectEmailCheckbox);
					 Click("Please click at checkbox button",GetData.EmailDeleteButton);
					 Click("Please click at checkbox button",GetData.EmailConfirmButton);
					 Assert.assertTrue(GetData.Success.getText().contains("Success"));

					

				}
				
				public static void Email_PurchaseOrder() throws InterruptedException, AWTException, IOException{
					
					test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
					Click("Please click at Email button",GetData.NavigateToEmails);
					Thread.sleep(2000);
					Input("Provide Order no",GetData.SearchEmail,Conversions.Orderno);
					Thread.sleep(5000);
					List<WebElement> SearchEmailResult=driver.findElements(By.xpath("//div[contains(@ng-click,'::vm.go(email.Id)')]//div[contains(@class,'col-xs-7 word-break')]"));
					
					int SearchEmailResultSize=SearchEmailResult.size();
					if(SearchEmailResultSize>0)
					{
						String SearchEmailResultText=driver.findElement(By.xpath("//div[contains(@ng-click,'::vm.go(email.Id)')]//div[contains(@class,'col-xs-7 word-break')]")).getText();
						System.out.println(SearchEmailResultText);
						Assert.assertTrue(SearchEmailResultText.contains(Conversions.Orderno));
					}
					else
					{
						Assert.assertTrue(false);
					}


				}
				
				public static void PromoOfficeDomain() throws InterruptedException, AWTException, IOException{
					
					 try 
						 {
							 test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
							 Click("Please click at Email button",GetData.NavigateToEmails);
							 Thread.sleep(2000);
							 Click("Please click at All Email button",GetData.MoveToAllEmails);
							 Thread.sleep(2000);
							 Assert.assertTrue(GetData.Promoofcdomain.getText().contains("mypromooffice.com"));
						 }
					 catch(NoSuchElementException e)
							{
								e.getMessage();
							}

					} 	  		
}
