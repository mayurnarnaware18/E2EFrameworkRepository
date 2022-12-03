package QAClickAppTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OHRMObjectRepositories.OrangeHRMLoginPage;
import OHRMObjectRepositories.OrangeHRMResetPasswordPage;
import OrangeHRMAppTests.OHRMForgotPasswordTest;
import QAClickObjectRepositories.QAClickLandingPage;
import QAClickObjectRepositories.QAClickLoginPage;
import commonLibraries.AssertLibraries;
import commonLibraries.SeleniumLibraries;
import resources.Base;

public class QAClickLoginTest extends Base{
	
	public static Logger log = LogManager.getLogger(QAClickLoginTest.class.getName());
	//class level object declaration to use it inside body of all methods
	public WebDriver driver;
	
	QAClickLandingPage lap;;//object created to use elements of login page
	QAClickLoginPage lop;//object created to use elements of Reset 
	AssertLibraries Assertlib = new AssertLibraries();
	SeleniumLibraries seleniumFunctions = new SeleniumLibraries();
	WebDriverWait wait;
	//pre-requisite code to launch OrangeHRM login page in before class method
	@BeforeMethod
	public void launchQAClick() throws IOException {

		log.debug("Initializing driver");
		//it will launch browser, and return the base driver and store in TC driver
		driver = initializeDriver();
		log.debug("driver is successfully initialized, and browser is launched");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//1.Launch OHRM website
		driver.get(getURL1());
		
		//passed driver as an argument in constructors to link with page object driver
		lap = new QAClickLandingPage(driver);
		lop = new QAClickLoginPage(driver);
	}
	
	//Test method where we implement actual test case steps
	@Test(dataProvider="dpMethod")
	public void QADDTLoginTest(String username, String password) throws IOException {
		boolean isOnLanding = lap.getTxtLandingHeader().isDisplayed();
		Assert.assertTrue(isOnLanding,"StepFail: Not on Landing page");
		log.info("StepPass: Currently on landing page");
		wait.until(ExpectedConditions.visibilityOf(lap.getTxtNoThanks())).click();
		lap.getLnkLogin().click();
		boolean isOnLogin = lop.getTxtLoginHeader().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: Not on login page");
		lop.getTxtBoxUsername().sendKeys(username);
		lop.getTxtBoxPassword().sendKeys(password);
		lop.getBtnLogin().click();
		boolean isInvalidMsgDisplayed = lop.getTxtMsgInvalidUser().isDisplayed();
		
		Assert.assertTrue(isInvalidMsgDisplayed,"StepFail: Invalid Message not displayed");
		log.info("StepPass: Login unsuccessful with invalid credentials, still on Login page");
	}
	
	@DataProvider
	public String[][] dpMethod(){
		String[][] data = new String[3][2];
		data[0][0] = "admin1";
		data[0][1] = "admin123";
		
		data[1][0] = "admin2";
		data[1][1] = "admin123";
		
		data[2][0] = "admin3";
		data[2][1] = "admin123";
		
		return data;
		
	}
	
	//clean up After class method to close browser
	@AfterMethod
	public void closeQAClick() {
		driver.quit();
	}
}
