package week6_lesson11.dao;

import session7_8.Employees;
import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;

import java.util.List;
import java.util.Set;

/**
 TASK.1
 РЕализовать следующие функции
 -Получить всех сотрудников указанной Company
 -Получить сотрудников из всех компаний
 */
public interface EmployeeDao {
 List<Employees> getEmplFromCompany(Company comp);

 Long create(Employee employee);

 Employee read(Long id);

 boolean update(Employee employee);

 boolean delete(Employee employee);
}
