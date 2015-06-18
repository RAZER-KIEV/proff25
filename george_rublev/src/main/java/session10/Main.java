package session10;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Locale;

/**
 * Created by george on 16.06.15.
 */
public class Main {
    public static void main(String[] args) {
        //настраиваем локальные значения по умолчанию
        Locale.setDefault(Locale.ENGLISH);
        //подключаем конфигурационный файл Hibernate
        org.hibernate.cfg.Configuration cfg = new org.hibernate.cfg.Configuration().configure("session10/hibernate.cfg.xml");
        //создаем Builder
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        //передаем Builder конфигурационный файл
        sb.applySettings(cfg.getProperties());
        //регестрируе буилдер
        StandardServiceRegistry standardServiceRegistry = sb.build();
        //создаем фабрику зарегестрированный буилдер
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
//        log.info("Reference to SessionFactory " + factory);
        Client client = new Client("Vasja","asjda","2015-10-09");
        //подключаемся к DAO и передаем ему нашу фабрику
        ClientHibernateDaoImpl clientHibernateDao = new ClientHibernateDaoImpl(factory);
        clientHibernateDao.create(client);
        Client client1;
        client1 = clientHibernateDao.read(1L);
        System.out.println("-----------------------");
        System.out.println(client1);
        factory.close();
//        System.exit(0);
//        Collection client = Factory.
    }
}
