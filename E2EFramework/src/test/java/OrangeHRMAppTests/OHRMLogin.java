package OrangeHRMAppTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.Base;

public class OHRMLogin extends Base{
	public WebDriver driver;
	@Test
	public void OrangeHRMLoginTest() throws IOException {
		
		SoftAssert softAssert = new SoftAssert();
		
		driver = initializeDriver();
		driver.get("https://www.google.com/");
		String googleTitle = driver.getTitle();
		
		
		driver.get(getURL());
		
		String OHRMtitle = driver.getTitle();
		
		Assert.assertNotEquals(OHRMtitle, googleTitle, "StepFail: Still on google webpage");
		System.out.println("StepPass:Not on google web page");
		
		//Assert.assertEquals(OHRMtitle, "OrangeHRM1", "StepFail: Titles not matching | ");
		softAssert.assertEquals(OHRMtitle, "OrangeHRM", "StepFail: Titles not matching | ");
		System.out.println("StepPass: Titles are matching");
		boolean isOnLogin = driver.findElement(By.xpath("//h5[text()='Login']")).isDisplayed();
		
		WebElement forgotPassword = driver.findElement(By.xpath("//p[normalize-space()='Forgot your password?']"));
		Assert.assertNotNull(forgotPassword,"StepFail: Forgot your password is not available on Login Page | ");
		System.out.println("StepPass: Forgot password option available on Login page");
		
		Assert.assertTrue(isOnLogin,"StepFail: Not on login page | ");
		System.out.println("StepPass: Currently on login page");
		
		
		//Use the data in sendKeys method fetched from Excel
		driver.findElement(By.name("username")).sendKeys(getUsername());
		driver.findElement(By.name("password1")).sendKeys(getPassword());
		driver.findElement(By.xpath("//button[text()=' Login ']")).submit();
		
		boolean isOnHome = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		Assert.assertTrue(isOnHome,"StepFail: Login unsuccessful");
		System.out.println("StepPass: Login successful");	
		
		try {
			isOnLogin = driver.findElement(By.xpath("//h5[text()='Login']")).isDisplayed();
		} catch (Exception e) {
			isOnLogin = false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertFalse(isOnLogin,"StepFail: You are still on login page");
		System.out.println("StepPass: You are not on login page");
		
		driver.quit();
		softAssert.assertAll();
	}
}
