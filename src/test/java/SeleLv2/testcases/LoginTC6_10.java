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
	  log.info("DA_LOGIN_TC006: Verify that Password input is case sensitive");
	  
	  loginPage.loginDA(Constants.TC006_USERNAME, Constants.TC006_UPPERCASE_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	  homePage.logoutAccount();
	  loginPage.loginDA(Constants.TC006_USERNAME, Constants.TC006_LOWERCASE_PASSWORD);
	  Assert.assertEquals(loginPage.getTextAlert(), Constants.INVALID_USERNAME_PASS_MSG);
	 }
	
	@Test
	public void DA_LOGIN_TC007() {
	  log.info("DA_LOGIN_TC007: Verify that Username is not case sensitive");
	  
	  loginPage.loginDA(Constants.TC007_UPPERCASE_USERNAME, Constants.TC007_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	  homePage.logoutAccount();
	  loginPage.loginDA(Constants.TC007_LOWERCASE_USERNAME, Constants.TC007_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }
	
	@Test
	public void DA_LOGIN_TC008() {
	  log.info("DA_LOGIN_TC008: Verify that password with special characters is working correctly");
	  
	  loginPage.loginDA(Constants.TC008_USERNAME, Constants.TC008_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }
	
	@Test
	public void DA_LOGIN_TC009() {
	  log.info("DA_LOGIN_TC009: Verify that username with special characters is working correctly");
	  
	  loginPage.loginDA(Constants.TC009_USERNAME, Constants.TC009_PASSWORD);
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }
	
	@Test
	public void DA_LOGIN_TC010() {
	  log.info("DA_LOGIN_TC010: Verify that Password input is case sensitive");
	  
	  loginPage.clickBtnLogin();
	  Assert.assertEquals(DriverUtils.getTextAlert(),Constants.EMPTY_USERNAME_MSG);
	 }
	
}

