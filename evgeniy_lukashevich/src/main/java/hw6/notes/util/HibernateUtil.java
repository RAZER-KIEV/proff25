package hw6.notes.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by Jeckgehor on 20.06.2015.
 */
public class HibernateUtil {
    private static SessionFactory factory;

    public static SessionFactory connect() {
        Locale.setDefault(Locale.ENGLISH); // установление английской локали
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml"); // инкапсулирование конфигурации по xml-файлу
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder(); // создание построителя конфигугации Hibernate
        ssrb.applySettings(cfg.getProperties()); // передача настроек в построитель
        StandardServiceRegistry ssr = ssrb.build(); // регистрация настроек
        factory = cfg.buildSessionFactory(ssr); // создание фабрики сессий
        return factory;
    }

    public static void closeFactory () {
        factory.close();
    }
}
