package commonLibraries;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeleniumLibraries {
	public static Logger log = LogManager.getLogger(AssertLibraries.class.getName());
	
	public void clickElement(WebElement element) {
		if(element.isDisplayed()==false || element.isEnabled() ==false) {
			log.error("Element is not visible or enabled");
			Assert.assertFalse(true,"Element is not visible or enabled");
		}
		element.click();
	}
	
	public void sendText(WebElement element, String text) {
		if(text==null || text=="") {
			log.warn("text is empty");
			Assert.assertFalse(true, "text is empty");
		}
		
		element.sendKeys(text);
	}
}
