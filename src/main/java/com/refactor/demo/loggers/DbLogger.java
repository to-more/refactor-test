package com.refactor.demo.loggers;

import com.refactor.demo.daos.LoggerDao;

import java.util.logging.Level;

/**
 * Created by tomReq on 3/16/19.
 */
public class DbLogger implements Logger {


    private LoggerDao loggerDao;

    public DbLogger(LoggerDao loggerDao) {
        this.loggerDao = loggerDao;
    }

    @Override
    public void log(Level level, String message) {
        try {
            loggerDao.save(level, message);
        } catch (Exception e) {
            new ConsoleLogger().log(Level.SEVERE, "Error logging message " + message + " with logger file");
        }
    }
}
