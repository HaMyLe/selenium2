package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC004_Login_with_diff_repo extends BaseTest {
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC004() throws Exception {
		log.info(
				"Verify that user is able to log in different repositories successfully after logging out current repository");
		loginPage.loginDA(Constants.USERNAME, "", Constants.SAMPLE_REPO_NAME);
		homePage.logoutAccount();
		loginPage.loginDA(Constants.USERNAME, "", Constants.TEST_REPO_NAME);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		homePage.logoutAccount();
	}
}
