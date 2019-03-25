package corePages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class Locations {

	static WebDriver driver;

	public static Point getCoOrdinatesLocation() {
		Point co_ordinate_Location = driver.findElement(By.id("")).getLocation();
		return co_ordinate_Location;
	}
}
