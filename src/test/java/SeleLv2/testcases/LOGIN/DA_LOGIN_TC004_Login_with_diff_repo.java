package SeleLv2.testcases.LOGIN;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC004_Login_with_diff_repo extends BaseTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC004() throws Exception {
		Log.info(
				"Verify that user is able to log in different repositories successfully after logging out current repository");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.SAMPLE_REPO_NAME);
		homePage.logoutAccount();
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.TEST_REPO_NAME);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		homePage.logoutAccount();
	}
}
