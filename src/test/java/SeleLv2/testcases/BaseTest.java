package SeleLv2.testcases;

import driver.DriverType;
import driver.DriverUtils;
import driver.manager.DriverManager;
import driver.manager.DriverManagerFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Constants;
import utils.helpers.JsonHelper;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

	DriverManager driverManager;
	WebDriver driver;

	@BeforeClass
	@Parameters("browser")
	public void setUp(@Optional String browser) {
		DriverType current = (browser != null && !"".equals(browser)) ? DriverType.fromName(browser) : DriverType.CHROME;
		driverManager = DriverManagerFactory.getDriverManager(current);
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
