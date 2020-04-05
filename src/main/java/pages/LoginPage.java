package pages;

import controls.common.Button;
import controls.common.ComboBox;
import controls.common.TextBox;
import driver.DriverUtils;
import utils.Constants;

public class LoginPage {
	
	TextBox txtUsername = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id=password");
	Button btnLogin = new Button("//div[@class='btn-login']");
	ComboBox cbbRepo = new ComboBox("id=repository");

	public void loginDA(String username, String password, String repo)  {
		txtUsername.enter(username);
		txtUsername.waitForDisplay();
		txtPassword.enter(password);
		txtPassword.waitForDisplay();
		if (repo != null) {
			cbbRepo.waitForDisplay();
			cbbRepo.select(repo);
		}
		clickBtnLogin();
		
	}

	public void loginDA(String username, String password)   {
		loginDA(username, password, null);
	}

	public void clickBtnLogin() {
		btnLogin.waitForVisibility();
		btnLogin.click();		
	}
	
	public String getTextAlert() {
		btnLogin.waitForAlert(Constants.VERY_SHORT_TIME);
		return DriverUtils.getTextAlert();
	}
}
