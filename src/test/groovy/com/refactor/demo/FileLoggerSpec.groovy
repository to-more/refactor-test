package com.refactor.demo

import com.refactor.demo.loggers.FileLogger
import spock.lang.Specification

import java.util.logging.Level

/**
 * Created by tomReq on 3/16/19.
 */
class FileLoggerSpec extends Specification {


    def "Logging with file"() {
        given:
        def file = new File("/tmp/logFile.log")

        def properties = new HashMap()
        properties.put(FileLogger.FOLDER_NAME, "/tmp")

        def fileLogger = FileLogger.newInstance(properties)
        when:
        fileLogger.log(level, "logging using file-logger")
        then:
        file.exists()
        file.readLines().find { it.contains(msg) }
        where:
        level | msg
        Level.INFO      | "INFO"
        Level.SEVERE    | "SEVERE"
        Level.WARNING   | "WARNING"
    }

    def "Logging without properties file"() {
        given:
        def file = new File("/tmp/logFile.log")
        if (file.exists()) {
            file.delete()
        }
        def fileLogger = FileLogger.newInstance()
        when:
        fileLogger.log(Level.WARNING, "logging using file-logger")
        then:
        !file.exists()
    }
}
