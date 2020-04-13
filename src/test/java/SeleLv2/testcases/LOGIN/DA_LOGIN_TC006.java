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

public class DA_LOGIN_TC006 extends BaseTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that \"Password\" input is case sensitive", dataProvider = "getDataForTest")
	public void TC006(Hashtable<String, String> data) throws InterruptedException {
		
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with the account has uppercase password");
		loginPage.loginDA(data.get("username"), data.get("uppercase_password"));
		
		Log.info("Step #3: Observe the current page");
		Assert.assertEquals(DriverUtils.getTitle(), Constants.TITLE_DASHBOARD);
		
		Log.info("Step #4: Logout TA Dashboard");
		homePage.logoutAccount();
		
		Log.info("Step #5: Login with the above account but enter lowercase password");
		loginPage.loginDA(data.get("username"), data.get("lowsercase_password"));
		
		Log.info("Step #6: Observe the current page");
		Assert.assertEquals(loginPage.getTextAlert(), data.get("error_message"));
	}

}
