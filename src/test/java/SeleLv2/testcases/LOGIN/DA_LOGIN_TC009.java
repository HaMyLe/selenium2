package SeleLv2.testcases.LOGIN;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC009 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that username with special characters is working correctly", dataProvider = "getDataForTest")
	public void TC009(Hashtable<String, String> data) throws IOException {
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with account that has special characters password");
		Log.info("Step #3: Observe the current page");

		loginPage.loginDA(data.get("username"), data.get("password"));
		Assert.assertEquals(DriverUtils.getTitle(), Constants.TITLE_DASHBOARD);
	}

}
