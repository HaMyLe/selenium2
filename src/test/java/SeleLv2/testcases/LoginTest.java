package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class LoginTest extends BaseTest {
	
	private static Logger log4j = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC001() {
	  log4j.info("Verify that user can login specific repository successfully via Dashboard login page with correct credentials");
	  
	  loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
	  Assert.assertEquals(homePage.getUserName(),Constants.USERNAME);
		  
	 }
}
