package session11.Firm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import session11.Firm.Company;
import session11.Firm.Person;
import session11.Firm.dao.FirmDaoImpl;

import java.util.List;

/**
 * Created by oleg on 23.06.15.
 */
@Component
@Transactional
public class ServiceImpl implements  Service {
    @Autowired
    public FirmDaoImpl dao;

    public FirmDaoImpl getDao() {
        return dao;
    }

    public ServiceImpl(FirmDaoImpl dao) {
        this.dao = dao;
    }

    public ServiceImpl() {
    }

    public Long create(Company cmpn){ return dao.create(cmpn);}

    @Override
    public List<Company> findAll() {
        return dao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> findByCompany(Company cmpn) {
        return dao.findPersons(cmpn);
    }

    @Override
    public void findCompaniesWithMoreThenTwoPersons() {
        dao.findCompaniesWithMoreThenTwoPersons();
    }
}
