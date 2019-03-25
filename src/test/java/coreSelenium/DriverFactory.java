package coreSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverFactory {

	protected static WebDriver driver;
	
	
	public enum DriverType{
		CHROME,IE,FIREFOX;
	}
	
	public void quitWebDriver() {
		try {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
 }
	
	public WebDriver getWebDriver() {
		if(null == driver) {
			chromeDriver();
		}
		return driver;
	}

	public abstract ChromeDriver chromeDriver(); 
	
}

