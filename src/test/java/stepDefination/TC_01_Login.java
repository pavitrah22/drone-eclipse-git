package stepDefination;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import corePages.SignIn;
import coreSelenium.DriverFactory;
import coreSelenium.MyUtils;
import coreSelenium.DriverFactory.DriverType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TC_01_Login {

	public static WebDriver driver;
	DriverFactory driverManager;
	
	@BeforeClass
	public void setUp() {
		driverManager = MyUtils.getDriverManager(DriverType.CHROME);
		driver = driverManager.chromeDriver();
	}
	
	@AfterClass
	public void tearDown () {
		driver.close();
		driver.quit();	
	}
	
	@Given("^I launch the application$")
	public void i_launch_the_application()  {
	   
		driverManager = MyUtils.getDriverManager(DriverType.CHROME);
		driver = driverManager.chromeDriver();
	//	driver.get("https://www.google.com");
		SignIn signin = new SignIn(driver);
		 signin.openURL();
	}

	@When("^I enter username \"([^\"]*)\"$")
	public void i_enter_username(String username)  {
		SignIn signin = new SignIn(driver);
		signin.enterUsername(username);
	}
	
	@When("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password)  {
		SignIn signin = new SignIn(driver);
		signin.enterPassword(password);
	}

	@When("^I click login$")
	public void i_click_login() throws Throwable {
		SignIn signin = new SignIn(driver);
		signin.clickSignin();
	}

	@Then("^I verify Dashboard page is displayed$")
	public void i_verify_Dashboard_page_is_displayed() throws Throwable {
		SignIn signin = new SignIn(driver);
		assertTrue(signin.getDashboardTitle().contains("Dashboard title"));
	}
}
