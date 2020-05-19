package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import controls.common.Link;
import driver.DriverUtils;
import utils.Constants;

public class GeneralPage {

	private Link lnkDynamicMenu = new Link("//a[text()='%s']");

	public void selectMenuPath(String pathMenu) {
		String[] menuItems = pathMenu.split(">");

		for (int i = 0; i < menuItems.length; i++) {
			lnkDynamicMenu.setDynamicValue(menuItems[i].trim());
			lnkDynamicMenu.waitForVisibility();
			lnkDynamicMenu.moveTo();
		}
		lnkDynamicMenu.click();
	}
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, Constants.LONG_TIME);
        wait.until(pageLoadCondition);
    }
    
    public void waitForPageLoad() {
    	waitForLoad(DriverUtils.getDriver());
    }
    
}
