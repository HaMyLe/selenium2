package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class Common {

    public static void executeCmd(String command) {
        try {
            Process process = Runtime.getRuntime().exec(
                    "cmd /c " + command, null, new File(getResource()));
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getResource() {
        return Paths.get("").toAbsolutePath().toString();
    }
}

