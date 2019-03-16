package com.refactor.demo

import spock.lang.Specification

import java.util.logging.Level

class JobLoggerSpec extends Specification {

    void "test job logger"() {
        when:
        def jobLogger = new JobLogger([:])
        then:
        jobLogger.LogMessage("console", "Log message", Level.WARNING)
        jobLogger.LogMessage("db", "Log message", Level.WARNING)
        jobLogger.LogMessage("file", "Log message", Level.WARNING)
    }
}
