package session14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import session14.dao.CompanyDaoImpl;
import session14.domain.Company;
import session14.domain.Person;

import java.util.List;

/**
 * Created by oleg on 30.06.15.
 */

@Component
@Transactional
public class ServiceDaoImpl implements ServiceDao {
    @Autowired
    private CompanyDaoImpl dao;
    @Override
    public List<Person> readByCompany(Company cmpn) {
        return dao.findPersons(cmpn);
    }

    @Override
    public Long create(Company company) {
        return dao.create(company);
    }

    public ServiceDaoImpl() {
    }
}
