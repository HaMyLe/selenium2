package driver;

import java.util.Arrays;

public enum DriverType {
	CHROME("CHROME"), FIREFOX("CHROME"), IE("CHROME");

	private final String name;

	DriverType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static DriverType fromName(String driverName) {
		return Arrays.stream(DriverType.values()).filter(v -> v.name.equalsIgnoreCase(driverName))
				.findAny()
				.orElse(null);
	}

}
