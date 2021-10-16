package ua.rakhmail.hw23.creatorService;

import ua.rakhmail.hw23.DBInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreatorTable {

    public static void createTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            String sql = "CREATE TABLE factory " +
                    "(id serial PRIMARY KEY," +
                    "name varchar(50) NOT NULL," +
                    "country varchar(50) NOT NULL);" +

                    "CREATE TABLE technique " +
                    "(id serial PRIMARY KEY," +
                    "type varchar(50) NOT NULL," +
                    "model varchar(50) NOT NULL," +
                    "price int," +
                    "date DATE NOT NULL," +
                    "description text," +
                    "isHave boolean," +
                    "fk_factory int REFERENCES factory(id));";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
