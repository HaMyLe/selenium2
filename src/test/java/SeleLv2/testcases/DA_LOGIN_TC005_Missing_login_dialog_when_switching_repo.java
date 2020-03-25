package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC005_Missing_login_dialog_when_switching_repo extends BaseTest{
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC006() throws InterruptedException {
		log.info("Verify that there is no Login dialog when switching between 2 repositories with the same account");

		loginPage.loginDA(Constants.USERNAME, "", Constants.SAMPLE_REPO_NAME);
		homePage.selectRepo(Constants.TEST_REPO_NAME);
		Assert.assertEquals(homePage.getTextRepo(), Constants.TEST_REPO_NAME);
	}
}
