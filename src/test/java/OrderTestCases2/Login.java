package OrderTestCases2;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

//import Master.OrdersExecution;
import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;


public class Login extends OrdersExecution3 {

	public static void login() throws IOException, InterruptedException, AWTException{
		try{
	 //Now Insert the login credentials
    	// This is to Instantiate LogIn Page class  
    	 OrdersLocators Login = PageFactory.initElements(driver, OrdersLocators.class);
    	 
    	//Enter ASI No
        Login.ASINo.sendKeys(OrdersTestdata.ASINo);
     	
    	//Enter Username 
    	 Login.UserName.sendKeys(OrdersTestdata.Username);
    	 //Enter Password
    	 Login.Password.sendKeys(OrdersTestdata.Password);
    	 
    	 //Wait for few sec
    	 Thread.sleep(2000);
    	 //Now Press the Login Button
    	 Login.LoginButton.click();
    	 
    	 Thread.sleep(10000);
    	
    	// Switching to Alert        
	        Alert alert = driver.switchTo().alert();		
	        		
	        // Capturing alert message.    
	        String alertMessage= driver.switchTo().alert().getText();		
	        		
	        // Displaying alert message		
	        System.out.println(alertMessage);	
	        Thread.sleep(5000);
	        		
	        // Accepting alert		
	        alert.accept();	
	        
	        Thread.sleep(30000);
	        
	      if(Login.Successfull_ESPOrdersLogin.getText().contains("ESP Orders"))
     {
    	 System.out.println("Loggedin To ESP Orders Successfully");
    	 resultPass("Login", "Loggedin To ESP Orders Successfully");
     }
     else{
    	 System.out.println("Loggedin To ESP Orders UnSuccessfully");
    	 resultFail("Login", "Loggedin To ESP Orders UnSuccessfully");
     }
     
	      
		}
		catch (Exception e) {
			// TODO: handle exception
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

}