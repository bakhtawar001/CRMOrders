package OrderTestCases2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersLocators;


public class DocumentDesign_LogoUploadAndRemove extends OrdersExecution3 {
	public static JavascriptExecutor jse;
	static Robot rb;
   public static void LogoUploadAndRemove_DocumentDesign() throws IOException, InterruptedException, AWTException{
	   
	   try{
			// This is to Instantiate CreateOrders  class  
		 OrdersLocators LogoUpload = PageFactory.initElements(driver, OrdersLocators.class);	
		
		 LogoUpload.ESPWebHomePageLinkText.click();
		 
		//Click the Orders tab
		 LogoUpload.ESPWebHomePage_OrdersTab.click();
		 
		 Thread.sleep(10000);
		 //Goto Settings
		 //Click the userInfoIcon on My Order screen	 
		 LogoUpload.OrderListing_UserInfoIcon.click();
		 
		 Thread.sleep(5000);
		 
	//Click the settings option
		 LogoUpload.UserInfoIcon_Settings.click();
		 
		 Thread.sleep(5000);
		 
		 //Click the Design Documents option in settings
		 LogoUpload.Settings_DocumentDesign.click();
		 
		 Thread.sleep(3000);
		 
	 //    if(!LogoUpload.Documents_Logo_RemoveButton.isDisplayed())
	    	 if(LogoUpload.Documents_LogoUpload_Button.isDisplayed())
	     {
		 
 
		 //Press the Upload Button and Upload invalid file for error message validation check
		 LogoUpload.Documents_LogoUpload_Button.click();
		 
		 Thread.sleep(2000);
		 
		 // creating instance of Robot class (A java based utility)
			
			 rb =new Robot();
			
		// pressing keys with the help of keyPress and keyRelease events
			
			rb.keyPress(KeyEvent.VK_C);
			
			rb.keyRelease(KeyEvent.VK_C);
			
			Thread.sleep(2000);
			
			 
			
			rb.keyPress(KeyEvent.VK_SHIFT);
			
			rb.keyPress(KeyEvent.VK_SEMICOLON);
			
			rb.keyRelease(KeyEvent.VK_SEMICOLON);
			
			rb.keyRelease(KeyEvent.VK_SHIFT);
			
			 
			
			rb.keyPress(KeyEvent.VK_BACK_SLASH);
			
			rb.keyRelease(KeyEvent.VK_BACK_SLASH);
			
			Thread.sleep(2000);
			
			 
			
			rb.keyPress(KeyEvent.VK_I);
			
			rb.keyRelease(KeyEvent.VK_I);
			
			 Thread.sleep(2000);
			
			rb.keyPress(KeyEvent.VK_N);
			
			rb.keyRelease(KeyEvent.VK_N);
			
			Thread.sleep(2000); 
			
			rb.keyPress(KeyEvent.VK_V);
			
			rb.keyRelease(KeyEvent.VK_V);
			
			Thread.sleep(2000);
			
		   
			rb.keyPress(KeyEvent.VK_A);
			
			rb.keyRelease(KeyEvent.VK_A);
			
			Thread.sleep(2000);
			
            rb.keyPress(KeyEvent.VK_L);
			
			rb.keyRelease(KeyEvent.VK_L);
			
			Thread.sleep(2000);
			
			rb.keyPress(KeyEvent.VK_ENTER);
			
			rb.keyRelease(KeyEvent.VK_ENTER);
			
			
			Thread.sleep(1000);
		    
	  	//Validating the Error Message
			if(LogoUpload.Document_LogofileNotSupported_Error.getText().contains("File type not supported"))
			{
				System.out.println("Invalid Format File Upload Error Message Displayed Successfully");
				resultPass("InvalidFormat_LogoUpload_ErrorMessage", "Invalid Format File Upload Error Message Displayed Successfully");
			}
			else{
				System.out.println("Invalid Format File Upload Error Message Displayed UnSuccessfully");
				resultFail("InvalidFormat_LogoUpload_ErrorMessage", "Invalid Format File Upload Error Message Displayed UnSuccessfully");
			
			}
	  	      
			Thread.sleep(2000);
	  	  
			//Press the Upload Button and Upload valid file and Validate file gets uploaded and displayed Successfully
			 LogoUpload.Documents_LogoUpload_Button.click();
			 
			 Thread.sleep(3000);
			 
			 
			// pressing keys with the help of keyPress and keyRelease events
				
				rb.keyPress(KeyEvent.VK_C);
				
				rb.keyRelease(KeyEvent.VK_C);
				
				Thread.sleep(2000);
				
				 
				
				rb.keyPress(KeyEvent.VK_SHIFT);
				
				rb.keyPress(KeyEvent.VK_SEMICOLON);
				
				rb.keyRelease(KeyEvent.VK_SEMICOLON);
				
				rb.keyRelease(KeyEvent.VK_SHIFT);
				
				 
				
				rb.keyPress(KeyEvent.VK_BACK_SLASH);
				
				rb.keyRelease(KeyEvent.VK_BACK_SLASH);
				
				Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_C);
				
				rb.keyRelease(KeyEvent.VK_C);
				
				 Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_A);
				
				rb.keyRelease(KeyEvent.VK_A);
				
				 Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_P);
				
