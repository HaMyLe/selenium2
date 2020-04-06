package SeleLv2.testcases.LOGIN;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC006_Login_with_sensitive_password extends BaseTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC006(Hashtable<String, String> data) throws InterruptedException {
		Log.info("Verify that Password input is case sensitive");

		loginPage.loginDA(data.get("username"), data.get("uppercase_password"));
		Assert.assertEquals(DriverUtils.getTitle(), Constants.TITLE_DASHBOARD);
		homePage.logoutAccount();
		loginPage.loginDA(data.get("username"), data.get("lowsercase_password"));
		Assert.assertEquals(loginPage.getTextAlert(), data.get("error_message"));
	}

}
