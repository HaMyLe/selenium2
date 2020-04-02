package controls.common;

import org.openqa.selenium.By;

import controls.base.BaseControl;

public class CheckBox extends BaseControl{
	public CheckBox(By locator) {
        super(locator);
    }

    public CheckBox(String locator) {
        super(locator);
    }

    public CheckBox(String locator, Object... value) {
        super(locator, value);
    }

    public CheckBox(BaseControl parent, String locator) {
        super(parent, locator);
    }

    public CheckBox(BaseControl parent, By locator) {
        super(parent, locator);
    }

    public CheckBox(BaseControl parent, String locator, Object... value) {
        super(parent, locator, value);
    }
    
    public void check() {
        if (!isChecked()) {
            click();
        }
    }
    
    public boolean isChecked() {
        return isSelected();
    }
}