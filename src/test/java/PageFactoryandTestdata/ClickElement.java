package PageFactoryandTestdata;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Master.CRMExecution;

public class ClickElement extends CRMExecution {
	
	
	
/*	public static void input(String key,String value){

		 CrmLocatiors GetData=PageFactory.initElements(driver, CrmLocatiors.class);
		 GetData.ASINo.sendKeys(value);
		
	}*/
	
	

				public static void ClickByXpath(WebDriver ldriver, String addCompButton){
						Actions act = new Actions(ldriver);
						act.moveToElement(ldriver.findElement(By.xpath(addCompButton))).click().build().perform();
						
						}
				

				public static void ClickByLinkText(WebDriver driver, String linktext){
						Actions act = new Actions(driver);
						act.moveToElement(driver.findElement(By.linkText(linktext))).click().build().perform();
					}
				
				public static void ClickByID(WebDriver ldriver, String lid){
						Actions act = new Actions(ldriver);
						act.moveToElement(ldriver.findElement(By.id(lid))).click().build().perform();
					}
				
				public static void ClickByClassName(WebDriver ldriver, String className){
					Actions act = new Actions(ldriver);
					act.moveToElement(ldriver.findElement(By.className(className))).click().build().perform();
					
				}
				
				public static void ClickByCssSelector(WebDriver ldriver, String cssSelector){
					Actions act = new Actions(ldriver);
					act.moveToElement(ldriver.findElement(By.cssSelector(cssSelector))).click().build().perform();
					
				}
				
				public static void ClickByJs(WebDriver driver, WebElement company){
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", company);
					
				}
				
				
				
				
}












