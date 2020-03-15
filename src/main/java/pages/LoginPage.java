package pages;

import controls.common.Button;
import controls.common.TextBox;

public class LoginPage {
	
	TextBox txtUsername = new TextBox("id=username");
	TextBox txtPassword = new TextBox("id=password");
	Button btnLogin = new Button("//div[@class='btn-login']");
	
	public void loginDA(String username, String password) {
		txtUsername.enter(username);
		txtPassword.enter(password);
		btnLogin.click();
	}

}
