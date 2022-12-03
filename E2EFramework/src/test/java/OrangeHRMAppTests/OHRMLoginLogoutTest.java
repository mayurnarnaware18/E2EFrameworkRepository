package OrangeHRMAppTests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import OHRMObjectRepositories.OrangeHRMHomePage;
import OHRMObjectRepositories.OrangeHRMLoginPage;

public class OHRMLoginLogoutTest {
	WebDriver driver;
	OrangeHRMLoginPage lp;
	OrangeHRMHomePage hp;
	@BeforeClass
	public void launchOrangeHRM() {
		System.setProperty("webdriver.chrome.driver", "C:\\Mayur\\MyFiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		lp = new OrangeHRMLoginPage(driver);
		hp = new OrangeHRMHomePage(driver);
	}
	
	@Test
	public void loginLogoutTest() {
		boolean isOnLogin = lp.getTxtLoginHeader().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: User is not on login page");
		System.out.println("StepPass: User is on login page");
		
		lp.getTxtBoxUsername().sendKeys("admin");
		lp.getTxtBoxPassword().sendKeys("admin123");
		lp.getBtnLogin().click();
			
		boolean isOnHome =  hp.getTxtDashboardHeader().isDisplayed();
		Assert.assertTrue(isOnHome,"StepFail: User is not on home page");
		System.out.println("StepPass: User is on home page");
			
		String userLoggedIn = hp.getTxtLoggedInUser().getText();
		System.out.println("Logged In user is " + userLoggedIn);
		hp.getTxtLoggedInUser().click();
		hp.getLnkLogout().click();
		
		isOnLogin = lp.getTxtLoginHeader().isDisplayed();
		Assert.assertTrue(isOnLogin,"StepFail: User is not on login page after logout");
		System.out.println("StepPass: User is on login page after logout");
		
	}
	
	@AfterClass
	public void closeOrangeHRM() {
		driver.quit();
	}

}
