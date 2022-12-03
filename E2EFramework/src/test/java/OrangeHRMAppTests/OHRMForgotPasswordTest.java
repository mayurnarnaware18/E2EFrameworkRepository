package OrangeHRMAppTests;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OHRMObjectRepositories.OrangeHRMLoginPage;
import OHRMObjectRepositories.OrangeHRMResetPasswordPage;
import commonLibraries.AssertLibraries;
import commonLibraries.SeleniumLibraries;
import resources.Base;


public class OHRMForgotPasswordTest extends Base{
	
	public static Logger log = LogManager.getLogger(OHRMForgotPasswordTest.class.getName());
	//class level object declaration to use it inside body of all methods
	public WebDriver driver;
	OrangeHRMLoginPage lp;;//object created to use elements of login page
	OrangeHRMResetPasswordPage rp;//object created to use elements of Reset 
	AssertLibraries Assertlib = new AssertLibraries();
	SeleniumLibraries seleniumFunctions = new SeleniumLibraries();
	//pre-requisite code to launch OrangeHRM login page in before class method
	@BeforeClass
	public void launchOrangeHRM() throws IOException {

		log.debug("Initializing driver");
		//it will launch browser, and return the base driver and store in TC driver
		driver = initializeDriver();
		log.debug("driver is successfully initialized, and browser is launched");
		
		//1.Launch OHRM website
		driver.get(getURL());
		
		//passed driver as an argument in constructors to link with page object driver
		lp = new OrangeHRMLoginPage(driver);
		rp = new OrangeHRMResetPasswordPage(driver);
	}
	
	//Test method where we implement actual test case steps
	@Test
	public void ForgotPasswordTest() throws IOException {
		
		//verify OrangeHRM launched successfully
		boolean isOnLogin = lp.getTxtLoginHeader().isDisplayed();
		Assertlib.assertTrue(isOnLogin,"StepFail: User is not on login page");
		System.out.println("StepPass: User is on login page");
		log.info("StepPass: User is on login page");
		//2.Enter username
		//lp.getTxtBoxUsername().sendKeys("admin");
		seleniumFunctions.sendText(lp.getTxtBoxUsername(), getUsername());
		
		//3.Enter invalid password
		lp.getTxtBoxPassword().sendKeys("admin321");
		
		//4.Click on Login
		//lp.getBtnLogin().click();
		seleniumFunctions.clickElement(lp.getBtnLogin());
		//5.verify whether login is unsuccessful
		//6.Verify invalid credential message
		boolean isInvalidMessage = lp.getTxtInvalidCredentials().isDisplayed();
		Assert.assertTrue(isInvalidMessage, "StepFail: Invalid credential message not displayed | ");
		log.error("StepFail: Invalid credential message not displayed");
		System.out.println("StepPass: Login is unsuccessful and Invalid credential message displayed");
		log.info("StepPass: Login is unsuccessful and Invalid credential message displayed");
		
		//7.Click on forgot password link
		lp.getLnkForgotPassword().click();
		
		//8.Verify user landed on Reset password page
		boolean isOnResetPassword =  rp.getTxtResetPasswordHeading().isDisplayed();
		Assert.assertTrue(isOnResetPassword, "StepFail: Not on reset password page");
		System.out.println("StepPass: Currently on reset password page");
		
		//9.Enter valid user id and click on reset password
		rp.getTxtBoxUsername().sendKeys(getUsername());
		rp.getBtnResetPassword().click();
		
		//10.Validate reset password request message.
		boolean isResetSuccess = rp.getTxtResetPasswordSuccess().isDisplayed();
		Assert.assertTrue(isResetSuccess,"StepFail: Reset password success message not displayed");
		System.out.println("StepPass: reset password success message displayed");
	}
	
	//clean up After class method to close browser
	@AfterClass
	public void closeOrangeHRM() {
		driver.quit();
	}
}
