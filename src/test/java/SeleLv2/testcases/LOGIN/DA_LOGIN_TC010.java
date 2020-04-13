package SeleLv2.testcases.LOGIN;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class DA_LOGIN_TC010 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that the page works correctly for the case when no input entered to Password and Username field", dataProvider = "getDataForTest")
	public void TC010(Hashtable<String, String> data) throws IOException {
		
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Click Login button without entering data into Username and Password field");
		Log.info("Step #3: Observe the current page");

		loginPage.loginDA(data.get("username"), data.get("password"));
		Assert.assertEquals(DriverUtils.getTextAlert(), data.get("error_message"));
	}

}
