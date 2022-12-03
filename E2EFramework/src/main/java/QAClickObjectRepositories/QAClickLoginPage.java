package QAClickObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLoginPage {
	WebDriver driver;

	@FindBy(xpath="//h1[contains(text(),'Log In to WebServices')]")
	private WebElement txtLoginHeader;
	
	@FindBy(id="user_email")
	private WebElement txtBoxUsername;
	
	@FindBy(id="user_password")
	private WebElement txtBoxPassword;
	
	@FindBy(name="commit")
	private WebElement btnLogin;
	
	@FindBy(xpath="//div[normalize-space()='Invalid email or password.']")
	private WebElement txtMsgInvalidUser;
	
	@FindBy(linkText="Forgot Password?")
	private WebElement lnkForgotPassword;
	
	public QAClickLoginPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtLoginHeader() {
		return txtLoginHeader;
	}

	public WebElement getTxtBoxUsername() {
		return txtBoxUsername;
	}

	public WebElement getTxtBoxPassword() {
		return txtBoxPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getTxtMsgInvalidUser() {
		return txtMsgInvalidUser;
	}
	
	public WebElement getLnkForgotPassword() {
		return lnkForgotPassword;
	}
}
