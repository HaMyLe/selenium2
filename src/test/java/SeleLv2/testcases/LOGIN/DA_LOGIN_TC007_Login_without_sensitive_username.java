package SeleLv2.testcases.LOGIN;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_LOGIN_TC007_Login_without_sensitive_username extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC007(Hashtable<String, String> data) throws IOException {
	  Log.info("Verify that Username is not case sensitive");
	  
	  loginPage.loginDA(data.get("uppercase_username"), data.get("password"));
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	  homePage.logoutAccount();
	  loginPage.loginDA(data.get("lowsercase_username"), data.get("password"));
	  Assert.assertEquals(DriverUtils.getTitle(),Constants.TITLE_DASHBOARD);
	 }

}
