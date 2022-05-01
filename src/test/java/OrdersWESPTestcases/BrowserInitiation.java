package OrdersWESPTestcases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Master.WESPORDER;
//import Master.OrdersExecution2;
import PageFactoryandTestdata.OrdersTestdata;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserInitiation extends WESPORDER {
    
	public static void StartBrowser() throws IOException, InterruptedException, AWTException{
		
        WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
	  	options.addArguments("--disable-popup-blocking");
	  	options.addArguments("--disable-extensions");
	  	options.addArguments();
	 	options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		ExtentHtmlReporter htmlReporter;
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/WESPORDER.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Iftikhar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Muhammad Iftikhar");
//		extent.setReportUsesManualConfiguration(true);
		htmlReporter.config().setDocumentTitle("Automation Testing Report");
		htmlReporter.config().setReportName("IDAHO_WESPOrder Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();

		
		driver.get(OrdersTestdata.CRMandOrders_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		//Login.login();
		}
	
	}
