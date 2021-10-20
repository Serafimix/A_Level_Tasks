package ua.rakhmail.info.test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends AbstractDAO<Object, Integer> {
    public static final String SELECT_ALL_OBJECTS = "SELECT * FROM NameTable";



    @Override
    public List<Object> getAll() {
        List<Object> list = new LinkedList<>();
        PreparedStatement preparedStatement = getPrepareSt(SELECT_ALL_OBJECTS);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Object object = new Object();
//                object.setId(resultSet.getInt(1));
//                object.setName(resultSet.getString(2));
                list.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareSt(preparedStatement);
        }
        return list;
    }

    @Override
    public Object update(Object entry) {
        return null;
    }

    @Override
    public Object getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Object entry) {
        return false;
    }
}
