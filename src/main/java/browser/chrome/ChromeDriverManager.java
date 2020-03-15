package browser.chrome;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.*;

import driver.manager.*;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	public void createWebDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		this.driver = new ChromeDriver(options);	
	}

}
