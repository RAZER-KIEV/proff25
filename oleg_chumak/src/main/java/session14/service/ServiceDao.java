package session14.service;

import session14.domain.Company;
import session14.domain.Person;

import java.util.List;

/**
 * Created by oleg on 30.06.15.
 */
public interface ServiceDao {
    public List<Person> readByCompany(Company cmpn);
    public Long create (Company company);
}
