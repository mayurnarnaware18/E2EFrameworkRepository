package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import commonLibraries.UtilitiesLibrary;

public class Base {
	public WebDriver driver;
	private String username;
	private String password;
	private String browserName;
	private int implicitWait;
	private String url;
	private String url1;
	public String basePath = System.getProperty("user.dir");;
	
	public WebDriver initializeDriver() throws IOException {
		String path = basePath + "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		browserName = prop.getProperty("browser");
		url = prop.getProperty("url");
		url1 =  prop.getProperty("url1");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
	   if(browserName.equals("chrome")){
		   System.setProperty("webdriver.chrome.driver", basePath + "\\chromedriver.exe");
		   driver = new ChromeDriver();
	   }
	   else if(browserName.equals("firefox")){
		   System.setProperty("webdriver.gecko.driver", basePath + "\\geckodriver.exe");
		   driver = new FirefoxDriver();
	   }
	   else if(browserName.equals("ie")){
		   System.setProperty("webdriver.ie.driver", basePath + "\\IEDriverServer.exe");
		   driver = new InternetExplorerDriver();
	   }
	   else if(browserName.equals("edge")){
		   System.setProperty("webdriver.edge.driver", basePath + "\\msedgedriver.exe");
		   driver = new EdgeDriver();
	   }
	   else {
		   Assert.assertFalse(true,"Invalid browser, please specify correct browser name in the properties file");
	   }
	   
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
	  return driver;
	}
	
	public String getScreenshot(WebDriver driver, String methodName) throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = basePath + "\\Screenshots\\"+ methodName+"_" +UtilitiesLibrary.getCurrentTimeStamp() + ".png";
		FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		return screenshotPath;
	}
	
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getBrowserName() {
		return browserName;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getURL1() {
		return url1;
	}
	
}
