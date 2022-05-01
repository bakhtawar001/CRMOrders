package OrdersTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Master.OrdersExecution1;
//import Master.OrdersExecution2;
import PageFactoryandTestdata.OrdersTestdata;



public class BrowserInitiation2 extends OrdersExecution1 {
    
	public static void StartBrowser(){
		
		System.setProperty("webdriver.chrome.driver", OrdersTestdata.sChromePath);
		driver=new ChromeDriver();
		
		ExtentHtmlReporter htmlReporter;
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/CRMandOrders.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Iftikhar");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("UserName", "Muhammad Iftikhar");
//		extent.setReportUsesManualConfiguration(true);
		htmlReporter.config().setDocumentTitle("Automation Testing Report");
		htmlReporter.config().setReportName("CRM and Order Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();
		
	      driver.get(OrdersTestdata.CRMandOrders_URL);
	      driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	}
