package driver;

import driver.manager.DriverManagerFactory;

public class DriverUtils extends DriverManagerFactory {
	
	public static void maximumBrowser() {
		getDriver().manage().window().maximize();
	}
	
}
