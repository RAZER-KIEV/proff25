package session11.Firm;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import session10.HiberConnect;
import session11.Firm.dao.FirmDaoImpl;
import session11.Firm.service.ServiceImpl;
import session11.Firm.util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * Created by oleg on 22.06.15.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("session13/context_db.xml");
//        ServiceImpl service = context.getBean("serviceImpl", ServiceImpl.class);
//        System.out.println(service.create(new Company("aaza", 234L)));
//        System.out.println(service.findAll());
    }
}
