package week6_lesson11.dao;

import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;

import java.util.List;

/**
 * Created by HP on 23.06.2015.
 */
public interface CompanyDao {
    List<Employee> getEmplFromAllComp();

    List getCompWhereMoreThanEmpl(Long count);

    Long create(Company company);
    Company read(Long ig);
    boolean update(Company company);
    boolean delete(Company company);
}
