package com.refactor.demo.loggers;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

/**
 * Created by tomReq on 3/16/19.
 */
public class ConsoleLogger implements Logger {

    private static java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ConsoleLogger.class.getSimpleName());

    @Override
    public void log(Level level, String message) {
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(level, message);
    }
}
