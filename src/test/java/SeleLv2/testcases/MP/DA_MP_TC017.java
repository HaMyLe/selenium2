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

public class DA_MP_TC017 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that user can remove any main parent page except Overview page successfully and the order of pages stays persistent as long as there is not children page under it", dataProvider = "getDataForTest")
	public void TC017(Hashtable<String, String> data) throws Exception {

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
