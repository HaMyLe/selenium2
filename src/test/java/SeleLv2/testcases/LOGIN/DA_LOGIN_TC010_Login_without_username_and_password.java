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

public class DA_LOGIN_TC010_Login_without_username_and_password extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test(dataProvider = "getDataForTest")
	public void DA_LOGIN_TC010(Hashtable<String, String> data) throws IOException {
	  Log.info("DA_LOGIN_TC010: Verify that Password input is case sensitive");
	  
	  loginPage.loginDA(data.get("username"), data.get("password"));
	  Assert.assertEquals(DriverUtils.getTextAlert(),data.get("error_message"));
	 }

}
