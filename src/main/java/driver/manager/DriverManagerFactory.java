package driver.manager;

import org.openqa.selenium.WebDriver;

import browser.chrome.ChromeDriverManager;
import browser.firefox.FireFoxDriverManager;
import driver.DriverType;
import browser.ie.IEDriverManager;;

public class DriverManagerFactory {
	
	protected static DriverManager driverManager;
	private static int timeOut = 30;
	
	public static DriverManager getDriverManager(DriverType type) {
		
		switch (type) {
			case CHROME:
				driverManager = new ChromeDriverManager();
				break;
			case FIREFOX:
				driverManager = new FireFoxDriverManager();
				break;
			default:
				driverManager = new IEDriverManager();
				break;
			}
		return driverManager;
	}
	
	public static WebDriver getDriver() {
		return driverManager.getWebDriver();
	}
	
	/**
	 * @return the timeOut
	 */
	public static int getTimeOut() {
		return timeOut;
	}
	
}
