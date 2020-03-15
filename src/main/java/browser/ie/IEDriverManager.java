package browser.ie;

import io.github.bonigarcia.wdm.*;
import driver.manager.*;
import org.openqa.selenium.edge.*;
public class IEDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		this.driver = new EdgeDriver(options);
	}

}
