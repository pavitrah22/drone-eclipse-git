package stepDefination;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import corePages.Dashboard;
import corePages.DroneSelection;
import corePages.Locations;
import corePages.SignIn;
import coreSelenium.MyUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_03_DroneSelection {

	WebDriver driver;
	WebElement element;
	DroneSelection droneSelection;
	static Point location_id_coordinates;
	static Point address_location;
	static Point co_ordinates_itemID;
	static Point available_drone_location;
	
	
	@Given("^user is on the Drone selection page$")
	public void user_is_on_the_Drone_selection_page() throws Throwable {
		Dashboard dashboard = new Dashboard(driver);
		assertTrue("Drone selection page is not displayed", dashboard.getDroneSelectionTitle().contains("Expected Title"));
	}
	
	@When("^I enter the warehouse \"([^\"]*)\"$")
	public void i_select_the_warehouse_Location_(String location_id) throws Throwable {
		DroneSelection droneSelection = new DroneSelection(driver); 
		droneSelection.enterLocation(location_id);
		location_id_coordinates = droneSelection.getLocationAxes();
	}
	
	@When("^I select the drone$")
	public void i_select_the_drone() throws Throwable {
		
		//Available drone Radiobutton to select drone
		DroneSelection droneSelection = new DroneSelection(driver); 
		droneSelection.selectDroneRadioButton();
		
	}

	@When("^I enter the item to pick up \"([^\"]*)\"$")
	public void i_select_the_item_to_pick_up_item_(String item_id) throws Throwable {
		DroneSelection droneSelection = new DroneSelection(driver);
		droneSelection.enterItemID(item_id);
	    co_ordinates_itemID = droneSelection.getItemIdLocationAxes();
	}

	@Then("^I am on Destination Address page$")
	public void i_am_on_Destination_Address_page() throws Throwable {
		assertTrue("Destination Address page is not displayed", droneSelection.getDestinationAddressTitle().contains("Expected Title"));
	}
	
	@Then("^I verify drone \"([^\"]*)\" has pick correct \"([^\"]*)\"$")
	public void i_verify_drone_Drone__has_pick_correct_Location_(String drone_id, String  location_id) throws Throwable {
		assertTrue("Selected Drone Id doesnot match ", droneSelection.isSelectedDrone_id().equals(drone_id));
	    assertTrue("Selected Location does not match the atual location", droneSelection.isSelectedLocationID().equals(location_id));
	}

	@When("^I enter the Destination \"([^\"]*)\" to be delivered$")
	public void i_enter_the_Destination_streetAddress_to_be_delivered(String address) throws Throwable {
	    droneSelection.enterDestinationAddress(address);
	    address_location = droneSelection.getAddressLocationAxes();
	}
	
	@Given("^I am on Destination Location page$")
	public void i_am_on_Destination_Location_page() throws Throwable {
	    assertTrue("Destination Location page is not displayed",droneSelection.getDestinationPageTitle().contains("Expected Title"));
	}

	@When("^I click on unload button$")
	public void i_click_on_unload_button() throws Throwable {
	    droneSelection.clickUnload();
	}

	@Then("^I verify and confirm the address displayed$")
	public void i_verify_the_address_displayed() throws Throwable {
	    assertTrue("Actual Address Location does not match the adress", droneSelection.getAddressLocationAxes().toString().equals("Expected Address Location"));
	    droneSelection.clickConfirm();
	}

	@Then("^I verify the \"([^\"]*)\" picked for unload$")
	public void i_verify_the_picked_for_unload(String item_id) throws Throwable {
	    assertTrue("Expected Item_id does not match the actual Item_id picked", droneSelection.getItemIdLocationAxes().toString().equals(item_id));
	}

	@When("^I select the \"([^\"]*)\" of Instruction$")
	public void i_select_the_of_Instruction(String status) throws Throwable {
		droneSelection.selectInstruction(status);
		
	}
	
	@When("^I click unload button$")
	public void i_click_unload_button() throws Throwable {
	    droneSelection.clickUnload();
	}

	@Then("^verify I am on Dashboard page$")
	public void verify_I_am_on_Dashboard_page() throws Throwable {
		SignIn signin = new SignIn(driver);
		assertTrue(signin.getDashboardTitle().contains("Expected  Dashboard title"));
	}

	@When("^I click on the avilable parkingspot button$")
	public void i_click_on_the_avilable_parkingspot_button() throws Throwable {
		DroneSelection droneSelection = new DroneSelection(driver);
		droneSelection.selectParkingSpot();
		
	}

	@Then("^I am on parking page$")
	public void i_am_on_parking_page() throws Throwable {
	   assertTrue("Parking page is not displayed", droneSelection.getParkingPageTitle().contains("Expected Result"));
	}

	
	@Then("^I verify \"([^\"]*)\" is available in the selection list$")
	public void i_verify_is_available_in_the_selection_list(String drone_id) throws Throwable {
		DroneSelection droneSelection = new DroneSelection(driver);
		assertTrue("Drone is not avialable in the Selection List",droneSelection.isDisplayedDroneIDAvailable(drone_id));
	}	

}
