package session11.Firm.service;

import session11.Firm.Company;
import session11.Firm.Person;

import java.util.List;

/**
 * Created by oleg on 23.06.15.
 */
public interface Service {
    public List<Person> findAll();
    public List<Person> findByCompany(Company cmpn);
    void  findCompaniesWithMoreThenTwoPersons();
}
