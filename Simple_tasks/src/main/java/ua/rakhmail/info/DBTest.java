package ua.rakhmail.info;

import java.sql.*;

public class DBTest {
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


    public static void testPrepStat(Connection connection){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person (name, " +
                    "email, birthday, photo) VALUES (?, ?, ?, ?)");
//            preparedStatement.setString(1, clas.getName());
//            preparedStatement.setString(2, clas.getEmail());
//            preparedStatement.setTimestamp(3, new Timestamp(clas.getBirthdate().getTime()));
//            preparedStatement.setBinaryStream(4, clas.getPhoto());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testStatem(Connection connection) throws SQLException {
        Statement statement = null;
        connection.setAutoCommit(false);
        statement = connection.createStatement();
        String sql = "SELECT * FROM tableName";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("col1");
            String name = resultSet.getString("col2Name");
            String speciality = resultSet.getString("col3spe");
            int salary = resultSet.getInt("col4Sal");
            System.out.println(id + name + speciality + salary);
        }
        Savepoint savepointOne = connection.setSavepoint("NameOfSave1");

        try {
            sql = "INSERT INTO tableName VALUES (6, Jhone, JAva, 2200)";
            statement.executeUpdate(sql);
            sql = "INSERT INTO tableName VALUES (7, Vika, C++, 1500)";
            statement.executeUpdate(sql);
            connection.commit();
        } catch (SQLException s) {
            System.out.println("fail");
            connection.rollback(savepointOne);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }


    public static void testPackageIn (Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        String sql = "INSERT INTO tableName VALUES (1, 'First_name', 'second_name', 3000)";
        statement.addBatch(sql);
        sql = "INSERT INTO tableName VALUES (2, 'First_name1', 'second_name1', 2000)";
        statement.addBatch(sql);
        sql = "INSERT INTO tableName VALUES (3, 'First_name2', 'second_name2', 1500)";
        statement.addBatch(sql);

        try {
            statement.executeBatch();
            connection.commit();
        } finally {
            statement.close();
            connection.close();
        }
    }
}
