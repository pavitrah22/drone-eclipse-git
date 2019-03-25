package coreSelenium;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverFactory{

	public void createWebDriver() {
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
	}
	
	@Override
	public ChromeDriver chromeDriver() {
		ChromeDriver driver = chromeDriverFactory();
		return driver;
	}

	protected static ChromeDriver chromeDriverFactory() {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "C:\\SerenityRestAssured\\AssignmentDrone\\src\\test\\resource\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		return driver;
	}
}
