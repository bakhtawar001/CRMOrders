package OrderTestCases2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import Master.OrdersExecution;
import Master.OrdersExecution3;
import PageFactoryandTestdata.OrdersTestdata;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserInitiation extends OrdersExecution3 {
    
	public static void StartBrowser(String Suite){

        WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
	  	options.addArguments("--disable-popup-blocking");
	  	options.addArguments("--disable-extensions");
	  	options.addArguments();
	 	options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);	
		ExtentHtmlReporter htmlReporter;
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+Suite);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "Iftikhar");
		extent.setSystemInfo("Environment",OrdersTestdata.CRMandOrders_URL );
		extent.setSystemInfo("UserName", "Muhammad Iftikhar");
//		extent.setReportUsesManualConfiguration(true);
		htmlReporter.config().setDocumentTitle("Automation Testing Report");
		htmlReporter.config().setReportName("Orders Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.getStartTime();
		htmlReporter.getEndTime();
		driver.get(OrdersTestdata.CRMandOrders_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		}
	}
