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

public class DA_MP_TC018_User_Is_Able_To_Add_Additional_Sibbling_Pages_To_The_Parent_Page_Successfully
		extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC018(Hashtable<String, String> data) throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #4: Add new page");
		homePage.addNewPage(data.get("page_name"), false);
		Assert.assertTrue(homePage.isPageDisplayed(data.get("page_name")),
				String.format("%s isn't displayed", data.get("page_name_1")));

		Log.info("Step #5: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #6: Add new page");
		homePage.addNewPage(data.get("page_name_child_1"), data.get("page_name"), null, null, false);
		Assert.assertTrue(homePage.isChildPageDisplayed(data.get("page_name_child_1")),
				String.format("%s isn't displayed", data.get("page_name_child_1")));

		Log.info("Step #7: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #8: Add new page");
		homePage.addNewPage(data.get("page_name_child_2"), data.get("page_name"), null, null, false);
		Assert.assertTrue(homePage.isChildPageDisplayed(data.get("page_name_child_2")),
				String.format("%s isn't displayed", data.get("page_name_child_2")));

		CacheHelper.setValue("Key", data);
	}

	@SuppressWarnings("unchecked")
	@AfterMethod
	public void cleanUp() {
		Hashtable<String, String> data = CacheHelper.getValue("Key", Hashtable.class);
		String menuPath1 = data.get("page_name") + ">" + data.get("page_name_child_1");
		String menuPath2 = data.get("page_name") + ">" + data.get("page_name_child_2");
		homePage.logoutAccount();
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		homePage.deleteAddedPage(menuPath1, SettingsButton.DELETE_PAGE.getName());
		homePage.deleteAddedPage(menuPath2, SettingsButton.DELETE_PAGE.getName());
		homePage.deleteAddedPage(data.get("page_name"), SettingsButton.DELETE_PAGE.getName());
	}
}
