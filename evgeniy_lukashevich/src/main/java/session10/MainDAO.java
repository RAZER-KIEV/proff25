package session10;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * написать DAO Для регионов, CRUD
 * пользователь вводит имя региона, создаем, сохраняем, потом новое, изменяем
 */
public class MainDAO {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        Configuration cfg = new Configuration().configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);

        RegionHibernateDaoImpl regionHibernateDao = new RegionHibernateDaoImpl(factory);

        regionHibernateDao.read(2L).print();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of region:");
        Region region = new Region(scanner.nextLine());
        System.out.println(regionHibernateDao.create(region));

        System.out.println("Enter new name of region:");
        region.setName(scanner.nextLine());
        regionHibernateDao.update(region);

        factory.close();
    }
}
