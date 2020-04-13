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

public class DA_LOGIN_TC003 extends BaseTest{
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that user fails to log in specific repository successfully via Dashboard login page with correct username and incorrect password", dataProvider = "getDataForTest")
	public void TC003(Hashtable<String, String> data) throws IOException {
		
		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Enter invalid username and password");
		Log.info("Step #3: Click on Login button");
		loginPage.loginDA(data.get("username"), data.get("password"),data.get("sample_repository"));
		
		Log.info("Verify that Dashboard Error message \"Username or password is invalid\" appears");
		Assert.assertEquals(DriverUtils.getTextAlert(), data.get("message"));		
	}
}
