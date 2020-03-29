package SeleLv2.testcases.MP;

import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC011_User_is_Unable_Open_More_Than_1_NewPage_dialog extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test
	public void DA_MP_TC011() throws Exception {
		loginPage.loginDA(Constants.USERNAME, Constants.PASSWORD);
		Assert.assertEquals(homePage.getUserName(), Constants.USERNAME);
		homePage.selectItemsSetting("Add Page");
		homePage.selectItemsSetting("Add Page");
		Assert.assertTrue(homePage.isDialogPageDisplayed("New Page"), "Dialog Add Page isn't displayed");

	}
}
