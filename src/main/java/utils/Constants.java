package utils;

import utils.helpers.PropertiesHelper;

public class Constants {
	
	public static final String URL = PropertiesHelper.getPropValue("profile.url");
	public static final String USERNAME = PropertiesHelper.getPropValue("profile.username");
	public static final String PASSWORD = PropertiesHelper.getPropValue("profile.password");
	public static final String TITLE_DASHBOARD = "TestArchitect �";
<<<<<<< HEAD
	
	//MESSAGE 
	public static final String SAMPLE_REPO_NAME = PropertiesHelper.getPropValue("profile.sample_repo_name");
	public static final String TEST_REPO_NAME = PropertiesHelper.getPropValue("profile.test_repo_name");
	
	// Timeout variables
    public static final int DRIVER_TIMEOUT = Integer.parseInt(PropertiesHelper.getPropValue("driver.timeout"));
    public static final int DRIVER_PAGELOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getPropValue("driver.pageload.timeout"));
    public static final int LONG_TIME = Integer.parseInt(PropertiesHelper.getPropValue("common.long.time"));
    public static final int MEDIUM_TIME = Integer.parseInt(PropertiesHelper.getPropValue("common.medium.time"));
    public static final int SHORT_TIME = Integer.parseInt(PropertiesHelper.getPropValue("common.short.time"));
    public static final int VERY_SHORT_TIME = Integer.parseInt(PropertiesHelper.getPropValue("common.very.short.time"));
=======
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
	public static final String INVALID_PASSWORD = PropertiesHelper.getPropValue("profile.invalid_password");
	
	public static final String INVALID_USERNAME = PropertiesHelper.getPropValue("profile.invalid_username");
	public static final String TEST_UPPERCASE_PASSWORD = PropertiesHelper.getPropValue("profile.test_uppercase_password");
	public static final String TEST_LOWERCASE_USER = PropertiesHelper.getPropValue("profile.test_lowercase_username");
	public static final String TEST_LOWERCASE_PASSWORD = PropertiesHelper.getPropValue("profile.test_lowercase_password");
//	public static final String INVALID_USERNAME_PASS_MSG =  PropertiesHelper.getPropValue("profile.username_pass_invalid_mess");
	public static final String SAMPLE_REPO_NAME = PropertiesHelper.getPropValue("profile.sample_repo_name");
	public static final String TEST_REPO_NAME = PropertiesHelper.getPropValue("profile.test_repo_name");

>>>>>>> TC2-5
}
