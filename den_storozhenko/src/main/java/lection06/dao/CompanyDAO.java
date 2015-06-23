package lection06.dao;

import lection06.domain.Company;

import java.util.List;

public interface CompanyDAO {
    Long create(Company company);
    Company read(Long id);
    boolean update(Company company);
    boolean delete(Company company);
    List getEmploiesFromCompany(String name);
    List getEmploiesFromAllCompanies();
    List getCompaniesPorced(int start, int size);
    List findAll();
    List getCompaniesMoreThanPersons(Long count);
}
