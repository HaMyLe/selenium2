package utils;

import utils.helpers.PropertiesHelper;

public class Constants {
	
	public static final String URL = PropertiesHelper.getPropValue("profile.url");
	public static final String USERNAME = PropertiesHelper.getPropValue("profile.username");
	public static final String PASSWORD = PropertiesHelper.getPropValue("profile.password");
	public static final String TITLE_DASHBOARD = "TestArchitect ™";
	public static final String TC006_USERNAME = "TEST";
	public static final String TC006_UPPERCASE_PASSWORD = "TEST";
	public static final String TC006_LOWERCASE_PASSWORD = "test";
	public static final String TC007_UPPERCASE_USERNAME = "TAADMIN";
	public static final String TC007_LOWERCASE_USERNAME = "TAADMIN";
	public static final String TC007_PASSWORD = "taadmin";
	public static final String TC008_USERNAME = "tc008";
	public static final String TC008_PASSWORD = "p@ssw0rd";
	public static final String TC009_USERNAME = "tc009!";
	public static final String TC009_PASSWORD = "taadmin";
	
	
	
	//MESSAGE 
	public static final String INVALID_USERNAME_PASS_MSG = "Username or password is invalid";
	public static final String EMPTY_USERNAME_MSG = "Please enter username!";
}
