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

public class DA_MP_TC013_Newly_Added_Main_Parent_Page_Is_Positioned_At_The_Location_Specified_As_Set_With_Displayed_After_Field_Of_New_Page extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC013(Hashtable<String, String> data) throws Exception {
		
		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");

		Log.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name_1"), false);
		Assert.assertTrue(homePage.isPageCreated(data.get("page_name_1")), String.format("%s isn't displayed",data.get("page_name_1")));
		
		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());
		
		Log.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_2"), data.get("display_after"), false);

		Log.info("Step #6: Check \"Another Test\" page is positioned besides the \"Test\" page");
		Assert.assertTrue(homePage.isPositionBesidePage(data.get("page_name_1")),
				String.format("%s is positioned besides the %s", data.get("page_name_1"), data.get("page_name_2")));
		
		CacheHelper.setValue("Key", data);
	}
	
	@SuppressWarnings("unchecked")
	@AfterMethod
	public void cleanUp() {
		Hashtable<String, String> data = CacheHelper.getValue("Key", Hashtable.class);
		homePage.deleteAddedPage(data.get("page_name_2"), SettingsButton.DELETE_PAGE.getName());
		homePage.deleteAddedPage(data.get("page_name_1"), SettingsButton.DELETE_PAGE.getName());
	}

}
