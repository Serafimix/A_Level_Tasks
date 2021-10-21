package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.rakhmail.hw24.util.HibernateUtil;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FactoryDao {
    public Factory findById(int id) {
        Factory factory;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            factory = session.createQuery("SELECT f FROM Factory f WHERE f.id = :id",
                            Factory.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return factory;
    }

    public void save(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(factory);
        tx1.commit();
        session.close();
    }

    public void update(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(factory);
        tx1.commit();
        session.close();
    }

    public void deleteByID(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE FROM Factory f WHERE f.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }

    public void getInfoCountForAllTechniquesFromAllFactories() {
//        SELECT technique.factory_id , COUNT(*) AS Allcount, SUM(price)
//        AS AllPrice FROM technique GROUP BY technique.factory_id ORDER BY technique.factory_id
        List<Factory> factories = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            factories = session.createQuery("SELECT technique.factory_id , COUNT(*) AS Allcount, SUM(price) " +
                    "AS AllPrice FROM technique GROUP BY technique.factory_id ORDER BY technique.factory_id", Factory.class).list();
            factories.forEach(System.out::println);
        }
    }

    public List<Factory> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT f FROM Factory f", Factory.class
            ).list();
        }
    }
}
