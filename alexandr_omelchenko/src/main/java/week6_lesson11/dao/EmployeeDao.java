package week6_lesson11.dao;


import week6_lesson11.domain.Company;
import week6_lesson11.domain.Employee;

import java.util.List;


/**
 TASK.1
 РЕализовать следующие функции
 -Получить всех сотрудников указанной Company
 -Получить сотрудников из всех компаний
 */
public interface EmployeeDao {
 List<Employee> getEmplFromCompany(Company comp);

 Long create(Employee employee);

 Employee read(Long id);

 boolean update(Employee employee);

 boolean delete(Employee employee);
}
