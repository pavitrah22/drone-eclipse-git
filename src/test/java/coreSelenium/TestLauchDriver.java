package coreSelenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import coreSelenium.DriverFactory.DriverType;

public class TestLauchDriver {

	DriverFactory driverManager;
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driverManager = MyUtils.getDriverManager(DriverType.CHROME);
		driver = driverManager.chromeDriver();
	}
	
	@AfterTest
	public void tearDown () {
		driver.close();
		driver.quit();	
	}
}
