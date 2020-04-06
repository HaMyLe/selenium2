package SeleLv2.testcases.LOGIN;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC001_Users_Able_to_Login_Successfully_with_Valid_Username_and_Password extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_LOGIN_TC001() throws Exception {
		
		Log.info("Step #1: Navigate to Dashboard login page and login with valid username and password");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		Log.info("Step #2: Verify that Dashboard Mainpage appears");
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
	}

}
