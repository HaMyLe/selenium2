package utils;

public enum SettingsButton {

	ADD_PAGE("Add Page"),
	CREATE_PROFILE("Create Profile"),
	CREATE_PANEL("Create Panel"),
	EDIT_PAGE("Edit"),
	DELETE_PAGE("Delete");

	private final String name;

	SettingsButton(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
