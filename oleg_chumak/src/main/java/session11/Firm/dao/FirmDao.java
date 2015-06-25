package session11.Firm.dao;

import session11.Firm.Company;
import session11.Firm.Person;

import java.util.List;

/**
 * Created by oleg on 23.06.15.
 */
 interface  FirmDao {
    Long create(Company cmpn);
    Company read(Long ig);
    boolean update(Company ntb);
    boolean delete(Company ntb);
    List<Company> findAll();
    List<Person> findPersons(Company cmpn);
    List<Person> findAllPersons();
   void  findCompaniesWithMoreThenTwoPersons();
}
