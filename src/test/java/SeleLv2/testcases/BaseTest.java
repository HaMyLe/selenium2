package SeleLv2.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;

import driver.DriverType;
import driver.DriverUtils;
import driver.manager.DriverManager;
import driver.manager.DriverManagerFactory;
import utils.Constants;
import utils.helpers.*;
import java.io.IOException;
import org.apache.log4j.xml.DOMConfigurator;

public class BaseTest {
	DriverManager driverManager;
	WebDriver driver;

	// Initiate log4j property system
	
	@BeforeClass
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
		DriverUtils.maximumBrowser();
		driver.get(Constants.URL);
	}
	
	@DataProvider(name = "getDataForTest")
	  public synchronized Object[][] getDataForTest(Method method) throws IOException {
		String testMethodName = method.getName();
	      return (Object[][]) JsonHelper.getDataFile("data.json", testMethodName);
	  }
}
