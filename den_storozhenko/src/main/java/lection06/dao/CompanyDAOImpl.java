package lection06.dao;

import lection06.domain.Company;
import lection06.domain.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Component
public class CompanyDAOImpl implements CompanyDAO {
    @Autowired
    private SessionFactory factory;

    public CompanyDAOImpl(){

    }

    public CompanyDAOImpl(SessionFactory factory){
        this.factory = factory;
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Company company) {
        return null;
    }

    @Override
    public Company read(Long id) {
        return null;
    }

    @Override
    public boolean update(Company company) {
        return false;
    }

    @Override
    public boolean delete(Company company) {
        return false;
    }

    @Override
    public List<Person> getEmploiesFromCompany(String name) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("select new Person(p.id, p.name, c) from Company c join c.persons p where c.name=:name");
        query.setParameter("name",name);
        System.out.println(name);
        List<Person> results = query.list();
        return results;
    }

    @Override
    public List<Person> getEmploiesFromAllCompanies() {
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
    public List getCompaniesPorced(int start, int size) {
        return null;
    }

    @Override
    public List<Company> findAll() {
        Session session = factory.openSession();

        Query query = session.createQuery("from Company");
        List list = query.list();
        if (session!=null){
            session.close();
        }
        return list;
    }

    @Override
    public List<String> getCompaniesMoreThanPersons(Long count) {
        Session session = factory.openSession();
        Query query = session.createQuery("select c.name, count(p) from Company c join c.persons p group by c.name having count(p) >:col");
        query.setParameter("col",count);
        List results = query.list();
        List<String> companies = new ArrayList<>();
        for (Iterator iter = results.iterator(); iter.hasNext();) {
            Object object[] = (Object[]) iter.next();
            companies.add((String) object[0]);
        }
        if (session!=null){
            session.close();
        }
        return companies;
    }
}
