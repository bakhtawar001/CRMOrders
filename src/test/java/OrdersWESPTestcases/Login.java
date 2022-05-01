package OrdersWESPTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.WESPORDER;
//import Master.OrdersExecution2;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;


public class Login extends WESPORDER {

	public static void login(String sUserName, String sPassword) throws IOException, InterruptedException, AWTException{
		try{
	 //Now Insert the login credentials
    	// This is to Instantiate LogIn Page class  
    	 OrdersLocators Login = PageFactory.initElements(driver, OrdersLocators.class);
    	//Enter ASI No
    	 
        Login.ASINo.sendKeys(OrdersTestdata.ASINo);
      
        
    	//Enter Username 
    	 Login.UserName.sendKeys(sUserName);
    	 //Enter Password
    	 Login.Password.sendKeys(sPassword);
    	 
    	 //Wait for few sec
    	 Thread.sleep(8000);
    	 //Now Press the Login ButtonC:/DocP
    	 
    	// Login.LoginButton.click();
    	 
    	 Click("a", Login.LoginButton);
    	 Thread.sleep(25000);
    
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    	try{
    		wait.until(ExpectedConditions.alertIsPresent());
    		 Alert alert = driver.switchTo().alert();		
    		 alert.accept();
    	}
    	catch (Exception e) {
        }
    		
    	     
	        
    
     
		}
		catch (NoSuchElementException e) {
			// TODO: handle exception
		   e.getStackTrace();
		}
	}



	





}