				rb.keyRelease(KeyEvent.VK_P);
				
				Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_ENTER);
				
				rb.keyRelease(KeyEvent.VK_ENTER);
				
				
				Thread.sleep(15000);
			
			//Now Validating as the file uploaded successfully or not
			if(LogoUpload.Documents_LogoDisplay_Verification.isDisplayed())
			{
				System.out.println("Documents Logo Uploaded Successfully");
				resultPass("Valid_Logo_Upload_Settings", "Documents Logo Uploaded Successfully");
			}
			else{
				System.out.println("Documents Logo Uploaded UnSuccessfully");
				resultFail("Valid_Logo_Upload_Settings", "Documents Logo Uploaded UnSuccessfully");
			}
			
			
		//Now remove the Logo
			LogoUpload.Documents_Logo_RemoveButton.click();
			
			if(LogoUpload.Document_LogofileNotSupported_Error.getText().contains("Success"))
			{
			System.out.println("Logo Removed Successfully");
			resultPass("Logo Remove", "Logo Removed Successfully");
			}
			else{
				System.out.println("Logo Removed UnSuccessfully");
				resultFail("Logo Remove", "Logo Removed UnSuccessfully");
			}
			
			Thread.sleep(2000);
			
	//Upload the Document again and save details
			
			LogoUpload.Documents_LogoUpload_Button.click();
			 
			 Thread.sleep(3000);
			 
			 
			// pressing keys with the help of keyPress and keyRelease events
				
				rb.keyPress(KeyEvent.VK_C);
				
				rb.keyRelease(KeyEvent.VK_C);
				
				Thread.sleep(2000);
				
				 
				
				rb.keyPress(KeyEvent.VK_SHIFT);
				
				rb.keyPress(KeyEvent.VK_SEMICOLON);
				
				rb.keyRelease(KeyEvent.VK_SEMICOLON);
				
				rb.keyRelease(KeyEvent.VK_SHIFT);
				
				 
				
				rb.keyPress(KeyEvent.VK_BACK_SLASH);
				
				rb.keyRelease(KeyEvent.VK_BACK_SLASH);
				
				Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_C);
				
				rb.keyRelease(KeyEvent.VK_C);
				
				 Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_A);
				
				rb.keyRelease(KeyEvent.VK_A);
				
				 Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_P);
				
				rb.keyRelease(KeyEvent.VK_P);
				
				Thread.sleep(2000);
				
				rb.keyPress(KeyEvent.VK_ENTER);
				
				rb.keyRelease(KeyEvent.VK_ENTER);
				
				
				Thread.sleep(15000);
				
			//Now press the Save button to save the details for document settings
				LogoUpload.Documents_Settings_SaveButton.click();
				
				Thread.sleep(5000);
				
		//Now validate again after saving changes are saved successfully by validing the logo
				
				jse= (JavascriptExecutor)driver;
		        jse.executeScript("window.scrollBy(0,-250)", "");
		        
		        jse= (JavascriptExecutor)driver;
		        jse.executeScript("window.scrollBy(-250,-500)", "");
		        
		        jse= (JavascriptExecutor)driver;
		        jse.executeScript("window.scrollBy(-500,-750)", "");
		        
		        Thread.sleep(2000);
		        
		 if(LogoUpload.Documents_LogoDisplay_Verification.isDisplayed())
		 {
			 System.out.println("Document design Details saved Successfully");
			 resultPass("DocumentDesign_Details_Verification", "Document design Details saved Successfully");
		 }
		 else{
			 System.out.println("Document design Details saved UnSuccessfully");
			 resultFail("DocumentDesign_Details_Verification", "Document design Details saved UnSuccessfully");
		 }
			
	//If Condition Ends		
	     }		
	     else{
	    	 
	    	//Now remove the Logo
				LogoUpload.Documents_Logo_RemoveButton.click();
				
				Thread.sleep(3000);
	     
	     
				 //Press the Upload Button and Upload invalid file for error message validation check
				 LogoUpload.Documents_LogoUpload_Button.click();
				 
				 Thread.sleep(2000);
				 
				 // creating instance of Robot class (A java based utility)
					
					 rb =new Robot();
					
				// pressing keys with the help of keyPress and keyRelease events
					
					rb.keyPress(KeyEvent.VK_C);
					
					rb.keyRelease(KeyEvent.VK_C);
					
					Thread.sleep(2000);
					
					 
					
					rb.keyPress(KeyEvent.VK_SHIFT);
					
					rb.keyPress(KeyEvent.VK_SEMICOLON);
					
					rb.keyRelease(KeyEvent.VK_SEMICOLON);
					
					rb.keyRelease(KeyEvent.VK_SHIFT);
					
					 
					
					rb.keyPress(KeyEvent.VK_BACK_SLASH);
					
					rb.keyRelease(KeyEvent.VK_BACK_SLASH);
					
					Thread.sleep(2000);
					
					 
					
					rb.keyPress(KeyEvent.VK_I);
					
					rb.keyRelease(KeyEvent.VK_I);
					
					 Thread.sleep(2000);
					
					rb.keyPress(KeyEvent.VK_N);
					
					rb.keyRelease(KeyEvent.VK_N);
					
					Thread.sleep(2000); 
					
					rb.keyPress(KeyEvent.VK_V);
					
					rb.keyRelease(KeyEvent.VK_V);
					
					Thread.sleep(2000);
					
				   
					rb.keyPress(KeyEvent.VK_A);
					
					rb.keyRelease(KeyEvent.VK_A);
					
					Thread.sleep(2000);
					
		            rb.keyPress(KeyEvent.VK_L);
					
					rb.keyRelease(KeyEvent.VK_L);
					
					Thread.sleep(2000);
					
					rb.keyPress(KeyEvent.VK_ENTER);
					
					rb.keyRelease(KeyEvent.VK_ENTER);
					
					
					Thread.sleep(1000);
				    
			  	//Validating the Error Message
					if(LogoUpload.Document_LogofileNotSupported_Error.getText().contains("File type not supported"))
					{
						System.out.println("Invalid Format File Upload Error Message Displayed Successfully");
						resultPass("InvalidFormat_LogoUpload_ErrorMessage", "Invalid Format File Upload Error Message Displayed Successfully");
					}
					else{
						System.out.println("Invalid Format File Upload Error Message Displayed UnSuccessfully");
						resultFail("InvalidFormat_LogoUpload_ErrorMessage", "Invalid Format File Upload Error Message Displayed UnSuccessfully");
					
					}
			  	      
					Thread.sleep(2000);
			  	  
					//Press the Upload Button and Upload valid file and Validate file gets uploaded and displayed Successfully
					 LogoUpload.Documents_LogoUpload_Button.click();
					 
					 Thread.sleep(3000);
					 
					 
					// pressing keys with the help of keyPress and keyRelease events
						
						rb.keyPress(KeyEvent.VK_C);
						
						rb.keyRelease(KeyEvent.VK_C);
						
						Thread.sleep(2000);
						
						 
						
						rb.keyPress(KeyEvent.VK_SHIFT);
						
						rb.keyPress(KeyEvent.VK_SEMICOLON);
						
						rb.keyRelease(KeyEvent.VK_SEMICOLON);
						
						rb.keyRelease(KeyEvent.VK_SHIFT);
						
						 
						
						rb.keyPress(KeyEvent.VK_BACK_SLASH);
						
						rb.keyRelease(KeyEvent.VK_BACK_SLASH);
						
						Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_C);
						
						rb.keyRelease(KeyEvent.VK_C);
						
						 Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_A);
						
						rb.keyRelease(KeyEvent.VK_A);
						
						 Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_P);
						
						rb.keyRelease(KeyEvent.VK_P);
						
						Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_ENTER);
						
						rb.keyRelease(KeyEvent.VK_ENTER);
						
						
						Thread.sleep(15000);
					
					//Now Validating as the file uploaded successfully or not
					if(LogoUpload.Documents_LogoDisplay_Verification.isDisplayed())
					{
						System.out.println("Documents Logo Uploaded Successfully");
						resultPass("Valid_Logo_Upload_Settings", "Documents Logo Uploaded Successfully");
					}
					else{
						System.out.println("Documents Logo Uploaded UnSuccessfully");
						resultFail("Valid_Logo_Upload_Settings", "Documents Logo Uploaded UnSuccessfully");
					}
					
					
				//Now remove the Logo
					LogoUpload.Documents_Logo_RemoveButton.click();
					
					if(LogoUpload.Document_LogofileNotSupported_Error.getText().contains("Success"))
					{
					System.out.println("Logo Removed Successfully");
					resultPass("Logo Remove", "Logo Removed Successfully");
					}
					else{
						System.out.println("Logo Removed UnSuccessfully");
						resultFail("Logo Remove", "Logo Removed UnSuccessfully");
					}
					
					Thread.sleep(2000);
					
			//Upload the Document again and save details
					
					LogoUpload.Documents_LogoUpload_Button.click();
					 
					 Thread.sleep(3000);
					 
					 
					// pressing keys with the help of keyPress and keyRelease events
						
						rb.keyPress(KeyEvent.VK_C);
						
						rb.keyRelease(KeyEvent.VK_C);
						
						Thread.sleep(2000);
						
						 
						
						rb.keyPress(KeyEvent.VK_SHIFT);
						
						rb.keyPress(KeyEvent.VK_SEMICOLON);
						
						rb.keyRelease(KeyEvent.VK_SEMICOLON);
						
						rb.keyRelease(KeyEvent.VK_SHIFT);
						
						 
						
						rb.keyPress(KeyEvent.VK_BACK_SLASH);
						
						rb.keyRelease(KeyEvent.VK_BACK_SLASH);
						
						Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_C);
						
						rb.keyRelease(KeyEvent.VK_C);
						
						 Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_A);
						
						rb.keyRelease(KeyEvent.VK_A);
						
						 Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_P);
						
						rb.keyRelease(KeyEvent.VK_P);
						
						Thread.sleep(2000);
						
						rb.keyPress(KeyEvent.VK_ENTER);
						
						rb.keyRelease(KeyEvent.VK_ENTER);
						
						
						Thread.sleep(15000);
						
					//Now press the Save button to save the details for document settings
						LogoUpload.Documents_Settings_SaveButton.click();
						
						Thread.sleep(5000);
						
				//Now validate again after saving changes are saved successfully by validing the logo
						
						jse= (JavascriptExecutor)driver;
				        jse.executeScript("window.scrollBy(0,-250)", "");
				        
				        jse= (JavascriptExecutor)driver;
				        jse.executeScript("window.scrollBy(-250,-500)", "");
				        
				        jse= (JavascriptExecutor)driver;
				        jse.executeScript("window.scrollBy(-500,-750)", "");
				        
				        Thread.sleep(2000);
				        
				 if(LogoUpload.Documents_LogoDisplay_Verification.isDisplayed())
				 {
					 System.out.println("Document design Details saved Successfully");
					 resultPass("DocumentDesign_Details_Verification", "Document design Details saved Successfully");
				 }
				 else{
					 System.out.println("Document design Details saved UnSuccessfully");
					 resultFail("DocumentDesign_Details_Verification", "Document design Details saved UnSuccessfully");
				 }
	     
	     
	     
	     
	     
	     
	     
	     }
			
			
	  	  
	        
	     }
		
		   catch(NoSuchElementException e){
			   e.getStackTrace();
		   }
		}  
		
			
		public static void resultPass(String sTestName, String sTestCase) throws IOException, InterruptedException {
			try {
				 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				   
					test.log(Status.PASS, sTestName);

				
				 } catch (Exception e)
		{
				 e.printStackTrace();   
		}

		}
		public static void resultFail(String sTestName, String sTestCase) throws IOException, InterruptedException {
			try {
				 test =extent.createTest(new Exception().getStackTrace()[1].getMethodName());
				   
					test.log(Status.FAIL, sTestName);

			 } catch (Exception e)
		{
				 e.printStackTrace();		 
		}    	
		
		
	}
		public static void Hover(WebElement element) {
			Actions action = new Actions(driver);
			action.moveToElement(element).perform();
	}



}
