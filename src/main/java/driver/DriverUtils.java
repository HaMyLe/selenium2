package driver;

import org.openqa.selenium.JavascriptExecutor;

import driver.manager.DriverManagerFactory;

public class DriverUtils extends DriverManagerFactory {
	
	public static void maximumBrowser() {
		getDriver().manage().window().maximize();
	}
	
	public static Object execJavaScript(String script, Object... objs) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, objs);
    }
	
	public static int getTimeOut() {
        return DriverManagerFactory.getTimeOut();
    }
	
}
