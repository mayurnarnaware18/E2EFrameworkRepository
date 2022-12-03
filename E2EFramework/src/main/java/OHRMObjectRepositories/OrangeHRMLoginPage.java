package OHRMObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMLoginPage {
	WebDriver driver;
	
	//private By txtLoginHeader = By.xpath("//h5[text()='Login']");
	//private By txtBoxUsername = By.name("username");
	//private By txtBoxPassword = By.name("password");
	//private By btnLogin = By.xpath("//button[text()=' Login ']");

	@FindBy(xpath="//h5[text()='Login']")
	private WebElement txtLoginHeader;
	
	@FindBy(name="username")
	private WebElement txtBoxUsername;
	
	@FindBy(name="password")
	private WebElement txtBoxPassword;
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement btnLogin;
	
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement txtInvalidCredentials;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement lnkForgotPassword;
	
	public OrangeHRMLoginPage(WebDriver driver) {
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

	public WebElement getTxtInvalidCredentials() {
		return txtInvalidCredentials;
	}

	public WebElement getLnkForgotPassword() {
		return lnkForgotPassword;
	}
	
	
}
