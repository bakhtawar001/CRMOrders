package OrdersTestcases;



import java.awt.AWTException;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Master.OrdersExecution1;
//import Master.OrdersExecution2;
import PageFactoryandTestdata.OrdersLocators;
import PageFactoryandTestdata.OrdersTestdata;


public class Login extends OrdersExecution1 {

	public static void login() throws IOException, InterruptedException, AWTException{
	try
		{
			//Now Insert the login credentials
    		// This is to Instantiate LogIn Page class  
    	 	OrdersLocators Login = PageFactory.initElements(driver, OrdersLocators.class);
    	 	//Enter ASI No
    	 	Login.ASINo.sendKeys(OrdersTestdata.ASINo);
    	 	//Enter Username 
    	 	Login.UserName.sendKeys(OrdersTestdata.Username);
    	 	//Enter Password
    	 	Login.Password.sendKeys(OrdersTestdata.Password);
    	 	Click("a", Login.LoginButton);
    	 	Thread.sleep(5000);
    	 	WebDriverWait wait = new WebDriverWait(driver, 15);
     	try
     	{
     		wait.until(ExpectedConditions.alertIsPresent());
     		Alert alert = driver.switchTo().alert();		
     		alert.accept();
     	}
     	catch (Exception e) 
     	{
     	
        }
     	
     		Thread.sleep(2000);
     		Assert.assertTrue(driver.getTitle().contains("CRM") );
     
		}
		catch (NoSuchElementException e) 
		{
			// TODO: handle exception
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
		}
	}



	





}