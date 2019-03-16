package com.refactor.demo;


import com.refactor.demo.daos.LoggerDao;
import com.refactor.demo.loggers.ConsoleLogger;
import com.refactor.demo.loggers.DbLogger;
import com.refactor.demo.loggers.FileLogger;
import com.refactor.demo.loggers.Logger;

import java.util.Map;
import java.util.logging.Level;

public class JobLogger {

    private Map<String, Logger> loggers;

    public JobLogger(Map properties) {
        loggers = Map.of(
                "console", new ConsoleLogger(),
                "file", new FileLogger(properties),
                "db", new DbLogger(new LoggerDao(properties)
            )
        );
    }

    public void LogMessage(String loggerType, String messageText, Level level) {
        loggers.get(loggerType).log(level, messageText);
    }
}