package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.rakhmail.hw24.models.FactoryH;
import ua.rakhmail.hw24.utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class FactoryHDao {
    public void save(FactoryH factoryH) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(factoryH);
            transaction.commit();
        }
    }

    public FactoryH getById(String id) {
        FactoryH factoryH;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            factoryH = session.createQuery("SELECT h FROM FactoryH h WHERE h.id = :id",
                            FactoryH.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return factoryH;
    }

    public List<FactoryH> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT h FROM FactoryH h", FactoryH.class
            ).list();
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE FROM FactoryH h WHERE h.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }
}
