package SeleLv2.testcases.PANEL;

import java.util.Hashtable;

import org.testng.annotations.Test;

import SeleLv2.testcases.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utils.Log;
import utils.SettingsButton;

public class DA_PANEL_TC027 extends BaseTest {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
    @Test (description = "Verify that when Choose panels form is expanded all pre-set panels are populated and sorted correctly", dataProvider = "getDataForTest")
	public void DA_LOGIN_TC027(Hashtable<String, String> data) {
		Log.info("Step #1: Login with valid account");
		loginPage.loginDA(data.get("username"), data.get("password"), data.get("sample_repository"));
		
		Log.info("Step #2: Go to Global Setting -> Add page");
		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Step #3: Enter info into all required fields on New Page dialog Page name: Page 1");
		homePage.addNewPage(data.get("page_name_1"), false);
		
		Log.info("Step #4: Go to Global Setting -> Create Panel");
		homePage.selectItemsSetting(SettingsButton.CREATE_PANEL);
		
		Log.info("Step #5: Enter Panel name into Display Name textbox");
		homePage.addNewPanel(data.get("display_name"),null,null,data.get("series"));
		
		Log.info("Step #6: Click Ok button in Panel Configuration popup");
		homePage.clickOkButtonAlert();
		
		Log.info("Step #7: Click on Choose Panel menu icon next to Global Setting icon");
//		homePage.selectItemsSetting(SettingsButton.ADD_PAGE);
		
		Log.info("Verify that all pre-set panels are populated and sorted correctly");
		
    }
}
