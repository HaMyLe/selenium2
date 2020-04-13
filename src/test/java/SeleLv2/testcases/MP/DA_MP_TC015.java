package SeleLv2.testcases.MP;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;
import utils.helpers.CacheHelper;

public class DA_MP_TC015 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that non Public pages can only be accessed and visible to their creators with condition that all parent pages above it are Public", dataProvider = "getDataForTest")
	public void TC015(Hashtable<String, String> data) throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name_1"), true);
		Assert.assertTrue(homePage.isPageDisplayed(data.get("page_name_1")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_dropdown"), null, null, false);

		Log.info("Step #7: Click on Log out link");
		homePage.logoutAccount();

		Log.info("Step #8: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);

		Log.info("Step #9: Check children is invisibled");
//		Assert.assertFalse(homePage.isChildPageCreadted(data.get("page_name_2")),
//				String.format("%s is visibled", data.get("page_name_2")));

		Log.info("Step #10: Click on Log out link");
		homePage.logoutAccount();

		CacheHelper.setValue("Key", data);
	}

	@SuppressWarnings("unchecked")
	@AfterMethod
	public void cleanUp() {
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Hashtable<String, String> data = CacheHelper.getValue("Key", Hashtable.class);
		String pathMenu = data.get("page_name_1") + ">" + data.get("page_name_2");
		homePage.deleteChildMenu(pathMenu, SettingsButton.DELETE_PAGE.getName());
		homePage.deleteAddedPage(data.get("page_name_1"), SettingsButton.DELETE_PAGE.getName());
	}
}
