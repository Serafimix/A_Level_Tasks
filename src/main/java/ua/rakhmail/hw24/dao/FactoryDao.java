package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.rakhmail.hw24.util.HibernateUtil;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;

import java.util.List;

public class FactoryDao {
    public Factory findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Factory.class, id);
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

    public void delete(Factory factory) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(factory);
        tx1.commit();
        session.close();
    }

    public Factory findFactoryById(int id) {
        Factory factory;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            factory = session.createQuery("SELECT f FROM factory f WHERE f.id = :id",
                            Factory.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }

        return factory;
    }

    public List<Factory> findAll() {
        List<Factory> factories = (List<Factory>)  HibernateUtil.getSessionFactory().openSession().createQuery("From factory").list();
        return factories;
    }
}
