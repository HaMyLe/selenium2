package SeleLv2.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class LoginTC6_10 extends BaseTest {
	
	private static Logger log = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC006() throws InterruptedException {
	  log.info("Verify that Password input is case sensitive");
	  
	  loginPage.loginDA(Constants.TEST_LOWERCASE_PASSWORD, Constants.TEST_UPPERCASE_PASSWORD);
	  Assert.assertEquals(homePage.getTextHomePage(),Constants.TEST_LOWERCASE_PASSWORD);
	  homePage.logoutAccount();
	  loginPage.loginDA(Constants.TEST_LOWERCASE_USER, Constants.TEST_LOWERCASE_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTextAlert(), Constants.USERNAME_PASS_INVALID_MESS);
	 }
	
//	@Test
//	public void DA_LOGIN_TC007() {
//	  log.info("Verify that Username is not case sensitive");
//	  loginPage.loginDA(Constants.TEST_USER, Constants.UPPERCASE_PASSWORD);
//	  Assert.assertEquals(homePage.getTextHomePage(),Constants.USERNAME);
//	
//	 }
//	
//	@Test
//	public void DA_LOGIN_TC008() {
//	  log.info("Verify that password with special characters is working correctly");
//	  loginPage.loginDA(Constants.TEST_USER, Constants.UPPERCASE_PASSWORD);
//	  Assert.assertEquals(homePage.getTextHomePage(),Constants.USERNAME);
//	
//	 }
//	
//	@Test
//	public void DA_LOGIN_TC009() {
//	  log.info("Verify that username with special characters is working correctly");
//	  loginPage.loginDA(Constants.TEST_USER, Constants.UPPERCASE_PASSWORD);
//	  Assert.assertEquals(homePage.getTextHomePage(),Constants.USERNAME);
//	
//	 }
//	
//	@Test
//	public void DA_LOGIN_TC010() {
//	  log.info("Verify that Password input is case sensitive");
//	  loginPage.loginDA(Constants.TEST_USER, Constants.UPPERCASE_PASSWORD);
//	  Assert.assertEquals(homePage.getTextHomePage(),Constants.USERNAME);
//	
//	 }
	
}

