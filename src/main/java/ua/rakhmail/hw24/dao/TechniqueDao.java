package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;
import ua.rakhmail.hw24.util.HibernateUtil;

import java.util.LinkedList;
import java.util.List;

public class TechniqueDao {
    public Technique findById(int id) {
        Technique technique;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            technique = session.createQuery("SELECT t FROM Technique t WHERE t.id = :id",
                            Technique.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return technique;
    }

    public void save(Technique technique) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.save(technique);
            tx1.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Technique technique) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            session.update(technique);
            tx1.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(
                            "DELETE FROM Technique t WHERE t.id = :id")
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

    public Factory findFactoryById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Factory.class, id);
    }

    public List<Technique> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT t FROM Technique t", Technique.class
            ).list();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void findTechniquesByFactoryID(int id) {
        List<Technique> techniques = new LinkedList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            techniques = session.createQuery("SELECT t FROM Technique t WHERE t.factory = " + id, Technique.class).list();
            techniques.forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
