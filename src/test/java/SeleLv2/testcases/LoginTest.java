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

	@Test(dataProvider = "getDataForTest", priority = 1, description = "Verify that user can login specific repository successfully via Dashboard login page with correct credentials")
    public void DA_LOGIN_TC001(Hashtable<String, String> data) throws IOException {
            try {
            	
	  			loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
	  			Assert.assertEquals(homePage.getUserName(),Constants.USERNAME);
	  			} catch (Exception e) {
                log4j.error(getStackTrade(e.getStackTrace()));
                logException(logMethod, testCaseName, e);
            }
		  
	 }
}
