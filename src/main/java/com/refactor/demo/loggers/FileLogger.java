package com.refactor.demo.loggers;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.FileHandler;
import java.util.logging.Level;

/**
 * Created by tomReq on 3/16/19.
 */
public class FileLogger implements Logger {

    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FileLogger.class.getSimpleName());
    public static String FOLDER_NAME = "logFileFolder";
    private String fileName;
    public FileLogger(Map properties) {
        this.fileName = Optional.ofNullable(properties).orElse(new HashMap()).get(FOLDER_NAME) + "/logFile.log";
    }

    @Override
    public void log(Level level, String message) {
        File logFile = new File(fileName);

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
            FileHandler fh = new FileHandler(fileName);
            logger.addHandler(fh);
            logger.log(level, message);
        } catch (Exception e) {
            new ConsoleLogger().log(Level.SEVERE, "Error logging message => " + message + " with logger file");
        }
    }
}
