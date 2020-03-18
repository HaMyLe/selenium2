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
		try {
			Thread.sleep(2000);
			btnLogin.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
