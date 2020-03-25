package pages;


import controls.common.Link;

public class HomePage extends GeneralPage{
	 
//	 private Link lnkDynameUsername = new Link("//a[text()='%s']");
	private Link lnkUser= new Link("//a[@href='#Welcome']");
	private Link lnkLogout = new Link("//a[text()='Logout']");
	private Link lnkTitle = new Link("//title[contains(.,'TestArchitect')]");
	private Link lnkRepo = new Link("//a[contains(.,'Repository')]/span");
	//a[.='Repository: SampleRepository']
	private Link lnkRepoName = new Link("//a[.='%s']");	
	 
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

}
