package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC007_Login_without_sensitive_username extends BaseTest {
	
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC007() {
	  log.info("DA_LOGIN_TC007: Verify that Username is not case sensitive");
	  
	  loginPage.loginDA(Constants.TC007_UPPERCASE_USERNAME, Constants.TC007_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	  homePage.logoutAccount();
	  loginPage.loginDA(Constants.TC007_LOWERCASE_USERNAME, Constants.TC007_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }

}
