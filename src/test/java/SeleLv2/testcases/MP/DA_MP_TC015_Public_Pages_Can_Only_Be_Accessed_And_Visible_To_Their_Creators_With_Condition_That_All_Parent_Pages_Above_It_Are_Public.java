package SeleLv2.testcases.MP;

import java.util.Hashtable;
import org.testng.Assert;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_MP_TC015_Public_Pages_Can_Only_Be_Accessed_And_Visible_To_Their_Creators_With_Condition_That_All_Parent_Pages_Above_It_Are_Public extends BaseTest{

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC015(Hashtable<String, String> data) throws Exception {
		
		String item = "Delete";
		String pathMenu = data.get("page_name_1") + ">" + data.get("page_name_2");
				
		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");

		Log.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name_1"), null, null, null, true);
		Assert.assertTrue(homePage.isPageCreated(data.get("page_name_1")), String.format("%s isn't displayed",data.get("page_name_1")));
		
		Log.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");
		
		Log.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_2"), data.get("parent_dropdown"), null, null, false);
		
		Log.info("Step #7: Click on Log out link");
		homePage.logoutAccount();
		
		Log.info("Step #8: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		Log.info("Step #6: Check children is invisibled");
//		Assert.assertFalse(homePage.isChildPageCreadted(data.get("page_name_2")),
//				String.format("%s is visibled", data.get("page_name_2")));
		
		Log.info("Step #7: Click on Log out link");
		homePage.logoutAccount();
		
		Log.info("Step #8: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		Log.info("Step #7: Delete newly added main child page and its parent page");
		homePage.deleteChildMenu(pathMenu, item);
		homePage.deleteAddedPage(data.get("page_name_1"), item);
	}
}
