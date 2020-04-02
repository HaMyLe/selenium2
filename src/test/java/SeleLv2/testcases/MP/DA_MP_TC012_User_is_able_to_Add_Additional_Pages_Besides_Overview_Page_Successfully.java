package SeleLv2.testcases.MP;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC012_User_is_able_to_Add_Additional_Pages_Besides_Overview_Page_Successfully extends BaseTest {
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void DA_MP_TC012() throws Exception {
		String pageName = "Test";
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		homePage.selectItemsSetting("Add Page");
		homePage.addNewPage(pageName, null, null, null, false);
		Assert.assertTrue(homePage.isPageCreated(pageName), String.format("%s isn't displayed",pageName));
		homePage.deleteNewlyAddedPage(pageName, "Delete");
	}
}
