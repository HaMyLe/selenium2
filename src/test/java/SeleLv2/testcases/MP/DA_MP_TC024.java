package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;
import utils.helpers.CacheHelper;

public class DA_MP_TC024 extends BaseTest{
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
    @Test (description = "Verify that user is able to edit the name of the page (Parent/Sibbling) successfully")
	public void DA_LOGIN_TC024(Hashtable<String, String> data) throws InterruptedException {
		Log.info("Step #1: Login with valid account");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #2: Go to Global Setting -> Add page	");
		homePage.selectItemsSetting("Add Page");
		
		Log.info("Step #3: Enter info into all required fields on New Page dialog Page name: Page 1");
		homePage.addNewPage(data.get("page_name_1"), data.get("parent_page_name_1"), null, null, false);
		
		Log.info("Step #4: Go to Global Setting -> Add page	");
		homePage.selectItemsSetting("Add Page");
		
		Log.info("Step #5: Enter info into all required fields on New Page dialog Page name: Page 2");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_page_name_2"), null, null, false);
		
		Log.info("Step #6: Go to Page 1");
		homePage.goToPage(path); 
		
		Log.info("VP #1: Observe the current page");
		homePage.isPageDisplayed(data.get("page_name_1"));
		
		Log.info("Step #7: Go to Page 2");
		homePage.goToPage(path); 
		
		Log.info("VP #2: Observe the current page");
		homePage.isPageDisplayed(data.get("page_name_2"));
		
    }

}
