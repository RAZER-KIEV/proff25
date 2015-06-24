package session11.Firm;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
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
        HibernateUtil hib = new HibernateUtil();
        hib.createSessionFactory();
        SessionFactory factory = hib.getFactory();
        ServiceImpl service = new ServiceImpl(new FirmDaoImpl(factory));
//        System.out.println(service.findByCompany(new Company("c1", new Long(1574))));
        System.out.println("------------------------------------------");
        System.out.println();
//        List<Person> empls = service.findAll();
////        List<Person> empls = service.findByCompany(new Company("c1", new Long(1574)));
//        for(Person per : empls){
//            System.out.println(per);
//        }
        service.findCompaniesWithMoreThenTwoPersons();
    }
}
