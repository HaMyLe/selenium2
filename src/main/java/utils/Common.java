package utils;

import java.io.File;
import java.io.IOException;

public class Common {

    public static void executeCmd(String command) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // Windows

        try {
            Process process = Runtime.getRuntime().exec(
                    "cmd /c " + command, null, new File("C:\\Users\\trang.thi.le\\Desktop\\Sele2\\selenium2\\"));
            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
