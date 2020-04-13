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

public class DA_MP_TC020
		extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that user is able to delete sibbling page as long as that page has not children page under it", dataProvider = "getDataForTest")
	public void TC020(Hashtable<String, String> data) throws Exception {

		String menuPath1 = data.get("parent_page_1") + ">" + data.get("parent_page_2");
		String menuPath2 = data.get("parent_page_1") + ">" + data.get("parent_page_2") + ">" + data.get("page_name_2");

		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #4: Enter info into all required fields on New Page dialog");
		homePage.addNewPage(data.get("page_name_1"), data.get("parent_page_1"), null, null, false);

		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #4: Enter info into all required fields on New Page dialog");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_page_2"), null, null, false);

		Log.info("Step #5: Click on parent page");
		homePage.selectMenuPath(menuPath1);

		Log.info("Step #6: Click \"Delete\" link");
		homePage.selectItemsSetting(SettingsButton.DELETE_PAGE.getName());

		Log.info("Step #7: Click OK button");
		DriverUtils.acceptAltert();

		Log.info(
				"Step #8: Check warning message \"Can not delete page 'Page_1' since it has children page(s)\" appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("warning_message"),
				"The warning message doesn't match");

		Log.info("Step #9: Click OK button");
		DriverUtils.acceptAltert();

		Log.info("Step #10: Click on children page");
		homePage.selectMenuPath(menuPath2);

		Log.info("Step #11: Click \"Delete\" link");
		homePage.selectItemsSetting(SettingsButton.DELETE_PAGE.getName());

		Log.info("Step #12: Click OK button");
		DriverUtils.acceptAltert();

		Log.info("Step #13: Check parent page is deleted");
		Assert.assertFalse(homePage.isChildPageDisplayed(data.get("page_name_2")),
				String.format("%s page should not dispaly", data.get("page_name_2")));
	}
}
