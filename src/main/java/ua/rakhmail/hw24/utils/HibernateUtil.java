package ua.rakhmail.hw24.utils;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import ua.rakhmail.hw24.models.FactoryH;
import ua.rakhmail.hw24.models.TechniqueH;

import javax.persistence.Entity;
import java.util.Set;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Reflections reflections = new Reflections();
                Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);
                for (Class<?> entity : entities) {
                    configuration.addAnnotatedClass(entity);
                }
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}