package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.rakhmail.hw23.DBInfo;
import ua.rakhmail.hw24.util.HibernateUtil;
import ua.rakhmail.hw24.models.Factory;

import java.sql.*;
import java.util.List;

public class FactoryDao {
    public Factory findById(int id) {
        Factory factory;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            factory = session.createQuery("SELECT f FROM Factory f WHERE f.id = :id",
                            Factory.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
            return factory;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void save(Factory factory) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(factory);
            tx1.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Factory factory) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(factory);
            tx1.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteByID(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE FROM Factory f WHERE f.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void getInfoCountForAllTechniquesFromAllFactories() {
        String sql = "SELECT factory_id , COUNT(*) AS AllCount, SUM(price) " +
                "AS AllPrice FROM Technique t GROUP BY t.factory_id ORDER BY t.factory_id";
        try (Connection connection = DBInfo.getConn();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            int columns = statement.getMetaData().getColumnCount();
            System.out.println("#Factory = count   =   prices");
            while (resultSet.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(resultSet.getString(i) + "\t\t\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Factory> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT f FROM Factory f", Factory.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
