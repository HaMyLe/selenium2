package browser.firefox;

import org.openqa.selenium.firefox.*;
import io.github.bonigarcia.wdm.*;
import driver.manager.*;

public class FireFoxDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxOptions options = new FirefoxOptions();
		this.driver = new FirefoxDriver(options);
	}
}
