package pages;

import org.openqa.selenium.ElementClickInterceptedException;

import controls.common.Button;
import controls.common.CheckBox;
import controls.common.ComboBox;
import controls.common.Dialog;
import controls.common.Link;
import controls.common.TextBox;
import driver.DriverUtils;
import utils.Log;

public class HomePage extends GeneralPage {

	private Link lnkUser = new Link("//a[@href='#Welcome']");
	private Link lnkLogout = new Link("//a[text()='Logout']");
	private Link lnkTitle = new Link("//title[contains(.,'TestArchitect')]");
	private Link lnkRepo = new Link("//a[contains(.,'Repository')]/span");
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
	private Link lnkDynamicNewPage = new Link("//div[@id='main-menu']//a[text()='%s']");
	private Link lnkDynamicPositionBeside = new Link("//li[@class='active']/preceding-sibling::li/a[text()='%s']");
	private ComboBox cbbRepo = new ComboBox("id=ulListRepositories");

	public String getUserName() {
		lnkUser.waitForDisplay();
		return lnkUser.getText();
	}

	public void logoutAccount() {
		lnkUser.waitForDisplay();
		lnkUser.click();
		lnkLogout.waitForDisplay();
		lnkLogout.click();
	}

	public String getTitle() {
		lnkTitle.waitForVisibility();
		return lnkTitle.getText();
	}

	public void selectRepo(String repo) {
		lnkRepo.waitForVisibility();
		lnkRepo.click();
		lnkRepoName.setDynamicValue(repo);
		lnkRepoName.waitForVisibility();
		lnkRepoName.click();
	}

	public String getTextRepo() {
		lnkRepo.waitTextRepoChange();
//		lnkRepo.waitForVisibility();
		return lnkRepo.getText();
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
	
	public boolean isItemUnderSettingDisplayed(String item) {
		clickIconSetting();
		return lnkDynamicIttemSetting.isVisible();
	}
	
	public void selectAddPage() {
		try {
			selectItemsSetting("Add Page");
		} catch (ElementClickInterceptedException e) {
			Log.info("Element is not interacted");
		}
	}

	public boolean isDialogPageDisplayed(String page) {
		dlgDynamicPage.setDynamicValue(page);
		dlgDynamicPage.waitForVisibility();
		return dlgDynamicPage.isVisible();
	}

	public void fillDataToAddPage(String pageName, String parentPage, String numberOfColumn, String displayAfter,
			Boolean ispublic) {
		txtPageName.waitForVisibility();
		txtPageName.clear();
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
		ckbPublic.waitForVisibility();
		ckbPublic.setState(ispublic);

	}

	public void addNewPage(String pageName, String parentPage, String numberOfColumn, String displayAfter,
			Boolean ispublic) {
		waitForPageLoad();
		fillDataToAddPage(pageName, parentPage, numberOfColumn, displayAfter, ispublic);
		clickButtonOkDialog();
		btnOkButton.waitForInVisibility();
	}

	public void addNewPage(String pageName, Boolean isPulic) {
		waitForPageLoad();
		fillDataToAddPage(pageName, null, null, null, isPulic);
		clickButtonOkDialog();
		btnOkButton.waitForInVisibility();
	}
	
	public void addNewPage(String pageName, String displayAfter, Boolean isPulic) {
		waitForPageLoad();
		fillDataToAddPage(pageName, null, null, displayAfter, isPulic);
		clickButtonOkDialog();
		btnOkButton.waitForInVisibility();
	}

	public void editNewPage(String pageName, String parentPage, String numberOfColumn, String displayAfter,
			Boolean ispublic) {
		waitForPageLoad();
		fillDataToAddPage(pageName, parentPage, numberOfColumn, displayAfter, ispublic);
		clickButtonOkDialog();
		btnOkButton.waitForInVisibility();
	}
	
	public void editNewPage(String pageName,Boolean ispublic) {
		waitForPageLoad();
		fillDataToAddPage(pageName, null, null, null, ispublic);
		clickButtonOkDialog();
		btnOkButton.waitForInVisibility();
	}

	public void clickButtonOkDialog() {
		btnOkButton.waitForVisibility();
		btnOkButton.click();
	}

	public void clickButtonCancelDialog() {
		btnCancelButton.waitForVisibility();
		btnCancelButton.click();
	}

	public boolean isPageDisplayed(String page) {
		lnkDynamicNewPage.setDynamicValue(page);
		return lnkDynamicNewPage.isVisible();
	}

	public boolean isChildPageDisplayed(String page) {
		waitForPageLoad();
		lnkDynamicNewPage.setDynamicValue(page);
		return lnkDynamicNewPage.isExist();
	}

	public void deleteAddedPage(String page, String item) {
		waitForPageLoad();
		selectMenuPage(page);
		selectItemsSetting(item);
		DriverUtils.acceptAltert();
		lnkDynamicNewPage.waitForInVisibility();
	}

	public void deleteChildMenu(String pathMenu, String item) {
		waitForPageLoad();
		selectMenuPath(pathMenu);
		selectItemsSetting(item);
		DriverUtils.acceptAltert();
		lnkDynamicNewPage.waitForInVisibility();
	}

	public boolean isPositionBesidePage(String page) {
		lnkDynamicPositionBeside.setDynamicValue(page);
		lnkDynamicPositionBeside.waitForVisibility();
		return lnkDynamicPositionBeside.isVisible();
	}

	public void gotToEditPage(String page, String item) {
		waitForPageLoad();
		selectMenuPage(page);
		selectItemsSetting(item);
	}

	public void selectMenuPage(String page) {
		lnkDynamicNewPage.setDynamicValue(page);
		lnkDynamicNewPage.waitForVisibility();
		lnkDynamicNewPage.click();
	}
	
	public String getAlterMessage() {
		return DriverUtils.getTextAlert().trim();
	}

}