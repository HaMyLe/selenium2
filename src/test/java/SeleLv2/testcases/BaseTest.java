package SeleLv2.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import driver.DriverType;
import driver.DriverUtils;
import driver.manager.DriverManager;
import driver.manager.DriverManagerFactory;
import utils.Constants;
import utils.helpers.JsonHelper;
import utils.helpers.PropertiesHelper;

public class BaseTest {

	DriverManager driverManager;
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional String browser) {
		if(browser == null) {
		browser = PropertiesHelper.getPropValue("driver.browser");
		}
		if (browser.equalsIgnoreCase("CHROME")) {
			driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		}
//		DOMConfigurator.configure("resources/log4j2.xml");
		else if (browser.equalsIgnoreCase("IE")) {
			driverManager = DriverManagerFactory.getDriverManager(DriverType.IE);
		}
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
