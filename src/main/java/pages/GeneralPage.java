package pages;

import controls.common.Link;

public class GeneralPage {

	private Link lnkDynamicMenu = new Link("//a[text()='%s']");

	public void selectMainMenu(String pathMenu) {
		String[] menuIterms = pathMenu.split(">");

		for (int i = 0; i < menuIterms.length; i++) {
			lnkDynamicMenu.setDynamicValue(menuIterms[i].trim());
			lnkDynamicMenu.waitForVisibility();
			lnkDynamicMenu.moveTo();
		}
		lnkDynamicMenu.click();

	}

}
