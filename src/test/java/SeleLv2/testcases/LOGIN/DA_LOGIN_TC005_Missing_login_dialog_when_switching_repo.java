package SeleLv2.testcases.LOGIN;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC005_Missing_login_dialog_when_switching_repo extends BaseTest{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC005() throws InterruptedException {
		Log.info("Verify that there is no Login dialog when switching between 2 repositories with the same account");

		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.SAMPLE_REPO_NAME);
		homePage.selectRepo(Constants.TEST_REPO_NAME);
		Assert.assertEquals(homePage.getTextRepo(), Constants.TEST_REPO_NAME);
	}
}