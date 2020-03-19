package pages;

import controls.common.Link;

public class HomePage extends GeneralPage{
	 
//	 private Link lnkDynameUsername = new Link("//a[text()='%s']");
	private Link lnkUser= new Link("//a[@href='#Welcome']");
	private Link lnkLogout = new Link("//a[text()='Logout']");
	private Link lnkTitle = new Link("//title[contains(.,'TestArchitect')]");
	 
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
}