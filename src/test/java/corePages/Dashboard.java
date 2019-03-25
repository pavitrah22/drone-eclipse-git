package corePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "AvailableDrone")
	WebElement AvailableDrone;

	@FindBy(xpath = "//input[@name='task']")
	WebElement task;

	@FindBy(xpath = "//input[@name='next']")
	WebElement next;
	
	@FindBy(xpath = "//a[contains(.,'SignIn')]")
	WebElement signInBtn;

	@FindBy(xpath="//h1[contains(.,'Avialable Drone')]")
	WebElement titleAvialableDrone;
	
	@FindBy(xpath="//h1[contains(.,'Drone Selection')]")
	WebElement titleDroneSelection;
	

	public String getAvialbleDroneTitle() {
		return titleAvialableDrone.getText().toString();
	}

	public void clickTask() {
		task.click();	
	}
	
	public void clickNext() {
		next.click();	
	}

	public String getDroneSelectionTitle() {
		return titleDroneSelection.getText().toString();
	}

	
	
}
