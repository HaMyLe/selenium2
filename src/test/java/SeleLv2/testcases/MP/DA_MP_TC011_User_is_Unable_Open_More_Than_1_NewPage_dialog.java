package SeleLv2.testcases.MP;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC011_User_is_Unable_Open_More_Than_1_NewPage_dialog extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	private static Logger log4j = Logger.getLogger(DA_MP_TC011_User_is_Unable_Open_More_Than_1_NewPage_dialog.class);

	@Test
	public void DA_MP_TC011() throws Exception {
		
		log4j.info("Step #1: Navigate to Dashboard login page");
		log4j.info("Step #2: Login with valid account");
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		
		log4j.info("Step #3: Go to Global Setting -> Add page");
		homePage.selectItemsSetting("Add Page");
		
		log4j.info("Step #4: Try to go to Global Setting -> Add page again");
		homePage.selectItemsSetting("Add Page");
		
		log4j.info("Observe the current page -> User cannot go to Global Setting -> Add page while \"New Page\" dialog appears.");
		Assert.assertTrue(homePage.isDialogPageDisplayed("New Page"), "Dialog Add Page isn't displayed");

	}
}
