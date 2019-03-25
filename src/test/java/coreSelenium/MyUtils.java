package coreSelenium;

import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonLib.ConfigFileReader;
import coreSelenium.DriverFactory.DriverType;

public class MyUtils {

	public static WebDriver driver;
	
	public static DriverFactory getDriverManager(DriverType type) {
		DriverFactory driverManager = null;
		
		switch(type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}

	public static String setRepo(String repoPath) {
		String pathToRepo = repoPath;
		return pathToRepo;
		
	}

	public static void click(By objectName) {
		try {			
			driver.findElement(objectName).click();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
}
