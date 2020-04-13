package SeleLv2.testcases.LOGIN;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC004 extends BaseTest {
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that user is able to log in different repositories successfully after logging out current repository")
	public void TC004() throws Exception {
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Enter valid username and password of default repository");
		Log.info("Step #3: Click on \"Login\" button");

 		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.SAMPLE_REPO_NAME);
		
		Log.info("Step #4: Click on \"Logout\" button ");
 		homePage.logoutAccount();
		
		Log.info("Step #5: Select a different repository");
		Log.info("Step #6: Enter valid username and password of this repository");
 		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD, Constants.TEST_REPO_NAME);
		
		Log.info("Step #7: Verify that Dashboard Mainpage appears");
 		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
	}
	
	@AfterMethod
	public void cleanUp() {
	 		homePage.logoutAccount();
	 	}
}