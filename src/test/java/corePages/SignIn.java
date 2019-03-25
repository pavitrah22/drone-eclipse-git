package corePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLib.ConfigFileReader;
import coreSelenium.MyUtils;

public class SignIn {
	
	WebDriver driver;
	
	public SignIn(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(id="username")
    WebElement userName;

	@FindBy(id="password")
	WebElement passwrd;
	
	@FindBy(xpath="//a[contains(.,'SignIn')]")
	WebElement signInBtn;
	
	@FindBy()
	WebElement titleText;
	
	ConfigFileReader configFileReader;
	
	public  void openURL() {
		ConfigFileReader configFileReader = new ConfigFileReader();
		driver.get(configFileReader.getURL());
	}
	
	public void clickSignin() {
		signInBtn.click();	
	}

	
	public void enterUsername(String username) {
		userName.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwrd.sendKeys(password);
	}

	
	public String getDashboardTitle() {
		return titleText.getText().toString();
	}
	
	

	
}
