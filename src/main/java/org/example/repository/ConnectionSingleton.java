package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {

    private static String user = "root";
    private static String password = "root";
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

}
