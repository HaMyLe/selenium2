package SeleLv2.testcases.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_LOGIN_TC001_Users_Able_to_Login_Successfully_with_Valid_Username_and_Password extends BaseTest {
	
	private static Logger log4j = Logger.getLogger(DA_LOGIN_TC001_Users_Able_to_Login_Successfully_with_Valid_Username_and_Password.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_LOGIN_TC001() {
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		  Assert.assertEquals(homePage.getUserName(),Constants.USERNAME);
	}

}
