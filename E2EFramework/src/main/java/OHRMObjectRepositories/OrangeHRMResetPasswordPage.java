package OHRMObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMResetPasswordPage {
	//page object driver
	WebDriver driver;
	
	//New Way of defining WebElement objects using pagefactory 
	@FindBy(xpath="//h6[text()='Reset Password']")
	private WebElement txtResetPasswordHeading;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(xpath="//button[text()=' Reset Password ']")
	private WebElement btnResetPassword;
	
	@FindBy(xpath="//h6[text()='Reset Password link sent successfully']")
	private WebElement txtResetPasswordSuccess;
	
	//constructor to link test case driver with page object driver
	public OrangeHRMResetPasswordPage(WebDriver driver) {
		//This step is not required as we are doing the same thing in initElements method below
		//this.driver = driver;
		
		//method to initialize all the elements when object of this page object class is created
		PageFactory.initElements(driver, this);
	}
	
	//getter methods
	public WebElement getTxtResetPasswordHeading() {
		return txtResetPasswordHeading;
	}

	public WebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}

	public WebElement getBtnResetPassword() {
		return btnResetPassword;
	}

	public WebElement getTxtResetPasswordSuccess() {
		return txtResetPasswordSuccess;
	}
	
	
	
}
