package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC009_Login_with_special_characters_username {
	
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC009() {
	  log.info("DA_LOGIN_TC009: Verify that username with special characters is working correctly");
	  
	  loginPage.loginDA(Constants.TC009_USERNAME, Constants.TC009_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }

}
