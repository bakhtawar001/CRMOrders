
package CrmTestCases;


import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import PageFactoryandTestdata.CrmLocatiors;
import PageFactoryandTestdata.CrmTestData;
import PageFactoryandTestdata.HelpingFunction;


public class Login extends HelpingFunction  {


				public static  void login() throws InterruptedException, AWTException, IOException{
						
					  test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
						SoftAssert assertion =new SoftAssert();
						test = extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASI);
						Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.USER);
					 	Input("Please Enter Password", GetData.Password, CrmTestData.PASS);
					 /*	Input("Please Enter ASI no", GetData.ASINo, CrmTestData.ASINo_Corp);
						Input("Please Enter UserName", GetData.AsiUserName, CrmTestData.Username_Corp);
					 	Input("Please Enter Password", GetData.Password, CrmTestData.Password_Corp);*/
					 	Click("Please click login button",GetData.LoginButton);
					 	
					 	
}
				public static  void IPAddress_Verification() throws InterruptedException, AWTException, IOException{
					
					
					CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
				 	
				 	 driver.get(CrmTestData.ADR);
					 if(driver.getPageSource().contains("10.101.2.22"))
					 {
						Assert.assertTrue(true); 
					 }
					 else
					 {
						 
				 	} Assert.assertTrue(false); 
}

				public static void VerifyExistingDomain() throws InterruptedException, AWTException, IOException{
				
						  test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
						  
						  SoftAssert assertion =new SoftAssert();
						  String url= driver.getCurrentUrl();
						  url = url.replace("esp", "orders");
						  System.out.print(url);
						  HttpURLConnection connection = (HttpURLConnection) new URL (url).openConnection();
						  connection.connect();
								if(connection.getResponseCode()==200)
							       {
										System.out.println("Passed");
										assertion.assertTrue(true);
										assertion.assertAll();
										Thread.sleep(2000);
							       }
							      else 
							       {
										System.out.println("Failed");
										assertion.assertTrue(false);
										assertion.assertAll();
									 	Thread.sleep(2000);

							       }
								
							String response=connection.getResponseMessage();
							connection.disconnect();
							System.out.println(url+" ----> "+ response);

					}
				
					
				}


