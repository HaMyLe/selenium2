package SeleLv2.testcases.MP;

import java.util.Hashtable;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC025 extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
    @Test (description = "Verify that user is able to edit the name of the page (Parent/Sibbling) successfully", dataProvider = "getDataForTest")
	public void DA_LOGIN_TC025(Hashtable<String, String> data) {
		Log.info("Step #1: Login with valid account");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #3: Enter info into all required fields on New Page dialog Page name: Page 1");
		homePage.addNewPage(data.get("page_name_1"), false);
		
		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #5: Enter info into all required fields on New Page dialog Page name: Page 2");
		homePage.addNewPage(data.get("page_name_2"),  false);
		
		Log.info("Step #6: Click Edit link for Page 2 created page");
		homePage.selectMenuPath(data.get("path_page2"));
		homePage.selectItemsSetting(SettingsButton.EDIT_PAGE);
		
		Log.info("Step #7: Change value Display After for the second created page to after Overview page");
		homePage.editNewPage(null, data.get("parent_page_name"), null, null, false);
		
		Log.info("VP #1: Observe the current page");
		homePage.selectMenuPath(data.get("path_page2_new"));
		homePage.isChildPageDisplayed(data.get("page_name_2"));
		
    }
}
