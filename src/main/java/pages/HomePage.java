package pages;

import controls.common.Button;
import controls.common.CheckBox;
import controls.common.ComboBox;
import controls.common.Dialog;
import controls.common.Link;
import controls.common.TextBox;

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
	private TextBox txtPageName = new TextBox("id=name");
	private ComboBox cbxParentPage = new ComboBox("id=parent");
	private ComboBox cbxNumberOfColumn = new ComboBox("id=columnnumber");
	private ComboBox cbxDisplayAfter = new ComboBox("id=afterpage");
	private CheckBox ckbPublic = new CheckBox("id=ispublic");
	private Button btnOkButton = new Button("id=OK");
	private Button btnCancelButton = new Button("id=Cancel");
	private Link lnkDynamicNewPage = new Link("//div[@id='main-menu']//li[@class='active']/a[text()='%s']");

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

	public void fillDataToAddPage(String pageName, String parentPage, String numberOfColumn, String displayAfter,
			Boolean ispublic) {
		txtPageName.waitForVisibility();
		txtPageName.enter(pageName);
		if (parentPage != null) {
			cbxParentPage.waitForVisibility();
			cbxParentPage.select(parentPage);
		}
		if (numberOfColumn != null) {
			cbxNumberOfColumn.waitForVisibility();
			cbxNumberOfColumn.select(numberOfColumn);
		}
		if (displayAfter != null) {
			cbxDisplayAfter.waitForVisibility();
			cbxDisplayAfter.select(displayAfter);
		}
		if (ispublic == true) {
			ckbPublic.waitForVisibility();
			ckbPublic.check();
		}
	}

	public void addNewPage(String pageName, String parentPage, String numberOfColumn, String displayAfter,
			Boolean ispublic) {
		fillDataToAddPage(pageName, parentPage, numberOfColumn, displayAfter, ispublic);
		clickButtonOkDialog();
	}

	public void clickButtonOkDialog() {
		btnOkButton.waitForVisibility();
		btnOkButton.click();
	}

	public void clickButtonCancelDialog() {
		btnCancelButton.waitForVisibility();
		btnCancelButton.click();
	}

	public boolean isPageCreated(String page) {
		lnkDynamicNewPage.setDynamicValue(page);
		lnkDynamicNewPage.waitForVisibility();
		return lnkDynamicNewPage.isExist();
	}
	
	public void deleteNewlyAddedPage(String page, String item) {
		lnkDynamicNewPage.setDynamicValue(page);
		lnkDynamicNewPage.waitForVisibility();
		lnkDynamicNewPage.click();
		selectItemsSetting(item);
	}
}
