package session14.dao;

import session14.domain.Company;
import session14.domain.Person;

import java.util.List;

/**
 * Created by oleg on 30.06.15.
 */
public interface CompanyDao {
    Long create(Company cmpn);
    Company read(Long ig);
    boolean update(Company ntb);
    boolean delete(Company ntb);
    List<Company> findAll();
    List<Person> findPersons(Company cmpn);
    List<Person> findAllPersons();
    void  findCompaniesWithMoreThenTwoPersons();
}
