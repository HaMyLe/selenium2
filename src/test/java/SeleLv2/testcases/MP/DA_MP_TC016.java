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

public class DA_MP_TC016 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that user is able to edit the Public setting of any page successfully", dataProvider = "getDataForTest")
	public void TC016(Hashtable<String, String> data) throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name_1"), false);
		Assert.assertTrue(homePage.isPageDisplayed(data.get("page_name_1")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_2"), true);
		Assert.assertTrue(homePage.isPageDisplayed(data.get("page_name_2")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #6: Go to Global Setting -> Edit page");
		homePage.goToEditPage(data.get("page_name_1"), SettingsButton.EDIT_PAGE.getName());

		Log.info("Step #7: Check \"Edit Page\" pop up window is displayed");
		Assert.assertTrue(homePage.isDialogPageDisplayed("Edit Page"), "Edit Page pop up doesn't display");

		Log.info("Step #8: Edit page");
		homePage.editNewPage(data.get("page_name_1"), true);

		Log.info("Step #9: Go to Global Setting -> Edit page");
		homePage.goToEditPage(data.get("page_name_2"), SettingsButton.EDIT_PAGE.getName());

		Log.info("Step #10: Check \"Edit Page\" pop up window is displayed");
		Assert.assertTrue(homePage.isDialogPageDisplayed("Edit Page"), "Edit Page pop up doesn't display");

		Log.info("Step #11: Edit page");
		homePage.editNewPage(data.get("page_name_2"), false);

		Log.info("Step #12: Click on Log out link");
		homePage.logoutAccount();

		Log.info("Step #13: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);

		Log.info("Step #14: Check " + data.get("page_name_1") + "page is visible and can be accessed");
		Assert.assertTrue(homePage.isChildPageDisplayed(data.get("page_name_1")),
				String.format("%s is invisibled", data.get("page_name_1")));

//		Log.info("Step #15: Check " + data.get("page_name_2") + "page is invisible");
//		Assert.assertFalse(homePage.isChildPageDisplayed(data.get("page_name_2")),
//				String.format("%s is visibled", data.get("page_name_2")));

		Log.info("Step #16: Click on Log out link");
		homePage.logoutAccount();

		CacheHelper.setValue("Key", data);
	}

	@SuppressWarnings("unchecked")
	@AfterMethod
	public void cleanUp() {
		Hashtable<String, String> data = CacheHelper.getValue("Key", Hashtable.class);
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		homePage.deleteAddedPage(data.get("page_name_1"), SettingsButton.DELETE_PAGE.getName());
		homePage.deleteAddedPage(data.get("page_name_2"), SettingsButton.DELETE_PAGE.getName());
	}
}
