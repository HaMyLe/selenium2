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

public class DA_LOGIN_TC007 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that Username is not case sensitive", dataProvider = "getDataForTest")
	public void TC007(Hashtable<String, String> data) throws IOException {

		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with the account has uppercase username");
		Log.info("Step #3: Observe the current page");
		loginPage.loginDA(data.get("uppercase_username"), data.get("password"));
		Assert.assertEquals(DriverUtils.getTitle(), Constants.TITLE_DASHBOARD);

		Log.info("Step #4: Logout TA Dashboard");
		homePage.logoutAccount();

		Log.info("Step #5: Login with the above account but enter lowercase username");
		loginPage.loginDA(data.get("lowsercase_username"), data.get("password"));

		Log.info("Step #6: Observe the current page");
		Assert.assertEquals(DriverUtils.getTitle(), Constants.TITLE_DASHBOARD);
	}

}
