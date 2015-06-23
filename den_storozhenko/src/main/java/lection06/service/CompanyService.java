package lection06.service;

import java.util.List;

public interface CompanyService {
    List getEmploiesFromCompany(String name);
    List getEmploiesFromAllCompanies();
    List getCompaniesMoreThanPersons(Long count);
}
