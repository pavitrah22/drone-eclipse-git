package corePages;

import java.util.List;

import commonLib.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DroneSelection {

	WebDriver driver;
	WebElement element;

	public DroneSelection(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Location")
	WebElement location_ID;

	@FindBy(id = "item_ID")
	WebElement item_ID;
	
	@FindBy(xpath = "//input[@name='id_Drone' and @value='1']")
	WebElement droneRadioButton;

	@FindBy(xpath = "//input[@name='next']")
	WebElement next;
	
	@FindBy(xpath = "//[@id='drone_id' and [@selected='selected']")
	WebElement selectedDroneID;
	
	@FindBy(xpath = "//[@id='drone_id']")
	WebElement DroneID;
	
	
	@FindBy(xpath = "//[@id='Location_id' and [@selected='selected']")
	WebElement selectedLocationID;

	@FindBy(xpath="//h1[contains(.,'Destination Address')]")
	WebElement titleDestinationAddress;
	
	@FindBy(id="address")
    WebElement Destinationaddress;
	
	@FindBy(xpath="//h1[contains(.,'Drone Selection')]")
	WebElement titleDroneSelection;
	
	@FindBy(xpath="//h1[contains(.,'Destination Location')]")
	WebElement titleDestinationLocation;
	
	@FindBy(xpath="//a[contains(.,'unload')]")
	WebElement unload;
	
	@FindBy(xpath="//a[contains(.,'instruction')]")
	WebElement instructions;
	
	
	@FindBy(id="Confirm")
    WebElement confirm;
	
	@FindBy(id="parkingSpot")
    WebElement parkingspot;
	
	@FindBy(xpath="//h1[contains(.,'Parking page')]")
	WebElement titleParkingPage;
	
	public String getAvialbleDroneTitle() {
		return titleDestinationAddress.getText().toString();
	}

	public void clickUnload() {
		unload.click();	
	}
	
	public void clickNext() {
		next.click();	
	}

	public String getDroneSelectionTitle() {
		return titleDroneSelection.getText().toString();
	}
	
	public void enterLocation(String location_id) {
		location_ID.sendKeys(location_id);
	}

	public Point getLocationAxes() {
		return location_ID.getLocation();
		
	}

	public void selectDroneRadioButton() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(droneRadioButton));
		droneRadioButton.click();
		
	}

	public void enterItemID(String item_id) {
		item_ID.sendKeys(item_id);
		
	}

	public Point getItemIdLocationAxes() {
		return item_ID.getLocation() ;
	}

	public String getDestinationAddressTitle() {
		return titleDestinationAddress.getText().toString();
	}

	public String isSelectedDrone_id() {
		return selectedDroneID.getText();
	}

	public String isSelectedLocationID() {
		return selectedLocationID.getText();
	}

	public void enterDestinationAddress(String address) {
		Destinationaddress.sendKeys(address);
		
	}

	public Point getAddressLocationAxes() {
		return Destinationaddress.getLocation();
	}

	public String getDestinationPageTitle() {
		return titleDestinationLocation.getText().toString();
	}

	public void clickConfirm() {
		confirm.click();
		
	}

	public void selectInstruction(String status) {
		Select instruction_status = new Select(instructions);
		instruction_status.selectByValue(status);
		
	}

	public void selectParkingSpot() {
		parkingspot.click();
	}

	public String getParkingPageTitle() {
		return titleParkingPage.getText().toString();
	}

	public boolean isDisplayedDroneIDAvailable(String drone_id) {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, 100);
		element= wait.until(ExpectedConditions.elementToBeClickable(DroneID));
		List<WebElement> elements = driver.findElements(By.id("drone_id"));
		if (elements.size() != 0) {
			for (WebElement ele : elements) {
				if (ele.isDisplayed()) {
					ele.getText().contains(drone_id);
					result = true;
					Log.info("Drone found in the list");
				} else {
					Log.error("Drone id not found");
				}
			}
		}
		return result;

	}
}
	
