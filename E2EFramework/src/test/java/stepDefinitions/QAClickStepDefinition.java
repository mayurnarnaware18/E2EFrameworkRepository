package stepDefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import QAClickObjectRepositories.QAClickLandingPage;
import QAClickObjectRepositories.QAClickLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class QAClickStepDefinition extends Base{
		public static Logger log = LogManager.getLogger(QAClickStepDefinition.class.getName());
		public WebDriver driver;
		QAClickLoginPage lop;
		QAClickLandingPage lap;
		WebDriverWait wait;
		@Given("^Launch QAClick application$")
	    public void launch_qaclick_application() throws Throwable {
			log.debug("Initializing driver");
			//it will launch browser, and return the base driver and store in TC driver
			driver = initializeDriver();
			lap = new QAClickLandingPage(driver);
			lop = new QAClickLoginPage(driver);
			log.debug("driver is successfully initialized, and browser is launched");
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//1.Launch OHRM website
			driver.get(getURL1());
			boolean isOnLanding = lap.getTxtLandingHeader().isDisplayed();
			Assert.assertTrue(isOnLanding,"StepFail: Not on Landing page");
			log.info("StepPass: Currently on landing page");
	    }
		
		@And("^Click login to land on Login Page$")
	    public void click_login_to_land_on_login_page() throws Throwable {
			wait.until(ExpectedConditions.visibilityOf(lap.getTxtNoThanks())).click();
			lap.getLnkLogin().click();
			boolean isOnLogin = lop.getTxtLoginHeader().isDisplayed();
			Assert.assertTrue(isOnLogin,"StepFail: Not on login page");
	    }
		
	    @When("^User tries Login with username as (.+) and password as (.+)$")
	    public void user_tries_login_with_username_as_and_password_as(String username, String password) throws Throwable {
	    	lop.getTxtBoxUsername().sendKeys(username);
			lop.getTxtBoxPassword().sendKeys(password);
			lop.getBtnLogin().click();
	    }

	    @Then("^Login is unsuccessful$")
	    public void login_is_unsuccessful() throws Throwable {
	    	//boolean isInvalidMsgDisplayed = lop.getTxtMsgInvalidUser().isDisplayed();
			
			//Assert.assertTrue(isInvalidMsgDisplayed,"StepFail: Invalid Message not displayed");
			
	    	boolean isOnLogin = lop.getLnkForgotPassword().isDisplayed();
	    	
	    	Assert.assertTrue(isOnLogin,"StepFail: Not on Login page after performing login");
	    	log.info("StepPass: Login unsuccessful with invalid credentials, still on Login page");
	    }

	    @And("^Close browser$")
	    public void close_browser() throws Throwable {
	       driver.quit();
	    }
}
