package session12.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import session12.company.domain.Company;
import session12.company.domain.Person;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
public class PersonDaoImpl implements PersonDao {
    private static Logger log = Logger.getLogger(PersonDaoImpl.class);

    private SessionFactory factory;

    public PersonDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Person person) {
        return null;
    }

    @Override
    public Person read(Long id) {
        return null;
    }

    @Override
    public boolean update(Person person) {
        return false;
    }

    @Override
    public boolean delete(Person person) {
        return false;
    }

    @Override
    public List listByCompany(String name) {
        List persons = null;
        Session session = factory.openSession();
        Query query = session.createQuery("from Company c join c.persons p where c.name=:name");
        query.setParameter("name", name);
        return query.list();
    }

    @Override
    public List<Person> listAll() {
        List persons = null;
        Session session = factory.openSession();
        Query query = session.createQuery("select new Person(p.id, p.name) from Company c join c.persons p");
        return query.list();
    }

    @Override
    public List listCompaniesHireMoreThanXEmployees(int i) {
        Session session = factory.openSession();
        Query query = session.createQuery("select c.name, count (c.name) from Company c join c.persons p group by c.name having count(c.name) >:number");
        Long number = new Long(i);
        query.setParameter("number", number);
        return query.list();
    }
}
