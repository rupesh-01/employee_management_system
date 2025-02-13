package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/employeesdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection = null;

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Successfully established the connection...");
            } catch (SQLException ex){
                System.out.println(ex);
            }
        }
        return connection;
    }
}
