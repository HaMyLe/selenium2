package SeleLv2.testcases.LOGIN;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC005 extends BaseTest{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that there is no Login dialog when switching between 2 repositories with the same account")
	public void TC005() throws InterruptedException {
		Log.info("Verify that there is no Login dialog when switching between 2 repositories with the same account");

		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.SAMPLE_REPO_NAME);
		homePage.selectRepo(Constants.TEST_REPO_NAME);
		Assert.assertEquals(homePage.getTextRepo(), Constants.TEST_REPO_NAME);
	}
}