package pages;

import controls.common.Dialog;
import controls.common.Link;

public class HomePage extends GeneralPage {

//	 private Link lnkDynameUsername = new Link("//a[text()='%s']");
	private Link lnkUser = new Link("//a[@href='#Welcome']");
	private Link lnkLogout = new Link("//a[text()='Logout']");
	private Link lnkTitle = new Link("//title[contains(.,'TestArchitect')]");
	private Link lnkRepo = new Link("//a[contains(.,'Repository')]/span");
	// a[.='Repository: SampleRepository']
	private Link lnkRepoName = new Link("//a[.='%s']");
	private Link lnkGlobalIcon = new Link("//div[@id='main-menu']//li[@class='mn-setting']");
	private Link lnkDynamicIttemSetting = new Link("//li[@class='mn-setting']//a[text()='%s']");
	private Dialog dlgDynamicPage = new Dialog("//div[@id='div_popup']//h2[text()='%s']");
	
	
	public String getUserName() throws Exception {
		lnkUser.waitForDisplay();
		return lnkUser.getText();
	}

	public void logoutAccount() {
		lnkUser.waitForDisplay();
		lnkUser.click();
		lnkLogout.waitForDisplay();
		lnkLogout.click();
	}

	public String getTitle() throws Exception {
		lnkTitle.waitForVisibility();
		return lnkTitle.getText();
	}

	public void selectRepo(String repo) throws InterruptedException {
		lnkRepo.waitForVisibility();
		lnkRepo.click();
		lnkRepoName.setDynamicValue(repo);
		lnkRepoName.waitForVisibility();
		lnkRepoName.click();
	}

	public String getTextRepo() {
		try {
			Thread.sleep(1000);
			lnkRepo.waitForVisibility();
			return lnkRepo.getText();

		} catch (Exception e) {

		}
		return "";
	}

	public void clickIconSetting() {
		lnkGlobalIcon.waitForVisibility();
		lnkGlobalIcon.click();
	}
	
	public void selectItemsSetting(String item) {
		clickIconSetting();
		lnkDynamicIttemSetting.setDynamicValue(item);
		lnkDynamicIttemSetting.waitForVisibility();
		lnkDynamicIttemSetting.click();
	}
	
	public boolean isDialogPageDisplayed(String page) {
		dlgDynamicPage.setDynamicValue(page);
		dlgDynamicPage.waitForVisibility();
		return dlgDynamicPage.isExist();
	}
	
}
