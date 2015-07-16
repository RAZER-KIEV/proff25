package session12.company.dao;

import session12.company.domain.Company;
import session12.company.domain.Person;

import java.util.List;

/**
 * Created by bosyi on 23.06.15.
 */
public interface PersonDao {
    Long create(Person person);
    Person read(Long id);
    void update(Person person);
    void delete(Person person);
    List listByCompany(String name);
    List listAll();
    List listCompaniesHireMoreThanXEmployees(int i);
}
