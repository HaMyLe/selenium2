package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC019
		extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description="Verify that user is able to add additional sibbling page levels to the parent page successfully.", dataProvider = "getDataForTest")
	public void TC019(Hashtable<String, String> data) throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #4: Enter info into all required fields on New Page dialog");
		homePage.addNewPage(data.get("page_name"), data.get("parent_page"), null, null, false);

		Log.info("Step #5: Observe the current page");
		Assert.assertTrue(homePage.isChildPageDisplayed(data.get("page_name")),
				String.format("%s isn't displayed", data.get("page_name")));

	}
}
