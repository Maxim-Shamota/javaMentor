package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static final String HOST = "jdbc:mysql://localhost:3306/users?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private Connection connection;

    public Util() {
        try {
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
