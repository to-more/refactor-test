package com.refactor.demo

import com.refactor.demo.daos.LoggerDao
import com.refactor.demo.loggers.DbLogger
import spock.lang.Specification

import java.util.logging.Level
/**
 * Created by tomReq on 3/16/19.
 */
class DbLoggerSpec extends Specification {


    def dao = Mock(LoggerDao)

    def "Logging with db"() {
        given:
        def dbLogger = DbLogger.newInstance(dao)
        when:
        dbLogger.log(Level.WARNING, "logging using console-logger")
        then:
        1 * dao.save(_ as Level, _ as String)
        noExceptionThrown()
    }

}
