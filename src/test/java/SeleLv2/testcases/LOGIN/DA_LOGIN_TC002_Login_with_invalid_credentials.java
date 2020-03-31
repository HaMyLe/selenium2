package SeleLv2.testcases.LOGIN;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;

public class DA_LOGIN_TC002_Login_with_invalid_credentials extends BaseTest {
	private static Logger log = Logger.getLogger(DA_LOGIN_TC002_Login_with_invalid_credentials.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC002(Hashtable<String, String> data) throws IOException {
		log.info("Verify that user fails to login specific repository successfully via Dashboard login page with incorrect credentials");

		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		Assert.assertEquals(DriverUtils.getTextAlert(), data.get("message"));	
	}

}
