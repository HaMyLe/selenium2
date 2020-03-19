package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC006_Login_with_sensitive_password {
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC006() throws InterruptedException {
	  log.info("DA_LOGIN_TC006: Verify that Password input is case sensitive");
	  
	  loginPage.loginDA(Constants.TC006_USERNAME, Constants.TC006_UPPERCASE_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	  homePage.logoutAccount();
	  loginPage.loginDA(Constants.TC006_USERNAME, Constants.TC006_LOWERCASE_PASSWORD);
	  Assert.assertEquals(loginPage.getTextAlert(), Constants.INVALID_USERNAME_PASS_MSG);
	 }

}
