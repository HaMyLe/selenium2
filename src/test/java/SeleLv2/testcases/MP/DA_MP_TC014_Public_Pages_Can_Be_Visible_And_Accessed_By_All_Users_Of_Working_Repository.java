package SeleLv2.testcases.MP;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC014_Public_Pages_Can_Be_Visible_And_Accessed_By_All_Users_Of_Working_Repository extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	private static Logger log4j = Logger
			.getLogger(DA_MP_TC014_Public_Pages_Can_Be_Visible_And_Accessed_By_All_Users_Of_Working_Repository.class);

	@Test
	public void DA_MP_TC014() throws Exception {

		String pageName = "Test";

		log4j.info("Step #1: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		log4j.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");

		log4j.info("Step #3: Add new page");
		homePage.addNewPage(pageName, null, null, null, true);
		
		log4j.info("Step #4: Click on Log out link");
		homePage.logoutAccount();
		
		log4j.info("Step #5: Navigate to Dashboard login page and Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);

		log4j.info("Step #6:Check \"Test\" page is displayed besides \"Overview\" page");
		Assert.assertTrue(homePage.isPageCreated(pageName), String.format("%s isn't displayed", pageName));
		
		log4j.info("Step #7: Click on Log out link");
		homePage.logoutAccount();
		
		log4j.info("Step #8: Log in  as creator page account and delete newly added page");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		
		log4j.info("Step #9: Delete newly added page");
		homePage.deleteAddedPage(pageName, "Delete");

	}
}
