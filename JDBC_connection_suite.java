package com.RaceGardens.Home;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_connection_suite {
    private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
    private String user = "hr";
    private String password = "123";
    Connection connection;
    private Driver driver;

    public Connection jdbc() throws SQLException {
        driver = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(driver);
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
