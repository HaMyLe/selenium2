package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC022 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
    
    @Test (description = "Verify that user is unable to duplicate the name of sibbling page under the same parent page", dataProvider = "getDataForTest")
	public void DA_LOGIN_TC022(Hashtable<String, String> data) {
		Log.info("Step #1: Log in specific repository with valid account ");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #2: Add a new page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		homePage.addNewPage(data.get("page_name_1"), false);
		
		Log.info("Step #3: Add a sibling page of new page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_page_name_2"), null, null, false);
		
		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #5: Enter Page Name");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_page_name_2"), null, null, false);
		
		Log.info("VP #1: Check warning message Test child already exist. Please enter a diffrerent name appears");
		Assert.assertEquals(homePage.getAlterMessage(), data.get("warning_message"),
				"The warning message doesn't match");
    }
   
}
