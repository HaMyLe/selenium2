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
		
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with valid account for the first repository");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.SAMPLE_REPO_NAME);
		
		Log.info("Step #3: Choose another repository in Repository list");
		homePage.selectRepo(Constants.TEST_REPO_NAME);
		
		Log.info("Step #4: Observe the current page");
		Assert.assertEquals(homePage.getTextRepo(), Constants.TEST_REPO_NAME);
	}
}