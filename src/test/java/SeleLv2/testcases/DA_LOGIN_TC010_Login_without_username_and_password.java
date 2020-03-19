package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC010_Login_without_username_and_password {
	
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC010() {
	  log.info("DA_LOGIN_TC010: Verify that Password input is case sensitive");
	  
	  loginPage.clickBtnLogin();
	  Assert.assertEquals(DriverUtils.getTextAlert(),Constants.EMPTY_USERNAME_MSG);
	 }

}
