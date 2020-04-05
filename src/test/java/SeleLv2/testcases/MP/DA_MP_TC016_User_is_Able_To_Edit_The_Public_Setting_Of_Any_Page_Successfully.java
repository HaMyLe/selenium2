package SeleLv2.testcases.MP;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC016_User_is_Able_To_Edit_The_Public_Setting_Of_Any_Page_Successfully extends BaseTest{

	private static Logger log4j = Logger
			.getLogger(DA_MP_TC016_User_is_Able_To_Edit_The_Public_Setting_Of_Any_Page_Successfully.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC016(Hashtable<String, String> data) throws Exception {
		
		String itemDelete = "Delete";
		String itemEdit = "Edit";
				
		log4j.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		log4j.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");

		log4j.info("Step #3: Add new page");
		homePage.addNewPage(data.get("page_name_1"), null, null, null, false);
		Assert.assertTrue(homePage.isPageCreated(data.get("page_name_1")), String.format("%s isn't displayed",data.get("page_name_1")));
		
		log4j.info("Step #4: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");

		log4j.info("Step #5: Add new page");
		homePage.addNewPage(data.get("page_name_2"), null, null, null, true);
		Assert.assertTrue(homePage.isPageCreated(data.get("page_name_2")), String.format("%s isn't displayed",data.get("page_name_1")));
		
		log4j.info("Step #6: Go to Global Setting -> Edit page");
		homePage.gotToEditPage(data.get("page_name_1"), itemEdit);
		
		log4j.info("Step #7: Check \"Edit Page\" pop up window is displayed");
		Assert.assertTrue(homePage.isDialogPageDisplayed("Edit Page"), "Edit Page pop up doesn't display");
		
		log4j.info("Step #8: Edit page");
		homePage.editNewPage(data.get("page_name_1"), null, null, null, true);
		
		log4j.info("Step #9: Go to Global Setting -> Edit page");
		homePage.gotToEditPage(data.get("page_name_2"), itemEdit);
		
		log4j.info("Step #10: Check \"Edit Page\" pop up window is displayed");
		Assert.assertTrue(homePage.isDialogPageDisplayed("Edit Page"), "Edit Page pop up doesn't display");
		
		log4j.info("Step #11: Edit page");
		homePage.editNewPage(data.get("page_name_2"), null, null, null, false);
		
		log4j.info("Step #12: Click on Log out link");
		homePage.logoutAccount();
		
		log4j.info("Step #13: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		log4j.info("Step #14: Check " + data.get("page_name_1") + "page is visible and can be accessed");
		Assert.assertTrue(homePage.isChildPageCreadted(data.get("page_name_1")),
				String.format("%s is invisibled", data.get("page_name_1")));
		
//		log4j.info("Step #15: Check " + data.get("page_name_2") + "page is invisible");
//		Assert.assertFalse(homePage.isChildPageCreadted(data.get("page_name_2")),
//				String.format("%s is visibled", data.get("page_name_2")));
		
		log4j.info("Step #16: Click on Log out link");
		homePage.logoutAccount();
		
		log4j.info("Step #17: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		log4j.info("Step #18: Delete newly added main child page and its parent page");
		homePage.deleteAddedPage(data.get("page_name_1"), itemDelete);
		homePage.deleteAddedPage(data.get("page_name_2"), itemDelete);
	}
}
