
package CrmTestCases;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.HelpingFunction;
import PageFactoryandTestdata.OrdersLocators;


public class ExportScenarios extends HelpingFunction {


	public static CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
	public static OrdersLocators CreateOrder = PageFactory.initElements(driver, OrdersLocators.class);	
	public static void ExortCSV() throws InterruptedException, AWTException, IOException{
		//	CrmTestData obj = new CrmTestData();

			 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
			 Thread.sleep(15000);
			 Click("Navigate to CRM", GetData.CRM);

			 Click("Navigate to Companies page",GetData.NavigatetoCompanies);
			 Thread.sleep(15000);
			 List<WebElement> optionCount = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
			 if(optionCount.size()>0) {
				 NotificationBefore=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();		 
			 }
			 else {
				 NotificationBefore="0";
			 }
		
			 Click("Please click Main checkbox",GetData.SelectAllCheckbox);
			 Click("Please click at export button",GetData.ExportButton);
			 Click("Please click at export button",GetData.CSV);
			 Thread.sleep(10000);
	//		 List<WebElement> optionCount1 = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
			 driver.navigate().refresh();
			 Thread.sleep(15000);
			 
			 List<WebElement> optionCount1 = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
			 if(optionCount1.size()>0) {
				 NotificationAfter=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();		 
			 }
			 else {
				 NotificationAfter="0";
			 }
			 
			
			 
			 Assert.assertNotSame(NotificationBefore, NotificationAfter);	 
			 Click("Please click at export button",GetData.ClickNotification);
			 Click("Please click at export button",GetData.DownloadCSV);
			 Thread.sleep(15000);
			//Now Validating as if the Personalization file is downloaded successfully or not
			  	File PersonalizationFile = getLatestFilefromDir(downloadPath);
				String PersonalizationDownload = PersonalizationFile.getName();
				
				 if(PersonalizationDownload.contains("ESPCRM")){
					 System.out.println("CSV File Exported Successfully");
						Assert.assertTrue(true);							 }
				 else{
					 System.out.println("CSV File not Exported ");
				 }
			 
			 
			

			} 
				public static void ExportCompanyQB() throws InterruptedException, AWTException, IOException{
					//	CrmTestData obj = new CrmTestData();

						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						
						 Thread.sleep(5000);
						 
						 List<WebElement> optionCount = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
						 if(optionCount.size()>0) {
							 NotificationBefore=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();	
							 System.out.println(NotificationBefore);
						 }
						 else {
							 NotificationBefore="0";
						 }
						 Click("Please click Main checkbox",GetData.SelectAllCheckbox);
						 Click("Please click at export button",GetData.ExportButton);
						 Click("Please click at export button",GetData.QB);
						 Thread.sleep(5000);
						 driver.navigate().refresh();
						 Thread.sleep(10000);
						 NotificationAfter=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();	
						 System.out.println(NotificationAfter);

						 Assert.assertNotSame(NotificationBefore, NotificationAfter);	 
						 Click("Please click at export button",GetData.ClickNotification);
						 Click("Please click at export button",GetData.DownloadCSV);
						 Thread.sleep(20000);
						//Now Validating as if the Personalization file is downloaded successfully or not
						  	File PersonalizationFile = getLatestFilefromDir(downloadPath);
							String PersonalizationDownload = PersonalizationFile.getName();
							 Thread.sleep(5000);
							 if(PersonalizationDownload.contains("ESPCRM")){
								 System.out.println("QB File Exported Successfully");
									Assert.assertTrue(true);							 }
							 else{
								 System.out.println("QB File not Exported ");
								 Assert.assertTrue(false);								
							 }
						 
					
		
						} 
			
				
				public static void ExportContactCSV() throws InterruptedException, AWTException, IOException{
					//	CrmTestData obj = new CrmTestData();

						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());

						 Thread.sleep(5000);
						 Click("Please click at export button",GetData.NavigatetoContacts);
						Input("Please Enter ASI no", GetData.CompaniesSearchField, "Auto");
						Thread.sleep(10000);
						 Click("Please click Main checkbox",GetData.SelectAllCheckbox);

						 List<WebElement> optionCount = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
						 System.out.println(optionCount.size());
						 if(optionCount.size()>0) {
							 NotificationBefore=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();		 
						 }
						 else {
							 NotificationBefore="0";
						 }
						 
						 Click("Please click at export button",GetData.ExportContactCSV);
						 Thread.sleep(10000);
						 List<WebElement> optionCount1 = driver.findElements(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]"));
						 System.out.println(optionCount1.size());
			//			 int Count2=optionCount1.size();
						 driver.navigate().refresh();
						 Thread.sleep(15000);
						 NotificationAfter=driver.findElement(By.xpath("//div[contains(@class, 'badge pull-right ng-binding ng-scope')]")).getText();		 
						 Assert.assertNotSame(NotificationBefore, NotificationAfter);	 
						 Click("Please click at export button",GetData.ClickNotification);
						 Click("Please click at export button",GetData.DownloadCSV);
						 Thread.sleep(20000);
						//Now Validating as if the Personalization file is downloaded successfully or not
						  	File PersonalizationFile = getLatestFilefromDir(downloadPath);
							String PersonalizationDownload = PersonalizationFile.getName();
							 Thread.sleep(5000);
							 if(PersonalizationDownload.contains("ESPCRM")){
								 System.out.println("Contact CSV File Exported Successfully");
									Assert.assertTrue(true);							 }
							 else{
								 System.out.println("Contact CSV File not Exported ");
								 Assert.assertTrue(false);								
							 }
						 
						
						
		
						} 
				
				
				public static void ExportoVcard() throws InterruptedException, AWTException, IOException{
					//	CrmTestData obj = new CrmTestData();

						 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						 driver.navigate().refresh();
						 Thread.sleep(5000);
						 Input("Please Enter ASI no", GetData.CompaniesSearchField, "Auto");
							Thread.sleep(10000);
							WebElement HoverVcard=GetData.ClickCompanyName;
							Hover(HoverVcard);
							Thread.sleep(3000);
							 Click("Please click at export button",GetData.VcardIcon);

						 Click("Please click at export button",GetData.ExportVcard);
						 Thread.sleep(15000);
						//Now Validating as if the Personalization file is downloaded successfully or not
				  	File PersonalizationFile = getLatestFilefromDir(downloadPath);
							String PersonalizationDownload = PersonalizationFile.getName();
							
							 if(PersonalizationDownload.contains("Auto") || PersonalizationDownload.contains("auto")){
								 System.out.println("CSV File Exported Successfully");
									Assert.assertTrue(true);							 }
							 else{
								 System.out.println("CSV File not Exported ");
								 Assert.assertTrue(false);								
							 }
						
						
						
		
						} 

		
				public static void Hover(WebElement element) {
					Actions action = new Actions(driver);
					action.moveToElement(element).perform();
			}
				public static File getLatestFilefromDir(String dirPath){
				    File dir = new File(dirPath);
				    File[] files = dir.listFiles();
				    if (files == null || files.length == 0) {
				        return null;
				    }

				    File lastModifiedFile = files[0];
				    for (int i = 1; i < files.length; i++) {
				       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				           lastModifiedFile = files[i];
				       }
				    }
				    return lastModifiedFile;
				}
				
}
