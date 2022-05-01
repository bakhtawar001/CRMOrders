package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageFactoryandTestdata.HelpingFunction;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StartBrowser extends HelpingFunction {


				public static void StartupBrowser(String Suite) throws InterruptedException, AWTException, IOException
	
					
						{
							System.setProperty("webdriver.chrome.silentOutput","true");
					        WebDriverManager.chromedriver().setup();
							ChromeOptions options = new ChromeOptions();
							options.addArguments("-incognito");
						  	options.addArguments("--disable-popup-blocking");
						  	options.addArguments("--disable-extensions");
						  	options.addArguments("--disable-dev-shm-usage");
						 	options.addArguments("--start-maximized");
							driver=new ChromeDriver(options);
							ExtentHtmlReporter htmlReporter;
							htmlReporter = new ExtentHtmlReporter(".//src//test//java//Reports//"+Suite);
							extent = new ExtentReports();
							extent.attachReporter(htmlReporter);
							extent.setSystemInfo("HostName", "Bakhtawar");
							extent.setSystemInfo("Environment", "QA");
							extent.setSystemInfo("UserName", "Bakhtawar Malik");
							extent.setSystemInfo("URL", envirnment);
							htmlReporter.config().setDocumentTitle("Automation Testing Report");
							htmlReporter.config().setReportName("CRM Report");
							htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
							htmlReporter.config().setTheme(Theme.DARK);
							htmlReporter.getStartTime();
							htmlReporter.getEndTime();
							driver.get(envirnment);
							driver.manage().window().maximize();
							driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
							driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
							}
						/*if(browser.equals("chrome")){
					     WebDriverManager.chromedriver().setup();
						ChromeOptions options = new ChromeOptions();
						options.addArguments("-incognito");
					  	options.addArguments("--disable-popup-blocking");
					  	options.addArguments("--disable-extensions");
					  	options.addArguments();
					 	options.addArguments("--start-maximized");
					// 	options.addArguments("--start-fullscreen");
					    WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver(options);
					 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
						
						}*/
						
					//	else if(browser.equalsIgnoreCase("ff")){
						//	WebDriverManager.firefoxdriver().setup();
				/*			System.setProperty("webdriver.firefox.marionette", CrmTestData.Firefoxpath);
			    			DesiredCapabilities dc = new DesiredCapabilities();
			    			dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			    			driver = new FirefoxDriver();*/
							//DesiredCapabilities dc = new DesiredCapabilities();
						//	dc = DesiredCapabilities.firefox();
						//	dc.setCapability("marionette", true);
						//	driver = new FirefoxDriver(dc);				
						//	System.setProperty("webdriver.gecko.driver", CrmTestData.Firefoxpath);
			    		//	driver = new FirefoxDriver(dc);
			    			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			    			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			    			//WebDriver driver = new ChromeDriver();
			    	    	
			    	      
					//	}
				
					/*	else if(browser.equalsIgnoreCase("edge")){
							System.setProperty("webdriver.edge.driver", CrmTestData.EdgePath);
					//		driver = new EdgeDriver();
									}*/
									
						
					
				
					
					
			
			}







