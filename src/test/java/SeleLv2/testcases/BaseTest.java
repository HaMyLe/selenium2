package SeleLv2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverType;
import driver.DriverUtils;
import driver.manager.DriverManager;
import driver.manager.DriverManagerFactory;
import utils.Constants;

public class BaseTest {
	DriverManager driverManager;
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		openBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public void openBrowser() {
		driver.get(Constants.URL);
		DriverUtils.maximumBrowser();
	}

}
