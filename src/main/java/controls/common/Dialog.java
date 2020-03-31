package controls.common;

import org.openqa.selenium.By;

import controls.base.BaseControl;

public class Dialog extends BaseControl{
	
	public Dialog(String locator) {
		super(locator);
	}

	public Dialog(By locator) {
		super(locator);
	}

	public Dialog(String locator, Object... value) {
		super(locator, value);
	}

	public Dialog(BaseControl parent, String locator) {
		super(parent, locator);
	}

	public Dialog(BaseControl parent, By locator) {
		super(parent, locator);
	}

	public Dialog(BaseControl parent, String locator, Object... value) {
		super(parent, locator, value);
	}

}
