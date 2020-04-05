package SeleLv2.testcases.MP;

import java.util.Hashtable;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Constants;

public class DA_MP_TC013_Newly_Added_Main_Parent_Page_Is_Positioned_At_The_Location_Specified_As_Set_With_Displayed_After_Field_Of_New_Page extends BaseTest {

	private static Logger log4j = Logger
			.getLogger(DA_MP_TC013_Newly_Added_Main_Parent_Page_Is_Positioned_At_The_Location_Specified_As_Set_With_Displayed_After_Field_Of_New_Page.class);
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@Test(dataProvider = "getDataForTest")
	public void DA_MP_TC013(Hashtable<String, String> data) throws Exception {
		
		String item = "Delete";
		
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
		homePage.addNewPage(data.get("page_name_2"), null, null, data.get("display_after"), false);

		log4j.info("Step #6: Check \"Another Test\" page is positioned besides the \"Test\" page");
		Assert.assertTrue(homePage.isPositionBesidePage(data.get("page_name_1")),
				String.format("%s is positioned besides the %s", data.get("page_name_1"), data.get("page_name_2")));
		
		log4j.info("Step #7: Delete newly added main child page and its parent page");
		homePage.deleteAddedPage(data.get("page_name_2"), item);
		homePage.deleteAddedPage(data.get("page_name_1"), item);
	}

}
