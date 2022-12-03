package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");
	}

	
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String methodName = result.getMethod().getMethodName();
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String screenshotPath;
			screenshotPath = getScreenshot(driver, methodName);
			test.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
}
