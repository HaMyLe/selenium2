package utils;

import utils.helpers.PropertiesHelper;

public class Constants {
	
	public static final String URL = PropertiesHelper.getPropValue("profile.url");
	public static final String USERNAME = PropertiesHelper.getPropValue("profile.username");
	public static final String PASSWORD = PropertiesHelper.getPropValue("profile.password");
	public static final String TEST_UPPERCASE_PASSWORD = PropertiesHelper.getPropValue("profile.test_uppercase_password");
	public static final String TEST_LOWERCASE_USER = PropertiesHelper.getPropValue("profile.test_lowercase_username");
	public static final String TEST_LOWERCASE_PASSWORD = PropertiesHelper.getPropValue("profile.test_lowercase_password");
	public static final String USERNAME_PASS_INVALID_MESS = PropertiesHelper.getPropValue("profile.username_pass_invalid_mess");
}
