package com.refactor.demo.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by tomReq on 3/16/19.
 */
public class Database {

    private static Database instance;
    private Connection connection;

    private Database(){}

    private Database(Map dbParams) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));
        connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName") + ":" + dbParams.get("portNumber") + "/", connectionProps);
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance(Map dbParams) throws SQLException {
        if (instance == null) {
            instance = new Database(dbParams);
        } else if (instance.getConnection().isClosed()) {
            instance = new Database(dbParams);
        }

        return instance;
    }
}
