package me.sfclog.helperbot.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    public DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public LocalDateTime now = LocalDateTime.now();


    public static File logFile = new File("plugins/HelperBOT/", "log.txt");

    public Logger() {
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void writelog(String msg) {
        if(logFile!= null) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(logFile, true);
                writer.write(dtf.format(now) + " - " + msg + "\n");
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
