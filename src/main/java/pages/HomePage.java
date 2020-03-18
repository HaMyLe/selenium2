package pages;

import controls.common.Link;

public class HomePage extends GeneralPage{
	 
//	 private Link lnkDynameUsername = new Link("//a[text()='%s']");
	private Link lnkUser= new Link("//a[@href='#Welcome']");
	private Link lnkLogout = new Link("//a[text()='Logout']");
	 
	 public String getTextHomePage() {
		 lnkUser.waitForDisplay();
		 return lnkUser.getText();
	 }
	 
	 public void logoutAccount() {
		 lnkUser.waitForDisplay();
		 lnkUser.click();
		 lnkLogout.waitForDisplay();
		 lnkLogout.click();
	 }

}
