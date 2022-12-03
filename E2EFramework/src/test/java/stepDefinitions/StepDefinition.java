package stepDefinitions;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import OHRMObjectRepositories.OrangeHRMHomePage;
import OHRMObjectRepositories.OrangeHRMLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import resources.Base;

public class StepDefinition extends Base{
	public static Logger log = LogManager.getLogger(StepDefinition.class.getName());
	public WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	@Given("^User is on Login page$")
    public void user_is_on_login_page() throws Throwable {
		driver = initializeDriver();
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
		
		driver.get(getURL());
		boolean isOnLogin = lp.getTxtLoginHeader().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: Not on login page");
		log.info("StepPass: Currently on login page");	
		
		
	}

//    @When("^User clicks on Login by entering username and password$")
//    public void user_clicks_on_login_by_entering_username_and_password() throws Throwable {
//    	driver.findElement(By.name("username")).sendKeys("admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.xpath("//button[text()=' Login ']")).submit();
//    }

	@When("^User clicks on Login by entering username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_clicks_on_login_by_entering_username_as_something_and_password_as_something(String username, String password) throws Throwable {
		lp.getTxtBoxUsername().sendKeys(username);
		lp.getTxtBoxPassword().sendKeys(password);
		lp.getBtnLogin().submit();
    }	
	
//    @Then("^Login is successful$")
//    public void login_is_successful() throws Throwable {
//    	boolean isOnHome = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
//		if(isOnHome==true) {
//			System.out.println("StepPass: Login successful");	
//		}
//		else {
//			System.out.println("StepFail: Login unsuccessful");
//		}
//    }
//
//    @And("^Username is displayed on homepage$")
//    public void username_is_displayed_on_homepage() throws Throwable {
//        boolean isUserDisplayed = driver.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).isDisplayed();
//        if(isUserDisplayed==true) {
//        	System.out.println("StepPass: User displayed successfully");
//        }
//        else {
//        	System.out.println("StepFail: User not displayed");
//        }
//    }
    
    
    @Then("^Login success is \"([^\"]*)\"$")
    public void login_success_is_something(String strArg1) throws Throwable {
    	boolean isOnHome=false;
		try {
			isOnHome = hp.getTxtDashboardHeader().isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(strArg1.equals("true")) {
	    	Assert.assertTrue(false,"StepFail: Login unsuccessful");
			System.out.println("StepPass: Login successful");	
			
    	}
    	else {
    		Assert.assertTrue(isOnHome,"StepFail: Login successful");
			System.out.println("StepPass: Login is unsuccessful");	
			
    	}
    }

    @And("^Username displayed is \"([^\"]*)\"$")
    public void username_displayed_is_something(String strArg1) throws Throwable {
    	boolean isUserDisplayed = false;
		try {
			isUserDisplayed = driver.findElement(By.xpath("//img[@alt='profile picture']/following-sibling::p")).isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	if(strArg1.equals("true")) {
	    	
	        if(isUserDisplayed==true) {
	        	System.out.println("StepPass: User displayed successfully");
	        }
	        else {
	        	System.out.println("StepFail: User not displayed");
	        }
    	}
    	else {
    		
	        if(isUserDisplayed==false) {
	        	System.out.println("StepPass: User not displayed");
	        }
	        else {
	        	System.out.println("StepFail: User is displayed");
	        }
    	}
    }
    
    @And("^Close the browser$")
    public void close_the_browser() {
    	driver.quit();
    }
}
