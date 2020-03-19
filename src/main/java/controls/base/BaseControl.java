package controls.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverUtils;

public class BaseControl {
	private Logger logger = Logger.getLogger(BaseControl.class);
    private String locator;
    private By byLocator;
    private String dynamicLocator;
    private BaseControl parent;
    
    public BaseControl(String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
    }

    public BaseControl(By byLocator) {
        this.byLocator = byLocator;
    }

    public BaseControl(String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
    }

    public BaseControl(BaseControl parent, String locator) {
        this.locator = locator;
        this.dynamicLocator = locator;
        this.byLocator = getByLocator();
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, By byLocator) {
        this.byLocator = byLocator;
        this.parent = parent;
    }

    public BaseControl(BaseControl parent, String locator, Object... args) {
        this.dynamicLocator = locator;
        this.locator = String.format(dynamicLocator, args);
        this.byLocator = getByLocator();
        this.parent = parent;
    }
    
    protected WebDriver getDriver() {
        return DriverUtils.getDriver();
    }

    protected JavascriptExecutor jsExecutor() {
        return (JavascriptExecutor) getDriver();
    }
    
    public void setDynamicValue(Object... args) {
        this.locator = String.format(this.dynamicLocator, args);
        this.byLocator = getByLocator();
    }
    
    public void focus() {
        DriverUtils.execJavaScript("arguments[0].focus();", getElement());
    }
    
    private By getByLocator() {
        String body = this.locator.replaceAll("[\\w\\s]*=(.*)", "$1").trim();
        String type = this.locator.replaceAll("([\\w\\s]*)=.*", "$1").trim();
        switch (type.toLowerCase()) {
            case "css":
                return By.cssSelector(body);
            case "id":
                return By.id(body);
            case "class":
                return By.className(body);
            case "link":
                return By.linkText(body);
            case "xpath":
                return By.xpath(body);
            case "text":
                return By.xpath(String.format("//*[contains(text(), '%s')]", body));
            case "name":
                return By.name(body);
            default:
                return By.xpath(locator);
        }
    }
    
    public WebElement getElement() {
        WebElement element = null;
        try {
            if (parent != null) {
                WebElement eleParent = parent.getElement();
                element = eleParent.findElement(getLocator());
            } else {
                element = getDriver().findElement(getLocator());
            }
            return element;
        } catch (StaleElementReferenceException e) {
            logger.error(
                    String.format("StaleElementReferenceException '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
            return getElement();
        }
    }
    
    public By getLocator() {
        return this.byLocator;
    }
    
    public String getText() {
        try {
            logger.debug(String.format("Get text of element %s", getLocator().toString()));
            return getElement().getText();
        } catch (Exception e) {
            logger.error(String.format("Has error with control '%s': %s", getLocator().toString(), e.getMessage().split("\n")[0]));
            throw e;
        }
    }
    
    public void mouseHoverJScript() {
        String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
        jsExecutor().executeScript(mouseOverScript, getElement());

    }
    
    public void moveTo() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getElement()).build().perform();
    }
    
    public void click() {
    	getElement().click();
    }
    
    public void waitForDisplay() {
        waitForDisplay(DriverUtils.getTimeOut());
    }
    
    public void waitForDisplay(int timeOutInSeconds) {
        try {
            logger.info(String.format("Wait for control display %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(getLocator()));
        } catch (Exception e) {
            logger.error(String.format("WaitForDisplay: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
        }
    }
    public void waitForAlert(int timeOutInSeconds) {
    	WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
    	wait.until(ExpectedConditions.alertIsPresent());
    }
    
    public void waitForVisibility(int timeOutInSeconds) {
        try {
            logger.info(String.format("Wait for control's visibility %s", getLocator().toString()));
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOutInSeconds);
            wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator()));
        } catch (Exception e) {
            logger.error(String.format("waitForVisibility: Has error with control '%s': %s", getLocator().toString(),
                    e.getMessage().split("\n")[0]));
        }
    }
    
    public void waitForVisibility() {
        waitForVisibility(DriverUtils.getTimeOut());
    }
    
}
