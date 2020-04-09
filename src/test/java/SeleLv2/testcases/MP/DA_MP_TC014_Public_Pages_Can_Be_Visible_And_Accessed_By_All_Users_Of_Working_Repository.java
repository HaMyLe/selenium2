package SeleLv2.testcases.MP;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;
import utils.SettingsButton;

public class DA_MP_TC014_Public_Pages_Can_Be_Visible_And_Accessed_By_All_Users_Of_Working_Repository extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	String pageName = "Test";
	
	@Test
	public void DA_MP_TC014() throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE.getName());

		Log.info("Step #3: Add new page");
		homePage.addNewPage(pageName, true);
		
		Log.info("Step #4: Click on Log out link");
		homePage.logoutAccount();
		
		Log.info("Step #5: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);

		Log.info("Step #6:Check \"Test\" page is displayed besides \"Overview\" page");
		Assert.assertTrue(homePage.isPageDisplayed(pageName), String.format("%s isn't displayed", pageName));
		
		Log.info("Step #7: Click on Log out link");
		homePage.logoutAccount();

	}
	
	@AfterMethod
	public void cleanUp() {
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		homePage.deleteAddedPage(pageName, SettingsButton.DELETE_PAGE.getName());
	}
}
