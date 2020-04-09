package SeleLv2.testcases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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

public class BaseTest {

	DriverManager driverManager;
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
//		DOMConfigurator.configure("resources/log4j2.xml");
		driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		driver = driverManager.getWebDriver();
		openBrowser();
	}
	
	@AfterClass
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
