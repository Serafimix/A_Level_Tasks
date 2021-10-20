package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.rakhmail.hw24.models.TechniqueH;
import ua.rakhmail.hw24.utils.HibernateUtil;

import java.util.List;

public class TechniqueHDao {
    public void save(TechniqueH techniqueH) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(techniqueH);
            transaction.commit();
        }
    }

    public TechniqueH getById(String id) {
        TechniqueH techniqueH;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            techniqueH = session.createQuery("SELECT h FROM TechniqueH h WHERE h.id = :id",
                            TechniqueH.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        }
        return techniqueH;
    }

    public List<TechniqueH> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT h FROM TechniqueH h", TechniqueH.class
            ).list();
        }
    }

    public void deleteById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE FROM TechniqueH h WHERE h.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        }
    }
}
