package ua.rakhmail.hw25.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ua.rakhmail.hw24.models.Factory;
import ua.rakhmail.hw24.models.Technique;
import ua.rakhmail.hw25.entity.Owner;
import ua.rakhmail.hw25.entity.Vehicle;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private HibernateUtil() {

    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();

                /* предпочитаю не захламлять файл конфигурации гибернейта добавлением всех классов,
                не касающехся данного ДЗ
                 */
                configuration.addAnnotatedClass(Owner.class);
                configuration.addAnnotatedClass(Vehicle.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
