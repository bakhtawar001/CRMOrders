package CrmTestCases;

import java.awt.AWTException;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import PageFactoryandTestdata.HelpingFunction;


public class Systemroperties extends HelpingFunction {


				public static void Property(String Suite) throws InterruptedException, AWTException, IOException{
	
					try {
						ExtentHtmlReporter htmlReporter;
					//	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/CRMReport.html");
						htmlReporter = new ExtentHtmlReporter("./Reports/"+Suite);

						extent = new ExtentReports();
						extent.attachReporter(htmlReporter);
						extent.setSystemInfo("HostName", "Iftikhar");
						extent.setSystemInfo("Environment", "QA");
						extent.setSystemInfo("UserName", "Muhammad Iftikhar");
						extent.setSystemInfo("URL", envirnment);
				//		extent.setReportUsesManualConfiguration(true);
						htmlReporter.config().setDocumentTitle("Automation Testing Report");
						htmlReporter.config().setReportName("Sep Report");
						htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
						htmlReporter.config().setTheme(Theme.DARK);
						htmlReporter.getStartTime();
						htmlReporter.getEndTime();
						
				

					} 
					catch (IndexOutOfBoundsException e) {
					    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
						}
					
					}
			
			}



