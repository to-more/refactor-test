package com.refactor.demo.daos;

import com.refactor.demo.configuration.Database;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;

/**
 * Created by tomReq on 3/16/19.
 */
public class LoggerDao {

    private Map dbParams;

    public LoggerDao(Map dbParams) {
        this.dbParams = dbParams;
    }

    public void save(Level level, String message) throws Exception {
        Connection connection = Database.getInstance(dbParams).getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("insert into Log_Values('" + message + "', " + level.getName() + ")");
    }
}
