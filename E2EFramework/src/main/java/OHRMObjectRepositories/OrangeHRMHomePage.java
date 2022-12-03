package OHRMObjectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {
	WebDriver driver;
	
	//private By txtDashboardHeader = By.xpath("//h6[text()='Dashboard']");
	//private By txtLoggedInUser = By.xpath("//img[@alt='profile picture']/following-sibling::p");
	//private By lnkLogout = By.linkText("Logout");
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement txtDashboardHeader;
	
	@FindBy(xpath="//img[@alt='profile picture']/following-sibling::p")
	private WebElement txtLoggedInUser;
	
	@FindBy(linkText="Logout")
	private WebElement lnkLogout;
	
	public OrangeHRMHomePage(WebDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getTxtDashboardHeader() {
		return txtDashboardHeader;
	}
	public WebElement getTxtLoggedInUser() {
		return txtLoggedInUser;
	}
	public WebElement getLnkLogout() {
		return lnkLogout;
	}
	
	
}
