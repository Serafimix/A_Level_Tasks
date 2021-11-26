package ua.rakhmail.hw23;

import lombok.Getter;

import java.sql.*;

@Getter
public class DBInfo {
    private final static String LOGIN = "postgres";
    private final static String PASSWORD = "root";
    private final static String URL = "jdbc:postgresql://localhost:5432/myDataBase";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
//            System.out.println("Connection is done");
        } catch (Exception e) {
            System.out.println("Failed to create JDBC db connection " + e.getMessage());
        }
        return conn;
    }
}
