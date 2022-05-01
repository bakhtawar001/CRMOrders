package OrdersTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Master.OrdersExecution1;
import PageFactoryandTestdata.OrdersLocators;




public class ProductAndSupplierClickable extends OrdersExecution1 {

	
	
	public static void LinksAreClickable() throws IOException, InterruptedException, AWTException{
           try{
		// This is to Instantiate CreateOrders  class  
   	 OrdersLocators link = PageFactory.initElements(driver, OrdersLocators.class);	
	

/*		List <WebElement> linklist=driver.findElements(By.tagName("a"));
		
			List <WebElement> activelist=new ArrayList <WebElement>();

			
			System.out.println("Size of all links =====>>" + linklist.size());
			
			for(int i=0; i<linklist.size(); i++) {
				
				if(linklist.get(i).getAttribute("href")!=null && (!linklist.get(i).getAttribute("href").contains("javascript"))) {
					activelist.add(linklist.get(i));
				}
			}
			

			System.out.println("Size of active links =====>>" + activelist.size());
			*/
			String[] mylinks = {"//a[contains(@ng-if, 'lineItem.Supplier.AsiNumber')]"};
			
			
			for(int j=0; j<1; j++) {
				String url=driver.findElement(By.xpath(mylinks[j])).getAttribute("href");
				
					HttpURLConnection connection = (HttpURLConnection) new URL (url).openConnection();
					connection.connect();
					if(connection.getResponseCode()==200)
				       {
						System.out.println("Passed");

			 }
				       else 
				       {
							System.out.println("Failed");

				       //    System.out.println(activelist.get(j).getAttribute("href")+" - is Dowm");
				       }
					String response=connection.getResponseMessage();
					connection.disconnect();
					System.out.println(url+" ----> "+ response + j);
			}
		
				Click("Click at product name", link.ProductName);
			Thread.sleep(10000);
			 String parentWindow = driver.getWindowHandle();
			 
			 //Press the Preview Button
			 
			//Switch to new window opened
			  	for(String winHandle : driver.getWindowHandles()){
			  	    if(!winHandle.equals(parentWindow)) {
			  	        driver.switchTo().window(winHandle);
			  	    }
			  	}
			  	Thread.sleep(2000);
			  	
			  	wait = new WebDriverWait(driver, 120);
			    wait.until(ExpectedConditions.elementToBeClickable(link.ProductSearch_TextField));
			
			    Thread.sleep(2000);
			  	
			  	if(link.ProductSearch_TextField.isDisplayed()) {
		  	//	resultPass("Product And Supplier are Clickable","Product AndSupplier are Clickable");	

			}
			else {
		  	//	resultFail("Product And Supplier are not Clickable","Product AndSupplier are not Clickable");	

			}
			  	
			  	driver.close();
		        //
		        Thread.sleep(2000);
		        
		      //Switch back to parent window 
		        driver.switchTo().window(parentWindow);
				
			
	}
   	 
  			

	   catch(NoSuchElementException e){
	    	 System.err.println("NoSuchElementException: " + e.getMessage());
	   }
	}}



