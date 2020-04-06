package SeleLv2.testcases.LOGIN;

import java.io.IOException;
import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;

public class DA_LOGIN_TC003_Login_with_incorrect_password extends BaseTest{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC003(Hashtable<String, String> data) throws IOException {
		Log.info("Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password");

		loginPage.loginDA(data.get("username"), data.get("password"),data.get("sample_repository"));
		Assert.assertEquals(DriverUtils.getTextAlert(), data.get("message"));		
	}
}
