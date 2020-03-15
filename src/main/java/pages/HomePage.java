package pages;

import controls.common.Link;

public class HomePage extends GeneralPage{
	 
//	 private Link lnkDynameUsername = new Link("//a[text()='%s']");
	private Link lnkUser= new Link("//a[@href='#Welcome']");
	 
	 public String getTextHomePage() {
		 lnkUser.waitForDisplay();
		 return lnkUser.getText();
	 }

}
