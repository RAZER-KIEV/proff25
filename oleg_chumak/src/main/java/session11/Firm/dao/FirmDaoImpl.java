package session11.Firm.dao;

import hw6.notes.domain.Notebook;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import session11.Firm.Company;
import session11.Firm.Person;
import sun.rmi.transport.ObjectTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 23.06.15.
 */
@Component
@Scope("prototype")
public class FirmDaoImpl implements FirmDao {

    @Autowired
    private SessionFactory factory;

    public SessionFactory getFactory() {
        return factory;
    }

    public FirmDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public FirmDaoImpl() {
    }

    @Override
    public Long create(Company cmpn) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long cr = (Long)session.save(cmpn);
            session.getTransaction().commit();
            return cr;
        } catch (HibernateException exc) {
            System.out.println(exc);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Company read(Long ig) {
        Session session = factory.openSession();
        Company comp = (Company) session.get(Company.class, ig);
        return comp;
    }

    @Override
    public boolean update(Company ntb) {
        return false;
    }

    @Override
    public boolean delete(Company ntb) {
        return false;
    }

    @Override
    public List<Company> findAll() {
        Session session = factory.openSession();
        Query query = session.createQuery("from Company ");
        return query.list();

    }

    @Override
    public List<Person> findPersons(Company cmpn) {
        Session session = factory.openSession();
        Query query = session.createQuery("from Company c join c.person e  where c.name = '"+cmpn.getName()+"'");
        List list = query.list();
        List<Person> summary = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            Person per = (Person)obj[1];
            summary.add(per);
//            System.out.println(per);
        }
        return summary;
    }

//    @Override
//    public List<Person> findAllPersons() {
//        List<Person> persons = new ArrayList<>();
//        List<Company> companies = findAll();
//        for(Company comp :companies){
//            List<Person> compPersons = findPersons(comp);
//            for(Person person : compPersons){
//                persons.add(person);
//            }
//        }
//        return persons;
//    }



    @Override
    public List<Person> findAllPersons() {Session session = factory.openSession();
        Query query = session.createQuery("from Company c join c.person e");
        List list = query.list();
        List<Person> summary = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            Person per = (Person)obj[1];
            summary.add(per);
//            System.out.println(per);
        }
        return summary;
    }

    @Override
    public void findCompaniesWithMoreThenTwoPersons() {
        Session session = factory.openSession();
//        Query query = session.createQuery("select c.name, count(c.name) from Company c join c.person p group by c.name having count(c.person) >:number");
        Query query = session.createQuery("select c.name, count (c.name) from Company c join c.person p group by c.name having count(c.name) >:number");
        query.setParameter("number", new Long(1));
        List list = query.list();
        for(int i = 0; i < list.size(); i++) {
            Object[] obj = (Object[]) list.get(i);
            System.out.println((String)obj[0]);
        }
    }
}
