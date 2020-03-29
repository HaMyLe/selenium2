package SeleLv2.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import org.apache.log4j.xml.DOMConfigurator;

public class LoginTest extends BaseTest{

	private static Logger log4j = Logger.getLogger(LoginTest.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	

	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC002(Hashtable<String, String> data) throws IOException {
		try {
			log4j.info(data.get("username"));
			loginPage.loginDA(data.get("username"), data.get("password"));
//			Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		} catch (Exception e) {
//			log4j.error(getStackTrade(e.getStackTrace()));
//			logException(logMethod, testCaseName, e);
		}

	}


}
