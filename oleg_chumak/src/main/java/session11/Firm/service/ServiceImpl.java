package session11.Firm.service;

import session11.Firm.Company;
import session11.Firm.Person;
import session11.Firm.dao.FirmDaoImpl;

import java.util.List;

/**
 * Created by oleg on 23.06.15.
 */
public class ServiceImpl implements  Service {

    public FirmDaoImpl dao;

    public FirmDaoImpl getDao() {
        return dao;
    }

    public ServiceImpl(FirmDaoImpl dao) {
        this.dao = dao;
    }

    public ServiceImpl() {
    }

    @Override
    public List<Person> findAll() {
        return dao.findAllPersons();
    }

    @Override
    public List<Person> findByCompany(Company cmpn) {
        return dao.findPersons(cmpn);
    }

    @Override
    public void findCompaniesWithMoreThenTwoPersons() {
        dao.findCompaniesWithMoreThenTwoPersons();
    }
}
