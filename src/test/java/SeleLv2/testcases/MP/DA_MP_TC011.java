package SeleLv2.testcases.MP;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;
import utils.Log;

public class DA_MP_TC011 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(description = "Verify that user is unable open more than 1 New Page dialog")
	public void TC011() throws Exception {

		Log.info("Step #1: Navigate to Dashboard login page");
		Log.info("Step #2: Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);

		Log.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectAddPage();

		Log.info("Step #4: Try to go to Global Setting -> Add page again");
		homePage.selectAddPage();

		Log.info(
				"Step #5: Observe the current page -> User cannot go to Global Setting -> Add page while \"New Page\" dialog appears.");
		Assert.assertTrue(homePage.isDialogPageDisplayed("New Page"), "Dialog Add Page isn't displayed");

	}
}
