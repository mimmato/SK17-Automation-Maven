package lesson16;

import java.io.IOException;
public class killAllChromedrivers {
     public static void main(String[] args) {
            try {
                String os = System.getProperty("os.name").toLowerCase();
                String command;

                if (os.contains("win")) {
                    command = "taskkill /F /IM chromedriver.exe";
                } else if (os.contains("nix") || os.contains("nux")) {
                    command = "pkill chromedriver";
                } else {
                    System.out.println("Unsupported OS");
                    return;
                }

                Process process = Runtime.getRuntime().exec(command);
                process.waitFor();
                System.out.println("All chromedriver processes have been terminated.");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

