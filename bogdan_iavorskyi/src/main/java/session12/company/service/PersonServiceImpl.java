package session12.company.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import session12.company.dao.PersonDao;
import session12.company.dao.PersonDaoImpl;
import session12.company.domain.Company;
import session12.company.domain.Person;
import session12.company.util.HibernateUtil;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
@Service("service")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao dao;

    public PersonServiceImpl() {
    }

    public PersonServiceImpl(PersonDao personDao) {
        dao = personDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List listByCompany(String name) {
        return dao.listByCompany(name);
    }

    @Transactional(readOnly = true)
    @Override
    public List listAll() {
        return dao.listAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List listCompaniesHireMoreThanXEmployees(int i) {
        return dao.listCompaniesHireMoreThanXEmployees(i);
    }
}
