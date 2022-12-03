package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonLibraries.UtilitiesLibrary;

public class ExtentReporterNG {
	//object created at class level
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\index_" + UtilitiesLibrary.getCurrentTimeStamp() + ".html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Mayur N");
		extent.setSystemInfo("OS", "Windows");
		return extent;
	}
}
