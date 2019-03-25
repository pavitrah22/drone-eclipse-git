package stepDefination;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import corePages.Dashboard;
import corePages.SignIn;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_02_Dashboard {
	WebDriver driver;
	WebElement element;
	Dashboard dashboard;

	@Given("^I am on Dashboard page$")
	public void user_is_on_Dashboard_page() throws Throwable {
		SignIn signin = new SignIn(driver);
		assertTrue(signin.getDashboardTitle().contains("Dashboard title"));
	}

	@When("^I click on Available Drone button$")
	public void i_click_on_Available_Drone_button() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.id(" ")));
		driver.findElement(By.xpath("//*[@id='	'")).click();
	}

	@Then("^I verify I am on Available drone page$")
	public void i_verify_I_am_on_Available_drone_page() throws Throwable {
		Dashboard dashboard = new Dashboard(driver);
		assertTrue("Available Drone page is not displayed", dashboard.getAvialbleDroneTitle().contains("Expected title"));
			
	}

	@When("^I choose the assign task to drone button$")
	public void i_choose_the_drone_D_radiobutton(String task) throws Throwable {
		Dashboard dashboard = new Dashboard(driver);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(By.name("task")));
		dashboard.clickTask();
	}

	@When("^I click on next$")
	public void i_click_on_next() throws Throwable {
		Dashboard dashboard = new Dashboard(driver);
		dashboard.clickNext();
	}
	
	@Then("^I verify I am on Drone selection page$")
	public void i_verify_I_am_on_Drone_selection_page() throws Throwable {
		Dashboard dashboard = new Dashboard(driver);
		assertTrue("Drone selection page is not displayed", dashboard.getDroneSelectionTitle().contains("Expected Title"));
	}
	
}
