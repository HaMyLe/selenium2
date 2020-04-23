package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC026 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
    @Test (description = "Verify that page column is correct when user edit Number of Columns field of a specific page", dataProvider = "getDataForTest")
	public void TC026(Hashtable<String, String> data) {
		Log.info("Step #1: Login with valid account");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #3: Enter info into all required fields on New Page dialog");
		homePage.addNewPage(data.get("page_name_1"), null, data.get("number_of_column_1"), null, false);
		
		Log.info("Step #2: Go to Global Setting -> Edit");
		homePage.selectItemsSetting(SettingsButton.EDIT_PAGE);
		
		Log.info("Step #7: Edit Number of Columns for the above created page");
		homePage.editNewPage(null, null, data.get("number_of_column_2"), null, false);
		
		Log.info("VP #1: Observe the current page");
		homePage.isChildPageDisplayed(data.get("page_name_2"));
		
    }
}
