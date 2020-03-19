package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC002_Login_with_invalid_credentials extends BaseTest {
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC002() throws InterruptedException {
		log.info("Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials");

		loginPage.loginDA(Constants.INVALID_USERNAME, Constants.INVALID_PASSWORD, Constants.SAMPLE_REPO_NAME);
		Assert.assertEquals(DriverUtils.getTextAlert(), Constants.INVALID_USERNAME_PASS_MSG);	
	}

}
