package session12.dao;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session12.domain.Company;
import session12.domain.Person;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

/**
 * Created by just1ce on 23.06.2015.
 */
public class CompanyDaoImpl implements CompanyDao {
    private static Logger log = Logger.getLogger(CompanyDaoImpl.class);
    private SessionFactory factory;

    public CompanyDaoImpl(){
    }

    public CompanyDaoImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
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
    public List<Person> findEmpFromCompany(String company) {
        Session session = factory.openSession();

        Query query = session.createQuery("from Company c join c.persons p where c.name=:name");
        query.setParameter("name",company);
        List results = query.list();
        List<Person> persons = new ArrayList<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Object object[] = (Object[]) iter.next();
            persons.add((Person)object[1]);
        }
        if (session!=null){
            session.close();
        }
        return persons;
    }

    @Override
    public List getAll() {
        Session session = factory.openSession();

        Query query = session.createQuery("from Company c join c.persons p");
        List results = query.list();
        List<Person> persons = new ArrayList<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Object object[] = (Object[]) iter.next();
            persons.add((Person)object[1]);
        }
        if (session!=null){
            session.close();
        }
        return persons;
    }

    @Override
    public List getCompaniesByCountEmpl(int count) {
        Session session = factory.openSession();

        Query query = session.createQuery("select c.name  from Company c, Person p  group by c.name having count(c.name)> 2");
        List results = query.list();

        return results;
    }
}
