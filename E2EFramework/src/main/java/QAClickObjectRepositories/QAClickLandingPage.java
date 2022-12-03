package QAClickObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAClickLandingPage {
	WebDriver driver;

	@FindBy(xpath="//h2[text()='Featured Courses']")
	private WebElement txtLandingHeader;
	
	@FindBy(xpath="//button[text()='NO THANKS']")
	private WebElement txtNoThanks;
	
	@FindBy(xpath="//a[@href='https://rahulshettyacademy.com/sign_in/']")
	private WebElement lnkLogin;
	
	public QAClickLandingPage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getTxtLandingHeader() {
		return txtLandingHeader;
	}

	public WebElement getTxtNoThanks() {
		return txtNoThanks;
	}

	public WebElement getLnkLogin() {
		return lnkLogin;
	}
	
	
}
