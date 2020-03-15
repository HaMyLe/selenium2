package utils;

import utils.helpers.PropertiesHelper;

public class Constants {
	
	public static final String URL = PropertiesHelper.getPropValue("profile.url");
	public static final String USERNAME = PropertiesHelper.getPropValue("profile.username");
	public static final String PASSWORD = PropertiesHelper.getPropValue("profile.password");

}
