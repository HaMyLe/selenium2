package driver;

import driver.manager.DriverManagerFactory;

public class DriverUtils extends DriverManagerFactory {
	
	public void maximumBrowser() {
		getDriver().manage().window().maximize();
	}
	
	
}
