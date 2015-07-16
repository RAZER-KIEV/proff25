package session12.company.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import session12.company.domain.Company;
import session12.company.domain.Person;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

    @Autowired
    private SessionFactory factory;

    public PersonDaoImpl() {
    }

    public PersonDaoImpl(SessionFactory sessionFactory) {
        factory = sessionFactory;
    }

    @Override
    public Long create(Person person) {
        return (Long) factory.getCurrentSession().save(person);
    }

    @Override
    public Person read(Long id) {
        return (Person) factory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void update(Person person) {
        factory.getCurrentSession().update(person);
    }

    @Override
    public void delete(Person person) {
        factory.getCurrentSession().delete(person);
    }

    @Override
    public List listByCompany(String name) {
        return factory.getCurrentSession().createQuery("from Company c join c.persons p where c.name=:name").list();
    }

    @Override
    public List<Person> listAll() {
        return factory.getCurrentSession().createQuery("select new Person(p.id, p.name) from Company c join c.persons p").list();
    }

    @Override
    public List listCompaniesHireMoreThanXEmployees(int i) {
        return factory.getCurrentSession().createQuery("select c.name, count (c.name) from Company c join c.persons p group by c.name having count(c.name) >:number").list();
    }
}
