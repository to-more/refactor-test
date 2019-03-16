package com.refactor.demo

import com.refactor.demo.loggers.ConsoleLogger
import spock.lang.Specification

import java.util.logging.Level

/**
 * Created by tomReq on 3/16/19.
 */
class ConsoleLoggerSpec extends Specification {


    def "Logging with file"() {
        given:
        def consoleLogger = ConsoleLogger.newInstance()
        when:
        consoleLogger.log(level, msg)
        then:
        noExceptionThrown()
        where:
        level | msg
        Level.INFO      | "logging using console-logger"
        Level.SEVERE    | "logging using console-logger"
        Level.WARNING   | "logging using console-logger"
    }
}
