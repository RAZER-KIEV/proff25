package session10;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**
 * Created by ivan on 15.06.15.
 */
public class HiberConnectRegion {

    private static Logger log = Logger.getLogger(HiberConnect.class); // Логгируем нашу работу

    private SessionFactory factory;
    private Session session;

    public void init(){
        Configuration cfg = new Configuration()
                .addAnnotatedClass(Region.class)
                .configure("session10/hibernate.cfg.xml");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
    }

    public void addRegion(Region region){
//         Session session = null;
//        try {
//            session = factory.openSession
//        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH); //Настрйока локализации (приложения)
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(Region.class); // Добавляем в конфигурацию аннотованный класс
        cfg.configure("session10/hibernate.cfg.xml");// Создаем класс конфигураций на основе файла hibernate.cfg.xml
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        SessionFactory factory = cfg.buildSessionFactory(standardServiceRegistry);
        log.info("Reference to SessionFactory " + factory);
        Region antarktida = new Region();
        antarktida.setName("Antarktida");
//        antarktida.setId(5L);
        Region antarktika = new Region();
        antarktika.setName("antarktika");
            Session session = null;
            try {
                session = factory.openSession();
                session.beginTransaction();
                session.saveOrUpdate("antarktida",antarktika);
                session.getTransaction().commit();
            } catch (HibernateException e) {
                log.error("Open session failed", e);
                session.close();
                factory.close();
            } finally {
                if (session != null) {
                    session.close();
                }
            }
            log.info(session);
            factory.close();
        }



}
