package ua.rakhmail.hw23.creatorService;

import ua.rakhmail.hw23.DBInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddObjects {
    public static void addObjects() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            String sqlFactory = "INSERT INTO factory (name, country) VALUES ('Factorio', 'USA');" +
                    "INSERT INTO factory (name, country) VALUES ('Satisfactory', 'EU');" +
                    "INSERT INTO factory (name, country) VALUES ('Oxygen', 'China');" +
                    "INSERT INTO factory (name, country) VALUES ('Varma', 'UK');";
            String sqlTEchnique =
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('television', 'AOC', 1250, '2008-10-23', 'some text', true, 1);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('telephone', 'Iphone10', 900, '20018-05-23', 'some text', false, 4);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('television', 'LG', 1500, '2021-11-11', 'some text', true, 3);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('telephone', 'NokiaN73', 200, '2007-12-09', 'some text', false, 2);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('television', 'SAMSUNG', 950, '2016-01-21', 'some text', true, 1);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('telephone', 'SAMSUNG', 400, '2002-01-23', 'some text', false, 2);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('television', 'Berezka ch', 100, '1980-10-23', 'some text', true, 3);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('telephone', 'SiemensA50', 200, '2001-02-23', 'some text', false, 4);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('television', 'iWatch5', 700, '2017-08-23', 'some text', true, 1);" +
                            "INSERT INTO technique (type, model, price, date, description, isHave, fk_factory)" +
                            "VALUES ('telephone', 'xiaomi', 500, '2015-10-23', 'some text', false, 2);";
            statement.executeUpdate(sqlFactory);
            statement.executeUpdate(sqlTEchnique);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
