package driver.manager;

import org.openqa.selenium.WebDriver;

import browser.chrome.ChromeDriverManager;
import driver.DriverType;

public class DriverManagerFactory {
	
	static DriverManager driverManager;
	public static DriverManager getDriverManager(DriverType type) {
		
		switch (type) {
			case CHROME:
				driverManager = new ChromeDriverManager();
				break;
				
			default:
				break;
			}
		return driverManager;
	}
	
	public WebDriver getDriver() {
		return driverManager.getWebDriver();
	}
}
