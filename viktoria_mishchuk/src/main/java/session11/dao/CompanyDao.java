package session11.dao;

import session11.domain.Company;
import session11.domain.Employee;

import java.util.List;

/**
 * Created by viktoria
 * Project:.session11.dao
 */
public interface CompanyDao {

    Long create(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List<Employee> findEmpl( Company company);
    List<Employee> findAll();

}
