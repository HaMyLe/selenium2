package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import driver.DriverUtils;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC017_User_Can_Remove_Any_Main_Parent_Page_Except_Overview_Page_Successfully_And_The_Order_Of_Pages_Stays_Persistent_As_Long_As_There_Is_Not_Children_Page_Under_It
		extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC017(Hashtable<String, String> data) throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name"), false);
		Assert.assertTrue(homePage.isPageDisplayed(data.get("page_name")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_child"), data.get("page_name"), null, null, true);
		Assert.assertTrue(homePage.isChildPageDisplayed(data.get("page_name_child")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #6: Click on parent page");
		homePage.selectMenuPage(data.get("page_name"));

		Log.info("Step #7: Click \"Delete\" link");
		homePage.selectItemsSetting(SettingsButton.DELETE_PAGE.getName());

		Log.info("Step #8: Check confirm message \"Are you sure you want to remove this page?\" appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("confirm_message"),
				"The confirm message doesn't match");

		Log.info("Step #9: Click OK button");
		DriverUtils.acceptAltert();

		Log.info(
				"Step #10: Check warning message \"Can not delete page 'Test' since it has children page(s)\" appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("warning_message"),
				"The warning message doesn't match");

		Log.info("Step #11: Click OK button");
		DriverUtils.acceptAltert();

		Log.info("Step #12: Click on children page");
		homePage.selectMenuPath("Test > Test_Child_1");

		Log.info("Step #13: Click \"Delete\" link");
		homePage.selectItemsSetting(SettingsButton.DELETE_PAGE.getName());

		Log.info("Step #14: Check confirm message \"Are you sure you want to remove this page?\" appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("confirm_message"),
				"The confirm message doesn't match");

		Log.info("Step #15: Click OK button");
		DriverUtils.acceptAltert();

		Log.info("Step #16: Check children page is deleted");
		Assert.assertFalse(homePage.isChildPageDisplayed(data.get("page_name_child")),
				String.format("%s page should not dispaly", data.get("page_name_child")));

		Log.info("Step #17: Click on parent page");
		homePage.selectMenuPage(data.get("page_name"));

		Log.info("Step #18: Click \"Delete\" link");
		homePage.selectItemsSetting(SettingsButton.DELETE_PAGE.getName());

		Log.info("Step #19: Check confirm message \"Are you sure you want to remove this page?\" appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("confirm_message"),
				"The confirm message doesn't match");

		Log.info("Step #20: Click OK button");
		DriverUtils.acceptAltert();

		Log.info("Step #21: Check parent page is deleted");
		Assert.assertFalse(homePage.isPageDisplayed(data.get("page_name")),
				String.format("%s page should not dispaly", data.get("page_name")));

		Log.info("Step #22: Click on \"Overview\" page");
		homePage.selectMenuPage("Overview");

		Log.info("Step #23: Check \"Delete\" link disappears");
		Assert.assertFalse(homePage.isItemUnderSettingDisplayed(SettingsButton.DELETE_PAGE.getName()),
				String.format("%s is not display", SettingsButton.DELETE_PAGE.getName()));

	}
}
