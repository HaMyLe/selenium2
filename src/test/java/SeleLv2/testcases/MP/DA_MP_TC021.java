package SeleLv2.testcases.MP;

import java.util.Hashtable;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC021 extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
    @Test (description = "Verify that user is able to edit the name of the page (Parent/Sibbling) successfully", dataProvider = "getDataForTest")
	public void TC021(Hashtable<String, String> data) {
		Log.info("Step #2: Login with valid account");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #4: Enter info into all required fields on New Page dialog Page name: Page 1");
		homePage.addNewPage(data.get("page_name_1"), data.get("parent_page_name_1"), null, null, false);
		
		Log.info("Step #5: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #6: Enter info into all required fields on New Page dialog Page name: Page 2");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_page_name_2"), null, null, false);
		
		Log.info("Step #7: Go to Page 1");
		homePage.selectMenuPath(data.get("path_page1"));
		
		Log.info("Step #8: Change name of Page 1 to Page 3 and click Ok button");
		homePage.editNewPage(data.get("page_name_3"), false);
		
		Log.info("VP #1: Observe the current page");
		homePage.isPageDisplayed(data.get("page_name_3"));
		
		Log.info("Step #9: Go to Page 2");
		homePage.selectMenuPath(data.get("path_page2"));
		
		Log.info("Step #10: Change name of Page 2 to Page 4 and click Ok button");
		homePage.editNewPage(data.get("page_name_4"), true);
		
		Log.info("VP #2: Observe the current page");
		homePage.isChildPageDisplayed(data.get("page_name_4"));
    } 

}