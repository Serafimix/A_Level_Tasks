package ua.rakhmail.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;
import ua.rakhmail.hw24.util.HibernateUtil;

import java.util.List;

public class TechniqueDao {
    public Technique findById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Technique.class, id);
    }

    public void save(Technique technique) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(technique);
        tx1.commit();
        session.close();
    }

    public void update(Technique technique) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(technique);
        tx1.commit();
        session.close();
    }

    public void delete(Technique technique) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(technique);
        tx1.commit();
        session.close();
    }

    public Factory findFactoryById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Factory.class, id);
    }

    public List<Technique> findAll() {
        List<Technique> techniques = (List<Technique>)  HibernateUtil.getSessionFactory().openSession().createQuery("From technique").list();
        return techniques;
    }
}
