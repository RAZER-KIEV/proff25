package session12.company.service;

import org.hibernate.SessionFactory;
import session12.company.dao.PersonDao;
import session12.company.dao.PersonDaoImpl;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.util.HibernateUtil;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao dao;
    private SessionFactory factory;

    public PersonServiceImpl(SessionFactory factory) {
        this.factory = factory;
        dao = new PersonDaoImpl(factory);
    }

    @Override
    public List listByCompany(String name) {
        return dao.listByCompany(name);
    }

    @Override
    public List listAll() {
        return dao.listAll();
    }

    @Override
    public List listCompaniesHireMoreThanXEmployees(int i) {
        return dao.listCompaniesHireMoreThanXEmployees(i);
    }
}
