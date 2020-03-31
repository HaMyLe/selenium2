package controls.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import controls.base.BaseControl;

public class TextBox extends BaseControl {
	
	private Logger logger = Logger.getLogger(TextBox.class);
	
	public TextBox(String locator) {
		super(locator);
	}

	public TextBox(By locator) {
		super(locator);
	}

	public TextBox(String locator, Object... value) {
		super(locator, value);
	}

	public TextBox(BaseControl parent, String locator) {
		super(parent, locator);
	}

	public TextBox(BaseControl parent, By locator) {
		super(parent, locator);
	}

	public TextBox(BaseControl parent, String locator, Object... value) {
		super(parent, locator, value);
	}
	
	public void enter(CharSequence... value) {
		try {
			logger.debug(String.format("Enter '%s' for %s", value, getLocator().toString()));
			getElement().sendKeys(value);
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
		}
	}
    
    public void clear() {
		try {
			logger.debug(String.format("Clean text for %s", getLocator().toString()));
			getElement().clear();
		} catch (Exception e) {
			logger.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
		}
	}

}