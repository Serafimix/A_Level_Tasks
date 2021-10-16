package ua.rakhmail.hw23.creatorService;

import ua.rakhmail.hw23.DBInfo;
import ua.rakhmail.hw23.objects.Factory;
import ua.rakhmail.hw23.objects.Technique;
import ua.rakhmail.hw23.objects.TechniqueType;

import java.sql.*;

public class TableService {
    public static void deleteObjectFromTable(int id) {
        Connection connection = null;
        Statement statement = null;
        try {
            String sql = "DELETE FROM technique WHERE id=" + id + ";";
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("Delete technique #" + id + " is done");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getSumOfFactoryObject() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlCountAndSum = "SELECT fk_factory , COUNT(*) AS Allcount, SUM(price)" +
                    " AS AllPrice FROM technique GROUP BY fk_factory ORDER BY fk_factory";
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlCountAndSum);
            int columns = resultSet.getMetaData().getColumnCount();
            System.out.println("All technique prices and count of product from factory");
            System.out.println("#Factory = count   =   prices");
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resultSet.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
            System.out.println("************************************************************************************");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getListOfCreateFactory(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT technique.*, factory.* FROM technique" +
                    " INNER JOIN factory ON factory.id = fk_factory WHERE factory.id = " + id + "ORDER BY technique.id;";
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            int columns = resultSet.getMetaData().getColumnCount();
            System.out.println("List of technique from factory №" + id);
            System.out.println("factory = TechType = model = price = creatDate" +
                    " = description = isHave(t/f) = #factory = factoryName = Country");
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.println("************************************************************************************");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeTechniqueForHaving(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            String sqlIsHave = "SELECT * FROM technique WHERE ID = " + id;
            String sqlIsNOTHave = "UPDATE technique SET isHave = false WHERE ID = " + id;
            String sqlIsYasHave = "UPDATE technique SET isHave = true WHERE ID = " + id;
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlIsHave);
            resultSet.next();
            boolean isHave = resultSet.getBoolean("isHave");
            if (isHave) {
                statement.executeUpdate(sqlIsNOTHave);
                System.out.println("Technique is haven in the storage now");
            } else {
                statement.executeUpdate(sqlIsYasHave);
                System.out.println("Technique is not have in the storage now");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getInfoObjectFromTable(int id) {
        String sqlGetTech = "SELECT * FROM technique WHERE id = " + id;
        String sqlGetFact = "SELECT * FROM factory WHERE ID IN (SELECT fk_factory FROM technique WHERE id = " + id + ")";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBInfo.getConn();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlGetTech);
            while (resultSet.next()) {
                int idTe = resultSet.getInt("id");
                String techType = resultSet.getString("type");
                String model = resultSet.getString("model");
                int price = resultSet.getInt("price");
                Date date = resultSet.getDate("date");
                String desc = resultSet.getString("description");
                boolean isHave = resultSet.getBoolean("isHave");
                int nFactory = resultSet.getInt("fk_factory");
                TechniqueType techniqueType = null;
                switch (techType) {
                    case ("television") -> techniqueType = TechniqueType.TELEVISION;
                    case ("telephone") -> techniqueType = TechniqueType.TELEPHONE;
                    default -> techniqueType = TechniqueType.UNKNOWN_MODEL;
                }
                Technique technique = new Technique(idTe, techniqueType, model, price, date, desc, isHave, nFactory);
                System.out.println(technique);
            }
            resultSet = statement.executeQuery(sqlGetFact);
            while (resultSet.next()) {
                int ide = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");
                Factory factory = new Factory(ide, name, country);
                System.out.println(factory);
                System.out.println("*****************************************");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getListOfAllTechniquesAndFactory() {

    }
}
