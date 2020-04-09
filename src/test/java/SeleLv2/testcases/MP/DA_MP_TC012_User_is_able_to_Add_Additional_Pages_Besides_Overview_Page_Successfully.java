package SeleLv2.testcases.MP;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC012_User_is_able_to_Add_Additional_Pages_Besides_Overview_Page_Successfully extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	String pageName = "Test";

	@Test
	public void DA_MP_TC012() throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #3: Add new page");
		homePage.addNewPage(pageName, false);

		Log.info("Step #4: Check \"Test\" page is displayed besides \"Overview\" page");
		Assert.assertTrue(homePage.isPageDisplayed(pageName), String.format("%s isn't displayed", pageName));

	}

	@AfterMethod
	public void cleanUp() {
		homePage.deleteAddedPage(pageName, SettingsButton.DELETE_PAGE.getName());
	}

}
