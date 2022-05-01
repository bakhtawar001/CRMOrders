package PageFactoryandTestdata;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.common.base.Predicate;

public class HelpingFunction{

	protected static WebDriver driver;
	protected static String dest;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public static WebDriverWait wait;
	protected static String GetRecordsOwner;
	protected static String NotificationBefore;
	protected static String NotificationAfter;
	protected static boolean bol;
	public static String SelectedROwn;
	public static String browser="chrome";
	public static String TaskCurdat;
	static Predicate<WebDriver> pageLoaded;
	
	protected static String envirnment=CrmTestData.prod;
			
				static String user=System.getProperty("user.name");
				public static String downloadPath = "C:\\Users\\"+user+"\\Downloads";
			public static void Input(String message, WebElement key,String value){
					try {
						key.clear();
						key.sendKeys(value);
					}	
					catch (NoSuchElementException e) {
						System.err.println("NoSuchElementException: " + e.getMessage());
					}	
				}

			public static void RefreshPage() throws InterruptedException{
					Thread.sleep(2000);
					driver.navigate().refresh();
					Thread.sleep(6000);

			}
	
	
	
			protected static void Click(String abc, WebElement key)
			{
					try {
						
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", key);
					
						
						
					}
					catch (IndexOutOfBoundsException e) {
						System.err.println("IndexOutOfBoundsException: " + e.getMessage());
					}	
					 
					catch (NoSuchElementException b) {
						System.err.println("NoSuchElementException: " + b.getMessage());
					}	
			}

			public static void ClickAt(String abc, WebElement key){
					try {
						key.click();
						
					}
						catch (IndexOutOfBoundsException e) {
							System.err.println("IndexOutOfBoundsException: " + e.getMessage());
						}	
			}
			
			
			

			
			public static void Verify(String expected, String actual, String mesage){
				try {
    			SoftAssert assertion =new SoftAssert();
    			assertion.assertEquals(expected, actual, mesage);
    			assertion.assertAll();
				}
				catch (IndexOutOfBoundsException e) {
					System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				}	
			}
			
			public static void VerifySearch(String a, String b, String c){
				try {
    			SoftAssert assertion =new SoftAssert();
    			assertion.assertNotEquals(a, b, c);
    			assertion.assertAll();
				}
				catch (IndexOutOfBoundsException e) {
					System.err.println("IndexOutOfBoundsException: " + e.getMessage());
				}	
			}

			
			public static void Hover(WebElement element) {
				Actions action = new Actions(driver);
				action.moveToElement(element).perform();
				
			}
			
			public static void HoverandClick(WebElement element,WebElement ClickElement, WebDriver driver) {
				
				Actions action = new Actions(driver);
				action.moveToElement(element).click(ClickElement).build().perform();
				
				
			}
			
			public static void waitForPageLoading() throws InterruptedException {
				try {
				 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				    pageLoaded = new Predicate<WebDriver>() {

				        public boolean apply(WebDriver input) {
				            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
				        }

				    };
				  // wait.until(pageLoaded) ;
				    System.out.println("Page Loading...");
				   
				   Thread.sleep(3000);
				   
				   if( driver.findElement(By.xpath("//head[contains(@id,'Head1')]")).isDisplayed()){
					   waitForPageLoading();
				   }
				}
				   catch (Exception e)
					  {
					   try
					   {
					   if(driver.findElement(By.xpath("//h5[contains(text(),'Initializing Design Studio')]")).isDisplayed())
					   {
						   waitForPageLoading();

					   }
					   }
					   catch (Exception e1)
					   {
						   try
						   {
							   if( driver.findElement(By.xpath("//div[contains(@class,'spinner')]")).isDisplayed()){
								   waitForPageLoading();
							   }
						   }
						   catch (Exception e2)
						   {
							   try
							   {
								   if( driver.findElement(By.xpath("//div[contains(@ng-class,'blockUiMessageClass')][contains(text(),'Loading')]")).isDisplayed()){
									   waitForPageLoading();
								   }
							   }
							   catch (Exception e4)
							   {
								   System.out.println(e4.getMessage());
							   }
						   }
					   }
					  
				      } 
				
				/*   else if(driver.findElement(By.xpath("//h5[contains(text(),'Initializing Design Studio')]")).isDisplayed())
				   {
					   waitForPageLoading();

				   }*/
			
			}

			public static String capture(String SceenShotName)throws IOException, InterruptedException{
				
				try{
			//	 	 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  			 dest = System.getProperty("user.dir")+"/Screenshot/"+SceenShotName+".jpg";
		  			 dest=dest.replace("\\", "/");
	  		//	     File destination = new File(dest);
	  		//	     FileUtils.copyFile(source, destination);
	  			    
				}
				 	 
				catch (Exception e)
				  {
		  			 System.out.println(e.getMessage());
			      } 
	  			     
				 return dest;    

			}
			public static void waitForPageLoadSave() throws InterruptedException {
				 wait = new WebDriverWait(driver, 120);
			     
				    pageLoaded = new Predicate<WebDriver>() {

				        public boolean apply(WebDriver input) {
				            return ((JavascriptExecutor) input).executeScript("return document.readyState").toString().equals("complete");
				        }

				    };
				  // wait.until(pageLoaded) ;
				   System.out.println("Page Loading...");
				   
				   Thread.sleep(5000);
				   
				   if( driver.findElement(By.xpath("//div[contains(@ng-class,'blockUiMessageClass')][contains(text(),'Saving')]")).isDisplayed()){
					   waitForPageLoadSave();
				   }
			}
			public static String waitForElementNotVisible(int timeOutInSeconds, WebDriver driver, String elementXPath) {
			    if ((driver == null) || (elementXPath == null) || elementXPath.isEmpty()) {

			        return "Wrong usage of WaitforElementNotVisible()";
			    }
			    try {
			        (new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.invisibilityOfElementLocated(By
			                .xpath(elementXPath)));
			        return null;
			    } catch (TimeoutException e) {
			        return "Build your own errormessage...";
			    }
			}

			
}
